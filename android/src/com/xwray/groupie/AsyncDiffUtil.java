//start - license
/*
 * Copyright (c) 2025 Ashera Cordova
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 */
//end - license
package com.xwray.groupie;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListUpdateCallback;

import java.util.Collection;

/**
 * A wrapper around {@link DiffUtil} that calculates diff in a background thread
 */
class AsyncDiffUtil {
    interface Callback extends ListUpdateCallback {
       /**
         * Called on the main thread before DiffUtil dispatches the result
         */
        @MainThread
        void onDispatchAsyncResult(@NonNull Collection<? extends Group> newGroups);
    }

    private final Callback asyncDiffUtilCallback;
    private int maxScheduledGeneration;
    private Collection<? extends Group> groups;

    AsyncDiffUtil(@NonNull Callback callback) {
        this.asyncDiffUtilCallback = callback;
    }

    @NonNull
    Callback getAsyncDiffUtilCallback() {
        return asyncDiffUtilCallback;
    }

    @NonNull
    Collection<? extends Group> getGroups() {
        return groups;
    }

    int getMaxScheduledGeneration() {
        return maxScheduledGeneration;
    }

    void calculateDiff(@NonNull Collection<? extends Group> newGroups,
                       @NonNull DiffUtil.Callback diffUtilCallback,
                       @Nullable OnAsyncUpdateListener onAsyncUpdateListener,
                       boolean detectMoves) {
        groups = newGroups;
        // incrementing generation means any currently-running diffs are discarded when they finish
        final int runGeneration = ++maxScheduledGeneration;
        new DiffTask(this, diffUtilCallback, runGeneration, detectMoves, onAsyncUpdateListener).execute();
    }
}

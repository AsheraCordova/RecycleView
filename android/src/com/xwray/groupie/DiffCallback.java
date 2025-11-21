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

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;

import java.util.Collection;

class DiffCallback extends DiffUtil.Callback {
    private final int oldBodyItemCount;
    private final int newBodyItemCount;
    private final Collection<? extends Group> oldGroups;
    private final Collection<? extends Group> newGroups;

    DiffCallback(Collection<? extends Group> oldGroups, Collection<? extends Group> newGroups) {
        this.oldBodyItemCount = GroupUtils.getItemCount(oldGroups);
        this.newBodyItemCount = GroupUtils.getItemCount(newGroups);
        this.oldGroups = oldGroups;
        this.newGroups = newGroups;
    }

    @Override
    public int getOldListSize() {
        return oldBodyItemCount;
    }

    @Override
    public int getNewListSize() {
        return newBodyItemCount;
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        Item oldItem = GroupUtils.getItem(oldGroups, oldItemPosition);
        Item newItem = GroupUtils.getItem(newGroups, newItemPosition);
        return newItem.isSameAs(oldItem);
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        Item oldItem = GroupUtils.getItem(oldGroups, oldItemPosition);
        Item newItem = GroupUtils.getItem(newGroups, newItemPosition);
        return newItem.hasSameContentAs(oldItem);
    }

    @Nullable
    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        Item oldItem = GroupUtils.getItem(oldGroups, oldItemPosition);
        Item newItem = GroupUtils.getItem(newGroups, newItemPosition);
        return oldItem.getChangePayload(newItem);
    }
}
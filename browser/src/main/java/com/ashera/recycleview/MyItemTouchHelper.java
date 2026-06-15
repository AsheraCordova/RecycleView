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
package com.ashera.recycleview;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

public interface MyItemTouchHelper {
	interface MyCallback {
		void onSwiped(ViewHolder viewHolder, int direction);

		boolean onMove(RecyclerView recyclerView, ViewHolder viewHolder, ViewHolder target);

		void onMoved(RecyclerView recyclerView, int fromPos, int toPos);

		void onSelectedChanged(ViewHolder viewHolder, int actionState);
	}
}
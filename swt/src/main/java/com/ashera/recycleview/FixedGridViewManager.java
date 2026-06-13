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

import r.android.view.View;
import r.android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

public class FixedGridViewManager extends RecyclerView.LayoutManager {

	private final int rows;
	private final int cols;

	public FixedGridViewManager(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
	}

	@Override
	public RecyclerView.LayoutParams generateDefaultLayoutParams() {
		return new RecyclerView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
	}

	@Override
	public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {

		detachAndScrapAttachedViews(recycler);

		if (getItemCount() == 0 || rows == 0 || cols == 0) {
			return;
		}

		int parentWidth = getWidth();
		int parentHeight = getHeight();

		int cellWidth = parentWidth / cols;
		int cellHeight = parentHeight / rows;

		for (int i = 0; i < getItemCount(); i++) {

			View view = recycler.getViewForPosition(i);

			addView(view);

			int widthSpec = View.MeasureSpec.makeMeasureSpec(cellWidth, View.MeasureSpec.EXACTLY);

			int heightSpec = View.MeasureSpec.makeMeasureSpec(cellHeight, View.MeasureSpec.EXACTLY);

			view.measure(widthSpec, heightSpec);

			int row = i / cols;
			int col = i % cols;

			int left = col * cellWidth;
			int top = row * cellHeight;

			int right = (col == cols - 1) ? parentWidth : left + cellWidth;

			int bottom = (row == rows - 1) ? parentHeight : top + cellHeight;

			layoutDecorated(view, left, top, right, bottom);
		}
	}
}
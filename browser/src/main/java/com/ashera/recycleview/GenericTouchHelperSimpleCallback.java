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

import java.util.Map;

import r.android.view.View;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

public class GenericTouchHelperSimpleCallback extends ItemTouchHelper.SimpleCallback {
	private com.ashera.recycleview.MyItemTouchHelper.MyCallback swipeListener;
	private com.ashera.recycleview.MyItemTouchHelper.MyCallback onMoveListener;
	private com.ashera.recycleview.MyItemTouchHelper.MyCallback onMovedListener;
	private com.ashera.recycleview.MyItemTouchHelper.MyCallback onSelectedChangedListener;
	private boolean deleteOnSwipe;
	private String swipeSwapMode;

	private final RecyclerView.Adapter<?> adapter;
	private int fromPosition = -1;
	private int toPosition = -1;
	private RecyclerView.ViewHolder currentTarget;
	private String dragmode;
	private String dragStartMode;
	private String swapMode;
	private String selectHighlightAttributes;
	private String resetHighlightAttributes;

	public String getSelectHighlightAttributes() {
		return selectHighlightAttributes;
	}

	public void setSelectHighlightAttributes(String selectHighlightAttributes) {
		this.selectHighlightAttributes = selectHighlightAttributes;
	}

	public String getResetHighlightAttributes() {
		return resetHighlightAttributes;
	}
	public String getDragStartMode() {
		return dragStartMode;
	}

	public void setDragStartMode(String dragStartMode) {
		this.dragStartMode = dragStartMode;
	}

	public void setResetHighlightAttributes(String resetHighlightAttributes) {
		this.resetHighlightAttributes = resetHighlightAttributes;
	}

	public String getSwapMode() {
		return swapMode;
	}

	public void setSwapMode(String swapMode) {
		this.swapMode = swapMode;
	}
	
	public String getSwipeSwapMode() {
		return swipeSwapMode;
	}

	public void setSwipeSwapMode(String swipeSwapMode) {
		this.swipeSwapMode = swipeSwapMode;
	}

	public boolean isDeleteOnSwipe() {
		return deleteOnSwipe;
	}

	public void setDeleteOnSwipe(boolean deleteOnSwipe) {
		this.deleteOnSwipe = deleteOnSwipe;
	}

	public com.ashera.recycleview.MyItemTouchHelper.MyCallback getSwipeListener() {
		return swipeListener;
	}

	public void setSwipeListener(com.ashera.recycleview.MyItemTouchHelper.MyCallback swipeListener) {
		this.swipeListener = swipeListener;
	}

	public com.ashera.recycleview.MyItemTouchHelper.MyCallback getOnMoveListener() {
		return onMoveListener;
	}

	public void setOnMoveListener(com.ashera.recycleview.MyItemTouchHelper.MyCallback onMoveListener) {
		this.onMoveListener = onMoveListener;
	}

	public com.ashera.recycleview.MyItemTouchHelper.MyCallback getOnMovedListener() {
		return onMovedListener;
	}

	public void setOnMovedListener(com.ashera.recycleview.MyItemTouchHelper.MyCallback onMovedListener) {
		this.onMovedListener = onMovedListener;
	}

	public com.ashera.recycleview.MyItemTouchHelper.MyCallback getOnSelectedChangedListener() {
		return onSelectedChangedListener;
	}

	public void setOnSelectedChangedListener(
			com.ashera.recycleview.MyItemTouchHelper.MyCallback onSelectedChangedListener) {
		this.onSelectedChangedListener = onSelectedChangedListener;
	}

	public GenericTouchHelperSimpleCallback(RecyclerView.Adapter<?> adapter, int dragDirs, int swipeDirs) {
		super(dragDirs, swipeDirs);

		this.adapter = adapter;
	}
	
	@Override
	public androidx.recyclerview.widget.RecyclerView.ViewHolder chooseDropTarget(
			androidx.recyclerview.widget.RecyclerView.ViewHolder selected,
			java.util.List<androidx.recyclerview.widget.RecyclerView.ViewHolder> dropTargets, int curX, int curY) {
		ViewHolder target = super.chooseDropTarget(selected, dropTargets, curX, curY);
		
		if (currentTarget != null && currentTarget != target) {
			resetView(currentTarget);
		}
		
		if (target != null) {
			if (currentTarget != target) {
				selectView(target);
			}
		} else {
			toPosition = -1;
		}
		
		currentTarget = target;
		return target;
	}

	public void selectView(ViewHolder viewHolder) {
		View itemView = viewHolder.itemView;
		if (itemView instanceof com.ashera.widget.ILifeCycleDecorator) {
			if (selectHighlightAttributes != null) {
				applyStyle(itemView, selectHighlightAttributes);
			}
		}
	}

	private void applyStyle(View itemView, String cssExpression) {
		com.ashera.widget.IWidget widget = ((com.ashera.widget.ILifeCycleDecorator) itemView).getWidget();
		Map<String, Object> attributes = com.ashera.model.ModelExpressionParser.parseSimpleCssExpression(cssExpression);
		
		for (String key : attributes.keySet()) {
			Object value = attributes.get(key);
			
			if (key.contains("#")) {
				String[] keyAndId = key.split("#");
				String id = keyAndId[0];
				key = keyAndId[1];
				widget.findWidgetById("@+id/" + id).setAttribute(key, value, false);
			} else {
				widget.setAttribute(key, value, false);
			}
			
		}
	}
	
	

	private void resetView(ViewHolder viewHolder) {
		View itemView = viewHolder.itemView;
		if (itemView instanceof com.ashera.widget.ILifeCycleDecorator) {
			if (resetHighlightAttributes != null) {
				applyStyle(itemView, resetHighlightAttributes);
			}
		}
	}

	

	@Override
	public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {

		super.onSelectedChanged(viewHolder, actionState);
		if (actionState == ItemTouchHelper.ACTION_STATE_DRAG && viewHolder != null) {
			selectView(viewHolder);
		}
		
		if (onSelectedChangedListener != null) {
			onSelectedChangedListener.onSelectedChanged(viewHolder, actionState);
		}
	}

	@Override
	public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder,
			RecyclerView.ViewHolder target) {
		if (viewHolder.getItemViewType() != target.getItemViewType()) {
            return false;
        }
		fromPosition = viewHolder.getAdapterPosition();
		toPosition = target.getAdapterPosition();
		if (dragmode != null && dragmode.equals("swaponhighlight")) {
			onItemMove(fromPosition, toPosition);
			
			
			if (onMovedListener != null) {
				onMovedListener.onMoved(recyclerView, fromPosition, toPosition);
			}
		}
		
		if (onMoveListener != null) {
			onMoveListener.onMove(recyclerView, viewHolder, target);
		}
		return true;
	}
	
	@Override
	public void onSwiped(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, int direction) {
		if (deleteOnSwipe) {
            int position = viewHolder.getAdapterPosition();
            
            if (adapter instanceof ItemActionHandler) {
            	((ItemActionHandler) adapter).onItemRemove(position, swipeSwapMode);
            }
		}
		
		if (swipeListener != null) {
			swipeListener.onSwiped(viewHolder, direction);
		}
		
	}

	@Override
	public boolean isLongPressDragEnabled() {
		return dragStartMode != null && dragStartMode.equals("longpress");
	}
	
	public boolean isDownPressDragEnabled() {
		return dragStartMode != null && dragStartMode.equals("onclick");
	}


	@Override
	public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {

		super.clearView(recyclerView, viewHolder);

		resetView(viewHolder);

		if (currentTarget != null) {
			resetView(currentTarget);
		}

		if (fromPosition != -1 && toPosition != -1 && fromPosition != toPosition) {
			if (dragmode != null && dragmode.equals("swapwhendropped")) {
				onItemMove(fromPosition, toPosition);
				
				if (onMovedListener != null) {
					onMovedListener.onMoved(recyclerView, fromPosition, toPosition);
				}
			}
		}
		
		currentTarget = null;
		fromPosition = -1;
		toPosition = -1;
	}

	private void onItemMove(int fromPosition, int toPosition) {
		if (adapter instanceof ItemActionHandler) {
			((ItemActionHandler) adapter).onItemMove(fromPosition, toPosition, swapMode);
		}
	}
	
	public String getDragmode() {
		return dragmode;
	}

	public void setDragmode(String dragmode) {
		this.dragmode = dragmode;
	}
	
	@Override
	public int getMovementFlags(RecyclerView recyclerView, ViewHolder viewHolder) {
		if (adapter instanceof ItemActionHandler) {
			if (!((ItemActionHandler) adapter).isDragEnabled(viewHolder)) {
				return makeMovementFlags(0, 0);
			}
		}
		return super.getMovementFlags(recyclerView, viewHolder);
	}
	
	@Override 
	public int getSwipeDirs(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
		if (adapter instanceof ItemActionHandler) {
			int swipeDirs = ((ItemActionHandler) adapter).getSwipeDirs(viewHolder);
			if (swipeDirs != -1) {
				return swipeDirs;
			}
		}
		return super.getSwipeDirs(recyclerView, viewHolder);
    }

	@Override 
	public int getDragDirs(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
		if (adapter instanceof ItemActionHandler) {
			int dragDirs = ((ItemActionHandler) adapter).getDragDirs(viewHolder);
			if (dragDirs != -1) {
				return dragDirs;
			}
		}
        return super.getDragDirs(recyclerView, viewHolder);
    }

}
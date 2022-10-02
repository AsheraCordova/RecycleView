package com.ashera.recycleview;

import android.graphics.Rect;
import android.view.View;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/** 
 * An ItemDecoration which applies an even visual padding on the left and right edges of a grid and
 * between each item, while also applying an even amount of inset to each item.  This ensures that
 * all items remain the same size.
 *
 * It assumes all items in a row have the same span size, and it assumes it's the only item
 * decorator.
 */
public class InsetItemDecoration extends RecyclerView.ItemDecoration {

    public InsetItemDecoration() {
    }

    private Object getMargin(View view, RecyclerView parent) {
        RecyclerViewImpl.GroupieViewHolder viewHolder = ( RecyclerViewImpl.GroupieViewHolder) parent.getChildViewHolder(view);
        if (viewHolder == null || viewHolder.widgetViewHolder == null) {
            return null;
        }
        return viewHolder.widgetViewHolder.widget.getFromTempCache("insets");
    }

	@Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        Object insets = getMargin(view, parent);
        if (insets == null || (int) insets == 0) return;

        if (parent.getLayoutManager() instanceof GridLayoutManager) {
	        int padding = (int) insets;
	        GridLayoutManager.LayoutParams layoutParams = (GridLayoutManager.LayoutParams) view.getLayoutParams();
	        GridLayoutManager gridLayoutManager = (GridLayoutManager) parent.getLayoutManager();
	        float spanSize = layoutParams.getSpanSize();
	        float totalSpanSize = gridLayoutManager.getSpanCount();
	
	        float n = totalSpanSize / spanSize; // num columns
	        float c = layoutParams.getSpanIndex() / spanSize; // column index
	
	        float leftPadding = padding * ((n - c) / n);
	        float rightPadding = padding * ((c + 1) / n);
	
	        outRect.left = (int) leftPadding;
	        outRect.right = (int) rightPadding;
	        outRect.bottom = padding;
        }
    }
}

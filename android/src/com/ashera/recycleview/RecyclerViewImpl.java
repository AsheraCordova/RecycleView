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
// start - imports
import java.util.*;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.view.*;
import android.widget.*;
import android.view.View.*;

import com.ashera.widget.BaseHasWidgets;

import android.annotation.SuppressLint;

import com.ashera.core.IFragment;
import com.ashera.widget.bus.*;
import com.ashera.converter.*;
import com.ashera.widget.bus.Event.*;
import com.ashera.widget.*;
import com.ashera.widget.IWidgetLifeCycleListener.*;
import com.ashera.layout.*;

import android.graphics.Canvas;
import android.widget.*;
import androidx.core.view.*;
import android.view.*;

import static com.ashera.widget.IWidget.*;
//end - imports

import androidx.recyclerview.widget.*;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

public class RecyclerViewImpl extends BaseHasWidgets {
	//start - body
	public final static String LOCAL_NAME = "androidx.recyclerview.widget.RecyclerView"; 
	public final static String GROUP_NAME = "androidx.recyclerview.widget.RecyclerView";
	private androidx.recyclerview.widget.RecyclerView recyclerView;
	

	
		@SuppressLint("NewApi")
		final static class Orientation extends AbstractEnumToIntConverter{
		private Map<String, Integer> mapping = new HashMap<>();
				{
				mapping.put("horizontal",  0x0);
				mapping.put("vertical",  0x1);
				}
		@Override
		public Map<String, Integer> getMapping() {
				return mapping;
				}

		@Override
		public Integer getDefault() {
				return 0;
				}
				}
		@SuppressLint("NewApi")
		final static class DragDirs  extends AbstractBitFlagConverter{
		private Map<String, Integer> mapping = new HashMap<>();
				{
				mapping.put("none", 0x0);
				mapping.put("up", 0x1);
				mapping.put("down", 0x2);
				mapping.put("left", 0x4);
				mapping.put("right", 0x8);
				}
		@Override
		public Map<String, Integer> getMapping() {
				return mapping;
				}

		@Override
		public Integer getDefault() {
				return 0;
				}
				}
		@SuppressLint("NewApi")
		final static class SwipeDirs  extends AbstractBitFlagConverter{
		private Map<String, Integer> mapping = new HashMap<>();
				{
				mapping.put("none", 0x0);
				mapping.put("up", 0x1);
				mapping.put("down", 0x2);
				mapping.put("left", 0x4);
				mapping.put("right", 0x8);
				}
		@Override
		public Map<String, Integer> getMapping() {
				return mapping;
				}

		@Override
		public Integer getDefault() {
				return 0;
				}
				}
		@SuppressLint("NewApi")
		final static class DragDropMode extends AbstractEnumToIntConverter{
		private Map<String, Integer> mapping = new HashMap<>();
				{
				mapping.put("none",  0x0);
				mapping.put("swaponhighlight",  0x1);
				mapping.put("swapwhendropped",  0x2);
				}
		@Override
		public Map<String, Integer> getMapping() {
				return mapping;
				}

		@Override
		public Integer getDefault() {
				return 0;
				}
				}
		@SuppressLint("NewApi")
		final static class DragStartMode extends AbstractEnumToIntConverter{
		private Map<String, Integer> mapping = new HashMap<>();
				{
				mapping.put("none",  0x0);
				mapping.put("longpress",  0x1);
				mapping.put("onclick",  0x2);
				}
		@Override
		public Map<String, Integer> getMapping() {
				return mapping;
				}

		@Override
		public Integer getDefault() {
				return 0;
				}
				}
		@SuppressLint("NewApi")
		final static class DragSwapMode extends AbstractEnumToIntConverter{
		private Map<String, Integer> mapping = new HashMap<>();
				{
				mapping.put("none",  0x0);
				mapping.put("notifyDataSetChanged",  0x1);
				mapping.put("notifyItemMoved",  0x2);
				}
		@Override
		public Map<String, Integer> getMapping() {
				return mapping;
				}

		@Override
		public Integer getDefault() {
				return 0;
				}
				}
		@SuppressLint("NewApi")
		final static class SwipeSwapMode extends AbstractEnumToIntConverter{
		private Map<String, Integer> mapping = new HashMap<>();
				{
				mapping.put("none",  0x0);
				mapping.put("notifyDataSetChanged",  0x1);
				mapping.put("notifyItemRemoved",  0x2);
				}
		@Override
		public Map<String, Integer> getMapping() {
				return mapping;
				}

		@Override
		public Integer getDefault() {
				return 0;
				}
				}
	@Override
	public void loadAttributes(String localName) {
		ViewGroupImpl.register(localName);

		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("onFling").withType("String"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("onScrollStateChange").withType("String"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("onScrolled").withType("String"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layoutManager").withType("string"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("viewHolderIds").withType("array").withArrayType("string"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("spanCount").withType("int").withOrder(-1));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout").withType("string").withOrder(100));
		ConverterFactory.register("androidx.recyclerview.widget.RecyclerView.orientation", new Orientation());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("orientation").withType("androidx.recyclerview.widget.RecyclerView.orientation").withOrder(-1));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("nestedScrollingEnabled").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("addSectionItem").withType("object"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("removeSectionItem").withType("object"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("removeAllItems").withType("object"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("updateSectionItem").withType("object"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("stackFromEnd").withType("boolean").withOrder(101));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("reverseLayout").withType("boolean").withOrder(101));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("scrollToEnd").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("scrollToTop").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("scrollToPosition").withType("int"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("headerDisabled").withType("boolean").withOrder(-1));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("footerDisabled").withType("boolean").withOrder(-1));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("filter").withType("string"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("filterDelay").withType("int").withOrder(-10));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("filterId").withType("string").withOrder(-10));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("filterItemPath").withType("array").withOrder(-10));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("filterSectionPath").withType("array").withOrder(-10));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("filterQueryStorePath").withType("string").withOrder(-10));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("filterQueryGetPath").withType("string").withOrder(-10));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("fixedgrid_rowCount").withType("int").withOrder(-10));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("fixedgrid_columnCount").withType("int").withOrder(-10));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("fixedgrid_tileWidth").withType("int").withOrder(-10));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("fixedgrid_tileHeight").withType("int").withOrder(-10));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("disableItemAnimator").withType("nil"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("hasFixedSize").withType("boolean"));
		ConverterFactory.register("androidx.recyclerview.widget.RecyclerView.dragDirs", new DragDirs());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("dragDirs").withType("androidx.recyclerview.widget.RecyclerView.dragDirs").withOrder(-10));
		ConverterFactory.register("androidx.recyclerview.widget.RecyclerView.swipeDirs", new SwipeDirs());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("swipeDirs").withType("androidx.recyclerview.widget.RecyclerView.swipeDirs").withOrder(-10));
		ConverterFactory.register("androidx.recyclerview.widget.RecyclerView.dragDropMode", new DragDropMode());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("dragDropMode").withType("androidx.recyclerview.widget.RecyclerView.dragDropMode").withOrder(10));
		ConverterFactory.register("androidx.recyclerview.widget.RecyclerView.dragStartMode", new DragStartMode());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("dragStartMode").withType("androidx.recyclerview.widget.RecyclerView.dragStartMode").withOrder(10));
		ConverterFactory.register("androidx.recyclerview.widget.RecyclerView.dragSwapMode", new DragSwapMode());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("dragSwapMode").withType("androidx.recyclerview.widget.RecyclerView.dragSwapMode").withOrder(10));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("dragSelectHighlightAttributes").withType("resourcestring").withOrder(10));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("dragResetHighlightAttributes").withType("resourcestring").withOrder(10));
		ConverterFactory.register("androidx.recyclerview.widget.RecyclerView.swipeSwapMode", new SwipeSwapMode());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("swipeSwapMode").withType("androidx.recyclerview.widget.RecyclerView.swipeSwapMode").withOrder(10));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("deleteOnSwipe").withType("boolean").withOrder(10));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("onSwiped").withType("string").withOrder(10));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("onMove").withType("string").withOrder(10));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("onMoved").withType("string").withOrder(10));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("onSelectedChanged").withType("string").withOrder(10));
	
	}
	
	public RecyclerViewImpl() {
		super(GROUP_NAME, LOCAL_NAME);
	}
	public  RecyclerViewImpl(String localname) {
		super(GROUP_NAME, localname);
	}
	public  RecyclerViewImpl(String groupName, String localname) {
		super(groupName, localname);
	}

	@Override
	public IWidget newInstance() {
		return new RecyclerViewImpl(groupName, localName);
	}
	
	@SuppressLint("NewApi")
	@Override
	public void create(IFragment fragment, Map<String, Object> params) {
		super.create(fragment, params);
Context context = (Context) fragment.getRootActivity();
	Object systemStyle = params.get("systemStyle");
	Object systemAndroidAttrStyle = params.get("systemAndroidAttrStyle");
	
	if (systemStyle == null && systemAndroidAttrStyle == null) {
		recyclerView = new RecyclerViewExt(context);
	} else {
		int defStyleAttr = 0;
		int defStyleRes = 0;
		
		if (systemStyle != null) {
			defStyleRes = context.getResources().getIdentifier((String) systemStyle, "style", context.getPackageName());	
		}
		
		if (systemAndroidAttrStyle != null) {
			defStyleAttr = context.getResources().getIdentifier((String) systemAndroidAttrStyle, "attr", "android");	
		}
		
		if (defStyleRes == 0) {
			recyclerView = new RecyclerViewExt(context, null, defStyleAttr);	
		} else {
		}
		
	}

		
		nativeCreate(params);
		
		
		ViewGroupImpl.registerCommandConveter(this);

	}

	@Override
	public Object asWidget() {
		return recyclerView;
	}


	
	@Override
	public void add(IWidget w, int index) {
		if (index != -2) {
			View view = (View) w.asWidget();
			createLayoutParams(view);
			    if (index == -1) {
			        recyclerView.addView(view);
			    } else {
			        recyclerView.addView(view, index);
			    }
		}
		
		ViewGroupImpl.nativeAddView(asNativeWidget(), w.asNativeWidget());
		super.add(w, index);
	}
	
	private void createLayoutParams(View view) {
		androidx.recyclerview.widget.RecyclerView.LayoutParams layoutParams = (androidx.recyclerview.widget.RecyclerView.LayoutParams) view.getLayoutParams();
		
		layoutParams = (androidx.recyclerview.widget.RecyclerView.LayoutParams) view.getLayoutParams();
		if (layoutParams == null) {
			layoutParams = recyclerView.getLayoutManager().generateDefaultLayoutParams();
			view.setLayoutParams(layoutParams);
		}  else {
			layoutParams.height = -2;
			layoutParams.width = -2;
		}
	}
	
	private androidx.recyclerview.widget.RecyclerView.LayoutParams getLayoutParams(View view) {
		return (androidx.recyclerview.widget.RecyclerView.LayoutParams) view.getLayoutParams();		
	}
	
	@SuppressLint("NewApi")
	@Override
	public void setChildAttribute(IWidget w, WidgetAttribute key, String strValue, Object objValue) {
		View view = (View) w.asWidget();
		androidx.recyclerview.widget.RecyclerView.LayoutParams layoutParams = getLayoutParams(view);
		ViewGroupImpl.setChildAttribute(w, key, objValue, layoutParams);		
		
		switch (key.getAttributeName()) {
		case "layout_width":
			layoutParams.width = (int) objValue;
			break;	
		case "layout_height":
			layoutParams.height = (int) objValue;
			break;
		default:
			break;
		}
		
		
		view.setLayoutParams(layoutParams);		
	}
	
	@SuppressLint("NewApi")
	@Override
	public Object getChildAttribute(IWidget w, WidgetAttribute key) {
		Object attributeValue = ViewGroupImpl.getChildAttribute(w, key);		
		if (attributeValue != null) {
			return attributeValue;
		}
		View view = (View) w.asWidget();
		androidx.recyclerview.widget.RecyclerView.LayoutParams layoutParams = getLayoutParams(view);

		switch (key.getAttributeName()) {
		case "layout_width":
			return layoutParams.width;
		case "layout_height":
			return layoutParams.height;
		}
		
		return null;

	}
	
		
	public class RecyclerViewExt extends androidx.recyclerview.widget.RecyclerView implements ILifeCycleDecorator, com.ashera.widget.IMaxDimension{
		private MeasureEvent measureFinished = new MeasureEvent();
		private OnLayoutEvent onLayoutEvent = new OnLayoutEvent();
		
		public IWidget getWidget() {
			return RecyclerViewImpl.this;
		}
		private int mMaxWidth = -1;
		private int mMaxHeight = -1;
		@Override
		public void setMaxWidth(int width) {
			mMaxWidth = width;
		}
		@Override
		public void setMaxHeight(int height) {
			mMaxHeight = height;
		}
		@Override
		public int getMaxWidth() {
			return mMaxWidth;
		}
		@Override
		public int getMaxHeight() {
			return mMaxHeight;
		}

		public RecyclerViewExt(Context context, android.util.AttributeSet attrs, int defStyleAttr) {
	        super(context, attrs, defStyleAttr);
	    }

		public RecyclerViewExt(Context context) {
			super(context);
			
		}
		
		@Override
		public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
			if (isCustomMeasure()) {
				int[] wh = RecyclerViewImpl.this.customMeasure(widthMeasureSpec, heightMeasureSpec);
				super.onMeasure(wh[0], wh[1]);
				return;
			}

			if(mMaxWidth > 0) {
	        	widthMeasureSpec = MeasureSpec.makeMeasureSpec(mMaxWidth, MeasureSpec.AT_MOST);
	        }
	        if(mMaxHeight > 0) {
	            heightMeasureSpec = MeasureSpec.makeMeasureSpec(mMaxHeight, MeasureSpec.AT_MOST);

	        }

	        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
			IWidgetLifeCycleListener listener = (IWidgetLifeCycleListener) getListener();
			if (listener != null) {
			    measureFinished.setWidth(getMeasuredWidth());
			    measureFinished.setHeight(getMeasuredHeight());
				listener.eventOccurred(EventId.measureFinished, measureFinished);
			}
		}
		
		@Override
		protected void onLayout(boolean changed, int l, int t, int r, int b) {
			super.onLayout(changed, l, t, r, b);
			
			ViewImpl.nativeMakeFrame(asNativeWidget(), l, t, r, b);
			
			replayBufferedEvents();
			
			IWidgetLifeCycleListener listener = (IWidgetLifeCycleListener) getListener();
			if (listener != null) {
				onLayoutEvent.setB(b);
				onLayoutEvent.setL(l);
				onLayoutEvent.setR(r);
				onLayoutEvent.setT(t);
				onLayoutEvent.setChanged(changed);
				listener.eventOccurred(EventId.onLayout, onLayoutEvent);
			}
			
			if (isInvalidateOnFrameChange() && isInitialised()) {
				RecyclerViewImpl.this.invalidate();
			}
		}	
		
		@Override
		public void onDraw(Canvas canvas) {
			Runnable runnable = () -> super.onDraw(canvas);
			executeMethodListeners("onDraw", runnable, canvas);
		}

		@Override
		public void draw(Canvas canvas) {
			Runnable runnable = () -> super.draw(canvas);
			executeMethodListeners("draw", runnable, canvas);
		}

		@SuppressLint("WrongCall")
		@Override
		public void execute(String method, Object... args) {
			switch (method) {
				case "onDraw":
					setOnMethodCalled(true);
					super.onDraw((Canvas) args[0]);
					break;

				case "draw":
					setOnMethodCalled(true);
					super.draw((Canvas) args[0]);
					break;

				default:
					break;
			}
		}

		public void updateMeasuredDimension(int width, int height) {
			setMeasuredDimension(width, height);
		}


		@Override
		public ILifeCycleDecorator newInstance(IWidget widget) {
			throw new UnsupportedOperationException();
		}

		@Override
		public void setAttribute(WidgetAttribute widgetAttribute,
				String strValue, Object objValue) {
			throw new UnsupportedOperationException();
		}		
		

		@Override
		public List<String> getMethods() {
			throw new UnsupportedOperationException();
		}
		
		@Override
		public void initialized() {
			throw new UnsupportedOperationException();
		}
		
        @Override
        public Object getAttribute(WidgetAttribute widgetAttribute) {
            throw new UnsupportedOperationException();
        }
        @Override
        public void drawableStateChanged() {
        	super.drawableStateChanged();
        	if (!isWidgetDisposed()) {
        		ViewImpl.drawableStateChanged(RecyclerViewImpl.this);
        	}
        }
        
    	public void setState0(float value) {
    		ViewImpl.setState(RecyclerViewImpl.this, 0, value);
    	}
    	public void setState0(int value) {
    		ViewImpl.setState(RecyclerViewImpl.this, 0, value);
    	}
    	public void setState0(double value) {
    		ViewImpl.setState(RecyclerViewImpl.this, 0, value);
    	}
    	
    	public void setState0(Float value) {
    		ViewImpl.setState(RecyclerViewImpl.this, 0, value);
    	}
    	public void setState0(Integer value) {
    		ViewImpl.setState(RecyclerViewImpl.this, 0, value);
    	}
    	public void setState0(Double value) {
    		ViewImpl.setState(RecyclerViewImpl.this, 0, value);
    	}
    	public void setState0(Object value) {
    		ViewImpl.setState(RecyclerViewImpl.this, 0, value);
    	}
    	public void setState1(float value) {
    		ViewImpl.setState(RecyclerViewImpl.this, 1, value);
    	}
    	public void setState1(int value) {
    		ViewImpl.setState(RecyclerViewImpl.this, 1, value);
    	}
    	public void setState1(double value) {
    		ViewImpl.setState(RecyclerViewImpl.this, 1, value);
    	}
    	
    	public void setState1(Float value) {
    		ViewImpl.setState(RecyclerViewImpl.this, 1, value);
    	}
    	public void setState1(Integer value) {
    		ViewImpl.setState(RecyclerViewImpl.this, 1, value);
    	}
    	public void setState1(Double value) {
    		ViewImpl.setState(RecyclerViewImpl.this, 1, value);
    	}
    	public void setState1(Object value) {
    		ViewImpl.setState(RecyclerViewImpl.this, 1, value);
    	}
    	public void setState2(float value) {
    		ViewImpl.setState(RecyclerViewImpl.this, 2, value);
    	}
    	public void setState2(int value) {
    		ViewImpl.setState(RecyclerViewImpl.this, 2, value);
    	}
    	public void setState2(double value) {
    		ViewImpl.setState(RecyclerViewImpl.this, 2, value);
    	}
    	
    	public void setState2(Float value) {
    		ViewImpl.setState(RecyclerViewImpl.this, 2, value);
    	}
    	public void setState2(Integer value) {
    		ViewImpl.setState(RecyclerViewImpl.this, 2, value);
    	}
    	public void setState2(Double value) {
    		ViewImpl.setState(RecyclerViewImpl.this, 2, value);
    	}
    	public void setState2(Object value) {
    		ViewImpl.setState(RecyclerViewImpl.this, 2, value);
    	}
    	public void setState3(float value) {
    		ViewImpl.setState(RecyclerViewImpl.this, 3, value);
    	}
    	public void setState3(int value) {
    		ViewImpl.setState(RecyclerViewImpl.this, 3, value);
    	}
    	public void setState3(double value) {
    		ViewImpl.setState(RecyclerViewImpl.this, 3, value);
    	}
    	
    	public void setState3(Float value) {
    		ViewImpl.setState(RecyclerViewImpl.this, 3, value);
    	}
    	public void setState3(Integer value) {
    		ViewImpl.setState(RecyclerViewImpl.this, 3, value);
    	}
    	public void setState3(Double value) {
    		ViewImpl.setState(RecyclerViewImpl.this, 3, value);
    	}
    	public void setState3(Object value) {
    		ViewImpl.setState(RecyclerViewImpl.this, 3, value);
    	}
    	public void setState4(float value) {
    		ViewImpl.setState(RecyclerViewImpl.this, 4, value);
    	}
    	public void setState4(int value) {
    		ViewImpl.setState(RecyclerViewImpl.this, 4, value);
    	}
    	public void setState4(double value) {
    		ViewImpl.setState(RecyclerViewImpl.this, 4, value);
    	}
    	
    	public void setState4(Float value) {
    		ViewImpl.setState(RecyclerViewImpl.this, 4, value);
    	}
    	public void setState4(Integer value) {
    		ViewImpl.setState(RecyclerViewImpl.this, 4, value);
    	}
    	public void setState4(Double value) {
    		ViewImpl.setState(RecyclerViewImpl.this, 4, value);
    	}
    	public void setState4(Object value) {
    		ViewImpl.setState(RecyclerViewImpl.this, 4, value);
    	}
        	public void state0() {
        		ViewImpl.state(RecyclerViewImpl.this, 0);
        	}
        	public void state1() {
        		ViewImpl.state(RecyclerViewImpl.this, 1);
        	}
        	public void state2() {
        		ViewImpl.state(RecyclerViewImpl.this, 2);
        	}
        	public void state3() {
        		ViewImpl.state(RecyclerViewImpl.this, 3);
        	}
        	public void state4() {
        		ViewImpl.state(RecyclerViewImpl.this, 4);
        	}
                        
        public void stateYes() {
        	ViewImpl.stateYes(RecyclerViewImpl.this);
        	
        }
        
        public void stateNo() {
        	ViewImpl.stateNo(RecyclerViewImpl.this);
        }
     
	
	}
	@Override
	public Class getViewClass() {
		return RecyclerViewExt.class;
	}
	
	@SuppressLint("NewApi")
	@Override
	public void setAttribute(WidgetAttribute key, String strValue, Object objValue, ILifeCycleDecorator decorator) {
				ViewGroupImpl.setAttribute(this,  key, strValue, objValue, decorator);
		Object nativeWidget = asNativeWidget();
		switch (key.getAttributeName()) {
			case "onFling": {


		if (objValue instanceof String) {recyclerView.setOnFlingListener(new OnFlingListener(this, strValue));} else {setOnFlingListener(recyclerView, objValue);}



			}
			break;
			case "onScrollStateChange": {


		if (objValue instanceof String) {recyclerView.setOnScrollListener(new OnScrollListener(this, strValue));} else {setOnScrollListener(recyclerView, objValue);}



			}
			break;
			case "onScrolled": {


		if (objValue instanceof String) {recyclerView.setOnScrollListener(new OnScrollListener(this, strValue));} else {setOnScrollListener(recyclerView, objValue);}



			}
			break;
			case "layoutManager": {


		 setLayoutManager(objValue);



			}
			break;
			case "viewHolderIds": {


		 setViewHolderIds(objValue);



			}
			break;
			case "spanCount": {


		 setSpanCount(objValue);



			}
			break;
			case "layout": {


		 setLayout(objValue);



			}
			break;
			case "orientation": {


		setOrientation(objValue);



			}
			break;
			case "nestedScrollingEnabled": {


		recyclerView.setNestedScrollingEnabled((boolean)objValue);



			}
			break;
			case "addSectionItem": {
		if (objValue instanceof Map) {
			Map<String, Object> data = ((Map<String, Object>) objValue);
		Object sectionId = quickConvert(data.get("sectionId"), "string");
		Object itemConfigId = quickConvert(data.get("itemConfigId"), "string");
		Object item = quickConvert(data.get("item"), "object");


		 addSectionItem((String) sectionId, (String) itemConfigId, item);


}
if (objValue instanceof java.util.List) {
	java.util.List<Object> list = (java.util.List<Object>) objValue;
	for (Object object : list) {
		Map<String, Object> data = PluginInvoker.getMap(object);
		Object sectionId = quickConvert(data.get("sectionId"), "string");
		Object itemConfigId = quickConvert(data.get("itemConfigId"), "string");
		Object item = quickConvert(data.get("item"), "object");


		 addSectionItem((String) sectionId, (String) itemConfigId, item);


	}
}
			}
			break;
			case "removeSectionItem": {
		if (objValue instanceof Map) {
			Map<String, Object> data = ((Map<String, Object>) objValue);
		Object sectionId = quickConvert(data.get("sectionId"), "string");
		Object itemConfigId = quickConvert(data.get("itemConfigId"), "string");
		Object itemId = quickConvert(data.get("itemId"), "string");


		 removeSectionItem((String) sectionId, (String) itemConfigId, (String) itemId);


}
if (objValue instanceof java.util.List) {
	java.util.List<Object> list = (java.util.List<Object>) objValue;
	for (Object object : list) {
		Map<String, Object> data = PluginInvoker.getMap(object);
		Object sectionId = quickConvert(data.get("sectionId"), "string");
		Object itemConfigId = quickConvert(data.get("itemConfigId"), "string");
		Object itemId = quickConvert(data.get("itemId"), "string");


		 removeSectionItem((String) sectionId, (String) itemConfigId, (String) itemId);


	}
}
			}
			break;
			case "removeAllItems": {
		if (objValue instanceof Map) {
			Map<String, Object> data = ((Map<String, Object>) objValue);
		Object sectionId = quickConvert(data.get("sectionId"), "string");
		Object itemConfigId = quickConvert(data.get("itemConfigId"), "string");


		 removeAllItems((String) sectionId, (String)itemConfigId);


}
if (objValue instanceof java.util.List) {
	java.util.List<Object> list = (java.util.List<Object>) objValue;
	for (Object object : list) {
		Map<String, Object> data = PluginInvoker.getMap(object);
		Object sectionId = quickConvert(data.get("sectionId"), "string");
		Object itemConfigId = quickConvert(data.get("itemConfigId"), "string");


		 removeAllItems((String) sectionId, (String)itemConfigId);


	}
}
			}
			break;
			case "updateSectionItem": {
		if (objValue instanceof Map) {
			Map<String, Object> data = ((Map<String, Object>) objValue);
		Object sectionId = quickConvert(data.get("sectionId"), "string");
		Object itemConfigId = quickConvert(data.get("itemConfigId"), "string");
		Object itemId = quickConvert(data.get("itemId"), "string");
		Object item = quickConvert(data.get("item"), "object");


		 updateSectionItem((String) sectionId, (String) itemConfigId, (String) itemId, item);


}
if (objValue instanceof java.util.List) {
	java.util.List<Object> list = (java.util.List<Object>) objValue;
	for (Object object : list) {
		Map<String, Object> data = PluginInvoker.getMap(object);
		Object sectionId = quickConvert(data.get("sectionId"), "string");
		Object itemConfigId = quickConvert(data.get("itemConfigId"), "string");
		Object itemId = quickConvert(data.get("itemId"), "string");
		Object item = quickConvert(data.get("item"), "object");


		 updateSectionItem((String) sectionId, (String) itemConfigId, (String) itemId, item);


	}
}
			}
			break;
			case "stackFromEnd": {


		 setStackFromBottom(objValue);



			}
			break;
			case "reverseLayout": {


		 setReverseLayout(objValue);



			}
			break;
			case "scrollToEnd": {


		 scrollToEnd(objValue);



			}
			break;
			case "scrollToTop": {


		 scrollToTop(objValue);



			}
			break;
			case "scrollToPosition": {


		 scrollToPosition(objValue);



			}
			break;
			case "headerDisabled": {


		 setHeaderDisabled(objValue);



			}
			break;
			case "footerDisabled": {


		 setFooterDisabled(objValue);



			}
			break;
			case "filter": {


		 filter(objValue);



			}
			break;
			case "filterDelay": {


		 setFilterDelay(objValue);



			}
			break;
			case "filterId": {


		 setFilterId(objValue);



			}
			break;
			case "filterItemPath": {


		 setFilterItemPath(objValue);



			}
			break;
			case "filterSectionPath": {


		 setFilterSectionItemPath(objValue);



			}
			break;
			case "filterQueryStorePath": {


		 setFilterQueryStorePath(objValue);



			}
			break;
			case "filterQueryGetPath": {


		 setFilterQueryGetPath(objValue);



			}
			break;
			case "fixedgrid_rowCount": {


		 setFixedgridRowCount(objValue);



			}
			break;
			case "fixedgrid_columnCount": {


		 setFixedgridColumnCount(objValue);



			}
			break;
			case "fixedgrid_tileWidth": {


		 setFixedgridTileWidth(objValue);



			}
			break;
			case "fixedgrid_tileHeight": {


		 setFixedgridTileHeight(objValue);



			}
			break;
			case "disableItemAnimator": {


		 disableItemAnimator();



			}
			break;
			case "hasFixedSize": {


		 setHasFixedSize(objValue);



			}
			break;
			case "dragDirs": {


		setDragDirs(objValue);



			}
			break;
			case "swipeDirs": {


		setSwipeDirs(objValue);



			}
			break;
			case "dragDropMode": {


		setDragDropMode(strValue, objValue);



			}
			break;
			case "dragStartMode": {


		setDragStartMode(strValue, objValue);



			}
			break;
			case "dragSwapMode": {


		setSwapMode(strValue, objValue);



			}
			break;
			case "dragSelectHighlightAttributes": {


		 setSelectHighlightAttributes(objValue);



			}
			break;
			case "dragResetHighlightAttributes": {


		 setResetHighlightAttributes(objValue);



			}
			break;
			case "swipeSwapMode": {


		setSwipeSwapMode(strValue, objValue);



			}
			break;
			case "deleteOnSwipe": {


		 setDeleteOnSwipe(objValue);



			}
			break;
			case "onSwiped": {


		if (objValue instanceof String) {setonSwiped(strValue);} else {setonSwiped((MyItemTouchHelper.MyCallback) objValue);}



			}
			break;
			case "onMove": {


		if (objValue instanceof String) {setOnMove(strValue);} else {setOnMove((MyItemTouchHelper.MyCallback) objValue);}



			}
			break;
			case "onMoved": {


		if (objValue instanceof String) {setOnMoved(strValue);} else {setOnMoved((MyItemTouchHelper.MyCallback) objValue);}



			}
			break;
			case "onSelectedChanged": {


		if (objValue instanceof String) {setOnSelectedChanged(strValue);} else {setOnSelectedChanged((MyItemTouchHelper.MyCallback) objValue);}



			}
			break;
		default:
			break;
		}
		
	}
	
	@Override
	@SuppressLint("NewApi")
	public Object getAttribute(WidgetAttribute key, ILifeCycleDecorator decorator) {
		Object attributeValue = ViewGroupImpl.getAttribute(this, key, decorator);
		if (attributeValue != null) {
			return attributeValue;
		}
		Object nativeWidget = asNativeWidget();
		switch (key.getAttributeName()) {
			case "orientation": {
return getOrientation();			}
			case "nestedScrollingEnabled": {
return recyclerView.isNestedScrollingEnabled();			}
			case "reverseLayout": {
return isReverseLayout();			}
		}
		return null;
	}


	@Override
    public Object asNativeWidget() {
        return recyclerView;
    }
    
    @Override
    public void requestLayout() {
    	if (isInitialised()) {
    		ViewImpl.requestLayout(this, asNativeWidget());
    	}
    }
    
    @Override
    public void invalidate() {
    	if (isInitialised()) {
    		ViewImpl.invalidate(this, asNativeWidget());
    	}
    }
    
	

    private boolean disableUpdate = false;
    @Override
    protected void addObject(com.ashera.model.LoopParam childModel, String modelIdPath, int index, String currentLoopVar) {
        String id = null;
        if (modelIdPath != null) {
            id = PluginInvoker.getString(getModelByPath(modelIdPath, childModel.get(currentLoopVar)));
        } else {
            id = UUID.randomUUID().toString();
        }
        
        if (!ids.contains(id)) {
            if (index == -1) {
                ids.add(id);
                dataList.add(childModel);
            } else {
                ids.add(index, id);
                dataList.add(index, childModel);
            }
            
        } else {
            // update the objects on the widget
            dataList.set(ids.indexOf(id), childModel);
        }

        reloadTable();
    }
    
    @Override
    public void addAllModel(Object objValue) {
    	disableUpdate = true;
    	super.addAllModel(objValue);
    	disableUpdate = false;
    	reloadTable();
    }

    @Override
    public boolean remove(int index) {
        if (index + 1 <= ids.size()) {
            ids.remove(index);
        }
        if (index + 1 <= dataList.size()) {
            dataList.remove(index);
        }
        reloadTable();
        return true;
    }

    
    @Override
    public boolean areWidgetItemsRecycled() {
    	return true;
    }

	
	@Override
	public void clear() {
		ids.clear();
		dataList.clear();
		reloadTable();
	}
	
	@Override
	protected void clearModel() {
		ids.clear();
		dataList.clear();
	}
	
	@Override
	public void notifyDataSetChanged() {
		disableUpdate = true;
		super.notifyDataSetChanged();
		disableUpdate = false;
		reloadTable();
	}
	

	@SuppressLint("NewApi")
private static class OnFlingListener extends RecyclerView.OnFlingListener implements com.ashera.widget.IListener{
private IWidget w; private View view; private String strValue; private String action;
public String getAction() {return action;}
public OnFlingListener(IWidget w, String strValue)  {
this.w = w; this.strValue = strValue;
}
public OnFlingListener(IWidget w, String strValue, String action)  {
this.w = w; this.strValue = strValue;this.action=action;
}
public boolean onFling (int velocityX, 
                int velocityY){
    boolean result = true;
    
	if (action == null || action.equals("onFling")) {
		// populate the data from ui to pojo
		w.syncModelFromUiToPojo("onFling");
	    java.util.Map<String, Object> obj = getOnFlingEventObj(velocityX,velocityY);
	    String commandName =  (String) obj.get(EventExpressionParser.KEY_COMMAND_NAME);
	    
	    // execute command based on command type
	    String commandType = (String)obj.get(EventExpressionParser.KEY_COMMAND_TYPE);
		switch (commandType) {
		case "+":
		    if (EventCommandFactory.hasCommand(commandName)) {
		    	 Object commandResult = EventCommandFactory.getCommand(commandName).executeCommand(w, obj, velocityX,velocityY);
		    	 if (commandResult != null) {
		    		 result = (boolean) commandResult;
		    	 }
		    }

			break;
		default:
			break;
		}
		
		if (obj.containsKey("refreshUiFromModel")) {
			Object widgets = obj.remove("refreshUiFromModel");
			com.ashera.layout.ViewImpl.refreshUiFromModel(w, widgets, true);
		}
		if (w.getModelUiToPojoEventIds() != null) {
			com.ashera.layout.ViewImpl.refreshUiFromModel(w, w.getModelUiToPojoEventIds(), true);
		}
		if (strValue != null && !strValue.isEmpty() && !strValue.trim().startsWith("+")) {
		    com.ashera.core.IActivity activity = (com.ashera.core.IActivity)w.getFragment().getRootActivity();
		    if (activity != null) {
		    	activity.sendEventMessage(obj);
		    }
		}
	}
    return result;
}//#####

public java.util.Map<String, Object> getOnFlingEventObj(int velocityX,int velocityY) {
	java.util.Map<String, Object> obj = com.ashera.widget.PluginInvoker.getJSONCompatMap();
    obj.put("action", "action");
    obj.put("eventType", "fling");
    obj.put("fragmentId", w.getFragment().getFragmentId());
    obj.put("actionUrl", w.getFragment().getActionUrl());
    obj.put("namespace", w.getFragment().getNamespace());
    
    if (w.getComponentId() != null) {
    	obj.put("componentId", w.getComponentId());
    }
    
    PluginInvoker.putJSONSafeObjectIntoMap(obj, "id", w.getId());
     
        PluginInvoker.putJSONSafeObjectIntoMap(obj, "velocityX", velocityX);
        PluginInvoker.putJSONSafeObjectIntoMap(obj, "velocityY", velocityY);
    
    // parse event info into the map
    EventExpressionParser.parseEventExpression(strValue, obj);
    
    // update model data into map
    w.updateModelToEventMap(obj, "onFling", (String)obj.get(EventExpressionParser.KEY_EVENT_ARGS));
    return obj;
}
}

	@SuppressLint("NewApi")
private static class OnScrollListener extends RecyclerView.OnScrollListener implements com.ashera.widget.IListener{
private IWidget w; private View view; private String strValue; private String action;
public String getAction() {return action;}
public OnScrollListener(IWidget w, String strValue)  {
this.w = w; this.strValue = strValue;
}
public OnScrollListener(IWidget w, String strValue, String action)  {
this.w = w; this.strValue = strValue;this.action=action;
}
public void onScrollStateChanged (RecyclerView recyclerView, 
                int newState){
    
	if (action == null || action.equals("onScrollStateChange")) {
		// populate the data from ui to pojo
		w.syncModelFromUiToPojo("onScrollStateChange");
	    java.util.Map<String, Object> obj = getOnScrollStateChangeEventObj(recyclerView,newState);
	    String commandName =  (String) obj.get(EventExpressionParser.KEY_COMMAND_NAME);
	    
	    // execute command based on command type
	    String commandType = (String)obj.get(EventExpressionParser.KEY_COMMAND_TYPE);
		switch (commandType) {
		case "+":
		    if (EventCommandFactory.hasCommand(commandName)) {
		    	 EventCommandFactory.getCommand(commandName).executeCommand(w, obj, recyclerView,newState);
		    }

			break;
		default:
			break;
		}
		
		if (obj.containsKey("refreshUiFromModel")) {
			Object widgets = obj.remove("refreshUiFromModel");
			com.ashera.layout.ViewImpl.refreshUiFromModel(w, widgets, true);
		}
		if (w.getModelUiToPojoEventIds() != null) {
			com.ashera.layout.ViewImpl.refreshUiFromModel(w, w.getModelUiToPojoEventIds(), true);
		}
		if (strValue != null && !strValue.isEmpty() && !strValue.trim().startsWith("+")) {
		    com.ashera.core.IActivity activity = (com.ashera.core.IActivity)w.getFragment().getRootActivity();
		    if (activity != null) {
		    	activity.sendEventMessage(obj);
		    }
		}
	}
    return;
}//
public void onScrolled (RecyclerView recyclerView, 
                int dx, 
                int dy){
    
	if (action == null || action.equals("onScrolled")) {
		// populate the data from ui to pojo
		w.syncModelFromUiToPojo("onScrolled");
	    java.util.Map<String, Object> obj = getOnScrolledEventObj(recyclerView,dx,dy);
	    String commandName =  (String) obj.get(EventExpressionParser.KEY_COMMAND_NAME);
	    
	    // execute command based on command type
	    String commandType = (String)obj.get(EventExpressionParser.KEY_COMMAND_TYPE);
		switch (commandType) {
		case "+":
		    if (EventCommandFactory.hasCommand(commandName)) {
		    	 EventCommandFactory.getCommand(commandName).executeCommand(w, obj, recyclerView,dx,dy);
		    }

			break;
		default:
			break;
		}
		
		if (obj.containsKey("refreshUiFromModel")) {
			Object widgets = obj.remove("refreshUiFromModel");
			com.ashera.layout.ViewImpl.refreshUiFromModel(w, widgets, true);
		}
		if (w.getModelUiToPojoEventIds() != null) {
			com.ashera.layout.ViewImpl.refreshUiFromModel(w, w.getModelUiToPojoEventIds(), true);
		}
		if (strValue != null && !strValue.isEmpty() && !strValue.trim().startsWith("+")) {
		    com.ashera.core.IActivity activity = (com.ashera.core.IActivity)w.getFragment().getRootActivity();
		    if (activity != null) {
		    	activity.sendEventMessage(obj);
		    }
		}
	}
    return;
}//#####

public java.util.Map<String, Object> getOnScrolledEventObj(RecyclerView recyclerView,int dx,int dy) {
	java.util.Map<String, Object> obj = com.ashera.widget.PluginInvoker.getJSONCompatMap();
    obj.put("action", "action");
    obj.put("eventType", "scrolled");
    obj.put("fragmentId", w.getFragment().getFragmentId());
    obj.put("actionUrl", w.getFragment().getActionUrl());
    obj.put("namespace", w.getFragment().getNamespace());
    
    if (w.getComponentId() != null) {
    	obj.put("componentId", w.getComponentId());
    }
    
    PluginInvoker.putJSONSafeObjectIntoMap(obj, "id", w.getId());
     
        PluginInvoker.putJSONSafeObjectIntoMap(obj, "dx", dx);
        PluginInvoker.putJSONSafeObjectIntoMap(obj, "dy", dy);
    
    // parse event info into the map
    EventExpressionParser.parseEventExpression(strValue, obj);
    
    // update model data into map
    w.updateModelToEventMap(obj, "onScrolled", (String)obj.get(EventExpressionParser.KEY_EVENT_ARGS));
    return obj;
}

public java.util.Map<String, Object> getOnScrollStateChangeEventObj(RecyclerView recyclerView,int newState) {
	java.util.Map<String, Object> obj = com.ashera.widget.PluginInvoker.getJSONCompatMap();
    obj.put("action", "action");
    obj.put("eventType", "scrollstatechange");
    obj.put("fragmentId", w.getFragment().getFragmentId());
    obj.put("actionUrl", w.getFragment().getActionUrl());
    obj.put("namespace", w.getFragment().getNamespace());
    
    if (w.getComponentId() != null) {
    	obj.put("componentId", w.getComponentId());
    }
    
    PluginInvoker.putJSONSafeObjectIntoMap(obj, "id", w.getId());
     
        PluginInvoker.putJSONSafeObjectIntoMap(obj, "newState", newState);
    
    // parse event info into the map
    EventExpressionParser.parseEventExpression(strValue, obj);
    
    // update model data into map
    w.updateModelToEventMap(obj, "onScrollStateChange", (String)obj.get(EventExpressionParser.KEY_EVENT_ARGS));
    return obj;
}
}

	@SuppressLint("NewApi")
private static class MyCallback implements MyItemTouchHelper.MyCallback, com.ashera.widget.IListener{
private IWidget w; private View view; private String strValue; private String action;
public String getAction() {return action;}
public MyCallback(IWidget w, String strValue)  {
this.w = w; this.strValue = strValue;
}
public MyCallback(IWidget w, String strValue, String action)  {
this.w = w; this.strValue = strValue;this.action=action;
}
public void onSwiped(ViewHolder viewHolder, int direction){
    
	if (action == null || action.equals("onSwiped")) {
		// populate the data from ui to pojo
		w.syncModelFromUiToPojo("onSwiped");
	    java.util.Map<String, Object> obj = getOnSwipedEventObj(viewHolder,direction);
	    String commandName =  (String) obj.get(EventExpressionParser.KEY_COMMAND_NAME);
	    
	    // execute command based on command type
	    String commandType = (String)obj.get(EventExpressionParser.KEY_COMMAND_TYPE);
		switch (commandType) {
		case "+":
		    if (EventCommandFactory.hasCommand(commandName)) {
		    	 EventCommandFactory.getCommand(commandName).executeCommand(w, obj, viewHolder,direction);
		    }

			break;
		default:
			break;
		}
		
		if (obj.containsKey("refreshUiFromModel")) {
			Object widgets = obj.remove("refreshUiFromModel");
			com.ashera.layout.ViewImpl.refreshUiFromModel(w, widgets, true);
		}
		if (w.getModelUiToPojoEventIds() != null) {
			com.ashera.layout.ViewImpl.refreshUiFromModel(w, w.getModelUiToPojoEventIds(), true);
		}
		if (strValue != null && !strValue.isEmpty() && !strValue.trim().startsWith("+")) {
		    com.ashera.core.IActivity activity = (com.ashera.core.IActivity)w.getFragment().getRootActivity();
		    if (activity != null) {
		    	activity.sendEventMessage(obj);
		    }
		}
	}
    return;
}//#####

public java.util.Map<String, Object> getOnSwipedEventObj(ViewHolder viewHolder,int direction) {
	java.util.Map<String, Object> obj = com.ashera.widget.PluginInvoker.getJSONCompatMap();
    obj.put("action", "action");
    obj.put("eventType", "swiped");
    obj.put("fragmentId", w.getFragment().getFragmentId());
    obj.put("actionUrl", w.getFragment().getActionUrl());
    obj.put("namespace", w.getFragment().getNamespace());
    
    if (w.getComponentId() != null) {
    	obj.put("componentId", w.getComponentId());
    }
    
    PluginInvoker.putJSONSafeObjectIntoMap(obj, "id", w.getId());
     
        RecyclerViewImpl.addEventInfoViewHolder(obj, viewHolder);
        PluginInvoker.putJSONSafeObjectIntoMap(obj, "direction", direction);
    
    // parse event info into the map
    EventExpressionParser.parseEventExpression(strValue, obj);
    
    // update model data into map
    w.updateModelToEventMap(obj, "onSwiped", (String)obj.get(EventExpressionParser.KEY_EVENT_ARGS));
    return obj;
}public boolean onMove(RecyclerView recyclerView, ViewHolder viewHolder, ViewHolder target){
    boolean result = true;
    
	if (action == null || action.equals("onMove")) {
		// populate the data from ui to pojo
		w.syncModelFromUiToPojo("onMove");
	    java.util.Map<String, Object> obj = getOnMoveEventObj(recyclerView,viewHolder,target);
	    String commandName =  (String) obj.get(EventExpressionParser.KEY_COMMAND_NAME);
	    
	    // execute command based on command type
	    String commandType = (String)obj.get(EventExpressionParser.KEY_COMMAND_TYPE);
		switch (commandType) {
		case "+":
		    if (EventCommandFactory.hasCommand(commandName)) {
		    	 Object commandResult = EventCommandFactory.getCommand(commandName).executeCommand(w, obj, recyclerView,viewHolder,target);
		    	 if (commandResult != null) {
		    		 result = (boolean) commandResult;
		    	 }
		    }

			break;
		default:
			break;
		}
		
		if (obj.containsKey("refreshUiFromModel")) {
			Object widgets = obj.remove("refreshUiFromModel");
			com.ashera.layout.ViewImpl.refreshUiFromModel(w, widgets, true);
		}
		if (w.getModelUiToPojoEventIds() != null) {
			com.ashera.layout.ViewImpl.refreshUiFromModel(w, w.getModelUiToPojoEventIds(), true);
		}
		if (strValue != null && !strValue.isEmpty() && !strValue.trim().startsWith("+")) {
		    com.ashera.core.IActivity activity = (com.ashera.core.IActivity)w.getFragment().getRootActivity();
		    if (activity != null) {
		    	activity.sendEventMessage(obj);
		    }
		}
	}
    return result;
}//#####

public java.util.Map<String, Object> getOnMoveEventObj(RecyclerView recyclerView,ViewHolder viewHolder,ViewHolder target) {
	java.util.Map<String, Object> obj = com.ashera.widget.PluginInvoker.getJSONCompatMap();
    obj.put("action", "action");
    obj.put("eventType", "move");
    obj.put("fragmentId", w.getFragment().getFragmentId());
    obj.put("actionUrl", w.getFragment().getActionUrl());
    obj.put("namespace", w.getFragment().getNamespace());
    
    if (w.getComponentId() != null) {
    	obj.put("componentId", w.getComponentId());
    }
    
    PluginInvoker.putJSONSafeObjectIntoMap(obj, "id", w.getId());
     
        RecyclerViewImpl.addEventInfoViewHolder(obj, viewHolder);
        RecyclerViewImpl.addEventInfoTargetViewHolder(obj, target);
    
    // parse event info into the map
    EventExpressionParser.parseEventExpression(strValue, obj);
    
    // update model data into map
    w.updateModelToEventMap(obj, "onMove", (String)obj.get(EventExpressionParser.KEY_EVENT_ARGS));
    return obj;
}public void onMoved(RecyclerView recyclerView, int fromPos, int toPos){
    
	if (action == null || action.equals("onMoved")) {
		// populate the data from ui to pojo
		w.syncModelFromUiToPojo("onMoved");
	    java.util.Map<String, Object> obj = getOnMovedEventObj(recyclerView,fromPos,toPos);
	    String commandName =  (String) obj.get(EventExpressionParser.KEY_COMMAND_NAME);
	    
	    // execute command based on command type
	    String commandType = (String)obj.get(EventExpressionParser.KEY_COMMAND_TYPE);
		switch (commandType) {
		case "+":
		    if (EventCommandFactory.hasCommand(commandName)) {
		    	 EventCommandFactory.getCommand(commandName).executeCommand(w, obj, recyclerView,fromPos,toPos);
		    }

			break;
		default:
			break;
		}
		
		if (obj.containsKey("refreshUiFromModel")) {
			Object widgets = obj.remove("refreshUiFromModel");
			com.ashera.layout.ViewImpl.refreshUiFromModel(w, widgets, true);
		}
		if (w.getModelUiToPojoEventIds() != null) {
			com.ashera.layout.ViewImpl.refreshUiFromModel(w, w.getModelUiToPojoEventIds(), true);
		}
		if (strValue != null && !strValue.isEmpty() && !strValue.trim().startsWith("+")) {
		    com.ashera.core.IActivity activity = (com.ashera.core.IActivity)w.getFragment().getRootActivity();
		    if (activity != null) {
		    	activity.sendEventMessage(obj);
		    }
		}
	}
    return;
}//#####

public java.util.Map<String, Object> getOnMovedEventObj(RecyclerView recyclerView,int fromPos,int toPos) {
	java.util.Map<String, Object> obj = com.ashera.widget.PluginInvoker.getJSONCompatMap();
    obj.put("action", "action");
    obj.put("eventType", "moved");
    obj.put("fragmentId", w.getFragment().getFragmentId());
    obj.put("actionUrl", w.getFragment().getActionUrl());
    obj.put("namespace", w.getFragment().getNamespace());
    
    if (w.getComponentId() != null) {
    	obj.put("componentId", w.getComponentId());
    }
    
    PluginInvoker.putJSONSafeObjectIntoMap(obj, "id", w.getId());
     
        PluginInvoker.putJSONSafeObjectIntoMap(obj, "fromPos", fromPos);
        PluginInvoker.putJSONSafeObjectIntoMap(obj, "toPos", toPos);
    
    // parse event info into the map
    EventExpressionParser.parseEventExpression(strValue, obj);
    
    // update model data into map
    w.updateModelToEventMap(obj, "onMoved", (String)obj.get(EventExpressionParser.KEY_EVENT_ARGS));
    return obj;
}public void onSelectedChanged(ViewHolder viewHolder, int actionState){
    
	if (action == null || action.equals("onSelectedChanged")) {
		// populate the data from ui to pojo
		w.syncModelFromUiToPojo("onSelectedChanged");
	    java.util.Map<String, Object> obj = getOnSelectedChangedEventObj(viewHolder,actionState);
	    String commandName =  (String) obj.get(EventExpressionParser.KEY_COMMAND_NAME);
	    
	    // execute command based on command type
	    String commandType = (String)obj.get(EventExpressionParser.KEY_COMMAND_TYPE);
		switch (commandType) {
		case "+":
		    if (EventCommandFactory.hasCommand(commandName)) {
		    	 EventCommandFactory.getCommand(commandName).executeCommand(w, obj, viewHolder,actionState);
		    }

			break;
		default:
			break;
		}
		
		if (obj.containsKey("refreshUiFromModel")) {
			Object widgets = obj.remove("refreshUiFromModel");
			com.ashera.layout.ViewImpl.refreshUiFromModel(w, widgets, true);
		}
		if (w.getModelUiToPojoEventIds() != null) {
			com.ashera.layout.ViewImpl.refreshUiFromModel(w, w.getModelUiToPojoEventIds(), true);
		}
		if (strValue != null && !strValue.isEmpty() && !strValue.trim().startsWith("+")) {
		    com.ashera.core.IActivity activity = (com.ashera.core.IActivity)w.getFragment().getRootActivity();
		    if (activity != null) {
		    	activity.sendEventMessage(obj);
		    }
		}
	}
    return;
}//#####

public java.util.Map<String, Object> getOnSelectedChangedEventObj(ViewHolder viewHolder,int actionState) {
	java.util.Map<String, Object> obj = com.ashera.widget.PluginInvoker.getJSONCompatMap();
    obj.put("action", "action");
    obj.put("eventType", "selectedchanged");
    obj.put("fragmentId", w.getFragment().getFragmentId());
    obj.put("actionUrl", w.getFragment().getActionUrl());
    obj.put("namespace", w.getFragment().getNamespace());
    
    if (w.getComponentId() != null) {
    	obj.put("componentId", w.getComponentId());
    }
    
    PluginInvoker.putJSONSafeObjectIntoMap(obj, "id", w.getId());
     
        RecyclerViewImpl.addEventInfoViewHolder(obj, viewHolder);
        PluginInvoker.putJSONSafeObjectIntoMap(obj, "actionState", actionState);
    
    // parse event info into the map
    EventExpressionParser.parseEventExpression(strValue, obj);
    
    // update model data into map
    w.updateModelToEventMap(obj, "onSelectedChanged", (String)obj.get(EventExpressionParser.KEY_EVENT_ARGS));
    return obj;
}
}


	@Override
	public void setId(String id){
		if (id != null && !id.equals("")){
			super.setId(id);
			recyclerView.setId((int) quickConvert(id, "id"));
		}
	}
	
    

		//end - body
	//start - recyclerview
	private RecyclerView.Adapter<? extends RecyclerView.ViewHolder> adapter;
	private IWidget headerTemplate;
	private IWidget footerTemplate;
	
	private void nativeCreate(Map<String, Object> params) {
		adapter = new ListAdapter();
		adapter.setHasStableIds(true);
		recyclerView.setAdapter(adapter);
		recyclerView.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(recyclerView.getContext()));
		initScrollBars();
	}

	public class ListAdapter extends RecyclerView.Adapter<MyViewHolder> implements ItemActionHandler {
		@Override
		public boolean isDragEnabled(ViewHolder viewHolder) {
			return viewHolder.getItemViewType() == 0;
		}

		@Override
		public void onItemMove(int fromPosition, int toPosition, String mode) {
			int fromItem = adapterPositionToItemIndex(fromPosition);
			int toItem = adapterPositionToItemIndex(toPosition);
			try {
				disableUpdate = true;
				swapModelByIndex(fromItem, toItem);
			} finally {
				disableUpdate = false;
			}
			
			if (mode != null) {
				switch (mode) {
				case "notifyDataSetChanged":
					notifyDataSetChanged();
					break;
				case "notifyItemMoved":
					notifyItemMoved(fromPosition, toPosition);
					break;
				default:
					break;
				}
			}

		}
		
		private int adapterPositionToItemIndex(int index) {
			if (headerTemplate != null && !headerDisabled) {
				return index - 1;
			}
			
			return index;
		}

		@Override
		public void onItemRemove(int position, String mode) {
			int itemIndex = adapterPositionToItemIndex(position);
			try {
				disableUpdate = true;
				removeModelAtIndex(itemIndex);
			} finally {
				disableUpdate = false;
			}
            
            if (mode != null) {
	            switch (mode) {
				case "notifyDataSetChanged":
					notifyDataSetChanged();
					break;
				case "notifyItemRemoved":
					notifyItemRemoved(position);
					break;
				default:
					break;
				}
            } else {
            	notifyItemRemoved(position);
            }
		}
		@Override
		public long getItemId(int position) {
			if (isHeader(position) || isFooter(position)) {
				return super.getItemId(position);
			}
			if (headerTemplate != null && !headerDisabled) {
				position = position - 1;
			}
			Object id = quickConvert(ids.get(position), "id");
			if (id == null) {
				id = 0;
			}
			return (int) id;
		}
		
		@Override
		public void onViewAttachedToWindow(MyViewHolder holder) {
			super.onViewAttachedToWindow(holder);
			holder.itemView.setVisibility(View.VISIBLE);
		}
		
		@Override
		public void onViewDetachedFromWindow(MyViewHolder holder) {
			super.onViewDetachedFromWindow(holder);
			holder.itemView.setVisibility(View.INVISIBLE);
		}

		@Override
		public int getItemViewType(int position) {
			if (isHeader(position)) {
				return 1;
			}
			
			if (isFooter(position)) {
				return 2;
			}
				
			return 0;
		}

		private boolean isFooter(int position) {
			return !footerDisabled && footerTemplate != null && position == getItemCount() - 1;
		}

		private boolean isHeader(int position) {
			return !headerDisabled && headerTemplate != null && position == 0;
		}

		@Override
		public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			IWidget listItem = null;
			List<String> viewHolderIds;
			
			if (viewType == 1) {
				listItem = headerTemplate;
				viewHolderIds = RecyclerViewImpl.this.headerViewHolderIds;
			} else if (viewType == 2) {
				listItem = footerTemplate;
				viewHolderIds = RecyclerViewImpl.this.footerViewHolderIds;
			} else {
				listItem = getListItem();
				viewHolderIds = RecyclerViewImpl.this.viewHolderIds;
			}
			
			IWidget widget = (IWidget) listItem.loadLazyWidgets((com.ashera.model.LoopParam) null);
			if (widgets.indexOf(widget) == -1) {
				widgets.add(widget);
			}
			View itemView = (View) widget.asWidget();
			
			setItemViewParams(widget, itemView);

			MyViewHolder viewHolder = new MyViewHolder(widget, itemView, viewHolderIds);
			addStartDrag(viewHolder);
			return viewHolder;
		}

		@Override
		public void onBindViewHolder(MyViewHolder viewHolder, int position) {
			if (isHeader(position) || isFooter(position)) {
				setAttributeOnViewHolder(viewHolder.widgetViewHolder, ( com.ashera.model.LoopParam) null);
				return;
			}
			if (headerTemplate != null && !headerDisabled) {
				position = position - 1;
			}
			setAttributeOnViewHolder(viewHolder.widgetViewHolder, position);
		}
	
		@Override
		public int getItemCount() {
			int size = dataList.size();
			if (headerTemplate != null && !headerDisabled) {
				size++;
			}
			if (footerTemplate != null && !footerDisabled) {
				size++;
			}
			return size;
		}

		@Override
		public int getSwipeDirs(ViewHolder viewHolder) {
			return -1;
		}

		@Override
		public int getDragDirs(ViewHolder viewHolder) {
			return -1;
		}
	}
	

	public class MyViewHolder extends RecyclerView.ViewHolder {
		WidgetViewHolder widgetViewHolder;
		public MyViewHolder(IWidget widget, View itemView, List<String> viewHolderIds) {
			super(itemView);

			if (viewHolderIds != null) {
				widgetViewHolder = createWidgetViewHolder(viewHolderIds, widget);
			}
		}
	}
	private void setLayoutManager(Object objValue) {
		String layoutManager = (String) objValue;
		
		switch (layoutManager) {
			case "com.ashera.recycleview.FixedGridViewManager": {
				FixedGridViewManager gridLayoutManager = new FixedGridViewManager(fixedGridRowCount, fixedGridColumnCount);
				recyclerView.setLayoutManager(gridLayoutManager);
				break;
			}
		case "androidx.recyclerview.widget.GridLayoutManager": {
				GridLayoutManager gridLayoutManager = new GridLayoutManager(recyclerView.getContext(), spanCount);
				recyclerView.setLayoutManager(gridLayoutManager);
				gridLayoutManager.setOrientation(orientation);
				((GridLayoutManager)recyclerView.getLayoutManager()).setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {

					@Override
					public int getSpanSize(int position) {
						if (headerTemplate != null && position == 0) {
							return spanCount;
						}
						return 1;
					}
					
				});
			}
			break;
		case "androidx.recyclerview.widget.LinearLayoutManager": {
				LinearLayoutManager linearLayoutManager = new LinearLayoutManager(recyclerView.getContext());
				recyclerView.setLayoutManager(linearLayoutManager);
				linearLayoutManager.setOrientation(orientation);
			}
			break;
		case "androidx.recyclerview.widget.StaggeredGridLayoutManager":	 {
			StaggeredGridLayoutManager gridLayoutManager = new StaggeredGridLayoutManager(orientation, spanCount);
			recyclerView.setLayoutManager(gridLayoutManager);
			gridLayoutManager.setOrientation(orientation);
			
			}
			break;
		default:
			break;
		}
	}
	
	private void reloadTable() {
		if (!disableUpdate && adapter != null) {
			adapter.notifyDataSetChanged();
		}
	}
	
	private List<String> viewHolderIds;
	private List<String> headerViewHolderIds;
	private List<String> footerViewHolderIds;
	Map<String, Object> layout;
	private void setViewHolderIds(Object objValue) {
		viewHolderIds = (List<String>) objValue;
	
	}
	
	
	private int spanCount = 0;
	private void setSpanCount(Object objValue) {
		spanCount = (int) objValue;
		
		if (isInitialised()) {
			if (recyclerView.getLayoutManager() instanceof GridLayoutManager) {
				if (adapter instanceof GroupieAdapter) {
					((GroupieAdapter)adapter).setSpanCount(spanCount);
				} else {
					((GridLayoutManager)recyclerView.getLayoutManager()).setSpanCount(spanCount);
				}
			}
			
			if (recyclerView.getLayoutManager() instanceof StaggeredGridLayoutManager) {
				((StaggeredGridLayoutManager)recyclerView.getLayoutManager()).setSpanCount(spanCount);
			}
		}
	}
	
	private int orientation = RecyclerView.VERTICAL;
	private void setOrientation(Object objValue) {
		orientation = (int) objValue;
		if (isInitialised()) {
			if (recyclerView.getLayoutManager() instanceof GridLayoutManager) {
				((GridLayoutManager)recyclerView.getLayoutManager()).setOrientation(orientation);
			}
			if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
				((LinearLayoutManager)recyclerView.getLayoutManager()).setOrientation(orientation);
			}
			if (recyclerView.getLayoutManager() instanceof StaggeredGridLayoutManager) {
				((StaggeredGridLayoutManager)recyclerView.getLayoutManager()).setOrientation(orientation);
			}
		}
	}
	
	private int getOrientation() {
		return orientation;
	}
	
	public boolean isHorizontal() {
		return getOrientation() == RecyclerView.HORIZONTAL;
	}
	
	private void setLayout(Object objValue) {
		String value = (String) objValue;
		
		String inlineResource = fragment.getInlineResource(value);
		String json;
		if (inlineResource == null) {
			json = com.ashera.utils.ResourceBundleUtils.getString("xml/recycler", value.replace("@xml/", ""), fragment);
		} else {
			json = PluginInvoker.xml2json(inlineResource, fragment);
		}
		Map<String, Object> configMap =  PluginInvoker.unmarshal(json, Map.class);
		this.layout =  PluginInvoker.getMap(configMap.get("layout"));
		
		// simple case
		if (layout.get("@adapter").equals("simple")) {
			if (recyclerView.getLayoutManager() instanceof GridLayoutManager) {
				((GridLayoutManager)recyclerView.getLayoutManager()).setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
	
					@Override
					public int getSpanSize(int position) {
						if (headerTemplate != null && position == 0) {
							return spanCount;
						}
						if (footerTemplate != null && !footerDisabled && position == adapter.getItemCount() -1) {
							return spanCount;
						}
						return 1;
					}
					
				});
			}
			Map<String, Object> headerMap = PluginInvoker.getMap(layout.get("header"));
			if (headerMap != null) {
				headerTemplate = (IWidget) quickConvert(headerMap.get("@layout"), com.ashera.converter.CommonConverters.template);
				Object viewHolderIds = headerMap.get("@viewHolderIds");
				if (viewHolderIds != null) {
					this.headerViewHolderIds = (List<String>) quickConvert(viewHolderIds, CommonConverters.array, "list", null);
				}
			}
			
			Map<String, Object> footerMap = PluginInvoker.getMap(layout.get("footer"));
			if (footerMap != null) {
				footerTemplate = (IWidget) quickConvert(footerMap.get("@layout"), com.ashera.converter.CommonConverters.template);
				
				Object viewHolderIds = footerMap.get("@viewHolderIds");
				if (viewHolderIds != null) {
					this.footerViewHolderIds = (List<String>) quickConvert(viewHolderIds, CommonConverters.array, "list", null);
				}

			}
			
			Map<String, Object> itemMap = PluginInvoker.getMap(layout.get("item"));
			if (itemMap != null) {
				Object viewHolderIds = itemMap.get("@viewHolderIds");

				if (viewHolderIds != null) {
					this.viewHolderIds = (List<String>) quickConvert(viewHolderIds, CommonConverters.array, "list", null);
				}
				Object layoutItem = itemMap.get("@layout");
				if (layoutItem != null) {
					listItem = (IWidget) quickConvert(layoutItem, com.ashera.converter.CommonConverters.template);
				}
			}
		} 
		
		// groupie case
		if (layout.get("@adapter").equals("groupie")) {
			if (layout.containsKey("section")) {
				GroupieAdapter groupieAdapter = createGroupieAdapter();
				
				adapter = groupieAdapter;
				recyclerView.setAdapter(adapter);

				if (recyclerView.getLayoutManager() instanceof GridLayoutManager) {
					((GridLayoutManager)recyclerView.getLayoutManager()).setSpanSizeLookup(groupieAdapter.getSpanSizeLookup());
				}
				recyclerView.addItemDecoration(new InsetItemDecoration());

				createSections(groupieAdapter);
			}
		}
	}

	private GroupieAdapter createGroupieAdapter() {
		GroupieAdapter groupieAdapter = new GroupieAdapter();
		groupieAdapter.setHasStableIds(true);
		groupieAdapter.setSpanCount(spanCount);
		return groupieAdapter;
	}

	private void createSections(GroupieAdapter groupieAdapter) {
		List<Object> sections = PluginInvoker.getList(layout.get("section"));

		if (sections == null) {
			createSections(groupieAdapter, layout.get("section"), null);
		} else {
			for (Object section : sections) {
				createSections(groupieAdapter, section, null);
			}
		}
	}

	private void createSections(Object group, Object sectionObj, com.ashera.model.LoopParam pLoopParam) {
		Map<String, Object> sectionMap = PluginInvoker.getMap(sectionObj);
		if (sectionMap != null) { 
			if (sectionMap.containsKey("@modelFor")) {
				String modelFor = PluginInvoker.getString(sectionMap.get("@modelFor"));
				if (modelFor != null) {
					com.ashera.model.ModelExpressionParser.ModelLoopHolder modelLoopHolder = com.ashera.model.ModelExpressionParser.parseModelLoopExpression(modelFor);
	
					//let x in . from y->intent into view as pathmap
					Object obj = getModelFromScope(modelLoopHolder.key, modelLoopHolder.varSource);
					obj = getModelByPath(modelLoopHolder.varPath, obj);
	
					if (obj != null) {
						for (Object model: PluginInvoker.getList(obj)) {
							model = changeModelDataType(modelLoopHolder.dataType, model);
							
							if (filterData(model, this.filterSectionPaths)) {
								com.ashera.model.LoopParam loopParam = new com.ashera.model.LoopParam();
								storeModelToScope(modelLoopHolder.varName, modelLoopHolder.varScope, model, loopParam);
								addSection(group, sectionMap, loopParam);
							}
						}
					}
				}
			} else if (sectionMap.containsKey("@modelVar")) {
				String modelVar = PluginInvoker.getString(sectionMap.get("@modelVar"));
				if (modelVar != null) {
					List<com.ashera.model.ModelExpressionParser.ModelVarHolder> modelVarHolders = com.ashera.model.ModelExpressionParser.parseModelVarExpression(modelVar);
					com.ashera.model.LoopParam loopParam = new com.ashera.model.LoopParam();
					for (com.ashera.model.ModelExpressionParser.ModelVarHolder modelVarHolder : modelVarHolders) {
						//let x in . from y->intent into view as pathmap
						Object obj = getModelFromScope(modelVarHolder.key, modelVarHolder.varSource);
						obj = getModelByPath(modelVarHolder.varPath, obj);
						obj = changeModelDataType(modelVarHolder.dataType, obj);
						storeModelToScope(modelVarHolder.varName, modelVarHolder.varScope, obj, loopParam);
					}
					
					addSection(group, sectionMap, loopParam);
				}
			} else {
				addSection(group, sectionMap, pLoopParam);
			}
		}
	}

	private void createExpandable(Map<String, Object> sectionMap, com.xwray.groupie.Section section, com.ashera.model.LoopParam pLoopParam) {
		
		Map<String, Object> itemMap = PluginInvoker.getMap(sectionMap.get("expandable"));
		if (itemMap != null) {
			Object layout = itemMap.get("@layout");
			IWidget template = (IWidget) quickConvert(layout, CommonConverters.template);
			Object viewHolderId = itemMap.get("@viewHolderIds");
			List<String>  viewHolderIds = null;
			List<String> onClickIds = null;
			if (viewHolderId != null) {
				viewHolderIds = (List<String>) quickConvert(viewHolderId, CommonConverters.array, "list", null);
			}
			int margin = 0;
			if (itemMap.containsKey("@gridInsets")) {
				margin = (int) quickConvert(itemMap.get("@gridInsets"), CommonConverters.dimension);
			}
			
			if (itemMap.containsKey("@onclick")) {
				onClickIds = (List<String>) quickConvert(itemMap.get("@onclick"), CommonConverters.array, "list", null);
			}

			GenericExpandableItem item = new GenericExpandableItem(layout.toString(), template, pLoopParam, viewHolderIds, onClickIds);
			item.setMargin(margin);
		
			com.xwray.groupie.ExpandableGroup expandableGroup = new com.xwray.groupie.ExpandableGroup(item);
			expandableGroup.setExpanded(itemMap.containsKey("@expand") && PluginInvoker.getBoolean(itemMap.get("@expand")));
			section.add(expandableGroup);
			
			if (itemMap.containsKey("section")) {
				createSections(expandableGroup, itemMap.get("section"), pLoopParam);
			}
		}
	}
	
	private void addSection(Object group, Object sectionObj, com.ashera.model.LoopParam loopParam) {
		Map<String, Object> sectionMap = PluginInvoker.getMap(sectionObj);
		com.xwray.groupie.Section section = new com.xwray.groupie.Section();
		SectionHolder sectionHolder = new SectionHolder();
		sectionHolder.section = section;
		sectionHolder.loopParam = loopParam;
		if (sectionMap.containsKey("@idPath")) { 
			String path = PluginInvoker.getString(sectionMap.get("@idPath"));
			com.ashera.model.ModelExpressionParser.ModelFromScopeHolder modelFromScopeHolder = com.ashera.model.ModelExpressionParser.parseModelFromScope(path);
			Object obj = getModelFromScope(modelFromScopeHolder.varName, modelFromScopeHolder.varScope, loopParam);
			obj = getModelByPath(modelFromScopeHolder.varPath, obj);
			
			this.sectionMap.put(PluginInvoker.getString(obj), sectionHolder);
		} else if (sectionMap.containsKey("@id")) {
			this.sectionMap.put(PluginInvoker.getString(sectionMap.get("@id")), sectionHolder);
		}
		
		sectionHolder.sectionConfigAttrs =  sectionMap;

		createHeader(loopParam, section, sectionMap);

		createFooter(loopParam, section, sectionMap);

		createItems(sectionMap, section, loopParam);
		
		createExpandable(sectionMap, section, loopParam);
		
		// child sections
		if (sectionMap.containsKey("section")) {
			createSections(section, sectionMap.get("section"), loopParam);
		}
		
		if (group instanceof GroupieAdapter) {
			((GroupieAdapter)group).add(section);	
		} else if (group instanceof com.xwray.groupie.ExpandableGroup) {
			((com.xwray.groupie.ExpandableGroup)group).add(section);	
		} else if (group instanceof com.xwray.groupie.Section) {
			((com.xwray.groupie.Section)group).add(section);	
		}
		
	}

	private void createItems(Map<String, Object> sectionMap, com.xwray.groupie.Section section, com.ashera.model.LoopParam pLoopParam) {
		Map<String, Object> itemMap = PluginInvoker.getMap(sectionMap.get("item"));
		if (itemMap != null) {
			if (itemMap.containsKey("@id")) {
				this.itemConfigMap.put(PluginInvoker.getString(itemMap.get("@id")), itemMap);
			}
			createItem(section, itemMap, pLoopParam, null);
		}
	}

	private void createItem(com.xwray.groupie.Section section, Map<String, Object> itemMap,
			com.ashera.model.LoopParam pLoopParam, Object myitem) {
		int numberOfColumns = 1;
		if (itemMap.containsKey("@numberOfColumns")) {
			numberOfColumns = (int) quickConvert(itemMap.get("@numberOfColumns"), CommonConverters.intconverter);
		}
		Object layout = itemMap.get("@layout");
		IWidget template = (IWidget) quickConvert(layout, CommonConverters.template);
		Object viewHolderId = itemMap.get("@viewHolderIds");
		List<String>  viewHolderIds = null;
		if (viewHolderId != null) {
			viewHolderIds = (List<String>) quickConvert(viewHolderId, CommonConverters.array, "list", null);
		}

		int margin = 0;
		if (itemMap.containsKey("@gridInsets")) {
			margin = (int) quickConvert(itemMap.get("@gridInsets"), CommonConverters.dimension);
		}
		
		int swipeDirs = -1;
		if (itemMap.containsKey("@swipeDirs")) {
			swipeDirs = (int) quickConvert(itemMap.get("@swipeDirs"), "androidx.recyclerview.widget.RecyclerView.swipeDirs");
		}
		
		int dragDirs = -1;
		if (itemMap.containsKey("@dragDirs")) {
			dragDirs = (int) quickConvert(itemMap.get("@dragDirs"), "androidx.recyclerview.widget.RecyclerView.dragDirs");
		}
		
		boolean dragAcrossSections = false;
		
		if (itemMap.containsKey("@dragAcrossSections")) {
			dragAcrossSections = (boolean) quickConvert(itemMap.get("@dragAcrossSections"), "boolean");
		}
		if (itemMap.containsKey("@modelFor")) {
			String modelFor = PluginInvoker.getString(itemMap.get("@modelFor"));
			com.ashera.model.ModelExpressionParser.ModelLoopHolder modelLoopHolder = com.ashera.model.ModelExpressionParser.parseModelLoopExpression(modelFor);

			//let x in . from y->intent into view as pathmap
			Object obj = null;
			// add item to existing section list
			if (myitem == null) {
				obj = getModelFromScope(modelLoopHolder.key, modelLoopHolder.varSource, pLoopParam);
				obj = getModelByPath(modelLoopHolder.varPath, obj);
			} else {
				obj = myitem;
			}

			if (obj != null) {
				List<Object> list = PluginInvoker.getList(obj);
				
				if (list != null) {
					for (Object model: list) {
						model = changeModelDataType(modelLoopHolder.dataType, model);
						
						if (filterData(model)) {
							com.ashera.model.LoopParam loopParam = new com.ashera.model.LoopParam();
							storeModelToScope(modelLoopHolder.varName, modelLoopHolder.varScope, model, loopParam);
							GenericItem item = new GenericItem(layout.toString(), template, loopParam, viewHolderIds, section);
							item.setNumberOfColums(numberOfColumns);
							item.setDragDirs(dragDirs);
							item.setSwipeDirs(swipeDirs);
							item.setMargin(margin);
							item.setDragAcrossSections(dragAcrossSections);
							section.add(item);
						}
					}
				} else {
					Map<String, Object> map = PluginInvoker.getMap(obj);
					
					if (map != null) {
						obj = changeModelDataType(modelLoopHolder.dataType, obj);
						com.ashera.model.LoopParam loopParam = new com.ashera.model.LoopParam();
						storeModelToScope(modelLoopHolder.varName, modelLoopHolder.varScope, obj, loopParam);
						GenericItem item = new GenericItem(layout.toString(), template, loopParam, viewHolderIds, section);
						item.setNumberOfColums(numberOfColumns);
						item.setDragDirs(dragDirs);
						item.setSwipeDirs(swipeDirs);
						item.setMargin(margin);
						item.setDragAcrossSections(dragAcrossSections);
						section.add(item);
					}
				}
			}
		}  else if (itemMap.containsKey("@modelVar")) {
			String modelVar = PluginInvoker.getString(itemMap.get("@modelVar"));
			if (modelVar != null) {
				List<com.ashera.model.ModelExpressionParser.ModelVarHolder> modelVarHolders = com.ashera.model.ModelExpressionParser.parseModelVarExpression(modelVar);
				com.ashera.model.LoopParam loopParam = new com.ashera.model.LoopParam();
				for (com.ashera.model.ModelExpressionParser.ModelVarHolder modelVarHolder : modelVarHolders) {
					//let x in . from y->intent into view as pathmap
					Object obj = null;
					if (myitem == null) {
						obj = getModelFromScope(modelVarHolder.key, modelVarHolder.varSource);
						obj = getModelByPath(modelVarHolder.varPath, obj);
					} else {
						obj = myitem;
					}
					obj = changeModelDataType(modelVarHolder.dataType, obj);
					storeModelToScope(modelVarHolder.varName, modelVarHolder.varScope, obj, loopParam);
				}
				
				GenericItem item = new GenericItem(layout.toString(), template, loopParam, viewHolderIds, section);
				item.setNumberOfColums(numberOfColumns);
				item.setDragDirs(dragDirs);
				item.setSwipeDirs(swipeDirs);
				item.setMargin(margin);
				item.setDragAcrossSections(dragAcrossSections);
				section.add(item);
			}
		} else {
			GenericItem item = new GenericItem(layout.toString(), template, pLoopParam, viewHolderIds, section);
			item.setNumberOfColums(numberOfColumns);
			item.setDragDirs(dragDirs);
			item.setSwipeDirs(swipeDirs);
			item.setMargin(margin);
			item.setDragAcrossSections(dragAcrossSections);
			section.add(item);
		}
	}

	private void createFooter(com.ashera.model.LoopParam loopParam, com.xwray.groupie.Section section, Map<String, Object> sectionMap) {
		Map<String, Object> footerMap = PluginInvoker.getMap(sectionMap.get("footer"));
		if (footerMap != null) {
			Object layout = footerMap.get("@layout");
			IWidget template = (IWidget) quickConvert(layout, CommonConverters.template);
			
			Object viewHolderId = footerMap.get("@viewHolderIds");
			List<String>  viewHolderIds = null;
			if (viewHolderId != null) {
				viewHolderIds = (List<String>) quickConvert(viewHolderId, CommonConverters.array, "list", null);
			}

			int swipeDirs = -1;
			if (footerMap.containsKey("@swipeDirs")) {
				swipeDirs = (int) quickConvert(footerMap.get("@swipeDirs"), "androidx.recyclerview.widget.RecyclerView.swipeDirs");
			}
			
			int dragDirs = -1;
			if (footerMap.containsKey("@dragDirs")) {
				dragDirs = (int) quickConvert(footerMap.get("@dragDirs"), "androidx.recyclerview.widget.RecyclerView.dragDirs");
			}
			
			boolean dragAcrossSections = false;
			
			if (footerMap.containsKey("@dragAcrossSections")) {
				dragAcrossSections = (boolean) quickConvert(footerMap.get("@dragAcrossSections"), "boolean");
			}
			GenericItem footer = new GenericItem(layout.toString(), template, loopParam, viewHolderIds, section);
			footer.setDragDirs(dragDirs);
			footer.setSwipeDirs(swipeDirs);
			footer.setDragAcrossSections(dragAcrossSections);
			section.setFooter(footer);
		}
	}

	private void createHeader(com.ashera.model.LoopParam loopParam, com.xwray.groupie.Section section, Map<String, Object> sectionMap) {
		Map<String, Object> headerMap = PluginInvoker.getMap(sectionMap.get("header"));
		if (headerMap != null) {
			Object layout = headerMap.get("@layout");
			IWidget template = (IWidget) quickConvert(layout, CommonConverters.template);
			
			Object viewHolderId = headerMap.get("@viewHolderIds");
			List<String>  viewHolderIds = null;
			if (viewHolderId != null) {
				viewHolderIds = (List<String>) quickConvert(viewHolderId, CommonConverters.array, "list", null);
			}
			
			int swipeDirs = -1;
			if (headerMap.containsKey("@swipeDirs")) {
				swipeDirs = (int) quickConvert(headerMap.get("@swipeDirs"), "androidx.recyclerview.widget.RecyclerView.swipeDirs");
			}
			
			int dragDirs = -1;
			if (headerMap.containsKey("@dragDirs")) {
				dragDirs = (int) quickConvert(headerMap.get("@dragDirs"), "androidx.recyclerview.widget.RecyclerView.dragDirs");
			}
			
			boolean dragAcrossSections = false;
			if (headerMap.containsKey("@dragAcrossSections")) {
				dragAcrossSections = (boolean) quickConvert(headerMap.get("@dragAcrossSections"), "boolean");
			}
			GenericItem header = new GenericItem(layout.toString(), template, loopParam, viewHolderIds, section);
			header.setDragDirs(dragDirs);
			header.setSwipeDirs(swipeDirs);
			header.setDragAcrossSections(dragAcrossSections);
			section.setHeader(header);
		}
	}

	class SectionHolder {
		Map<String, Object> sectionConfigAttrs;
		com.xwray.groupie.Section section;
		com.ashera.model.LoopParam loopParam;
	}
	private Map<String, SectionHolder> sectionMap = new HashMap<>();
	private Map<String, Map<String, Object>> itemConfigMap = new HashMap<>();
	
	@com.google.j2objc.annotations.WeakOuter
	public class GenericExpandableItem extends GenericItem implements com.xwray.groupie.ExpandableItem{
		@com.google.j2objc.annotations.WeakOuter
		private final class ExpandableClickListener implements View.OnClickListener {
			private final int position;
			private IWidget widget;
			private ExpandableClickListener(int position, IWidget widget) {
				this.position = position;
				this.widget = widget;
			}

			@Override
			public void onClick(View arg0) {
				recyclerView.requestLayout();
				expandableGroup.setExpanded(!expandableGroup.isExpanded());
				widget.setAttribute("selected", expandableGroup.isExpanded(), true);
				fragment.remeasure();
			}
		}

		private com.xwray.groupie.ExpandableGroup expandableGroup;
		private List<String> onClickIds;
		public GenericExpandableItem(String layout, IWidget template, com.ashera.model.LoopParam loopParam, List<String> viewHolderIds, List<String> onClickIds) {
			super(layout, template, loopParam, viewHolderIds, null);
			this.onClickIds = onClickIds;
		}


		@Override
		public void setExpandableGroup(com.xwray.groupie.ExpandableGroup expandableGroup) {
			this.expandableGroup =  expandableGroup;
		}
		
		@Override
		public void bind(GroupieViewHolder viewHolder, int position) {
			super.bind(viewHolder, position);
			if (onClickIds != null) {
				IWidget widget = viewHolder.widgetViewHolder.widget;
				
				for (String onClickId : onClickIds) {
					if (!onClickId.startsWith("@+id/")) {
						onClickId = "@+id/" + onClickId; 
					}
					IWidget onClickWidget = widget;
					if (!onClickId.equals(widget.getId())) {
						onClickWidget  =  widget.findWidgetById(onClickId);
					}
					onClickWidget.setAttribute("onClick", new ExpandableClickListener(position, onClickWidget), true);
					onClickWidget.setAttribute("selected", this.expandableGroup.isExpanded(), true);
				}
				
				
			}
		}
	}
	public class GenericItem extends com.xwray.groupie.Item<GroupieViewHolder>{
		private IWidget template;
		private com.ashera.model.LoopParam loopParam;
		private List<String> viewHolderIds;
		private String layout;
		private com.xwray.groupie.Section section;
		private int margin;
		private boolean modified;
		int numberOfColums = 1;
		private int dragDirs = -1;
		private int swipeDirs = -1;
		private boolean dragAcrossSections;
		
		public boolean isDragAcrossSections() {
			return dragAcrossSections;
		}
		public void setDragAcrossSections(boolean dragAcrossSections) {
			this.dragAcrossSections = dragAcrossSections;
		}
		@Override
		public int getDragDirs() {
			return dragDirs;
		}
		public void setDragDirs(int dragDirs) {
			this.dragDirs = dragDirs;
		}
		
		@Override
		public int getSwipeDirs() {
			return swipeDirs;
		}
		public void setSwipeDirs(int swipeDirs) {
			this.swipeDirs = swipeDirs;
		}
		public boolean isModified() {
			return modified;
		}
		public void setModified(boolean modified) {
			this.modified = modified;
		}

		public void setNumberOfColums(int numberOfColums) {
			this.numberOfColums = numberOfColums;
		}
		@Override
	    public int getSpanSize(int spanCount, int position) {
	        return spanCount/numberOfColums;
	    }

		public int getMargin() {
			return margin;
		}

		public void setMargin(int margin) {
			this.margin = margin;
		}

		public GenericItem(String layout, IWidget template, com.ashera.model.LoopParam loopParam, List<String> viewHolderIds, com.xwray.groupie.Section section) {
			this.template = template;
			this.loopParam = loopParam;
			this.layout = layout;
			this.viewHolderIds = viewHolderIds;
			this.section = section;
		}

		public List<String> getViewHolderIds() {
			return viewHolderIds;
		}

		public com.ashera.model.LoopParam getLoopParam() {
			return loopParam;
		}

		@Override
		public void bind(GroupieViewHolder viewHolder, int position) {
			setAttributeOnViewHolder(viewHolder.widgetViewHolder, loopParam, modified);
			modified = false;
		}

		@Override
		public int getLayout() {
			return (int) quickConvert(layout, "id");
		}

		public IWidget getTemplate() {
			return template;
		}
		
		public com.xwray.groupie.Section getSection() {
			return section;
		}
		
		public void setSection(com.xwray.groupie.Section section) {
			this.section = section;
		}
	}
	
	public class GroupieAdapter extends com.xwray.groupie.GroupAdapter<GroupieViewHolder> implements ItemActionHandler {
		@Override
		public int getSwipeDirs(ViewHolder viewHolder) {
			if (viewHolder instanceof GroupieViewHolder) {
				return ((GroupieViewHolder) viewHolder).getSwipeDirs();
			}
			return -1;
		}

		@Override
		public int getDragDirs(ViewHolder viewHolder) {
			if (viewHolder instanceof GroupieViewHolder) {
				return ((GroupieViewHolder) viewHolder).getDragDirs();
			}
			return -1;
		}
		@Override
		public void onItemMove(int fromPosition, int toPosition, String mode) {
			com.xwray.groupie.Item<GroupieViewHolder> item = getItem(fromPosition);
			com.xwray.groupie.Item<GroupieViewHolder> targetItem = getItem(toPosition);
			
			if (item instanceof GenericItem && targetItem instanceof GenericItem) {
				GenericItem genericItem = (GenericItem)item;
				GenericItem targetGenericItem = (GenericItem)targetItem;
				
				if (genericItem.getLayout() == targetGenericItem.getLayout()) {
					com.xwray.groupie.Section section = genericItem.getSection();
					com.xwray.groupie.Section dragSection = targetGenericItem.getSection();
	
					if (dragSection != null && section == dragSection) {
						List<com.xwray.groupie.Group> dragItems = section.getGroups();
			            int targetIndex = dragItems.indexOf(targetItem);
			            dragItems.remove(item);
		
			            // if item gets moved out of the boundary
			            if (targetIndex == -1) {
			                if (toPosition < fromPosition) {
			                    targetIndex = 0;
			                } else {
			                    targetIndex = dragItems.size() - 1;
			                }
			            }
			            
			            dragItems.add(targetIndex, item);
			            dragSection.update(dragItems);
					} else {
						if (genericItem.isDragAcrossSections() && section != null && dragSection != null && section != dragSection) {

						    List<com.xwray.groupie.Group> sourceItems =
						            new ArrayList<>(section.getGroups());

						    List<com.xwray.groupie.Group> targetItems =
						            new ArrayList<>(dragSection.getGroups());

						    int sourceIndex = sourceItems.indexOf(item);
						    int targetIndex = targetItems.indexOf(targetItem);

						    if (sourceIndex == -1 || targetIndex == -1) {
						        return;
						    }

						    sourceItems.remove(sourceIndex);

						    targetItems.add(targetIndex, item);
						    genericItem.setSection(dragSection);

						    section.update(sourceItems);
						    dragSection.update(targetItems);
						}
					}
				}
			}
		}

		@Override
		public void onItemRemove(int position, String mode) {
			com.xwray.groupie.Item<GroupieViewHolder> item = getItem(position);
			if (item instanceof GenericItem) {
				 GenericItem genericItem = (GenericItem)item;
				 com.xwray.groupie.Section section = genericItem.getSection();
				 section.remove(item);
			 }
		}

		@Override
		public boolean isDragEnabled(ViewHolder viewHolder) {
			 com.xwray.groupie.Item<GroupieViewHolder> item = getItem(viewHolder.getAdapterPosition());
			 
			 if (item instanceof GenericItem) {
				 GenericItem genericItem = (GenericItem) item;
				 com.xwray.groupie.Section section = genericItem.getSection();
				 return section != null;
			 }
			return false;
		}
		@Override
		public void onViewAttachedToWindow(GroupieViewHolder holder) {
			super.onViewAttachedToWindow(holder);
			holder.itemView.setVisibility(View.VISIBLE);
		}
		
		@Override
		public void onViewDetachedFromWindow(GroupieViewHolder holder) {
			super.onViewDetachedFromWindow(holder);
			holder.itemView.setVisibility(View.INVISIBLE);
		}

		@Override
		public GroupieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			GenericItem item = (GenericItem) getItemForViewType(viewType);
			IWidget widget = (IWidget) item.getTemplate().loadLazyWidgets(item.getLoopParam());
			if (widgets.indexOf(widget) == -1) {
				widgets.add(widget);
			}
			View itemView = (View) widget.asWidget();
			setItemViewParams(widget, itemView);
			GroupieViewHolder viewHolder = new GroupieViewHolder(widget, itemView, item.getViewHolderIds());
			widget.storeInTempCache("insets", item.getMargin());
			return viewHolder;
		}
	}
	
	public class GroupieViewHolder extends com.xwray.groupie.GroupieViewHolder {
		WidgetViewHolder widgetViewHolder;
		public GroupieViewHolder(IWidget widget, View itemView, List<String> viewHolderIds) {
			super(itemView);

			if (viewHolderIds != null) {
				widgetViewHolder = createWidgetViewHolder(viewHolderIds, widget);
			}
		}
	}
	

	public void setItemViewParams(IWidget widget, View itemView) {
		int itemViewWidth = (int) ConverterFactory.get(CommonConverters.dimension).convertFrom(widget.getAttributeValue("layout_width"), null, fragment);
		int itemViewHeight = (int) ConverterFactory.get(CommonConverters.dimension).convertFrom(widget.getAttributeValue("layout_height"), null, fragment);
		

		ViewGroup.LayoutParams lp = new GridLayoutManager.LayoutParams(itemViewWidth, itemViewHeight);
		
		int itemMargin = (int) ConverterFactory.get(CommonConverters.dimension).convertFrom(widget.getAttributeValue("layout_margin"), null, fragment);
		if (itemMargin != -2) {
			ViewGroupImpl.setMargin(itemMargin, lp, widget);
		}
		
		int itemMarginTop = (int) ConverterFactory.get(CommonConverters.dimension).convertFrom(widget.getAttributeValue("layout_marginTop"), null, fragment);
		int itemMarginBottom = (int) ConverterFactory.get(CommonConverters.dimension).convertFrom(widget.getAttributeValue("layout_marginBottom"), null, fragment);
		int itemMarginLeft = (int) ConverterFactory.get(CommonConverters.dimension).convertFrom(widget.getAttributeValue("layout_marginStart"), null, fragment);
		int itemMarginRight = (int) ConverterFactory.get(CommonConverters.dimension).convertFrom(widget.getAttributeValue("layout_marginEnd"), null, fragment);
		
		if (itemMarginTop != -2) {
			ViewGroupImpl.setTopMargin(itemMarginTop, lp);
		}
		
		if (itemMarginBottom != -2) {
			ViewGroupImpl.setBottomMargin(itemMarginBottom, lp);
		}
		
		if (itemMarginLeft != -2) {
			ViewGroupImpl.setStartMargin(itemMarginLeft, lp, widget);
		}
		
		if (itemMarginRight != -2) {
			ViewGroupImpl.setEndMargin(itemMarginRight, lp, widget);
		}
		
		itemView.setLayoutParams(lp);
	}
	
	
	private void addSectionItem(String sectionId, String itemConfigId, Object item) {
		if (adapter instanceof GroupieAdapter) {
			if (sectionMap != null) {
				SectionHolder sectionHolder = sectionMap.get(sectionId);
				Map<String, Object> itemConfig = this.itemConfigMap.get(itemConfigId);
				if (itemConfig.containsKey("@itemsPath")) {
					List<Object> list = getChildItems(sectionHolder, itemConfig);
					if (list != null) {
						list.add(item);
					}
					notifyDataSetChanged(sectionHolder);
				} else {
					if (itemConfig.containsKey("@modelFor")) {
						List<Object> list = getModelChildItems(itemConfig, sectionHolder.loopParam);
						if (list != null) {
							list.addAll((List) item);
						}
					}
					

					createItem(sectionHolder.section, itemConfig, sectionHolder.loopParam, item);
				}
			}
		}
	}

	private List<Object> getModelChildItems(Map<String, Object> itemConfig, com.ashera.model.LoopParam loopParam) {
		String modelFor = PluginInvoker.getString(itemConfig.get("@modelFor"));
		com.ashera.model.ModelExpressionParser.ModelLoopHolder modelLoopHolder = com.ashera.model.ModelExpressionParser
				.parseModelLoopExpression(modelFor);

		Object obj = null;
		obj = getModelFromScope(modelLoopHolder.key, modelLoopHolder.varSource, loopParam);
		obj = getModelByPath(modelLoopHolder.varPath, obj);
		List<Object> list = PluginInvoker.getList(obj);
		return list;
	}

	private void notifyDataSetChanged(SectionHolder sectionHolder) {
		for (Object g : sectionHolder.section.getGroups()) {
			if (g instanceof GenericItem) {
				((GenericItem) g).setModified(true);
			}
		}
		adapter.notifyDataSetChanged();
	}

	public List<Object> getChildItems(SectionHolder sectionHolder, Map<String, Object> itemConfig) {
		String path = PluginInvoker.getString(itemConfig.get("@itemsPath"));
		com.ashera.model.ModelExpressionParser.ModelFromScopeHolder modelFromScopeHolder = com.ashera.model.ModelExpressionParser.parseModelFromScope(path);
		Object obj = getModelFromScope(modelFromScopeHolder.varName, modelFromScopeHolder.varScope, sectionHolder.loopParam);
		obj = getModelByPath(modelFromScopeHolder.varPath, obj);
		List<Object> list = PluginInvoker.getList(obj);
		return list;
	}

	
	private void removeSectionItem(String sectionId, String itemConfigId, String itemId) {
		if (adapter instanceof GroupieAdapter) {
			if (sectionMap != null) {
				SectionHolder sectionHolder = sectionMap.get(sectionId);
				Map<String, Object> itemConfig = this.itemConfigMap.get(itemConfigId);
				
				
				if (itemConfig.containsKey("@itemsPath")) {
					List<Object> list = getChildItems(sectionHolder, itemConfig);
					if (itemConfig.containsKey("@idPath")) {
						String path = PluginInvoker.getString(itemConfig.get("@idPath"));
						com.ashera.model.ModelExpressionParser.ModelFromScopeHolder modelFromScopeHolder = com.ashera.model.ModelExpressionParser
								.parseModelFromScope(path);

						for (int i = 0; i < list.size(); i++) {
							Object obj = getModelByPath(modelFromScopeHolder.varPath, list.get(i));
							if (itemId.equals(obj)) {
								list.remove(i);
								break;
							}
						}
					}
					notifyDataSetChanged(sectionHolder);
				} else {
					int itemCount = sectionHolder.section.getItemCount();
					
					if (itemConfig.containsKey("@idPath")) { 
						String path = PluginInvoker.getString(itemConfig.get("@idPath"));
						com.ashera.model.ModelExpressionParser.ModelFromScopeHolder modelFromScopeHolder = com.ashera.model.ModelExpressionParser.parseModelFromScope(path);
						if (itemConfig.containsKey("@modelFor")) {
							List<Object> list = getModelChildItems(itemConfig, sectionHolder.loopParam);
							syncObjectRemoveSectionItem(itemId, modelFromScopeHolder.varPath, list);
						}						
						for (int i = itemCount - 1; i >= 0; i--) {
							com.xwray.groupie.Item<GroupieViewHolder> item = sectionHolder.section.getItem(i);
							if (item instanceof GenericItem) {
								Object obj = getModelFromScope(modelFromScopeHolder.varName, modelFromScopeHolder.varScope, ((GenericItem) item).getLoopParam());
								obj = getModelByPath(modelFromScopeHolder.varPath, obj);
								if (itemId.equals(obj)) {
									sectionHolder.section.remove(item);
								}
							}
						}
					}				
				}
			}
		}
	}


	private void syncObjectRemoveSectionItem(String itemId, String idPath, List<Object> list) {
		for (int j = list.size() - 1; j >= 0; j--) {
			Object model = list.get(j);
			Object id =  getModelByPath(idPath, model);
			if (itemId.equals(id)) {
				list.remove(model);
			}
		}
	}
	
	private void syncObjectUpdateSectionItem(String itemId, String idPath, List<Object> list, Object item) {
		for (int j = list.size() - 1; j >= 0; j--) {
			Object model = list.get(j);
			Object id =  getModelByPath(idPath, model);
			if (itemId.equals(id)) {
				list.set(j, item);
			}
		}
	}

	
	
	
	private void removeAllItems(String sectionId, String myitemConfigId) {
		if (adapter instanceof GroupieAdapter) {
			if (sectionMap != null) {
				SectionHolder sectionHolder = sectionMap.get(sectionId);
				
				if (sectionHolder.sectionConfigAttrs.containsKey("@removeAllItemIdHint")) {
					String[] itemConfigIds = PluginInvoker.getString(sectionHolder.sectionConfigAttrs.get("@removeAllItemIdHint")).split(",");
					
					for (String itemConfigId : itemConfigIds) {
						Map<String, Object> itemConfig = this.itemConfigMap.get(itemConfigId);
						
						if (itemConfig.containsKey("@itemsPath")) {
							List<Object> list = getChildItems(sectionHolder, itemConfig);
							if (list != null) {
								list.clear();
							}
							notifyDataSetChanged(sectionHolder);
						} else {
							sectionHolder.section.clear();
						}
					}
				} else {
					Map<String, Object> itemConfig = this.itemConfigMap.get(myitemConfigId);
					if (itemConfig.containsKey("@modelFor")) {
						List<Object> list = getModelChildItems(itemConfig, sectionHolder.loopParam);
						list.clear();
					}
					sectionHolder.section.clear();
				}
			}
		}		
	}
	
	
	private void updateSectionItem(String sectionId, String itemConfigId, String itemId, Object newData) {
		if (adapter instanceof GroupieAdapter) {
			if (sectionMap != null) {
				SectionHolder sectionHolder = sectionMap.get(sectionId);
				Map<String, Object> itemConfig = this.itemConfigMap.get(itemConfigId);
				
				if (itemConfig.containsKey("@itemsPath")) {
					List<Object> list = getChildItems(sectionHolder, itemConfig);
					if (itemConfig.containsKey("@idPath")) {
						String path = PluginInvoker.getString(itemConfig.get("@idPath"));
						com.ashera.model.ModelExpressionParser.ModelFromScopeHolder modelFromScopeHolder = com.ashera.model.ModelExpressionParser
								.parseModelFromScope(path);

						for (int i = 0; i < list.size(); i++) {
							Object obj = getModelByPath(modelFromScopeHolder.varPath, list.get(i));
							if (itemId.equals(obj)) {
								list.set(i, newData);
								break;
							}
						}
					}
					notifyDataSetChanged(sectionHolder);
				} else {
					if (itemConfig.containsKey("@idPath")) { 
						String path = PluginInvoker.getString(itemConfig.get("@idPath"));
						com.ashera.model.ModelExpressionParser.ModelFromScopeHolder modelFromScopeHolder = com.ashera.model.ModelExpressionParser.parseModelFromScope(path);
						
						if (itemConfig.containsKey("@modelFor")) {
							List<Object> list = getModelChildItems(itemConfig, sectionHolder.loopParam);
							syncObjectUpdateSectionItem(itemId, modelFromScopeHolder.varPath, list, newData);
						}
						
						int itemCount = sectionHolder.section.getItemCount();
						int layoutId =  (int) quickConvert(PluginInvoker.getString(itemConfig.get("@layout")), "id");
						ArrayList<com.xwray.groupie.Item<GroupieViewHolder>> items = new ArrayList<>();
						for (int i = itemCount - 1; i >= 0; i--) {
							com.xwray.groupie.Item<GroupieViewHolder> item = sectionHolder.section.getItem(i);
							
							if (item instanceof GenericItem) {
								if (((GenericItem) item).getLayout() == layoutId) {
									Object obj = getModelFromScope(modelFromScopeHolder.varName, modelFromScopeHolder.varScope, ((GenericItem) item).getLoopParam());
									obj = getModelByPath(modelFromScopeHolder.varPath, obj);
									
									if (itemId.equals(obj)) {
										com.xwray.groupie.Section tmpSection = new com.xwray.groupie.Section();
										createItem(tmpSection, itemConfig, sectionHolder.loopParam, newData);
										item = tmpSection.getItem(0);
									}
									
									items.add(0, item);
								}
							}
						}
						
						sectionHolder.section.update(items);
					}	
				}
			}
		}
	}
	
	
	private void scrollToPosition(Object objValue) {
		recyclerView.scrollToPosition((int) objValue);
	}

	private void scrollToTop(Object objValue) {
		recyclerView.scrollToPosition(0);
	}

	private void scrollToEnd(Object objValue) {
		recyclerView.scrollToPosition(adapter.getItemCount() - 1);
	}

	private void setStackFromBottom(Object objValue) {
		if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
			((LinearLayoutManager)recyclerView.getLayoutManager()).setStackFromEnd((boolean) objValue);
		}
	}

	
	private void setReverseLayout(Object objValue) {
		if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
			((LinearLayoutManager)recyclerView.getLayoutManager()).setReverseLayout((boolean) objValue);
		}
		
		if (recyclerView.getLayoutManager() instanceof StaggeredGridLayoutManager) {
			((StaggeredGridLayoutManager)recyclerView.getLayoutManager()).setReverseLayout((boolean) objValue);
		}
	}
	
	private boolean isReverseLayout() {
		androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
		if (layoutManager instanceof LinearLayoutManager) {
			return ((LinearLayoutManager) layoutManager).getReverseLayout();
		}
		
		if (layoutManager instanceof StaggeredGridLayoutManager) {
			return ((StaggeredGridLayoutManager) layoutManager).getReverseLayout();
		}
		
		return false;
	}

	@Override
	protected void invalidateChildIfRequired(IWidget childWidget) {
		if (childWidget instanceof RecyclerViewImpl) {
			((RecyclerViewImpl) childWidget).notifyDataSetChanged();
		}
	}
	
	private boolean headerDisabled;
	private void setFooterDisabled(Object objValue) {
		this.footerDisabled = (boolean) objValue;
		
		reloadTable();
	}

	private boolean footerDisabled;
	private void setHeaderDisabled(Object objValue) {
		this.headerDisabled = (boolean) objValue;
		
		reloadTable();
	}

	@Override
	public void applyModelToWidget() {
		super.applyModelToWidget();
		
		if (adapter instanceof GroupieAdapter) {
			widgets.clear();
			((GroupieAdapter) adapter).clear();
			recyclerView.setAdapter(adapter);
			createSections((GroupieAdapter) adapter);
		}
	}
	
	private int fixedGridRowCount;
	private int fixedGridColumnCount;

	private int fixedGridTileWidth;
	private int fixedGridTileHeight;
	private int dragDirs = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
	private int swipeDirs = ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;

	private boolean isCustomMeasure() {
		return isFixedGridViewManager();
	}
	
	private int[] customMeasure(int widthSpec, int heightSpec) {
		return measureFixedGridViewManager(widthSpec, heightSpec);
	}

	private boolean isFixedGridViewManager() {
		return recyclerView.getLayoutManager() instanceof FixedGridViewManager;
	}

	private int[] measureFixedGridViewManager(int widthSpec, int heightSpec) {
		int parentWidth = MeasureSpec.getSize(widthSpec);
		int parentHeight = MeasureSpec.getSize(heightSpec);

		float imageWidth = fixedGridTileWidth * fixedGridColumnCount;
		float imageHeight = fixedGridTileHeight * fixedGridRowCount;

		float ratio = imageWidth / imageHeight;

		boolean isLandscape =
				parentWidth > parentHeight;

		int finalWidth;
		int finalHeight;

		if (isLandscape) {

			// Fit height
			finalHeight = parentHeight;

			finalWidth = (int)(finalHeight * ratio);

		} else {

			// Fit width
			finalWidth = parentWidth;

			finalHeight = (int)(finalWidth / ratio);
		}

		int w = MeasureSpec.makeMeasureSpec(
				finalWidth,
				MeasureSpec.EXACTLY
		);

		int h = MeasureSpec.makeMeasureSpec(
				finalHeight,
				MeasureSpec.EXACTLY
		);

		return new int []{
				w, h
		};
	}

	private ItemTouchHelper itemTouchHelper;
	private GenericTouchHelperSimpleCallback touchHelperSimpleCallback;
	private void setDragDropMode(String strValue, Object objValue) {
		initTouchHelperSimpleCallback();
		touchHelperSimpleCallback.setDragmode(strValue);
	}

	private void initTouchHelperSimpleCallback() {
		if (touchHelperSimpleCallback == null) {
			touchHelperSimpleCallback = new GenericTouchHelperSimpleCallback(adapter, dragDirs, swipeDirs);	
			itemTouchHelper = createItemTouchHelper();
			itemTouchHelper.attachToRecyclerView(recyclerView);
		}
	}

	private void setFixedgridTileHeight(Object objValue) {
		fixedGridTileHeight = (int) objValue;
	}

	private void setFixedgridTileWidth(Object objValue) {
		fixedGridTileWidth = (int) objValue;
	}

	private void setFixedgridColumnCount(Object objValue) {
		fixedGridColumnCount = (int) objValue;
	}

	private void setFixedgridRowCount(Object objValue) {
		fixedGridRowCount = (int) objValue;
	}
	
	private void setResetHighlightAttributes(Object objValue) {
		initTouchHelperSimpleCallback();
		touchHelperSimpleCallback.setResetHighlightAttributes((String) objValue);
	}

	private void setSelectHighlightAttributes(Object objValue) {
		initTouchHelperSimpleCallback();
		touchHelperSimpleCallback.setSelectHighlightAttributes((String) objValue);
	}

	private void setSwapMode(String strValue, Object objValue) {
		initTouchHelperSimpleCallback();
		touchHelperSimpleCallback.setSwapMode(strValue);
	}

	private void setDragStartMode(String strValue, Object objValue) {
		initTouchHelperSimpleCallback();
		touchHelperSimpleCallback.setDragStartMode(strValue);
	}
	
	private void setHasFixedSize(Object objValue) {
		recyclerView.setHasFixedSize((boolean) objValue);
	}

	private void disableItemAnimator() {
		recyclerView.setItemAnimator(null);
	}
	
	private void setSwipeSwapMode(String strValue, Object objValue) {
		initTouchHelperSimpleCallback();
		touchHelperSimpleCallback.setSwipeSwapMode(strValue);
	}
	
	private void setDeleteOnSwipe(Object objValue) {
		initTouchHelperSimpleCallback();
		touchHelperSimpleCallback.setDeleteOnSwipe((boolean) objValue);
	}
	
	

	private void setonSwiped(String strValue) {
		initTouchHelperSimpleCallback();
		MyCallback mycallback = new MyCallback(this, strValue, "onSwipe");
		touchHelperSimpleCallback.setSwipeListener(mycallback);
	}


	private void setOnMoved(String strValue) {
		initTouchHelperSimpleCallback();
		MyCallback mycallback = new MyCallback(this, strValue, "onMoved");
		touchHelperSimpleCallback.setOnMovedListener(mycallback);
	}

	private void setOnMove(String strValue) {
		initTouchHelperSimpleCallback();
		MyCallback mycallback = new MyCallback(this, strValue, "onMove");
		touchHelperSimpleCallback.setOnMoveListener(mycallback);
	}

	private void setOnSelectedChanged(String strValue) {
		initTouchHelperSimpleCallback();
		MyCallback mycallback = new MyCallback(this, strValue, "onSelectedChanged");
		touchHelperSimpleCallback.setOnSelectedChangedListener(mycallback);
	}


	private void setonSwiped(MyItemTouchHelper.MyCallback  objValue) {
		initTouchHelperSimpleCallback();
		touchHelperSimpleCallback.setSwipeListener(objValue);
	}
	
	private void setOnMoved(com.ashera.recycleview.MyItemTouchHelper.MyCallback objValue) {
		initTouchHelperSimpleCallback();
		touchHelperSimpleCallback.setOnMovedListener(objValue);
	}

	private void setOnMove(com.ashera.recycleview.MyItemTouchHelper.MyCallback objValue) {
		initTouchHelperSimpleCallback();
		touchHelperSimpleCallback.setOnMoveListener(objValue);
	}
	
	private void setOnSelectedChanged(com.ashera.recycleview.MyItemTouchHelper.MyCallback objValue) {
		initTouchHelperSimpleCallback();
		touchHelperSimpleCallback.setOnSelectedChangedListener(objValue);
	}

	
	
	private void setSwipeDirs(Object objValue) {
		swipeDirs = (int) objValue;
	}

	private void setDragDirs(Object objValue) {
		dragDirs = (int) objValue;
	}
    

	private static void addEventInfoTargetViewHolder(Map<String, Object> obj, ViewHolder target) {
		if (target != null) {
			obj.put("targetViewHolderAdapterPoition", target.getAdapterPosition());
		}
	}

	private static void addEventInfoViewHolder(Map<String, Object> obj, ViewHolder viewHolder) {
		if (viewHolder != null) {
			obj.put("viewHolderAdapterPoition", viewHolder.getAdapterPosition());
		}
	}
	//end - recyclerview
	

	private void initScrollBars() {
		android.content.res.TypedArray typedArray = recyclerView.getContext().obtainStyledAttributes(new int[] {});
		invokePrivateMethodUsingReflection(recyclerView, "initializeScrollbars", typedArray);
		typedArray.recycle();
		recyclerView.setVerticalScrollBarEnabled(true);
		recyclerView.setHorizontalScrollBarEnabled(true);
	}
	
	private void setOnScrollListener(RecyclerView recyclerView, Object objValue) {
		recyclerView.setOnScrollListener((RecyclerView.OnScrollListener) objValue);
	}
	

	private void setOnFlingListener(RecyclerView recyclerView2, Object objValue) {
		recyclerView.setOnFlingListener((RecyclerView.OnFlingListener) objValue);
	}


	//start - filter	
	private String query;
	private int filterDelay = 100;
	private android.os.Handler handler;
	private void filter(Object query) {
		this.query = (String) query;
		
		if (filterQuerySetPath != null) {
			storeModelToScope(filterQuerySetPath.varName, filterQuerySetPath.varScope, query);
		}

		if (handler == null) {
			handler = new android.os.Handler(); 
		} else {
			handler.removeCallbacks(null);
		}
		handler.postDelayed(() -> {
			notifyDataSetChanged();
			getFragment().remeasure();
		}, filterDelay);
	}
	
	
	
	private void setFilterDelay(Object objValue) {
		this.filterDelay = (int) objValue;
		
	}
	
	private String filterId = FilterFactory.DEFAULT_FILTER;
	private void setFilterId(Object objValue) {
		filterId = (String) objValue;
	}
	
	@Override
	protected boolean filterData(Object model) {
		return filterData(model, filterItemPaths);
	}

	private boolean filterData(Object model, String[] paths) {
		if (filterQueryGetPath != null) {
			this.query = (String) getModelFromScope(filterQueryGetPath.varName, filterQueryGetPath.varScope);
		}
		if (this.query == null || paths == null) {
			return true;
		}
		
		for (String path : paths) {
			Object modelVal = getModelByPath(path, model);
			IFilter filter = FilterFactory.get(filterId);
	        if (filter == null) {
	        	filter = FilterFactory.get(FilterFactory.DEFAULT_FILTER);
	        }
			if (filter.filter(PluginInvoker.getString(modelVal), query)) {
				return true;
			}
		}
		
		return false;
		
	}
	
	private String[] filterSectionPaths;
	private String[] filterItemPaths; 
	private void setFilterSectionItemPath(Object objValue) {
		filterSectionPaths = (String[]) objValue;
	} 

	private void setFilterItemPath(Object objValue) {
		filterItemPaths = (String[]) objValue;		
	}
	
	private com.ashera.model.ModelExpressionParser.ModelVarScopeHolder filterQuerySetPath;	
	private com.ashera.model.ModelExpressionParser.ModelVarScopeHolder filterQueryGetPath;
	private void setFilterQueryGetPath(Object objValue) {
		filterQueryGetPath = com.ashera.model.ModelExpressionParser.parseModelVarScope((String) objValue);
		
	}

	private void setFilterQueryStorePath(Object objValue) {
		filterQuerySetPath = com.ashera.model.ModelExpressionParser.parseModelVarScope((String) objValue);
		
	}
		//end - filter

	private void addStartDrag(ViewHolder viewHolder) {
		if (touchHelperSimpleCallback != null && touchHelperSimpleCallback.isDownPressDragEnabled()) {
			viewHolder.itemView.setOnTouchListener((v, event) -> {
			    if (event.getActionMasked() == MotionEvent.ACTION_DOWN) {
			    	if (itemTouchHelper != null) {
			    		itemTouchHelper.startDrag(viewHolder);
			    	}
			    }
			    return false;
			});
		}
	}
	

	//start - createItemTouchHelper
	private ItemTouchHelper createItemTouchHelper() {
		return new ItemTouchHelper(touchHelperSimpleCallback);
	}
	//end - createItemTouchHelper
}

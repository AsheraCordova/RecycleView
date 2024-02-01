package com.ashera.recycleview;
// start - imports
import java.util.*;

import r.android.annotation.SuppressLint;
import r.android.content.Context;
import r.android.os.Build;
import r.android.view.*;
import r.android.widget.*;
import r.android.view.View.*;

import com.ashera.widget.BaseHasWidgets;

import r.android.annotation.SuppressLint;

import com.ashera.core.IFragment;
import com.ashera.widget.bus.*;
import com.ashera.converter.*;
import com.ashera.widget.bus.Event.*;
import com.ashera.widget.*;
import com.ashera.widget.IWidgetLifeCycleListener.*;
import com.ashera.layout.*;

import org.teavm.jso.dom.html.HTMLElement;

import static com.ashera.widget.IWidget.*;
//end - imports
import androidx.recyclerview.widget.*;
public class RecyclerViewImpl extends BaseHasWidgets {
	//start - body
	private HTMLElement htmlElement;
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
	@Override
	public void loadAttributes(String localName) {
		ViewGroupImpl.register(localName);

		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layoutManager").withType("string"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("viewHolderIds").withType("array").withArrayType("string"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("spanCount").withType("int").withOrder(-1));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout").withType("string").withOrder(100));
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
		ConverterFactory.register("androidx.recyclerview.widget.RecyclerView.orientation", new Orientation());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("orientation").withType("androidx.recyclerview.widget.RecyclerView.orientation").withOrder(-1));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("onScrollStateChange").withType("string"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("onScrolled").withType("string"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("headerDisabled").withType("boolean").withOrder(-1));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("footerDisabled").withType("boolean").withOrder(-1));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("nestedScrollStopDelay").withType("int"));
	
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
		recyclerView = new RecyclerViewExt();
		
		nativeCreate(params);
		
		
		ViewGroupImpl.registerCommandConveter(this);
	}

	@Override
	public Object asWidget() {
		return recyclerView;
	}


	private void nativeRemoveView(IWidget widget) {
		r.android.animation.LayoutTransition layoutTransition = recyclerView.getLayoutTransition();
		if (layoutTransition != null && (
				layoutTransition.isTransitionTypeEnabled(r.android.animation.LayoutTransition.CHANGE_DISAPPEARING) ||
				layoutTransition.isTransitionTypeEnabled(r.android.animation.LayoutTransition.DISAPPEARING)
				)) {
			addToBufferedRunnables(() -> ViewGroupImpl.nativeRemoveView(widget));          
		} else {
			ViewGroupImpl.nativeRemoveView(widget);
		}
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

		public RecyclerViewExt() {
			super();
			
		}
		
		@Override
		public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

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
			ViewImpl.setDrawableBounds(RecyclerViewImpl.this, l, t, r, b);
			ViewImpl.nativeMakeFrame(asNativeWidget(), l, t, r, b);
			nativeMakeFrameForChildWidget(l, t, r, b);
			replayBufferedEvents();
	        ViewImpl.redrawDrawables(RecyclerViewImpl.this);
			
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
		public void execute(String method, Object... canvas) {
			
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
        	ViewImpl.drawableStateChanged(RecyclerViewImpl.this);
        }
        private Map<String, IWidget> templates;
    	@Override
    	public r.android.view.View inflateView(java.lang.String layout) {
    		if (templates == null) {
    			templates = new java.util.HashMap<String, IWidget>();
    		}
    		IWidget template = templates.get(layout);
    		if (template == null) {
    			template = (IWidget) quickConvert(layout, "template");
    			templates.put(layout, template);
    		}
    		IWidget widget = template.loadLazyWidgets(RecyclerViewImpl.this.getParent());
    		return (View) widget.asWidget();
    	}        
        
    	@Override
		public void remeasure() {
    		if (getFragment() != null) {
    			getFragment().remeasure();
    		}
		}
    	
        @Override
		public void removeFromParent() {
        	RecyclerViewImpl.this.getParent().remove(RecyclerViewImpl.this);
		}
        @Override
        public void getLocationOnScreen(int[] appScreenLocation) {
        	appScreenLocation[0] = htmlElement.getBoundingClientRect().getLeft();
        	appScreenLocation[1] = htmlElement.getBoundingClientRect().getTop();
        }
        @Override
        public void getWindowVisibleDisplayFrame(r.android.graphics.Rect displayFrame){
        	
        	org.teavm.jso.dom.html.TextRectangle boundingClientRect = htmlElement.getBoundingClientRect();
			displayFrame.top = boundingClientRect.getTop();
        	displayFrame.left = boundingClientRect.getLeft();
        	displayFrame.bottom = boundingClientRect.getBottom();
        	displayFrame.right = boundingClientRect.getRight();
        }
        @Override
		public void offsetTopAndBottom(int offset) {
			super.offsetTopAndBottom(offset);
			ViewImpl.nativeMakeFrame(asNativeWidget(), getLeft(), getTop(), getRight(), getBottom());
		}
		@Override
		public void offsetLeftAndRight(int offset) {
			super.offsetLeftAndRight(offset);
			ViewImpl.nativeMakeFrame(asNativeWidget(), getLeft(), getTop(), getRight(), getBottom());
		}
		@Override
		public void setMyAttribute(String name, Object value) {
			if (name.equals("state0")) {
				setState0(value);
				return;
			}
			if (name.equals("state1")) {
				setState1(value);
				return;
			}
			if (name.equals("state2")) {
				setState2(value);
				return;
			}
			if (name.equals("state3")) {
				setState3(value);
				return;
			}
			if (name.equals("state4")) {
				setState4(value);
				return;
			}
			RecyclerViewImpl.this.setAttribute(name, value, true);
		}
        @Override
        public void setVisibility(int visibility) {
            super.setVisibility(visibility);
            ((HTMLElement)asNativeWidget()).getStyle().setProperty("display", visibility != View.VISIBLE ? "none" : "block");
            
        }
        
    	public void setState0(Object value) {
    		ViewImpl.setState(RecyclerViewImpl.this, 0, value);
    	}
    	public void setState1(Object value) {
    		ViewImpl.setState(RecyclerViewImpl.this, 1, value);
    	}
    	public void setState2(Object value) {
    		ViewImpl.setState(RecyclerViewImpl.this, 2, value);
    	}
    	public void setState3(Object value) {
    		ViewImpl.setState(RecyclerViewImpl.this, 3, value);
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
     
		@Override
		public void endViewTransition(r.android.view.View view) {
			super.endViewTransition(view);
			runBufferedRunnables();
		}
	}
	@Override
	public Class getViewClass() {
		return RecyclerViewExt.class;
	}
	
	@SuppressLint("NewApi")
	@Override
	public void setAttribute(WidgetAttribute key, String strValue, Object objValue, ILifeCycleDecorator decorator) {
		ViewGroupImpl.setAttribute(this, key, strValue, objValue, decorator);
		Object nativeWidget = asNativeWidget();
		switch (key.getAttributeName()) {
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


		 removeAllItems((String) sectionId);


}
if (objValue instanceof java.util.List) {
	java.util.List<Object> list = (java.util.List<Object>) objValue;
	for (Object object : list) {
		Map<String, Object> data = PluginInvoker.getMap(object);
		Object sectionId = quickConvert(data.get("sectionId"), "string");


		 removeAllItems((String) sectionId);


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
			case "orientation": {


		setOrientation(objValue);



			}
			break;
			case "onScrollStateChange": {


		 setOnScrollStateChange(key, strValue, objValue, decorator);



			}
			break;
			case "onScrolled": {


		 setOnScroll(key, strValue, objValue, decorator);



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
			case "nestedScrollStopDelay": {


		setNestedScrollStopDelay((int) objValue);



			}
			break;
		default:
			break;
		}
		postSetAttribute(key, strValue, objValue, decorator);
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
			case "nestedScrollingEnabled": {
return recyclerView.isNestedScrollingEnabled();			}
			case "reverseLayout": {
return isReverseLayout();			}
		}
		return null;
	}


	@Override
    public Object asNativeWidget() {
        return htmlElement;
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
	


	private Object scrollProvider;
	private int scrollBarIncrement = 20;
	private int nestedScrollStopDelay = 700;
	private int oldScrollPos = 0;
	private int prevRange = -1;
	private long lastScrollEvent;
	enum ScrollProviderType {READ_ONLY, DRAGABBLE}
	private ScrollProviderType scrollProviderType = ScrollProviderType.DRAGABBLE;
	private r.android.os.Handler nestedScrollHandler = new r.android.os.Handler();
	
	private void initScrollBars() {
	}
	
	private void setScrollBarIncrement(Object objValue) {
		scrollBarIncrement = (int) objValue;
	}
	
	
	private void setNestedScrollStopDelay(int delay) {
		nestedScrollStopDelay = delay;
		
	}
	private void handleScroll() {
		try {
			fragment.disableRemeasure();
			nestedScrollHandler.removeCallbacksAndMessages(null);
			long currentTime = System.currentTimeMillis();
			
			if (currentTime - lastScrollEvent >= nestedScrollStopDelay) {
				recyclerView.startNestedScroll();	
			}
			nestedScrollHandler.postDelayed(() -> {
				recyclerView.stopNestedScroll();
			}, nestedScrollStopDelay);
			lastScrollEvent = System.currentTimeMillis();
			// get range/offset/extent
			int range = getRange();
			int offset = getOffset();
			int extent = getExtent();
			float scrollBarDimen = getScrollBarDimen(range, extent);

			int rangeDiff = range - prevRange;
			prevRange = range;

			int selection = getSelection();
			int dpos = selection - oldScrollPos;

			if (scrollProviderType == ScrollProviderType.DRAGABBLE) {
				// ensure that scroll bar always reaches end/top
				if (selection >= getScrollBarMax(scrollProvider, scrollBarDimen) - 20) {
					dpos = scrollBarIncrement * 1000;
				}
				if (selection == 0) {
					dpos = -(scrollBarIncrement * 1000);
				}
			}

			dpos = recyclerView.dispatchNestedPreScroll(dpos);
			
			// scroll the recycler view
			if (isHorizontal()) {
				recyclerView.scrollBy((int) Math.ceil(dpos), 0);
			} else {
				recyclerView.scrollBy(0, (int) Math.ceil(dpos));
			}

			oldScrollPos = selection;

			if (scrollProviderType == ScrollProviderType.DRAGABBLE) {
				// set max value
				if (getMaximum() < range) {
					setMaximum(range);
				} else if (rangeDiff > 0) {
					setMaximum(getMaximum() + rangeDiff);
				}
			}
			
			// any custom adjustment per platform
			setCustomHandleScroll(dpos, range, offset, extent);
		} finally {
			fragment.enableRemeasure();	
		}
	}

	private float getScrollBarDimen(int range, int extent) {
		return (extent/(float) range) * extent;
	}
	
	private void nativeMakeFrameForChildWidget(int l, int t, int r, int b) {
		setMinimum(0);
		
		// get range/offset/extent
		int range = getRange();
		int offset = getOffset();
		int extent = getExtent();

		int rangeDiff = range - prevRange;
		prevRange = range;
		
		// set max value
		if (scrollProviderType == ScrollProviderType.DRAGABBLE) {
			if (getMaximum() < range) {
				 setMaximum(range);
			} else if (rangeDiff != 0) {
				setMaximum(getMaximum() + rangeDiff);
			}
		}

		// set frame of scroll provider
		if (isHorizontal()) {
			if (range > (r - l)) {
				ViewImpl.nativeMakeFrameForHorizontalScrollView(scrollProvider, 0, b - t - getThumbWidth(), r - l, b - t, range);
			} else {
				ViewImpl.nativeMakeFrameForHorizontalScrollView(scrollProvider, 0, 0, 0, 0, range);
			}
		} else {
			if (range > (b - t)) {
				ViewImpl.nativeMakeFrame(scrollProvider, r - l - getThumbWidth(), 0, r - l, b - t, range);
			} else {
				ViewImpl.nativeMakeFrame(scrollProvider, 0, 0, 0, 0, range);
			}
		}
		
		// set custom frame if needed
		setCustomMakeFrameForChildWidget(range, rangeDiff, l, t, r, b);
		
		// adjust selection of scrollbar
		if ((range - extent) > 0) {
			float percentage = (offset / (float)(range - extent));
			float scrollBarDimen = getScrollBarDimen(range, extent);
			// call on scrollProvider
			int selection = setSelection((int) (getScrollBarMax(scrollProvider, scrollBarDimen) * percentage), offset, scrollProvider);
			if (selection >= 0) {
				oldScrollPos = selection;
			}
			
			if (scrollProviderType == ScrollProviderType.READ_ONLY) {
				if (percentage == 1) {
					// call on view also
					selection = setSelection((int) (getScrollBarMax(htmlElement, scrollBarDimen) * percentage), offset, htmlElement);
					if (selection >= 0) {
						oldScrollPos = selection;
					}
				} else {
					
					int currentSelection = getSelection();
					if (currentSelection >= 0) {
						oldScrollPos = currentSelection;
					}
				}
			}
			
		} else {
			oldScrollPos = 0;
		}
	}

	private int getExtent() {
		return isHorizontal() ? recyclerView.computeHorizontalScrollExtent() : recyclerView.computeVerticalScrollExtent();
	}

	private int getOffset() {
		return isHorizontal() ? recyclerView.computeHorizontalScrollOffset() : recyclerView.computeVerticalScrollOffset();
	}

	private int getRange() {
		return isHorizontal() ? recyclerView.computeHorizontalScrollRange() : recyclerView.computeVerticalScrollRange();
	}
	
	
	
	private void setOnScroll(WidgetAttribute key, String strValue, Object objValue, ILifeCycleDecorator decorator) {
		if (objValue instanceof String) {
			recyclerView.setOnScrollListener(new OnScrollListener(this, strValue));
		} else {
			recyclerView.setOnScrollListener((OnScrollListener)objValue);
		}
	}

	private void setOnScrollStateChange(WidgetAttribute key, String strValue, Object objValue,
			ILifeCycleDecorator decorator) {
		if (objValue instanceof String) {
			recyclerView.setOnScrollListener(new OnScrollListener(this, strValue));
		} else {
			recyclerView.setOnScrollListener((OnScrollListener)objValue);
		}
	}
	


	private int thumbWidth;
	private int thumbHeight;
	private int originalPadding;
	
	private void setInitialPadding() {
		if (isHorizontal()) {
			if (recyclerView.getPaddingBottom() < thumbHeight) {
				originalPadding = recyclerView.getPaddingBottom();
				recyclerView.setPadding(recyclerView.getPaddingLeft(), recyclerView.getPaddingTop(), recyclerView.getPaddingRight(), thumbHeight);
			}
		} else {
			if (recyclerView.getPaddingRight() < thumbWidth) {
				originalPadding = recyclerView.getPaddingRight();
				recyclerView.setPadding(recyclerView.getPaddingLeft(), recyclerView.getPaddingTop(), thumbWidth, recyclerView.getPaddingBottom());
			}
		}
	}
	private void adjustPaddingIfNecessary() {
		if (isHorizontal()) {
			if (!(recyclerView.canScrollHorizontally(1) || recyclerView.canScrollHorizontally(-1))) {
				if (recyclerView.getPaddingBottom() != originalPadding) { 
					recyclerView.setPadding(recyclerView.getPaddingLeft(), recyclerView.getPaddingTop(), recyclerView.getPaddingRight(), originalPadding);
					getFragment().remeasure();
				}
			} else {
				if (recyclerView.getPaddingBottom() < thumbWidth) {
					recyclerView.setPadding(recyclerView.getPaddingLeft(), recyclerView.getPaddingTop(), recyclerView.getPaddingRight(), thumbHeight);
					getFragment().remeasure();
				}
			}
		
		} else {
			if (!(recyclerView.canScrollVertically(1) || recyclerView.canScrollVertically(-1))) {
				if (recyclerView.getPaddingRight() != originalPadding) { 
					recyclerView.setPadding(recyclerView.getPaddingLeft(), recyclerView.getPaddingTop(), originalPadding, recyclerView.getPaddingBottom());
					getFragment().remeasure();
				}
			} else {
				if (recyclerView.getPaddingRight() < thumbWidth) {
					recyclerView.setPadding(recyclerView.getPaddingLeft(), recyclerView.getPaddingTop(), thumbWidth, recyclerView.getPaddingBottom());
					getFragment().remeasure();
				}
			}
		}
	}
	


	private RecyclerView.Adapter<? extends RecyclerView.ViewHolder> adapter;
	private IWidget headerTemplate;
	private IWidget footerTemplate;
	
	private void nativeCreateRecycleView(Map<String, Object> params) {
		adapter = new ListAdapter();
		adapter.setHasStableIds(true);
		recyclerView.setAdapter(adapter);
		recyclerView.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(recyclerView.getContext()));
		
		initScrollBars();
	}
	
	public class ListAdapter extends RecyclerView.Adapter<ViewHolder> {
		@Override
		public long getItemId(int position) {
			if (isHeader(position) || isFooter(position)) {
				return super.getItemId(position);
			}
			if (headerTemplate != null && !headerDisabled) {
				position = position - 1;
			}
			return (int) quickConvert(ids.get(position), "id");
		}
		
		@Override
		public void onViewAttachedToWindow(ViewHolder holder) {
			super.onViewAttachedToWindow(holder);
			holder.itemView.setVisibility(View.VISIBLE);
		}
		
		@Override
		public void onViewDetachedFromWindow(ViewHolder holder) {
			super.onViewDetachedFromWindow(holder);
			holder.itemView.setVisibility(View.GONE);
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
		public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
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
			
			IWidget widget = (IWidget) listItem.loadLazyWidgets(RecyclerViewImpl.this);
			if (widgets.indexOf(widget) == -1) {
				widgets.add(widget);
			}
			View itemView = (View) widget.asWidget();
			
			setItemViewParams(widget, itemView);

			ViewHolder viewHolder = new ViewHolder(widget, itemView, viewHolderIds);
			return viewHolder;
		}
	
		@Override
		public void onBindViewHolder(ViewHolder viewHolder, int position) {
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
	}
	

	public class ViewHolder extends RecyclerView.ViewHolder {
		WidgetViewHolder widgetViewHolder;
		public ViewHolder(IWidget widget, View itemView, List<String> viewHolderIds) {
			super(itemView);

			if (viewHolderIds != null) {
				widgetViewHolder = createWidgetViewHolder(viewHolderIds, widget);
			}
		}
	}
	private void setLayoutManager(Object objValue) {
		String layoutManager = (String) objValue;
		
		switch (layoutManager) {
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
		String json = com.ashera.utils.ResourceBundleUtils.getString("xml/recycler", ((String) objValue).replace("@xml/", ""), fragment);
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
				GroupieAdapter groupieAdapter = new GroupieAdapter();
				adapter = groupieAdapter;
				adapter.setHasStableIds(true);
				groupieAdapter.setSpanCount(spanCount);
				recyclerView.setAdapter(adapter);

				if (recyclerView.getLayoutManager() instanceof GridLayoutManager) {
					((GridLayoutManager)recyclerView.getLayoutManager()).setSpanSizeLookup(groupieAdapter.getSpanSizeLookup());
				}
				recyclerView.addItemDecoration(new InsetItemDecoration());

				createSections(groupieAdapter);
			}
		}
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
							com.ashera.model.LoopParam loopParam = new com.ashera.model.LoopParam();
							storeModelToScope(modelLoopHolder.varName, modelLoopHolder.varScope, model, loopParam);
							addSection(group, sectionMap, loopParam);
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

		if (itemMap.containsKey("@modelFor")) {
			String modelFor = PluginInvoker.getString(itemMap.get("@modelFor"));
			com.ashera.model.ModelExpressionParser.ModelLoopHolder modelLoopHolder = com.ashera.model.ModelExpressionParser.parseModelLoopExpression(modelFor);

			//let x in . from y->intent into view as pathmap
			Object obj = null;
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
						com.ashera.model.LoopParam loopParam = new com.ashera.model.LoopParam();
						storeModelToScope(modelLoopHolder.varName, modelLoopHolder.varScope, model, loopParam);
						GenericItem item = new GenericItem(layout.toString(), template, loopParam, viewHolderIds);
						item.setNumberOfColums(numberOfColumns);
						item.setMargin(margin);
						section.add(item);
					}
				} else {
					Map<String, Object> map = PluginInvoker.getMap(obj);
					
					if (map != null) {
						obj = changeModelDataType(modelLoopHolder.dataType, obj);
						com.ashera.model.LoopParam loopParam = new com.ashera.model.LoopParam();
						storeModelToScope(modelLoopHolder.varName, modelLoopHolder.varScope, obj, loopParam);
						GenericItem item = new GenericItem(layout.toString(), template, loopParam, viewHolderIds);
						item.setNumberOfColums(numberOfColumns);
						item.setMargin(margin);
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
				
				GenericItem item = new GenericItem(layout.toString(), template, loopParam, viewHolderIds);
				item.setNumberOfColums(numberOfColumns);
				item.setMargin(margin);
				section.add(item);
			}
		} else {
			GenericItem item = new GenericItem(layout.toString(), template, pLoopParam, viewHolderIds);
			item.setNumberOfColums(numberOfColumns);
			item.setMargin(margin);
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

			section.setFooter(new GenericItem(layout.toString(), template, loopParam, viewHolderIds));
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
			section.setHeader(new GenericItem(layout.toString(), template, loopParam, viewHolderIds));
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
			super(layout, template, loopParam, viewHolderIds);
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
		private int margin;
		private boolean modified;
		int numberOfColums = 1;
		
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

		public GenericItem(String layout, IWidget template, com.ashera.model.LoopParam loopParam, List<String> viewHolderIds) {
			this.template = template;
			this.loopParam = loopParam;
			this.layout = layout;
			this.viewHolderIds = viewHolderIds;
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
		
	}
	
	public class GroupieAdapter extends com.xwray.groupie.GroupAdapter<GroupieViewHolder> {

		@Override
		public void onViewAttachedToWindow(GroupieViewHolder holder) {
			super.onViewAttachedToWindow(holder);
			holder.itemView.setVisibility(View.VISIBLE);
		}
		
		@Override
		public void onViewDetachedFromWindow(GroupieViewHolder holder) {
			super.onViewDetachedFromWindow(holder);
			holder.itemView.setVisibility(View.GONE);
		}

		@Override
		public GroupieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			GenericItem item = (GenericItem) getItemForViewType(viewType);
			IWidget widget = (IWidget) item.getTemplate().loadLazyWidgets(RecyclerViewImpl.this, -1, null, item.getLoopParam());
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
					createItem(sectionHolder.section, itemConfig, sectionHolder.loopParam, item);
				}
			}
		}
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
	
	
	private void removeAllItems(String sectionId) {
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
			((GroupieAdapter) adapter).clear();
			createSections((GroupieAdapter) adapter);
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
		    activity.sendEventMessage(obj);
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
		    activity.sendEventMessage(obj);
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


	@Override
	public void setId(String id){
		if (id != null && !id.equals("")){
			super.setId(id);
			recyclerView.setId((int) quickConvert(id, "id"));
		}
	}
	
    
    @Override
    public void setVisible(boolean b) {
        ((View)asWidget()).setVisibility(b ? View.VISIBLE : View.GONE);
    }

	
private RecyclerViewCommandBuilder builder;
private RecyclerViewBean bean;
public Object getPlugin(String plugin) {
	return WidgetFactory.getAttributable(plugin).newInstance(this);
}
public RecyclerViewBean getBean() {
	if (bean == null) {
		bean = new RecyclerViewBean();
	}
	return bean;
}
public RecyclerViewCommandBuilder getBuilder() {
	if (builder == null) {
		builder = new RecyclerViewCommandBuilder();
	}
	return builder;
}


public  class RecyclerViewCommandBuilder extends com.ashera.layout.ViewGroupImpl.ViewGroupCommandBuilder <RecyclerViewCommandBuilder> {
    public RecyclerViewCommandBuilder() {
	}
	
	public RecyclerViewCommandBuilder execute(boolean setter) {
		if (setter) {
			executeCommand(command, null, IWidget.COMMAND_EXEC_SETTER_METHOD);
			getFragment().remeasure();
		}
		executeCommand(command, null, IWidget.COMMAND_EXEC_GETTER_METHOD);
return this;	}

public RecyclerViewCommandBuilder setLayoutManager(String value) {
	Map<String, Object> attrs = initCommand("layoutManager");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public RecyclerViewCommandBuilder setViewHolderIds(String value) {
	Map<String, Object> attrs = initCommand("viewHolderIds");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public RecyclerViewCommandBuilder setSpanCount(int value) {
	Map<String, Object> attrs = initCommand("spanCount");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public RecyclerViewCommandBuilder setLayout(String value) {
	Map<String, Object> attrs = initCommand("layout");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public RecyclerViewCommandBuilder tryGetNestedScrollingEnabled() {
	Map<String, Object> attrs = initCommand("nestedScrollingEnabled");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object isNestedScrollingEnabled() {
	Map<String, Object> attrs = initCommand("nestedScrollingEnabled");
	return attrs.get("commandReturnValue");
}
public RecyclerViewCommandBuilder setNestedScrollingEnabled(boolean value) {
	Map<String, Object> attrs = initCommand("nestedScrollingEnabled");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public RecyclerViewCommandBuilder addSectionItem(String sectionId,
String itemConfigId,
Object item) {
	Map<String, Object> attrs = initCommand("addSectionItem");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	Map<String, Object> wrapper = new HashMap<>();
	wrapper.put("sectionId", sectionId);
	wrapper.put("itemConfigId", itemConfigId);
	wrapper.put("item", item);
	attrs.put("value", wrapper);
return this;}
public RecyclerViewCommandBuilder removeSectionItem(String sectionId,
String itemConfigId,
String itemId) {
	Map<String, Object> attrs = initCommand("removeSectionItem");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	Map<String, Object> wrapper = new HashMap<>();
	wrapper.put("sectionId", sectionId);
	wrapper.put("itemConfigId", itemConfigId);
	wrapper.put("itemId", itemId);
	attrs.put("value", wrapper);
return this;}
public RecyclerViewCommandBuilder removeAllItems(String sectionId) {
	Map<String, Object> attrs = initCommand("removeAllItems");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	Map<String, Object> wrapper = new HashMap<>();
	wrapper.put("sectionId", sectionId);
	attrs.put("value", wrapper);
return this;}
public RecyclerViewCommandBuilder updateSectionItem(String sectionId,
String itemConfigId,
String itemId,
Object item) {
	Map<String, Object> attrs = initCommand("updateSectionItem");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	Map<String, Object> wrapper = new HashMap<>();
	wrapper.put("sectionId", sectionId);
	wrapper.put("itemConfigId", itemConfigId);
	wrapper.put("itemId", itemId);
	wrapper.put("item", item);
	attrs.put("value", wrapper);
return this;}
public RecyclerViewCommandBuilder setStackFromEnd(boolean value) {
	Map<String, Object> attrs = initCommand("stackFromEnd");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public RecyclerViewCommandBuilder tryGetReverseLayout() {
	Map<String, Object> attrs = initCommand("reverseLayout");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object isReverseLayout() {
	Map<String, Object> attrs = initCommand("reverseLayout");
	return attrs.get("commandReturnValue");
}
public RecyclerViewCommandBuilder setReverseLayout(boolean value) {
	Map<String, Object> attrs = initCommand("reverseLayout");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public RecyclerViewCommandBuilder scrollToEnd(boolean value) {
	Map<String, Object> attrs = initCommand("scrollToEnd");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public RecyclerViewCommandBuilder scrollToTop(boolean value) {
	Map<String, Object> attrs = initCommand("scrollToTop");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public RecyclerViewCommandBuilder scrollToPosition(int value) {
	Map<String, Object> attrs = initCommand("scrollToPosition");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public RecyclerViewCommandBuilder setOrientation(String value) {
	Map<String, Object> attrs = initCommand("orientation");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public RecyclerViewCommandBuilder setOnScrollStateChange(String value) {
	Map<String, Object> attrs = initCommand("onScrollStateChange");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public RecyclerViewCommandBuilder setOnScrolled(String value) {
	Map<String, Object> attrs = initCommand("onScrolled");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public RecyclerViewCommandBuilder setHeaderDisabled(boolean value) {
	Map<String, Object> attrs = initCommand("headerDisabled");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public RecyclerViewCommandBuilder setFooterDisabled(boolean value) {
	Map<String, Object> attrs = initCommand("footerDisabled");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public RecyclerViewCommandBuilder setNestedScrollStopDelay(int value) {
	Map<String, Object> attrs = initCommand("nestedScrollStopDelay");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
}
public class RecyclerViewBean extends com.ashera.layout.ViewGroupImpl.ViewGroupBean{
		public RecyclerViewBean() {
			super(RecyclerViewImpl.this);
		}
public void setLayoutManager(String value) {
	getBuilder().reset().setLayoutManager(value).execute(true);
}

public void setViewHolderIds(String value) {
	getBuilder().reset().setViewHolderIds(value).execute(true);
}

public void setSpanCount(int value) {
	getBuilder().reset().setSpanCount(value).execute(true);
}

public void setLayout(String value) {
	getBuilder().reset().setLayout(value).execute(true);
}

public Object isNestedScrollingEnabled() {
	return getBuilder().reset().tryGetNestedScrollingEnabled().execute(false).isNestedScrollingEnabled(); 
}
public void setNestedScrollingEnabled(boolean value) {
	getBuilder().reset().setNestedScrollingEnabled(value).execute(true);
}

public void addSectionItem(String sectionId,
String itemConfigId,
Object item) {
	getBuilder().reset().addSectionItem(sectionId,
itemConfigId,
item).execute(true);
}

public void removeSectionItem(String sectionId,
String itemConfigId,
String itemId) {
	getBuilder().reset().removeSectionItem(sectionId,
itemConfigId,
itemId).execute(true);
}

public void removeAllItems(String sectionId) {
	getBuilder().reset().removeAllItems(sectionId).execute(true);
}

public void updateSectionItem(String sectionId,
String itemConfigId,
String itemId,
Object item) {
	getBuilder().reset().updateSectionItem(sectionId,
itemConfigId,
itemId,
item).execute(true);
}

public void setStackFromEnd(boolean value) {
	getBuilder().reset().setStackFromEnd(value).execute(true);
}

public Object isReverseLayout() {
	return getBuilder().reset().tryGetReverseLayout().execute(false).isReverseLayout(); 
}
public void setReverseLayout(boolean value) {
	getBuilder().reset().setReverseLayout(value).execute(true);
}

public void scrollToEnd(boolean value) {
	getBuilder().reset().scrollToEnd(value).execute(true);
}

public void scrollToTop(boolean value) {
	getBuilder().reset().scrollToTop(value).execute(true);
}

public void scrollToPosition(int value) {
	getBuilder().reset().scrollToPosition(value).execute(true);
}

public void setOrientation(String value) {
	getBuilder().reset().setOrientation(value).execute(true);
}

public void setOnScrollStateChange(String value) {
	getBuilder().reset().setOnScrollStateChange(value).execute(true);
}

public void setOnScrolled(String value) {
	getBuilder().reset().setOnScrolled(value).execute(true);
}

public void setHeaderDisabled(boolean value) {
	getBuilder().reset().setHeaderDisabled(value).execute(true);
}

public void setFooterDisabled(boolean value) {
	getBuilder().reset().setFooterDisabled(value).execute(true);
}

public void setNestedScrollStopDelay(int value) {
	getBuilder().reset().setNestedScrollStopDelay(value).execute(true);
}

}


private RecyclerViewCommandParamsBuilder paramsBuilder;
private RecyclerViewParamsBean paramsBean;

public RecyclerViewParamsBean getParamsBean() {
	if (paramsBean == null) {
		paramsBean = new RecyclerViewParamsBean();
	}
	return paramsBean;
}
public RecyclerViewCommandParamsBuilder getParamsBuilder() {
	if (paramsBuilder == null) {
		paramsBuilder = new RecyclerViewCommandParamsBuilder();
	}
	return paramsBuilder;
}



public class RecyclerViewParamsBean extends com.ashera.layout.ViewGroupImpl.ViewGroupParamsBean{
}





public class RecyclerViewCommandParamsBuilder extends com.ashera.layout.ViewGroupImpl.ViewGroupCommandParamsBuilder<RecyclerViewCommandParamsBuilder>{
}

	//end - body
	private HTMLElement dummyElement;
	private void nativeCreate(Map<String, Object> params) {
		nativeCreateRecycleView(params);
		htmlElement = org.teavm.jso.dom.html.HTMLDocument.current().createElement("div");
    	htmlElement.getStyle().setProperty("overflow-y", "hidden");
    	htmlElement.getStyle().setProperty("overflow-x", "hidden");
    	htmlElement.getStyle().setProperty("box-sizing", "border-box");
    	
    	HTMLElement scrollProvider = org.teavm.jso.dom.html.HTMLDocument.current().createElement("div");
    	scrollProvider.getStyle().setProperty("overflow-y", "auto");
    	scrollProvider.getStyle().setProperty("overflow-x", "hidden");
    	scrollProvider.getStyle().setProperty("box-sizing", "border-box");
    	scrollProvider.getStyle().setProperty("z-index", "1");
    	this.scrollProvider = scrollProvider;
    	ViewGroupImpl.nativeAddView(htmlElement, scrollProvider);
    	
    	dummyElement = org.teavm.jso.dom.html.HTMLDocument.current().createElement("div");
    	dummyElement.getStyle().setProperty("width", "1px");
    	dummyElement.getStyle().setProperty("height", "1px");
    	dummyElement.getStyle().setProperty("top", "0");
    	dummyElement.getStyle().setProperty("left", "0");
    	dummyElement.getStyle().setProperty("left", "0");
    	dummyElement.getStyle().setProperty("transform-origin", "0 0");
    	scrollProvider.appendChild(dummyElement);
    	
    	ViewImpl.setOnListener(this, htmlElement, new org.teavm.jso.dom.events.EventListener<WheelEvent>() {
	          @Override
	          public void handleEvent(WheelEvent event) {
	        	  if (!isHorizontal()) {
	  				int selection = getSelection() - ((int)(event.getDeltaY() * -0.05) * scrollBarIncrement);
					setSelection(selection, selection, scrollProvider);
	  			}
	          }
	  	}, "wheel", "wheel");
    	ViewImpl.setOnListener(this, scrollProvider, new org.teavm.jso.dom.events.EventListener<org.teavm.jso.dom.events.Event>() {
	          @Override
	          public void handleEvent(org.teavm.jso.dom.events.Event event) {
	        	  handleScroll();
	          }
	  	}, "scroll", "scroll");
	}
	
	public interface WheelEvent extends org.teavm.jso.dom.events.Event {
		@org.teavm.jso.JSProperty
   	 	int getDeltaY();
   }
	
	private void postSetAttribute(WidgetAttribute key, String strValue, Object objValue,
			ILifeCycleDecorator decorator) {
		switch (key.getAttributeName()) {
		case "orientation":
			if (isHorizontal()) {
				((HTMLElement)scrollProvider).getStyle().setProperty("overflow-y", "hidden");
				((HTMLElement)scrollProvider).getStyle().setProperty("overflow-x", "auto");
			} else {
				((HTMLElement)scrollProvider).getStyle().setProperty("overflow-y", "auto");
				((HTMLElement)scrollProvider).getStyle().setProperty("overflow-x", "hidden");
			}
			break;

		default:
			break;
		}
	}
	
	
	private void setCustomHandleScroll(int dpos, int range, int offset, int extent) {
	}
	
	
	private int getSelection() {
		int selection = isHorizontal() ? ((HTMLElement)scrollProvider).getScrollLeft() : ((HTMLElement)scrollProvider).getScrollTop();
		return selection;
	}

	private int setSelection(int percoffset, int offset, Object view) {
		if (view == scrollProvider) {
			if (isHorizontal()) {
				((HTMLElement)scrollProvider).setScrollLeft(percoffset);
			} else {
				((HTMLElement)scrollProvider).setScrollTop(percoffset);
			}
			
			return percoffset;
		}
		
		return -1;
	}

	private int maximum; 
	private void setMaximum(int maximum) {
		this.maximum = maximum;
		if (isHorizontal()) {
			dummyElement.getStyle().setProperty("width", maximum +"px");
		} else {
			dummyElement.getStyle().setProperty("height", maximum +"px");
		}
	}

	private int getMaximum() {
		return maximum;
	}
	

	private int getThumbWidth() {
		return 20;
	}

	private void setMinimum(int min) {
		
	}
	

	private void setCustomMakeFrameForChildWidget(int range, int rangeDiff, int l, int t, int r, int b) {
	}
	

	private int getScrollBarMax(Object uiView, float scrollBarDimen) {
		HTMLElement scrollBar = (HTMLElement)scrollProvider;
		if (isHorizontal()) {
			return scrollBar.getScrollWidth() - scrollBar.getClientWidth();
		} else {
			return scrollBar.getScrollHeight() - scrollBar.getClientHeight();
		}
	}

    @org.teavm.jso.JSBody(params = {}, script = "return window.getScrollbarWidth();")
    private static native int getScrollbarWidth();
    @Override
    public void initialized() {
    	super.initialized();
    	thumbHeight = thumbWidth = getScrollbarWidth();
    	setInitialPadding();
    
    	ViewImpl.addResizeObserver((HTMLElement) scrollProvider, (e) -> {
    		adjustPaddingIfNecessary();
    	});
    	ViewImpl.addResizeObserver(htmlElement, (e) -> {
    		adjustPaddingIfNecessary();
    	});
    }

}

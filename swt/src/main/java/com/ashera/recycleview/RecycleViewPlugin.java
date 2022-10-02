package com.ashera.recycleview;

import com.ashera.widget.WidgetFactory;

public class RecycleViewPlugin  {
    public static void initPlugin() {
    	//start - widgets
        WidgetFactory.register(new com.ashera.recycleview.RecyclerViewImpl());
        //end - widgets
    }
}

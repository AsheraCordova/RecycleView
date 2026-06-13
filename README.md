# RecyclerView

RecyclerView project which adds support for android RecyclerView.

## Installation
To install the plugin use:

```
cordova plugin add https://github.com/AsheraCordova/RecycleView.git
```

## Important Links
https://asheracordova.github.io/

https://asheracordova.github.io/doc/help-doc.html

https://asheracordova.github.io/doc/androidx/recyclerview/widget/RecyclerView.html

## Widgets
* androidx.recyclerview.widget.RecyclerView

## Custom Attributes

The following table lists the custom attributes used in widgets:

### androidx.recyclerview.widget.RecyclerView

Name                	| Description
-------------       	| -------------
viewHolderIds         | Comma separated list of ids which will be used to refresh the widgets when reusing the widgets. See section Configuring Recycler View.
headerDisabled        | When true, header is hidden.
footerDisabled        | When true, footer is hidden.
layout                | Layout xml file.  See section Configuring Recycler View.
filter				  | Method to filter the data presented in recycler view.				
filterDelay 	 	  | Delay before which filter will not be triggered. Default is 100ms.  	 	 	 	 	 	 	 	 	 	 	 	 	 
filterId 	 	 	  | The id of the filter. Custom filters can be created by using FilterFatory.register(LowerCasePrefixFilter.class.getName(), new LowerCasePrefixFilter());	 	 	 	 	 	 	 	 	 	 	 	 	 
filterItemPath 	 	  |	Mandatory for filter to work. The path on the model object on which filter will be applied to the items.
filterSectionPath     | Applicable only for groupie adapters. The path on the model object on which filter will be applied to section header items. 	 	 	 	 	 	 	 	 	 	 	 	 	 
filterQueryGetPath 	  |	Applicable only for groupie adapters. Groupie adapter can have child recycler views. The query of the filter will be passed to the child recycler views using filterQueryGetPath and filterQuerySetPath.   	 	 	 	 	 	 	 	 	 	 	 	 	 	 
filterQueryStorePath  |	Applicable only for groupie adapters. Groupie adapter can have child recycler views. The query of the filter will be passed to the child recycler views using filterQueryGetPath and filterQuerySetPath. 	 	 	 	 	 	 	 	 	 	 	 	 	 	 	 
disableItemAnimator   | Disables ItemAnimator by calling recyclerView.setItemAnimator(null);
hasFixedSize          | Signifies that recycler view items have fixed size. Setting this to true will improve the performance of recycler view.

## Configuring Recycler View
The Recycler View in android requires an adpater being configured with view holder pattern being core of its implementation. Ashera provides a generic implementation of the view holder pattern. Hence recycler view can be written by configuring a few attributes.

Also 2 types of adapter has been provided:

ListAdapter - a very basic adapter implementation for simple list and list with header and footer.

GroupieAdapter - an adapter based on https://github.com/lisawray/groupie. 

The following snippet uses a basic adapter:
```
  <androidx.recyclerview.widget.RecyclerView
    android:id="@+id/addSectionItem0"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    modelFor="let item in looptest.textlayout from testObj->view into loopvar as pathmap"
    modelIdPath="id"
    tools:listitem="@layout/listview_testitem"
    app:layoutManager="androidx.recyclerview.widget.LinearLayoutManager"
    viewHolderIds="@+id/name"></androidx.recyclerview.widget.RecyclerView>

```

layout/listview_testitem.xml
```
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/rootView"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="vertical"
    tools:ignore="MissingPrefix" >

    <TextView
        android:id="@+id/name"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        modelPojoToUi="text = a from item->loopvar;background = background from item->loopvar"
        android:text="Name" />

</LinearLayout>
```

The important atributes are discussed below:
* modelFor - Gets the items from list and loop over the items in the list.
* modelIdPath - Required for recycler view to get stableIds so that update can be done on the object.
* tools:listitem - Layout for the child in the recycler view.
* app:layoutManager - Layout manager for the recycler view.
* viewHolderIds - View holder ids for the recycler view. Comma separated ids.

The following snippet uses a basic adapter which provides support for header and footer:
```
  <androidx.recyclerview.widget.RecyclerView
    android:id="@+id/addSectionItem0"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    modelFor="let item in looptest.textlayout from testObj->view into loopvar as pathmap"
    modelIdPath="id"
    layout="@xml/recyclerview_simple"
    app:layoutManager="androidx.recyclerview.widget.LinearLayoutManager"></androidx.recyclerview.widget.RecyclerView>

```
xml/recyclerview_simple.xml
```
<layout adapter="simple">
    <header layout="@layout/listheader"></header>
    <footer layout="@layout/listfooter"></footer>
    <item viewHolderIds="@+id/name" layout='@layout/listview_testitem'></item>
</layout>
```

layout/listview_testitem.xml
```
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/rootView"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="vertical"
    tools:ignore="MissingPrefix" >

    <TextView
        android:id="@+id/name"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        modelPojoToUi="text = a from item->loopvar;background = background from item->loopvar"
        android:text="Name" />

</LinearLayout>
```

xml/listheader.xml
```
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/rootView"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="vertical"
    tools:ignore="MissingPrefix">

    <TextView
        android:id="@+id/textView"
        style="@style/blackBg"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="@string/android_layout_examples" />
</LinearLayout>
```

xml/listfooter.xml
```
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/rootView"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="vertical"
    tools:ignore="MissingPrefix">

    <TextView
        android:id="@+id/textView"
        style="@style/blackBg"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="@string/copyright_ashera" />
</LinearLayout>
```

The important atributes are discussed below:
* layout - XML file which describes the layout. i.e. header, footer, item

The following snippet uses a groupie adapter which provides support for complex layouts using recycler view:

```
    <androidx.recyclerview.widget.RecyclerView
        android:id="@+id/adapterConfig0"
        layout="@xml/recyclerview_groupie"
        background="#fff"
        app:layoutManager="androidx.recyclerview.widget.GridLayoutManager"
        android:orientation="vertical"
        app:spanCount="12"
        itemview_width="match_parent"
        android:layout_width="match_parent"
        android:layout_height="match_parent"></androidx.recyclerview.widget.RecyclerView>
```

xml/recyclerview_groupie.xml
```
<layout adapter="groupie"
    xmlns:app="http://schemas.android.com/apk/res-auto">
    <section id="test">
        <header layout="@layout/listheader"></header>
        <footer layout="@layout/listfooter"></footer>
        <item layout="@layout/listview_testitem" modelFor="let item in test.items from sectionInfo->view into loopvar as map" viewHolderIds="@+id/name"/>
    </section>
    <section id="test1">
        <header layout="@layout/listheader"></header>
        <footer layout="@layout/listfooter"></footer>
        <section id="test2" modelFor="let item in test1.items from sectionInfo->view into loopvar as map">
            <header layout="@layout/listheader_data" viewHolderIds="@+id/textView"></header>
            <item layout="@layout/listview_testitem" modelFor="let item in subitems from item->loopvar into loopvar as map" viewHolderIds="@+id/name"/>
        </section>
    </section>
</layout>
``` 
The groupie adapter consists of sections which can contain another section, item, header and footer. This type of configuration helps to create complex layout using recycler view.

## Drag and Drop
The following attributes enable drag and drop.

Name                	| Description
-------------       	| -------------
dragDirs              | Direction of drag e.g none|up|down|left|right
dragDropMode          | Can be one of these: swaponhighlight (Swap widgets when highlighted), swapwhendropped (Swap widgets on drop)
dragResetHighlightAttributes | Style attributes that needs to be applied to Target/source item when unselected.Style attributes that needs to be applied to Target/source item when unselected.
dragSelectHighlightAttributes | Style attributes that needs to be applied to Target/source item when unselected.Style attributes that needs to be applied to Target/source item when selected.
dragStartMode        | Can be one of these: onclick (Start drag on click) longpress (Start drag on long press)
dragSwapMode         | Can be one of these when ListAdapter is used:notifyItemMoved (Call notifyItemMoved on drop) notifyDataSetChanged (Call notifyDataSetChanged on drop). 
onMove 	             | Call back to javascript when onMove is called.
onMoved 	           | Call back to javascript when onMoved is called. 	 	 	 	 	 	 	 	 	 	 	 	 	 	 	 	 
onSelectedChanged 	 | Call back to javascript when onSelectedChanged is called.

## Swipe
The following attributes enable swipe.

Name                	| Description
-------------       	| -------------
swipeDirs             | Direction of swipe e.g none|up|down|left|right
onSwiped 	            | Call back to javascript when onSwiped is called. 	 	 	 	 	 	 	 	 	 	 	 	 	 	 	 	  	 
deleteOnSwipe         | Enable delete on swipe.
swipeSwapMode         |  Can be one of these when ListAdapter is used:notifyItemRemoved (Call notifyItemRemoved on drop) notifyDataSetChanged (Call notifyDataSetChanged on drop)

To enable/disable drag and drop in groupie adapter for header, footer and item, swipeDirs/dragDirs/dragAcrossSections has been add to the xml.

## Recycler View as GridView.
Recycler view can be configured as grid view with no scroll.

Name                	| Description
-------------       	| -------------
fixedgrid_columnCount | Column count
fixedgrid_rowCount 	 	| Row count
fixedgrid_tileHeight 	| Tile size height of grid view. e.g 300 (Say you displaying 200X300 image in grid view)
fixedgrid_tileWidth   | Tile size of height of grid view. e.g 200 (Say you displaying 200X300 image in grid view)

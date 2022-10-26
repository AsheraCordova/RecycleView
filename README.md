# RecyclerView

RecyclerView project which adds support for android RecyclerView.

## Widgets
* androidx.recyclerview.widget.RecyclerView

Important Links:

https://asheracordova.github.io/

https://asheracordova.github.io/doc/help-doc.html

https://asheracordova.github.io/doc/androidx/recyclerview/widget/RecyclerView.html

## Custom Attributes

The following table lists the custom attributes used in widgets:

### androidx.recyclerview.widget.RecyclerView
Name                	| Description
-------------       	| -------------
viewHolderIds         | Comma separated list of ids which will be used to refresh the widgets when reusing the widgets. See section Configuring Recycler View.
headerDisabled        | When true, header is hidden.
footerDisabled        | When true, footer is hidden.
layout                | Layout xml file.  See section Configuring Recycler View.

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
The groupie adapter consists of sections which can contains another section, item, header ad footer. This type of configuration helps to create complex layout using recycler view.

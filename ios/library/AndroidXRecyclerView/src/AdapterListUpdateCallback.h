//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//  source: D:\Java\git\core-javafx-widget\SWTAndroidXRecyclerView\src\main\java\androidx\recyclerview\widget\AdapterListUpdateCallback.java
//

#include "J2ObjC_header.h"

#pragma push_macro("INCLUDE_ALL_AdapterListUpdateCallback")
#ifdef RESTRICT_AdapterListUpdateCallback
#define INCLUDE_ALL_AdapterListUpdateCallback 0
#else
#define INCLUDE_ALL_AdapterListUpdateCallback 1
#endif
#undef RESTRICT_AdapterListUpdateCallback

#if __has_feature(nullability)
#pragma clang diagnostic push
#pragma GCC diagnostic ignored "-Wnullability"
#pragma GCC diagnostic ignored "-Wnullability-completeness"
#endif

#if !defined (ADXAdapterListUpdateCallback_) && (INCLUDE_ALL_AdapterListUpdateCallback || defined(INCLUDE_ADXAdapterListUpdateCallback))
#define ADXAdapterListUpdateCallback_

#define RESTRICT_ListUpdateCallback 1
#define INCLUDE_ADXListUpdateCallback 1
#include "ListUpdateCallback.h"

@class ADXRecyclerView_Adapter;

/*!
 @brief ListUpdateCallback that dispatches update events to the given adapter.
 - seealso: DiffUtil.DiffResult#dispatchUpdatesTo(RecyclerView.Adapter)
 */
@interface ADXAdapterListUpdateCallback : NSObject < ADXListUpdateCallback >

#pragma mark Public

/*!
 @brief Creates an AdapterListUpdateCallback that will dispatch update events to the given adapter.
 @param adapter The Adapter to send updates to.
 */
- (instancetype)initWithADXRecyclerView_Adapter:(ADXRecyclerView_Adapter *)adapter;

/*!
 */
- (void)onChangedWithInt:(jint)position
                 withInt:(jint)count
                  withId:(id)payload;

/*!
 */
- (void)onInsertedWithInt:(jint)position
                  withInt:(jint)count;

/*!
 */
- (void)onMovedWithInt:(jint)fromPosition
               withInt:(jint)toPosition;

/*!
 */
- (void)onRemovedWithInt:(jint)position
                 withInt:(jint)count;

// Disallowed inherited constructors, do not use.

- (instancetype)init NS_UNAVAILABLE;

@end

J2OBJC_EMPTY_STATIC_INIT(ADXAdapterListUpdateCallback)

FOUNDATION_EXPORT void ADXAdapterListUpdateCallback_initWithADXRecyclerView_Adapter_(ADXAdapterListUpdateCallback *self, ADXRecyclerView_Adapter *adapter);

FOUNDATION_EXPORT ADXAdapterListUpdateCallback *new_ADXAdapterListUpdateCallback_initWithADXRecyclerView_Adapter_(ADXRecyclerView_Adapter *adapter) NS_RETURNS_RETAINED;

FOUNDATION_EXPORT ADXAdapterListUpdateCallback *create_ADXAdapterListUpdateCallback_initWithADXRecyclerView_Adapter_(ADXRecyclerView_Adapter *adapter);

J2OBJC_TYPE_LITERAL_HEADER(ADXAdapterListUpdateCallback)

@compatibility_alias AndroidxRecyclerviewWidgetAdapterListUpdateCallback ADXAdapterListUpdateCallback;

#endif


#if __has_feature(nullability)
#pragma clang diagnostic pop
#endif
#pragma pop_macro("INCLUDE_ALL_AdapterListUpdateCallback")

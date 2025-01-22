//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//  source: D:\Java\git\core-ios-widgets\IOSRecycleViewPlugin\src\main\java\com\ashera\recycleview\RecyclerViewImpl.java
//

#include "J2ObjC_header.h"

#pragma push_macro("INCLUDE_ALL_RecyclerViewImpl")
#ifdef RESTRICT_RecyclerViewImpl
#define INCLUDE_ALL_RecyclerViewImpl 0
#else
#define INCLUDE_ALL_RecyclerViewImpl 1
#endif
#undef RESTRICT_RecyclerViewImpl
#ifdef INCLUDE_ASRecyclerViewImpl_GenericExpandableItem
#define INCLUDE_ASRecyclerViewImpl_GenericItem 1
#endif

#if __has_feature(nullability)
#pragma clang diagnostic push
#pragma GCC diagnostic ignored "-Wnullability"
#pragma GCC diagnostic ignored "-Wnullability-completeness"
#endif

#if !defined (ASRecyclerViewImpl_) && (INCLUDE_ALL_RecyclerViewImpl || defined(INCLUDE_ASRecyclerViewImpl))
#define ASRecyclerViewImpl_

#define RESTRICT_BaseHasWidgets 1
#define INCLUDE_ASBaseHasWidgets 1
#include "BaseHasWidgets.h"

@class ADView;
@class ASLoopParam;
@class ASRecyclerViewImpl_SectionHolder;
@class ASWidgetAttribute;
@class IOSClass;
@protocol ASIFragment;
@protocol ASILifeCycleDecorator;
@protocol ASIWidget;
@protocol JavaUtilList;
@protocol JavaUtilMap;

@interface ASRecyclerViewImpl : ASBaseHasWidgets {
 @public
  id<JavaUtilMap> layout_;
}
@property id uiView;

#pragma mark Public

- (instancetype)init;

- (instancetype)initWithNSString:(NSString *)localname;

- (instancetype)initWithNSString:(NSString *)groupName
                    withNSString:(NSString *)localname;

- (void)addWithASIWidget:(id<ASIWidget>)w
                 withInt:(jint)index;

- (void)addAllModelWithId:(id)objValue;

- (void)applyModelToWidget;

- (jboolean)areWidgetItemsRecycled;

- (id)asNativeWidget;

- (id)asWidget;

- (jboolean)checkIosVersionWithNSString:(NSString *)v;

- (void)clear;

- (void)createWithASIFragment:(id<ASIFragment>)fragment
              withJavaUtilMap:(id<JavaUtilMap>)params;

- (id)createView;

- (id)getAttributeWithASWidgetAttribute:(ASWidgetAttribute *)key
              withASILifeCycleDecorator:(id<ASILifeCycleDecorator>)decorator;

- (id)getChildAttributeWithASIWidget:(id<ASIWidget>)w
               withASWidgetAttribute:(ASWidgetAttribute *)key;

- (id<JavaUtilList>)getChildItemsWithASRecyclerViewImpl_SectionHolder:(ASRecyclerViewImpl_SectionHolder *)sectionHolder
                                                      withJavaUtilMap:(id<JavaUtilMap>)itemConfig;

- (IOSClass *)getViewClass;

- (void)invalidate;

- (jboolean)isHorizontal;

- (void)loadAttributesWithNSString:(NSString *)localName;

- (id)nativescrollViewCreateWithBoolean:(jboolean)scrollIndicator
                            withBoolean:(jboolean)userInteractionEnabled
                            withBoolean:(jboolean)infiniteScroll;

- (id<ASIWidget>)newInstance OBJC_METHOD_FAMILY_NONE;

- (void)notifyDataSetChanged;

- (jboolean)removeWithInt:(jint)index;

- (void)requestLayout;

- (void)setAttributeWithASWidgetAttribute:(ASWidgetAttribute *)key
                             withNSString:(NSString *)strValue
                                   withId:(id)objValue
                withASILifeCycleDecorator:(id<ASILifeCycleDecorator>)decorator;

- (void)setChildAttributeWithASIWidget:(id<ASIWidget>)w
                 withASWidgetAttribute:(ASWidgetAttribute *)key
                          withNSString:(NSString *)strValue
                                withId:(id)objValue;

- (void)setIdWithNSString:(NSString *)id_;

- (void)setItemViewParamsWithASIWidget:(id<ASIWidget>)widget
                            withADView:(ADView *)itemView;

- (void)setVisibleWithBoolean:(jboolean)b;

- (void)updateContentSizeOfScrolledProviderWithInt:(jint)range;

#pragma mark Protected

- (void)addObjectWithASLoopParam:(ASLoopParam *)childModel
                    withNSString:(NSString *)modelIdPath
                         withInt:(jint)index
                    withNSString:(NSString *)currentLoopVar;

- (void)clearModel;

- (jboolean)filterDataWithId:(id)model;

- (void)invalidateChildIfRequiredWithASIWidget:(id<ASIWidget>)childWidget;

#pragma mark Package-Private

- (void)adjustScrollOffsetWhenEdgeReachedWithInt:(jint)dpos;

@end

J2OBJC_EMPTY_STATIC_INIT(ASRecyclerViewImpl)

J2OBJC_FIELD_SETTER(ASRecyclerViewImpl, layout_, id<JavaUtilMap>)

inline NSString *ASRecyclerViewImpl_get_LOCAL_NAME(void);
/*! INTERNAL ONLY - Use accessor function from above. */
FOUNDATION_EXPORT NSString *ASRecyclerViewImpl_LOCAL_NAME;
J2OBJC_STATIC_FIELD_OBJ_FINAL(ASRecyclerViewImpl, LOCAL_NAME, NSString *)

inline NSString *ASRecyclerViewImpl_get_GROUP_NAME(void);
/*! INTERNAL ONLY - Use accessor function from above. */
FOUNDATION_EXPORT NSString *ASRecyclerViewImpl_GROUP_NAME;
J2OBJC_STATIC_FIELD_OBJ_FINAL(ASRecyclerViewImpl, GROUP_NAME, NSString *)

FOUNDATION_EXPORT void ASRecyclerViewImpl_init(ASRecyclerViewImpl *self);

FOUNDATION_EXPORT ASRecyclerViewImpl *new_ASRecyclerViewImpl_init(void) NS_RETURNS_RETAINED;

FOUNDATION_EXPORT ASRecyclerViewImpl *create_ASRecyclerViewImpl_init(void);

FOUNDATION_EXPORT void ASRecyclerViewImpl_initWithNSString_(ASRecyclerViewImpl *self, NSString *localname);

FOUNDATION_EXPORT ASRecyclerViewImpl *new_ASRecyclerViewImpl_initWithNSString_(NSString *localname) NS_RETURNS_RETAINED;

FOUNDATION_EXPORT ASRecyclerViewImpl *create_ASRecyclerViewImpl_initWithNSString_(NSString *localname);

FOUNDATION_EXPORT void ASRecyclerViewImpl_initWithNSString_withNSString_(ASRecyclerViewImpl *self, NSString *groupName, NSString *localname);

FOUNDATION_EXPORT ASRecyclerViewImpl *new_ASRecyclerViewImpl_initWithNSString_withNSString_(NSString *groupName, NSString *localname) NS_RETURNS_RETAINED;

FOUNDATION_EXPORT ASRecyclerViewImpl *create_ASRecyclerViewImpl_initWithNSString_withNSString_(NSString *groupName, NSString *localname);

J2OBJC_TYPE_LITERAL_HEADER(ASRecyclerViewImpl)

@compatibility_alias ComAsheraRecycleviewRecyclerViewImpl ASRecyclerViewImpl;

#endif

#if !defined (ASRecyclerViewImpl_Orientation_) && (INCLUDE_ALL_RecyclerViewImpl || defined(INCLUDE_ASRecyclerViewImpl_Orientation))
#define ASRecyclerViewImpl_Orientation_

#define RESTRICT_AbstractEnumToIntConverter 1
#define INCLUDE_ASAbstractEnumToIntConverter 1
#include "AbstractEnumToIntConverter.h"

@class JavaLangInteger;
@protocol JavaUtilMap;

@interface ASRecyclerViewImpl_Orientation : ASAbstractEnumToIntConverter

#pragma mark Public

- (JavaLangInteger *)getDefault;

- (id<JavaUtilMap>)getMapping;

#pragma mark Package-Private

- (instancetype)init;

@end

J2OBJC_EMPTY_STATIC_INIT(ASRecyclerViewImpl_Orientation)

FOUNDATION_EXPORT void ASRecyclerViewImpl_Orientation_init(ASRecyclerViewImpl_Orientation *self);

FOUNDATION_EXPORT ASRecyclerViewImpl_Orientation *new_ASRecyclerViewImpl_Orientation_init(void) NS_RETURNS_RETAINED;

FOUNDATION_EXPORT ASRecyclerViewImpl_Orientation *create_ASRecyclerViewImpl_Orientation_init(void);

J2OBJC_TYPE_LITERAL_HEADER(ASRecyclerViewImpl_Orientation)

#endif

#if !defined (ASRecyclerViewImpl_RecyclerViewExt_) && (INCLUDE_ALL_RecyclerViewImpl || defined(INCLUDE_ASRecyclerViewImpl_RecyclerViewExt))
#define ASRecyclerViewImpl_RecyclerViewExt_

#define RESTRICT_RecyclerView 1
#define INCLUDE_ADXRecyclerView 1
#include "RecyclerView.h"

#define RESTRICT_ILifeCycleDecorator 1
#define INCLUDE_ASILifeCycleDecorator 1
#include "ILifeCycleDecorator.h"

#define RESTRICT_IMaxDimension 1
#define INCLUDE_ASIMaxDimension 1
#include "IMaxDimension.h"

@class ADRect;
@class ADView;
@class ASRecyclerViewImpl;
@class ASWidgetAttribute;
@class IOSIntArray;
@class IOSObjectArray;
@protocol ASIWidget;
@protocol JavaUtilList;

@interface ASRecyclerViewImpl_RecyclerViewExt : ADXRecyclerView < ASILifeCycleDecorator, ASIMaxDimension >

#pragma mark Public

- (instancetype)initWithASRecyclerViewImpl:(ASRecyclerViewImpl *)outer$;

- (void)drawableStateChanged;

- (void)endViewTransitionWithADView:(ADView *)view;

- (void)executeWithNSString:(NSString *)method
          withNSObjectArray:(IOSObjectArray *)canvas;

- (id)getAttributeWithASWidgetAttribute:(ASWidgetAttribute *)widgetAttribute;

- (void)getLocationOnScreenWithIntArray:(IOSIntArray *)appScreenLocation;

- (jint)getMaxHeight;

- (jint)getMaxWidth;

- (id<JavaUtilList>)getMethods;

- (id<ASIWidget>)getWidget;

- (void)getWindowVisibleDisplayFrameWithADRect:(ADRect *)displayFrame;

- (ADView *)inflateViewWithNSString:(NSString *)layout;

- (void)initialized OBJC_METHOD_FAMILY_NONE;

- (id<ASILifeCycleDecorator>)newInstanceWithASIWidget:(id<ASIWidget>)widget OBJC_METHOD_FAMILY_NONE;

- (void)offsetLeftAndRightWithInt:(jint)offset;

- (void)offsetTopAndBottomWithInt:(jint)offset;

- (void)onMeasureWithInt:(jint)widthMeasureSpec
                 withInt:(jint)heightMeasureSpec;

- (void)remeasure;

- (void)removeFromParent;

- (void)setAttributeWithASWidgetAttribute:(ASWidgetAttribute *)widgetAttribute
                             withNSString:(NSString *)strValue
                                   withId:(id)objValue;

- (void)setMaxHeightWithInt:(jint)height;

- (void)setMaxWidthWithInt:(jint)width;

- (void)setMyAttributeWithNSString:(NSString *)name
                            withId:(id)value;

- (void)setState0WithId:(id)value;

- (void)setState1WithId:(id)value;

- (void)setState2WithId:(id)value;

- (void)setState3WithId:(id)value;

- (void)setState4WithId:(id)value;

- (void)setVisibilityWithInt:(jint)visibility;

- (void)state0;

- (void)state1;

- (void)state2;

- (void)state3;

- (void)state4;

- (void)stateNo;

- (void)stateYes;

- (void)updateMeasuredDimensionWithInt:(jint)width
                               withInt:(jint)height;

#pragma mark Protected

- (void)onLayoutWithBoolean:(jboolean)changed
                    withInt:(jint)l
                    withInt:(jint)t
                    withInt:(jint)r
                    withInt:(jint)b;

// Disallowed inherited constructors, do not use.

- (instancetype)init NS_UNAVAILABLE;

@end

J2OBJC_EMPTY_STATIC_INIT(ASRecyclerViewImpl_RecyclerViewExt)

FOUNDATION_EXPORT void ASRecyclerViewImpl_RecyclerViewExt_initWithASRecyclerViewImpl_(ASRecyclerViewImpl_RecyclerViewExt *self, ASRecyclerViewImpl *outer$);

FOUNDATION_EXPORT ASRecyclerViewImpl_RecyclerViewExt *new_ASRecyclerViewImpl_RecyclerViewExt_initWithASRecyclerViewImpl_(ASRecyclerViewImpl *outer$) NS_RETURNS_RETAINED;

FOUNDATION_EXPORT ASRecyclerViewImpl_RecyclerViewExt *create_ASRecyclerViewImpl_RecyclerViewExt_initWithASRecyclerViewImpl_(ASRecyclerViewImpl *outer$);

J2OBJC_TYPE_LITERAL_HEADER(ASRecyclerViewImpl_RecyclerViewExt)

#endif

#if !defined (ASRecyclerViewImpl_ScrollProviderType_) && (INCLUDE_ALL_RecyclerViewImpl || defined(INCLUDE_ASRecyclerViewImpl_ScrollProviderType))
#define ASRecyclerViewImpl_ScrollProviderType_

#define RESTRICT_JavaLangEnum 1
#define INCLUDE_JavaLangEnum 1
#include "java/lang/Enum.h"

@class IOSObjectArray;

typedef NS_ENUM(NSUInteger, ASRecyclerViewImpl_ScrollProviderType_Enum) {
  ASRecyclerViewImpl_ScrollProviderType_Enum_READ_ONLY = 0,
  ASRecyclerViewImpl_ScrollProviderType_Enum_DRAGABBLE = 1,
};

@interface ASRecyclerViewImpl_ScrollProviderType : JavaLangEnum

#pragma mark Public

+ (ASRecyclerViewImpl_ScrollProviderType *)valueOfWithNSString:(NSString *)name;

+ (IOSObjectArray *)values;

#pragma mark Package-Private

- (ASRecyclerViewImpl_ScrollProviderType_Enum)toNSEnum;

@end

J2OBJC_STATIC_INIT(ASRecyclerViewImpl_ScrollProviderType)

/*! INTERNAL ONLY - Use enum accessors declared below. */
FOUNDATION_EXPORT ASRecyclerViewImpl_ScrollProviderType *ASRecyclerViewImpl_ScrollProviderType_values_[];

inline ASRecyclerViewImpl_ScrollProviderType *ASRecyclerViewImpl_ScrollProviderType_get_READ_ONLY(void);
J2OBJC_ENUM_CONSTANT(ASRecyclerViewImpl_ScrollProviderType, READ_ONLY)

inline ASRecyclerViewImpl_ScrollProviderType *ASRecyclerViewImpl_ScrollProviderType_get_DRAGABBLE(void);
J2OBJC_ENUM_CONSTANT(ASRecyclerViewImpl_ScrollProviderType, DRAGABBLE)

FOUNDATION_EXPORT IOSObjectArray *ASRecyclerViewImpl_ScrollProviderType_values(void);

FOUNDATION_EXPORT ASRecyclerViewImpl_ScrollProviderType *ASRecyclerViewImpl_ScrollProviderType_valueOfWithNSString_(NSString *name);

FOUNDATION_EXPORT ASRecyclerViewImpl_ScrollProviderType *ASRecyclerViewImpl_ScrollProviderType_fromOrdinal(NSUInteger ordinal);

J2OBJC_TYPE_LITERAL_HEADER(ASRecyclerViewImpl_ScrollProviderType)

#endif

#if !defined (ASRecyclerViewImpl_ListAdapter_) && (INCLUDE_ALL_RecyclerViewImpl || defined(INCLUDE_ASRecyclerViewImpl_ListAdapter))
#define ASRecyclerViewImpl_ListAdapter_

#define RESTRICT_RecyclerView 1
#define INCLUDE_ADXRecyclerView_Adapter 1
#include "RecyclerView.h"

@class ADViewGroup;
@class ASRecyclerViewImpl;
@class ASRecyclerViewImpl_ViewHolder;

@interface ASRecyclerViewImpl_ListAdapter : ADXRecyclerView_Adapter

#pragma mark Public

- (instancetype)initWithASRecyclerViewImpl:(ASRecyclerViewImpl *)outer$;

- (ASRecyclerViewImpl_ViewHolder *)createViewHolderWithADViewGroup:(ADViewGroup *)arg0
                                                           withInt:(jint)arg1;

- (jint)getItemCount;

- (jlong)getItemIdWithInt:(jint)position;

- (jint)getItemViewTypeWithInt:(jint)position;

- (void)onBindViewHolderWithADXRecyclerView_ViewHolder:(ASRecyclerViewImpl_ViewHolder *)viewHolder
                                               withInt:(jint)position;

- (ASRecyclerViewImpl_ViewHolder *)onCreateViewHolderWithADViewGroup:(ADViewGroup *)parent
                                                             withInt:(jint)viewType;

- (void)onViewAttachedToWindowWithADXRecyclerView_ViewHolder:(ASRecyclerViewImpl_ViewHolder *)holder;

- (void)onViewDetachedFromWindowWithADXRecyclerView_ViewHolder:(ASRecyclerViewImpl_ViewHolder *)holder;

// Disallowed inherited constructors, do not use.

- (instancetype)init NS_UNAVAILABLE;

@end

J2OBJC_EMPTY_STATIC_INIT(ASRecyclerViewImpl_ListAdapter)

FOUNDATION_EXPORT void ASRecyclerViewImpl_ListAdapter_initWithASRecyclerViewImpl_(ASRecyclerViewImpl_ListAdapter *self, ASRecyclerViewImpl *outer$);

FOUNDATION_EXPORT ASRecyclerViewImpl_ListAdapter *new_ASRecyclerViewImpl_ListAdapter_initWithASRecyclerViewImpl_(ASRecyclerViewImpl *outer$) NS_RETURNS_RETAINED;

FOUNDATION_EXPORT ASRecyclerViewImpl_ListAdapter *create_ASRecyclerViewImpl_ListAdapter_initWithASRecyclerViewImpl_(ASRecyclerViewImpl *outer$);

J2OBJC_TYPE_LITERAL_HEADER(ASRecyclerViewImpl_ListAdapter)

#endif

#if !defined (ASRecyclerViewImpl_ViewHolder_) && (INCLUDE_ALL_RecyclerViewImpl || defined(INCLUDE_ASRecyclerViewImpl_ViewHolder))
#define ASRecyclerViewImpl_ViewHolder_

#define RESTRICT_RecyclerView 1
#define INCLUDE_ADXRecyclerView_ViewHolder 1
#include "RecyclerView.h"

@class ADView;
@class ASRecyclerViewImpl;
@class ASWidgetViewHolder;
@protocol ASIWidget;
@protocol JavaUtilList;

@interface ASRecyclerViewImpl_ViewHolder : ADXRecyclerView_ViewHolder {
 @public
  ASWidgetViewHolder *widgetViewHolder_;
}

#pragma mark Public

- (instancetype)initWithASRecyclerViewImpl:(ASRecyclerViewImpl *)outer$
                             withASIWidget:(id<ASIWidget>)widget
                                withADView:(ADView *)itemView
                          withJavaUtilList:(id<JavaUtilList>)viewHolderIds;

// Disallowed inherited constructors, do not use.

- (instancetype)initWithADView:(ADView *)arg0 NS_UNAVAILABLE;

@end

J2OBJC_EMPTY_STATIC_INIT(ASRecyclerViewImpl_ViewHolder)

J2OBJC_FIELD_SETTER(ASRecyclerViewImpl_ViewHolder, widgetViewHolder_, ASWidgetViewHolder *)

FOUNDATION_EXPORT void ASRecyclerViewImpl_ViewHolder_initWithASRecyclerViewImpl_withASIWidget_withADView_withJavaUtilList_(ASRecyclerViewImpl_ViewHolder *self, ASRecyclerViewImpl *outer$, id<ASIWidget> widget, ADView *itemView, id<JavaUtilList> viewHolderIds);

FOUNDATION_EXPORT ASRecyclerViewImpl_ViewHolder *new_ASRecyclerViewImpl_ViewHolder_initWithASRecyclerViewImpl_withASIWidget_withADView_withJavaUtilList_(ASRecyclerViewImpl *outer$, id<ASIWidget> widget, ADView *itemView, id<JavaUtilList> viewHolderIds) NS_RETURNS_RETAINED;

FOUNDATION_EXPORT ASRecyclerViewImpl_ViewHolder *create_ASRecyclerViewImpl_ViewHolder_initWithASRecyclerViewImpl_withASIWidget_withADView_withJavaUtilList_(ASRecyclerViewImpl *outer$, id<ASIWidget> widget, ADView *itemView, id<JavaUtilList> viewHolderIds);

J2OBJC_TYPE_LITERAL_HEADER(ASRecyclerViewImpl_ViewHolder)

#endif

#if !defined (ASRecyclerViewImpl_SectionHolder_) && (INCLUDE_ALL_RecyclerViewImpl || defined(INCLUDE_ASRecyclerViewImpl_SectionHolder))
#define ASRecyclerViewImpl_SectionHolder_

@class ADXSection;
@class ASLoopParam;
@class ASRecyclerViewImpl;
@protocol JavaUtilMap;

@interface ASRecyclerViewImpl_SectionHolder : NSObject {
 @public
  id<JavaUtilMap> sectionConfigAttrs_;
  ADXSection *section_;
  ASLoopParam *loopParam_;
}

#pragma mark Package-Private

- (instancetype)initWithASRecyclerViewImpl:(ASRecyclerViewImpl *)outer$;

// Disallowed inherited constructors, do not use.

- (instancetype)init NS_UNAVAILABLE;

@end

J2OBJC_EMPTY_STATIC_INIT(ASRecyclerViewImpl_SectionHolder)

J2OBJC_FIELD_SETTER(ASRecyclerViewImpl_SectionHolder, sectionConfigAttrs_, id<JavaUtilMap>)
J2OBJC_FIELD_SETTER(ASRecyclerViewImpl_SectionHolder, section_, ADXSection *)
J2OBJC_FIELD_SETTER(ASRecyclerViewImpl_SectionHolder, loopParam_, ASLoopParam *)

FOUNDATION_EXPORT void ASRecyclerViewImpl_SectionHolder_initWithASRecyclerViewImpl_(ASRecyclerViewImpl_SectionHolder *self, ASRecyclerViewImpl *outer$);

FOUNDATION_EXPORT ASRecyclerViewImpl_SectionHolder *new_ASRecyclerViewImpl_SectionHolder_initWithASRecyclerViewImpl_(ASRecyclerViewImpl *outer$) NS_RETURNS_RETAINED;

FOUNDATION_EXPORT ASRecyclerViewImpl_SectionHolder *create_ASRecyclerViewImpl_SectionHolder_initWithASRecyclerViewImpl_(ASRecyclerViewImpl *outer$);

J2OBJC_TYPE_LITERAL_HEADER(ASRecyclerViewImpl_SectionHolder)

#endif

#if !defined (ASRecyclerViewImpl_GenericItem_) && (INCLUDE_ALL_RecyclerViewImpl || defined(INCLUDE_ASRecyclerViewImpl_GenericItem))
#define ASRecyclerViewImpl_GenericItem_

#define RESTRICT_Item 1
#define INCLUDE_ADXItem 1
#include "Item.h"

@class ADView;
@class ASLoopParam;
@class ASRecyclerViewImpl;
@class ASRecyclerViewImpl_GroupieViewHolder;
@protocol ASIWidget;
@protocol JavaUtilList;

@interface ASRecyclerViewImpl_GenericItem : ADXItem {
 @public
  jint numberOfColums_;
}

#pragma mark Public

- (instancetype)initWithASRecyclerViewImpl:(ASRecyclerViewImpl *)outer$
                              withNSString:(NSString *)layout
                             withASIWidget:(id<ASIWidget>)template_
                           withASLoopParam:(ASLoopParam *)loopParam
                          withJavaUtilList:(id<JavaUtilList>)viewHolderIds;

- (void)bindWithADXGroupieViewHolder:(ASRecyclerViewImpl_GroupieViewHolder *)viewHolder
                             withInt:(jint)position;

- (ASRecyclerViewImpl_GroupieViewHolder *)createViewHolderWithADView:(ADView *)arg0;

- (jint)getLayout;

- (ASLoopParam *)getLoopParam;

- (jint)getMargin;

- (jint)getSpanSizeWithInt:(jint)spanCount
                   withInt:(jint)position;

- (id<ASIWidget>)getTemplate;

- (id<JavaUtilList>)getViewHolderIds;

- (jboolean)isModified;

- (void)setMarginWithInt:(jint)margin;

- (void)setModifiedWithBoolean:(jboolean)modified;

- (void)setNumberOfColumsWithInt:(jint)numberOfColums;

// Disallowed inherited constructors, do not use.

- (instancetype)init NS_UNAVAILABLE;

- (instancetype)initWithLong:(jlong)arg0 NS_UNAVAILABLE;

@end

J2OBJC_EMPTY_STATIC_INIT(ASRecyclerViewImpl_GenericItem)

FOUNDATION_EXPORT void ASRecyclerViewImpl_GenericItem_initWithASRecyclerViewImpl_withNSString_withASIWidget_withASLoopParam_withJavaUtilList_(ASRecyclerViewImpl_GenericItem *self, ASRecyclerViewImpl *outer$, NSString *layout, id<ASIWidget> template_, ASLoopParam *loopParam, id<JavaUtilList> viewHolderIds);

FOUNDATION_EXPORT ASRecyclerViewImpl_GenericItem *new_ASRecyclerViewImpl_GenericItem_initWithASRecyclerViewImpl_withNSString_withASIWidget_withASLoopParam_withJavaUtilList_(ASRecyclerViewImpl *outer$, NSString *layout, id<ASIWidget> template_, ASLoopParam *loopParam, id<JavaUtilList> viewHolderIds) NS_RETURNS_RETAINED;

FOUNDATION_EXPORT ASRecyclerViewImpl_GenericItem *create_ASRecyclerViewImpl_GenericItem_initWithASRecyclerViewImpl_withNSString_withASIWidget_withASLoopParam_withJavaUtilList_(ASRecyclerViewImpl *outer$, NSString *layout, id<ASIWidget> template_, ASLoopParam *loopParam, id<JavaUtilList> viewHolderIds);

J2OBJC_TYPE_LITERAL_HEADER(ASRecyclerViewImpl_GenericItem)

#endif

#if !defined (ASRecyclerViewImpl_GenericExpandableItem_) && (INCLUDE_ALL_RecyclerViewImpl || defined(INCLUDE_ASRecyclerViewImpl_GenericExpandableItem))
#define ASRecyclerViewImpl_GenericExpandableItem_

#define RESTRICT_ExpandableItem 1
#define INCLUDE_ADXExpandableItem 1
#include "ExpandableItem.h"

@class ADView;
@class ADXExpandableGroup;
@class ASLoopParam;
@class ASRecyclerViewImpl;
@class ASRecyclerViewImpl_GroupieViewHolder;
@protocol ASIWidget;
@protocol JavaUtilList;

@interface ASRecyclerViewImpl_GenericExpandableItem : ASRecyclerViewImpl_GenericItem < ADXExpandableItem >

#pragma mark Public

- (instancetype)initWithASRecyclerViewImpl:(ASRecyclerViewImpl *)outer$
                              withNSString:(NSString *)layout
                             withASIWidget:(id<ASIWidget>)template_
                           withASLoopParam:(ASLoopParam *)loopParam
                          withJavaUtilList:(id<JavaUtilList>)viewHolderIds
                          withJavaUtilList:(id<JavaUtilList>)onClickIds;

- (void)bindWithADXGroupieViewHolder:(ASRecyclerViewImpl_GroupieViewHolder *)viewHolder
                             withInt:(jint)position;

- (ASRecyclerViewImpl_GroupieViewHolder *)createViewHolderWithADView:(ADView *)arg0;

- (void)setExpandableGroupWithADXExpandableGroup:(ADXExpandableGroup *)expandableGroup;

// Disallowed inherited constructors, do not use.

- (instancetype)initWithASRecyclerViewImpl:(ASRecyclerViewImpl *)outer$
                              withNSString:(NSString *)arg0
                             withASIWidget:(id<ASIWidget>)arg1
                           withASLoopParam:(ASLoopParam *)arg2
                          withJavaUtilList:(id<JavaUtilList>)arg3 NS_UNAVAILABLE;

@end

J2OBJC_EMPTY_STATIC_INIT(ASRecyclerViewImpl_GenericExpandableItem)

FOUNDATION_EXPORT void ASRecyclerViewImpl_GenericExpandableItem_initWithASRecyclerViewImpl_withNSString_withASIWidget_withASLoopParam_withJavaUtilList_withJavaUtilList_(ASRecyclerViewImpl_GenericExpandableItem *self, ASRecyclerViewImpl *outer$, NSString *layout, id<ASIWidget> template_, ASLoopParam *loopParam, id<JavaUtilList> viewHolderIds, id<JavaUtilList> onClickIds);

FOUNDATION_EXPORT ASRecyclerViewImpl_GenericExpandableItem *new_ASRecyclerViewImpl_GenericExpandableItem_initWithASRecyclerViewImpl_withNSString_withASIWidget_withASLoopParam_withJavaUtilList_withJavaUtilList_(ASRecyclerViewImpl *outer$, NSString *layout, id<ASIWidget> template_, ASLoopParam *loopParam, id<JavaUtilList> viewHolderIds, id<JavaUtilList> onClickIds) NS_RETURNS_RETAINED;

FOUNDATION_EXPORT ASRecyclerViewImpl_GenericExpandableItem *create_ASRecyclerViewImpl_GenericExpandableItem_initWithASRecyclerViewImpl_withNSString_withASIWidget_withASLoopParam_withJavaUtilList_withJavaUtilList_(ASRecyclerViewImpl *outer$, NSString *layout, id<ASIWidget> template_, ASLoopParam *loopParam, id<JavaUtilList> viewHolderIds, id<JavaUtilList> onClickIds);

J2OBJC_TYPE_LITERAL_HEADER(ASRecyclerViewImpl_GenericExpandableItem)

#endif

#if !defined (ASRecyclerViewImpl_GroupieAdapter_) && (INCLUDE_ALL_RecyclerViewImpl || defined(INCLUDE_ASRecyclerViewImpl_GroupieAdapter))
#define ASRecyclerViewImpl_GroupieAdapter_

#define RESTRICT_GroupAdapter 1
#define INCLUDE_ADXGroupAdapter 1
#include "GroupAdapter.h"

@class ADViewGroup;
@class ASRecyclerViewImpl;
@class ASRecyclerViewImpl_GroupieViewHolder;

@interface ASRecyclerViewImpl_GroupieAdapter : ADXGroupAdapter

#pragma mark Public

- (instancetype)initWithASRecyclerViewImpl:(ASRecyclerViewImpl *)outer$;

- (ASRecyclerViewImpl_GroupieViewHolder *)createViewHolderWithADViewGroup:(ADViewGroup *)arg0
                                                                  withInt:(jint)arg1;

- (ASRecyclerViewImpl_GroupieViewHolder *)onCreateViewHolderWithADViewGroup:(ADViewGroup *)parent
                                                                    withInt:(jint)viewType;

- (void)onViewAttachedToWindowWithADXRecyclerView_ViewHolder:(ASRecyclerViewImpl_GroupieViewHolder *)holder;

- (void)onViewDetachedFromWindowWithADXRecyclerView_ViewHolder:(ASRecyclerViewImpl_GroupieViewHolder *)holder;

// Disallowed inherited constructors, do not use.

- (instancetype)init NS_UNAVAILABLE;

@end

J2OBJC_EMPTY_STATIC_INIT(ASRecyclerViewImpl_GroupieAdapter)

FOUNDATION_EXPORT void ASRecyclerViewImpl_GroupieAdapter_initWithASRecyclerViewImpl_(ASRecyclerViewImpl_GroupieAdapter *self, ASRecyclerViewImpl *outer$);

FOUNDATION_EXPORT ASRecyclerViewImpl_GroupieAdapter *new_ASRecyclerViewImpl_GroupieAdapter_initWithASRecyclerViewImpl_(ASRecyclerViewImpl *outer$) NS_RETURNS_RETAINED;

FOUNDATION_EXPORT ASRecyclerViewImpl_GroupieAdapter *create_ASRecyclerViewImpl_GroupieAdapter_initWithASRecyclerViewImpl_(ASRecyclerViewImpl *outer$);

J2OBJC_TYPE_LITERAL_HEADER(ASRecyclerViewImpl_GroupieAdapter)

#endif

#if !defined (ASRecyclerViewImpl_GroupieViewHolder_) && (INCLUDE_ALL_RecyclerViewImpl || defined(INCLUDE_ASRecyclerViewImpl_GroupieViewHolder))
#define ASRecyclerViewImpl_GroupieViewHolder_

#define RESTRICT_GroupieViewHolder 1
#define INCLUDE_ADXGroupieViewHolder 1
#include "GroupieViewHolder.h"

@class ADView;
@class ASRecyclerViewImpl;
@class ASWidgetViewHolder;
@protocol ASIWidget;
@protocol JavaUtilList;

@interface ASRecyclerViewImpl_GroupieViewHolder : ADXGroupieViewHolder {
 @public
  ASWidgetViewHolder *widgetViewHolder_;
}

#pragma mark Public

- (instancetype)initWithASRecyclerViewImpl:(ASRecyclerViewImpl *)outer$
                             withASIWidget:(id<ASIWidget>)widget
                                withADView:(ADView *)itemView
                          withJavaUtilList:(id<JavaUtilList>)viewHolderIds;

// Disallowed inherited constructors, do not use.

- (instancetype)initWithADView:(ADView *)arg0 NS_UNAVAILABLE;

@end

J2OBJC_EMPTY_STATIC_INIT(ASRecyclerViewImpl_GroupieViewHolder)

J2OBJC_FIELD_SETTER(ASRecyclerViewImpl_GroupieViewHolder, widgetViewHolder_, ASWidgetViewHolder *)

FOUNDATION_EXPORT void ASRecyclerViewImpl_GroupieViewHolder_initWithASRecyclerViewImpl_withASIWidget_withADView_withJavaUtilList_(ASRecyclerViewImpl_GroupieViewHolder *self, ASRecyclerViewImpl *outer$, id<ASIWidget> widget, ADView *itemView, id<JavaUtilList> viewHolderIds);

FOUNDATION_EXPORT ASRecyclerViewImpl_GroupieViewHolder *new_ASRecyclerViewImpl_GroupieViewHolder_initWithASRecyclerViewImpl_withASIWidget_withADView_withJavaUtilList_(ASRecyclerViewImpl *outer$, id<ASIWidget> widget, ADView *itemView, id<JavaUtilList> viewHolderIds) NS_RETURNS_RETAINED;

FOUNDATION_EXPORT ASRecyclerViewImpl_GroupieViewHolder *create_ASRecyclerViewImpl_GroupieViewHolder_initWithASRecyclerViewImpl_withASIWidget_withADView_withJavaUtilList_(ASRecyclerViewImpl *outer$, id<ASIWidget> widget, ADView *itemView, id<JavaUtilList> viewHolderIds);

J2OBJC_TYPE_LITERAL_HEADER(ASRecyclerViewImpl_GroupieViewHolder)

#endif

#if !defined (ASRecyclerViewImpl_UIScrollViewDelegate_) && (INCLUDE_ALL_RecyclerViewImpl || defined(INCLUDE_ASRecyclerViewImpl_UIScrollViewDelegate))
#define ASRecyclerViewImpl_UIScrollViewDelegate_

@class ASRecyclerViewImpl;

@interface ASRecyclerViewImpl_UIScrollViewDelegate : NSObject

#pragma mark Public

- (instancetype)initWithASRecyclerViewImpl:(ASRecyclerViewImpl *)outer$;

- (void)nativeScrollChangeListenerWithId:(id)nativeWidget;

- (void)onscrollWithInt:(jint)scrollX
                withInt:(jint)scrollY;

#pragma mark Package-Private

// Disallowed inherited constructors, do not use.

- (instancetype)init NS_UNAVAILABLE;

@end

J2OBJC_EMPTY_STATIC_INIT(ASRecyclerViewImpl_UIScrollViewDelegate)

FOUNDATION_EXPORT void ASRecyclerViewImpl_UIScrollViewDelegate_initWithASRecyclerViewImpl_(ASRecyclerViewImpl_UIScrollViewDelegate *self, ASRecyclerViewImpl *outer$);

FOUNDATION_EXPORT ASRecyclerViewImpl_UIScrollViewDelegate *new_ASRecyclerViewImpl_UIScrollViewDelegate_initWithASRecyclerViewImpl_(ASRecyclerViewImpl *outer$) NS_RETURNS_RETAINED;

FOUNDATION_EXPORT ASRecyclerViewImpl_UIScrollViewDelegate *create_ASRecyclerViewImpl_UIScrollViewDelegate_initWithASRecyclerViewImpl_(ASRecyclerViewImpl *outer$);

J2OBJC_TYPE_LITERAL_HEADER(ASRecyclerViewImpl_UIScrollViewDelegate)

#endif


#if __has_feature(nullability)
#pragma clang diagnostic pop
#endif
#pragma pop_macro("INCLUDE_ALL_RecyclerViewImpl")

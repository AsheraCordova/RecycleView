//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//  source: D:\Java\git\core-javafx-widget\SWTAndroidXRecyclerView\src\main\java\com\xwray\groupie\AsyncDiffUtil.java
//

#include "J2ObjC_header.h"

#pragma push_macro("INCLUDE_ALL_AsyncDiffUtil")
#ifdef RESTRICT_AsyncDiffUtil
#define INCLUDE_ALL_AsyncDiffUtil 0
#else
#define INCLUDE_ALL_AsyncDiffUtil 1
#endif
#undef RESTRICT_AsyncDiffUtil

#if __has_feature(nullability)
#pragma clang diagnostic push
#pragma GCC diagnostic ignored "-Wnullability"
#pragma GCC diagnostic ignored "-Wnullability-completeness"
#endif

#if !defined (ADXAsyncDiffUtil_) && (INCLUDE_ALL_AsyncDiffUtil || defined(INCLUDE_ADXAsyncDiffUtil))
#define ADXAsyncDiffUtil_

@class ADXDiffUtil_Callback;
@protocol ADXAsyncDiffUtil_Callback;
@protocol ADXOnAsyncUpdateListener;
@protocol JavaUtilCollection;

/*!
 @brief A wrapper around <code>DiffUtil</code> that calculates diff in a background thread
 */
@interface ADXAsyncDiffUtil : NSObject

#pragma mark Package-Private

- (instancetype)initPackagePrivateWithADXAsyncDiffUtil_Callback:(id<ADXAsyncDiffUtil_Callback>)callback;

- (void)calculateDiffWithJavaUtilCollection:(id<JavaUtilCollection>)newGroups
                   withADXDiffUtil_Callback:(ADXDiffUtil_Callback *)diffUtilCallback
               withADXOnAsyncUpdateListener:(id<ADXOnAsyncUpdateListener>)onAsyncUpdateListener
                                withBoolean:(jboolean)detectMoves;

- (id<ADXAsyncDiffUtil_Callback>)getAsyncDiffUtilCallback;

- (id<JavaUtilCollection>)getGroups;

- (jint)getMaxScheduledGeneration;

// Disallowed inherited constructors, do not use.

- (instancetype)init NS_UNAVAILABLE;

@end

J2OBJC_EMPTY_STATIC_INIT(ADXAsyncDiffUtil)

FOUNDATION_EXPORT void ADXAsyncDiffUtil_initPackagePrivateWithADXAsyncDiffUtil_Callback_(ADXAsyncDiffUtil *self, id<ADXAsyncDiffUtil_Callback> callback);

FOUNDATION_EXPORT ADXAsyncDiffUtil *new_ADXAsyncDiffUtil_initPackagePrivateWithADXAsyncDiffUtil_Callback_(id<ADXAsyncDiffUtil_Callback> callback) NS_RETURNS_RETAINED;

FOUNDATION_EXPORT ADXAsyncDiffUtil *create_ADXAsyncDiffUtil_initPackagePrivateWithADXAsyncDiffUtil_Callback_(id<ADXAsyncDiffUtil_Callback> callback);

J2OBJC_TYPE_LITERAL_HEADER(ADXAsyncDiffUtil)

@compatibility_alias ComXwrayGroupieAsyncDiffUtil ADXAsyncDiffUtil;

#endif

#if !defined (ADXAsyncDiffUtil_Callback_) && (INCLUDE_ALL_AsyncDiffUtil || defined(INCLUDE_ADXAsyncDiffUtil_Callback))
#define ADXAsyncDiffUtil_Callback_

#define RESTRICT_ListUpdateCallback 1
#define INCLUDE_ADXListUpdateCallback 1
#include "ListUpdateCallback.h"

@protocol JavaUtilCollection;

@protocol ADXAsyncDiffUtil_Callback < ADXListUpdateCallback, JavaObject >

/*!
 @brief Called on the main thread before DiffUtil dispatches the result
 */
- (void)onDispatchAsyncResultWithJavaUtilCollection:(id<JavaUtilCollection>)newGroups;

@end

J2OBJC_EMPTY_STATIC_INIT(ADXAsyncDiffUtil_Callback)

J2OBJC_TYPE_LITERAL_HEADER(ADXAsyncDiffUtil_Callback)

#endif


#if __has_feature(nullability)
#pragma clang diagnostic pop
#endif
#pragma pop_macro("INCLUDE_ALL_AsyncDiffUtil")

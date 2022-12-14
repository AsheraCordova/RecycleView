//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//  source: D:\Java\git\core-javafx-widget\SWTAndroidXRecyclerView\src\main\java\com\xwray\groupie\DiffTask.java
//

#include "J2ObjC_header.h"

#pragma push_macro("INCLUDE_ALL_DiffTask")
#ifdef RESTRICT_DiffTask
#define INCLUDE_ALL_DiffTask 0
#else
#define INCLUDE_ALL_DiffTask 1
#endif
#undef RESTRICT_DiffTask

#if __has_feature(nullability)
#pragma clang diagnostic push
#pragma GCC diagnostic ignored "-Wnullability"
#pragma GCC diagnostic ignored "-Wnullability-completeness"
#endif

#if !defined (ADXDiffTask_) && (INCLUDE_ALL_DiffTask || defined(INCLUDE_ADXDiffTask))
#define ADXDiffTask_

#define RESTRICT_AsyncTask 1
#define INCLUDE_ADAsyncTask 1
#include "AsyncTask.h"

@class ADXAsyncDiffUtil;
@class ADXDiffUtil_Callback;
@class ADXDiffUtil_DiffResult;
@class IOSObjectArray;
@protocol ADXOnAsyncUpdateListener;

/*!
 @brief An async task implementation that runs <code>DiffUtil.calculateDiff(DiffUtil.Callback)</code>
  in a background thread.This task will call <code>AsyncDiffUtil.Callback.onDispatchAsyncResult(Collection)</code>
  passing the new list just before dispatching the diff result to the provided 
 <code>DiffUtil.Callback</code> so that the new list.
 <p>This task is executed via <code>AsyncDiffUtil.calculateDiff(Collection, DiffUtil.Callback, OnAsyncUpdateListener, boolean)</code>.
 */
@interface ADXDiffTask : ADAsyncTask

#pragma mark Protected

- (ADXDiffUtil_DiffResult *)doInBackgroundWithNSObjectArray:(IOSObjectArray *)voids;

- (void)onPostExecuteWithId:(ADXDiffUtil_DiffResult *)diffResult;

#pragma mark Package-Private

- (instancetype)initPackagePrivateWithADXAsyncDiffUtil:(ADXAsyncDiffUtil *)asyncDiffUtil
                              withADXDiffUtil_Callback:(ADXDiffUtil_Callback *)callback
                                               withInt:(jint)runGeneration
                                           withBoolean:(jboolean)detectMoves
                          withADXOnAsyncUpdateListener:(id<ADXOnAsyncUpdateListener>)onAsyncUpdateListener;

// Disallowed inherited constructors, do not use.

- (instancetype)init NS_UNAVAILABLE;

@end

J2OBJC_EMPTY_STATIC_INIT(ADXDiffTask)

FOUNDATION_EXPORT void ADXDiffTask_initPackagePrivateWithADXAsyncDiffUtil_withADXDiffUtil_Callback_withInt_withBoolean_withADXOnAsyncUpdateListener_(ADXDiffTask *self, ADXAsyncDiffUtil *asyncDiffUtil, ADXDiffUtil_Callback *callback, jint runGeneration, jboolean detectMoves, id<ADXOnAsyncUpdateListener> onAsyncUpdateListener);

FOUNDATION_EXPORT ADXDiffTask *new_ADXDiffTask_initPackagePrivateWithADXAsyncDiffUtil_withADXDiffUtil_Callback_withInt_withBoolean_withADXOnAsyncUpdateListener_(ADXAsyncDiffUtil *asyncDiffUtil, ADXDiffUtil_Callback *callback, jint runGeneration, jboolean detectMoves, id<ADXOnAsyncUpdateListener> onAsyncUpdateListener) NS_RETURNS_RETAINED;

FOUNDATION_EXPORT ADXDiffTask *create_ADXDiffTask_initPackagePrivateWithADXAsyncDiffUtil_withADXDiffUtil_Callback_withInt_withBoolean_withADXOnAsyncUpdateListener_(ADXAsyncDiffUtil *asyncDiffUtil, ADXDiffUtil_Callback *callback, jint runGeneration, jboolean detectMoves, id<ADXOnAsyncUpdateListener> onAsyncUpdateListener);

J2OBJC_TYPE_LITERAL_HEADER(ADXDiffTask)

@compatibility_alias ComXwrayGroupieDiffTask ADXDiffTask;

#endif


#if __has_feature(nullability)
#pragma clang diagnostic pop
#endif
#pragma pop_macro("INCLUDE_ALL_DiffTask")

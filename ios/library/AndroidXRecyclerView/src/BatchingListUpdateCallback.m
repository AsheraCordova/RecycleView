//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//  source: D:\Java\git\core-javafx-widget\SWTAndroidXRecyclerView\src\main\java\androidx\recyclerview\widget\BatchingListUpdateCallback.java
//

#include "BatchingListUpdateCallback.h"
#include "J2ObjC_source.h"
#include "ListUpdateCallback.h"
#include "java/lang/Math.h"


inline jint ADXBatchingListUpdateCallback_get_TYPE_NONE(void);
#define ADXBatchingListUpdateCallback_TYPE_NONE 0
J2OBJC_STATIC_FIELD_CONSTANT(ADXBatchingListUpdateCallback, TYPE_NONE, jint)

inline jint ADXBatchingListUpdateCallback_get_TYPE_ADD(void);
#define ADXBatchingListUpdateCallback_TYPE_ADD 1
J2OBJC_STATIC_FIELD_CONSTANT(ADXBatchingListUpdateCallback, TYPE_ADD, jint)

inline jint ADXBatchingListUpdateCallback_get_TYPE_REMOVE(void);
#define ADXBatchingListUpdateCallback_TYPE_REMOVE 2
J2OBJC_STATIC_FIELD_CONSTANT(ADXBatchingListUpdateCallback, TYPE_REMOVE, jint)

inline jint ADXBatchingListUpdateCallback_get_TYPE_CHANGE(void);
#define ADXBatchingListUpdateCallback_TYPE_CHANGE 3
J2OBJC_STATIC_FIELD_CONSTANT(ADXBatchingListUpdateCallback, TYPE_CHANGE, jint)

@implementation ADXBatchingListUpdateCallback

- (instancetype)initWithADXListUpdateCallback:(id<ADXListUpdateCallback>)callback {
  ADXBatchingListUpdateCallback_initWithADXListUpdateCallback_(self, callback);
  return self;
}

- (void)dispatchLastEvent {
  if (mLastEventType_ == ADXBatchingListUpdateCallback_TYPE_NONE) {
    return;
  }
  switch (mLastEventType_) {
    case ADXBatchingListUpdateCallback_TYPE_ADD:
    [((id<ADXListUpdateCallback>) nil_chk(mWrapped_)) onInsertedWithInt:mLastEventPosition_ withInt:mLastEventCount_];
    break;
    case ADXBatchingListUpdateCallback_TYPE_REMOVE:
    [((id<ADXListUpdateCallback>) nil_chk(mWrapped_)) onRemovedWithInt:mLastEventPosition_ withInt:mLastEventCount_];
    break;
    case ADXBatchingListUpdateCallback_TYPE_CHANGE:
    [((id<ADXListUpdateCallback>) nil_chk(mWrapped_)) onChangedWithInt:mLastEventPosition_ withInt:mLastEventCount_ withId:mLastEventPayload_];
    break;
  }
  JreStrongAssign(&mLastEventPayload_, nil);
  mLastEventType_ = ADXBatchingListUpdateCallback_TYPE_NONE;
}

- (void)onInsertedWithInt:(jint)position
                  withInt:(jint)count {
  if (mLastEventType_ == ADXBatchingListUpdateCallback_TYPE_ADD && position >= mLastEventPosition_ && position <= mLastEventPosition_ + mLastEventCount_) {
    mLastEventCount_ += count;
    mLastEventPosition_ = JavaLangMath_minWithInt_withInt_(position, mLastEventPosition_);
    return;
  }
  [self dispatchLastEvent];
  mLastEventPosition_ = position;
  mLastEventCount_ = count;
  mLastEventType_ = ADXBatchingListUpdateCallback_TYPE_ADD;
}

- (void)onRemovedWithInt:(jint)position
                 withInt:(jint)count {
  if (mLastEventType_ == ADXBatchingListUpdateCallback_TYPE_REMOVE && mLastEventPosition_ >= position && mLastEventPosition_ <= position + count) {
    mLastEventCount_ += count;
    mLastEventPosition_ = position;
    return;
  }
  [self dispatchLastEvent];
  mLastEventPosition_ = position;
  mLastEventCount_ = count;
  mLastEventType_ = ADXBatchingListUpdateCallback_TYPE_REMOVE;
}

- (void)onMovedWithInt:(jint)fromPosition
               withInt:(jint)toPosition {
  [self dispatchLastEvent];
  [((id<ADXListUpdateCallback>) nil_chk(mWrapped_)) onMovedWithInt:fromPosition withInt:toPosition];
}

- (void)onChangedWithInt:(jint)position
                 withInt:(jint)count
                  withId:(id)payload {
  if (mLastEventType_ == ADXBatchingListUpdateCallback_TYPE_CHANGE && !(position > mLastEventPosition_ + mLastEventCount_ || position + count < mLastEventPosition_ || mLastEventPayload_ != payload)) {
    jint previousEnd = mLastEventPosition_ + mLastEventCount_;
    mLastEventPosition_ = JavaLangMath_minWithInt_withInt_(position, mLastEventPosition_);
    mLastEventCount_ = JavaLangMath_maxWithInt_withInt_(previousEnd, position + count) - mLastEventPosition_;
    return;
  }
  [self dispatchLastEvent];
  mLastEventPosition_ = position;
  mLastEventCount_ = count;
  JreStrongAssign(&mLastEventPayload_, payload);
  mLastEventType_ = ADXBatchingListUpdateCallback_TYPE_CHANGE;
}

- (void)dealloc {
  RELEASE_(mWrapped_);
  RELEASE_(mLastEventPayload_);
  [super dealloc];
}

+ (const J2ObjcClassInfo *)__metadata {
  static J2ObjcMethodInfo methods[] = {
    { NULL, NULL, 0x1, -1, 0, -1, -1, -1, -1 },
    { NULL, "V", 0x1, -1, -1, -1, -1, -1, -1 },
    { NULL, "V", 0x1, 1, 2, -1, -1, -1, -1 },
    { NULL, "V", 0x1, 3, 2, -1, -1, -1, -1 },
    { NULL, "V", 0x1, 4, 2, -1, -1, -1, -1 },
    { NULL, "V", 0x1, 5, 6, -1, -1, -1, -1 },
  };
  #pragma clang diagnostic push
  #pragma clang diagnostic ignored "-Wobjc-multiple-method-names"
  #pragma clang diagnostic ignored "-Wundeclared-selector"
  methods[0].selector = @selector(initWithADXListUpdateCallback:);
  methods[1].selector = @selector(dispatchLastEvent);
  methods[2].selector = @selector(onInsertedWithInt:withInt:);
  methods[3].selector = @selector(onRemovedWithInt:withInt:);
  methods[4].selector = @selector(onMovedWithInt:withInt:);
  methods[5].selector = @selector(onChangedWithInt:withInt:withId:);
  #pragma clang diagnostic pop
  static const J2ObjcFieldInfo fields[] = {
    { "TYPE_NONE", "I", .constantValue.asInt = ADXBatchingListUpdateCallback_TYPE_NONE, 0x1a, -1, -1, -1, -1 },
    { "TYPE_ADD", "I", .constantValue.asInt = ADXBatchingListUpdateCallback_TYPE_ADD, 0x1a, -1, -1, -1, -1 },
    { "TYPE_REMOVE", "I", .constantValue.asInt = ADXBatchingListUpdateCallback_TYPE_REMOVE, 0x1a, -1, -1, -1, -1 },
    { "TYPE_CHANGE", "I", .constantValue.asInt = ADXBatchingListUpdateCallback_TYPE_CHANGE, 0x1a, -1, -1, -1, -1 },
    { "mWrapped_", "LADXListUpdateCallback;", .constantValue.asLong = 0, 0x10, -1, -1, -1, -1 },
    { "mLastEventType_", "I", .constantValue.asLong = 0, 0x0, -1, -1, -1, -1 },
    { "mLastEventPosition_", "I", .constantValue.asLong = 0, 0x0, -1, -1, -1, -1 },
    { "mLastEventCount_", "I", .constantValue.asLong = 0, 0x0, -1, -1, -1, -1 },
    { "mLastEventPayload_", "LNSObject;", .constantValue.asLong = 0, 0x0, -1, -1, -1, -1 },
  };
  static const void *ptrTable[] = { "LADXListUpdateCallback;", "onInserted", "II", "onRemoved", "onMoved", "onChanged", "IILNSObject;" };
  static const J2ObjcClassInfo _ADXBatchingListUpdateCallback = { "BatchingListUpdateCallback", "androidx.recyclerview.widget", ptrTable, methods, fields, 7, 0x1, 6, 9, -1, -1, -1, -1, -1 };
  return &_ADXBatchingListUpdateCallback;
}

@end

void ADXBatchingListUpdateCallback_initWithADXListUpdateCallback_(ADXBatchingListUpdateCallback *self, id<ADXListUpdateCallback> callback) {
  NSObject_init(self);
  self->mLastEventType_ = ADXBatchingListUpdateCallback_TYPE_NONE;
  self->mLastEventPosition_ = -1;
  self->mLastEventCount_ = -1;
  JreStrongAssign(&self->mLastEventPayload_, nil);
  JreStrongAssign(&self->mWrapped_, callback);
}

ADXBatchingListUpdateCallback *new_ADXBatchingListUpdateCallback_initWithADXListUpdateCallback_(id<ADXListUpdateCallback> callback) {
  J2OBJC_NEW_IMPL(ADXBatchingListUpdateCallback, initWithADXListUpdateCallback_, callback)
}

ADXBatchingListUpdateCallback *create_ADXBatchingListUpdateCallback_initWithADXListUpdateCallback_(id<ADXListUpdateCallback> callback) {
  J2OBJC_CREATE_IMPL(ADXBatchingListUpdateCallback, initWithADXListUpdateCallback_, callback)
}

J2OBJC_CLASS_TYPE_LITERAL_SOURCE(ADXBatchingListUpdateCallback)

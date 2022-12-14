//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//  source: D:\Java\git\core-javafx-widget\SWTAndroidXRecyclerView\src\main\java\com\xwray\groupie\GroupUtils.java
//

#include "GroupUtils.h"
#include "Item.h"
#include "J2ObjC_source.h"
#include "RVGroup.h"
#include "java/lang/IndexOutOfBoundsException.h"
#include "java/util/Collection.h"


@implementation ADXGroupUtils

- (instancetype)initPackagePrivate {
  ADXGroupUtils_initPackagePrivate(self);
  return self;
}

+ (ADXItem *)getItemWithJavaUtilCollection:(id<JavaUtilCollection>)groups
                                   withInt:(jint)position {
  return ADXGroupUtils_getItemWithJavaUtilCollection_withInt_(groups, position);
}

+ (jint)getItemCountWithJavaUtilCollection:(id<JavaUtilCollection>)groups {
  return ADXGroupUtils_getItemCountWithJavaUtilCollection_(groups);
}

+ (const J2ObjcClassInfo *)__metadata {
  static J2ObjcMethodInfo methods[] = {
    { NULL, NULL, 0x0, -1, -1, -1, -1, -1, -1 },
    { NULL, "LADXItem;", 0x8, 0, 1, -1, 2, -1, -1 },
    { NULL, "I", 0x8, 3, 4, -1, 5, -1, -1 },
  };
  #pragma clang diagnostic push
  #pragma clang diagnostic ignored "-Wobjc-multiple-method-names"
  #pragma clang diagnostic ignored "-Wundeclared-selector"
  methods[0].selector = @selector(initPackagePrivate);
  methods[1].selector = @selector(getItemWithJavaUtilCollection:withInt:);
  methods[2].selector = @selector(getItemCountWithJavaUtilCollection:);
  #pragma clang diagnostic pop
  static const void *ptrTable[] = { "getItem", "LJavaUtilCollection;I", "(Ljava/util/Collection<+Lcom/xwray/groupie/RVGroup;>;I)Lcom/xwray/groupie/Item;", "getItemCount", "LJavaUtilCollection;", "(Ljava/util/Collection<+Lcom/xwray/groupie/RVGroup;>;)I" };
  static const J2ObjcClassInfo _ADXGroupUtils = { "GroupUtils", "com.xwray.groupie", ptrTable, methods, NULL, 7, 0x0, 3, 0, -1, -1, -1, -1, -1 };
  return &_ADXGroupUtils;
}

@end

void ADXGroupUtils_initPackagePrivate(ADXGroupUtils *self) {
  NSObject_init(self);
}

ADXGroupUtils *new_ADXGroupUtils_initPackagePrivate() {
  J2OBJC_NEW_IMPL(ADXGroupUtils, initPackagePrivate)
}

ADXGroupUtils *create_ADXGroupUtils_initPackagePrivate() {
  J2OBJC_CREATE_IMPL(ADXGroupUtils, initPackagePrivate)
}

ADXItem *ADXGroupUtils_getItemWithJavaUtilCollection_withInt_(id<JavaUtilCollection> groups, jint position) {
  ADXGroupUtils_initialize();
  jint previousPosition = 0;
  for (id<ADXRVGroup> __strong group in nil_chk(groups)) {
    jint size = [((id<ADXRVGroup>) nil_chk(group)) getItemCount];
    if (size + previousPosition > position) {
      return [group getItemWithInt:position - previousPosition];
    }
    previousPosition += size;
  }
  @throw create_JavaLangIndexOutOfBoundsException_initWithNSString_(JreStrcat("$I$I$", @"Wanted item at ", position, @" but there are only ", previousPosition, @" items"));
}

jint ADXGroupUtils_getItemCountWithJavaUtilCollection_(id<JavaUtilCollection> groups) {
  ADXGroupUtils_initialize();
  jint size = 0;
  for (id<ADXRVGroup> __strong group in nil_chk(groups)) {
    size += [((id<ADXRVGroup>) nil_chk(group)) getItemCount];
  }
  return size;
}

J2OBJC_CLASS_TYPE_LITERAL_SOURCE(ADXGroupUtils)

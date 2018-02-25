[![Build Status](https://travis-ci.org/amardeshbd/android-recycler-view-wrap-content.svg)](https://travis-ci.org/amardeshbd/android-recycler-view-wrap-content)  [![AOSP issue link](https://img.shields.io/badge/AOSP%20issue-%23220204-orange.svg)](https://code.google.com/p/android/issues/detail?id=220204)  [![Percentage of issues still open](http://isitmaintained.com/badge/open/amardeshbd/android-recycler-view-wrap-content.svg)](http://isitmaintained.com/project/amardeshbd/android-recycler-view-wrap-content "Percentage of issues still open")  [![Average time to resolve an issue](http://isitmaintained.com/badge/resolution/amardeshbd/android-recycler-view-wrap-content.svg)](http://isitmaintained.com/project/amardeshbd/android-recycler-view-wrap-content "Average time to resolve an issue")  [![Build Status](https://www.bitrise.io/app/905812b34b6fe291/status.svg?token=BRK-fzCxj5GwTLb9MQa_7w&branch=master)](https://www.bitrise.io/app/905812b34b6fe291) _(Download APK)_

# android-recycler-view-wrap-content
This is a sample android app which demonstrates `RecyclerView` with **layout_height=wrap_content** not taking height of all the items issue inside `ScrollView` that happens on Marshmallow, Nougat (+MR1), Orio (API 23, 24, 25, 26 &amp; 27) and how to work around it.

 * UPDATE # 1: On Marshmallow (API 23) devices, the issue seems to happen **only on** `PORTRAIT` orientation, `LANDSCAPE` works fine. On Nougat _(Build # `NPD90G`)_ the issue still exist on both orientation.
 * UPDATE # 2: Based on solution found on [stackoverflow](http://stackoverflow.com/questions/27083091/recyclerview-inside-scrollview-is-not-working), replacing root `ScrollView` with `android.support.v4.widget.NestedScrollView` also avoids this issue on Marshmallow+ devices. A new demo section has been added to showcase this.
 * UPDATE # 3: Updated **Support Library** version from `24.1.1` to `24.2.0`, but the issue still exists.
 * UPDATE # 4: Updated **Support Library** version from `24.2.0` to `24.2.1`, but the issue still exists.
 * UPDATE # 5: Updated **Support Library** version from `24.2.0` to `25.0.0`, but the issue still exists.
 * UPDATE # 6: Updated **Support Library** version from `25.0.0` to `25.1.0`, but the issue still exists.
 * UPDATE # 7: Updated **Support Library** version from `25.1.0` to `25.2.0`, but the issue still exists.
 * UPDATE # 8: Updated **Support Library** version from `25.2.0` to `25.3.1`, but the issue still exists.
 * UPDATE # 9: Updated **Support Library** version from `25.3.1` to `25.4.0`, but the issue still exists.
 * UPDATE # 10: Updated **Support Library** version from `25.4.0` to `26.1.0`, but the issue still exists.
 * UPDATE # 11: Updated **Support Library** version from `26.1.0` to `27.0.2`, but the issue still exists.

> `android.support.v7.widget.RecyclerView` version used **[27.0.2](https://github.com/amardeshbd/android-recycler-view-wrap-content/blob/master/app/build.gradle#L4)** _(November 2017)_  - [Release Notes](https://developer.android.com/topic/libraries/support-library/revisions.html)

# Devices Tested On

| Device        | OS Version    | Works? | Notes|
| ------------- | ------------- |--------| -----|
| Moto G (3rd Gen) | 5.1.1  | ✔ | |
| Nexus 5  | 6.0.1 | ✘ | Works on `LANDSCAPE` orientation. |
| Galaxy S4 (SGH-i337M) | 5.0.1 | ✔ | |
| Galaxy S6 (SM-G920F) | 6.0.1 | ✘ | Works on `LANDSCAPE` orientation.  |
| Nexus 6P | 7.0 (NPD90G), 7.1.1 (NPF10C) | ✘ | |
| OnePlus 5 | 7.1.1 | ✘ | |
| Galaxy Note 3 | 4.2.2 | ✔ | |
| Emulator | 4.3.1 | ✔ | |
| Emulator | 8.0.0 | ✘ | |
| LG G4  | 6.0 | ✘ | Works on `LANDSCAPE` orientation. |


> DISCLAIMER: Most recent updates did not execute test on all devices mentioned above.

## Why use `wrap_content`?
There may be different use case where may need to use `wrap_content`, 
one example is there may be fixed number of similar menu items that needs to be rendered.

![Fixed Menu Items](https://github.com/amardeshbd/android-recycler-view-wrap-content/raw/master/web-resources/wrap_content-use-case.jpg)
 
But, it doesnt't make sense to copy & paste code for same view multiple times.
Creating views dynamically is also not that nice. So, using `RecyclerView` and `wrap_content` gives full control of creating this view.

### Stack Overflow References
 * http://stackoverflow.com/questions/27083091/recyclerview-inside-scrollview-is-not-working
 * http://stackoverflow.com/questions/34314719/how-to-use-recyclerview-inside-scrollview

> _DISCLAIMER: This application code has been generated using activity template provided in Android Studio. It is intended to showcase the issue on specified OS versions. No effort has been made to follow industry's best practices for developing android apps. 
If you are interested in learning best practices for developing android apps, please follow Google's official guides found here: [https://github.com/googlesamples/android-architecture](https://github.com/googlesamples/android-architecture)_

# Where is the workaround?

There is nothing to see in the code. Take a look at following layout files for workaround.

 * Layout **without** any workaround - [fragment_recycler_view_without_fix.xml#L33](https://github.com/amardeshbd/android-recycler-view-wrap-content/blob/master/app/src/main/res/layout/fragment_recycler_view_without_fix.xml#L33) loaded in [RecyclerViewWrapContentIssueDemoFragment.java](https://github.com/amardeshbd/android-recycler-view-wrap-content/blob/master/app/src/main/java/info/hossainkhan/recyclerviewdemo/RecyclerViewWrapContentIssueDemoFragment.java#L23)
 * Layout **with** `RelativeLayout` wrapper workaround applied - [fragment_recycler_view_with_fix.xml#L34](https://github.com/amardeshbd/android-recycler-view-wrap-content/blob/master/app/src/main/res/layout/fragment_recycler_view_with_fix.xml#L34) loaded in [RecyclerViewWrapContentFixDemoFragment.java](https://github.com/amardeshbd/android-recycler-view-wrap-content/blob/master/app/src/main/java/info/hossainkhan/recyclerviewdemo/RecyclerViewWrapContentFixDemoFragment.java#L23)
 * Layout **using** `NestedScrollView` as root view - [fragment_recycler_view_with_nested_scrollview_fix.xml#L4](https://github.com/amardeshbd/android-recycler-view-wrap-content/blob/master/app/src/main/res/layout/fragment_recycler_view_with_nested_scrollview_fix.xml#L4) loaded in [RecyclerViewNestedScrollviewFixDemoFragment.java](https://github.com/amardeshbd/android-recycler-view-wrap-content/blob/master/app/src/main/java/info/hossainkhan/recyclerviewdemo/RecyclerViewNestedScrollviewFixDemoFragment.java#L23)

Here is basic skeleton of layout I have used
```
<ScrollView>
  <LinearLayout> (vertical - this is the only child of scrollview)
     <SomeViews>
     <RecyclerView> (layout_height=wrap_content)
     <SomeOtherViews>
```


# Demo

## Screencast
A picture is worth a thousand words, and a video is probably worth even more `^_^`

![Screencast](https://github.com/amardeshbd/android-recycler-view-wrap-content/raw/master/web-resources/RecyclerView-wrap_content-demo-screen-cast-update-small.gif)

## Screenshot

![screenshot](https://cloud.githubusercontent.com/assets/99822/25346354/5f7f6f4c-28e5-11e7-88a7-1034ae2a1e31.png)

# TODO
~~File bug report with android project.~~

_UPDATE: Reported new issue at https://code.google.com/p/android/issues/detail?id=220204_

# Test On Device
You can download latest APK from Bitrise CI server at https://www.bitrise.io/app/905812b34b6fe291 _(use the latest build that is passing)_

# android-recycler-view-wrap-content
This is a sample android app which demonstrates `RecyclerView` with **layout_height=wrap_content** not taking height of all the items issue inside `ScrollView` that happens on Marshmallow and Nougat (API 23 &amp; 24) and how to work around it.

 * UPDATE # 1: The issue seems to happen **only on** `PORTRAIT` orientation. On `LANDSCAPE` orientation the issue is not visible on Marshmallow+ devices.
 * UPDATE # 2: Based on solution found on [stackoverflow](http://stackoverflow.com/questions/27083091/recyclerview-inside-scrollview-is-not-working), replacing root `ScrollView` with `android.support.v4.widget.NestedScrollView` also avoids this issue on Marshmallow+ devices. A new demo section has been added to showcase this.

> `android.support.v7.widget.RecyclerView` version used **[24.1.1](https://github.com/amardeshbd/android-recycler-view-wrap-content/blob/master/app/build.gradle#L27)** _(July 2016)_  - [Release Notes](https://developer.android.com/topic/libraries/support-library/revisions.html)

### Stack Overflow References
 * http://stackoverflow.com/questions/27083091/recyclerview-inside-scrollview-is-not-working
 * http://stackoverflow.com/questions/34314719/how-to-use-recyclerview-inside-scrollview

> _DISCLAIMER: This application code has been generated using activity template provided in Android Studio. It is intended to showcase the issue on specified OS versions. No effort has been made to follow industry's best practices for developing android apps. 
If you are interested in learning best practices for developing android apps, please follow Google's official guides found here: [https://github.com/googlesamples/android-architecture](https://github.com/googlesamples/android-architecture)_

# Where is the workaround?

There is nothing to see in the code. Take a look at following layout files for workaround.

 * Layout **without** any workaround - https://github.com/amardeshbd/android-recycler-view-wrap-content/blob/master/app/src/main/res/layout/fragment_recycler_view_without_fix.xml#L33
 * Layout **with** `RelativeLayout` wrapper workaround applied - https://github.com/amardeshbd/android-recycler-view-wrap-content/blob/master/app/src/main/res/layout/fragment_recycler_view_with_fix.xml#L34
 * Layout **using** `NestedScrollView` as root view - https://github.com/amardeshbd/android-recycler-view-wrap-content/blob/master/app/src/main/res/layout/fragment_recycler_view_with_nested_scrollview_fix.xml#L4

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

![Screencast](https://github.com/amardeshbd/android-recycler-view-wrap-content/raw/master/web-resources/RecyclerView-wrap_content-demo-screen-cash.gif)

## Screenshot

![Screenshot](https://raw.githubusercontent.com/amardeshbd/android-recycler-view-wrap-content/master/web-resources/app-drawer-options-screenshot.png)

# TODO
File bug report with android project.

_UPDATE: Reported new issue at https://code.google.com/p/android/issues/detail?id=220204_

# Test On Device
For convenience, I've uploaded my debug build `apk` to Google Drive. You can try installing the app from https://goo.gl/TDhWtY
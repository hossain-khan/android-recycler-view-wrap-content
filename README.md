# android-recycler-view-wrap-content
This is a sample android app which demonstrates `RecyclerView` with **layout_height=wrap_content** not taking height of all the items issue inside `ScrollView` that happens on Marshmallow and Nougat (API 23 &amp; 24) and how to work around it.


> _DISCLAIMER: This application code has been generated using activity template provided in Android Studio. It is intended to showcase the issue on specified OS versions. No effort has been made to follow industry's best practices for developing android apps. 
If you are interested in learning best practices for developing android apps, please follow Google's official guides found here: [https://github.com/googlesamples/android-architecture](https://github.com/googlesamples/android-architecture)_

# Where is the workaround?

There is nothing to see in the code. Take a look at following layout files for workaround.

 * Layout **without** woraround - https://github.com/amardeshbd/android-recycler-view-wrap-content/blob/master/app/src/main/res/layout/fragment_recycler_view_without_fix.xml#L33
 * Layout **with** workaround applied - https://github.com/amardeshbd/android-recycler-view-wrap-content/blob/master/app/src/main/res/layout/fragment_recycler_view_with_fix.xml#L34


# Demo

## Screencast
A picture is worth a thousand words, and a video is probably worth even more `^_^`

![Screencast](https://github.com/amardeshbd/android-recycler-view-wrap-content/raw/master/web-resources/RecyclerView-wrap_content-demo-screen-cash.gif)

## Screenshot

![Screenshot](https://raw.githubusercontent.com/amardeshbd/android-recycler-view-wrap-content/master/web-resources/app-drawer-options-screenshot.png)

# TODO
File bug report with android project.

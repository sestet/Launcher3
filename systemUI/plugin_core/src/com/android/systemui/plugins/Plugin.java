package com.android.systemui.plugins;

public interface Plugin {
    default void onCreate() { }
    default void onDestroy() { }
}

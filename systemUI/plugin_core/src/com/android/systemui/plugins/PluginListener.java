package com.android.systemui.plugins;

import android.content.Context;

public interface PluginListener<T extends Plugin> {
    void onPluginConnected(T plugin, Context context);
    void onPluginDisconnected(T plugin);
}

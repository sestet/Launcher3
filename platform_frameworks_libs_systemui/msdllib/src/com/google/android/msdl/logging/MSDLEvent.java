package com.google.android.msdl.logging;

public class MSDLEvent {
    private final String mName;

    public MSDLEvent(String name) {
        mName = name;
    }

    @Override
    public String toString() {
        return mName;
    }
}

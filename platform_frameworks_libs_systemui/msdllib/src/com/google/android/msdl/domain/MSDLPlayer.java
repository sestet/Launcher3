package com.google.android.msdl.domain;

import android.os.Vibrator;

import com.google.android.msdl.data.model.MSDLToken;
import com.google.android.msdl.logging.MSDLEvent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;

public class MSDLPlayer {
    public static final Companion Companion = new Companion();

    private final List<MSDLEvent> mHistory = new ArrayList<>();

    public void playToken(MSDLToken token, InteractionProperties properties) {
        mHistory.add(new MSDLEvent(token.name()));
    }

    public List<MSDLEvent> getHistory() {
        return Collections.unmodifiableList(mHistory);
    }

    public static class Companion {
        public MSDLPlayer createPlayer(Vibrator vibrator, Executor executor,
                Object useHapticFeedbackForToken) {
            return new MSDLPlayer();
        }
    }
}

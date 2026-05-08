package com.android.app.animation;

import android.animation.TimeInterpolator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;

public final class Interpolators {
    public static final Interpolator LINEAR = new LinearInterpolator();
    public static final Interpolator ACCELERATE = new AccelerateInterpolator();
    public static final Interpolator ACCELERATE_2 = new AccelerateInterpolator(2f);
    public static final Interpolator ACCELERATE_DECELERATE = new AccelerateDecelerateInterpolator();
    public static final Interpolator DECELERATE = new DecelerateInterpolator();
    public static final Interpolator DECELERATE_1_5 = new DecelerateInterpolator(1.5f);
    public static final Interpolator DECELERATE_1_7 = new DecelerateInterpolator(1.7f);
    public static final Interpolator DECELERATE_2 = new DecelerateInterpolator(2f);
    public static final Interpolator DECELERATE_3 = new DecelerateInterpolator(3f);
    public static final Interpolator DECELERATE_QUINT =
            input -> 1f - (float) Math.pow(1f - input, 5);
    public static final Interpolator DECELERATED_EASE = new DecelerateInterpolator(1.7f);
    public static final Interpolator FAST_OUT_SLOW_IN =
            new PathInterpolator(0.4f, 0f, 0.2f, 1f);
    public static final Interpolator EMPHASIZED =
            new PathInterpolator(0.2f, 0f, 0f, 1f);
    public static final Interpolator EMPHASIZED_ACCELERATE =
            new PathInterpolator(0.3f, 0f, 0.8f, 0.15f);
    public static final Interpolator EMPHASIZED_DECELERATE =
            new PathInterpolator(0.05f, 0.7f, 0.1f, 1f);
    public static final Interpolator STANDARD = new PathInterpolator(0.2f, 0f, 0f, 1f);
    public static final Interpolator SCROLL = new DecelerateInterpolator(1.5f);
    public static final Interpolator SCROLL_CUBIC =
            input -> 1f - (float) Math.pow(1f - input, 3);
    public static final Interpolator ZOOM_OUT = new DecelerateInterpolator(0.75f);
    public static final Interpolator INSTANT = input -> input <= 0f ? 0f : 1f;
    public static final Interpolator FINAL_FRAME = input -> input < 1f ? 0f : 1f;

    private Interpolators() { }

    public static Interpolator clampToProgress(TimeInterpolator interpolator, float lowerBound,
            float upperBound) {
        return input -> {
            if (upperBound <= lowerBound) {
                return input >= upperBound ? 1f : 0f;
            }
            float progress = (input - lowerBound) / (upperBound - lowerBound);
            progress = Math.max(0f, Math.min(1f, progress));
            return interpolator.getInterpolation(progress);
        };
    }

    public static float clampToProgress(float progress, float lowerBound, float upperBound) {
        if (upperBound <= lowerBound) {
            return progress >= upperBound ? 1f : 0f;
        }
        return Math.max(0f, Math.min(1f, (progress - lowerBound) / (upperBound - lowerBound)));
    }

    public static Interpolator mapToProgress(TimeInterpolator interpolator, float lowerBound,
            float upperBound) {
        return input -> lowerBound + (upperBound - lowerBound) * interpolator.getInterpolation(input);
    }

    public static Interpolator reverse(TimeInterpolator interpolator) {
        return input -> 1f - interpolator.getInterpolation(1f - input);
    }

    public static Interpolator scrollInterpolatorForVelocity(float velocity) {
        return SCROLL;
    }
}

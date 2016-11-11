package com.stzemo.customgridview.helper;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class ScreenParametrs {
    private static int width;
    private static int height;
    private static Context context;

    public static int getWidth() {
        return width;
    }

    public static int getHeight() {
        return height;
    }

    public static int convertDpToPixel(int dp) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        int px = (int) (dp * ((float) metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT));
        return px;
    }

    public static int convertPixelsToDp(int px) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        int dp = (int) (px / ((float) metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT));
        return dp;
    }

    public static void initialize(Context c) {
        context = c;
        Display display = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        width = display.getWidth();
        height = display.getHeight();
    }
}

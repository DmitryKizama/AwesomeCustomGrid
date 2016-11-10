package com.stzemo.customgridview.helper;

import android.content.Context;
import android.view.Display;
import android.view.WindowManager;

public class ScreenParametrs {
    private static int width;
    private static int height;

    public static int getWidth() {
        return width;
    }

    public static int getHeight() {
        return height;
    }

    public static void initialize(Context context) {
        Display display = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        width = display.getWidth();
        height = display.getHeight();
    }
}

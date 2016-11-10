package com.stzemo.customgridview.bottom.controller;

import android.view.View;

public abstract class BaseBottomController {
    protected View parent;

    public BaseBottomController(View parent) {
        this.parent = parent;
    }

    protected abstract void initialise();
}

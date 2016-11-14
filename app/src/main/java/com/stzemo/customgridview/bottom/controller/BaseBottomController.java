package com.stzemo.customgridview.bottom.controller;

import android.view.View;

import com.stzemo.customgridview.models.Person;

public abstract class BaseBottomController implements BottomControllerListener {
    protected View parent;
    protected BottomControllerListener bottomControllerListener;

    public BaseBottomController(View parent, BottomControllerListener gridAdapterListener) {
        this.parent = parent;
        this.bottomControllerListener = gridAdapterListener;
        initialise();
    }

    public abstract void addPerson(Person person);

    @Override
    public void onPhotoRemovedFromBottom(Person person) {
        bottomControllerListener.onPhotoRemovedFromBottom(person);
    }

    protected abstract void initialise();
}

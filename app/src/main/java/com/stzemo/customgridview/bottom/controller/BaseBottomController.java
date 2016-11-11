package com.stzemo.customgridview.bottom.controller;

import android.view.View;

import com.stzemo.customgridview.adapters.GridAdapter;
import com.stzemo.customgridview.models.Person;

public abstract class BaseBottomController implements GridAdapter.GridAdapterListener {
    protected View parent;
    protected GridAdapter.GridAdapterListener gridAdapterListener;

    public BaseBottomController(View parent, GridAdapter.GridAdapterListener gridAdapterListener) {
        this.parent = parent;
        this.gridAdapterListener = gridAdapterListener;
        initialise();
    }

    public abstract void addPerson(Person person);

    @Override
    public void onPhotoClick(Person person) {
        gridAdapterListener.onPhotoClick(person);
    }

    protected abstract void initialise();
}

package com.stzemo.customgridview.top.controller;

import android.widget.LinearLayout;

import com.stzemo.customgridview.models.Person;

public class PhotoTopController {

    interface OnPhotoTopControllerCallback {
        void onPersonClick(Person person);
    }

    private LinearLayout linearLayout;
    private OnPhotoTopControllerCallback listener;

    public PhotoTopController(LinearLayout parent) {
        linearLayout = parent;
    }

    public void addPerson(Person person) {

    }

    private void removePerson(Person person){
        
    }

    public void setListener(OnPhotoTopControllerCallback listener) {
        this.listener = listener;
    }
}

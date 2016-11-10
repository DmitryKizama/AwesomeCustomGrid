package com.stzemo.customgridview.top.controller;

import android.view.View;
import android.widget.LinearLayout;

import com.stzemo.customgridview.R;
import com.stzemo.customgridview.models.Person;

public class TopController {


    public interface OnTopControllerCallback {
        void onPersonClick(Person person);
    }

    private View parent;
    private OnTopControllerCallback listener;
    private LinearLayout topPhotos;
    private PhotoTopController photoTopController;

    public TopController(View parent) {
        this.parent = parent;
        topPhotos = (LinearLayout) parent.findViewById(R.id.circle_person_photos);
        photoTopController = new PhotoTopController(topPhotos);
    }

    public void addPerson(Person person) {

    }

    public void setListener(final OnTopControllerCallback listener) {
        this.listener = listener;
        photoTopController.setListener(new PhotoTopController.OnPhotoTopControllerCallback() {
            @Override
            public void onPersonClick(Person person) {
                listener.onPersonClick(person);
            }
        });
    }


}

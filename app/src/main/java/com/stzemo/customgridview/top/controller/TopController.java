package com.stzemo.customgridview.top.controller;

import android.view.View;
import android.widget.FrameLayout;

import com.stzemo.customgridview.R;
import com.stzemo.customgridview.models.Person;

public class TopController {


    public interface OnTopControllerCallback {
        void onPersonRemovedFromTop(Person person);
    }

    private View parent;
    private OnTopControllerCallback listener;
    private FrameLayout topPhotos;
    private PhotoTopController photoTopController;

    public TopController(View parent) {
        this.parent = parent;
        topPhotos = (FrameLayout) parent.findViewById(R.id.circle_person_photos);
        photoTopController = new PhotoTopController(topPhotos);
    }

    public void addPerson(Person person) {
        photoTopController.addPerson(person);
    }

    public void setListener(final OnTopControllerCallback listener) {
        this.listener = listener;
        photoTopController.setListener(new PhotoTopController.OnPhotoTopControllerCallback() {
            @Override
            public void onPersonClick(Person person) {
                listener.onPersonRemovedFromTop(person);
            }
        });
    }


}

package com.stzemo.customgridview.top.controller;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;

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
    private ImageView btnNext;
    private HorizontalScrollView hScrollView;

    public TopController(View parent) {
        this.parent = parent;
        topPhotos = (FrameLayout) parent.findViewById(R.id.circle_person_photos);
        btnNext = (ImageView) parent.findViewById(R.id.btn_im_next);
        hScrollView = (HorizontalScrollView) parent.findViewById(R.id.horizontal_scroll_bar);
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
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hScrollView.arrowScroll(View.FOCUS_RIGHT);
            }
        });
    }


}

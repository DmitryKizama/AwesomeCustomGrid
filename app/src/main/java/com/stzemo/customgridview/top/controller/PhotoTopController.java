package com.stzemo.customgridview.top.controller;

import android.view.View;
import android.widget.FrameLayout;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.stzemo.customgridview.helper.ScreenParametrs;
import com.stzemo.customgridview.models.Person;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class PhotoTopController {
    private static final int CIRCLE_SIZE = ScreenParametrs.convertDpToPixel(35);
    private static final int MARGIN_LEFT = ScreenParametrs.convertDpToPixel(25);
    private FrameLayout frameLayout;
    private OnPhotoTopControllerCallback listener;
    private List<Person> list;


    interface OnPhotoTopControllerCallback {
        void onPersonClick(Person person);
    }


    public PhotoTopController(FrameLayout parent) {
        frameLayout = parent;
        list = new ArrayList<>();
    }

    public void addPerson(Person person) {
        addPerson(person, true, list.size());
    }

    private void addPerson(final Person person, boolean addToList, int currentListSize) {
        CircleImageView circleImageView = new CircleImageView(frameLayout.getContext());
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(CIRCLE_SIZE, CIRCLE_SIZE);

        params.setMargins(MARGIN_LEFT * currentListSize, 0, 0, 0);
        circleImageView.setLayoutParams(params);
        frameLayout.addView(circleImageView);
        ImageLoader.getInstance().displayImage(person.urlPhoto, circleImageView);
        if (addToList) {
            list.add(person);
        }
        circleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removePerson(person);
            }
        });
    }

    private void removePerson(Person person) {
        list.remove(person);
        frameLayout.removeAllViews();
        int i = 0;
        for (Person p : list) {
            addPerson(p, false, i);
            ++i;
        }
        listener.onPersonClick(person);
    }

    public void setListener(OnPhotoTopControllerCallback listener) {
        this.listener = listener;
    }
}

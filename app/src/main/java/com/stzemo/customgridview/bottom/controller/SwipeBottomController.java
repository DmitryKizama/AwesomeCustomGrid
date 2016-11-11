package com.stzemo.customgridview.bottom.controller;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.stzemo.customgridview.R;
import com.stzemo.customgridview.adapters.GridAdapter;
import com.stzemo.customgridview.helper.EmulateUrlDownload;
import com.stzemo.customgridview.listeners.OnSwipeTouchListener;
import com.stzemo.customgridview.models.Person;

import java.util.ArrayList;
import java.util.List;

public class SwipeBottomController extends BaseBottomController {

    private ImageView imageView;
    private List<Person> list;
    private int position = 0;
    private static final String LOGTAG = "SwipeBottomController";

    public SwipeBottomController(View parent, GridAdapter.GridAdapterListener gridAdapterListener) {
        super(parent, gridAdapterListener);
    }

    @Override
    public void addPerson(Person person) {
        if (position == -1) {
            position = 0;
        }
        list.add(position, person);
        showNext();
    }

    @Override
    protected void initialise() {
        imageView = (ImageView) parent.findViewById(R.id.img_swipe);
        init();
    }

    private void init() {
        list = new ArrayList<>();
        list = EmulateUrlDownload.getList();
        showNext();
        imageView.setOnTouchListener(new OnSwipeTouchListener(parent.getContext()) {
            @Override
            public void onSwipeLeft() {
                super.onSwipeLeft();
                if (position >= list.size() - 1) {
                    position = 0;
                } else {
                    ++position;
                }
                showNext();
            }

            @Override
            public void onSwipeRight() {
                super.onSwipeRight();
                if (position == 0) {
                    position = list.size() - 1;
                } else {
                    --position;
                }
                showNext();
            }

            @Override
            public void onSwipeTop() {
                super.onSwipeTop();
                Log.d(LOGTAG, "onSwipeTop");
                onPhotoClick(list.get(position));
                if (list.size() == 0) {
                    ImageLoader.getInstance().displayImage(EmulateUrlDownload.getNoHoney(), imageView);
                }
                Log.d(LOGTAG, "position = " + position);
                list.remove(position);
                nextPos();
                Log.d(LOGTAG, "position = " + position);
                showNext();
            }
        });
    }

    private void nextPos() {
        if (list.size() <= position) {
            position = list.size() - 1;
        }
    }

    private void showNext() {
        if (list.size() == 0) {
            ImageLoader.getInstance().displayImage(EmulateUrlDownload.getNoHoney(), imageView);
            return;
        }
        ImageLoader.getInstance().displayImage(list.get(position).urlPhoto, imageView);
    }
}

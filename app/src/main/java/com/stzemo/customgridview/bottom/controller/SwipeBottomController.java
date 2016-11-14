package com.stzemo.customgridview.bottom.controller;

import android.view.View;

import com.lorentzos.flingswipe.SwipeFlingAdapterView;
import com.stzemo.customgridview.R;
import com.stzemo.customgridview.adapters.SwipeAdapter;
import com.stzemo.customgridview.helper.EmulateUrlDownload;
import com.stzemo.customgridview.models.Person;

public class SwipeBottomController extends BaseBottomController {

    private SwipeFlingAdapterView swipeFlingAdapterView;
    private SwipeAdapter swipeAdapter;

    public SwipeBottomController(View parent, BottomControllerListener bottomControllerListener) {
        super(parent, bottomControllerListener);
    }

    @Override
    public void addPerson(Person person) {
        swipeAdapter.addPerson(person);
    }

    @Override
    protected void initialise() {
        swipeFlingAdapterView = (SwipeFlingAdapterView) parent.findViewById(R.id.swipe_filing);

        swipeAdapter = new SwipeAdapter(parent.getContext(), EmulateUrlDownload.getList(), bottomControllerListener);
        swipeFlingAdapterView.setAdapter(swipeAdapter);
        swipeFlingAdapterView.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {

            }

            @Override
            public void onLeftCardExit(Object o) {
                swipeAdapter.next();
            }

            @Override
            public void onRightCardExit(Object o) {
                swipeAdapter.remove();
            }

            @Override
            public void onAdapterAboutToEmpty(int i) {

            }

            @Override
            public void onScroll(float v) {

            }


        });
    }
}

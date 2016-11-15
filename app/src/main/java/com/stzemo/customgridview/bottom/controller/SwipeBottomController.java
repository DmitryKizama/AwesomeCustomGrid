package com.stzemo.customgridview.bottom.controller;

import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.lorentzos.flingswipe.SwipeFlingAdapterView;
import com.stzemo.customgridview.R;
import com.stzemo.customgridview.adapters.SwipeAdapter;
import com.stzemo.customgridview.helper.EmulateUrlDownload;
import com.stzemo.customgridview.models.Person;

public class SwipeBottomController extends BaseBottomController implements View.OnClickListener {

    private SwipeFlingAdapterView swipeFlingAdapterView;
    private SwipeAdapter swipeAdapter;
    private Button btnLike, btnNext;

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
        btnLike = (Button) parent.findViewById(R.id.btn_like);
        btnNext = (Button) parent.findViewById(R.id.btn_next);
        btnNext.setOnClickListener(this);
        btnLike.setOnClickListener(this);
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
                Log.d("SwipeBottomOnScroll", "v = " + v);
                swipeAdapter.scroll(v);
            }


        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_like:
                swipeFlingAdapterView.getTopCardListener().selectRight();
//                swipeAdapter.remove();
                break;
            case R.id.btn_next:
                swipeFlingAdapterView.getTopCardListener().selectLeft();
//                swipeAdapter.next();
                break;
        }
    }
}

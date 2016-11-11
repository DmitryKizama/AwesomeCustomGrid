package com.stzemo.customgridview.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.stzemo.customgridview.R;
import com.stzemo.customgridview.adapters.GridAdapter;
import com.stzemo.customgridview.bottom.controller.BaseBottomController;
import com.stzemo.customgridview.bottom.controller.GridBottomController;
import com.stzemo.customgridview.bottom.controller.SwipeBottomController;
import com.stzemo.customgridview.models.Person;
import com.stzemo.customgridview.top.controller.TopController;

public class MainActivity extends AppCompatActivity implements GridAdapter.GridAdapterListener, TopController.OnTopControllerCallback {

    private FrameLayout bottomLayout, topLayout;
    private BaseBottomController bottomController;
    private TopController topController;
    private Button btnSwitch;
    private boolean isGridShow = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomLayout = (FrameLayout) findViewById(R.id.frame_main_layout_bottom);
        topLayout = (FrameLayout) findViewById(R.id.frame_main_layout_top);
        btnSwitch = (Button) findViewById(R.id.btnMain);
        btnSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isGridShow = !isGridShow;
                inflateBottomLayout(isGridShow);
            }
        });
        inflateBottomLayout(isGridShow);
        inflateTopLayout();
    }

    private void inflateBottomLayout(boolean isGridLayout) {
        if (isGridLayout) {
            View view = LayoutInflater.from(this).inflate(R.layout.layout_bottom_grid, bottomLayout, false);
            bottomLayout.removeAllViews();
            bottomLayout.addView(view);
            bottomController = new GridBottomController(bottomLayout, this);
        } else {
            View view = LayoutInflater.from(this).inflate(R.layout.layout_bottom_swipe, bottomLayout, false);
            bottomLayout.removeAllViews();
            bottomLayout.addView(view);
            bottomController = new SwipeBottomController(bottomLayout, this);
        }
    }

    private void inflateTopLayout() {
        View view = LayoutInflater.from(this).inflate(R.layout.layout_top, topLayout, false);
        topLayout.addView(view);
        topController = new TopController(topLayout);
        topController.setListener(this);
    }

    @Override
    public void onPhotoClick(Person person) {
        topController.addPerson(person);
    }

    @Override
    public void onPersonClick(Person person) {
        bottomController.addPerson(person);
    }
}

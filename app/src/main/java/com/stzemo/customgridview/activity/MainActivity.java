package com.stzemo.customgridview.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.stzemo.customgridview.R;
import com.stzemo.customgridview.bottom.controller.BaseBottomController;
import com.stzemo.customgridview.bottom.controller.GridBottomController;
import com.stzemo.customgridview.top.controller.TopController;

public class MainActivity extends AppCompatActivity {

    private FrameLayout bottomLayout, topLayout;
    private BaseBottomController bottomController;
    private TopController topController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomLayout = (FrameLayout) findViewById(R.id.frame_main_layout_bottom);
        topLayout = (FrameLayout) findViewById(R.id.frame_main_layout_top);
        inflateBottomLayout(true);
        inflateTopLayout();
    }

    private void inflateBottomLayout(boolean isGridLayout) {
        if (isGridLayout) {
            View view = LayoutInflater.from(this).inflate(R.layout.layout_bottom_grid, bottomLayout, false);
            bottomLayout.removeAllViews();
            bottomLayout.addView(view);
            bottomController = new GridBottomController(bottomLayout);
        } else {
            //TODO: another layout
        }
    }

    private void inflateTopLayout() {
        View view = LayoutInflater.from(this).inflate(R.layout.layout_top, topLayout, false);
        topLayout.addView(view);
        topController = new TopController(topLayout);
    }

}

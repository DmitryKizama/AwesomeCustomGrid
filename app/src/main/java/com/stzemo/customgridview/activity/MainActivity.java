package com.stzemo.customgridview.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.stzemo.customgridview.R;
import com.stzemo.customgridview.bottom.controller.BaseBottomController;
import com.stzemo.customgridview.bottom.controller.GridBottomController;

public class MainActivity extends AppCompatActivity {

    private FrameLayout mainLayout;
    private BaseBottomController bottomController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainLayout = (FrameLayout) findViewById(R.id.frame_main_layout);
        inflateBottomLayout(true);
    }

    private void inflateBottomLayout(boolean isGridLayout) {
        if (isGridLayout) {
            View view = LayoutInflater.from(this).inflate(R.layout.layout_bottom_grid, mainLayout, false);
            mainLayout.removeAllViews();
            mainLayout.addView(view);
            bottomController = new GridBottomController(mainLayout);
        } else {
            //TODO: another layout
        }
    }

}

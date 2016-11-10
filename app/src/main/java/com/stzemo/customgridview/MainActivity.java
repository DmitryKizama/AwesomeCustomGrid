package com.stzemo.customgridview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    private FrameLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainLayout = (FrameLayout) findViewById(R.id.frame_main_layout);
        inflateBottomLayout(true);
    }

    private void inflateBottomLayout(boolean isGridLayout) {
        if (isGridLayout) {
            LayoutInflater.from(this).inflate(R.layout.layout_bottom_grid, mainLayout, true);
        } else {
            //TODO: another layout
        }
    }

}

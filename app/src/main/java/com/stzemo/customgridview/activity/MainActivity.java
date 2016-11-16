package com.stzemo.customgridview.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.stzemo.customgridview.R;
import com.stzemo.customgridview.bottom.controller.BaseBottomController;
import com.stzemo.customgridview.bottom.controller.BottomControllerListener;
import com.stzemo.customgridview.bottom.controller.GridBottomController;
import com.stzemo.customgridview.bottom.controller.SwipeBottomController;
import com.stzemo.customgridview.models.Person;
import com.stzemo.customgridview.top.controller.TopController;

public class MainActivity extends AppCompatActivity implements BottomControllerListener, TopController.OnTopControllerCallback {

    private static final String ISGRIDSHOWN = "isGridShow";
    private FrameLayout bottomLayout, topLayout;
    private BaseBottomController bottomController;
    private TopController topController;
    private ImageView btnSwitch;
    private boolean isGridShow = true;
    private SharedPreferences sPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomLayout = (FrameLayout) findViewById(R.id.frame_main_layout_bottom);
        topLayout = (FrameLayout) findViewById(R.id.frame_main_layout_top);
        btnSwitch = (ImageView) findViewById(R.id.btnMain);
        sPref = getPreferences(MODE_PRIVATE);
        final SharedPreferences.Editor ed = sPref.edit();

        btnSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isGridShow = !isGridShow;
                ed.putBoolean(ISGRIDSHOWN, isGridShow);
                ed.commit();
                inflateBottomLayout(isGridShow);
            }
        });
        inflateBottomLayout(sPref.getBoolean(ISGRIDSHOWN, true));
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
    public void onPhotoRemovedFromBottom(Person person) {
        topController.addPerson(person);
    }

    @Override
    public void onPersonRemovedFromTop(Person person) {
        bottomController.addPerson(person);
    }
}

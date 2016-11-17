package com.stzemo.customgridview.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.stzemo.customgridview.R;
import com.stzemo.customgridview.bottom.controller.BaseBottomController;
import com.stzemo.customgridview.bottom.controller.BottomControllerListener;
import com.stzemo.customgridview.bottom.controller.GridBottomController;
import com.stzemo.customgridview.bottom.controller.SwipeBottomController;
import com.stzemo.customgridview.helper.MainActivityActionBarCntl;
import com.stzemo.customgridview.models.Person;
import com.stzemo.customgridview.top.controller.TopController;

public class MainActivity extends AppCompatActivity implements BottomControllerListener, TopController.OnTopControllerCallback {

    private static final String GITHUB_URL = "https://github.com/DmitryKizama/AwesomeCustomGrid";

    private FrameLayout bottomLayout, topLayout;
    private BaseBottomController bottomController;
    private TopController topController;
    private MainActivityActionBarCntl mainActivityActionBarCntl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomLayout = (FrameLayout) findViewById(R.id.frame_main_layout_bottom);
        topLayout = (FrameLayout) findViewById(R.id.frame_main_layout_top);

        mainActivityActionBarCntl = new MainActivityActionBarCntl(findViewById(R.id.linearLayout), new MainActivityActionBarCntl.OnActionBarClickListener() {
            @Override
            public void onSwitchClicked(boolean isGridShow) {
                inflateBottomLayout(isGridShow);
            }

            @Override
            public void onMenuPressed() {
                showDeveloperInfo();
            }
        });

        inflateBottomLayout(mainActivityActionBarCntl.isGridShown());
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

    private void showDeveloperInfo() {
        new AlertDialog.Builder(this)
                .setIcon(R.drawable.ic_github)
                .setTitle("Go to github!")
                .setMessage("This app was created by Dmitriy Kizema. Look my profile on github, and this project!")
                .setPositiveButton("To Github", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(GITHUB_URL));
                        startActivity(intent);
                    }

                })
                .setNegativeButton("Back", null)
                .show();
    }

    public void onBottomClick(View v){
        Toast.makeText(this, "Not implemented", Toast.LENGTH_SHORT).show();
    }
}

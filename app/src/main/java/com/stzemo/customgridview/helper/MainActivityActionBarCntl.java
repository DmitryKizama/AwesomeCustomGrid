package com.stzemo.customgridview.helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.stzemo.customgridview.R;

import static android.content.Context.MODE_PRIVATE;

public class MainActivityActionBarCntl {

    private static final String ACTION_BAR_SP = "ACTION_BAR_SP";
    private static final String ISGRIDSHOWN = "isGridShow";

    private View btnSwitch;
    private View btnInfo;
    private TextSwitcher tsTitle;

    private Context context;

    private boolean isGridShow = true;

    private OnActionBarClickListener listener;

    public interface OnActionBarClickListener{
        void onSwitchClicked(boolean isGridShow);
        void onMenuPressed();
    }

    public MainActivityActionBarCntl(View parent, OnActionBarClickListener l){
        this.listener = l;
        context = parent.getContext();

        isGridShow = getFlag();

        btnSwitch = parent.findViewById(R.id.btnMain);
        btnInfo = parent.findViewById(R.id.btnDots);

        initTitle(parent);
        setTitleText();

        btnSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isGridShow = !isGridShow;
                listener.onSwitchClicked(isGridShow);

                setTitleText();
                updateFlag();
            }
        });

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onMenuPressed();
            }
        });
    }

    private void initTitle(View parent){
        tsTitle = (TextSwitcher) parent.findViewById(R.id.tvTitle);

        tsTitle.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView () {
                TextView tv = new TextView(context);
                FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);
                params.gravity = Gravity.CENTER;
                tv.setLayoutParams(params);
                tv.setTextSize(17);

                return tv;
            }
        });
        tsTitle.setInAnimation(context, R.anim.in);
        tsTitle.setOutAnimation(context, R.anim.out);
    }

    private void updateFlag(){
        SharedPreferences sPref = context.getSharedPreferences(ACTION_BAR_SP, MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putBoolean(ISGRIDSHOWN, isGridShow);
        ed.apply();
    }

    private boolean getFlag(){
        SharedPreferences sPref = context.getSharedPreferences(ACTION_BAR_SP, MODE_PRIVATE);
        return sPref.getBoolean(ISGRIDSHOWN, true);
    }

    private void setTitleText(){
        if (isGridShow){
            tsTitle.setText("Game : Grid Layout");
        } else {
            tsTitle.setText("Game : Swipe Layout");
        }
    }

    public boolean isGridShown(){
        return isGridShow;
    }
}

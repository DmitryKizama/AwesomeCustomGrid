package com.stzemo.customgridview.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.stzemo.customgridview.R;
import com.stzemo.customgridview.bottom.controller.BottomControllerListener;
import com.stzemo.customgridview.helper.ScreenParametrs;
import com.stzemo.customgridview.models.Person;

import java.util.List;

public class SwipeAdapter extends BaseAdapter {

    private Context context;
    private List<Person> list;
    private BottomControllerListener bListener;

    public SwipeAdapter(Context c, List<Person> list, BottomControllerListener bottomControllerListener) {
        this.list = list;
        context = c;
        bListener = bottomControllerListener;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.swipe_item, viewGroup, false);
        }
        ImageView photo = (ImageView) view.findViewById(R.id.photo_swipe_adapter);
        ImageLoader.getInstance().displayImage(list.get(i).urlPhoto, photo);

        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ScreenParametrs.getWidth(), ScreenParametrs.getWidth());
        photo.setLayoutParams(layoutParams);
        return view;
    }


    public void addPerson(Person person) {
        list.add(person);
        notifyDataSetChanged();
    }

    public void remove() {
        bListener.onPhotoRemovedFromBottom(list.get(0));
        list.remove(0);
        notifyDataSetChanged();
    }

    public void next() {
        Person p = list.get(0);
        list.add(p);
        list.remove(0);
        notifyDataSetChanged();
    }
}

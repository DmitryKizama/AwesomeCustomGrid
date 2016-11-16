package com.stzemo.customgridview.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;

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
    private ViewHolder firstViewHolder;

    public SwipeAdapter(Context c, List<Person> list, BottomControllerListener bottomControllerListener) {
        this.list = list;
        context = c;
        bListener = bottomControllerListener;
    }

    private static class ViewHolder {
        ImageView im;
        View red;
        View blue;
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
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.swipe_item, viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.im = (ImageView) view.findViewById(R.id.photo_swipe_adapter);
            viewHolder.red = view.findViewById(R.id.im_red);
            viewHolder.blue = view.findViewById(R.id.im_blue);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        if (i == 0) {
            firstViewHolder = viewHolder;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ScreenParametrs.getWidth(),
                ScreenParametrs.getHeight() - ScreenParametrs.convertDpToPixel(200));
        view.setLayoutParams(layoutParams);
        ImageLoader.getInstance().displayImage(list.get(i).urlPhoto, viewHolder.im);

        return view;
    }


    public void addPerson(Person person) {
        list.add(person);
        notifyDataSetChanged();
    }

    public void remove() {
        if (list.isEmpty()) {
            return;
        }
        bListener.onPhotoRemovedFromBottom(list.get(0));
        list.remove(0);
        notifyDataSetChanged();
    }

    public void next() {
        if (list.isEmpty()) {
            return;
        }
        Person p = list.get(0);
        list.add(p);
        list.remove(0);
        notifyDataSetChanged();
    }

    public void scroll(float v) {
        if (firstViewHolder == null) {
            return;
        }
        if (v < 0) {
            firstViewHolder.red.setAlpha(-v / 2);
            firstViewHolder.blue.setAlpha(0);
        } else {
            firstViewHolder.blue.setAlpha(v / 2);
            firstViewHolder.red.setAlpha(0);
        }
    }
}

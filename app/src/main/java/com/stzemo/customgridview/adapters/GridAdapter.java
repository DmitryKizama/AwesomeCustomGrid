package com.stzemo.customgridview.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.stzemo.customgridview.R;
import com.stzemo.customgridview.helper.ScreenParametrs;
import com.stzemo.customgridview.models.Person;

import java.util.List;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.ViewHolder> {

    private List<Person> listPersons;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView photo;

        public ViewHolder(View v) {
            super(v);
            photo = (ImageView) v.findViewById(R.id.photo);
        }
    }

    public GridAdapter(List<Person> listPersons) {
        this.listPersons = listPersons;
    }

    @Override
    public GridAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.person_grid, parent, false);
        ViewHolder vh = new ViewHolder(v);


        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ScreenParametrs.getWidth() / 3, ScreenParametrs.getWidth() / 3);
        vh.photo.setLayoutParams(layoutParams);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ImageLoader.getInstance().displayImage(listPersons.get(position).urlPhoto, holder.photo);
    }

    @Override
    public int getItemCount() {
        return listPersons.size();
    }
}

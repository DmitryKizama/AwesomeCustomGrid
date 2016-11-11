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

    public interface GridAdapterListener {
        void onPhotoClick(Person person);
    }

    private List<Person> listPersons;
    private GridAdapterListener listener;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView photo;

        public ViewHolder(View v) {
            super(v);
            photo = (ImageView) v.findViewById(R.id.photo);
        }
    }

    public GridAdapter(List<Person> listPersons, GridAdapterListener listener) {
        this.listPersons = listPersons;
        this.listener = listener;
    }

    public void addPerson(Person person) {
        listPersons.add(0, person);
        notifyItemInserted(0);
    }

    @Override
    public GridAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.person_grid, parent, false);
        ViewHolder vh = new ViewHolder(v);


        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ScreenParametrs.getWidth() / 3, ScreenParametrs.getWidth() / 3);
        vh.photo.setLayoutParams(layoutParams);
        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        ImageLoader.getInstance().displayImage(listPersons.get(position).urlPhoto, holder.photo);
        holder.photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onPhotoClick(listPersons.get(holder.getAdapterPosition()));
                listPersons.remove(holder.getAdapterPosition());
                notifyItemRemoved(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return listPersons.size();
    }
}

package com.stzemo.customgridview.bottom.controller;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.stzemo.customgridview.R;
import com.stzemo.customgridview.adapters.GridAdapter;
import com.stzemo.customgridview.helper.EmulateUrlDownload;
import com.stzemo.customgridview.models.Person;

public class GridBottomController extends BaseBottomController {

    private RecyclerView recyclerView;
    private GridAdapter gAdapter;


    public GridBottomController(View parent, BottomControllerListener gridAdapterListener) {
        super(parent, gridAdapterListener);
    }

    @Override
    public void addPerson(Person person) {
        gAdapter.addPerson(person);
    }

    @Override
    protected void initialise() {
        recyclerView = (RecyclerView) parent.findViewById(R.id.grid_recycler_view);
        init();
    }

    private void init() {
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(recyclerView.getContext(), 3);
        recyclerView.setLayoutManager(layoutManager);

        gAdapter = new GridAdapter(EmulateUrlDownload.getList(), this, 3);
        recyclerView.setAdapter(gAdapter);
    }


}

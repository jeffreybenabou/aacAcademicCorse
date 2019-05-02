package com.example.jeffrey.academic.restaurant_menu;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jeffrey.academic.R;
import com.example.jeffrey.academic.recycler_view.RecyclerViewExample;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShowItems extends Fragment {


    public ShowItems() {

        // Required empty public constructor
    }

    private void loadTheRecycler() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        layoutManager.setSmoothScrollbarEnabled(true);


        RecyclerView recyclerView = getView().findViewById(R.id.resturant_recycler);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerAdapter adapter = new RecyclerAdapter(MenuActivity.pickedList);
        recyclerView.setAdapter(adapter);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_show_items, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        loadTheRecycler();
    }


}

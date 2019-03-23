package com.example.jeffrey.academic.fragment_example.transfer_data_between_fragmant_from_class;


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
public class ShowUsers extends Fragment {


    private ArrayList<UserNameExample> userNameExamples;
    public ShowUsers() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        userNameExamples=new ArrayList<>();
        return inflater.inflate(R.layout.fragment_show_users, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        initRecyclerView();
    }

    private void initRecyclerView(){

// TODO: 15/12/2018 איתחול של אובייקט מסוג recycelviev
        // TODO: 15/12/2018 אשר תפקידו הוא להציג לנו כמות מידע מסויימת לפי תבנית שהגדרנו מראש
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false);
        layoutManager.setSmoothScrollbarEnabled(true);

        RecyclerView recyclerView = getView().findViewById(R.id.user_recycler);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewClass adapter = new RecyclerViewClass(userNameExamples);
        recyclerView.setAdapter(adapter);
    }

    public ArrayList<UserNameExample> getUserNameExamples() {
        return userNameExamples;
    }

    public void setUserNameExamples(ArrayList<UserNameExample> userNameExamples) {
        this.userNameExamples = userNameExamples;
    }
}

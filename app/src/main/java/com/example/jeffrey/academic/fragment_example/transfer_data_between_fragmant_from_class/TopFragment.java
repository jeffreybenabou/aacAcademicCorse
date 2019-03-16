package com.example.jeffrey.academic.fragment_example.transfer_data_between_fragmant_from_class;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jeffrey.academic.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TopFragment extends Fragment {


    private int totalUsers=0;
    public TopFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_top, container, false);
    }

    public void changeTheData(String _lastName){
        TextView lastName,total;
        lastName=getView().findViewById(R.id.last_name);
        total=getView().findViewById(R.id.sum_users);
        totalUsers++;
        lastName.setText(_lastName);
        total.setText("סה’כ רשומים:"+totalUsers);
    }

}

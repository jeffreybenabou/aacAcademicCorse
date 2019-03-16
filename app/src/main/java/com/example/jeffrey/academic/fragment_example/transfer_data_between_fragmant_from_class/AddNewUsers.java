package com.example.jeffrey.academic.fragment_example.transfer_data_between_fragmant_from_class;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.jeffrey.academic.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddNewUsers extends Fragment {


    private EditText  phone,name,lastName;
    private Button addUsers;
    private ChangeDestData changeDestData;
    private ArrayList<EditText> editTextArray;

    public AddNewUsers() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_src, container, false);
    }


    public interface ChangeDestData{
        void changeData(UserNameExample userNameExample);
    }

    @Override
    public void onResume() {
        super.onResume();
        phone=getView().findViewById(R.id.enter_phone);
        name=getView().findViewById(R.id.enter_name);
        lastName=getView().findViewById(R.id.enter_last_name);
        addUsers=getView().findViewById(R.id.add_users);
        editTextArray=new ArrayList<>();
        editTextArray.add(phone);
        editTextArray.add(name);
        editTextArray.add(lastName);
        addUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkTheData())
                {
                    UserNameExample userNameExample=new UserNameExample(
                            editTextArray.get(0).getText().toString(),
                            editTextArray.get(1).getText().toString(),
                            editTextArray.get(2).getText().toString());

                    changeDestData.changeData(userNameExample);
                }
            }
        });
    }

    private boolean checkTheData() {
        boolean isVaild=true;
        for (EditText editText:editTextArray) {
            if(editText.getText().toString().isEmpty())
            {
                isVaild=false;
                editText.setError("");
            }
        }
        return isVaild;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        changeDestData=(ChangeDestData)context;
    }
}


package com.example.jeffrey.academic.fragment_example.rating_fragmant;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.SeekBar;
import android.widget.Spinner;

import com.example.jeffrey.academic.R;

public class FirstRatingFragmant extends Fragment {


    private SendDataToMainActivity dataSend;

    // TODO: 07/12/2018 נגדיר אובייקט מסוג View 
    // TODO: 07/12/2018 התפקיד שלו הוא לייצג לנו את תבנית העיצוב שלנו כדי שנוכל לגשת לרכיבים שנמצאים שמה  
    private View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         view=inflater.inflate(R.layout.rating_first_fragmant,container,false);
         seekbarDataLiseners();
         spinnerDataLiseners();
        return view;
    }

    private void seekbarDataLiseners() {
        // TODO: 07/12/2018 נגדיר מאזין אל מד התנועה שלנו כדי לדעת באיזה מיקום אנחנו נמצאים מבחינת המד שלנו  
        
        SeekBar seekBar = view.findViewById(R.id.seek_bar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                dataSend.setTheData(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    // TODO: 07/12/2018  מתודה זו היא מתודה שאנחנו דורסים ונכנסת לעבודה כאשר הפרגמנט נקשר אל הפעילות שלנו
    // TODO: 07/12/2018 בעצם אנחנו מקבלים פרמטר שמייצג לנו את הפעילות הפעילות שלנו כדי לדעת עם איזה פעילות הפרגמנט יתקשר
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        dataSend =(SendDataToMainActivity) context;
    }


    // TODO: 07/12/2018 בנינו ממשק שמכיל מתודה אבסטרקיבית אחת שתמוממש שפעילות שיורשת מהממשק על מנת לשלוח נתונים אל הפעילות שלנו
    public interface SendDataToMainActivity {
         void setTheData(float start);
    }

    public void spinnerDataLiseners(){

        // TODO: 07/12/2018 הגדרנו אובייקט מסוג ספינר כדי לדעת כמה כוכבים המשתמש ירצה להראות לנו
        Spinner spinner = view.findViewById(R.id.spinner);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                dataSend.setTheData(position+1);
                // TODO: 07/12/2018 נשתמש באובייקט מסוג ממשק שהגדרנו ונשלח מידע אל הפעילות שלנו דרך המתודה setTheData
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
}

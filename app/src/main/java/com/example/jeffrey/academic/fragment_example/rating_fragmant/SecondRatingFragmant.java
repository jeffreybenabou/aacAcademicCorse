package com.example.jeffrey.academic.fragment_example.rating_fragmant;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;

import com.example.jeffrey.academic.R;

public class SecondRatingFragmant extends Fragment {

    private View view;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // TODO: 07/12/2018  inflater האובייקט
        // TODO: 07/12/2018 תפקידו הוא לקבל תבנית עיצוב כלשהיא ולנתח  את התבנית על מנת ליצור את התצוגה שלנו 
        // TODO: 07/12/2018    הפעולה של inflater
        // TODO: 07/12/2018 דומה לפעולה של setContentView בפעילות כלשהיא
        view = inflater.inflate(R.layout.rating_seconde_fragmant, container, false);

        return view;
    }


    // TODO: 07/12/2018 מתודה שבניתי על מנת לגשת אל מד הרייטינג ולעדכן כמה כוכבים נרצה שהמשתמש יראה
    public void setTheRating(float rating) {
        RatingBar ratingBar = view.findViewById(R.id.ratingBar);
        ratingBar.setRating(rating);
    }





}

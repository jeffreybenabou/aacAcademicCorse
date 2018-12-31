package com.example.jeffrey.academic.fragment_example.rating_fragmant;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.jeffrey.academic.R;

public class RatingActivity extends AppCompatActivity implements FirstRatingFragmant.SendDataToMainActivity {

    // TODO: 07/12/2018  שימו לב שאנחנו מממשים ממשק מהפרגמנט הראשון על מנת לבצע תקשורת בין הפרגמנט לפעילות הראשית


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_rating_activity);

    }


    // TODO: 07/12/2018 בעת מימוש הממשק אנחנו מחוייבים למממש את המתודה הזו
    @Override
    public void setTheData(float star) {
        // TODO: 07/12/2018 נבנה אובייקט מסוג פרגמנט שמייצג את מד הרייטינג שלנו באמצעות גישה אל מנהל הפרגמנטים
        SecondRatingFragmant secondRatingFragmant = (SecondRatingFragmant) getSupportFragmentManager().findFragmentById(R.id.second_fragmant);
        secondRatingFragmant.setTheRating(star);
    }
}

package com.example.jeffrey.academic.data_send.secondExercise;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jeffrey.academic.R;

public class ShowData extends AppCompatActivity {

    private TextView showNameAndAge;
    private ImageView showImage;
    private String age;
    private String name;
    private EditText nameEdit,ageEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view_example);
        getTheData();
        try
        {
            Toast.makeText(this,  "ברוך הבא"+getIntent().getExtras().get("name"),Toast.LENGTH_LONG).show();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        setTheImageView();
        setTheTextView();

        nameEdit=findViewById(R.id.name_of_user);
        ageEdit=findViewById(R.id.age);





    }

    private void getTheData() {

        try
        {
            name = getIntent().getExtras().getString("name", "no value");
            age = getIntent().getExtras().getString("age", "no value");
        }catch (Exception e)
        {
            e.printStackTrace();
        }



    }

    private void setTheTextView() {
        showNameAndAge =findViewById(R.id.welcome_text);
        showNameAndAge.setText("ברוך הבא "+name+" שהגיל שלו "+age);
    }

    private void setTheImageView() {
        showImage =findViewById(R.id.image_to_show);
        showImage.setImageDrawable(getDrawable(R.drawable.logo_android));
    }
}

package com.example.jeffrey.academic.fragment_example.transfer_data_between_fragmant;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jeffrey.academic.R;


public class BottomFragmant extends Fragment {
    private ImageView imageView;
    private TextView name,lastName,location;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

//       todo פה אנחנו מגדירים בעצם איזה תבנית עיצוב אנחנו נרצה שהפרגמנט שלנו יציג לנו
        View view=inflater.inflate(R.layout.bottom_fragmant,container,false);
        defineTheComponent(view);
        return view;
    }

    private void defineTheComponent(View view) {
        // TODO: 05/12/2018 view הוא בעצם האובייקט שמכיל לנו את תבנית העיצוב שלנו
        imageView=view.findViewById(R.id.image_of_user);
        name=view.findViewById(R.id.first_name_in_end_semester);
        lastName=view.findViewById(R.id.last_name);
        location=view.findViewById(R.id.location);
    }

    public void showComponent(boolean name,boolean last,boolean location,boolean image){
        // TODO: 05/12/2018 מתודה שבודקת מה המצב של הcheckbox שלנו ולפי זה יודעת להראות רכיב או להעלים אותו
        if(name)
            this.name.setVisibility(View.VISIBLE);
        else
            this.name.setVisibility(View.INVISIBLE);

        if(last)
            this.lastName.setVisibility(View.VISIBLE);
        else
            this.lastName.setVisibility(View.INVISIBLE);

        if(location)
            this.location.setVisibility(View.VISIBLE);
        else
            this.location.setVisibility(View.INVISIBLE);

        if(image)
            this.imageView.setVisibility(View.VISIBLE);
        else
            this.imageView.setVisibility(View.INVISIBLE);


    }
}

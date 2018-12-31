package com.example.jeffrey.academic.fragment_example.transfer_data_between_fragmant;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.example.jeffrey.academic.R;

public class TopFragmant extends Fragment {

    static boolean name=false,lastName=false,location=false,image=false;

    private CheckBox showName,showLastName,showLocation, showUserImage;
    // TODO: 05/12/2018  אובייקט מסוג ממשק שתפקידו הוא לתקשר עם הפעילות המכילה את הפרגמנט כאובייקט
    private TopFragmantLiseners topFragmantLiseners;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.top_fragment,container,false);
        defineTheComponent(view);
        return view;
    }
//todo אנחנו נבנה ממשק כלשהוא עם מתודה שתקבל ארבעה פרמטרים בוליאנים על מנת לעדכן את הפעילות שלנו על שינוי במצב הכפתורים
    public interface TopFragmantLiseners{
         void whichComponentIsChecked(boolean name,boolean lastName,boolean location,boolean image);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        // TODO: 06/12/2018 מתודה זו נכנסת לפעולה כאשר הפרגמנט נקשר אל הפעילות שלנו
        try {
            topFragmantLiseners=(TopFragmantLiseners)context;

        }catch (Exception e)
        {

        }
    }

    private void defineTheComponent(View view) {

        showName=view.findViewById(R.id.first_name_top);
        showLastName=view.findViewById(R.id.last_name_top);
        showLocation=view.findViewById(R.id.location_top);
        showUserImage =view.findViewById(R.id.image_of_user_top);

        setTheLiseners(showName,0);
        setTheLiseners(showLastName,1);
        setTheLiseners(showLocation,2);
        setTheLiseners(showUserImage,3);

    }

    public void setTheLiseners(CheckBox checkBox, final int type){

        // TODO: 05/12/2018 מתודה שמאתחלת כל פעם רכיב אחר ומוסיפה לו מאזין במקום להוסיף לכל רכיב מאזין מה שמקצר לנו את הקוד
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                switch (type)
                {
                    case 0:
                        name = isChecked;
                        break;
                    case 1:
                        lastName = isChecked;
                        break;
                    case 2:
                        location = isChecked;
                        break;
                    case 3:
                        image = isChecked;
                        break;
                }
/*
*  TODO: 05/12/2018 ברגע שיש מימוש למתודה הזו במקום כלשהוא אז הקיראה למתודה תגיע למקום שמיממשנו את המתודה של ה מממשק במקרה הזה במחלקה
*  DataHandlerActivity
*
 * */
                topFragmantLiseners.whichComponentIsChecked(name,lastName,location,image);
            }
        });
    }


}

package com.example.jeffrey.academic.firebase_example.firebase_users_data_add_data_change;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jeffrey.academic.R;
import com.example.jeffrey.academic.firebase_example.FireBaseInit;
import com.example.jeffrey.academic.firebase_example.add_new_user_to_database.UserNameClass;
import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FireBaseExmaple extends AppCompatActivity {


    // TODO: 31/12/2018 אובייקט מסוג מפה אשר יכיל בתוכו את הערכים שנרצה להוסיף אל הדאטה בייס
    private Map<String,Object>map=new HashMap<>();
    private FireBaseInit singalton;
    private EditText collection,document,field,fieldData;
    private ArrayList<EditText>editTexts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        singalton=FireBaseInit.getInstance(this);
        setContentView(R.layout.activity_firebase_remove_data);
        setTheEditTexts();




    }

    private void setTheEditTexts() {


        // TODO: 30/12/2018 מתודה שתפקידה היא לטעון את כל הפקדים שלנו אל תוך מערך ולאחר מכן לרוץ על הפקדים ולראות אם הם רקים או לא
        // TODO: 31/12/2018 זה בעצם גורם לקוד שלנו להתקצר בהרבה ולייעל את עצמנו בתור מפתחים
        // TODO: 31/12/2018 כאשר בהמשך אנחנו נשתמש במערך הזה על מנת לבדוק אם הערך שבתוך הפקד הוא ריק או לא
        editTexts=new ArrayList<>();
        field=findViewById(R.id.name_of_field_to_change);
        collection=findViewById(R.id.collection_name);
        document=findViewById(R.id.name_of_document_to_change);
        fieldData=findViewById(R.id.new_field_value);

        editTexts.add(fieldData);
        editTexts.add(field);
        editTexts.add(collection);
        editTexts.add(document);

    }


    public void onClick(View view)
    {
        // TODO: 31/12/2018 מתודה שמקושרת למספר כפתורים דרך תבנית העיצוב
        switch (view.getId())
        {


            case R.id.add_new_data_to_firebase:
                if(checkAllFieldHaveData())
                    addDataToFireBase();


                break;











            case R.id.connect_firebase:
                if(singalton.user==null)
                    connectToFireBase();
                else
                    Toast.makeText(this,"משתמש כבר מחובר",Toast.LENGTH_LONG).show();
                break;







            case R.id.sign_out:
                if(singalton.user!=null)
                    signOut();
                else
                    Toast.makeText(this,"אין משתמש מחובר",Toast.LENGTH_LONG).show();
                break;






            case R.id.delete_user:
                if(singalton.user!=null)
                {
                    final String userName=singalton.user.getDisplayName();

                                    AuthUI.getInstance()
                                            .delete(FireBaseExmaple.this)
                                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NonNull Task<Void> task) {
                                                    Toast.makeText(FireBaseExmaple.this,"המשתמש "+userName+" נמחק מהרשומות בהצלחה.",Toast.LENGTH_LONG).show();
                                                }
                                            });


                }

                else
                    Toast.makeText(this,"אין משתמש מחובר",Toast.LENGTH_LONG).show();

                break;

        }
        singalton.user = FirebaseAuth.getInstance().getCurrentUser();
    }



    private void addDataToFireBase() {
        // TODO: 30/12/2018 לאחר שווידנו שהערכים אינם רקים נבנה אובייקט מסוג מפה ונכניס לתוכו את הערך של
         // TODO: 30/12/2018 השדה שלנו שנרצה שיהיה לנו במסד נתונים
        // TODO: 31/12/2018 שימו לב שכל פעם שנשנה את הערך של "שדה" אז יתווסף לנו שדה חדש בפיירבייס
        map.put(field.getText().toString(),fieldData.getText().toString());


        // TODO: 30/12/2018 מה שעשינו פה הוא בעצם להכניס את הערכים מתוך הקלט אל תוך המסד נתונים שלנו
        // TODO: 31/12/2018   האובייקטים שניתן להכניס אל מסד נתונים הם אובייקטים מסוג מחלקות גאווה או מפות
        singalton.getDatabase().collection(collection.getText().toString())
                .document(document.getText().toString())
                .set(map).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                // TODO: 30/12/2018 מאזין שבודק האם הפעולה הושלמה
                Toast.makeText(FireBaseExmaple.this,"מסמך נוצר בהצלחה",Toast.LENGTH_LONG).show();
            }
        });
    }

    private void signOut() {
        AuthUI.getInstance()
                .signOut(this)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(FireBaseExmaple.this,"התנתקת מהמשתמש",Toast.LENGTH_LONG).show();

                    }
                });
    }

    private void connectToFireBase() {
        startActivityForResult(
                        AuthUI.getInstance()
                                .createSignInIntentBuilder()
                        .setAvailableProviders(singalton.providers)
                        .build(),
                0);
    }

    private boolean checkAllFieldHaveData() {
        // TODO: 30/12/2018 מתודה שבודקת אם הערך שנמצא בפקד ריק ובמידה והוא ריק תציג שגיאה כלשהיא
        int x=0;
        for (EditText e:editTexts) {
            if(e.getText().toString().isEmpty())
            {
                x++;
                e.setError("יש להקליד את "+e.getHint());
            }
        }
        return x == 0;
    }





    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 0) {


            if (resultCode == RESULT_OK) {
                singalton. user = FirebaseAuth.getInstance().getCurrentUser();
                assert singalton.user != null;
                Toast.makeText(FireBaseExmaple.this,"ברוך הבא "+singalton.user.getDisplayName(),Toast.LENGTH_LONG).show();

            }
        }
    }

}

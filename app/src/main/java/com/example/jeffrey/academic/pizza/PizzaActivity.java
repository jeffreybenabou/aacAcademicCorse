package com.example.jeffrey.academic.pizza;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.jeffrey.academic.R;

public class PizzaActivity extends AppCompatActivity {

    private EditText name,phoneNumber,addressOfMail;
    private Button moveToOrder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza);
        setTheEditText();
        setTheButton();


    }



    private void setTheButton() {
        moveToOrder=findViewById(R.id.order_pizza);
        moveToOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name.getText().toString().length()>0&&phoneNumber.getText().toString().length()==10&&addressOfMail.getText().toString().length()>0)
                {
                    startActivity(new Intent(PizzaActivity.this,PizzaOrder.class).putExtra("name",name.getText().toString()).putExtra("address",addressOfMail.getText().toString()).putExtra("phone",phoneNumber.getText().toString()));
                    finish();
                }else
                setTheErrorOfEditText();

            }
        });
    }

    private void setTheErrorOfEditText() {
        if(name.getText().toString().length()==0){
            name.setError("נא להכניס שם");
        }else
            name.setError(null);

        if(phoneNumber.getText().toString().length()!=10){
            phoneNumber.setError("יש להכניס מספר פלאפון בעל 10 ספרות");

        }else
            phoneNumber.setError(null);
        if(addressOfMail.getText().toString().length()==0){
            addressOfMail.setError("נא להכניס כתובת מגורים");
        }else
            addressOfMail.setError(null);
    }

    private void setTheEditText() {
        name=findViewById(R.id.name);
        phoneNumber=findViewById(R.id.phone);
        addressOfMail=findViewById(R.id.address);

    }
}

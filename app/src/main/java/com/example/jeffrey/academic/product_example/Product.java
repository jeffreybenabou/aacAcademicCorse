package com.example.jeffrey.academic.product_example;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jeffrey.academic.R;

public class Product extends AppCompatActivity {

    private TextView name,area, description,cost,id,nameOfProduct,sellerNumber;
    private ImageView imageView;
    private Button sendMail,callSeller,sendMessage;
    private String sellerPhoneNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        sellerPhoneNumber="0501234567";

        defineTextView();
        defineButtonsAction();



    }

    private void defineButtonsAction() {
        sendMail=findViewById(R.id.send_mail_button);
        sendMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activeTheGmailImplicitIntent();
            }
        });
        callSeller=findViewById(R.id.call_seller);
        callSeller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activeTheCallImplicitIntent();
            }
        });
        sendMessage=findViewById(R.id.send_message);
        sendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activeTheSmsImplicitIntent();
            }
        });
    }

    private void defineTextView() {
        for (int i = 0; i <7 ; i++) {
            switch (i)
            {
                case 0:
                    name=setTheTextViews("שם מוכר :יובל",R.id.name_of_seller);
                    break;
                case 1:
                    area= setTheTextViews("אזור:דרום",R.id.area);
                    break;
                case 2:
                    description = setTheTextViews("תיאור:מוצר מיוחד וחדשני",R.id.discription);
                    break;
                case 3:
                    cost=   setTheTextViews("מחיר :8000",R.id.cost);
                    break;
                case 4:
                    id=  setTheTextViews("קוד מוצר: 1",R.id.id_of_product);
                    break;
                case 5 :
                    nameOfProduct=  setTheTextViews("שם מוצר:מוצר חסוי",R.id.type_of_product);
                    break;
                case 6 :
                    sellerNumber=setTheTextViews("מספר טלפון:"+""+sellerPhoneNumber,R.id.number_of_seller);

                    break;
            }

        }
    }

    private TextView setTheTextViews(String text,int id) {
        TextView textView;
        textView=findViewById(id);
        textView.setText(text);
        textView.setTextSize(20);
        return textView;
    }

    private void activeTheSmsImplicitIntent(){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("sms:"+sellerPhoneNumber));
        startActivity(intent);
    }
    private void activeTheCallImplicitIntent(){
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", ""+sellerPhoneNumber, null));
        startActivity(intent);
    }
    private void activeTheGmailImplicitIntent(){
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto","gmail@gmail.com", null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "id");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "");
        startActivity(Intent.createChooser(emailIntent, "Send email..."));
    }


    public TextView getName() {
        return name;
    }

    public void setName(TextView name) {
        this.name = name;
    }

    public TextView getArea() {
        return area;
    }

    public void setArea(TextView area) {
        this.area = area;
    }

    public TextView getDescription() {
        return description;
    }

    public void setDescription(TextView description) {
        this.description = description;
    }

    public TextView getCost() {
        return cost;
    }

    public void setCost(TextView cost) {
        this.cost = cost;
    }

    public TextView getId() {
        return id;
    }

    public void setId(TextView id) {
        this.id = id;
    }

    public TextView getNameOfProduct() {
        return nameOfProduct;
    }

    public void setNameOfProduct(TextView nameOfProduct) {
        this.nameOfProduct = nameOfProduct;
    }

    public TextView getSellerNumber() {
        return sellerNumber;
    }

    public void setSellerNumber(TextView sellerNumber) {
        this.sellerNumber = sellerNumber;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }
}

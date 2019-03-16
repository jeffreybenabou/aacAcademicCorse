package com.example.jeffrey.academic.final_assignment_first_semester;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jeffrey.academic.R;

import java.util.Objects;

public class DestinationActivity extends AppCompatActivity {

    private Destination destination;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination);
        whichObjectHasBeenPicked();

    }

    public void onClickEmailMessageCall(View view){
        switch (view.getId())
        {
            case R.id.email_end_semster:
                setTheGmailIntent();
                break;
            case R.id.message_end_semster:
                setTheTextIntent();
                break;
            case R.id.phone_call_end_semster:
                setThePhoneCallIntent();
                break;
        }
    }
    private void whichObjectHasBeenPicked() {
        switch (Objects.requireNonNull(getIntent().getExtras()).getInt("index"))
        {
            case 0:
                setData(ItemsActivity.destinationArrayList.get(0));
                destination=ItemsActivity.destinationArrayList.get(0);
                break;
            case 1:
                setData(ItemsActivity.destinationArrayList.get(1));
                destination=ItemsActivity.destinationArrayList.get(1);
                break;
            case 2:
                setData(ItemsActivity.destinationArrayList.get(2));
                destination=ItemsActivity.destinationArrayList.get(2);
                break;
            case 3:
                setData(ItemsActivity.destinationArrayList.get(3));
                destination=ItemsActivity.destinationArrayList.get(3);
                break;
        }
    }



    private void setData(Destination destination) {
        ImageView imageView=findViewById(R.id.image_to_show_end_semster);
        TextView title=findViewById(R.id.title_end_semster);
        TextView cost=findViewById(R.id.cost_end_semster);
        TextView description=findViewById(R.id.description);
        TextView flightNumber=findViewById(R.id.flight_number);
        TextView date=findViewById(R.id.date);

        imageView.setImageDrawable(getDrawable(destination.getImageId()));
        cost.setText(destination.getCost());
        description.setText(destination.getDescription());
        flightNumber.setText(destination.getFlightNumber());
        date.setText(destination.getDate());
        title.setText(destination.getNameOfCountry());
    }

    private void setThePhoneCallIntent() {

        Intent phoneCall = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "0508177842", null));
        try
        {
            startActivity(phoneCall);
        }catch (Exception e)
        {
            e.fillInStackTrace();
        }


    }

    private void setTheTextIntent() {



        Intent textMessage = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:0508177842"));
        textMessage.putExtra("sms_body", "");
        try
        {
            startActivity(textMessage);
        }catch (Exception e)
        {
            e.fillInStackTrace();
        }



    }

    private void setTheGmailIntent(){
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto", "jeffreybenabou@gmail.com", null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT,""+destination.getDate()+"/"+destination.getNameOfCountry());
        emailIntent.putExtra(Intent.EXTRA_TEXT,"");

        try
        {
            startActivity(emailIntent);
        }catch (Exception e)
        {
            e.fillInStackTrace();
        }
    }
}

package com.example.profilemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //onOpenGoogleMap

    public void onOpenInGoogleMaps(View view){
        //google map url
        EditText teamAddress = findViewById(R.id.teamAddressField);
        // Create a Uri from an intent string. Use the result to create an Intent.
        Uri gmmIntentUri = Uri.parse("http://maps.google.co.in/maps?q="+teamAddress.getText());

        // Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
        Intent mapIntent = new Intent(Intent.ACTION_VIEW,gmmIntentUri);

        // Make the Intent explicit by setting the Google Maps package
        mapIntent.setPackage("com.google.android.apps.maps");

        // Attempt to start an activity that can handle the Intent
        startActivity(mapIntent);

        //need Google APIs in your Virtual Emulator, most current Android Images have it included
    }

    public void OnSetAvatarButton(View view){
        //Application context and activity
        Intent intent = new Intent(getApplicationContext(),ProfileActivity.class);
        startActivityForResult(intent,0);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);

        if(resultCode == RESULT_CANCELED) return;

        ImageView avatarImage = (ImageView) findViewById(R.id.avatarImage);
        String drawableName = "ic_logo_00";

        switch(data.getIntExtra("imageId",R.id.teamId00)){
                case R.id.teamId00:
                    drawableName="ic_logo_00";
                    break;
                case R.id.teamId01:
                    drawableName="ic_logo_01";
                    break;
                case R.id.teamId02:
                    drawableName="ic_logo_02";
                    break;
                case R.id.teamId03:
                    drawableName="ic_logo_03";
                    break;
                case R.id.teamId04:
                    drawableName="ic_logo_04";
                    break;
                case R.id.teamId05:
                    drawableName="ic_logo_05";
                    break;
            default:
                drawableName ="ic_logo_00";
                break;
            }
        int resID = getResources().getIdentifier(drawableName,"drawable",getPackageName());
        avatarImage.setImageResource(resID);

    }


}
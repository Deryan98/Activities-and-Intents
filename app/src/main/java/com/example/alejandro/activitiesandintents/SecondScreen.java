package com.example.alejandro.activitiesandintents;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by alejandro on 4/2/18.
 */

public class SecondScreen extends AppCompatActivity {
    TextView receivedText;
    Button homeScreen;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_screen);

        Intent callingIntent = getIntent();
        String intentAction = callingIntent.getAction();
        String intentType = callingIntent.getType();

        if (Intent.ACTION_SEND.equals(intentAction) && intentType != null){
            if (intentType.equals("text/plain")){
                handleReceivedText(callingIntent);
            }
        }

        homeScreen = (Button) findViewById(R.id.goToFstScreenBtn);
        homeScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fstScreenIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(fstScreenIntent);
            }
        });

    }

    private void handleReceivedText(Intent intent){
        receivedText = (TextView)findViewById(R.id.textReceived);
        String intentText = intent.getStringExtra(Intent.EXTRA_TEXT);

        if (receivedText != null){
            receivedText.setText(intentText);
        }
    }
}

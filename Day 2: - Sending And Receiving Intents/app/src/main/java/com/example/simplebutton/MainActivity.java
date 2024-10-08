package com.example.simplebutton;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textView);


        Button homeButton = findViewById(R.id.mainButton);

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                textView.setText("Number of clicks are"+ counter);
                if (counter==10){
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://neupaneniraj.com.np/"));
                    startActivity(browserIntent);
                }
            }
        });
    }
}

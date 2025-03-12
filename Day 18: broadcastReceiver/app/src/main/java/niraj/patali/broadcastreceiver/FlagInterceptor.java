package niraj.patali.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class FlagInterceptor extends BroadcastReceiver {
    private static final String TAG = "FlagInterceptor";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "Broadcast received!");
        String flag = intent.getStringExtra("flag");
        Log.d(TAG, "Intercepted flag: " + flag);
        Toast.makeText(context, "Received flag: " + flag, Toast.LENGTH_LONG).show();
        // Optionally, set a result code for an ordered broadcast
        setResultCode(1);
    }
}


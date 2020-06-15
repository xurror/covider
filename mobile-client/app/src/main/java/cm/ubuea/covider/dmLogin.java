package cm.ubuea.covider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class dmLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dm_login);

//        Button location_button = findViewById(R.id.location_button);
//        location_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(getApplicationContext(), "Login successful", Toast.LENGTH_LONG).show();
//                Intent gotoUserLocation = new Intent(getApplicationContext(), dmUserLocation.class);
//                startActivity(gotoUserLocation);
//            }
//        });

        Button login_button = findViewById(R.id.login_button);
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotoDisTracking = new Intent(getApplicationContext(), dmDisTrack.class);
                startActivity(gotoDisTracking);
            }
        });
    }
}
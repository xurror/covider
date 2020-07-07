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

<<<<<<< HEAD
        Button location_button = findViewById(R.id.location_button);
        location_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Toast.makeText(getApplicationContext(), "Message sent, will be in touch", Toast.LENGTH_LONG).show();
                Intent gotoUserLocation = new Intent(getApplicationContext(), dmUserLocation.class);
                startActivity(gotoUserLocation);
            }
        });
=======
        /*Button location_button = findViewById(R.id.location_button);
        location_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Toast.makeText(getApplicationContext(), "Message sent, will be in touch", Toast.LENGTH_LONG).show();
                    Intent gotoUserLocation = new Intent(getApplicationContext(), dmUserLocation.class);
                    startActivity(gotoUserLocation);
                }
        });*/
>>>>>>> 8d7a999... Added one page


        Button login_button = findViewById(R.id.login_button);
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Toast.makeText(getApplicationContext(), "Message sent, will be in touch", Toast.LENGTH_LONG).show();
<<<<<<< HEAD
                Intent gotoDisTracking = new Intent(getApplicationContext(), dmDisTrack.class);
=======
                Intent gotoDisTracking = new Intent(getApplicationContext(), dmList.class);
>>>>>>> 8d7a999... Added one page
                startActivity(gotoDisTracking);
            }
        });
    }
}

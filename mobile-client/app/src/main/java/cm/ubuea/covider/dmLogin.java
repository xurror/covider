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

//        Button location_button = findViewById(R.id.location_button);
//        location_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(getApplicationContext(), "Login successful", Toast.LENGTH_LONG).show();
//                Intent gotoUserLocation = new Intent(getApplicationContext(), dmUserLocation.class);
//                startActivity(gotoUserLocation);
//            }
//        });

=======
        
>>>>>>> 03fd9d9080807420c4d55bd5497ce766e7eddca0
        Button login_button = findViewById(R.id.login_button);
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
<<<<<<< HEAD
                Intent gotoDisTracking = new Intent(getApplicationContext(), dmDisTrack.class);
                startActivity(gotoDisTracking);
            }
        });
    }
}
=======
                // Toast.makeText(getApplicationContext(), "Message sent, will be in touch", Toast.LENGTH_LONG).show();
                Intent gotoUsers = new Intent(getApplicationContext(), Users.class);
                startActivity(gotoUsers);
            }
        });
    }
}
>>>>>>> 03fd9d9080807420c4d55bd5497ce766e7eddca0

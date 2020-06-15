package cm.ubuea.covider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class dmUserLocation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dm_user_location);

        Button back_button = findViewById(R.id.submit_button);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Location set", Toast.LENGTH_LONG).show();
                Intent gotoLogin = new Intent(getApplicationContext(), dmLogin.class);
                startActivity(gotoLogin);
            }
        });
    }
}
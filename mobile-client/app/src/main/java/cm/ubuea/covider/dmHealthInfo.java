package cm.ubuea.covider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class dmHealthInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dm_health_info);

        Button submit_button = findViewById(R.id.submit_button);
        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Status recorded", Toast.LENGTH_LONG).show();
<<<<<<< HEAD
                Intent gotoRandevouz = new Intent(getApplicationContext(), dmRandevouz.class);
                startActivity(gotoRandevouz);
=======
                Intent gotoUser = new Intent(getApplicationContext(), Users.class);
                startActivity(gotoUser);
>>>>>>> 03fd9d9080807420c4d55bd5497ce766e7eddca0
            }
        });
    }
}
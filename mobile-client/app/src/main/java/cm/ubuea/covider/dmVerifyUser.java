package cm.ubuea.covider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
<<<<<<< HEAD
=======
import android.widget.EditText;
>>>>>>> 03fd9d9080807420c4d55bd5497ce766e7eddca0
import android.widget.Toast;

public class dmVerifyUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dm_verify_user);

        Button verify_button = findViewById(R.id.verify_button);
        verify_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "user verified", Toast.LENGTH_LONG).show();
                Intent sendAlert = new Intent(getApplicationContext(), dmHealthInfo.class);
                startActivity(sendAlert);
            }
        });
    }
}
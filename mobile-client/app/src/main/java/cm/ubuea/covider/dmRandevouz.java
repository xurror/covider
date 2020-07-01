package cm.ubuea.covider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class dmRandevouz extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dm_randevouz);

<<<<<<< HEAD
        Button rendevouz_button = findViewById(R.id.rendevouz_button);
=======
        Button rendevouz_button = findViewById(R.id.rendezvous_button);
>>>>>>> 03fd9d9080807420c4d55bd5497ce766e7eddca0
        rendevouz_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Message sent, will be in touch", Toast.LENGTH_LONG).show();
<<<<<<< HEAD
                Intent sendToDb = new Intent(getApplicationContext(), dmRandevouz.class);
=======
                Intent sendToDb = new Intent(getApplicationContext(), dmLogin.class);
>>>>>>> 03fd9d9080807420c4d55bd5497ce766e7eddca0
                startActivity(sendToDb);
            }
        });
    }
}
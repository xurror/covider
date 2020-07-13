package cm.ubuea.covider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class dmLanguage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dm_language);

        Button button_eng = findViewById(R.id.button_eng);
        button_eng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Language set to English", Toast.LENGTH_LONG).show();
                Intent gotoLogin = new Intent(getApplicationContext(), dmLogin.class);
                startActivity(gotoLogin);
                finish();
            }
        });
    }
}
package cm.ubuea.covider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class dmDisTrack extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dm_dis_track);

        Button found_button = findViewById(R.id.found_button);
        found_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotoVerifyUser = new Intent(getApplicationContext(), dmVerifyUser.class);
                startActivity(gotoVerifyUser);
            }
        });

    }
}
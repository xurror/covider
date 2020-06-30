package cm.ubuea.covider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.getbase.floatingactionbutton.FloatingActionButton;

public class Notification extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        ImageView back_user = findViewById(R.id.back_user);
        back_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Toast.makeText(getApplicationContext(), "Message sent, will be in touch", Toast.LENGTH_LONG).show();
                Intent gotoUser = new Intent(getApplicationContext(), Users.class);
                startActivity(gotoUser);
            }
        });
    }
}
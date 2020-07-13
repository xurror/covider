package cm.ubuea.covider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class dmSplash extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dm_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent gotoSetLanguage = new Intent(dmSplash.this, dmLanguage.class);
                startActivity(gotoSetLanguage);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
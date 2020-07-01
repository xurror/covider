package cm.ubuea.covider;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Handler;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    ProgressDialog pDialog;
    private final int SPLASH_DISPLAY_LENGTH = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent gotoHome = new Intent(getApplicationContext(), dmLogin.class);
        startActivity(gotoHome);
        finish();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void run(){
                Intent intent = new Intent(MainActivity.this, Login.class);
                MainActivity.this.startActivity(intent);
                MainActivity.this.finish();

                pDialog = new ProgressDialog(MainActivity.this);
                pDialog.setCancelable(false);
                pDialog.setIndeterminate(false);
                pDialog.setMessage("Loading...");
                pDialog.show();
            }

        }, SPLASH_DISPLAY_LENGTH);

    }
}
package cm.ubuea.covider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.getbase.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Notification extends AppCompatActivity {

    ListView lw_notification;
    ///String[] notifications;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        lw_notification = findViewById(R.id.lw_notification);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("New Notification ");
        arrayList.add("New Notification ");
        arrayList.add("New Notification ");
        arrayList.add("New Notification ");
        arrayList.add("New Notification ");
        arrayList.add("New Notification ");
        arrayList.add("New Notification ");
        arrayList.add("New Notification ");
        arrayList.add("New Notification ");
        arrayList.add("New Notification ");
        arrayList.add("New Notification ");
        arrayList.add("New Notification ");


        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,arrayList);
        lw_notification.setAdapter(arrayAdapter);
        //notifications = new;

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
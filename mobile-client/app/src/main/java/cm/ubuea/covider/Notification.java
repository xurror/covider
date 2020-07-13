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
        arrayList.add("New user location available");
        arrayList.add("Products running out back to base for review ");
        arrayList.add("Agent impersonation, click to get verified ");
        arrayList.add("Weekly updates From citizen W: \n" +
                "Last visited location: Buea, Cameroon\n" +
                "Signs and symptoms\n" +
                "Cough: No\n" +
                "Fever: No\n" +
                "Tiredness: No ");
        arrayList.add("General Meeting at 1pm on Sunday 03-07-2020\n" +
                "Location: Ministry of Health, Yaounde");
        arrayList.add("New user location available");
        arrayList.add("Following the meeting held last week, you have been relocated to Bamenda for distribution");
        arrayList.add("Signed in from a new device, verify it's you");
        arrayList.add("Weekly updates From citizen X: \n" +
                "Last visited location: Buea, Cameroon\n" +
                "Signs and symptoms\n" +
                "Cough: No\n" +
                "Fever: No\n" +
                "Tiredness: No");
        arrayList.add("Weekly updates From citizen Y: \n" +
                "Last visited location: Buea, Cameroon\n" +
                "Signs and symptoms\n" +
                "Cough: No\n" +
                "Fever: No\n" +
                "Tiredness: No ");
        arrayList.add("Agent meeting");
        arrayList.add("Weekly updates From citizen Z: \n" +
                "Last visited location: Buea, Cameroon\n" +
                "Signs and symptoms\n" +
                "Cough: No\n" +
                "Fever: No\n" +
                "Tiredness: No ");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,arrayList);
        lw_notification.setAdapter(arrayAdapter);
        //notifications = new;

        ImageView back_user = findViewById(R.id.back_user);
        back_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Toast.makeText(getApplicationContext(), "Message sent, will be in touch", Toast.LENGTH_LONG).show();
                Intent gotoUser = new Intent(getApplicationContext(), dmList.class);
                startActivity(gotoUser);
            }
        });
    }
}
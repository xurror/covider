package cm.ubuea.covider;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.getbase.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class dmList extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dm_list);
        final ListView list = findViewById(R.id.list);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("1. Azimbom Pino");
        arrayList.add("2. Dong Harry");
        arrayList.add("3. Durrell Gemuh");
        arrayList.add("4. Kapgang Ralph ");
        arrayList.add("5. Mbekou Jessie");
        arrayList.add("6. Mobou Defo");
        arrayList.add("7. Nanfack Takoutsi");
        arrayList.add("8. Njoko A. Cesar");
        arrayList.add("9. Ndoh Rowling");
        arrayList.add("10. Nkoa Christophe");
        arrayList.add("11. Okonkwo Jasper");
        arrayList.add("12. Sonwa Yanne");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, arrayList);
        list.setAdapter(arrayAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent gotoUserLocation = new Intent(getApplicationContext(), dmDisTrack.class);
                startActivity(gotoUserLocation);
            }
        });

        ImageView notifications = findViewById(R.id.notifications);
        notifications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Toast.makeText(getApplicationContext(), "Message sent, will be in touch", Toast.LENGTH_LONG).show();
                Intent gotoNotification = new Intent(getApplicationContext(), Notification.class);
                startActivity(gotoNotification);
            }
        });

        FloatingActionButton notification = findViewById(R.id.notification);
        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Toast.makeText(getApplicationContext(), "Message sent, will be in touch", Toast.LENGTH_LONG).show();
                Intent gotoNotification = new Intent(getApplicationContext(), Notification.class);
                startActivity(gotoNotification);
            }
        });

        FloatingActionButton account = findViewById(R.id.account);
        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Toast.makeText(getApplicationContext(), "Message sent, will be in touch", Toast.LENGTH_LONG).show();
                Intent gotoAccount = new Intent(getApplicationContext(), dmAccount.class);
                startActivity(gotoAccount);
            }
        });
    }
}

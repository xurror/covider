package cm.ubuea.covider;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class PersonNotifications extends AppCompatActivity {
    ProgressDialog pDialog;
    SharedPreferences sharedPreferences;

    SearchView searchView;

    ArrayList<NotificationModel> notificationModelArrayList;
    private RecyclerView recyclerView;
    NotificationAdapter notificationAdapter;

    String username, email, userid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_notifications);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        sharedPreferences = getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
        userid = sharedPreferences.getString(getResources().getString(R.string.prefLoginUserID), "");
        username = sharedPreferences.getString(getResources().getString(R.string.prefLoginUserName), "");
        email = sharedPreferences.getString(getResources().getString(R.string.prefLoginUserEmail), "");

        recyclerView = findViewById(R.id.rv2);

        notificationModelArrayList = new ArrayList<>();

        getNotifications();
    }

    private void getNotifications() {
        for (int i = 0; i < 10; i++) {
            notificationModelArrayList.add(new NotificationModel(
                    "Title",
                    "Notification",
                    "2020:07:15"
            ));

            recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),1));
            notificationAdapter = new NotificationAdapter(notificationModelArrayList);
            recyclerView.setHasFixedSize(true);
            recyclerView.setAdapter(notificationAdapter);

            notificationAdapter.setOnItemClickListener(new NotificationAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(int position) {


                }
            });
        }
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(PersonNotifications.this, PersonHome.class));
        finish();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    startActivity(new Intent(PersonNotifications.this, PersonHome.class));
                    finish();
                    return true;
                case R.id.navigation_dashboard:
                    startActivity(new Intent(PersonNotifications.this, PersonHome.class));
                    finish();
                    return true;
                case R.id.navigation_notifications:
                    startActivity(new Intent(PersonNotifications.this, PersonNotifications.class));
                    finish();
                    return true;
            }
            return false;
        }
    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options, menu);

        searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                notificationAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                notificationAdapter.getFilter().filter(newText);
                return false;
            }
        });

        return true;
    }



}
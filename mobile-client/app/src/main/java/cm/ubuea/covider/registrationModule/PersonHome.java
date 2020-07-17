package cm.ubuea.covider;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

public class PersonHome extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    ProgressDialog pDialog;
    SharedPreferences sharedPreferences;

    String username, email, userid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_home);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        sharedPreferences = getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
        userid = sharedPreferences.getString(getResources().getString(R.string.prefLoginUserID), "");
        username = sharedPreferences.getString(getResources().getString(R.string.prefLoginUserName), "");
        email = sharedPreferences.getString(getResources().getString(R.string.prefLoginUserEmail), "");

        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);



        PersonHomePagerAdapter pageAdapter = new PersonHomePagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(pageAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                tabLayout.setScrollPosition(position, positionOffset, true);
                tabLayout.setSelected(true);
            }

            @Override
            public void onPageSelected(int position) {
                tabLayout.setScrollPosition(position, 0, true);
                tabLayout.setSelected(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }


    @Override
    public void onBackPressed() {
        finish();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    startActivity(new Intent(PersonHome.this, PersonHome.class));
                    finish();
                    return true;
                case R.id.navigation_dashboard:
                    startActivity(new Intent(PersonHome.this, PersonHome.class));
                    finish();
                    return true;
                case R.id.navigation_notifications:
                    startActivity(new Intent(PersonHome.this, PersonHome.class));
                    finish();
                    return true;
            }
            return false;
        }
    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.logout){
            logout();
        }
        else if (id == R.id.contact){
            startActivity(new Intent(PersonHome.this, PersonHome.class));
            finish();
        }
        else if (id == R.id.settings){
            startActivity(new Intent(PersonHome.this, PersonHome.class));
            finish();
        }
        else if (id == R.id.profile){
            startActivity(new Intent(PersonHome.this, PersonHome.class));
            finish();
        }
        else if (id == R.id.about){
            Uri uri = Uri.parse("https://www.ubuea.cm/");
            startActivity(new Intent(Intent.ACTION_VIEW, uri));
        }
        return super.onOptionsItemSelected(item);
    }

    public void logout(){
        pDialog = new ProgressDialog(PersonHome.this);
        pDialog.setCancelable(false);
        pDialog.setIndeterminate(false);
        pDialog.setMessage("Logging out...");
        pDialog.show();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(getResources().getString(R.string.prefLoginState), "loggedout");
        editor.putString(getResources().getString(R.string.prefLoginUserID), "");
        editor.putString(getResources().getString(R.string.prefLoginUserName), "");
        editor.putString(getResources().getString(R.string.prefLoginUserEmail), "");
        editor.putString(getResources().getString(R.string.prefLoginUserStatus), "");
        editor.apply();

        startActivity(new Intent(PersonHome.this, Login.class));
        finish();

    }





}
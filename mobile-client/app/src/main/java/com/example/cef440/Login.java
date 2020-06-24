package com.example.cef440;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class Login extends AppCompatActivity {
    EditText username, password;
    Button btnLogin;
    TextView gotopassword, btn_signup;
    ProgressDialog pDialog;
    String fcm_id;
    SharedPreferences sharedPreferences;

    RequestParams requestParams;
    AsyncHttpClient asyncHttpClient;
    String url = "http://172.20.10.14:8080/CEF440/LoginServlet";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        if(!isConnected(Login.this))
            buildDialog(Login.this).show();
        else {
            setContentView(R.layout.activity_login);
        }

        sharedPreferences = getSharedPreferences("UserInfo", Context.MODE_PRIVATE);

        FirebaseInstanceId.getInstance().getInstanceId().addOnSuccessListener(Login.this, new OnSuccessListener<InstanceIdResult>() {
            @Override
            public void onSuccess(InstanceIdResult instanceIdResult) {
                String deviceToken = instanceIdResult.getToken();
                //Store it in shared preference
                sharedPreferences = getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(getResources().getString(R.string.preftoken), deviceToken);
                editor.apply();
            }
        });

        //Get form data
        username = findViewById(R.id.inputEmail);
        password = findViewById(R.id.inputPassword);
        btnLogin = findViewById(R.id.btnLogin);
        gotopassword = findViewById(R.id.forgotPassword);
        btn_signup = findViewById(R.id.gotoRegister);


        String loginStatus = sharedPreferences.getString(getResources().getString(R.string.prefLoginState), "");
        String loginUserStatus = sharedPreferences.getString(getResources().getString(R.string.prefLoginUserStatus), "");
        fcm_id = sharedPreferences.getString(getResources().getString(R.string.preftoken), "");
        if (loginStatus.equals("loggedin")){
            if (loginUserStatus.equals("Person")) {
                startActivity(new Intent(Login.this, PersonHome.class));
                finish();
            }else if (loginUserStatus.equals("Agent")) {
                startActivity(new Intent(Login.this, PersonHome.class));
                finish();
            }else if (loginUserStatus.equals("Admin")) {
                startActivity(new Intent(Login.this, PersonHome.class));
                finish();
            }
        }

        //Forgot password button clicked
        gotopassword.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent i = new Intent(getApplicationContext(),
                        ForgotPassword.class);
                startActivity(i);
                finish();
            }
        });

        //Sign up button clicked
        btn_signup.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent i = new Intent(getApplicationContext(),
                        SignUp.class);
                startActivity(i);
                finish();
            }
        });

        //Login button clicked
        btnLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){

                pDialog = new ProgressDialog(Login.this);
                pDialog.setCancelable(false);
                pDialog.setIndeterminate(false);
                pDialog.setMessage("Authenticating user...");
                pDialog.show();

                //Convert input to string
                String txtUserName = username.getText().toString();
                String txtPassword = password.getText().toString();

                //Check for empty fields
                if (TextUtils.isEmpty(txtUserName) || TextUtils.isEmpty(txtPassword) ){
                    pDialog.dismiss();
                    Toast.makeText(Login.this, "All fields are required", Toast.LENGTH_LONG).show();
                }
                else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(txtUserName).matches()){
                    pDialog.dismiss();
                    Toast.makeText(Login.this, "Please enter a valid email", Toast.LENGTH_LONG).show();
                }
                else{
                    requestParams = new RequestParams();
                    requestParams.put("name", txtUserName);
                    requestParams.put("token", fcm_id);
                    requestParams.put("password", txtPassword);

                    asyncHttpClient = new AsyncHttpClient();
                    asyncHttpClient.post(url, requestParams, new JsonHttpResponseHandler(){
                        @Override
                        public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                            super.onSuccess(statusCode, headers, response);

                            try {
                                String status = response.getString("status");
                                if (status.equals("SUCCESS")) {
                                    // User successfully authenticated
                                    pDialog.dismiss();
                                    String id0 = response.getString("id");
                                    String name0 = response.getString("name");
                                    String email0 = response.getString("email");
                                    String status0 = response.getString("role");

                                    SharedPreferences.Editor editor = sharedPreferences.edit();
                                    editor.putString(getResources().getString(R.string.prefLoginState), "loggedin");
                                    editor.putString(getResources().getString(R.string.prefLoginUserID), id0);
                                    editor.putString(getResources().getString(R.string.prefLoginUserName), name0);
                                    editor.putString(getResources().getString(R.string.prefLoginUserEmail), email0);
                                    editor.putString(getResources().getString(R.string.prefLoginUserStatus), status0);
                                    editor.apply();

                                    Toast.makeText(Login.this, "Login Successfully", Toast.LENGTH_SHORT).show();

                                    if (status0.equals("Person")) {
                                        startActivity(new Intent(Login.this, PersonHome.class));
                                        finish();
                                    }else if (status0.equals("Agent")) {
                                        startActivity(new Intent(Login.this, PersonHome.class));
                                        finish();
                                    }else if (status0.equals("Admin")) {
                                        startActivity(new Intent(Login.this, PersonHome.class));
                                        finish();
                                    }

                                } else {
                                    // Error occurred in login. Get the error message
                                    pDialog.dismiss();
                                    Toast.makeText(getApplicationContext(), "Incorrect username or password, please try again later", Toast.LENGTH_LONG).show();
                                }

                            } catch (JSONException e) {
                                pDialog.dismiss();
                                AlertBox.buildDialog(Login.this).show();
                            }

                            Toast.makeText(Login.this, "Login successful", Toast.LENGTH_SHORT).show();

                            username.getText().clear();
                            password.getText().clear();
                        }

                        @Override
                        public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                            pDialog.dismiss();
                            super.onFailure(statusCode, headers, responseString, throwable);
                            Toast.makeText(Login.this, "Incorrect username or password, please try again later", Toast.LENGTH_LONG).show();
                        }
                    });
                    //login(txtUserName, txtPassword, fcm_id);
                }
            }
        });

    }

    public boolean isConnected(Context context) {

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netinfo = cm.getActiveNetworkInfo();

        if (netinfo != null && netinfo.isConnectedOrConnecting()) {
            android.net.NetworkInfo wifi = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            android.net.NetworkInfo mobile = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

            if((mobile != null && mobile.isConnectedOrConnecting()) || (wifi != null && wifi.isConnectedOrConnecting())) {
                return true;
            }
            else {
                return false;
            }
        } else {
            return false;
        }
    }

    public AlertDialog.Builder buildDialog(Context c) {

        AlertDialog.Builder builder = new AlertDialog.Builder(c);
        builder.setTitle("No Internet Connection");
        builder.setMessage("You need to have mobile data or wifi to access this. Please check your internet connection and try again.");

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                finish();
            }
        });

        return builder;
    }

}

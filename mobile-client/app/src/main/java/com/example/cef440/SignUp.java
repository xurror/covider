package com.example.cef440;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;


public class SignUp extends AppCompatActivity {
    EditText username, email, password, password2;
    String fcm_id;
    Button btnRegister;
    TextView gotologin;
    ProgressDialog pDialog;

    RequestParams requestParams;
    AsyncHttpClient asyncHttpClient;
    String url = "http://172.20.10.14:8080/CEF440/RegisterServlet";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //Get data from form
        username = findViewById(R.id.inputUsername);
        email = findViewById(R.id.inputEmail);
        password = findViewById(R.id.inputPassword);
        password2 = findViewById(R.id.inputPassword2);
        btnRegister = findViewById(R.id.btnRegister);
        gotologin = findViewById(R.id.gotoLogin);


        //Already have an account button clicked
        gotologin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent i = new Intent(getApplicationContext(),
                        Login.class);
                startActivity(i);
                finish();
            }
        });

        //Register button clicked
        btnRegister.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){

                pDialog = new ProgressDialog(SignUp.this);
                pDialog.setCancelable(false);
                pDialog.setIndeterminate(false);
                pDialog.setMessage("Registering new user...");
                pDialog.show();

                //Convert input to string
                String txtUserName = username.getText().toString();
                String txtEmail = email.getText().toString();
                String txtPassword = password.getText().toString();
                String txtPassword2 = password2.getText().toString();

                //Check for empty fields
                if (TextUtils.isEmpty(txtUserName) || TextUtils.isEmpty(txtEmail) || TextUtils.isEmpty(txtPassword) ||TextUtils.isEmpty(txtPassword2) ){
                    pDialog.dismiss();
                    Toast.makeText(SignUp.this, "All fields are required", Toast.LENGTH_LONG).show();
                }
                else if (!txtPassword.equals(txtPassword2)){
                    pDialog.dismiss();
                    Toast.makeText(SignUp.this, "Passwords do not match", Toast.LENGTH_LONG).show();
                }
                else if (txtUserName.length() < 6){
                    pDialog.dismiss();
                    Toast.makeText(SignUp.this, "Username must be of at least six (06) characters", Toast.LENGTH_LONG).show();
                }
                else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(txtEmail).matches()){
                    pDialog.dismiss();
                    Toast.makeText(SignUp.this, "Please enter a valid email", Toast.LENGTH_LONG).show();
                }
                else if (txtPassword.length() < 6 || txtPassword2.length() < 6){
                    pDialog.dismiss();
                    Toast.makeText(SignUp.this, "Password must be of at least six (06) characters", Toast.LENGTH_LONG).show();
                }
                else if (!txtPassword.equals(txtPassword2)){
                    pDialog.dismiss();
                    Toast.makeText(SignUp.this, "Passwords do not match", Toast.LENGTH_LONG).show();
                }
                else{
                    requestParams = new RequestParams();
                    requestParams.put("name", txtUserName);
                    requestParams.put("email", txtEmail);
                    requestParams.put("password", txtPassword);

                    asyncHttpClient = new AsyncHttpClient();
                    asyncHttpClient.post(url, requestParams, new JsonHttpResponseHandler(){
                        @Override
                        public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                            pDialog.dismiss();
                            super.onSuccess(statusCode, headers, response);
                            Toast.makeText(SignUp.this, "Account successfully created, login to continue", Toast.LENGTH_LONG).show();

                            username.getText().clear();
                            email.getText().clear();
                            password.getText().clear();
                            password2.getText().clear();

                            startActivity(new Intent(SignUp.this, Login.class));
                            finish();
                        }

                        @Override
                        public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                            pDialog.dismiss();
                            super.onFailure(statusCode, headers, responseString, throwable);
                            Toast.makeText(SignUp.this, "There was an error creating your account, please try again later", Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }
       });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(SignUp.this, Login.class));
        finish();
    }
}

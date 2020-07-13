package cm.ubuea.covider;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.entity.StringEntity;

public class SignUp extends AppCompatActivity {
    EditText name, idNumber, email, password, password2;
    String fcm_id;
    Button btnRegister;
    TextView gotologin;
    ProgressDialog pDialog;

    RequestParams requestParams;
    AsyncHttpClient asyncHttpClient;
    String url = "https://covider.herokuapp.com/api/register";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //Get data from form
        name = findViewById(R.id.inputName);
        idNumber = findViewById(R.id.inputIdNumber);
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
                String txtName = name.getText().toString();
                String txtIdNumber = idNumber.getText().toString();
                String txtEmail = email.getText().toString();
                String txtPassword = password.getText().toString();
                String txtPassword2 = password2.getText().toString();

                //Check for empty fields
                if (TextUtils.isEmpty(txtName) || TextUtils.isEmpty(txtEmail) || TextUtils.isEmpty(txtPassword) ||TextUtils.isEmpty(txtPassword2) ){
                    pDialog.dismiss();
                    Toast.makeText(SignUp.this, "All fields are required", Toast.LENGTH_LONG).show();
                }
                else if (!txtPassword.equals(txtPassword2)){
                    pDialog.dismiss();
                    Toast.makeText(SignUp.this, "Passwords do not match", Toast.LENGTH_LONG).show();
                }
                else if (txtName.length() < 6){
                    pDialog.dismiss();
                    Toast.makeText(SignUp.this, "Please enter your full names", Toast.LENGTH_LONG).show();
                }
                else if (txtIdNumber.length() < 6){
                    pDialog.dismiss();
                    Toast.makeText(SignUp.this, "Please enter a valid NIC number", Toast.LENGTH_LONG).show();
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
                    try {
                        JSONObject requestParams = new JSONObject();
                        requestParams.put("name", txtName);
                        requestParams.put("idNumber", txtIdNumber);
                        requestParams.put("email", txtEmail);
                        requestParams.put("password", txtPassword);

                        StringEntity entity = new StringEntity(requestParams.toString());

                        asyncHttpClient = new AsyncHttpClient();
                        asyncHttpClient.addHeader("Accept", "application/json");
                        asyncHttpClient.addHeader("Content-Type", "application/json");
                        asyncHttpClient.post(getApplicationContext(), url, entity, "application/json", new JsonHttpResponseHandler() {
                            @Override
                            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                                pDialog.dismiss();
                                super.onSuccess(statusCode, headers, response);
                                Toast.makeText(SignUp.this, "Account successfully created, login to continue", Toast.LENGTH_LONG).show();

                                name.getText().clear();
                                idNumber.getText().clear();
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
                    } catch (JSONException | UnsupportedEncodingException e) {
                        Log.i("ERROR", e.getLocalizedMessage());
                    }
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

package cm.ubuea.covider;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;

import cz.msebera.android.httpclient.Header;


public class PersonPersonalInformation extends Fragment {

    TextInputLayout textInputLayout, textInputLayout1, textInputLayout2, textInputLayout3, textInputLayout4, textInputLayout5;
    AutoCompleteTextView autoCompleteTextView;
    TextInputEditText textInputEditText, textInputEditText1, textInputEditText2, textInputEditText3, textInputEditText4;
    ExtendedFloatingActionButton extendedFloatingActionButton;

    DatePickerDialog datePickerDialog;
    SharedPreferences sharedPreferences;

    String uid, name, idCardNumber, sex, dob, telephone, email;

    ProgressDialog pDialog;

    RequestParams requestParams, requestParams1;
    AsyncHttpClient asyncHttpClient, asyncHttpClient1;
    String url = "https://covider.herokuapp.com/api/users";
    String url1 = "http://172.20.10.4:8080/CEF440/GetPersonalInformationServlet";

    public PersonPersonalInformation() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_person_personal_information, container, false);

        sharedPreferences = this.getActivity().getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
        uid = sharedPreferences.getString(getResources().getString(R.string.prefLoginUserID), "");
        String loginUserEmail = sharedPreferences.getString(getResources().getString(R.string.prefLoginUserEmail), "");

        textInputLayout = view.findViewById(R.id.textInputLayout);
        textInputLayout1 = view.findViewById(R.id.textInputLayout1);
        textInputLayout2 = view.findViewById(R.id.textInputLayout2);
        textInputLayout3 = view.findViewById(R.id.textInputLayout3);
        textInputLayout4 = view.findViewById(R.id.textInputLayout4);
        textInputLayout5 = view.findViewById(R.id.textInputLayout5);

        autoCompleteTextView = view.findViewById(R.id.autoCompleteTextView);
        textInputEditText = view.findViewById(R.id.textInputEditText);
        textInputEditText1 = view.findViewById(R.id.textInputEditText1);
        textInputEditText2 = view.findViewById(R.id.textInputEditText2);
        textInputEditText3 = view.findViewById(R.id.textInputEditText3);
        textInputEditText4 = view.findViewById(R.id.textInputEditText4);

        extendedFloatingActionButton = view.findViewById(R.id.extendedFloatingActionButton);

        //Get personal information
        getPersonalInformation(uid);

        textInputEditText4.setText(loginUserEmail);

        //Populate sex dropdown
        String[] items = new String[] {"M", "F"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.dropdown_item, items);

        autoCompleteTextView.setAdapter(adapter);

        //Handle date of birth clicked
        textInputEditText2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                final int year0 = calendar.get(Calendar.YEAR);
                final int month0 = calendar.get(Calendar.MONTH);
                final int day0 = calendar.get(Calendar.DAY_OF_MONTH);
                datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        textInputEditText2.setText(year+"-"+(month+1)+"-"+dayOfMonth);
                    }
                }, year0, month0, day0);
                datePickerDialog.show();
            }
        });

        textInputEditText2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    Calendar calendar = Calendar.getInstance();
                    final int year0 = calendar.get(Calendar.YEAR);
                    final int month0 = calendar.get(Calendar.MONTH);
                    final int day0 = calendar.get(Calendar.DAY_OF_MONTH);
                    datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                            textInputEditText2.setText(year+"-"+(month+1)+"-"+dayOfMonth);
                        }
                    }, year0, month0, day0);
                    datePickerDialog.show();
                }
            }
        });

        extendedFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pDialog = new ProgressDialog(getContext());
                pDialog.setCancelable(false);
                pDialog.setIndeterminate(false);
                pDialog.setMessage("Saving personal information...");
                pDialog.show();

                //Get form data
                name = textInputEditText.getText().toString();
                idCardNumber = textInputEditText1.getText().toString();
                sex = autoCompleteTextView.getEditableText().toString();
                dob = textInputEditText2.getText().toString();
                telephone = textInputEditText3.getText().toString();
                email = textInputEditText4.getText().toString();


                //Validate form
                if (validateName(name) && validateSex(sex) && validateDOB(dob) && validateTelephone(telephone) && validateEmail(email) ) {
                    requestParams = new RequestParams();
                    requestParams.put("uid", uid);
                    requestParams.put("name", name);
                    requestParams.put("idCardNumber", idCardNumber);
                    requestParams.put("sex", sex);
                    requestParams.put("dob", dob);
                    requestParams.put("telephone", telephone);
                    requestParams.put("email", email);


                    asyncHttpClient = new AsyncHttpClient();
                    asyncHttpClient.post(url, requestParams, new JsonHttpResponseHandler(){
                        @Override
                        public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                            pDialog.dismiss();
                            super.onSuccess(statusCode, headers, response);
                            getPersonalInformation(uid);
                            Toast.makeText(getContext(), "Successfully saved your personal information details", Toast.LENGTH_LONG).show();
                        }

                        @Override
                        public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                            pDialog.dismiss();
                            super.onFailure(statusCode, headers, responseString, throwable);
                            Toast.makeText(getContext(), "There was an error saving your personal information, please try again later", Toast.LENGTH_LONG).show();
                        }
                    });
                }else{
                    pDialog.dismiss();
                }


            }
        });

        // Inflate the layout for this fragment
        return view;
    }

    private void getPersonalInformation(String uid) {

        requestParams1 = new RequestParams();
        requestParams1.put("uid", uid);

        asyncHttpClient1 = new AsyncHttpClient();
        asyncHttpClient1.post(url1, requestParams1, new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {

                try {
                    String status = response.getString("status");
                    if (status.equals("SUCCESS")) {
                        // Data successfully retrieved
                        String id0 = response.getString("id");
                        String uid0 = response.getString("uid");
                        String name0 = response.getString("name");
                        String idCardNumber0 = response.getString("idCardNumber");
                        String sex0 = response.getString("sex");
                        String dob0 = response.getString("dob");
                        String telephone0 = response.getString("telephone");
                        String email0 = response.getString("email");

                        autoCompleteTextView.setText(sex0);
                        textInputEditText.setText(name0);
                        textInputEditText1.setText(idCardNumber0);
                        textInputEditText2.setText(dob0);
                        textInputEditText3.setText(telephone0);
                        textInputEditText4.setText(email0);

                    }

                } catch (JSONException e) {
                    AlertBox.buildDialog(getContext()).show();
                }

                super.onSuccess(statusCode, headers, response);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                super.onFailure(statusCode, headers, responseString, throwable);
                Toast.makeText(getContext(), "There was an error retrieving your personal information", Toast.LENGTH_LONG).show();
            }
        });
    }

    private boolean validateTelephone(String telephone) {
        boolean valid = false;
        if (TextUtils.isEmpty(telephone)){
            valid = false;
            textInputLayout4.setError("Telephone is required");
        }else if (telephone.length() != 9){
            valid = false;
            textInputLayout4.setError("Telephone must be exactly 9 digits");
        }else{
            valid = true;
            textInputLayout4.setError(null);
        }

        return valid;
    }

    private boolean validateEmail(String email) {
        boolean valid = false;
        if (TextUtils.isEmpty(email)){
            valid = false;
            textInputLayout5.setError("Email is required");
        }else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            valid = false;
            textInputLayout5.setError("Please enter a valid email address");
        }else{
            valid = true;
            textInputLayout5.setError(null);
        }

        return valid;
    }

    private boolean validateDOB(String dob) {
        boolean valid = false;
        if (TextUtils.isEmpty(dob)){
            valid = false;
            textInputLayout3.setError("Date of birth is required");
        }else{
            valid = true;
            textInputLayout3.setError(null);
        }

        return valid;
    }

    private boolean validateSex(String sex) {
        boolean valid = false;
        if (TextUtils.isEmpty(sex)){
            valid = false;
            textInputLayout2.setError("Sex is required");
        }else{
            valid = true;
            textInputLayout2.setError(null);
        }

        return valid;
    }

    private boolean validateName(String name) {
        boolean valid = false;
        if (TextUtils.isEmpty(name)){
            valid = false;
            textInputLayout.setError("Full Names is required");
        }else if (name.length() < 10){
            valid = false;
            textInputLayout.setError("Full Names must be of at least 10 characters");
        }else{
            valid = true;
            textInputLayout.setError(null);
        }

        return valid;
    }
}
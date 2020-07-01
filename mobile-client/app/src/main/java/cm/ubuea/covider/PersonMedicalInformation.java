package cm.ubuea.covider;

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
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.google.android.material.textfield.TextInputLayout;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class PersonMedicalInformation extends Fragment {

    TextInputLayout textInputLayout, textInputLayout1;
    AutoCompleteTextView autoCompleteTextView, autoCompleteTextView1;
    SwitchMaterial switchMaterial, switchMaterial1, switchMaterial2, switchMaterial3, switchMaterial4;
    ExtendedFloatingActionButton extendedFloatingActionButton;

    SharedPreferences sharedPreferences;

    String uid, pid, status, test;
    int status0 = 0, test0 = 0, cough = 0, temperature = 0, fever = 0, tiredness = 0, breathing = 0;

    ProgressDialog pDialog;

    RequestParams requestParams, requestParams1, requestParams2;
    AsyncHttpClient asyncHttpClient, asyncHttpClient1, asyncHttpClient2;
    String url = "http://172.20.10.14:8080/CEF440/MedicalInformationServlet";
    String url1 = "http://172.20.10.14:8080/CEF440/GetMedicalInformationServlet";
    String url2 = "http://172.20.10.14:8080/CEF440/GetUserPersonIDServlet";

    public PersonMedicalInformation() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_person_medical_information, container, false);


        sharedPreferences = this.getActivity().getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
        uid = sharedPreferences.getString(getResources().getString(R.string.prefLoginUserID), "");
        String loginUserName = sharedPreferences.getString(getResources().getString(R.string.prefLoginUserName), "");
        String loginUserEmail = sharedPreferences.getString(getResources().getString(R.string.prefLoginUserEmail), "");

        textInputLayout = view.findViewById(R.id.textInputLayout);
        textInputLayout1 = view.findViewById(R.id.textInputLayout1);

        autoCompleteTextView = view.findViewById(R.id.autoCompleteTextView);
        autoCompleteTextView1 = view.findViewById(R.id.autoCompleteTextView1);

        switchMaterial = view.findViewById(R.id.switchMaterial);
        switchMaterial1 = view.findViewById(R.id.switchMaterial1);
        switchMaterial2 = view.findViewById(R.id.switchMaterial2);
        switchMaterial3 = view.findViewById(R.id.switchMaterial3);
        switchMaterial4 = view.findViewById(R.id.switchMaterial4);

        extendedFloatingActionButton = view.findViewById(R.id.extendedFloatingActionButton);


        //Populate covid status dropdown
        String[] items = new String[] {"Positive", "Negative"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.dropdown_item, items);
        autoCompleteTextView.setAdapter(adapter);

        //Populate covid test dropdown
        String[] items1 = new String[] {"Yes", "No"};
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getActivity(), R.layout.dropdown_item, items1);
        autoCompleteTextView1.setAdapter(adapter1);

        //Get user person id
        getUserPersonID(uid);

        //Handle switch boxes
        switchMaterial.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    cough = 1;
                }else{
                    cough = 0;
                }
            }
        });

        switchMaterial1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    temperature = 1;
                }else{
                    temperature = 0;
                }
            }
        });

        switchMaterial2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    fever = 1;
                }else{
                    fever = 0;
                }
            }
        });

        switchMaterial3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    tiredness = 1;
                }else{
                    tiredness = 0;
                }
            }
        });

        switchMaterial4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    breathing = 1;
                }else{
                    breathing = 0;
                }
            }
        });

        extendedFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pDialog = new ProgressDialog(getContext());
                pDialog.setCancelable(false);
                pDialog.setIndeterminate(false);
                pDialog.setMessage("Saving medical information...");
                pDialog.show();

                //Get form data
                status = autoCompleteTextView.getEditableText().toString();
                test = autoCompleteTextView1.getEditableText().toString();

                if (status.equals("Positive")){
                    status0 = 1;
                }else{
                    status0 = 0;
                }

                if (test.equals("Yes")){
                    test0 = 1;
                }else{
                    test0 = 0;
                }


                //Validate form
                if (validateStatus(status) && validateTest(test) ) {
                    requestParams = new RequestParams();
                    requestParams.put("pid", pid);
                    requestParams.put("status", status0);
                    requestParams.put("test", test0);
                    requestParams.put("cough", cough);
                    requestParams.put("temperature", temperature);
                    requestParams.put("fever", fever);
                    requestParams.put("tiredness", tiredness);
                    requestParams.put("breathing", breathing);


                    asyncHttpClient = new AsyncHttpClient();
                    asyncHttpClient.post(url, requestParams, new JsonHttpResponseHandler(){
                        @Override
                        public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                            pDialog.dismiss();
                            super.onSuccess(statusCode, headers, response);
                            getUserPersonID(uid);
                            Toast.makeText(getContext(), "Successfully saved your medical information details", Toast.LENGTH_LONG).show();
                        }

                        @Override
                        public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                            pDialog.dismiss();
                            super.onFailure(statusCode, headers, responseString, throwable);
                            Toast.makeText(getContext(), "There was an error saving your medical information, please try again later", Toast.LENGTH_LONG).show();
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

    private void getMedicalInformation(String pid) {

        requestParams1 = new RequestParams();
        requestParams1.put("pid", pid);

        asyncHttpClient1 = new AsyncHttpClient();
        asyncHttpClient1.post(url1, requestParams1, new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {

                try {
                    String status = response.getString("status");
                    if (status.equals("SUCCESS")) {
                        // Data successfully retrieved
                        String id0 = response.getString("id");
                        String pid0 = response.getString("pid");
                        String status00 = response.getString("check");
                        String test00 = response.getString("test");
                        String cough00 = response.getString("cough");
                        String temperature00 = response.getString("temperature");
                        String fever00 = response.getString("fever");
                        String tiredness00 = response.getString("tiredness");
                        String breathing00 = response.getString("breathing");


                        if (status00.equals("1")){
                            autoCompleteTextView.setText("Positive");
                        }else{
                            autoCompleteTextView.setText("Negative");
                        }

                        if (test00.equals("1")){
                            autoCompleteTextView1.setText("Yes");
                        }else{
                            autoCompleteTextView1.setText("No");
                        }

                        if (cough00.equals("1")){
                            switchMaterial.setChecked(true);
                        }else{
                            switchMaterial.setChecked(false);
                        }

                        if (temperature00.equals("1")){
                            switchMaterial1.setChecked(true);
                        }else{
                            switchMaterial1.setChecked(false);
                        }

                        if (fever00.equals("1")){
                            switchMaterial2.setChecked(true);
                        }else{
                            switchMaterial2.setChecked(false);
                        }

                        if (tiredness00.equals("1")){
                            switchMaterial3.setChecked(true);
                        }else{
                            switchMaterial3.setChecked(false);
                        }

                        if (breathing00.equals("1")){
                            switchMaterial4.setChecked(true);
                        }else{
                            switchMaterial4.setChecked(false);
                        }


                    }

                } catch (JSONException e) {
                    AlertBox.buildDialog(getContext()).show();
                }

                super.onSuccess(statusCode, headers, response);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                super.onFailure(statusCode, headers, responseString, throwable);
                Toast.makeText(getContext(), "There was an error retrieving your medical information", Toast.LENGTH_LONG).show();
            }
        });
    }

    private boolean validateStatus(String status) {
        boolean valid = false;
        if (TextUtils.isEmpty(status)){
            valid = false;
            textInputLayout.setError("Status is required");
        }else{
            valid = true;
            textInputLayout.setError(null);
        }

        return valid;
    }

    private boolean validateTest(String test) {
        boolean valid = false;
        if (TextUtils.isEmpty(test)){
            valid = false;
            textInputLayout1.setError("Test is required");
        }else{
            valid = true;
            textInputLayout1.setError(null);
        }

        return valid;
    }

    private void getUserPersonID(String uid) {

        requestParams2 = new RequestParams();
        requestParams2.put("uid", uid);

        asyncHttpClient2 = new AsyncHttpClient();
        asyncHttpClient2.post(url2, requestParams2, new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {

                try {
                    String status = response.getString("status");
                    if (status.equals("SUCCESS")) {
                        // Data successfully retrieved
                        String pid0 = response.getString("id");

                        pid = pid0;

                        //Get medical information
                        getMedicalInformation(pid);

                    }

                } catch (JSONException e) {
                    AlertBox.buildDialog(getContext()).show();
                }

                super.onSuccess(statusCode, headers, response);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                super.onFailure(statusCode, headers, responseString, throwable);
                Toast.makeText(getContext(), "There was an error retrieving your medical information", Toast.LENGTH_LONG).show();
            }
        });
    }
}
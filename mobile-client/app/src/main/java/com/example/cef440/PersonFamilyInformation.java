package com.example.cef440;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class PersonFamilyInformation extends Fragment {

    TextInputLayout textInputLayout, textInputLayout1, textInputLayout2, textInputLayout3;
    TextInputEditText textInputEditText, textInputEditText1, textInputEditText2, textInputEditText3;
    ExtendedFloatingActionButton extendedFloatingActionButton;

    DatePickerDialog datePickerDialog;
    SharedPreferences sharedPreferences;

    String uid, pid, familyName, numberOfMembers, familyHead, familyAddress;

    ProgressDialog pDialog, pDialog1;

    RequestParams requestParams, requestParams1, requestParams2;
    AsyncHttpClient asyncHttpClient, asyncHttpClient1, asyncHttpClient2;
    String url = "http://192.168.1.103:8080/CEF440/FamilyInformationServlet";
    String url1 = "http://192.168.1.103:8080/CEF440/GetFamilyInformationServlet";
    String url2 = "http://192.168.1.103:8080/CEF440/GetUserPersonIDServlet";

    public PersonFamilyInformation() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_person_family_information, container, false);


        sharedPreferences = this.getActivity().getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
        uid = sharedPreferences.getString(getResources().getString(R.string.prefLoginUserID), "");
        String loginUserName = sharedPreferences.getString(getResources().getString(R.string.prefLoginUserName), "");
        String loginUserEmail = sharedPreferences.getString(getResources().getString(R.string.prefLoginUserEmail), "");

        textInputLayout = view.findViewById(R.id.textInputLayout);
        textInputLayout1 = view.findViewById(R.id.textInputLayout1);
        textInputLayout2 = view.findViewById(R.id.textInputLayout2);
        textInputLayout3 = view.findViewById(R.id.textInputLayout3);

        textInputEditText = view.findViewById(R.id.textInputEditText);
        textInputEditText1 = view.findViewById(R.id.textInputEditText1);
        textInputEditText2 = view.findViewById(R.id.textInputEditText2);
        textInputEditText3 = view.findViewById(R.id.textInputEditText3);

        extendedFloatingActionButton = view.findViewById(R.id.extendedFloatingActionButton);

        //Get user person id
        getUserPersonID(uid);


        extendedFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pDialog = new ProgressDialog(getContext());
                pDialog.setCancelable(false);
                pDialog.setIndeterminate(false);
                pDialog.setMessage("Saving family information...");
                pDialog.show();

                //Get form data
                familyName = textInputEditText.getText().toString();
                numberOfMembers = textInputEditText1.getText().toString();
                familyHead = textInputEditText2.getText().toString();
                familyAddress = textInputEditText3.getText().toString();


                //Validate form
                if (validateFamilyName(familyName) && validateNumberOfMembers(numberOfMembers) && validateFamilyHead(familyHead) && validateFamilyAddress(familyAddress) ) {
                    requestParams = new RequestParams();
                    requestParams.put("pid", pid);
                    requestParams.put("familyName", familyName);
                    requestParams.put("numberOfMembers", numberOfMembers);
                    requestParams.put("familyHead", familyHead);
                    requestParams.put("familyAddress", familyAddress);


                    asyncHttpClient = new AsyncHttpClient();
                    asyncHttpClient.post(url, requestParams, new JsonHttpResponseHandler(){
                        @Override
                        public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                            pDialog.dismiss();
                            getUserPersonID(uid);
                            super.onSuccess(statusCode, headers, response);
                            Toast.makeText(getContext(), "Successfully saved your family information details", Toast.LENGTH_LONG).show();
                        }

                        @Override
                        public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                            pDialog.dismiss();
                            super.onFailure(statusCode, headers, responseString, throwable);
                            Toast.makeText(getContext(), "There was an error saving your family information, please try again later", Toast.LENGTH_LONG).show();
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

    private void getFamilyInformation(String pid) {
        pDialog1 = new ProgressDialog(getContext());
        pDialog1.setCancelable(false);
        pDialog1.setIndeterminate(false);
        pDialog1.setMessage("Retrieving information...");
        pDialog1.show();

        requestParams1 = new RequestParams();
        requestParams1.put("pid", pid);

        asyncHttpClient1 = new AsyncHttpClient();
        asyncHttpClient1.post(url1, requestParams1, new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                pDialog1.dismiss();

                try {
                    String status = response.getString("status");
                    if (status.equals("SUCCESS")) {
                        // Data successfully retrieved
                        String id0 = response.getString("id");
                        String pid0 = response.getString("pid");
                        String familyName = response.getString("familyName");
                        String numberOfMembers = response.getString("numberOfMembers");
                        String familyHead = response.getString("familyHead");
                        String familyAddress = response.getString("familyAddress");

                        textInputEditText.setText(familyName);
                        textInputEditText1.setText(numberOfMembers);
                        textInputEditText2.setText(familyHead);
                        textInputEditText3.setText(familyAddress);

                    }

                } catch (JSONException e) {
                    AlertBox.buildDialog(getContext()).show();
                }

                super.onSuccess(statusCode, headers, response);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                pDialog1.dismiss();
                super.onFailure(statusCode, headers, responseString, throwable);
                Toast.makeText(getContext(), "There was an error retrieving your family information", Toast.LENGTH_LONG).show();
            }
        });
    }

    private boolean validateFamilyAddress(String familyAddress) {
        boolean valid = false;
        if (TextUtils.isEmpty(familyAddress)){
            valid = false;
            textInputLayout3.setError("Family residence is required");
        }else{
            valid = true;
            textInputLayout3.setError(null);
        }

        return valid;
    }

    private boolean validateFamilyHead(String familyHead) {
        boolean valid = false;
        if (TextUtils.isEmpty(familyHead)){
            valid = false;
            textInputLayout2.setError("Family head is required");
        }else{
            valid = true;
            textInputLayout2.setError(null);
        }

        return valid;
    }

    private boolean validateNumberOfMembers(String numberOfMembers) {
        boolean valid = false;
        if (TextUtils.isEmpty(numberOfMembers)){
            valid = false;
            textInputLayout1.setError("Telephone is required");
        }else if (numberOfMembers.equals("0")){
            valid = false;
            textInputLayout1.setError("Number of members in family must be different from zero");
        }else{
            valid = true;
            textInputLayout1.setError(null);
        }

        return valid;
    }

    private boolean validateFamilyName(String familyName) {
        boolean valid = false;
        if (TextUtils.isEmpty(familyName)){
            valid = false;
            textInputLayout.setError("Family name is required");
        }else{
            valid = true;
            textInputLayout.setError(null);
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

                        //Get family information
                        getFamilyInformation(pid);

                    }

                } catch (JSONException e) {
                    AlertBox.buildDialog(getContext()).show();
                }

                super.onSuccess(statusCode, headers, response);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                super.onFailure(statusCode, headers, responseString, throwable);
                Toast.makeText(getContext(), "There was an error retrieving your family information", Toast.LENGTH_LONG).show();
            }
        });
    }
}
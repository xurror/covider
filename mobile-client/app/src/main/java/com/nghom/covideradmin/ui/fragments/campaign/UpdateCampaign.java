package com.nghom.covideradmin.ui.fragments.campaign;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.nghom.covideradmin.R;

import cm.ubuea.covider.R;

///**
// * A simple {@link Fragment} subclass.
// * Use the {@link CreateCampaign#newInstance} factory method to
// * create an instance of this fragment.
// */
public class UpdateCampaign extends Fragment {

//    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";

    EditText name, agents, location;
    Button update;



//    // TODO: Rename and change types of parameters


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     //     * @param param1 Parameter 1.
     //     * @param param2 Parameter 2.
     //     * @return A new instance of fragment CreateCampaign.
     //     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_campaign_layout);
        //        take reference of XML data using id
        name = name.findViewById();
        agents = agents.findViewById();
        location = location.findViewById();
        update = update.findViewById();
        final Bundle b = new Bundle();

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //convert object to String
                b.putString("name", name.getText().toString());
                //convert object to String
                b.putString("agents", agents.getText().toString());
                //convert object to String
                b.putString("location", location.getText().toString());
                myDialog myDialog = new myDialog();
                myDialog.setArguments(b);
                myDialog.show((FragmentManager) getSupportFragmentManager(), "my Dialog");
            }
        });
    }

    private Object getSupportFragmentManager() {
    }

    private void setContentView(int update_campaign_layout) {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.update_campaign_layout, container, false);
    }
}
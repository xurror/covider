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
public class CreateCampaign extends Fragment {

//    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";

    EditText name, agents, location;
    Button create;

//    @Override
//    protected void  onCreate(Bundle savedInstanceState)
//    {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.create_campaign_layout);
////        take reference of XML data using id
//        name = findViewById(R.id.name);
//        agents = findViewById(R.id.agents);
//        location = findViewById(R.id.location);
//    }

//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;

//    public CreateCampaign() {
//        // Required empty public constructor
//    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment CreateCampaign.
//     */
    // TODO: Rename and change types and number of parameters
//    public static CreateCampaign newInstance(String param1, String param2) {
//        CreateCampaign fragment = new CreateCampaign();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_campaign_layout);
            //        take reference of XML data using id
            name = name.findViewById();
            agents = agents.findViewById();
            location = location.findViewById();
            create = create.findViewById();
            final Bundle b = new Bundle();

            create.setOnClickListener(new View.OnClickListener() {
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

    private void setContentView(int create_campaign_layout) {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.create_campaign_layout, container, false);
    }
}
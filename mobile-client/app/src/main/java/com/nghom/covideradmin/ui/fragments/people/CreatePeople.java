package com.nghom.covideradmin.ui.fragments.people;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.nghom.covideradmin.data.user.User;

import cm.ubuea.covider.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CreatePeople#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CreatePeople extends Fragment {

    private EditText fullname, username_edittext, enterpass_edittext, email;
    private ImageView pic_imageview;
    private CheckBox maleCheckBox, femaleCheckBox;
    private Button registerButton;
    private String TAG = "CreatePeople";

    private static final String USERS = "users";

    private String Full_Name, UserName, Email;
    private String password;
    private User user;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CreatePeople() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CreatePeople.
     */
    // TODO: Rename and change types and number of parameters
    public static CreatePeople newInstance(String param1, String param2) {
        CreatePeople fragment = new CreatePeople();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_people, container, false);
    }
}
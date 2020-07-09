package com.nghom.covideradmin.ui.fragments.campaign;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.nghom.covideradmin.R;


public class myDialog extends DialogFragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.createcamlayout, null, false);
        TextView myText = view.findViewById(R.id.text1);
        Button ok = view.findViewById(R.id.btnOk);
        Button cancel = view.findViewById(R.id.btnCancel);

        String name = getArguments().getString("name");
        String agents = getArguments().getString("agents");
        String location = getArguments().getString("location");
        StringBuffer stringBuffer = new StringBuffer();

        if(!name.matches("[a-zA-Z]"))
        {
            stringBuffer.append("This name is not valid");
        }
        else if(!agents.matches("[a-zA-Z]"))
        {
            stringBuffer.append("This agent is not valid");
        }
        else if(!location.matches("[a-zA-Z]"))
        {
            stringBuffer.append("This location is not valid");
        }
        else
        {
            stringBuffer.append("Campaign successfuly created");
        }
        myText.setText(stringBuffer);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDialog().dismiss();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDialog().dismiss();
            }
        });

        return view;
    }
}

package com.example.cef440;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class AlertBox {

    public static AlertDialog.Builder buildDialog(Context c) {
        AlertDialog.Builder builder = new AlertDialog.Builder(c);
        builder.setTitle("Oops! We are sorry, let's do this again");
        builder.setMessage("It seems one of the following could be a reason for this error: \n" +
                "\n1. Seems the portal is a bit congested and trafficked. If it persists, please try again at a later time of the day. \n " +
                "\n2. There was no connection to the server. Please check your internet connection and try again. \n" +
                "\n3. Perhaps your network connection is off or not working. Please check your internet connection and try again. \n" +
                "\n\nKeep calm, click the OK button and then try again later \n");

        builder.setPositiveButton("\nOK", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        return builder;
    }
}


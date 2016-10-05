package com.omegapps.twuicetheme.Dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.omegapps.twuicetheme.R;

/**
 * Created by danie on 10/4/2016.
 */

public class SuggestIcon extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View views = inflater.inflate(R.layout.dialog_suggest, null);
        final EditText name = (EditText) views.findViewById(R.id.name);
        final EditText url = (EditText) views.findViewById(R.id.url);
        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(views)
                // Add action buttons
                .setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        final Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);

                        emailIntent.setType("plain/text");
                        emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"info@omegapps.nl"});
                        emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "An icon suggestion.");
                        emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "App name: " + name.getText() + "\nUrl in the Play Store: " + url.getText());
                        getActivity().startActivity(Intent.createChooser(emailIntent, "Send mail..."));
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                });
        return builder.create();
    }

}

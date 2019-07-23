package com.mancj.example.dialog;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

import com.mancj.example.R;

import java.util.Objects;

@SuppressLint("ValidFragment")
public class SingleChoiceDialog extends DialogFragment {

    private String title;
    private int position;
    private String[] list;

    @SuppressLint("ValidFragment")
    public SingleChoiceDialog(String title) {
        this.title = title;
    }

    public interface SingleChoiceListener {
        void onPositiveButtonClicked(String[] list, int position);
        void onNegativeButtonClicked();
    }

    SingleChoiceListener mListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (SingleChoiceListener) context;
        } catch (Exception e) {
            throw new ClassCastException(getActivity().toString() + " SingleChoiceListener must be Implemented");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(Objects.requireNonNull(getActivity()));
        position = 0;
        if (title.equalsIgnoreCase("app_download")) {
            list = getActivity().getResources().getStringArray(R.array.app_download);
            builder.setTitle("App Download Preferences");
        } else if(title.equalsIgnoreCase("app_update")) {
            list = getActivity().getResources().getStringArray(R.array.app_update);
            builder.setTitle("Auto-Updates apps");
        } else if (title.equalsIgnoreCase("sort_menu")){
            list = new String[2];
            list[0] = "Smart Home";
            list[1] = "Smart School";
            builder.setTitle("Sorting by");
        }

        builder.setSingleChoiceItems(list, position, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        position = which;
                    }
                })
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mListener.onPositiveButtonClicked(list, position);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mListener.onNegativeButtonClicked();
                    }
                });

        return builder.create();
    }
}
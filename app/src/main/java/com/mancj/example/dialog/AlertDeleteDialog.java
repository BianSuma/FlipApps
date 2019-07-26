package com.mancj.example.dialog;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;

import com.mancj.example.pojo.Wishlist;

import java.util.Objects;

public class AlertDeleteDialog extends DialogFragment {

    private Wishlist wishlistDelete;

    @SuppressLint("ValidFragment")
    public AlertDeleteDialog(Wishlist delete) {
        wishlistDelete = delete;
    }

    public AlertDeleteDialog() {
    }

    public interface AlertDeleteListener {
        void onPositiveButtonClicked(Wishlist wishlistDelete);
        void onNegativeButtonClicked();
    }

    AlertDeleteListener alertListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            alertListener = (AlertDeleteListener) context;
        } catch (Exception e) {
            throw new ClassCastException(getActivity().toString() + " AlertDeleteListener must be implemented");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(Objects.requireNonNull(getActivity()));
        builder.setTitle("Delete The Wishlist")
                .setMessage("Are you sure want to delete this wishlist?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        alertListener.onPositiveButtonClicked(wishlistDelete);
                        Log.d("Wishlist delete :", wishlistDelete.toString());
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        alertListener.onNegativeButtonClicked();
                    }
                });
        return builder.create();
    }
}

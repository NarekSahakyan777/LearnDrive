package com.example.webdrive;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;


public class BlankFragment extends DialogFragment {
    TextView mTitle, mDescription;
    String mTitleText, mDescriptionText;

    public BlankFragment(String title, String description) {
        mTitleText = title;
        mDescriptionText = description;
    }

    @SuppressLint("MissingInflatedId")
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.fragment_blank, null);

        mTitle = view.findViewById(R.id.textview1);
        mDescription = view.findViewById(R.id.textview2);

        mTitle.setText(mTitleText);
        mDescription.setText(mDescriptionText);


        builder.setView(view);
        AlertDialog dialog = builder.create();

        return dialog;
    }
}
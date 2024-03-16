package com.example.webdrive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SettingsActivity extends AppCompatActivity {
    private FirebaseAuth auth;
    protected Button button;
    public TextView textView;
    private MaterialButton changePasswordButton;
    private MaterialButton deleteAccountButton;
    private FirebaseUser user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_settings);
        button = findViewById(R.id.logout);
        changePasswordButton = findViewById(R.id.changePassword);
        deleteAccountButton = findViewById(R.id.deleteAccount);

//        auth = FirebaseAuth.getInstance();
//        button = findViewById(R.id.logout);
//        user = auth.getCurrentUser();
        changePasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SettingsActivity.this, ChangePasswordActivity.class);
                startActivity(intent);
            }
        });
        deleteAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingsActivity.this, DeleteAccountConfirmationActivity.class);
                startActivity(intent);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(SettingsActivity.this, logIn.class);
                startActivity(intent);
                SettingsActivity.this.finish();

            }
        });

    }
}
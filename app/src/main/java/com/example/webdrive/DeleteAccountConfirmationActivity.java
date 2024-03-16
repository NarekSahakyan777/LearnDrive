package com.example.webdrive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.core.Context;

public class DeleteAccountConfirmationActivity extends AppCompatActivity {
    private MaterialButton yesButton;
    private MaterialButton noButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_account_confirmation);

        yesButton = findViewById(R.id.yesButton);
        noButton = findViewById(R.id.noButton);
        yesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteAccountFromFirebase();
            }

            private void deleteAccountFromFirebase() {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if (user != null) {
                    user.delete()
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        FirebaseAuth.getInstance().signOut();
                                        Intent intent = new Intent(DeleteAccountConfirmationActivity.this, signIn.class);
                                        startActivity(intent);
                                        finish();
                                    } else {
                                        Toast.makeText(DeleteAccountConfirmationActivity.this, "Failed to delete account", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
            }

            private void clearUserDataFromFirebase() {
                DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
                FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
                if (currentUser != null) {
                    String userId = currentUser.getUid();
                    databaseReference.child("users").child(userId).removeValue();
                }
            }
        });
        noButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DeleteAccountConfirmationActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });

    }
    }

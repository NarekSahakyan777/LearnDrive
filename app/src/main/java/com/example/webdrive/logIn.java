package com.example.webdrive;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class logIn extends AppCompatActivity {
    public EditText loginEmail, loginPassword;
    public TextView forgetPassword;
    public Button loginButton,guestMode;
    private FirebaseAuth auth;
    private TextView lognInRedirectText, forgotPasswordText;
    private CheckBox remember;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        ImageButton loginPasswordToggle = findViewById(R.id.login_password_toggle);
        loginEmail = findViewById(R.id.login_email);
        auth = FirebaseAuth.getInstance();
        loginPassword = findViewById(R.id.login_password);
        loginButton = findViewById(R.id.login_button);
        guestMode = findViewById(R.id.guest_mode);
        lognInRedirectText = findViewById(R.id.logInRedirect);
        forgotPasswordText = findViewById(R.id.forgetpassword);
        SharedPreferences sharedPref = getSharedPreferences("loginPrefs", Context.MODE_PRIVATE);
        boolean rememberMe = sharedPref.getBoolean("rememberMe", false);
        guestMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(logIn.this, Profile.class);
                startActivity(in);
            }
        });
        if (rememberMe) {
            String savedEmail = sharedPref.getString("username", "");
            String savedPassword = sharedPref.getString("password", "");

            if (!savedEmail.isEmpty() && !savedPassword.isEmpty()) {
                auth.signInWithEmailAndPassword(savedEmail, savedPassword)
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                if (auth.getCurrentUser().isEmailVerified()) {
                                    Toast.makeText(logIn.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(logIn.this, MainActivity.class));
                                    finish();
                                } else {
                                    Toast.makeText(logIn.this, "Email not verified", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(logIn.this, "Auto Login Failed", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        }

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = loginEmail.getText().toString().trim();
                String pass = loginPassword.getText().toString();

                if (email.isEmpty()) {
                    loginEmail.setError("Email cannot be empty");
                } else if (!Patterns.EMAIL_ADDRESS.matcher(email.toLowerCase()).matches()) {
                    loginEmail.setError("Please enter a valid email");
                } else if (pass.isEmpty()) {
                    loginPassword.setError("Password cannot be empty");
                } else {
                    auth.signInWithEmailAndPassword(email, pass)
                            .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                @Override
                                public void onSuccess(AuthResult authResult) {
                                    if (auth.getCurrentUser().isEmailVerified()) {
                                        Toast.makeText(logIn.this, "Login Successful", Toast.LENGTH_SHORT).show();

                                        startActivity(new Intent(logIn.this, Profile.class));
                                        finish();
                                    } else {
                                        Toast.makeText(logIn.this, "Email not verified", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(logIn.this, "Login Failed", Toast.LENGTH_SHORT).show();
                                }
                            });
                }
            }
        });

        forgotPasswordText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPasswordReset();
            }
        });

        lognInRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(logIn.this, signIn.class));
            }
        });
        loginPasswordToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (loginPassword.getInputType() == InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD) {
                    loginPassword.setInputType(InputType.TYPE_CLASS_TEXT |
                            InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    loginPasswordToggle.setImageResource(R.drawable.ic_seepsw);
                } else {
                    loginPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    loginPasswordToggle.setImageResource(R.drawable.ic_seepsw);
                }
                loginPassword.setSelection(loginPassword.getText().length());
            }
        });
    }

    public void openPasswordReset() {
        Intent intent = new Intent(this, PasswordResetActivity.class);
        startActivity(intent);
    }

    private void saveCredentials(final String email, final String password) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                SharedPreferences sharedPref = getSharedPreferences("loginPrefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("username", email)
                        .putString("password", password)
                        .putBoolean("rememberMe", true)
                        .apply();
                return null;
            }
        }.execute();
    }

}
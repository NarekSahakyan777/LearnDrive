package com.example.webdrive;

    import androidx.annotation.NonNull;
    import androidx.appcompat.app.AppCompatActivity;

    import android.annotation.SuppressLint;
    import android.content.Intent;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.Button;
    import android.widget.EditText;
    import android.widget.TextView;
    import android.widget.Toast;

    import com.google.android.gms.tasks.OnCompleteListener;
    import com.google.android.gms.tasks.Task;
    import com.google.firebase.auth.AuthResult;
    import com.google.firebase.auth.FirebaseAuth;

    public class signIn extends AppCompatActivity {

        private FirebaseAuth auth;
        private EditText signInEmail, signInPassword, confirmPassword;
        private Button signInButton;
        private TextView signInRedirect;

        @SuppressLint("MissingInflatedId")
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_sign_in);

            auth = FirebaseAuth.getInstance();
            signInEmail = findViewById(R.id.signin_email);
            signInPassword = findViewById(R.id.signin_password);
            signInButton = findViewById(R.id.signin_button);
            signInRedirect = findViewById(R.id.signInRedirect);
            confirmPassword = findViewById(R.id.confirm_password);

            signInButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String user = signInEmail.getText().toString().trim();
                    String pass = signInPassword.getText().toString().trim();
                    String confirmpass = confirmPassword.getText().toString().trim();

                    if (user.isEmpty()) {
                        signInEmail.setError("Email cannot be empty");
                    } else if (pass.isEmpty()) {
                        signInPassword.setError("Password cannot be empty");
                    } else if (confirmpass.isEmpty()) {
                        confirmPassword.setError("Please confirm the password");
                    } else if (!confirmpass.equals(pass)) {
                        confirmPassword.setError("Password must match");
                    } else {
                        auth.createUserWithEmailAndPassword(user, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    auth.getCurrentUser().sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if (task.isSuccessful()) {
                                                Toast.makeText(signIn.this, "SignUp Successful", Toast.LENGTH_SHORT).show();

                                                Intent intent = new Intent(signIn.this, EmailVerify.class);
                                                intent.putExtra("Password", pass);
                                                startActivity(intent);
                                                finish();
                                            } else {
                                                Toast.makeText(signIn.this, "Email Verification Failed" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    });
                                } else {
                                    Toast.makeText(signIn.this, "SignUp Failed" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                }
            });

            signInRedirect.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(signIn.this, logIn.class));
                }
            });
        }
    }

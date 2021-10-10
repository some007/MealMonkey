package com.example.mealmonkey;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.jetbrains.annotations.NotNull;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

import java.util.Arrays;

public class MainLogin_Screen extends AppCompatActivity {

    private EditText email, password;
    private Button login, loginButton;
    private TextView forgot, signup;
    private FirebaseAuth mAuth;
    private ProgressBar progressBar;
    private static final String EMAIL = "email";
    private CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login_screen);

        callbackManager = CallbackManager.Factory.create();
        mAuth = FirebaseAuth.getInstance();

        email = findViewById(R.id.ema_edt);
        password = findViewById(R.id.pass_edt);

        login = findViewById(R.id.log_button);
        forgot = findViewById(R.id.forgot_password);
        signup = findViewById(R.id.signup_text);
        loginButton = findViewById(R.id.login_button);
        //loginButton.setReadPermissions(Arrays.asList(EMAIL));

        progressBar = findViewById(R.id.progressBar2);

        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainLogin_Screen.this, ResetPassword.class);
                startActivity(intent);
                finish();
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainLogin_Screen.this, Registration.class);
                startActivity(intent);
                finish();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUserAccount();
            }
        });


    }

    private void loginUserAccount() {
        progressBar.setVisibility(View.VISIBLE);

        String ema, pass;
        ema = email.getText().toString();
        pass = password.getText().toString();

        if (TextUtils.isEmpty(ema)) {
            email.setError("Enter the valid email id");
            return;
        }
        if (TextUtils.isEmpty(pass)) {
            password.setError("Enter the Correct password");
            return;
        }

        mAuth.signInWithEmailAndPassword(ema, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Login Succesfull", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);

                    Intent intent = new Intent(MainLogin_Screen.this, OtpActivity.class);
                    startActivity(intent);
                    finish();

                } else {
                    Toast.makeText(getApplicationContext(), "Login Failed", Toast.LENGTH_SHORT).show();

                    progressBar.setVisibility(View.GONE);
                }

            }
        });


    }
}
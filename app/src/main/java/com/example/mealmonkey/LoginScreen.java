package com.example.mealmonkey;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
public class LoginScreen extends AppCompatActivity
{
    Button login,signup;
    ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        login = findViewById(R.id.login_button);
        signup= findViewById(R.id.create_account);
        back = findViewById(R.id.back_login);


        login.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                onBackPressed();
                Intent intent = new Intent(LoginScreen.this,MainLogin_Screen.class);
                startActivity(intent);
                finish();

            }
        });
        signup.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                onBackPressed();
                Intent intent = new Intent(LoginScreen.this,Registration.class);
                startActivity(intent);
                finish();
            }
        });





    }
}
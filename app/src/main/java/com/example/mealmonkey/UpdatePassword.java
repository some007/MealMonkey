package com.example.mealmonkey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mealmonkey.Activity.MainDashBoard;

public class UpdatePassword extends AppCompatActivity
{
    Button update;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_password);

        update =findViewById(R.id.next_update_pass);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UpdatePassword.this, MainDashBoard.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
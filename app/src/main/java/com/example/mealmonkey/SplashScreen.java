package com.example.mealmonkey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity
{
     ImageView monkey,meal;
     TextView food;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        monkey = findViewById(R.id.monkey);
        meal= findViewById(R.id.meal_monkey);
        food= findViewById(R.id.food);

        monkey.startAnimation(AnimationUtils.loadAnimation(this,R.anim.anim));
        meal.startAnimation(AnimationUtils.loadAnimation(this,R.anim.slide_right));
        food.startAnimation(AnimationUtils.loadAnimation(this,R.anim.slide_right));

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                Intent intent = new Intent(SplashScreen.this,LoginScreen.class);
                startActivity(intent);
                finish();
            }
        },3000);


    }
}
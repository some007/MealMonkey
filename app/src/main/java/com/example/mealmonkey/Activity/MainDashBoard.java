package com.example.mealmonkey.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.mealmonkey.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainDashBoard extends AppCompatActivity
{
    private ViewPager screenpager;
    IntroViewPager introViewPager;
    TabLayout tabindicator;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        List<ScreenItem> mList = new ArrayList<>();
        mList.add(new ScreenItem("Find Food You Love","Discover the best foods from over 1,000 restaurants and fast delivery to your doorstep",R.drawable.food));
        mList.add(new ScreenItem("Fast Delivery","Fast food delivery to your home, office wherever you are",R.drawable.delivery));
        mList.add(new ScreenItem("Live Tracking","Real time tracking of your food on the app once you placed the order",R.drawable.live));




        tabindicator = findViewById(R.id.tab_indicator);
        screenpager = findViewById(R.id.viewPager);
        introViewPager = new IntroViewPager(this,mList);
        screenpager.setAdapter(introViewPager);

        tabindicator.setupWithViewPager(screenpager);







    }
}
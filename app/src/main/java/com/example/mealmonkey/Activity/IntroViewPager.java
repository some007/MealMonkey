package com.example.mealmonkey.Activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.mealmonkey.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class IntroViewPager extends PagerAdapter
{
    Context context;
    List<ScreenItem> mListscreen;

    public IntroViewPager(Context context, List<ScreenItem> mListscreen)
    {
        this.context = context;
        this.mListscreen = mListscreen;
    }

    @NonNull
    @NotNull
    @Override
    public Object instantiateItem(@NonNull @NotNull ViewGroup container, int position)
    {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layoutscreen = inflater.inflate(R.layout.layout_screen,null);

        ImageView imgSlide = layoutscreen.findViewById(R.id.intro_image);
        TextView title = layoutscreen.findViewById(R.id.intro_title);
        TextView description = layoutscreen.findViewById(R.id.intro_description);

        title.setText(mListscreen.get(position).getTitle());
        description.setText(mListscreen.get(position).getDescription());
        imgSlide.setImageResource(mListscreen.get(position).getScreenimg());

        container.addView(layoutscreen);

        return layoutscreen;


    }

    @Override
    public int getCount()
    {
        return mListscreen.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull  View view, @NonNull @NotNull Object object) {

        return view == object ;
    }

    @Override
    public void destroyItem(@NonNull @NotNull ViewGroup container, int position, @NonNull @NotNull Object object)
    {
        container.removeView((View)object);
    }


}

package com.example.mealmonkey.Activity;

public class ScreenItem
{
    String title,description;
    int Screenimg;

    public ScreenItem(String title, String description, int screenimg) {
        this.title = title;
        this.description = description;
        Screenimg = screenimg;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getScreenimg() {
        return Screenimg;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setScreenimg(int screenimg) {
        Screenimg = screenimg;
    }
}

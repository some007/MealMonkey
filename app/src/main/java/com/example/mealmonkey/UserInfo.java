package com.example.mealmonkey;

public class UserInfo
{
    private String username;
    private String useremail;
    private String useraddress;
    private String usermobile;


    public UserInfo() {
    }

    public String getUsername(String username) {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUseremail(String ema) {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getUseraddress(String useraddress) {
        return this.useraddress;
    }

    public void setUseraddress(String useraddress) {
        this.useraddress = useraddress;
    }

    public String getMobile(String usermobile) {
        return this.usermobile;
    }

    public void setMobile(String mobile) {
        this.usermobile = mobile;
    }
}

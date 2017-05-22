package com.risqi17.garbpenjahit;

/**
 * Created by Risqi17 on 17/05/2017.
 */

public class Config {
    //URL to our login.php file
    public static final String IP = "garb.hol.es/API";
    public static final String LOGIN_URL = "http://"+IP+"/penjahitLogin.php";
    public static final String REGISTER_URL = "http://"+IP+"/penjahitRegister.php";
    public static final String LUPA_PASSWORD_URL = "http://"+IP+"/penjahitLupaPassword.php";
    public static final String SARAN_URL = "http://"+IP+"/saran.php";

    //LOGIN
    //Keys for email and password as defined in our $_POST['key'] in login.php
    public static final String KEY_ID = "id";
    public static final String KEY_PASSWORD = "password";

    //If server response is equal to this that means login is successful
    public static final String LOGIN_SUCCESS = "success";

    //Keys for Sharedpreferences
    //This would be the name of our shared preferences
    public static final String SHARED_PREF_NAME = "garbLogin";

    //This would be used to store the email of current logged in user
    public static final String ID_SHARED_PREF = "id";

    //We will use this to store the boolean in sharedpreference to track user is loggedin or not
    public static final String LOGGEDIN_SHARED_PREF = "loggedin";
}

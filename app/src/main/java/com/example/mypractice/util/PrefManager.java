package com.example.mypractice.util;
import android.content.Context;
import android.content.SharedPreferences;



public class PrefManager {

    SharedPreferences sp;
    SharedPreferences.Editor editor;//kind of interface
    Context c;

    private static String USERNAME="user_name";

    public PrefManager(Context c)
    {
        this.c=c;
        sp=c.getSharedPreferences("Pref_name",0);  //user defined ,file name 0 means private mode
        editor=sp.edit();
    }



    public void setUSERNAME(String un)
    {
        editor.putString(USERNAME,un);//USERNAME IS key here
        editor.commit();
    }

    public String getUSERNAME(){

        return sp.getString(USERNAME,""); //key + default value
    }



}

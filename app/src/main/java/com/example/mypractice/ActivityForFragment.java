package com.example.mypractice;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mypractice.fragments.MyFragment;

public class ActivityForFragment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_fragment);


        //adding of fragment in activity
        FragmentManager fm=getFragmentManager();
        MyFragment myFragment=new MyFragment();
        FragmentTransaction fT=fm.beginTransaction(); //no v4 or v7 only app. package
        fT.add(R.id.frame,myFragment);//frag id and built fragment object when second add modify with replace
        fT.commit();




    }
}

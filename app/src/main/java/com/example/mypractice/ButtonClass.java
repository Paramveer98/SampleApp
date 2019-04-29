package com.example.mypractice;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.example.mypractice.sqlitedb.DatabaseHandler;
import com.example.mypractice.sqlitedb.StudentDetails;
import com.example.mypractice.util.PrefManager;
import java.util.ArrayList;
import java.util.List;

public class ButtonClass extends AppCompatActivity {
    Button button2, button3;
    PrefManager prefManager;
    DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);

        db=new DatabaseHandler(ButtonClass.this);

        prefManager=new PrefManager(getApplicationContext());//prefmanager passing context of current apllicateion to shared pref




        button2 = (Button) findViewById(R.id.button2);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            db.addStudentDetails(new StudentDetails(0,"Paramveer","Btech"));//constructor

            }
        });

        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                List <StudentDetails> list= db.getStudentDetails();

                ArrayList<String> arrayList = new ArrayList<>();


                if(list.size()>0){
                    for (StudentDetails sd:list)
                    {
                        Log.e("std id ", ""+sd.getReg_id());
                        Log.e("std name", "std name "+sd.getName());
                        Log.e("std class", "std class "+sd.getStud_class() );


                        arrayList.add(""+sd.getReg_id());


                    }
                }

//                Toast.makeText(getApplicationContext(), prefManager.getUSERNAME(),Toast.LENGTH_SHORT).show();

            }
        });

    }
}

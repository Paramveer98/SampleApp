package com.example.mypractice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


import com.example.mypractice.sqlitedb.DatabaseHandlerList;
import com.example.mypractice.sqlitedb.StudentDetailsList;
import java.util.ArrayList;
import java.util.List;


public class ListViewSample extends AppCompatActivity {
    ListView listView;
    EditText editName, editRoll;
    Button submitbtn,fetchBtn;
    String name, roll;
    ArrayList<String> arrstudname = new ArrayList<>();
    ArrayList<String> arrstudroll = new ArrayList<>();
    ArrayList<Integer> arrstudimage = new ArrayList<>();
    DatabaseHandlerList db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_sample);



        editName = (EditText) findViewById(R.id.editname);
        editRoll = (EditText) findViewById(R.id.editroll);
        submitbtn = (Button) findViewById(R.id.submitBtn);
        fetchBtn= (Button) findViewById(R.id.fetchBtn);

        fetchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                List<StudentDetailsList> list= db.getStudentDetails();

                ArrayList<String> arrayList = new ArrayList<>();
                ArrayList<String> arrayListroll = new ArrayList<>();


                if(list.size()>0){
                    for (StudentDetailsList sd:list)
                    {

                        Log.e("std name", "std name "+sd.getName());
                        Log.e("std roll", "std roll "+sd.getStud_roll() );


//                        arrayList.add(sd.getName());
//                        arrayListroll.add(sd.getStud_roll());

//                        Toast.makeText(getApplicationContext(),arrayList.get(0),Toast.LENGTH_SHORT).show();


                    }
                }


            }
        });

        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                name = editName.getText().toString();
                roll = editRoll.getText().toString();




                arrstudname.add(name);
                arrstudroll.add(roll);
                arrstudimage.add(R.drawable.elon);


                listView = (ListView) findViewById(R.id.studentList);

                DetailsAdapter detailsAdapter = new DetailsAdapter(arrstudname, arrstudroll, arrstudimage);
                listView.setAdapter(detailsAdapter);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Object listItem = listView.getItemAtPosition(position);
                        db.addStudentDetails(new StudentDetailsList(arrstudname.get(position),arrstudroll.get(position)));//constructor
                        Intent intent=new Intent(ListViewSample.this,ListViewSampleProfile.class);

                        intent.putExtra("s_name",arrstudname.get(position));
                        intent.putExtra("s_roll",arrstudroll.get(position));
                        intent.putExtra("s_image",arrstudimage.get(position));
                        intent.putExtra("s_class","B.tech CSE");
                        intent.putExtra("s_address","Banga");
                        startActivity(intent);
                        finish();

                    }
                });


//                submitListBtn = (Button) findViewById(R.id.submitListBtn);
//
//        submitListBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//
//
//            }
//        });


            }
        });


    }

    class DetailsAdapter extends BaseAdapter {
        ArrayList<String> arrstudname = new ArrayList<>();
        ArrayList<String> arrstudroll = new ArrayList<>();
        ArrayList<Integer> arrstudimage = new ArrayList<>();


        public DetailsAdapter(ArrayList<String> arrstudname, ArrayList<String> arrstudroll, ArrayList<Integer> arrstudimage) {

            this.arrstudname = arrstudname;
            this.arrstudroll = arrstudroll;
            this.arrstudimage = arrstudimage;
        }


        @Override
        public int getCount() {
            return arrstudimage.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {
            LayoutInflater inflater = getLayoutInflater();
            View row = inflater.inflate(R.layout.list_details, viewGroup, false);

            TextView studnametxt, studrolltxt;
            ImageView studimageview;


            studnametxt = (TextView) row.findViewById(R.id.studname);
            studrolltxt = (TextView) row.findViewById(R.id.studroll);
            studimageview = (ImageView) row.findViewById(R.id.studimage);


            studnametxt.setText(arrstudname.get(position));

            studrolltxt.setText(arrstudroll.get(position));

            studimageview.setBackgroundResource(arrstudimage.get(position));




            return row;


        }
    }


}

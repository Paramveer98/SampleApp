package com.example.mypractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ListViewSampleProfile extends AppCompatActivity {
TextView studname,studroll,studclass,studaddress;
ImageView studimage;
int image;
String s_name,s_roll,s_class,s_add ,t_s_name,t_s_roll,t_s_class,t_s_add;
Button click_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view_sample_profile);


        studimage=(ImageView) findViewById(R.id.studimage);
        studname=(TextView) findViewById(R.id.studname);
        studroll =(TextView) findViewById(R.id.studroll);
        studclass=(TextView) findViewById(R.id.studclass);
        studaddress=(TextView) findViewById(R.id.studaddress);

        image= getIntent().getIntExtra("s_image",0);
        s_name= getIntent().getStringExtra("s_name");
        s_roll= getIntent().getStringExtra("s_roll");
        s_class= getIntent().getStringExtra("s_class");
        s_add= getIntent().getStringExtra("s_address");

        t_s_name="Student Name: ";
        t_s_roll="Roll No: ";
        t_s_class="Class: ";
        t_s_add="Address: ";


        studimage.setBackgroundResource(image);
        studname.setText(t_s_name + s_name);
        studroll.setText(t_s_roll + s_roll);
        studclass.setText(t_s_class + s_class);
        studaddress.setText(t_s_add + s_add);


        click_back=(Button) findViewById(R.id.click_back);

        click_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ListViewSampleProfile.this,ListViewSample.class);
                startActivity(intent);
                finish();
            }
        });


    }

}
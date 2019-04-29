package com.example.mypractice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class WhatsappSample extends AppCompatActivity {
    ListView UserView;
    ArrayList<String> arrusername=new ArrayList<>();
    ArrayList<String> arruserchat=new ArrayList<>();
    ArrayList<String> arrchattime=new ArrayList<>();
    ArrayList<Integer> arruserimage=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whatsapp);


        arrusername.add("Jaspreet");
        arruserchat.add("Hello");
        arrchattime.add("11:00 pm");
        arruserimage.add(R.drawable.rich);

        arrusername.add("Paramveer");
        arruserchat.add("Hey!");
        arrchattime.add("yesterday");
        arruserimage.add(R.drawable.elon);

        arrusername.add("Karan");
        arruserchat.add("Hello");
        arrchattime.add("11:00 am");
        arruserimage.add(R.drawable.elon1);

        arrusername.add("Dheeraj");
        arruserchat.add("SSA");
        arrchattime.add("5:00 am");
        arruserimage.add(R.drawable.rich);

        arrusername.add("Ritu");
        arruserchat.add("Namaste ji");
        arrchattime.add("11:00 pm");
        arruserimage.add(R.drawable.ic_launcher_background);

        arrusername.add("Ritesh");
        arruserchat.add("kaise ho!");
        arrchattime.add("2:00 pm");
        arruserimage.add(R.drawable.rich);

        arrusername.add("mohit");
        arruserchat.add("kida");
        arrchattime.add("7:00 am");
        arruserimage.add(R.drawable.elon1);

        arrusername.add("kambi");
        arruserchat.add("hey");
        arrchattime.add("10:00 pm");
        arruserimage.add(R.drawable.elon);


        UserView=(ListView) findViewById(R.id.customListWhats);

        DetailsAdapter detailsAdapter=new DetailsAdapter(arrusername,arruserchat,arrchattime, arruserimage);
        UserView.setAdapter(detailsAdapter);
    }

    class DetailsAdapter extends BaseAdapter {
        ArrayList<String> arrusername=new ArrayList<>();
        ArrayList<String> arruserchat=new ArrayList<>();
        ArrayList<String> arrchattime=new ArrayList<>();
        ArrayList<Integer> arruserimage=new ArrayList<>();



        public DetailsAdapter ( ArrayList<String> arrusername, ArrayList<String> arruserchat, ArrayList<String> arrchattime, ArrayList<Integer> arruserimage)
        {
            this.arrusername=arrusername;
            this.arruserchat=arruserchat;
            this.arrchattime=arrchattime;
            this.arruserimage=arruserimage;
        }


        @Override
        public int getCount() {
            return arruserimage.size();
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
            LayoutInflater inflater=getLayoutInflater();
            View row= inflater.inflate(R.layout.custom_whatsapp_view, viewGroup,false);

            TextView uname, uchat, ctime;
            ImageView userimageview;


            uname=(TextView)row.findViewById(R.id.username);
            uchat=(TextView)row.findViewById(R.id.userchat);
            ctime=(TextView)row.findViewById(R.id.chatTime);
            userimageview=(ImageView)row.findViewById(R.id.userimage);


            uname.setText(arrusername.get(position));

            uchat.setText(arruserchat.get(position));

            ctime.setText(arrchattime.get(position));

            userimageview.setBackgroundResource(arruserimage.get(position));

            return row;



        }
    }


}


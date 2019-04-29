package com.example.mypractice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class GridViewSample extends AppCompatActivity {
    GridView gridView;
    TextView studnametxt, studrolltxt;

    ArrayList<String> arrstudname = new ArrayList<>();
    ArrayList<String> arrstudroll = new ArrayList<>();
    ArrayList<Integer> arrstudimage = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridsample);


        arrstudname.add("Paramveer Singh");
        arrstudroll.add("2134");
        arrstudimage.add(R.drawable.elon1);

        arrstudname.add("Jaspreet");
        arrstudroll.add("2098");
        arrstudimage.add(R.drawable.elon);

        arrstudname.add("Ritesh");
        arrstudroll.add("2138");
        arrstudimage.add(R.drawable.rich);

        arrstudname.add("Mohit");
        arrstudroll.add("2132");
        arrstudimage.add(R.drawable.ic_launcher_background);

        arrstudname.add("Dheeraj");
        arrstudroll.add("2112");
        arrstudimage.add(R.drawable.elon1);

        gridView = (GridView) findViewById(R.id.GridView);

        GridDetailsAdapter detailsAdapter = new GridDetailsAdapter(arrstudname, arrstudroll, arrstudimage);
        gridView.setAdapter(detailsAdapter);


    }

    class GridDetailsAdapter extends BaseAdapter {
        ArrayList<String> arrstudname = new ArrayList<>();
        ArrayList<String> arrstudroll = new ArrayList<>();
        ArrayList<Integer> arrstudimage = new ArrayList<>();


        public GridDetailsAdapter(ArrayList<String> arrstudname, ArrayList<String> arrstudroll, ArrayList<Integer> arrstudimage) {

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
            View row = inflater.inflate(R.layout.custom_gridsample, viewGroup, false);

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


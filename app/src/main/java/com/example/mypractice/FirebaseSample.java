package com.example.mypractice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mypractice.modelClasses.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class FirebaseSample extends AppCompatActivity {
    public DatabaseReference mDatabase;
    Button BtnToast1;
    TextView textView;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.layout_firebase_sample);

            mDatabase = FirebaseDatabase.getInstance().getReference();


            User user =new User("Banga","Param","Btech");
            mDatabase.child("name").push().setValue(user);

            User user2 =new User("jalandhar","Ricky","Btech");

            mDatabase.child("name").push().setValue(user2);

            BtnToast1 = (Button) findViewById(R.id.BtnToast1);
            BtnToast1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ValueEventListener postListener = new ValueEventListener() {

                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {

                            String string = dataSnapshot.getValue().toString();
                            Toast.makeText(getApplicationContext(), string, Toast.LENGTH_SHORT).show();
                            textView = (TextView) findViewById(R.id.txtdata);
                            textView.setText(string);
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    };
                    mDatabase.addValueEventListener(postListener);


                }
            });



        }
    }




package com.example.mypractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button button,Whatsappbutton,buttonGridView,buttonRotateImg,buttonShared,buttonFragment,buttonFirebase,buttonRegAuth,buttonLoginAuth,buttonLayoutConstraint;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=(Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,ListViewSample.class);
                startActivity(intent);
            }
        });

        Whatsappbutton=(Button) findViewById(R.id.buttonWhatsapp);

        Whatsappbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,WhatsappSample.class);
                startActivity(intent);
            }
        });

       buttonGridView =(Button) findViewById(R.id.buttonGridView);

        buttonGridView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,GridViewSample.class);
                startActivity(intent);
            }
        });

        buttonRotateImg =(Button) findViewById(R.id.buttonRotateImg);

        buttonRotateImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Rotateimg.class);
                startActivity(intent);
            }
        });

        buttonShared =(Button) findViewById(R.id.buttonShared);

        buttonShared.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,ButtonClass.class);
                startActivity(intent);
            }
        });

        buttonFragment=(Button) findViewById(R.id.buttonFragment);

        buttonFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,ActivityForFragment.class);
                startActivity(intent);

            }
        });

        buttonFirebase=(Button) findViewById(R.id.buttonFirebase);

        buttonFirebase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,FirebaseSample.class);
                startActivity(intent);

            }
        });


        buttonRegAuth=(Button) findViewById(R.id.buttonRegAuth);

        buttonRegAuth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,RegActAuth.class);
                startActivity(intent);

            }
        });


        buttonLoginAuth=(Button) findViewById(R.id.buttonLoginAuth);

        buttonLoginAuth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,LoginActAuth.class);
                startActivity(intent);

            }
        });

        buttonLayoutConstraint=(Button) findViewById(R.id.buttonLayoutConstraint);

        buttonLayoutConstraint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,LayoutConstraint.class);
                startActivity(intent);

            }
        });

    }

}

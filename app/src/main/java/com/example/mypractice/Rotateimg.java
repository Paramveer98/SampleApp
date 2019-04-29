package com.example.mypractice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import java.util.Random;

public class Rotateimg extends AppCompatActivity {
    ImageView imageView;
    int j, lastangle;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rotate_img);


        imageView = (ImageView) findViewById(R.id.rotate_image);
        imageView.setBackgroundResource(R.drawable.bottle);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random randomdegree = new Random();

                int angle = randomdegree.nextInt(200) + 160;


                j = randomdegree.nextInt(6);
                j = j + 1;


                RotateAnimation rotateAnimation = new RotateAnimation(0, angle, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);


                rotateAnimation.setDuration(3000);
//                rotateAnimation.setRepeatCount(j);
                imageView.startAnimation(rotateAnimation);
            }
        });
    }
}

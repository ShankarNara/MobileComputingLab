package com.example.animapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class MainActivity extends AppCompatActivity {

    Button paint_button;
    Button zoomin_button,fadein_button,rotate_button;
    Button car_button;
    Button forward_button;
    Button backward_button;
    Button line_button ,circle_button, rect_button;
    ImageView iv_animate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        zoomin_button = findViewById(R.id.zoomin_button);
        fadein_button = findViewById(R.id.fadein_button);
        rotate_button = findViewById(R.id.rotatein_button);
        car_button = findViewById(R.id.car_button);
        forward_button = findViewById(R.id.forward_button);
        backward_button = findViewById(R.id.backward_button);
        line_button = findViewById(R.id.line_button);
        circle_button = findViewById(R.id.circle_button);
        rect_button = findViewById(R.id.rect_button);

        iv_animate = findViewById(R.id.iv_animate);

        final Bitmap b = Bitmap.createBitmap(720,1280,Bitmap.Config.ARGB_8888);

        paint_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Paint p = new Paint();
            }
        });

        zoomin_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_animate.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoomin_layout));
            }
        });

        fadein_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_animate.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadein_layout));
            }
        });

        rotate_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_animate.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_layout));
            }
        });

        car_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_animate.setImageResource(R.drawable.car);
            }
        });

        forward_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_animate.animate().translationXBy(300f).setDuration(1000);
            }
        });

        backward_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_animate.animate().translationXBy(-300f).setDuration(1000);
            }
        });

        line_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        rect_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        circle_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}

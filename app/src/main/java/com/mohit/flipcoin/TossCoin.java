package com.mohit.flipcoin;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

 public class TossCoin extends AppCompatActivity {

     TextView heads_val_tv, tails_val_tv;
     ImageView coin;
     MediaPlayer mediaPlayer;
     ScaleAnimation s_anim;
     int click=0;

     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_toss_coin);

         heads_val_tv = (TextView) findViewById(R.id.heads_val);
         tails_val_tv = (TextView) findViewById(R.id.tails_val);
         coin = (ImageView) findViewById(R.id.coin_side);

         Intent intent = getIntent();
         String heads_val = intent.getStringExtra("Heads");
         String tails_val = intent.getStringExtra("Tails");

         heads_val_tv.setText(heads_val);
         tails_val_tv.setText(tails_val);
         mediaPlayer = MediaPlayer.create(this,R.raw.coin_toss_sound);

     }

     @SuppressLint("ResourceAsColor")
     public void onCoinTap(View view) {
         coin.animate().setDuration(6000).rotationY(3600f);
         if(click==0)
         {
             mediaPlayer.start();
             click++;
         }
         int flag = decideFunction();
         Handler mHandler = new Handler();
         mHandler.postDelayed(new Runnable() {
             @Override
             public void run() {
                 if(flag==0){
                     coin.setImageResource(R.drawable.coin_heads_img);
                     heads_val_tv.setTextColor(getColor(R.color.red));
                 }
                 else{
                     coin.setImageResource(R.drawable.coin_tails_img);
                     tails_val_tv.setTextColor(getColor(R.color.red));
                 }
                 coin.setClickable(true);
             }
         },6000);
     }

     private int decideFunction() {
         Random random = new Random();
         int val = random.nextInt(30000);
         Log.d("Number", String.valueOf(val));
         if(val%2==0)
             return 1;
         else
             return 0;
     }
 }

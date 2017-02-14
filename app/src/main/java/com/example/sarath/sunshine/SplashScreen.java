package com.example.sarath.sunshine;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class SplashScreen extends AppCompatActivity {

private static int SPLASH_TIME_OUT= 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash_screen);

        new     Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        },SPLASH_TIME_OUT);
  /*Thread mythread = new Thread(){
      @Override
      public void run() {
          try {
              sleep(4000);
              Intent intent = new Intent(getApplicationContext(),Camera.class);
              startActivity(intent);
              finish();

          }catch (InterruptedException e){

          }
      }
  };
        mythread.start();*/
    }
}

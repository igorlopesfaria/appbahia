package br.com.bahiaapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;


public class LaucherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laucher);

        delay();
    }


    private void delay() {
        Handler delayHandler = new Handler();
        delayHandler.postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(myIntent);
                finish();
            }

        }, 2000);
    }

}


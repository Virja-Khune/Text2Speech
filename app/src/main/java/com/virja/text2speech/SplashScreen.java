package com.virja.text2speech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.virja.text2speech.databinding.ActivitySplashScreenBinding;

public class SplashScreen extends AppCompatActivity {
     private ActivitySplashScreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent mainIntent = new Intent(this,MainActivity.class);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
            startActivity(mainIntent);

            }
        },2000);

    }
}
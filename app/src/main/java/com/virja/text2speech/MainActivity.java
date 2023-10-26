package com.virja.text2speech;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.Toast;

import com.virja.text2speech.databinding.ActivityMainBinding;

import java.util.Locale;


public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {
    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textToSpeech = new TextToSpeech(this , (TextToSpeech.OnInitListener) this);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());

        binding.btnLearnMore.setOnClickListener(
                v->{
                    String text = binding.etMultiline.getText().toString();
                    textToSpeech.speak(text,TextToSpeech.QUEUE_FLUSH , null,null);
                }
        );

    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(textToSpeech!=null){
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
    }

    @Override
    public void onInit(int i) {
        if (i == TextToSpeech.SUCCESS) {
            int result = textToSpeech.setLanguage(Locale.ENGLISH);
            if (result == TextToSpeech.LANG_MISSING_DATA) {
                Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
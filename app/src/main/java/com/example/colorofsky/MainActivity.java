package com.example.colorofsky;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.airbnb.lottie.LottieAnimationView;
import android.media.MediaPlayer;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private LottieAnimationView lottieAnimationView;
    private Button buttonSunrise;
    private Button buttonSunset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lottieAnimationView = findViewById(R.id.lottieAnimationView);
        buttonSunrise = findViewById(R.id.buttonSunrise);
        buttonSunset = findViewById(R.id.buttonSunset);

        buttonSunrise.setOnClickListener(this);
        buttonSunset.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        int viewId = view.getId();
        if (viewId == R.id.buttonSunrise) {
            animateSunrise();
        } else if (viewId == R.id.buttonSunset) {
            animateSunset();
        }
    }


    private void animateSunrise() {
        lottieAnimationView.setAnimation("sunrise_1.json"); // Replace with the name of your sunrise animation file
        lottieAnimationView.setRepeatCount(0);
        lottieAnimationView.playAnimation();
        MediaPlayer sunriseSound = MediaPlayer.create(this, R.raw.sunrise_sound); // Replace 'sunrise_sound' with the name of your sunrise sound file
        sunriseSound.start();
    }

    private void animateSunset() {
        lottieAnimationView.setAnimation("sunset.json"); // Replace with the name of your sunset animation file
        lottieAnimationView.setRepeatCount(0);
        lottieAnimationView.playAnimation();
        MediaPlayer sunsetSound = MediaPlayer.create(this, R.raw.sunset_sound); // Replace 'sunset_sound' with the name of your sunset sound file
        sunsetSound.start();
    }

}

package com.example.electiva.zimbabue;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

/**
 * Created by LuisA on 20/4/2016.
 */
public class PopWin extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        Bundle variables = intent.getExtras();
        String jugadorEnTurno = String.valueOf(variables.getInt("jugadorEnTurno", -1));
        setContentView(R.layout.popwin);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        Typeface texto = Typeface.createFromAsset(getAssets(),"zoo.otf");
        Typeface textNumero = Typeface.createFromAsset(getAssets(),"number.ttf");

        System.out.println("GANADORRRRRRRRRRRRRRRRRRRRRRRRR:" + jugadorEnTurno);

        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int)(width*.8),(int)(height* 0.6));
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        final CounterClass timer = new CounterClass(5000,1000);
        timer.start();
        MediaPlayer correct = MediaPlayer.create(this,R.raw.win);
        correct.start();
    }

    public class CounterClass extends CountDownTimer {
        public CounterClass(long millisInfuture, long countDownInterval){
            super(millisInfuture,countDownInterval);
        }
        public  void onTick(long millisUntilFinished){
            long millis = millisUntilFinished;
            String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis),
                    TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
                    TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));


        }
        public void onFinish(){

            Intent i = new Intent();
            setResult(Activity.RESULT_OK, i);
            finish();
        }

    }
}

package com.example.electiva.zimbabue;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;


public class Pop extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        Bundle variables = intent.getExtras();
        int jugadorEnTurno = variables.getInt("jugadorEnTurno");
        String esTuTurno = "Jugador " + jugadorEnTurno;
        System.out.println("--------------------------------"+esTuTurno);
        setContentView(R.layout.popupwindow);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        Typeface texto = Typeface.createFromAsset(getAssets(),"zoo.otf");
        Typeface textNumero = Typeface.createFromAsset(getAssets(),"number.ttf");
        TextView myTexto = (TextView) findViewById(R.id.textViewPop);
        TextView myTexto2 = (TextView) findViewById(R.id.textViewPop2);
        TextView myTexto3 = (TextView) findViewById(R.id.textViewPop3);
        myTexto3.setText(String.valueOf(jugadorEnTurno));
        myTexto3.setTypeface(textNumero);
        myTexto.setTypeface(texto);
        myTexto2.setTypeface(texto);

        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int)(width*.8),(int)(height* 0.6));
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        final CounterClass timer = new CounterClass(3000,1000);
        timer.start();
    }

    public class CounterClass extends CountDownTimer{
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
            finish();
        }

    }
}

package com.example.electiva.zimbabue;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class Pantalla_Inicio extends Activity {
    public static MediaPlayer musicaFondo;
    public static boolean musicaEstaCorriendo = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_pantalla_inicio);

        Typeface texto = Typeface.createFromAsset(getAssets(),"zoo.otf");
        TextView myTexto = (TextView) findViewById(R.id.buttonJugar);
        TextView myTexto2 = (TextView) findViewById(R.id.buttonAyuda);
        myTexto.setTypeface(texto);
        myTexto2.setTypeface(texto);

        musicaFondo = MediaPlayer.create(this, R.raw.fondo);
        musicaFondo.setVolume(1,1);
        final MediaPlayer opc = MediaPlayer.create(this, R.raw.elige);
        final Button botonJugar= (Button) findViewById(R.id.buttonJugar);
        final Button botonAyuda = (Button) findViewById(R.id.buttonAyuda);
        musicaFondo.setLooping(true);
        musicaFondo.start();
        musicaEstaCorriendo = true;

// funcion que crea un intent hacia la ventana de Seleccionar Mundo una vez que se hace pop sobre "Jugar"
       botonJugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Animation anrTl = AnimationUtils.loadAnimation(getBaseContext(), R.anim.rotate_from_right_to_left);
                botonJugar.startAnimation(anrTl);//Animacion qe hace rotar el boton.
                anrTl.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override//cuando la animacion termina, se envia el intent
                    public void onAnimationEnd(Animation animation) {
                        finish();
                        startActivity(new Intent(Pantalla_Inicio.this, Seleccionar_Mundo.class));
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });
        //Funcion que se activa una vez que se hace pop sobre el boton de ayuda, envia un intent a un documento publico en google drive.
        botonAyuda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Animation anlTr = AnimationUtils.loadAnimation(getBaseContext(), R.anim.rotate_from_left_to_right);
                opc.start();
                botonAyuda.startAnimation(anlTr);
                anlTr.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        finish();
                        String url = "https://drive.google.com/open?id=0B0Qhm-1UypPhR2RlWmRhRElfXzg";
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(url));
                        startActivity(i);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });
    }
    //Apaga la musica
    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
    //Resume la musica
    @Override
    protected void onResume() {
        super.onResume();
      if (!musicaFondo.isPlaying()){
        musicaFondo.start();
      }
    }
    //Pausa la musica
    @Override
    protected void onPause() {
        super.onPause();

    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == event.KEYCODE_BACK) {

            musicaFondo.stop();
            finish();
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);


        }
        return super.onKeyDown(keyCode, event);
    }
}


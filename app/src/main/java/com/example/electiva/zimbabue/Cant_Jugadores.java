package com.example.electiva.zimbabue;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class Cant_Jugadores extends Activity {
    String simboloOperacion;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        Bundle otrasVariables = intent.getExtras();
        simboloOperacion = otrasVariables.getString("SimboloOperacion","-1");
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_cant_jugador);
        Typeface texto = Typeface.createFromAsset(getAssets(),"zoo.otf"); //settea el font-family
        TextView myTexto = (TextView) findViewById(R.id.textViewCantJugadores);
        myTexto.setTypeface(texto);

        final MediaPlayer sonad = MediaPlayer.create(this,R.raw.bongo);
        final Button Jugador2 = (Button) findViewById(R.id.Jugador2);
        final Button Jugador3 = (Button) findViewById(R.id.Jugador3);
        final Button Jugador4 = (Button) findViewById(R.id.Jugador4);
        //este es el listener para cuando se escogen dos jugadores..se envia un intent con un string de cantidadJugadores = 2;
        Jugador2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Animation anrTl = AnimationUtils.loadAnimation(getBaseContext(), R.anim.rotate_from_right_to_left);
                sonad.start();
                Jugador2.startAnimation(anrTl);
                anrTl.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Intent intentDosJugadores = new Intent(Cant_Jugadores.this, Pantalla_Tablero.class);
                        intentDosJugadores.putExtra("cantidadDeJugadores",2);
                        intentDosJugadores.putExtra("SimboloOperacion",simboloOperacion);
                        startActivity(intentDosJugadores);
                        Pantalla_Inicio.musicaFondo.stop();
                        finish();
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });
        //este es el listener para cuando se escogen tres jugadores..se envia un intent con un string de cantidadJugadores = 3;
        Jugador3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Animation anlTr = AnimationUtils.loadAnimation(getBaseContext(), R.anim.rotate_from_left_to_right);
                sonad.start();
                Jugador3.startAnimation(anlTr);
                anlTr.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Intent intentTresJugadores = new Intent(Cant_Jugadores.this, Pantalla_Tablero.class);
                        intentTresJugadores.putExtra("cantidadDeJugadores",3);
                        intentTresJugadores.putExtra("SimboloOperacion",simboloOperacion);
                        startActivity(intentTresJugadores);
                        Pantalla_Inicio.musicaFondo.stop();
                        finish();
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });
        //este es el listener para cuando se escogen dos jugadores..se envia un intent con un string de cantidadJugadores = 4;
        Jugador4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Animation anlTr = AnimationUtils.loadAnimation(getBaseContext(), R.anim.rotate_from_left_to_right);
                sonad.start();
                Jugador4.startAnimation(anlTr);
                anlTr.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Intent intentCuatroJugadores = new Intent(Cant_Jugadores.this, Pantalla_Tablero.class);
                        intentCuatroJugadores.putExtra("cantidadDeJugadores",4);
                        intentCuatroJugadores.putExtra("SimboloOperacion",simboloOperacion);
                        startActivity(intentCuatroJugadores);
                        Pantalla_Inicio.musicaFondo.pause();
                        finish();
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });


    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == event.KEYCODE_BACK) {
            startActivity(new Intent(Cant_Jugadores.this, Seleccionar_Mundo.class));
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}

package com.example.electiva.zimbabue;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class Seleccionar_Mundo extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_seleccionar_mundo);
        Typeface texto = Typeface.createFromAsset(getAssets(),"zoo.otf");
        TextView myTexto = (TextView) findViewById(R.id.textViewSelectMundo);
        myTexto.setTypeface(texto);
    }
//Metodo que crea un intent a la ventana para seleccionar jugadores, envia ademas el tipo de operacion suma
    public void abrirMundoSuma(View v){
        MediaPlayer sonad = MediaPlayer.create(this,R.raw.bongo);
        sonad.start();
        startActivity(new Intent(Seleccionar_Mundo.this, Cant_Jugadores.class).putExtra("SimboloOperacion","+"));
        finish();
    }
    //Metodo que crea un intent a la ventana para seleccionar jugadores, envia ademas el tipo de operacion resta
    public void abrirMundoResta(View v){
        MediaPlayer sonad = MediaPlayer.create(this,R.raw.bongo);
        sonad.start();
        startActivity(new Intent(Seleccionar_Mundo.this, Cant_Jugadores.class).putExtra("SimboloOperacion","-"));
        finish();
    }
    //Metodo que crea un intent a la ventana para seleccionar jugadores, envia ademas el tipo de operacion multiplicacion
    public void abrirMundoMultiplicacion(View v){
        MediaPlayer sonad = MediaPlayer.create(this,R.raw.bongo);
        sonad.start();
        startActivity(new Intent(Seleccionar_Mundo.this, Cant_Jugadores.class).putExtra("SimboloOperacion","x"));
        finish();
    }
    //Metodo que crea un intent a la ventana para seleccionar jugadores, envia ademas el tipo de operacion division
    public void abrirMundoDivision(View v){
        MediaPlayer sonad = MediaPlayer.create(this,R.raw.bongo);
        sonad.start();
        startActivity(new Intent(Seleccionar_Mundo.this, Cant_Jugadores.class).putExtra("SimboloOperacion","/"));
        finish();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == event.KEYCODE_BACK) {
            startActivity(new Intent(Seleccionar_Mundo.this, Pantalla_Inicio.class));
            Pantalla_Inicio.musicaFondo.stop();
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}

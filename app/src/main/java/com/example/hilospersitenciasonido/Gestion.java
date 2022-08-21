package com.example.hilospersitenciasonido;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;

public class Gestion extends Activity {

    private Partida_pelota partida;

    private  int dificultad;

    private int fps = 30;

    private Handler temporizador;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        Bundle extras = getIntent().getExtras();

        dificultad = extras.getInt("DIFICULTAD");

        partida = new Partida_pelota(getApplicationContext(), dificultad);

        setContentView(partida);

        temporizador = new Handler();

        temporizador.postDelayed(elhilo, 2000);
    }

    private Runnable elhilo = new Runnable() {
        @Override
        public void run() {

            if(partida.movimientoBola()) {
                fin();
            }else{

                partida.invalidate(); //Elimina el contenido de ImageView y llama de nuevo al metodo onDraw

                temporizador.postDelayed(elhilo, 1000/fps);

            }


        }
    };

    public boolean onTouchEvent(MotionEvent evento){

        int x = (int) evento.getX();

        int y = (int) evento.getY();

        System.out.println("X: " + x +" Y: " + y);

        //paso el punto concreto con el usuario ha tocado la pantalla
        partida.toque(x, y);

        return false;
    }

    public void fin(){

        temporizador.removeCallbacks(elhilo); // para matar el hilo

        finish();//destruye la actividad actual
    }

}

package com.example.hilospersitenciasonido;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ayuda(View vista){

        Intent intencion = new Intent(this, AyudaActividad.class);

        startActivity(intencion);

    }

    public void dificultad(View vista){

        String dific = (String) ((Button) vista).getText();

        System.out.println("Texto boton: " + dific);

        int dificultad = 1;

        if(dific.equals(getString(R.string.medio)) || dific.equals("Normal")) dificultad =2;

        if(dific.equals("Dificult") || dific.equals("Dificil")) dificultad =3;

        Intent in = new Intent(this, Gestion.class);

        in.putExtra("DIFICULTAD", dificultad);

        startActivity(in);

    }
}
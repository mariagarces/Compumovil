package com.example.taller1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class PaisActivity extends AppCompatActivity {

    TextView textViewPais;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pais);

        Bundle bundle = getIntent().getBundleExtra("bundle");
        String nombre = bundle.getString("nombre");
        String nombreInt = bundle.getString("nombre_int");
        String capital = bundle.getString("capital");
        String sigla = bundle.getString("sigla");
        String datosPais = "Nombre país: " + nombre + "\n" + "Country name: " + nombreInt + "\n" + "Capital: " + capital + "\n" + "Sigla: " + sigla + "\n";

        textViewPais = findViewById(R.id.datosPais);
        textViewPais.setText(datosPais);
    }
}

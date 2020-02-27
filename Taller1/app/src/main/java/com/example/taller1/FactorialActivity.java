package com.example.taller1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class FactorialActivity extends AppCompatActivity {

    TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factorial);

        texto = findViewById(R.id.fact);

        Intent incomingIntent = getIntent();
        String numero = incomingIntent.getStringExtra("numero");

        String mult="";
        int result=1;

        for (int i=1; i<=Integer.parseInt(numero); i++)
        {
            if(Integer.parseInt(numero)==i)
            {
                mult+=i;
            }
            else
            {
                mult+= i + "*";
            }
            result*=i;
        }

        texto.setText("Multiplicación = " + mult + "\n" + "Resultado = " + result);
    }
}

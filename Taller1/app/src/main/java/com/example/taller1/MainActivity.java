package com.example.taller1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button calculo, factorial, paises;
    EditText numero;
    ImageButton image;
    Spinner data;
    TextView textViewCont;
    String currentTimeFi, currentTimeFa;
    int contadorFi=0, contadorFa=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numero = findViewById(R.id.numero);
        calculo = findViewById(R.id.calculo);
        image = findViewById(R.id.image);
        factorial = findViewById(R.id.factorial);
        data = findViewById(R.id.spinner);
        paises = findViewById(R.id.paises);
        textViewCont = findViewById(R.id.textViewContador);

        if (savedInstanceState != null)
        {
            contadorFi = savedInstanceState.getInt("contadorStateFi", 0);
            currentTimeFi = savedInstanceState.getString("timeStateFi", Calendar.getInstance().getTime().toString());
            contadorFa = savedInstanceState.getInt("contadorStateFa", 0);
            currentTimeFa = savedInstanceState.getString("timeStateFa", Calendar.getInstance().getTime().toString());
            textViewCont.setText("Fibonacci " + String.valueOf(contadorFi) + " veces, en "+ currentTimeFi +"\n"+"Factorial " + String.valueOf(contadorFa) + " veces, en "+ currentTimeFa);

        }else
        {
            contadorFi = 0;
            currentTimeFi = Calendar.getInstance().getTime().toString();
            contadorFa = 0;
            currentTimeFa = Calendar.getInstance().getTime().toString();
            textViewCont.setText("Fibonacci : 0 veces, en " + currentTimeFi + "\n" + "Factorial : 0 veces, en " + currentTimeFa);
        }


        calculo.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                currentTimeFi = Calendar.getInstance().getTime().toString();
                contadorFi = contadorFi+1;

                TextView x = new TextView(MainActivity.this);

                String n = numero.getText().toString();

                if(!n.isEmpty())
                {
                    if (n.contentEquals("0"))
                    {
                        numero.setError("Ingrese valor diferente a 0");
                    }
                    else
                    {
                        Intent intent = new Intent(MainActivity.this, FibonacciActivity.class);
                        intent.putExtra("numero", n);
                        startActivity(intent);
                    }
                }
                else
                {
                    numero.setError("Ingrese valor");
                }
            }
        });

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WebActivity.class);
                startActivity(intent);
            }
        });

        factorial.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                currentTimeFa = Calendar.getInstance().getTime().toString();
                contadorFa = contadorFa+1;

                Intent intent = new Intent(MainActivity.this, FactorialActivity.class);
                intent.putExtra("numero", (String)data.getSelectedItem());
                startActivity(intent);
            }
        });

        paises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListViewAct.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onResume(){
        super.onResume();
        textViewCont.setText("Fibonacci: "+String.valueOf(contadorFi) + " veces, en "+ currentTimeFi + "\n" + "Factorial: "+String.valueOf(contadorFa) + " veces, en "+ currentTimeFa);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("contadorStateFi", contadorFi);
        outState.putString("timeStateFi", currentTimeFi);

        outState.putInt("contadorStateFa", contadorFa);
        outState.putString("timeStateFa", currentTimeFa);
    }
}

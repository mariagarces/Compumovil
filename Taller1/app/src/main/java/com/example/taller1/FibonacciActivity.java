package com.example.taller1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.*;

public class FibonacciActivity extends AppCompatActivity {

    LinearLayout layoutText;
    TextView numeros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fibonacci);

        numeros = findViewById(R.id.numeros);
        layoutText = findViewById(R.id.layoutText);

        Intent incomingIntent = getIntent();
        String incomingNumber = incomingIntent.getStringExtra("numero");

        int n = Integer.parseInt(incomingNumber);
        int n1 = 0, n2 = 1, total;

        if (n == 1)
        {
            TextView x = new TextView(FibonacciActivity.this);
            x.setText("0");
            layoutText.addView(x);
        }
        else if (n >= 2)
        {
            TextView x = new TextView(FibonacciActivity.this);
            x.setText("0");
            layoutText.addView(x);
            x = new TextView(FibonacciActivity.this);
            x.setText("1");
            layoutText.addView(x);

            for (int i=2; i<n; i++)
            {
                x = new TextView(FibonacciActivity.this);

                total = n1+n2;
                x.setText(Integer.toString(total));
                layoutText.addView(x);
                n1 = n2;
                n2 = total;
            }
        }
    }
}

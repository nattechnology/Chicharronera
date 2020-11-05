package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText val1, val2, val3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        val1 = (EditText) findViewById(R.id.TCuadratico);
        val2 = (EditText) findViewById(R.id.TLineal);
        val3 = (EditText) findViewById(R.id.TIndependiente);
    }

    public void operacion(View view){
        String val1s = val1.getText().toString();
        String val2s = val2.getText().toString();
        String val3s = val3.getText().toString();
        DecimalFormat format = new DecimalFormat("0.###");
        if(val1s.isEmpty()||val2s.isEmpty()||val3s.isEmpty()){
            if(val1s.isEmpty())
                val1.setError("Valor no ingresado");
            if(val2s.isEmpty())
                val2.setError("Valor no ingresado");
            if(val3s.isEmpty())
                val3.setError("Valor no ingresado");
        }
        else {
            double a = Double.valueOf(val1s);
            double b = Double.valueOf(val2s);
            double c = Double.valueOf(val3s);

            double mul = (4 * a) * c;
            double pot = Math.pow(b, 2);
            double res = pot - mul;
            double ra = Math.sqrt(res);
            if (ra >= 0) {
                double b_neg = b * (-1);
                double div = 2 * a;
                double pos = (b_neg + ra) / div;
                double neg = (b_neg - ra) / div;

                Toast.makeText(this, "Suma = " + format.format(pos) + " Resta = " + format.format(neg), Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "No se puede resolver la raiz", Toast.LENGTH_LONG).show();
            }
        }
    }
}
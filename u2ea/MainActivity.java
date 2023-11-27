package com.example.u2ea;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText et_a, et_b, et_a2, et_b2, et_a3, et_b3;

    Button button;
    Button button2;


    double a, b, a2, b2, a3, b3;
    String resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        et_a = (EditText) findViewById(R.id.et_a);
        et_b = (EditText) findViewById(R.id.et_b);
        et_a2 = (EditText) findViewById(R.id.et_a2);
        et_b2 = (EditText) findViewById(R.id.et_b2);
        et_a3 = (EditText) findViewById(R.id.et_a3);
        et_b3 = (EditText) findViewById(R.id.et_b3);


        button = (Button) findViewById(R.id.button_first);
        button2 = (Button) findViewById(R.id.button2);


        button.setOnClickListener(new View.OnClickListener() {

            public String calcular(double e1, double e2, double e3, double i1, double i2, double i3) {
                String rf = "";
                double r1 = (e1 * i2) - (e2 * i1);
                double r2 = (e3 * i2) - (e2 * i3);
                double r3 = (e1 * i3) - (e3 * i1);

                if ((e1 * i2 - e2 * i1) == 0) {
                    rf = "El sistema no cuenta con solución";
                } else {
                     rf = "Determinante del sistema " + "\n" + "A =" + "(" + e1 + "*" + i2 + ")-(" + e2 + "*" + i1 + ") = " + r1 +
                            "\n" + "\n" +
                            "Determinante de incógnita X " + "\n" + "A1 =" + "(" + e3 + "*" + i2 + ")-(" + e2 + "*" + i3 + ") = " + r2 +
                            "\n" + "\n" +
                            "Determinante de incógnita Y " + "\n" + "A2 =" + "(" + e1 + "*" + i3 + ")-(" + e3 + "*" + i1 + ") = " + r3 +
                            "\n" + "\n" +
                            "Resultados" + "\n" + "X = A1 / A = " + r2 + "/" + r1 + "=" + (r2 / r1) + "\n" +
                            "Y = A2 / A = " + r3 + "/" + r1 + "=" + (r3 / r1);
                }
                return rf;
            }

            public void onClick(View v) {


                a = Double.parseDouble(et_a.getText().toString());
                b = Double.parseDouble(et_b.getText().toString());
                a2 = Double.parseDouble(et_a2.getText().toString());
                b2 = Double.parseDouble(et_b2.getText().toString());
                a3 = Double.parseDouble(et_a3.getText().toString());
                b3 = Double.parseDouble(et_b3.getText().toString());


                resultado = calcular(a, a2, a3, b, b2, b3);



                String value=resultado;

                Intent i = new Intent(MainActivity.this, MainActivity2.class);
                i.putExtra("key",resultado);
                startActivity(i);


            }


        });


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MainActivity.this.finish();
                System.exit(0);


            }


        });

    }


}




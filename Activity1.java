package com.example.u3ea;

import android.widget.Adapter;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {
EditText nombre,apellido1, apellido2, edad, email, telefono;
RadioGroup radioGroup2;
Button button, button2;
RequestQueue requestQueue;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = (EditText)findViewById(R.id.nombre);
        apellido1 = (EditText)findViewById(R.id.apellido1);
        apellido2 = (EditText)findViewById(R.id.apellido2);
        edad = (EditText)findViewById(R.id.edad);
        email = (EditText)findViewById(R.id.email);
        telefono = (EditText)findViewById(R.id.telefono);
        radioGroup2 = (RadioGroup)findViewById(R.id.radioGroup2);
        button=(Button)findViewById(R.id.button);
        button2=(Button)findViewById(R.id.button2);
        requestQueue = Volley.newRequestQueue(this);


        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        String[] valores = {"Estado civil", "Soltero","Casado","Divorciado","Viudo"};
        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, valores));
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id)
            {
                Toast.makeText(adapterView.getContext(), (String) adapterView.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                // vacio

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviarDatos();
            }
        });
    }

    private void enviarDatos(){
        String url="http://192.168.1.66/Android/v1/registerUser.php";
        StringRequest request = new StringRequest(Request.Method.POST,url,new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }

        }){

            protected Map<String,String> getParams() throws AuthFailureError {
                Map<String,String> map= new HashMap<String,String>();
                map.put("nombre",nombre.getText().toString());
                map.put("apellido1",apellido1.getText().toString());
                map.put("apellido2",apellido2.getText().toString());
                map.put("edad",edad.getText().toString());
                map.put("email",email.getText().toString());
                map.put("telefono",telefono.getText().toString());

                return map;
            }

        };
        requestQueue.add(request);

    }


}

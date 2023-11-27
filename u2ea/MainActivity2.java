package com.example.u2ea;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        result = (TextView)findViewById(R.id.result);

        String key = getIntent().getStringExtra("key");
       result.setText(key);



    }

    public void Regresar(View View){
        Intent i =new Intent(this, MainActivity.class);
        startActivity(i);

    }

}
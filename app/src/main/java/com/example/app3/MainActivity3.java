package com.example.app3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
    Button btn;
    TextView rDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        btn = findViewById(R.id.btn1);
        rDatos = findViewById(R.id.idN);

        Bundle recibeNombre = getIntent().getExtras();
        String n = recibeNombre.getString("keyDatos");

        rDatos.setText("Bienvenido: " + n);



    }

    public void onClick(View h){

        Bundle extras = new Bundle();
        extras.putInt("id", 1);
        Intent ir = new Intent(MainActivity3.this, MainActivity2.class);
        ir.putExtras(extras);
        ir.addFlags(ir.FLAG_ACTIVITY_CLEAR_TASK | ir.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(ir);

    }
    public void onClick1(View h){

        Bundle extras = new Bundle();
        extras.putInt("id", 2);
        Intent ir = new Intent(MainActivity3.this, MainActivity2.class);
        ir.putExtras(extras);
        ir.addFlags(ir.FLAG_ACTIVITY_CLEAR_TASK | ir.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(ir);

    }
    public void onClick2(View h){

        Bundle extras = new Bundle();
        extras.putInt("id", 3);
        Intent ir = new Intent(MainActivity3.this, MainActivity2.class);
        ir.putExtras(extras);
        ir.addFlags(ir.FLAG_ACTIVITY_CLEAR_TASK | ir.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(ir);

    }
    public void onClick3(View h){

        Bundle extras = new Bundle();
        extras.putInt("id", 4);
        Intent ir = new Intent(MainActivity3.this, MainActivity2.class);
        ir.putExtras(extras);
        ir.addFlags(ir.FLAG_ACTIVITY_CLEAR_TASK | ir.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(ir);

    }
}
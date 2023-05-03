package com.example.app3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity2 extends AppCompatActivity {

    TextView rDatos;
    RequestQueue prueba;
    private static final String URL1="https://run.mocky.io/v3/ca53df7b-780e-4481-81ed-aab13e8f8730";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        prueba = Volley.newRequestQueue(this);
        //String url ="http://www.google.com";
       rDatos = findViewById(R.id.parametro);

        Bundle recibeDatos = getIntent().getExtras();
        String info = recibeDatos.getString("keyDatos");

       // rDatos.setText(info);

       // initUI();
        stringRequest();
    }

    //private void initUI(){
      //  rDatos = findViewById(R.id.textView);
    //}

    private void stringRequest(){
        StringRequest request = new StringRequest(
                Request.Method.GET,
                URL1,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        rDatos.setText(response);
                    }

                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }

        );
        prueba.add(request);
    }
}
package com.example.app3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Datos_Temperatura extends AppCompatActivity {

    RequestQueue pruebaTem;
    TextView rDatos, name,db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_temperatura);

        pruebaTem = Volley.newRequestQueue(this);
        name.setMovementMethod(new ScrollingMovementMethod());
    }

    private void metodoGet() {
        String url = "https://run.mocky.io/v3/7394bdd0-5fc7-4138-9bef-e0e40bdd5159";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray nConsulta = response.getJSONArray("eventos");
                    for (int i = 0; i < nConsulta.length(); i++) {
                        JSONObject nObjeto = nConsulta.getJSONObject(i);

                        name.append("Id: " + nObjeto.getString("id_evento") + "\n\n");
                        name.append("Nombre: " + nObjeto.getString("nombre_evento") + "\n\n");
                        name.append("---------------------------------------" + "\n");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                });
        pruebaTem.add(request);
    }
}
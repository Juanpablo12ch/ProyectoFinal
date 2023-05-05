package com.example.app3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MainActivity2 extends AppCompatActivity {

    TextView rDatos, name,db;
    RequestQueue prueba;
    private static final String URL1 = "https://run.mocky.io/v3/ca53df7b-780e-4481-81ed-aab13e8f8730";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        prueba = Volley.newRequestQueue(this);
        //String url ="http://www.google.com";
        rDatos = findViewById(R.id.datos);
        db = findViewById(R.id.db);
        name = findViewById(R.id.parametro);
        name.setMovementMethod(new ScrollingMovementMethod());

        Bundle recibeDatos = getIntent().getExtras();
        String info = recibeDatos.getString("keyDatos");

        // rDatos.setText(info);

        // initUI();
        //stringRequest();
        //obtener();
        //MethodPost();
       met();
    }

    //METODO DE PRIMERA PRUEBA PARA EL MÉTODO GET CON VOLLEY
    //METODO DE PRIMERA PRUEBA PARA EL MÉTODO GET CON VOLLEY
    //METODO DE PRIMERA PRUEBA PARA EL MÉTODO GET CON VOLLEY

    //private void initUI(){
    //  rDatos = findViewById(R.id.textView);
    //}

    /*private void stringRequest(){
        StringRequest request = new StringRequest(
                Request.Method.GET,
                URL1,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //rDatos.setText(response);
                    }

                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }

        );
        prueba.add(request);
    }*/


    //METODO DE PRIMERA PRUEBA PARA EL MÉTODO GET CON VOLLEY
    //METODO DE PRIMERA PRUEBA PARA EL MÉTODO GET CON VOLLEY
    //METODO DE PRIMERA PRUEBA PARA EL MÉTODO GET CON VOLLEY

    private void obtener() {
        String url = "https://invessoft.com/api/eventos";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray nConsulta = response.getJSONArray("eventos");
                    for (int i = 0; i < nConsulta.length(); i++) {
                        JSONObject nObjeto = nConsulta.getJSONObject(i);

                        // String id = nObjeto.getString("id_evento");
                        // String nombre_ev = nObjeto.getString("nombre_evento");

                        //name.setText(id);
                        name.append("Id: " + nObjeto.getString("id_evento") + "\n\n");
                        name.append("Nombre: " + nObjeto.getString("nombre_evento") + "\n\n");
                        name.append("Fecha inicio: " + nObjeto.getString("fecha_inicio") + "\n\n");
                        name.append("Fecha fin: " + nObjeto.getString("fecha_fin") + "\n\n");
                        name.append("Nombre imagen: " + nObjeto.getString("nombre_imagen") + "\n\n");
                        name.append("Ruta imagen: " + nObjeto.getString("ruta_imagen") + "\n\n");
                        name.append("---------------------------------------" + "\n");
                        // Toast.makeText(MainActivity2.this, "ID: " + id + "Nombre:" + nombre_ev, Toast.LENGTH_SHORT).show();
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
        prueba.add(request);
    }



    private void met() {
    //    String url1 = "https://run.mocky.io/v3/a069aceb-61d6-4c3c-928f-b92133a3581f";
      //  String url2="https://run.mocky.io/v3/d362736e-1400-47be-92f6-89340c62460e";
        //String url3= "https://run.mocky.io/v3/324cf6fe-6489-4a45-8c03-00b4daabae99";

        String url = "https://run.mocky.io/v3/4decaf2c-ed33-4e5d-892a-5ed921d7195b";



        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //met(response);
                rDatos.setText(response);
                Toast.makeText(MainActivity2.this, "Datos agregados. ", Toast.LENGTH_SHORT).show();

            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                        Toast.makeText(MainActivity2.this, "Error", Toast.LENGTH_SHORT).show();

                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError{
                Map<String, String> params = new HashMap<String, String>();

                //Toast.makeText(MainActivity2.this, "HOLA", Toast.LENGTH_LONG).show();
                    // the POST parameters:
                    params.put("nombre_evento", "Prueba1");
                    params.put("nombre_evento", "Prueba233");

                for (String value : params.keySet()) {
                   // System.out.println("Value = " + value);
                    db.setText(params.get(value));
                }

                for (Map.Entry<String, String> entry : params.entrySet()) {
                    //System.out.println("clave=" + entry.getKey() + ", valor=" + entry.getValue());
                    db.setText(entry.getValue() + "\n\n");
                }
                    return params;

            }@Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String,String> headers = new HashMap<String, String>();
                headers.put("Content-Type","application/json");
                headers.put("abc", "value");
                return headers;
            }

        };

        prueba.add(request);
    }

    private void prueba() {
    }
}
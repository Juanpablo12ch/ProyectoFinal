package com.example.app3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
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

import java.security.Key;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MainActivity2 extends AppCompatActivity {

    TextView rDatos, name,db;
    int num;

   // ProgressBar mProgress = findViewById(R.id.progressBar);
    RequestQueue prueba;
    ImageView img;
    private static final String URL1 = "https://run.mocky.io/v3/ca53df7b-780e-4481-81ed-aab13e8f8730";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        num = (int) (Math.random()*3);
        prueba = Volley.newRequestQueue(this);
        //String url ="http://www.google.com";
        rDatos = findViewById(R.id.datos);
        db = findViewById(R.id.db);
        name = findViewById(R.id.parametro);
        name.setMovementMethod(new ScrollingMovementMethod());

        img = findViewById(R.id.amarillo);



       Bundle recibeDatos = getIntent().getExtras();
        int valor = recibeDatos.getInt("id");

        if(valor == 1){
            metodoGet();
        }else if(valor == 2){
           // metodoGet();
            metodoPost();
        }else if(valor == 3){
            metodoDelete();
        }else {
            metodoPut();
        }


    //   rDatos.setText(info);

        // initUI();
        //stringRequest();
        //obtener();
      //  metodoGet();
       // metodoPost();
        //metodoPut();
        //metodoDelete();
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

    private void metodoGet() {
       // String url = "https://invessoft.com/api/eventos";
        String url = "https://run.mocky.io/v3/5b8e5114-2a07-4215-98ec-9b6f018c1b51";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray nConsulta = response.getJSONArray("mediciones");
                 //   for (int i = 0; i < nConsulta.length(); i++) {
                        JSONObject nObjeto = nConsulta.getJSONObject(num);
                        if(num==1){
                            name.append("Id: " + nObjeto.getString("id_evento") + "\n\n");
                            name.append("Nombre: " + nObjeto.getString("nombre") + "\n\n");
                            name.append("Medición: " + nObjeto.getString("nivel") + "\n\n");
                            img.setImageResource(R.drawable.tarjetaamarilla);
                        }else if(num==2){
                            name.append("Id: " + nObjeto.getString("id_evento") + "\n\n");
                            name.append("Nombre: " + nObjeto.getString("nombre") + "\n\n");
                            name.append("Medición: " + nObjeto.getString("nivel") + "\n\n");
                            img.setImageResource(R.drawable.cancelar);
                        }else if(num==0){
                            name.append("Id: " + nObjeto.getString("id_evento") + "\n\n");
                            name.append("Nombre: " + nObjeto.getString("nombre") + "\n\n");
                            name.append("Medición: " + nObjeto.getString("nivel") + "\n\n");
                            img.setImageResource(R.drawable.si);
                        }
                    //mProgress.setVisibility(View.INVISIBLE);
                        // String id = nObjeto.getString("id_evento");
                        // String nombre_ev = nObjeto.getString("nombre_evento");

                        //name.setText(id);
                     //   name.append("Id: " + nObjeto.getString("id_evento") + "\n\n");
                      //  name.append("Nombre: " + nObjeto.getString("nombre") + "\n\n");
                       // name.append("Medición: " + nObjeto.getString("nivel") + "\n\n");
                       // name.append("Fecha fin: " + nObjeto.getString("fecha_fin") + "\n\n");
                       // name.append("Nombre imagen: " + nObjeto.getString("nombre_imagen") + "\n\n");
                       // name.append("Ruta imagen: " + nObjeto.getString("ruta_imagen") + "\n\n");
                       // name.append("---------------------------------------" + "\n");
                        // Toast.makeText(MainActivity2.this, "ID: " + id + "Nombre:" + nombre_ev, Toast.LENGTH_SHORT).show();
                   // }
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



    private void metodoPost() {
    //    String url1 = "https://run.mocky.io/v3/a069aceb-61d6-4c3c-928f-b92133a3581f";
      //  String url2="https://run.mocky.io/v3/d362736e-1400-47be-92f6-89340c62460e";
        //String url3= "https://run.mocky.io/v3/324cf6fe-6489-4a45-8c03-00b4daabae99";

        String url = "https://run.mocky.io/v3/4decaf2c-ed33-4e5d-892a-5ed921d7195b";



        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //met(response);
              //  rDatos.setText(response);
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
                //    db.setText(params.get(value));
                }

                for (Map.Entry<String, String> entry : params.entrySet()) {
                    //System.out.println("clave=" + entry.getKey() + ", valor=" + entry.getValue());
                   db.setText(entry.getValue() + "\n\n");
                }
                    return params;

            }@Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String,String> headers = new HashMap<String, String>();
                headers.put("Content-Type","application/json; charset=utf-8");
                headers.put("abc", "value");
                name.setText("entró");
                for (String value : headers.keySet()) {
                    // System.out.println("Value = " + value);
                       db.setText(headers.get(value));
                }
                return headers;
                //rueba
            }

        };

        prueba.add(request);
    }

    private void metodoDelete(){
        final String url = "https://run.mocky.io/v3/4b4d895c-d610-4b30-9431-d2ec463f0401";
        //comentario
        StringRequest request = new StringRequest(Request.Method.DELETE, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //met(response);
                rDatos.setText(response);
                Toast.makeText(MainActivity2.this, "Datos eliminados. ", Toast.LENGTH_SHORT).show();

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
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String,String> headers = new HashMap<String, String>();
               //headers.put("Content-Type","application/json; charset=utf-8");
                headers.put("nombre_evento", "");
                name.setText("entró");
                for (String value : headers.keySet()) {
                    // System.out.println("Value = " + value);
                   db.setText(value + ":" + headers.get(value));
                }
                return headers;
            }

        };

        prueba.add(request);
    }

    private void metodoPut(){
        Toast.makeText(MainActivity2.this, "No existe el metodo", Toast.LENGTH_SHORT).show();

    }
    public void volver1(View h){

       startActivity(new Intent(MainActivity2.this, MainActivity3.class));

    }





}
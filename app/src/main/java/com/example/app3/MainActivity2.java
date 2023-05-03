package com.example.app3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;
import android.widget.Toast;

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

public class MainActivity2 extends AppCompatActivity {

    TextView rDatos, name;
    RequestQueue prueba;
    private static final String URL1="https://run.mocky.io/v3/ca53df7b-780e-4481-81ed-aab13e8f8730";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        prueba = Volley.newRequestQueue(this);
        //String url ="http://www.google.com";
       //rDatos = findViewById(R.id.parametro);
        name = findViewById(R.id.parametro);
        name.setMovementMethod(new ScrollingMovementMethod());

        Bundle recibeDatos = getIntent().getExtras();
        String info = recibeDatos.getString("keyDatos");

        // rDatos.setText(info);

        // initUI();
        //stringRequest();
        obtener();
    }

    //METODO DE PRIMERA PRUEBA PARA EL MÉTODO GET CON VOLLEY
    //METODO DE PRIMERA PRUEBA PARA EL MÉTODO GET CON VOLLEY
    //METODO DE PRIMERA PRUEBA PARA EL MÉTODO GET CON VOLLEY

    //private void initUI(){
      //  rDatos = findViewById(R.id.textView);
    //}

   /* private void stringRequest(){
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
    }
*/

    //METODO DE PRIMERA PRUEBA PARA EL MÉTODO GET CON VOLLEY
    //METODO DE PRIMERA PRUEBA PARA EL MÉTODO GET CON VOLLEY
    //METODO DE PRIMERA PRUEBA PARA EL MÉTODO GET CON VOLLEY

    private void obtener(){
        String url = "https://invessoft.com/api/eventos";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray nConsulta = response.getJSONArray("eventos");
                    for(int i=0; i<nConsulta.length(); i++) {
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
                    }catch (JSONException e){
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
}
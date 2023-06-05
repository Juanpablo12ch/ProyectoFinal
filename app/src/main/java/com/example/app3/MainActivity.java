package com.example.app3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    EditText user, pass, datos;
    CheckBox acept;
    Button btnLogin;
    RadioButton ok;

    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();

        user = findViewById(R.id.user);
        pass = findViewById(R.id.pass);
        btnLogin = findViewById(R.id.btnLogin);
        acept = findViewById(R.id.checkBox);
        ok = findViewById(R.id.radioButton);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                String usuario = user.getText().toString();
                String contra = pass.getText().toString();
                firebaseAuth.createUserWithEmailAndPassword(usuario, contra).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Bundle enviaDatos = new Bundle();
                                enviaDatos.putString("keyDatos", user.getText().toString());



                                Intent intent = new Intent(MainActivity.this, MainActivity3.class);
                                intent.putExtras(enviaDatos);
                                intent.addFlags(intent.FLAG_ACTIVITY_CLEAR_TASK | intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(intent);
                                Toast.makeText(MainActivity.this, "Accediendo", Toast.LENGTH_LONG).show();
                                finish();
                            }else{
                                Toast.makeText(MainActivity.this, "Incorrecto", Toast.LENGTH_LONG).show();
                            }
                    }
                });

               /* if(user.getText().toString().equals("Juan") && pass.getText().toString().equals("1234")
                && acept.isChecked() && ok.isChecked()){

                    Bundle enviaDatos = new Bundle();
                    enviaDatos.putString("keyDatos", user.getText().toString());



                    Intent intent = new Intent(MainActivity.this, MainActivity3.class);
                    intent.putExtras(enviaDatos);
                    intent.addFlags(intent.FLAG_ACTIVITY_CLEAR_TASK | intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    Toast.makeText(MainActivity.this, "Accediendo", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity.this, "Incorrecto", Toast.LENGTH_LONG).show();
                }*/
            }
        });
    }

    public void showAlertDialog (View v){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("¿Estás seguro qué deseas salir?");
        alert.setMessage("Perderás todos los datos ingresados.");
        alert.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               // Toast.makeText(MainActivity.this, "¡Vuelve pronto!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               // Toast.makeText(MainActivity.this, "¡Buen trabajo!", Toast.LENGTH_SHORT).show();
                dialog.cancel();
            }
        });
        alert.create().show();

    }

    public void navegar(View h){
        Intent ir = new Intent(this, MainActivity3.class);
        ir.addFlags(ir.FLAG_ACTIVITY_CLEAR_TASK | ir.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(ir);

    }

    public void navegar1(View h){
        Intent ir = new Intent(this, MainActivity4.class);
        ir.addFlags(ir.FLAG_ACTIVITY_CLEAR_TASK | ir.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(ir);

    }
}
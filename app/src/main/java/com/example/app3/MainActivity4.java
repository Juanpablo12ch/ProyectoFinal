package com.example.app3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity4 extends AppCompatActivity {
    Button btn, btnvolver;
    TextView email, pass;
    String usuario, contra;

    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        firebaseAuth = FirebaseAuth.getInstance();

        btn = findViewById(R.id.btnentrar);
        email =  findViewById(R.id.userlogin);
        pass = findViewById(R.id.passlogin);
        btn = findViewById(R.id.volver3);

        btn = findViewById(R.id.btnentrar);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usuario = email.getText().toString();
                contra = pass.getText().toString();

                if(!usuario.isEmpty()&&!contra.isEmpty()){

                    Toast.makeText(MainActivity4.this, "Accediendo", Toast.LENGTH_LONG).show();
                   loguser();
                }else{
                    Toast.makeText(MainActivity4.this, "Incorrecto", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void loguser(){
        firebaseAuth.signInWithEmailAndPassword(usuario, contra).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Bundle enviaDatos = new Bundle();
                    enviaDatos.putString("keyDatos", email.getText().toString());



                    Intent intent = new Intent(MainActivity4.this, MainActivity3.class);
                    intent.putExtras(enviaDatos);
                    intent.addFlags(intent.FLAG_ACTIVITY_CLEAR_TASK | intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(MainActivity4.this, "Incorrecto", Toast.LENGTH_LONG).show();

                }
            }
        });
    }

    public void volver3(View h){
        startActivity(new Intent(MainActivity4.this, MainActivity3.class));
    }
}
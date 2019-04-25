package com.univalle.proyectofinal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LogInActivity extends AppCompatActivity {

    //int MyScore
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        final TextView user = findViewById(R.id.editText);
        final TextView pass = findViewById(R.id.editText2);
        Button btn = findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE);
                String usuario = user.getText().toString();
                String password = pass.getText().toString();

                SharedPreferences.Editor editor = preferences.edit();
                //preferences.edit().putInt("score",200);
                editor.putString("usuario",usuario);
                editor.putString("contraseña",password);

                editor.commit();

                String user =preferences.getString("usuario","No Existe el usuario");

                Toast.makeText(LogInActivity.this,"Guardado con exito",Toast.LENGTH_SHORT).show();

                Intent nuevo = new Intent(LogInActivity.this,MainActivity.class);
                nuevo.putExtra("Usuario",user);
                startActivity(nuevo);
                finish();

            }
        });
    }
}

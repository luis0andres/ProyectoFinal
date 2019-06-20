package com.univalle.proyectofinal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class LogInActivity extends AppCompatActivity {

    final String URL ="https://d500.epimg.net/cincodias/imagenes/2015/05/08/pyme/1431098283_691735_1431098420_noticia_normal.jpg";
    ImageView imagen;
    //int MyScore
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        imagen = findViewById(R.id.imageView2);
        Button btn = findViewById(R.id.button);
        Picasso.with(getApplicationContext()).load(URL).into(imagen);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE);


                SharedPreferences.Editor editor = preferences.edit();
                //preferences.edit().putInt("score",200);


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

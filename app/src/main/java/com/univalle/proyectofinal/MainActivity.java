package com.univalle.proyectofinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar =(Toolbar) findViewById(R.id.tool);
        setSupportActionBar(toolbar);


        //View micontenido=LayoutInflater.from(this).inflate(R.layout.contenido,null);

       // micontenido.at
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.opc1:
                starservice();
                Toast.makeText(getApplicationContext(),"Servicio Iniciado",Toast.LENGTH_SHORT).show();
                break;
            case R.id.opc2:
                stopservice();
                Toast.makeText(getApplicationContext(),"Servicio Detenido",Toast.LENGTH_SHORT).show();
                break;
            case R.id.opc3:
                Toast.makeText(this, "Ha presionado la opcion 3", Toast.LENGTH_SHORT).show();
                break;
            case R.id.opc4:
                Toast.makeText(this, "Ha presionado la opcion 4", Toast.LENGTH_SHORT).show();
                break;
            case android.R.id.home:
                Toast.makeText(this, "Ha presionado la flechita de atras", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);




    }


    public void starservice()
    {
        Intent intent = new Intent(this,MiServicio.class);
        startService(intent);
    }

    public void stopservice()
    {
        Intent intent = new Intent(this,MiServicio.class);
        stopService(intent);
    }
}

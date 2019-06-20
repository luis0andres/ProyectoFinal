package com.univalle.proyectofinal;

import android.Manifest;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private LinearLayout layout;
    ImageButton nuevo;
    ImageButton tabla1;
    ImageButton tabla2;
    ImageButton tabla3;
    ImageButton tabla4;
    ImageButton tabla5;
    ImageButton tabla6;
    EditText nombre1;
    String nombre;
    String dato1;
    TextView texto1;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onDestroy() {

        if(dato1=="")
        {

        }
        else
        {
            editor.putString("Imagen",dato1);
            //editor.apply();
            editor.commit();
        }

        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(
                    new String[]{
                            Manifest.permission.WRITE_EXTERNAL_STORAGE,
                            Manifest.permission.READ_EXTERNAL_STORAGE,
                    }, 50
            );
        }

        tabla1 = findViewById(R.id.imageButton1);
        tabla2 = findViewById(R.id.imageButton2);
        tabla3 = findViewById(R.id.imageButton3);
        tabla4 = findViewById(R.id.imageButton4);
        tabla5 = findViewById(R.id.imageButton5);
        tabla6 = findViewById(R.id.imageButton6);
        nombre1 = findViewById(R.id.nombre);
        texto1=findViewById(R.id.textView1);
        nuevo = findViewById(R.id.nuevo);
        final View micontenido=LayoutInflater.from(MainActivity.this).inflate(R.layout.contenido,null);

        toolbar =(Toolbar) findViewById(R.id.tool);
        setSupportActionBar(toolbar);
        sharedPreferences= getSharedPreferences("Credenciales", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        String dato=sharedPreferences.getString("Imagen","No Encontrado");


        //if(dato!="No Encontrado") {

            Uri uri = Uri.parse(dato);
            Toast.makeText(MainActivity.this,uri.toString(),Toast.LENGTH_LONG).show();
        tabla1.setImageURI(uri);
        dato1=dato;
        editor.commit();

        //}
        //else
        //{

        //}



        final CharSequence[] items = new CharSequence[2];

        items[0]="Cambiar Imagen";
        items[1]="Cambiar Nombre Del Deposito";

        tabla1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                   // nombre1 = findViewById(R.id.nombre);
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Opciones");
                    builder.setItems(items, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if(which==0)
                            {
                                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                                intent.setType("image/");
                                startActivityForResult(intent.createChooser(intent,"Seleccione la app"),10);
                            }
                            else
                            {
                                AlertDialog.Builder builder2 = new AlertDialog.Builder(MainActivity.this);
                                builder2.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        //nombre1 = findViewById(R.id.nombre);
                                        nombre = nombre1.getText().toString();
                                        texto1.setText(nombre);

                                    }
                                });
                                builder2.setView(micontenido).show();
                            }
                        }
                    }).show();
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    Toast.makeText(getApplicationContext(),
                            "FocusChange: ACTION_UP",
                            Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });





         nuevo.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 //View micontenido=LayoutInflater.from(MainActivity.this).inflate(R.layout.contenido,null);
                 //layout = findViewById(R.id.principal);
                 //layout.addView(micontenido);

             }
         });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(resultCode==RESULT_OK)
        {
            Uri path = data.getData();
            tabla1.setImageURI(path);
            dato1 =path.toString();


        }
        super.onActivityResult(requestCode, resultCode, data);
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

package com.univalle.proyectofinal;

import android.Manifest;
import android.app.Activity;
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
import android.view.ViewGroup;
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
    String dato2;
    String dato3;
    String dato4;
    String dato5;
    String dato6;
    String dato7;
    String dato8;
    String dato9;
    String dato10;
    String dato11;
    String dato12;
    TextView texto1;
    TextView texto2;
    TextView texto3;
    TextView texto4;
    TextView texto5;
    TextView texto6;
    Activity  login;
    Button jaju;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onDestroy() {

        if(dato1=="")
        {

        }
        else
        {
            editor.putString("Imagen1",dato1);
            editor.putString("Nombre1",dato2);
            editor.putString("Imagen2",dato3);
            editor.putString("Nombre2",dato4);
            editor.putString("Imagen3",dato5);
            editor.putString("Nombre3",dato6);
            editor.putString("Imagen4",dato7);
            editor.putString("Nombre4",dato8);
            editor.putString("Imagen5",dato9);
            editor.putString("Nombre5",dato10);
            editor.putString("Imagen6",dato11);
            editor.putString("Nombre6",dato12);

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
        final View micontenido=LayoutInflater.from(MainActivity.this).inflate(R.layout.contenido,null);
        tabla1 = findViewById(R.id.imageButton1);
        tabla2 = findViewById(R.id.imageButton2);
        tabla3 = findViewById(R.id.imageButton3);
        tabla4 = findViewById(R.id.imageButton4);
        tabla5 = findViewById(R.id.imageButton6);
        tabla6 = findViewById(R.id.imageButton5);
        nombre1 = micontenido.findViewById(R.id.nombre);
        texto1=findViewById(R.id.textView1);
        texto2=findViewById(R.id.textView2);
        texto3=findViewById(R.id.textView3);
        texto4=findViewById(R.id.textView4);
        texto5=findViewById(R.id.textView6);
        texto6=findViewById(R.id.textView7);

        nuevo = findViewById(R.id.nuevo);


        texto2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Lista.class);
                startActivity(intent);
            }
        });




        toolbar =(Toolbar) findViewById(R.id.tool);
        setSupportActionBar(toolbar);
        sharedPreferences= getSharedPreferences("Credenciales", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        String img1=sharedPreferences.getString("Imagen1","No Encontrado");
        String nom1 = sharedPreferences.getString("Nombre1","No Find");
        String img2=sharedPreferences.getString("Imagen2","No Encontrado");
        String nom2 = sharedPreferences.getString("Nombre2","No Find");
        String img3=sharedPreferences.getString("Imagen3","No Encontrado");
        String nom3 = sharedPreferences.getString("Nombre3","Deposito3");
        String img4=sharedPreferences.getString("Imagen4","No Encontrado");
        String nom4 = sharedPreferences.getString("Nombre4","Deposito4");
        String img5=sharedPreferences.getString("Imagen5","No Encontrado");
        String nom5 = sharedPreferences.getString("Nombre5","Deposito5");
        String img6=sharedPreferences.getString("Imagen6","No Encontrado");
        String nom6 = sharedPreferences.getString("Nombre6","Deposito6");



        //if(dato!="No Encontrado") {

        Uri uri = Uri.parse(img1);
        Uri uri2 = Uri.parse(img2);
        Uri uri3 = Uri.parse(img3);
        Uri uri4 = Uri.parse(img4);
        Uri uri5 = Uri.parse(img5);
        Uri uri6 = Uri.parse(img6);
        // Toast.makeText(MainActivity.this,uri.toString(),Toast.LENGTH_LONG).show();
        tabla1.setImageURI(uri);
        tabla2.setImageURI(uri2);
        tabla3.setImageURI(uri3);
        tabla4.setImageURI(uri4);
        tabla5.setImageURI(uri5);
        tabla6.setImageURI(uri6);
        texto2.setText(nom2);
        texto1.setText(nom1);
        texto3.setText(nom3);
        texto4.setText(nom4);
        texto5.setText(nom5);
        texto6.setText(nom6);
        dato2=nom1;
        dato4=nom2;
        dato6=nom3;
        dato8=nom4;
        dato10=nom5;
        dato12=nom6;
        dato1=img1;
        dato3=img2;
        dato5=img3;
        dato7=img4;
        dato9=img5;
        dato11=img6;
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
                    final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
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
                                final AlertDialog.Builder builder2 = new AlertDialog.Builder(MainActivity.this);
                                builder2.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        //nombre1 = findViewById(R.id.nombre);
                                        nombre = nombre1.getText().toString();
                                        dato2=nombre;
                                        texto1.setText(nombre);

                                    }
                                });
                                ViewGroup parent = (ViewGroup) micontenido.getParent();
                                if (parent != null) {
                                    parent.removeView(micontenido);
                                }

                                builder2.setView(micontenido).show();
                                //((ViewGroup)micontenido).removeView(micontenido);


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


        tabla2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Opciones");
                builder.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(which==0)
                        {
                            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                            intent.setType("image/");
                            startActivityForResult(intent.createChooser(intent,"Seleccione la app"),20);
                        }
                        else
                        {
                            final AlertDialog.Builder builder2 = new AlertDialog.Builder(MainActivity.this);
                            builder2.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    //nombre1 = findViewById(R.id.nombre);
                                    nombre = nombre1.getText().toString();
                                    dato4=nombre;
                                    texto2.setText(nombre);

                                }
                            });
                            ViewGroup parent = (ViewGroup) micontenido.getParent();
                            if (parent != null) {
                                parent.removeView(micontenido);
                            }

                            builder2.setView(micontenido).show();
                            //((ViewGroup)micontenido).removeView(micontenido);


                        }
                    }

                }).show();
            }
        });


        tabla3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Opciones");
                builder.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(which==0)
                        {
                            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                            intent.setType("image/");
                            startActivityForResult(intent.createChooser(intent,"Seleccione la app"),30);
                        }
                        else
                        {
                            final AlertDialog.Builder builder2 = new AlertDialog.Builder(MainActivity.this);
                            builder2.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    //nombre1 = findViewById(R.id.nombre);
                                    nombre = nombre1.getText().toString();
                                    dato6=nombre;
                                    texto3.setText(nombre);

                                }
                            });
                            ViewGroup parent = (ViewGroup) micontenido.getParent();
                            if (parent != null) {
                                parent.removeView(micontenido);
                            }

                            builder2.setView(micontenido).show();
                            //((ViewGroup)micontenido).removeView(micontenido);


                        }
                    }

                }).show();
            }
        });

        tabla4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Opciones");
                builder.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(which==0)
                        {
                            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                            intent.setType("image/");
                            startActivityForResult(intent.createChooser(intent,"Seleccione la app"),40);
                        }
                        else
                        {
                            final AlertDialog.Builder builder2 = new AlertDialog.Builder(MainActivity.this);
                            builder2.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    //nombre1 = findViewById(R.id.nombre);
                                    nombre = nombre1.getText().toString();
                                    dato8=nombre;
                                    texto5.setText(nombre);

                                }
                            });
                            ViewGroup parent = (ViewGroup) micontenido.getParent();
                            if (parent != null) {
                                parent.removeView(micontenido);
                            }

                            builder2.setView(micontenido).show();
                            //((ViewGroup)micontenido).removeView(micontenido);


                        }
                    }

                }).show();
            }
        });


        tabla5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Opciones");
                builder.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(which==0)
                        {
                            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                            intent.setType("image/");
                            startActivityForResult(intent.createChooser(intent,"Seleccione la app"),50);
                        }
                        else
                        {
                            final AlertDialog.Builder builder2 = new AlertDialog.Builder(MainActivity.this);
                            builder2.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    //nombre1 = findViewById(R.id.nombre);
                                    nombre = nombre1.getText().toString();
                                    dato10=nombre;
                                    texto5.setText(nombre);

                                }
                            });
                            ViewGroup parent = (ViewGroup) micontenido.getParent();
                            if (parent != null) {
                                parent.removeView(micontenido);
                            }

                            builder2.setView(micontenido).show();
                            //((ViewGroup)micontenido).removeView(micontenido);


                        }
                    }

                }).show();
            }
        });

        tabla6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Opciones");
                builder.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(which==0)
                        {
                            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                            intent.setType("image/");
                            startActivityForResult(intent.createChooser(intent,"Seleccione la app"),60);
                        }
                        else
                        {
                            final AlertDialog.Builder builder2 = new AlertDialog.Builder(MainActivity.this);
                            builder2.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    //nombre1 = findViewById(R.id.nombre);
                                    nombre = nombre1.getText().toString();
                                    dato12=nombre;
                                    texto6.setText(nombre);

                                }
                            });
                            ViewGroup parent = (ViewGroup) micontenido.getParent();
                            if (parent != null) {
                                parent.removeView(micontenido);
                            }

                            builder2.setView(micontenido).show();
                            //((ViewGroup)micontenido).removeView(micontenido);


                        }
                    }

                }).show();
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
        if(resultCode==RESULT_OK&&requestCode==10)
        {
            Uri path = data.getData();
            tabla1.setImageURI(path);
            dato1 =path.toString();


        }
        else
        {
            if(resultCode==RESULT_OK&&requestCode==20)
            {
                Uri path = data.getData();
                tabla2.setImageURI(path);
                dato3 =path.toString();
            }
            else
            {
                if(resultCode==RESULT_OK&&requestCode==30)
                {
                    Uri path = data.getData();
                    tabla3.setImageURI(path);
                    dato5 =path.toString();
                }
                else
                {
                    if(resultCode==RESULT_OK&&requestCode==40)
                    {
                        Uri path = data.getData();
                        tabla4.setImageURI(path);
                        dato7 =path.toString();
                    }
                    else
                    {
                        if(resultCode==RESULT_OK&&requestCode==50)
                        {
                            Uri path = data.getData();
                            tabla5.setImageURI(path);
                            dato9 =path.toString();
                        }
                        else
                        {
                            Uri path = data.getData();
                            tabla6.setImageURI(path);
                            dato11 =path.toString();
                        }
                    }
                }
            }
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

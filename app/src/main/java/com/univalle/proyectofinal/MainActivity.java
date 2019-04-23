package com.univalle.proyectofinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar tool = findViewById(R.id.toolbar2);

        setSupportActionBar(tool);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public boolean OnCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu,menu);
        return  true;
    }

    public boolean OnOptionsItemSelected(MenuItem menuItem)
    {
        switch (menuItem.getItemId())
        {
            case R.id.opc1:
                Toast.makeText(this,"Ha presionado la opcion 1",Toast.LENGTH_SHORT);
                break;
            case R.id.opc2:
                Toast.makeText(this,"Ha presionado la opcion 2",Toast.LENGTH_SHORT);
                break;
            case R.id.opc3:
                Toast.makeText(this,"Ha presionado la opcion 3",Toast.LENGTH_SHORT);
                break;
            case R.id.opc4:
                Toast.makeText(this,"Ha presionado la opcion 4",Toast.LENGTH_SHORT);
                break;
            case android.R.id.home:
                Toast.makeText(this,"Ha presionado la flechita de atras",Toast.LENGTH_SHORT);
                break;

        }
        return true;
    }


}

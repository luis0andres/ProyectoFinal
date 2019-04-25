package com.univalle.proyectofinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar =(Toolbar) findViewById(R.id.tool);
        setSupportActionBar(toolbar);
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
                Toast.makeText(this, "Ha presionado la opcion 1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.opc2:
                Toast.makeText(this, "Ha presionado la opcion 2", Toast.LENGTH_SHORT).show();
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
}

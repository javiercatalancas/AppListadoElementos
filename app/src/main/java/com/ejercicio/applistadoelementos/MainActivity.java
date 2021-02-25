package com.ejercicio.applistadoelementos;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List <Listado> listado = new ArrayList<>();
    MyAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();

        if(actionBar !=null){
            actionBar.setTitle("Lista de la compra");
        }


        // llamamos a la vista recycler en el layout
        RecyclerView vistarecycler = findViewById(R.id.vistarecycler);

        // el llm es un manager para gestionar las propiedades de la vista y demás
        LinearLayoutManager llm = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        vistarecycler.setLayoutManager(llm);

        // Crear un divisor

        Drawable drawable = ContextCompat.getDrawable(MainActivity.this, R.drawable.divisor);
        DividerItemDecoration divider = new DividerItemDecoration(MainActivity.this, llm.getOrientation());
        divider.setDrawable(drawable);
        vistarecycler.addItemDecoration(divider);


        adapter = new MyAdapter(this, listado);
        vistarecycler.setAdapter(adapter);

        Button addbutton = findViewById(R.id.addboton);

        // CON ESTO ABRO LA SEGUNDA ACTIVIDAD CON ESPERA DE RESULTADOS (FOR RESULT)
        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, SecondActivity.class );
                startActivityForResult(intent, 77);


            }


        });

       Button borrartodo = findViewById(R.id.deleteboton);

       borrartodo.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               adapter.clearAll();
           }
       });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        switch (id){
            case R.id.addboton:
                Intent intent = new Intent(MainActivity.this, SecondActivity.class );
                startActivityForResult(intent, 77);
                return true;

            case R.id.removeboton:
                adapter.clearAll();
                return true;
        }

        return super.onOptionsItemSelected(item);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // CON ESTO RECIBO LOS DATOS DE LA SEGUNDA ACTIVIDAD
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==77){
            if(resultCode==RESULT_OK){
                if (data!=null){
                    String nombre = data.getStringExtra("nombre");
                    String cantidad = data.getStringExtra("cantidad");

               //     int cantnum = Integer.parseInt(cantidad);

                    Listado list = new Listado(nombre, Integer.parseInt(cantidad));

                    listado.add(list);
                    adapter.notifyItemInserted(listado.size());
                } else if (resultCode==MainActivity.RESULT_CANCELED){
                    Toast.makeText(this, "INTRODUCE DATOS", Toast.LENGTH_SHORT).show();
                }
            }
        }

    }
}
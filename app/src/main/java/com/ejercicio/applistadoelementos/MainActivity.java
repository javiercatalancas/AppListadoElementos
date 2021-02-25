package com.ejercicio.applistadoelementos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> listado = new ArrayList<>();


        listado.add("fulano");
        listado.add("mengano");
        listado.add("Paquito");

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

        MyAdapter adapter = new MyAdapter(MainActivity.this, listado);
        vistarecycler.setAdapter(adapter);

        Button addbutton = findViewById(R.id.addboton);

        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, SecondActivity.class );
                startActivity(intent);

               /*
                String persona = new String("francisco");
               // adapter.add(listado.size(), persona);

                vistarecycler.scrollToPosition(listado.size()-1);
                */

             // Nos lleva a la segunda pantalla para añadir el texto que luego se mostrará en esta pantalla


            }
        });




    }
}
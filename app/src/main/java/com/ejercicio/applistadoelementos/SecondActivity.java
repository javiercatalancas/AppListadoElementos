package com.ejercicio.applistadoelementos;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;

import com.google.android.material.textfield.TextInputEditText;

public class SecondActivity extends MainActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        Button add = findViewById(R.id.add);
        TextInputEditText nombre = findViewById(R.id.textnombre);
        TextInputEditText cantidad = findViewById(R.id.textcantidad);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String textnombre = nombre.getText().toString();
                String textcantidad = cantidad.getText().toString();

                Intent intent2 = new Intent();
                intent2.putExtra("cantidad", textcantidad);
                intent2.putExtra("nombre", textnombre);

                setResult(RESULT_OK, intent2);
                finish();

            }
        });

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Añadir producto");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            setResult(RESULT_CANCELED);
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

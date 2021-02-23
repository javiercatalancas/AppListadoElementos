package com.ejercicio.applistadoelementos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter {

    // Creamos el listado

    private List<String> listado; // este listado luego al main activity
    private Context contexto;

    // CONSTRUCTOR DEL ADAPTER, context (actividad donde se va a mostrar) + listado

    public MyAdapter (Context contexto, List<String>listado){
        this.contexto= contexto;
        this.listado = listado;
    }





    class holder1 extends RecyclerView.ViewHolder{
// AQUI CREAMOS LOS ELEMENTOS DEL HOLDER
        TextView text1;
        TextView text2;
        public holder1(@NonNull View itemView) {
            super(itemView);
            text1 = itemView.findViewById(R.id.textView2);
            text2 = itemView.findViewById(R.id.textView3);

        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewholder = LayoutInflater.from(contexto).inflate(R.layout.holder1_layout,parent, false);
        holder1 holderback = new holder1(viewholder);
        return holderback;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        String texto = listado.get(position);
        holder1 holderback = (holder1) holder;
        holderback.text1.setText(texto);

    }

    @Override
    public int getItemCount() {
        return listado.size();
    }
}

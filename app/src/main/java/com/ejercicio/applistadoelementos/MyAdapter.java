package com.ejercicio.applistadoelementos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    // Creamos el listado

    private List<Listado> listado; // este listado luego al main activity
    private Context contexto;

    // CONSTRUCTOR DEL ADAPTER, context (actividad donde se va a mostrar) + listado

    public MyAdapter (Context contexto, List<Listado>listado){
        this.contexto= contexto;
        this.listado = listado;
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        // AQUI CREAMOS LOS ELEMENTOS DEL HOLDER
      public TextView text1;
      public TextView text2;
      public ImageView delete;
      public TextView getText1(){
          return text1;
      }


        public MyHolder(@NonNull View itemView) {
            super(itemView);
            text1 = itemView.findViewById(R.id.textotoast);
            text2 = itemView.findViewById(R.id.numerotoast);
            delete =itemView.findViewById(R.id.borrar);
        }
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(contexto).inflate(R.layout.holder1_layout,parent, false);
        MyHolder myHolder = new MyHolder(v);
        return myHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyHolder myHolder = (MyHolder) holder;
        Listado producto = listado.get(position);
        myHolder.text1.setText(producto.getNombre());
        myHolder.text2.setText(String.valueOf(producto.getCantidad()));
        myHolder.text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(contexto, myHolder.text1.getText(), Toast.LENGTH_SHORT).show();
            }
        });

        myHolder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                remove(myHolder.getAdapterPosition());
            }
        });

        }

    @Override
    public int getItemCount() {
        return listado.size();
    }

    public void add(int position, Listado item){
        listado.add(position, item);
        notifyItemInserted(position);
    }

    public void add(Listado item){
        listado.add(item);
        notifyDataSetChanged();
    }

    public void remove(int position){
        listado.remove(position);
        notifyItemRemoved(position);
    }

    public void update(List<Listado> datos){
        listado.clear();
        listado =datos;
        notifyDataSetChanged();
    }

    public void clearAll(){
        listado.clear();
        notifyDataSetChanged();
    }


}

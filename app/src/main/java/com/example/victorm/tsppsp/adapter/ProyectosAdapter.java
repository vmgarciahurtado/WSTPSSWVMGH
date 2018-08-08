package com.example.victorm.tsppsp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.victorm.tsppsp.R;
import com.example.victorm.tsppsp.entidades.ProyectosVo;

import java.util.ArrayList;

public class ProyectosAdapter extends RecyclerView.Adapter<ProyectosAdapter.proyectosHolder> {

    ArrayList<ProyectosVo>listaProyectos;

    public ProyectosAdapter(ArrayList<ProyectosVo> listaProyectos) {
        this.listaProyectos = listaProyectos;
    }

    @Override
    public proyectosHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.modelo_proyectos_adapter,null,false);
        return new proyectosHolder(view);
    }

    @Override
    public void onBindViewHolder(proyectosHolder holder, int position) {
        holder.campoNombre.setText(listaProyectos.get(position).getNombre());
    }

    @Override
    public int getItemCount() {
        return listaProyectos.size();
    }

    public class proyectosHolder extends RecyclerView.ViewHolder {

        TextView campoNombre;
        public proyectosHolder(View itemView) {
            super(itemView);
            campoNombre = itemView.findViewById(R.id.nombreProyectoModelo);
        }
    }
}

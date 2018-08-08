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

public class ProyectosAdapter extends RecyclerView.Adapter<ProyectosAdapter.proyectosHolder> implements View.OnClickListener {

    ArrayList<ProyectosVo>listaProyectos;
    View.OnClickListener listener;

    public ProyectosAdapter(ArrayList<ProyectosVo> listaProyectos) {
        this.listaProyectos = listaProyectos;
    }

    @Override
    public proyectosHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.modelo_proyectos_adapter,null,false);
        view.setOnClickListener(this);
        return new proyectosHolder(view);
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onBindViewHolder(proyectosHolder holder, int position) {
        holder.campoNombre.setText(listaProyectos.get(position).getNombre());
    }

    @Override
    public int getItemCount() {
        return listaProyectos.size();
    }

    @Override
    public void onClick(View v) {
        if (listener != null){
            listener.onClick(v);
        }
    }

    public class proyectosHolder extends RecyclerView.ViewHolder {

        TextView campoNombre;
        public proyectosHolder(View itemView) {
            super(itemView);
            campoNombre = itemView.findViewById(R.id.nombreProyectoModelo);
        }
    }
}

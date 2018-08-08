package com.example.victorm.tsppsp.principal;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.victorm.tsppsp.R;
import com.example.victorm.tsppsp.adapter.ProyectosAdapter;
import com.example.victorm.tsppsp.entidades.ProyectosVo;
import com.example.victorm.tsppsp.utilidades.Conexion;
import com.example.victorm.tsppsp.utilidades.Datos;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db;
    Conexion conn;
    EditText campoNombre;
    Button btnRegistrarProyecto;
    RecyclerView recyclerViewProyectos;
    ProyectosAdapter adapter;
    ArrayList<ProyectosVo>listaProyectos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //////
        conn = new Conexion(getApplicationContext(),"db_proyectos",null,1);
        recyclerViewProyectos = findViewById(R.id.recyclerProyectos);
        recyclerViewProyectos.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerViewProyectos.setHasFixedSize(true);
        //////

        consultarProyectos();
        campoNombre = findViewById(R.id.campoRegistrarProyecto);
        btnRegistrarProyecto = findViewById(R.id.btnRegistrarProyecto);
        btnRegistrarProyecto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarProyecto();

            }
        });
    }

    private void consultarProyectos() {

            SQLiteDatabase db=conn.getReadableDatabase();
            listaProyectos=new ArrayList<>();
            ProyectosVo proyectosVo=null;

            Cursor cursor=db.rawQuery("SELECT * FROM "+ Datos.TABLA_PROYECTOS ,null);
            while (cursor.moveToNext()){
                proyectosVo=new ProyectosVo();
                proyectosVo.setNombre(cursor.getString(0));
                listaProyectos.add(proyectosVo);
            }

        adapter = new ProyectosAdapter(listaProyectos);
        recyclerViewProyectos.setAdapter(adapter);
        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(),"Seleccion: " +listaProyectos.get(recyclerViewProyectos.getChildAdapterPosition(v)).getNombre(),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this,Principal.class);
                Bundle miBundle = new Bundle();
                String dato = listaProyectos.get(recyclerViewProyectos.getChildAdapterPosition(v)).getNombre();
                miBundle.putString("nombre",dato);
                intent.putExtra("datos",miBundle);
                startActivity(intent);

            }
        });

    }

    private void registrarProyecto() {
        SQLiteDatabase db=conn.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(Datos.CAMPO_NOMBRE,campoNombre.getText().toString());
        Long resultado=db.insert(Datos.TABLA_PROYECTOS,Datos.CAMPO_NOMBRE,values);
        db.close();
        consultarProyectos();
        campoNombre.setText("");
        Toast.makeText(getApplicationContext(),"¡¡ Registro exitoso !!",Toast.LENGTH_SHORT).show();
    }



}

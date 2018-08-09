package com.example.victorm.tsppsp.principal;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.victorm.tsppsp.R;

public class Principal extends AppCompatActivity {
    String titulo;
    TextView tituloProyecto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        tituloProyecto = findViewById(R.id.tituloProyeto);
        Bundle miBundle = this.getIntent().getBundleExtra("datos");
        //Toast.makeText(getApplicationContext(),"dato" + miBundle.getString("nombre"),Toast.LENGTH_SHORT).show();
        if (miBundle != null){
             titulo = miBundle.getString("nombre");
        }

        tituloProyecto.setText(titulo);
    }

    public void project(View view) {
        Bundle miBundle = new Bundle();
        Intent intent = new Intent(getApplicationContext(),Secundaria.class);
        switch (view.getId()){
            case R.id.btnProject:
                //miBundle.putInt("pantalla",1);
                //intent.putExtra("glass",miBundle);
                //startActivity(intent);
                Intent intent2 = new Intent(getApplicationContext(),Main2Activity.class);
                startActivity(intent2);
                break;
            case R.id.btnDefectlog:
                miBundle.putInt("pantalla",2);
                intent.putExtra("glass",miBundle);
                startActivity(intent);
                break;
            case R.id.btnTimeLog:
                miBundle.putInt("pantalla",3);
                intent.putExtra("glass",miBundle);
                startActivity(intent);
                break;
        }
    }
}

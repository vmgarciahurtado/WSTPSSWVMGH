package com.example.victorm.tsppsp.principal;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.victorm.tsppsp.R;
import com.example.victorm.tsppsp.entidades.AllFragments;
import com.example.victorm.tsppsp.fragments.DefectLog;
import com.example.victorm.tsppsp.fragments.ProjectPlanSumary;
import com.example.victorm.tsppsp.fragments.TimeLog;

public class Secundaria extends AppCompatActivity implements AllFragments{
    Fragment miFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secundaria);
        Bundle miBundle = this.getIntent().getBundleExtra("glass");

        switch (miBundle.getInt("pantalla")){
            case 1:
                miFragment = new ProjectPlanSumary();
                getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,miFragment).commit();
                break;

            case 2:
                miFragment = new DefectLog();
                getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,miFragment).commit();
                break;

            case 3:
                miFragment = new TimeLog();
                getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,miFragment).commit();
                break;
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}

package com.example.victorm.tsppsp.entidades;

import com.example.victorm.tsppsp.fragments.DefectLog;
import com.example.victorm.tsppsp.fragments.FragmentOpciones;
import com.example.victorm.tsppsp.fragments.ProjectPlanSumary;
import com.example.victorm.tsppsp.fragments.TimeLog;

public interface AllFragments extends
        FragmentOpciones.OnFragmentInteractionListener,
        DefectLog.OnFragmentInteractionListener,
        TimeLog.OnFragmentInteractionListener,
        ProjectPlanSumary.OnFragmentInteractionListener {
}

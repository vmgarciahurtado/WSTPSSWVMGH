package com.example.victorm.tsppsp.entidades;

import com.example.victorm.tsppsp.fragments.DefectLog;
import com.example.victorm.tsppsp.fragments.FragmentOpciones;
import com.example.victorm.tsppsp.fragments.ProjectPlanSumary;
import com.example.victorm.tsppsp.fragments.TimeLog;
import com.example.victorm.tsppsp.tabed.DefectInjectedInPhase;
import com.example.victorm.tsppsp.tabed.DefectsRemoveInPhase;
import com.example.victorm.tsppsp.tabed.TimeinPhase;

public interface AllFragments extends
        FragmentOpciones.OnFragmentInteractionListener,
        DefectLog.OnFragmentInteractionListener,
        TimeLog.OnFragmentInteractionListener,
        ProjectPlanSumary.OnFragmentInteractionListener,DefectInjectedInPhase.OnFragmentInteractionListener,DefectsRemoveInPhase.OnFragmentInteractionListener,TimeinPhase.OnFragmentInteractionListener {
}

package com.example.victorm.tsppsp.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.victorm.tsppsp.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DefectLog.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DefectLog#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DefectLog extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    String type;
    String phaseInjected;
    String phaseRemoved;

    Button btnDate,btnRegistrar,btnStart,btnStop,btnRestart;
    TextView campoDate;
    EditText txtDefectDescription;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhaseInjected() {
        return phaseInjected;
    }

    public void setPhaseInjected(String phaseInjected) {
        this.phaseInjected = phaseInjected;
    }

    public String getPhaseRemoved() {
        return phaseRemoved;
    }

    public void setPhaseRemoved(String phaseRemoved) {
        this.phaseRemoved = phaseRemoved;
    }

    ArrayList<String>ArrayType;
    ArrayList<String>ArrayPhaseInjected;
    ArrayList<String>ArrayPhaseRemoved;

    Spinner listaType;
    Spinner listaPhaseRemoved;
    Spinner listaPhaseInjected;
    public DefectLog() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DefectLog.
     */
    // TODO: Rename and change types and number of parameters
    public static DefectLog newInstance(String param1, String param2) {
        DefectLog fragment = new DefectLog();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_defect_log, container, false);

        ArrayType = new ArrayList<>();
        ArrayType.add("Type");
        ArrayType.add("Documentation");
        ArrayType.add("Syntax");
        ArrayType.add("Build");
        ArrayType.add("Package");
        ArrayType.add("Assigment");
        ArrayType.add("Interface");
        ArrayType.add("Checking");
        ArrayType.add("Data");
        ArrayType.add("Funtion");
        ArrayType.add("System");
        ArrayType.add("Environment");

        ArrayPhaseInjected = new ArrayList<>();
        ArrayPhaseInjected.add("Phase injected");
        ArrayPhaseInjected.add("PLAN");
        ArrayPhaseInjected.add("DLD");
        ArrayPhaseInjected.add("CODE");
        ArrayPhaseInjected.add("COMPILE");
        ArrayPhaseInjected.add("UT");
        ArrayPhaseInjected.add("PM");

        ArrayPhaseRemoved = new ArrayList<>();
        ArrayPhaseRemoved.add("Phase removed");
        ArrayPhaseRemoved.add("PLAN");
        ArrayPhaseRemoved.add("DLD");
        ArrayPhaseRemoved.add("CODE");
        ArrayPhaseRemoved.add("COMPILE");
        ArrayPhaseRemoved.add("UT");
        ArrayPhaseRemoved.add("PM");

        listaType = vista.findViewById(R.id.spinnerType);
        ArrayAdapter<CharSequence> adapterType = new ArrayAdapter(getContext(),R.layout.support_simple_spinner_dropdown_item,ArrayType);
        listaType.setAdapter(adapterType);
        listaType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0){
                    setType(ArrayType.get(position));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        listaPhaseInjected = vista.findViewById(R.id.spinnerPhaseInjected);
        ArrayAdapter<CharSequence> adapterPhaseInjected = new ArrayAdapter(getContext(), R.layout.support_simple_spinner_dropdown_item,ArrayPhaseInjected);
        listaPhaseInjected.setAdapter(adapterPhaseInjected);
        listaPhaseInjected.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0){
                    setPhaseInjected(ArrayPhaseInjected.get(position));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        listaPhaseRemoved = vista.findViewById(R.id.spinnerPhaseRemoved);
        ArrayAdapter<CharSequence> adapterPhaseRemoved = new ArrayAdapter(getContext(), R.layout.support_simple_spinner_dropdown_item,ArrayPhaseRemoved);
        listaPhaseRemoved.setAdapter(adapterPhaseRemoved);
        listaPhaseRemoved.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0){
                    setPhaseRemoved(ArrayPhaseRemoved.get(position));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        btnDate = vista.findViewById(R.id.btnDateDefectlog);
        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
                Date date = new Date();
                String fecha = dateFormat.format(date);
                campoDate.setText(fecha);
            }
        });
        btnStart = vista.findViewById(R.id.btnStartDefectlog);
        btnStop = vista.findViewById(R.id.btnStopDefectlog);
        btnRestart = vista.findViewById(R.id.btnRestartDefectlog);

        campoDate = vista.findViewById(R.id.campoDateDefectlog);

        return vista;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}

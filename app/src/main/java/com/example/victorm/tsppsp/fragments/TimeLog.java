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
 * {@link TimeLog.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TimeLog#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TimeLog extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    String fase;



    ////////
    Button btnCapturarprimeraFechaTL,btnCapturarSegundaFechaTl,btnRegistrarTimelog;
    TextView txtPrimeraFechaTl,txtSegundaFechaTl,txtDeltaTl;



    public String getFase() {
        return fase;
    }

    public void setFase(String fase) {
        this.fase = fase;
    }

    ArrayList<String>ArrayFase;
    Spinner listaFases;

    public TimeLog() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TimeLog.
     */
    // TODO: Rename and change types and number of parameters
    public static TimeLog newInstance(String param1, String param2) {
        TimeLog fragment = new TimeLog();
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
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_time_log, container, false);
        ArrayFase = new ArrayList<>();
        ArrayFase.add("Phase");
        ArrayFase.add("PLAN");
        ArrayFase.add("DLD");
        ArrayFase.add("CODE");
        ArrayFase.add("COMPILE");
        ArrayFase.add("UT");
        ArrayFase.add("PM");

        listaFases = vista.findViewById(R.id.spinnerFase);
        ArrayAdapter<CharSequence> adapterFase = new ArrayAdapter(getContext(), R.layout.support_simple_spinner_dropdown_item, ArrayFase);
        listaFases.setAdapter(adapterFase);
        listaFases.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0){
                    setFase(ArrayFase.get(position));
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        btnCapturarprimeraFechaTL = vista.findViewById(R.id.btnStartTimeLog);
        btnCapturarprimeraFechaTL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
                Date date = new Date();
                String fecha = dateFormat.format(date);
                txtPrimeraFechaTl.setText(fecha);
            }
        });

        btnCapturarSegundaFechaTl = vista.findViewById(R.id.btnStopTimeLog);
        btnCapturarSegundaFechaTl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
                Date date = new Date();
                String fecha = dateFormat.format(date);
                txtSegundaFechaTl.setText(fecha);
                txtDeltaTl.setText("0000000");
            }
        });
        btnRegistrarTimelog = vista.findViewById(R.id.btnRegistrarTimeLog);

        txtPrimeraFechaTl = vista.findViewById(R.id.campoStartTimelog);
        txtSegundaFechaTl = vista.findViewById(R.id.campoStopTimelog);
        txtDeltaTl = vista.findViewById(R.id.campoDeltaTimelog);

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

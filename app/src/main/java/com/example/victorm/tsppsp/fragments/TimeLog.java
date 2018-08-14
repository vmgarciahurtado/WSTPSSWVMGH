package com.example.victorm.tsppsp.fragments;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.victorm.tsppsp.R;
import com.example.victorm.tsppsp.utilidades.Conexion;
import com.example.victorm.tsppsp.utilidades.Datos;

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
    String start;
    String stop;
    String interruption;
    String delta;

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getStop() {
        return stop;
    }

    public void setStop(String stop) {
        this.stop = stop;
    }

    public String getInterruption() {
        return interruption;
    }

    public void setInterruption(String interruption) {
        this.interruption = interruption;
    }

    public String getDelta() {
        return delta;
    }

    public void setDelta(String delta) {
        this.delta = delta;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    String comments;

    public int getFecha1() {
        return fecha1;
    }

    public void setFecha1(int fecha1) {
        this.fecha1 = fecha1;
    }

    public int getFecha2() {
        return fecha2;
    }

    public void setFecha2(int fecha2) {
        this.fecha2 = fecha2;
    }

    int fecha1;
    int fecha2;
    int fecha3;

    public int getFecha3() {
        return fecha3;
    }

    public void setFecha3(int fecha3) {
        this.fecha3 = fecha3;
    }

    ////////
    SQLiteDatabase db;
    Conexion conn;

    Button btnCapturarprimeraFechaTL,btnCapturarSegundaFechaTl,btnRegistrarTimelog;
    EditText campoInterruption,campoComentario;
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
        conn = new Conexion(getContext(),"db_proyectos",null,1);

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
                capturarHorasFecha1();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
                Date date = new Date();
                String fecha = dateFormat.format(date);
                setStart(fecha);
                txtPrimeraFechaTl.setText(fecha);
            }
        });

        btnCapturarSegundaFechaTl = vista.findViewById(R.id.btnStopTimeLog);
        btnCapturarSegundaFechaTl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                capturarHorasFecha2();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
                Date date = new Date();
                String fecha = dateFormat.format(date);
                setStop(fecha);
                txtSegundaFechaTl.setText(fecha);

                //txtDeltaTl.setText("0000000");
            }
        });
        btnRegistrarTimelog = vista.findViewById(R.id.btnRegistrarTimeLog);
        btnRegistrarTimelog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarTimelog();
            }
        });
        txtPrimeraFechaTl = vista.findViewById(R.id.campoStartTimelog);
        txtSegundaFechaTl = vista.findViewById(R.id.campoStopTimelog);
        txtDeltaTl = vista.findViewById(R.id.campoDeltaTimelog);
        campoInterruption = vista.findViewById(R.id.txtInterruptionTimelog);
        campoComentario = vista.findViewById(R.id.txtComentarioTimelog);

        return vista;
    }

    private void capturarHorasFecha1() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("mm", Locale.getDefault());
        Date date = new Date();
        String fecha = dateFormat.format(date);
        fecha1 = (Integer.parseInt(fecha));
        Toast.makeText(getContext(),"horas " + fecha1,Toast.LENGTH_LONG).show();
    }

    private void capturarHorasFecha2() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("mm", Locale.getDefault());
        Date date = new Date();
        String fecha = dateFormat.format(date);
        fecha3 = Integer.parseInt(campoInterruption.getText().toString());
        setInterruption(campoInterruption.getText().toString());
        //fecha3 = 1;
        fecha2 = (Integer.parseInt(fecha));
        int calculo = (fecha2-fecha1)-fecha3;
        int calculo2 = (fecha2-fecha1);

        setDelta(String.valueOf(calculo));
        if (fecha3>calculo2){
            Toast.makeText(getContext(),"EL tiempo de interrupcion es mayor al tiempo transcurrido,no se puede calcular el tiempo delta",Toast.LENGTH_LONG).show();
        }else {
            if (calculo>0){
                txtDeltaTl.setText(((String.valueOf(calculo) + "  minutos")));
            }else{
                txtDeltaTl.setText(((String.valueOf(calculo) + "  segundos")));
            }
        }

    }


        private void registrarTimelog() {
            setComments(campoComentario.getText().toString());

            SQLiteDatabase db=conn.getWritableDatabase();
            ContentValues values=new ContentValues();
            values.put(Datos.CAMPO_PHASE,getFase() + Datos.CAMPO_START);
            Long resultado=db.insert(Datos.TABLA_PROYECTOS,Datos.CAMPO_NOMBRE,values);
            db.close();
            Toast.makeText(getContext(),"¡¡ Registro exitoso !!",Toast.LENGTH_SHORT).show();
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

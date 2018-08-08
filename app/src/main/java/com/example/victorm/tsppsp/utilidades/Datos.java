package com.example.victorm.tsppsp.utilidades;

public class Datos {

    public static final String TABLA_TIMELOG = "timelog";
    public static final String CAMPO_PHASE = "phase";
    public static final String CAMPO_START = "start";
    public static final String CAMPO_INTERRUPTION = "interruption";
    public static final String CAMPO_STOP = "stop";
    public static final String CAMPO_DELTA = "delta";
    public static final String CAMPO_COMMENTS = "comments";
    public static final String CREAR_TABLA_TIMELOG = "CREATE TABLE " + " " + TABLA_TIMELOG + "(" + CAMPO_PHASE + " TEXT, " +
            CAMPO_START + " TEXT, " + CAMPO_INTERRUPTION + " TEXT, " + CAMPO_STOP + " TEXT, " + CAMPO_DELTA + " TEXT, " +
            CAMPO_COMMENTS + " TEXT" + " )";


    public static final String TABLA_DEFECTLOG = "defectlog";
    public static final String CAMPO_ESTADO = "estado";
    public static final String CAMPO_DATE = "date";
    public static final String CAMPO_TYPE = "type";
    public static final String CAMPO_PHASEINJECTED = "phaseinjected";
    public static final String CAMPO_PHASEREMOVED = "phaseremoved";
    public static final String CAMPO_FIXTIME = "fixtime";
    public static final String CAMPO_DEFECTDESCRIPTION = "defectdescription";
    public static final String CREAR_TABLA_DEFECTLOG = "CREATE TABLE " + " " + TABLA_DEFECTLOG + "(" + CAMPO_DATE + " TEXT, " +
            CAMPO_TYPE + " TEXT, " + CAMPO_PHASEINJECTED + " TEXT, " + CAMPO_PHASEREMOVED + " TEXT, " + CAMPO_FIXTIME + " TEXT, " +
            CAMPO_DEFECTDESCRIPTION + " TEXT " + " )";


    public static final String TABLA_PROYECTOS = "proyectos";
    public static final String CAMPO_NOMBRE = "nombre";
    public static final String CREAR_TABLA_PROYECTOS = "CREATE TABLE " + " " + TABLA_PROYECTOS + "(" + CAMPO_NOMBRE + " TEXT" + ")";

}

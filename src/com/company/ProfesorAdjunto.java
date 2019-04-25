package com.company;

public class ProfesorAdjunto extends Profesor
{
    Integer horasConsulta;

    public ProfesorAdjunto(String nombre, String apellido, Integer codigo){super(nombre, apellido, codigo); }
    public ProfesorAdjunto(String nombre, String apellido, Integer codigo, Integer horasConsulta){super(nombre, apellido, codigo); this.horasConsulta = horasConsulta; }

    //region Get Sets

    public Integer getHorasConsulta(){return horasConsulta;}
    public void setHorasConsulta(Integer horas){horasConsulta=horas;}

    //endregion

    //region Object Overrides

    @Override
    public String toString()
    { return getNombreCompleto() + " (Adjunto) : " + codigo.toString(); }

    //endregion
}

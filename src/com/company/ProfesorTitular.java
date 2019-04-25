package com.company;

public class ProfesorTitular extends Profesor
{
    String especialidad;

    public ProfesorTitular(String nombre, String apellido, Integer codigo){super(nombre, apellido, codigo); }
    public ProfesorTitular(String nombre, String apellido, Integer codigo, String especialidad){super(nombre, apellido, codigo); this.especialidad = especialidad;}

    //region Get Sets

    public String getEspecialidad(){return especialidad;}
    public void setEspecialidad(String especialidad){this.especialidad=especialidad;}

    //endregion

    //region Object Overrides

    @Override
    public String toString()
    {
        return getNombreCompleto() + " (Titular) : " + codigo.toString();
    }

    //endregion
}

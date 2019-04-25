package com.company;

public class Alumno
{
    String nombre, apellido;
    Integer codigo;

    public Alumno(String nombre, String apellido, Integer codigo)
    {this.nombre=nombre; this.apellido=apellido; this.codigo=codigo;}

    //region Get Sets

    public String getNombre(){return nombre;}
    public void setNombre(String nombre){this.nombre = nombre;}

    public String getApellido(){return apellido;}
    public void setApellido(String apellido){this.apellido=apellido;}

    public Integer getCodigo(){return codigo;}
    public void setCodigo(Integer codigo){this.codigo=codigo;}

    //additional info
    public String getNombreCompleto(){return nombre + " " + apellido;}

    //endregion

    //region Object Overrides

    @Override
    public boolean equals(Object o)
    {
        Alumno a = (Alumno)o;
        return a.getCodigo().equals(this.codigo);
    }

    @Override
    public String toString()
    {
        return getNombreCompleto() + " : " + codigo.toString();
    }

    //endregion

}

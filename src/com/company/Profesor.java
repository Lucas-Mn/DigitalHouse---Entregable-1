package com.company;

public abstract class Profesor
{
    String nombre, apellido;
    Integer codigo, antiguedad;

    public Profesor(String nombre, String apellido, Integer codigo)
    {this.nombre=nombre; this.apellido=apellido; this.codigo=codigo; antiguedad=0;}

    //region Get Sets

    public String getNombre(){return nombre;}
    public void setNombre(String nombre){this.nombre = nombre;}

    public String getApellido(){return apellido;}
    public void setApellido(){this.apellido = apellido;}

    public Integer getCodigo(){return codigo;}
    public void setCodigo(Integer codigo){this.codigo=codigo;}

    public Integer getAntiguedad(){return antiguedad;}
    //public void setAntiguedad(Integer antiguedad){this.antiguedad = antiguedad;}

    //additional info
    public String getNombreCompleto(){return nombre + " " + apellido;}

    //endregion

    //region Object Overrides

    @Override
    public boolean equals(Object o)
    {
        Profesor p = (Profesor)o;
        return p.getCodigo().equals(this.codigo);
    }

    @Override
    public String toString()
    {
        return getNombreCompleto() + " : " + codigo.toString();
    }

    //endregion

}

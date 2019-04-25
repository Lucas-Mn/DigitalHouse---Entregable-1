package com.company;
import java.util.List;
import java.util.ArrayList;

public class Curso
{
    String nombre;
    Integer codigo, maxCupo;

    List<Alumno> alumnos;

    ProfesorTitular profesorTitular;
    ProfesorAdjunto profesorAdjunto;

    public Curso(String nombre, Integer codigo, Integer maxCupo){Construct(nombre, codigo, maxCupo);}
    public Curso(String nombre, Integer codigo, Integer maxCupo, ProfesorTitular profesorTitular, ProfesorAdjunto profesorAdjunto)
        {Construct(nombre, codigo, maxCupo); this.profesorTitular=profesorTitular; this.profesorAdjunto=profesorAdjunto;}

        void Construct(String n, Integer c, Integer mc)
        {
            nombre=n; codigo=c; maxCupo=mc;
            alumnos = new ArrayList<Alumno>();
        }
    //region Get Sets

    public String getNombre(){return nombre;}
    public void setNombre(String nombre){this.nombre=nombre;}

    public Integer getCodigo(){return codigo;}
    public void setCodigo(Integer codigo){this.codigo=codigo;}

    public Integer getMaxCupo(){return maxCupo;}
    public void setMaxCupo(Integer maxCupo){this.maxCupo=maxCupo;}

    public List<Alumno> getAlumnos(){return alumnos;}

    public ProfesorTitular getProfesorTitular(){return profesorTitular;}
    public void setProfesorTitular(ProfesorTitular profesor){profesorTitular=profesor;}

    public ProfesorAdjunto getProfesorAdjunto(){return profesorAdjunto;}
    public void setProfesorAdjunto(ProfesorAdjunto profesor){profesorAdjunto=profesor;}

    //endregion

    //region Info

    public boolean tieneCupo()
    { return (maxCupo - alumnos.size() > 0);}

    //endregion

    //region List Management

    public boolean agregarUnAlumno(Alumno alumno)
    {
        if(alumnos.size()<maxCupo)
        {
            alumnos.add(alumno);
            return true;
        }
        else return false;
    }

    public void eliminarAlumno(Alumno alumno)
    {
        if(alumnos.remove(alumno)) dOut("Se eliminó el alumno " + alumno.toString() + " de " + this.toString());
        else dOut("Se intentó eliminar " + alumno.toString() + " de " + this.toString() + ", pero no existe el alumno");
    }

    public void printAlumnos()
    {
        dOut("*--- alumnos en " + this.toString());
        for(Alumno a : alumnos)dOut(a.toString());
        dOut("*---");
    }

    public void printProfesores()
    {
        dOut("*--- profesores en " + this.toString());
        if(profesorTitular!=null)dOut(profesorTitular.toString()); else dOut("No hay profesor titular");
        if(profesorAdjunto!=null)dOut(profesorAdjunto.toString()); else dOut("No hay profesor adjunto");
        dOut("*---");
    }

    //endregion

    //region Object Overrides

    @Override
    public boolean equals(Object o)
    {
        Curso c = (Curso)o;
        return c.getCodigo().equals(this.codigo);
    }

    @Override
    public String toString()
    {
        return nombre + " : " + codigo;
    }

    //endregion

    //region debug

    void dOut(String s){ System.out.println(s); }

    //endregion
}

package com.company;
import java.util.Date;

public class Inscripcion
{
    Alumno alumno;
    Curso curso;
    Date fecha;

    public Inscripcion(Alumno alumno, Curso curso)
    {
        this.alumno = alumno;
        this.curso = curso;
        fecha = new Date();
    }

    //region Get Sets

    public Alumno getAlumno(){return alumno;}
    //public void setAlumno(Alumno a){alumno = a;}

    public Curso getCurso(){return curso;}
    //public void setCurso(Curso c){curso = c;}

    public Date getFecha(){return fecha;}

    //endregion

    //region Object Overrides

    public boolean equals(Object o)
    {
        Inscripcion i = (Inscripcion)o;
        return i.getAlumno().equals(this.alumno) && i.getCurso().equals(this.curso);
    }

    public String toString()
    { return "Inscripcion: " + alumno.toString() + " en " + curso.toString() + " (" +fecha.toString() + ")";}

    //endregion
}

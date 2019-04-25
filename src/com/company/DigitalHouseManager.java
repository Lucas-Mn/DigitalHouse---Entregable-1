package com.company;
import java.util.List;
import java.util.ArrayList;

public class DigitalHouseManager
{

    List<Alumno> alumnos;
    List<Profesor> profesores;
    List<Curso> cursos;
    List<Inscripcion> inscripciones;

    public DigitalHouseManager()
    {
        alumnos = new ArrayList<Alumno>();
        profesores = new ArrayList<Profesor>();
        cursos = new ArrayList<Curso>();
        inscripciones = new ArrayList<Inscripcion>();
    }

    //region Get Sets

    public List<Alumno> getAlumnos(){return alumnos;}
    public Alumno findAlumno(Integer codigo)
    {
        for(Alumno a : alumnos)
        {if(a.getCodigo().equals(codigo))return a;}
        return null;
    }

    public List<Profesor> getProfesores(){return profesores;}
    public Profesor findProfesor(Integer codigo)
    {
        for(Profesor p : profesores)
        { if(p.getCodigo().equals(codigo)) return p; }

        return null;
    }

    public List<Curso> getCursos(){return cursos;}
    public Curso findCurso(Integer codigo)
    {
        for(Curso c : cursos) if(c.getCodigo().equals(codigo)) return c;

        return null;
    }

    public List<Inscripcion> getInscripciones(){return inscripciones;}

    //endregion

    //region Responsabilidades

    public void altaCurso(String nombre, Integer codigoCurso, Integer cupoMaximo)
    {
        Curso t = new Curso(nombre, codigoCurso, cupoMaximo);

        //abortar si ya existe curso
        if(cursos.contains(t)){ dOut("! altaCurso: ya existe ese curso"); return; }

        cursos.add(t);
        dOut("Se dió de alta el curso " + t);
    }

    public void bajaCurso(Integer codigo)
    {
        Curso c = new Curso("", codigo, 0);
        if(!cursos.remove(c)) { dOut("! bajaCurso: No existe curso con código " + codigo); return; }

        dOut("Se dió de baja el curso con código " + codigo);

//        //encontrar y eliminar inscripciones del curso
//        List<Inscripcion> found = new ArrayList<Inscripcion>();
//        for(Inscripcion x : inscripciones)
//        {
//            if(x.getCurso().getCodigo().equals(codigo))
//                found.add(x);
//        }
//        inscripciones.removeAll(found);

    }

    public void altaProfesorAdjunto(String nombre, String apellido, Integer codigo, Integer horas)
    {
        ProfesorAdjunto p = new ProfesorAdjunto(nombre, apellido, codigo, horas);

        //abortar si ya existe profesor
        if(profesores.contains(p)){ dOut("! altaProfesorAdjunto: ya existe ese profesor"); return;}

        profesores.add(p);
        dOut("Se dió de alta el profesor " + p.toString());
    }

    public void altaProfesorTitular(String nombre, String apellido, Integer codigo, String especialidad)
    {
        ProfesorTitular p = new ProfesorTitular(nombre, apellido, codigo, especialidad);

        //abortar si ya existe profesor
        if(profesores.contains(p)){ dOut("! altaProfesorTitular: ya existe ese profesor"); return;}

        profesores.add(p);
        dOut("Se dió de alta el profesor " + p.toString());
    }

    public void bajaProfesor(Integer codigo)
    {
        Profesor p = findProfesor(codigo);

        //comprobar y abortar
        if(p==null){ dOut("No se pudo dar de baja profesor con código " + codigo + ", no existe"); return; }

        profesores.remove(p);

        //quitar profesor de sus cursos
        for(Curso c : cursos)
        {
            if(c.getProfesorAdjunto().equals(p))c.setProfesorAdjunto(null);
            else if(c.getProfesorTitular().equals(p))c.setProfesorTitular(null);
        }

        dOut("Se dió de baja el profesor " + p.toString());
    }

    public void altaAlumno(String nombre, String apellido, Integer codigo)
    {
        Alumno a = new Alumno(nombre, apellido, codigo);

        //abortar si ya existe alumno
        if(alumnos.contains(a)){dOut("! altaAlumno: ya existe ese alumno"); return; }

        alumnos.add(a);
        dOut("Se dió de alta el alumno " + a.toString());
    }

    public boolean altaAlumno(Alumno alumno)
    {
        return altaAlumnoBool(alumno.getNombre(), alumno.getApellido(), alumno.getCodigo());
    }

    public boolean altaAlumnoBool(String nombre, String apellido, Integer codigo)
    {
        Alumno a = new Alumno(nombre, apellido, codigo);

        //abortar si ya existe alumno
        if(alumnos.contains(a)){dOut("! altaAlumno: ya existe ese alumno"); return false; }

        alumnos.add(a);
        dOut("Se dió de alta el alumno " + a.toString());
        return true;
    }

    public void bajaAlumno(Integer codigo)
    {
        Alumno a = findAlumno(codigo);
        if(a==null){ dOut("! bajaAlumno: no existe ese alumno "); return; }

        alumnos.remove(a);
        for(Curso c : cursos)
        {
            c.getAlumnos().remove(a);
        }

        //encontrar y eliminar inscripciones del curso
        List<Inscripcion> found = new ArrayList<Inscripcion>();
        for(Inscripcion x : inscripciones)
        {
            if(x.getAlumno().equals(a))
            { found.add(x); x.getCurso().eliminarAlumno(a);}
        }
        inscripciones.removeAll(found);

        dOut("Se dió de baja el alumno " + a.toString());
    }

    public void inscribirAlumno(Integer codigoAlumno, Integer codigoCurso)
    {
        //buscar sujetos y comprobar existencia
        Alumno a = findAlumno(codigoAlumno);
        if(a==null){dOut("! inscribirAlumno: no existe alumno con código " + codigoAlumno); return;}

        Curso c = findCurso(codigoCurso);
        if(c==null){dOut("! inscribirAlumno: no existe curso con código " + codigoCurso); return;}

        //abortar si curso ya contiene alumno
        if(c.getAlumnos().contains(a)){dOut("! inscribirAlumno: curso ya tiene ese alumno"); return; }

        //agregar alumno, return si no hay cupo
        if(!c.agregarUnAlumno(a)){dOut("! inscribirAlumno: " + c.toString() + " no tiene cupo"); return; }

        //crear inscripción
        Inscripcion ins = new Inscripcion(a, c);
        inscripciones.add(ins);
        dOut("Se creó la inscripción: " + ins.toString());
    }

    //para ahorrar iteraciones al inscribir alumnos por lista
    private void inscribirAlumno(Alumno alumno, Curso curso)
    {

        //abortar si curso ya contiene alumno
        if(curso.getAlumnos().contains(alumno)){dOut("! inscribirAlumno: curso ya tiene ese alumno"); return; }

        //agregar alumno, return si no hay cupo
        if(!curso.agregarUnAlumno(alumno)){dOut("! inscribirAlumno: " + curso.toString() + " no tiene cupo"); return; }

        //crear inscripción
        Inscripcion ins = new Inscripcion(alumno, curso);
        inscripciones.add(ins);
        dOut("Se creó la inscripción: " + ins.toString());
    }

    public void altaInscribirAlumnos(List<Alumno> alumnos, Integer codigoCurso)
    {
        Curso c = findCurso(codigoCurso);
        //comprobar y abortar
        if(c==null){dOut("No existe curso con código " + codigoCurso); return; }

        for(Alumno a : alumnos)
        {
                if(altaAlumno(a)) inscribirAlumno(a, c);
        }
    }

    public void asignarProfesores(Integer codigoCurso, Integer codigoTitular, Integer codigoAdjunto)
    {
        //buscar y comprobar curso
        Curso c = findCurso(codigoCurso);
        if(c==null){dOut("! asignarProfesores: no existe curso con código " + codigoCurso); return; }

        //buscar y comprobar profesor titular
        Profesor temp = findProfesor(codigoTitular);
        if(temp == null){ dOut("! asignarProfesores: no existe profesor con código " + codigoTitular); return; }
        ProfesorTitular pt;
        if( !(temp instanceof ProfesorTitular)) { dOut("! asignarProfesores: '" + temp.toString() + "' no es un ProfesorTitular"); return; }
        pt = (ProfesorTitular) temp;

        //buscar y comprobar profesor adjunto
        temp = findProfesor(codigoAdjunto);
        if(temp == null) { dOut("! asignarProfesores: no existe profesor con código " + codigoAdjunto); return; }
        ProfesorAdjunto pa;
        if(!(temp instanceof ProfesorAdjunto)){dOut("! asignarProfesores: '" + temp.toString() + "' no es un ProfesorAdjunto"); return;}
        pa = (ProfesorAdjunto)temp;

        //asignar profesores al curso
        c.setProfesorTitular(pt);
        c.setProfesorAdjunto(pa);
        dOut("Se asignaron los profesores " + pt.toString() + " y " + pa.toString() + " al curso " + c.toString());
    }

    //endregion

    //region Prints

    public void print()
    {
        dOut("");
        dOut("DHM:");
        dOut("");
        printCursos();
        printProfesores();
        printAlumnos();
        printInscripciones();
        dOut("");
    }

    public void printCursos()
    {
        dOut("*--- cursos en DHM");
        for(Curso c : cursos)
        {dOut(c.toString());}
        dOut("*---");
    }

    public void printProfesores()
    {
        dOut("*--- profesores en DHM");
        for(Profesor c : profesores)
        {dOut(c.toString());}
        dOut("*---");
    }

    public void printAlumnos()
    {
        dOut("*--- alumnos en DHM");
        for(Alumno c : alumnos)
        {dOut(c.toString());}
        dOut("*---");
    }

    public void printInscripciones()
    {
        dOut("*--- inscripciones en DHM");
        for(Inscripcion c : inscripciones)
        {dOut(c.toString());}
        dOut("*---");
    }

    public void printCursosFull()
    {
        dOut("*--- Cursos en DHM");
        for(Curso c : cursos)
        {
            dOut("- Curso " + c.toString());
            c.printAlumnos();
            c.printProfesores();
            dOut("-");
        }
        dOut("*--- ");
    }

    //endregion

    //region Debug

    void dOut(String s){
        System.out.println(s);
    }

    //endregion

}

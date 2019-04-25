package com.company;

public class Main {

    public static void main(String[] args) {

        //region entregable
        DigitalHouseManager dhm = new DigitalHouseManager();

        dhm.altaProfesorTitular("Ricardo", "Milos", 0, "Matemática");
        dhm.altaProfesorTitular("Eduardo", "Perez", 1, "Diseño");

        dhm.altaProfesorAdjunto("José", "Milos", 2, 3);
        dhm.altaProfesorAdjunto("Horacio", "Hernandez", 3, 2);

        dhm.altaCurso("Full Stack", 20001, 3);
        dhm.altaCurso("Android", 20002, 2);

        dhm.asignarProfesores(20001, 0, 2);
        dhm.asignarProfesores(20002, 1, 3);

        dhm.altaAlumno("Martín", "Toro", 0);
        dhm.altaAlumno("Francisco", "Rodriguez", 1);
        dhm.altaAlumno("Federico", "Rossberg", 2);

        dhm.inscribirAlumno(0, 20001);
        dhm.inscribirAlumno(1, 20001);

        dhm.inscribirAlumno(0, 20002);
        dhm.inscribirAlumno(1, 20002);
        dhm.inscribirAlumno(2, 20002);

        dhm.bajaProfesor(2);
        dhm.bajaCurso(20001);

        dhm.print();

        //para poder preguntarle a un alumno en qué cursos está inscripto, Alumno debería contener una lista de Cursos
        //y una nueva responsabilidad - getCursos():List<Curso>

        //endregion

        dhm = new DigitalHouseManager();
        dhm.altaCurso("Mobile Android", 20002, 40);
        LectorDeArchivosCSV lector = new LectorDeArchivosCSV();

        dhm.altaInscribirAlumnos(lector.LeerAlumnos(), 20002);

//        for(Alumno a : lector.LeerAlumnos())
//        {
//            dhm.altaAlumno(a);
//            dhm.inscribirAlumno(a.getCodigo(), 20002);
//        }

        dhm.print();

        //region mis tests
//        DigitalHouseManager dhm = new DigitalHouseManager();
//
//        dhm.print();
//
//        dhm.altaAlumno("Pedro", "Rodriguez", 0);
//        dhm.altaAlumno("Juan", "Rodriguez", 1);
//        dhm.altaAlumno("Francisco", "Perez", 2);
//
//        dhm.altaAlumno("Pedro", "Rodriguez", 0);
//
//        if(dhm.getAlumnos().size() > 3){ System.out.println("!!!Muchos alumnos!!!"); }
//
//        dhm.altaCurso("Matemática", 0, 3);
//        dhm.altaCurso("Arte", 1, 2);
//        dhm.altaCurso("Arte", 1, 5);
//
//        if(dhm.getCursos().size() > 2){ System.out.println("!!!Muchos cursos!!!"); }
//
//        dhm.altaProfesorAdjunto("Eduardo", "Milos", 0, 3);
//        dhm.altaProfesorTitular("Ricardo", "Milos", 1, "Arte");
//        dhm.altaProfesorAdjunto("Eduardo", "Milos", 0, 3);
//        dhm.altaProfesorTitular("Ricardo", "Milos", 1, "Arte");
//
//        if(dhm.getProfesores().size() > 2){ System.out.println("!!!Muchos profesores!!!"); }
//
//        dhm.inscribirAlumno(0, 0);
//        dhm.inscribirAlumno(0, 0);
//        dhm.inscribirAlumno(1, 0);
//        dhm.inscribirAlumno(2, 0);
//        dhm.inscribirAlumno(2, 0);
//
//        dhm.inscribirAlumno(0, 1);
//        dhm.inscribirAlumno(1, 1);
//        dhm.inscribirAlumno(2, 1);
//
//        dhm.printCursosFull();
//        dhm.print();
//
//        dhm.bajaAlumno(0);
//        dhm.bajaAlumno(0);
//        dhm.bajaCurso(1);
//        dhm.bajaCurso(1);
//
//        dhm.altaAlumno("Gorge", "Milos", 3);
//        dhm.altaAlumno("Pipi", "Piazo", 4);
//        dhm.inscribirAlumno(3, 0);
//        dhm.inscribirAlumno(4, 0);
//
//        dhm.asignarProfesores(0, 1, 0);
//        dhm.asignarProfesores(0, 0, 1);
//        dhm.asignarProfesores(1, 1, 0);
//        dhm.asignarProfesores(0, 1, 1);
//
//        dhm.bajaProfesor(0);
//
//        dhm.asignarProfesores(0, 1, 0);
//
//        dhm.print(); dhm.printCursosFull();
        //endregion
    }
}

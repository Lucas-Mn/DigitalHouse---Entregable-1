package com.company;

import com.opencsv.CSVReader;
import java.util.Arrays;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class LectorDeArchivosCSV
{

    String path;
    List<Alumno> alumnos;
    CSVReader reader;

    public LectorDeArchivosCSV()
    {
        path = "listadoDeAlumnos.csv";
        alumnos = new ArrayList<Alumno>();
        try {
            reader = new CSVReader(new FileReader(path));
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
    }

    public List<Alumno> getAlumnos(){return alumnos;}

    public List<Alumno> LeerAlumnos()
    {
        try
        {
            String[] linea = reader.readNext();
            while(linea != null)
            {
                linea = reader.readNext();
                if(linea!=null)
                alumnos.add(new Alumno(linea[1], linea[2], Integer.parseInt(linea[0])));
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        return alumnos;
    }

    public void print()
    {
        for(Alumno a : alumnos) {
            System.out.println(a.toString());
        }
    }

}

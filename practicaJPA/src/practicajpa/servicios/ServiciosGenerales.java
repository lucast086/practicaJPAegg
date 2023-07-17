/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicajpa.servicios;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import practicajpa.entidades.Alumno;
import practicajpa.entidades.Curso;
import practicajpa.entidades.Profesor;
import practicajpa.enums.DiaDeLaSemana;
import practicajpa.repositorios.AlumnoRepositorio;
import practicajpa.repositorios.CursoRepositorio;
import practicajpa.repositorios.ProfesorRepositorio;

/**
 *
 * @author sasa
 */
public class ServiciosGenerales {
    
    private AlumnoRepositorio alumnoRepositorio;
    private ProfesorRepositorio profesorRepositorio;
    private CursoRepositorio cursoRepositorio;
    private Scanner leer = new Scanner(System.in);

    public ServiciosGenerales() {
        alumnoRepositorio = new AlumnoRepositorio();
        cursoRepositorio = new CursoRepositorio();
        profesorRepositorio = new ProfesorRepositorio();
    }
      
    
    public void cargarBase() {
         

        Curso curso1 = new Curso();
        curso1.setNombre("JavaPOO");
        curso1.setDia(DiaDeLaSemana.LUNES);
        curso1.setHoraInicio(crearHora(14, 30));
        curso1.setHoraFin(crearHora(15, 30));
        curso1.setCupo(20);
        cursoRepositorio.crear(curso1);
        
        Curso curso2 = new Curso();
        curso2.setNombre("HTML");
        curso2.setDia(DiaDeLaSemana.MARTES);
        curso2.setHoraInicio(crearHora(14, 30));
        curso2.setHoraFin(crearHora(15, 30));
        curso2.setCupo(20);
        cursoRepositorio.crear(curso2);
        
        Curso curso3 = new Curso();
        curso3.setNombre("SPRING");
        curso3.setDia(DiaDeLaSemana.MIERCOLES);
        curso3.setHoraInicio(crearHora(14, 30));
        curso3.setHoraFin(crearHora(15, 30));
        curso3.setCupo(20);
        cursoRepositorio.crear(curso3);
        
        Set<Curso> cursosAlumno1 = new HashSet<>();
        cursosAlumno1.add(curso1);
        cursosAlumno1.add(curso2);

        Alumno alumno1 = new Alumno();
        alumno1.setNombre("Juan");
        alumno1.setApellido("Pérez");
        alumno1.setCursos(cursosAlumno1);
        alumnoRepositorio.crear(alumno1);

        Set<Curso> cursosAlumno2 = new HashSet<>();
        cursosAlumno2.add(curso2);
        cursosAlumno2.add(curso3);

        Alumno alumno2 = new Alumno();
        alumno2.setNombre("María");
        alumno2.setApellido("Gómez");
        alumno2.setCursos(cursosAlumno2);
        alumnoRepositorio.crear(alumno2);        
        
        
        Set<Curso> cursosProfesor1 = new HashSet<>();
        cursosProfesor1.add(cursoRepositorio.buscarPorNombre("JavaPOO").get(0));
        cursosProfesor1.add(cursoRepositorio.buscarPorNombre("HTML").get(0));

        Profesor profesor1 = new Profesor();
        profesor1.setNombre("Pedro");
        profesor1.setApellido("López");
        profesor1.setCursos(cursosProfesor1);
        profesorRepositorio.crear(profesor1);
        
        Set<Curso> cursosProfesor2 = new HashSet<>();
        cursosProfesor2.add(cursoRepositorio.buscarPorNombre("SPRING").get(0));
        
        Profesor profesor2 = new Profesor();
        profesor2.setNombre("Ana");
        profesor2.setApellido("Rodríguez");
        profesor2.setCursos(cursosProfesor2);
        profesorRepositorio.crear(profesor2);

        
        Curso curso11 = cursoRepositorio.buscarPorNombre("JavaPOO").get(0);
        List<Profesor> profesor22 = profesorRepositorio.buscarPorNombre("Pedro");
        curso11.setProfesor(profesor22.get(0));
        cursoRepositorio.editar(curso11);
        
        Curso curso22 = cursoRepositorio.buscarPorNombre("HTML").get(0);
        curso22.setProfesor(profesor22.get(0));
        cursoRepositorio.editar(curso22);
        
        Curso curso33 = cursoRepositorio.buscarPorNombre("SPRING").get(0);
        List<Profesor> profesor33 = profesorRepositorio.buscarPorNombre("Ana");
        curso33.setProfesor(profesor33.get(0));
        cursoRepositorio.editar(curso33);
        
    }
    
    private Date crearHora(int horas, int minutos){
        LocalTime hora = LocalTime.of(horas, minutos);
        Date fecha = Date.from(hora.atDate(LocalDate.now()).atZone(ZoneId.systemDefault()).toInstant());
        return fecha;    
    }
   
    public void consultas() {
        
        List<Curso> cursos = cursoRepositorio.listarCursos();
        
        System.out.println("****  LISTA DE TODOS LOS CURSOS DISPONIBLES.");
        for (Curso curso : cursos) {
            System.out.println(curso.toString());            
        }
        System.out.println(" ");
        
        System.out.println("****  LISTA DEL CURSO POR EL NOMBRE: ...");
        String nombre = leer.nextLine();
        System.out.println(" ");
        Curso cursito = cursoRepositorio.buscarPorNombre(nombre).get(0);
        System.out.println(cursito);
        System.out.println(" ");
        System.out.println("*********************************************************");
        System.out.println(" ");
        
         List<Profesor> profesores = profesorRepositorio.listarProfesores();
        
        System.out.println("****  LISTA DE TODOS LOS PROFESORES DISPONIBLES. NAMEDQUERY");
        for (Profesor profesor : profesores) {
            System.out.println(profesor.toString());            
        }
        System.out.println(" ");
        System.out.println("*********************************************************");
        System.out.println(" ");
        
        System.out.println("****  CANTIDAD DE ALUMNOS INSCRIPTOS NATIVE QUERY");
        System.out.println(alumnoRepositorio.cantidadAlumnos());
    }
    
}

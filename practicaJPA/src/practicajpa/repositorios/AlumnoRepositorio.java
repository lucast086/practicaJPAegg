/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicajpa.repositorios;

import java.util.List;
import practicajpa.entidades.Alumno;

/**
 *
 * @author sasa
 */
public class AlumnoRepositorio extends RepositorioJPA<Alumno> {

    public AlumnoRepositorio() {
        super();
    }
    
    public void crear(Alumno alumno) {
        super.create(alumno);
    }
    
    public void editar(Alumno alumno) {
        super.update(alumno);
    }
    
    public void borrar(Long id) {
       Alumno alumno = findId(id);
       super.delete(alumno);
    }  
    
    
    public Alumno findId(Long id){
        super.conect();
        Alumno alumno = em.find(Alumno.class, id);
        super.disconect();
        return alumno;
    }
    
     public List<Alumno> listarAlumnos(){
        super.conect();
        List<Alumno> alumnos = em.createNamedQuery("Alumno.listarTodos",Alumno.class).getResultList();
        super.disconect();
        return alumnos;    
    }    
    
     public Long cantidadAlumnos(){
         super.conect();
         Long cantidad = (Long) em.createNativeQuery("SELECT COUNT(*) FROM alumnos").getSingleResult();
         return cantidad;
     }
    
}

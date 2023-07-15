/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jpa.repositorios;

import java.util.List;
import java.util.Set;
import jpa.entidades.Alumno;

/**
 *
 * @author sasa
 */
public class AlumnoRepositorio extends RepositorioJPA<Alumno>{

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

 public List<Alumno> listarAlumnos(){
        super.conect();
        List<Alumno> alumnos = em.createNamedQuery("Alumno.findAll").getResultList();
        super.disconect();
        return alumnos;
        
    }
    
    
   public Alumno findId(Long id) {
       super.conect();
       Alumno alumno = em.createNamedQuery("Alumno.findById", Alumno.class).setParameter("id", id).getSingleResult();
       super.disconect();
       return alumno;
        
    }
   
   public Long cantidadAlumnos(){
       Long cantidad = (Long) em.createNativeQuery("Alumno.contarNativo").getSingleResult();
       return cantidad;
   }
}

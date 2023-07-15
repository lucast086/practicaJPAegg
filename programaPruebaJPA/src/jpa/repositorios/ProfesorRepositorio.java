/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jpa.repositorios;

import java.util.List;
import jpa.entidades.Profesor;

/**
 *
 * @author sasa
 */
public class ProfesorRepositorio extends RepositorioJPA<Profesor>{
    
    
        public ProfesorRepositorio() {
        super();
    }  
    
    
    public void crear(Profesor profesor) {
            super.create(profesor);
    }

    public void editar(Profesor profesor) {
        super.update(profesor);
    }
    
        public void borrar(Long id) {
       Profesor profesor = findId(id);
       super.delete(profesor);
    }    

 public List<Profesor> listarProfesores(){
        super.conect();
        List<Profesor> profesores = em.createNamedQuery("Profesor.findAll").getResultList();
        super.disconect();
        return profesores;
        
    }
    
    
   public Profesor findId(Long id) {
       super.conect();
       Profesor profesor = em.createNamedQuery("Profesor.findById", Profesor.class).setParameter("id", id).getSingleResult();
       super.disconect();
       return profesor;
    }

    public Profesor buscarPorNombre(String nombre) {
       super.conect();
       Profesor profesor = em.createQuery("SELECT c FROM Profesor c WHERE c.nombre = :nombre", Profesor.class).setParameter("nombre", nombre).getSingleResult();
       super.disconect();
       return profesor;
    }
}

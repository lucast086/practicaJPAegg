/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicajpa.repositorios;

import java.util.List;
import practicajpa.entidades.Profesor;

/**
 *
 * @author sasa
 */
public class ProfesorRepositorio extends RepositorioJPA<Profesor> {

    public ProfesorRepositorio() {
        super();
    }
    
    public void crear(Profesor profesor)     {
        super.create(profesor);
    }
    
    
    public void editar(Profesor profesor){
        super.update(profesor);
    }
    
    public void borrar(Long id){
        Profesor profesor = em.find(Profesor.class, id);
        super.delete(profesor);
    }
    
     public List<Profesor> listarProfesores(){
        super.conect();
        List<Profesor> profesores = em.createNamedQuery("Profesor.buscarTodos").getResultList();
        super.disconect();
        return profesores; 
    }
    
        public Profesor findId(Long id) {
       super.conect();
       Profesor profesor = em.createNamedQuery("Profesor.buscarPorId", Profesor.class).setParameter("id", id).getSingleResult();
       super.disconect();
       return profesor;
    }
        
    public List<Profesor> buscarPorNombre(String nombre){
        super.conect();
        List<Profesor> profesor = em.createQuery("SELECT p FROM Profesor p WHERE p.nombre = :nombre", Profesor.class).
                    setParameter("nombre",nombre).getResultList();
        super.disconect();
        return profesor;
                
    }
    
    
    
}

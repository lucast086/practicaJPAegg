/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicajpa.repositorios;

import java.util.List;
import practicajpa.entidades.Curso;
import practicajpa.enums.DiaDeLaSemana;

/**
 *
 * @author sasa
 */
public class CursoRepositorio extends RepositorioJPA<Curso>{

    public CursoRepositorio() {
        super();
    }
    
    public void crear(Curso curso) {
            super.create(curso);
    }

    public void editar(Curso curso) {
        super.update(curso);
    }

    public void borrar(Long id) {
       Curso curso = findId(id);
       super.delete(curso);
    }    
    
    public List<Curso> listarCursos(){
        super.conect();
        List<Curso> cursos = em.createNamedQuery("Curso.findAll").getResultList();
        super.disconect();
        return cursos;
    }
    
    
   public Curso findId(Long id) {
       super.conect();
       Curso curso = em.createNamedQuery("Curso.findById", Curso.class).setParameter("id", id).getSingleResult();
       super.disconect();
       return curso;
    }
   
       
   public List<Curso> buscarPorNombre(String nombre) {
       super.conect();
       List<Curso> cursos = em.createQuery("SELECT c FROM Curso c WHERE c.nombre = :nombre", Curso.class).setParameter("nombre", nombre).getResultList();
       super.disconect();
       return cursos;
    }
   
   public List<Curso> listarCursosPorDia(DiaDeLaSemana dia){
       super.conect();
       List<Curso> cursos = em.createQuery("SELECT c FROM Curso c WHERE c.dia = :dia", Curso.class).setParameter("dia", dia.toString()).getResultList();
       super.disconect();
       return cursos;
   }
    
    
}

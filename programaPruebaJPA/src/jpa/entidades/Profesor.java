/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jpa.entidades;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author sasa
 */
@NamedQueries({
    @NamedQuery(name="Profesor.findAll", query="SELECT a FROM Profesor a"),
    @NamedQuery(name="Profesor.findById", query="SELECT a FROM Profesor a WHERE a.id = :id")
})

@Entity
@Table(name="profesores")
public class Profesor extends Persona{
    
    @OneToMany(mappedBy="profesor")
    private Set<Curso> cursos;   

    public Profesor() {
    }

    public Set<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(Set<Curso> cursos) {
        this.cursos = cursos;
    }
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package jpa.enums;

/**
 *
 * @author sasa
 */
public enum DiaDeLaSemana {
    
    DOMINGO(1),
    LUNES(2),
    MARTES(3),
    MIERCOLES(4),
    JUEVES(5),
    VIERNES(6),
    SABADO(7);
    
    final int numero;
    
    DiaDeLaSemana(int dia){
        this.numero = dia;
    }
    
    
}

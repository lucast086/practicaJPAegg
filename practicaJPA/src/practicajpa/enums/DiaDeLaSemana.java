/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package practicajpa.enums;

/**
 *
 * @author sasa
 */
public enum DiaDeLaSemana {
    
    LUNES(2),
    MARTES(3),
    MIERCOLES(4),
    JUEVES(5),
    VIERNES(6),
    SABADO(7),
    DOMINGO(1);
    
    final int numero;

    private DiaDeLaSemana(int num) {
        this.numero = num;
    }
 
}

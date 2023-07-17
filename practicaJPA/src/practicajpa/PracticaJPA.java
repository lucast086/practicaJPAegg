/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practicajpa;

import practicajpa.servicios.ServiciosGenerales;

/**
 *
 * @author sasa
 */
public class PracticaJPA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ServiciosGenerales serviciosGenerales =  new ServiciosGenerales();
        serviciosGenerales.cargarBase();
        serviciosGenerales.consultas();
        // TODO code application logic here
    }
    
}

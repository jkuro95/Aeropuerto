/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import java.util.Scanner;
import modelos.Hangar;

/**
 *
 * @author juanr
 */
public class VistaHangar {
    
    public Hangar activarVistaRegistrarHangar(){
        
        Scanner entrada = new Scanner(System.in);
        Hangar hangar = new Hangar();
        
        System.out.println("Bienvenido al hangar 160");
        
        System.out.println("Digite el codigo del hangar: ");
        hangar.setCodigoHangar(entrada.nextInt());
        
        System.out.println("Digite los cupos totales: ");
        hangar.setCuposTotales(entrada.nextInt());
        
        System.out.println("Digite los cupos disponibles: ");
        hangar.setCuposDisponibles(entrada.nextInt());
        
        System.out.println("Digite los cupos reservados: ");
        hangar.setCuposReservados(entrada.nextInt());
        
        return hangar;
        
    }
    
    public void ativarVistaBuscarHangare(Hangar hangar){
        
        System.out.println("------------------------------");
        System.out.println("Los datos del hangar: " + hangar.getCodigoHangar());
        
        System.out.println("Cupos totales del hangar: " + hangar.getCuposTotales());
        
        System.out.println("Cupos disponibles del hangar: " + hangar.getCuposDisponibles());
        
        System.out.println("Cupos reservados del hangar: " + hangar.getCuposReservados());
        
        
    }
    
    public void activarVistaHagarNoDisponible(){
        
        System.out.println("");
        System.out.println("------------------------------");
        
        System.out.println("");
        
        System.out.println("No hay cupos disponibles en este hangar");
        
        System.out.println("");
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aeropuerto;

import controladores.ControladorAvion;
import controladores.ControladorHangar;
import controladores.ControladorHangarAvion;
import controladores.ControladorPropietario;
import java.util.Scanner;
import modelos.Avion;
import modelos.Hangar;
import modelos.Propietario;
import vistas.VistaAvion;
import vistas.VistaHangar;
import vistas.VistaPropietario;

/**
 *
 * @author juanr
 */
public class Aeropuerto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        
        Scanner entrada = new Scanner(System.in);
        
        //menu para elegir (Consultar informacion de un avion por la matricula/Matricular un avion en el hangar)
        
        VistaPropietario vistaPropietario = new VistaPropietario();
        ControladorPropietario controladorPropietario = new ControladorPropietario();
        VistaAvion vistaAvion = new VistaAvion();
        VistaHangar vistaHangar = new VistaHangar();
        ControladorAvion controladorAvion = new ControladorAvion();
        ControladorHangarAvion controladorHangarAvion = new ControladorHangarAvion();
        ControladorHangar controladorHangar = new ControladorHangar();
        Hangar hangar = controladorHangar.cosultarHangar();
        
        System.out.println("Bienvenido al aeropuerto el trapiche");
        System.out.println("Actualmente solo esta funcionando un hangar");
        System.out.println("---------------------------------------------------------------");

        int opcion = 1;
        String matriculaAvion;
        
        while(opcion != 0){

            System.out.println("Menu de opciones");
            System.out.println("Presione 1 para Buscar un avion en el aeropuerto");
            System.out.println("Presione 2 para hacer el registro completo del avion");
            System.out.println("Presione 0 para cerrar el programa");
            System.out.print("Ingrese la opcion: ");
            opcion = entrada.nextInt();
            
            if(opcion >= 0 && opcion <= 2){
                
                if(opcion == 1){
                    
                    matriculaAvion = vistaAvion.ActivarVistaConsultarAvionPorMtricula();
                    controladorAvion.ConsultarAvionPorMatricula(matriculaAvion);
                    
                    
                }else if(opcion == 2){
                    
                    if(hangar.getCuposDisponibles()>0){
            
                    //REGISTRAR PROPIETARIO
                    Propietario propietario = vistaPropietario.activarVista();
                    controladorPropietario.registrarPropietario(propietario);
            
                    //REGISTRAR AVION
                    Avion avion = vistaAvion.ActivarVistaRegistrarAvion();
                    controladorAvion.registrarAvion(avion);
            
                    //REGISTRAR AVION EN HANGAR
                    controladorHangarAvion.matricularAvionEnHangar(avion.getMatriculaAvio(), hangar.getCuposDisponibles());
            
                    //ACTUALIZAR CUPOS DISPONIBLES
                    controladorHangar.actualizarHangar(hangar);
                    }
                    else{
                        vistaHangar.activarVistaHagarNoDisponible();
                        }
                    
                }else{
                    System.out.println();
                    System.out.println("Gracias por usarnos, que tenga un feliz dia");
                    System.out.println("-------------------------------------------------------");
                }
                
                
            }else{
                System.out.println("Opcion invalida, por favor ingrese una valida(0/1/2)");
                System.out.println("---------------------------------------------------------");
            }
            
            
        }
        
        
        
        
        

        
        
        
        
        
    }
    
}

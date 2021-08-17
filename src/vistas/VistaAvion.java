/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import java.util.Scanner;
import modelos.Avion;
import modelos.HangaresAviones;

/**
 *
 * @author juanr
 */
public class VistaAvion {
    
    public Avion ActivarVistaRegistrarAvion(){
       
       Scanner entrada = new Scanner(System.in);
       Avion avion = new Avion();
       
       System.out.println("Digite la matricula del avion");
       avion.setMatriculaAvio(entrada.next());
       
       System.out.println("Digite el modelo del avion");
       avion.setModeloAvion(entrada.next());
       
       System.out.println("Digite la cedula del propietario");
       avion.setCedulaPropietario(entrada.next());
       
       System.out.println("Digite el tipo de contrato (1/2)");
       avion.setTipoContrato(entrada.nextInt());
       
       return avion;
    }
    
    public String ActivarVistaConsultarAvionPorMtricula(){
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Digite la matricula del avion que va a buscar: ");
        String matriculaAvion = entrada.next();
        
        return matriculaAvion;
    }
    
    public void ActivarVistaMostrarConsultaAvionPorMatricula(Avion avion, HangaresAviones hangaresAviones){
        
        System.out.println("Informacion del avion registrado con matricula : "+avion.getMatriculaAvio());
        System.out.println("Cedula del propietario: " + avion.getCedulaPropietario());
        System.out.println("Modelo del avion: " + avion.getModeloAvion());
        System.out.println("Fecha de ingreso: " + hangaresAviones.getFecha().toString());
        System.out.println("Hangar dond se encuentra guardado: " + hangaresAviones.getCodigoHangar());
        System.out.println("# de celda donde se encuentra guardado: " + hangaresAviones.getNumeroCelda());
        System.out.println("----------------------------------------------------------------------------");
    }
    
    public void aactivarVistaMostrarAvionPorMatricula(Avion avion){
        System.out.println("Aqui  : " + avion.getCedulaPropietario() );
    }
    

  
    
}

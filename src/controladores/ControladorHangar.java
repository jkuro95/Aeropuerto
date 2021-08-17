/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import modelos.ActualizarHangar;
import modelos.ConsultarHangar;
import modelos.Hangar;
import modelos.InsertarHangar;

/**
 *
 * @author juanr
 */
public class ControladorHangar {
    
    private InsertarHangar modeloInsertarHangar = new InsertarHangar();
    private ConsultarHangar modeloConsultarhangar = new ConsultarHangar();
    private ActualizarHangar modeloActualizarHangar = new ActualizarHangar();
    
    public void registrarHangar(Hangar hangar){
        modeloInsertarHangar.insertarHangar(hangar);
    }
    
   
    public Hangar cosultarHangar(){
        Hangar hangar = modeloConsultarhangar.BuscarHangares();
        return hangar;
    }
    
    public void actualizarHangar(Hangar hangar){
        
        hangar.setCuposDisponibles(hangar.getCuposDisponibles()-1);
        hangar.setCuposReservados(hangar.getCuposReservados()+1);
        
        modeloActualizarHangar.actualizarHangar(hangar);
        
    }
    
    
}

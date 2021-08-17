/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import modelos.InsertarPropietario;
import modelos.Propietario;

/**
 *
 * @author juanr
 */
public class ControladorPropietario {
    
    private InsertarPropietario modeloInsertar = new InsertarPropietario();
    
    public void registrarPropietario(Propietario propietario){
        
        //VALIDACIONES SE HACEN EN CONTROLADOR
        
        modeloInsertar.insertarPropietario(propietario);
        
    }
    
}

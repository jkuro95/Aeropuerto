/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import modelos.InsertarHangaresAviones;

/**
 *
 * @author juanr
 */
public class ControladorHangarAvion {
    
    private InsertarHangaresAviones modeloInsertarHangaresAviones = new InsertarHangaresAviones();
    
    public void matricularAvionEnHangar(String matriculaAvion, int cuposDisponibles){
        modeloInsertarHangaresAviones.insertarAvionHangar(matriculaAvion, cuposDisponibles);
    }
    
}

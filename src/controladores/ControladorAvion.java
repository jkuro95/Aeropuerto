/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import modelos.Avion;
import modelos.ConsultaHangaresAviones;
import modelos.ConsultarAvion;
import modelos.InsertarAvion;
import vistas.VistaAvion;

/**
 *
 * @author juanr
 */
public class ControladorAvion {
    
    private InsertarAvion modeloInsertar = new InsertarAvion();
    private ConsultaHangaresAviones modeloConsultaHangaresAviones = new ConsultaHangaresAviones();
    private ConsultarAvion modeloConsultarAvion = new ConsultarAvion();
    private VistaAvion modeloVistaAvion = new VistaAvion();
    private Avion avion = new Avion();
    
    public void registrarAvion(Avion avion){
        
        modeloInsertar.insertarAvion(avion);
        
    }
    
    public void ConsultarAvionPorMatricula(String matriculaAvion){
        modeloVistaAvion.ActivarVistaMostrarConsultaAvionPorMatricula(modeloConsultarAvion.buscarAvionPorMatricula(matriculaAvion), modeloConsultaHangaresAviones.buscarHangarAvionPorMatricula(matriculaAvion));
        //avion = modeloConsultarAvion.buscarAvionPorMatricula(matriculaAvion);
        //modeloVistaAvion.aactivarVistaMostrarAvionPorMatricula(avion);
    }
    
}

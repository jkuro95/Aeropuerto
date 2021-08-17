/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author juanr
 */
public class Avion {
    
    private String matriculaAvio;
    private String modeloAvion;
    private String cedulaPropietario;
    private int tipoContrato;

    public String getMatriculaAvio() {
        return matriculaAvio;
    }

    public void setMatriculaAvio(String matriculaAvio) {
        this.matriculaAvio = matriculaAvio;
    }

    public String getModeloAvion() {
        return modeloAvion;
    }

    public void setModeloAvion(String modeloAvion) {
        this.modeloAvion = modeloAvion;
    }

    public String getCedulaPropietario() {
        return cedulaPropietario;
    }

    public void setCedulaPropietario(String cedulaPropietario) {
        this.cedulaPropietario = cedulaPropietario;
    }

    public int getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(int tipoContrato) {
        this.tipoContrato = tipoContrato;
    }
    
    
}

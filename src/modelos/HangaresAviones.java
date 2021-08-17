/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.sql.Date;

/**
 *
 * @author juanr
 */
public class HangaresAviones {
    
    private int codigoHangar;
    private String matriculaAvion;
    private Date fecha;
    private int numeroCelda;

    public int getCodigoHangar() {
        return codigoHangar;
    }

    public void setCodigoHangar(int codigoHangar) {
        this.codigoHangar = codigoHangar;
    }

    public String getMatriculaAvion() {
        return matriculaAvion;
    }

    public void setMatriculaAvion(String matriculaAvion) {
        this.matriculaAvion = matriculaAvion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getNumeroCelda() {
        return numeroCelda;
    }

    public void setNumeroCelda(int numeroCelda) {
        this.numeroCelda = numeroCelda;
    }
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author juanr
 */
public class ConsultarAvion extends BaseDatos{
    
    private PreparedStatement sentenciaSQL;
    private ResultSet resultadoConsulta;
    
    public Avion buscarAvionPorMatricula(String matriculaAvion){
        
        Connection conexion = conectarBD();
        
        Avion avion = new Avion();
        
        String consulta = "SELECT matricula_avion, modelo_avion, cedula_propietario, tipo_contrato "
                + "FROM aviones WHERE matricula_avion=?";
        
        //String consulta = "SELECT * FROM aviones";
        
        try{
            
            sentenciaSQL = conexion.prepareStatement(consulta);
            
            sentenciaSQL.setString(1, matriculaAvion);
            
            resultadoConsulta = sentenciaSQL.executeQuery();
            
            if(resultadoConsulta.next()){
                
                avion.setMatriculaAvio(resultadoConsulta.getString("matricula_avion"));
                avion.setModeloAvion(resultadoConsulta.getString("modelo_avion"));
                avion.setCedulaPropietario(resultadoConsulta.getString("cedula_propietario"));
                avion.setTipoContrato(resultadoConsulta.getInt("tipo_contrato"));
                
                
                return avion;
            }
            else{
                return null;
            }
            
        }catch(Exception e){
            System.out.println("Error colsuntando registro: "+e);
            return null;
        }finally{
            try{
                conexion.close();
            }catch(Exception e){
                System.out.println("Error: "+e);
            }
        }
    }
}

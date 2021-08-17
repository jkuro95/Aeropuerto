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
public class ConsultaHangaresAviones extends BaseDatos{
    
    private PreparedStatement sentenciaSQL;
    private ResultSet resultadoConsulta;
    
    public HangaresAviones buscarHangarAvionPorMatricula(String matriculaAvion){
        
        Connection conexion = conectarBD();
        HangaresAviones hangaresAviones = new HangaresAviones();
        
        String consulta = "SELECT codigo_hangar, matricula_avion, fecha_ingreso, numero_celda "
                + "FROM hangares_aviones WHERE matricula_avion=?";
        
        try{
            
            sentenciaSQL = conexion.prepareStatement(consulta);
            
            sentenciaSQL.setString(1, matriculaAvion);
            
            resultadoConsulta = sentenciaSQL.executeQuery();
            
            if(resultadoConsulta.next()){
                
                hangaresAviones.setCodigoHangar(resultadoConsulta.getInt("codigo_hangar"));
                hangaresAviones.setMatriculaAvion(resultadoConsulta.getString("matricula_avion"));
                hangaresAviones.setFecha(resultadoConsulta.getDate("fecha_ingreso"));
                hangaresAviones.setNumeroCelda(resultadoConsulta.getInt("numero_celda"));

                
                
                return hangaresAviones;
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

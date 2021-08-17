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
public class ConsultarHangar extends BaseDatos {
    
    private PreparedStatement sentenciaSQL;
    private ResultSet resultadoConsulta;
    
    public Hangar BuscarHangares(){
        
        Connection conexion = conectarBD();
        
        Hangar hangar = new Hangar();
        
        String consulta = "SELECT * FROM hangares";
        
        try{
            
            sentenciaSQL = conexion.prepareStatement(consulta);
            
            resultadoConsulta = sentenciaSQL.executeQuery();
            
            if(resultadoConsulta.next()){
                
                hangar.setCodigoHangar(resultadoConsulta.getInt("codigo_hangar"));
                hangar.setCuposTotales(resultadoConsulta.getInt("cupos_totales"));
                hangar.setCuposDisponibles(resultadoConsulta.getInt("cupos_disponibles"));
                hangar.setCuposReservados(resultadoConsulta.getInt("cupos_reservados"));
                
                return hangar;
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
                System.out.println("error: "+e);
            }
            
        }
        
    }
    
}

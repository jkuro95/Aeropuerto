/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author juanr
 */
public class ActualizarHangar extends BaseDatos{
    private PreparedStatement sentenciaSQL;
    
    public void actualizarHangar(Hangar hangar){
        
        Connection conexion = conectarBD();
        
        String consulta ="UPDATE hangares SET cupos_disponibles=?, cupos_reservados=? WHERE codigo_hangar=?";
        
        try{
            
            sentenciaSQL = conexion.prepareStatement(consulta);
            
            sentenciaSQL.setInt(1, hangar.getCuposDisponibles());
            sentenciaSQL.setInt(2, hangar.getCuposReservados());
            sentenciaSQL.setInt(3, hangar.getCodigoHangar());
            
            int resultado = sentenciaSQL.executeUpdate();
            
            if(resultado > 0){
                System.out.println("Exito actualizando cupos");
            }else{
                System.out.println("Error al actualizar cupos");
            }
            
        }catch(Exception e){
            System.out.print("No se puedo registrar el avion en el hangar " + e);
        }finally{
            
            try{
                conexion.close();
            }catch(Exception e){
                System.out.println("Error: "+e);
            }
            
        }
        
    }
}

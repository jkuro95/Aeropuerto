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
public class InsertarHangar extends BaseDatos{
    
    private PreparedStatement sentenciaSQL;
    
    public void insertarHangar(Hangar hangar){
        
        Connection conexion = conectarBD();
        String consulta = "INSERT INTO hangares (codigo_hangar, cupos_totales, cupos_disponibles, cupos_reservados)"
                + "VALUES(?,?,?,?)";
        
        try{
            
            sentenciaSQL = conexion.prepareStatement(consulta);
            
            sentenciaSQL.setInt(1, hangar.getCodigoHangar());
            sentenciaSQL.setInt(2, hangar.getCuposTotales());
            sentenciaSQL.setInt(3, hangar.getCuposDisponibles());
            sentenciaSQL.setInt(4, hangar.getCuposReservados());
            int resultado = sentenciaSQL.executeUpdate();
            
            if(resultado > 0){
                System.out.println("Exito registrando el hangar");
            }else{
                System.out.println("Error al al crear registro");
            }
            
            
        }catch(Exception e){
            System.out.print("No se puedo registrar el hangar " + e);
        }finally{
            
            try{
                conexion.close();
            }catch(Exception e){
                System.out.println("Error: "+e);
            }
        }
    }
    
}

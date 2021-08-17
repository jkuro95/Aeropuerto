/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author juanr
 */
public class InsertarHangaresAviones extends BaseDatos{
    
    private PreparedStatement sentenciaSQL;
    private ResultSet resultadoConsulta;
    
    public void insertarAvionHangar(String matriculaAvion, int cuposDisponibles){
        
        Connection conexion = conectarBD();
        
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fechaActual = format.format(date);
        
        //Rutina para generar numero de celda(1,2,3)
        
        
        
        String consulta = "INSERT INTO hangares_aviones (codigo_hangar, matricula_avion, fecha_ingreso, numero_celda)"
                + "VALUES(?,?,?,?)";
        
                try{
            
            sentenciaSQL = conexion.prepareStatement(consulta);
            
            sentenciaSQL.setInt(1, 1);
            sentenciaSQL.setString(2, matriculaAvion);
            sentenciaSQL.setString(3, fechaActual);
            sentenciaSQL.setInt(4, (16-cuposDisponibles));
            
            int resultado = sentenciaSQL.executeUpdate();
            
            if(resultado > 0){
                System.out.println("Exito registrando el hangar_avion");
            }else{
                System.out.println("Error al al crear registro");
            }
            
            
        }catch(Exception e){
            System.out.print("No se puedo registrar el hangar_avion " + e);
        }finally{
            
            try{
                conexion.close();
            }catch(Exception e){
                System.out.println("Error: "+e);
            }
        }
        
    }
    
}

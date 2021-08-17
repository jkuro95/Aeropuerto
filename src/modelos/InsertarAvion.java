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
public class InsertarAvion extends BaseDatos{
    
    private PreparedStatement sentenciaSQL;
    
    public void insertarAvion(Avion avion){
        
        Connection conexion = conectarBD();
        String consulta = "INSERT INTO aviones (matricula_avion, modelo_avion, cedula_propietario, tipo_contrato)"
                + "VALUES(?,?,?,?)";
        
        try{
            
            sentenciaSQL = conexion.prepareStatement(consulta);
            
            sentenciaSQL.setString(1, avion.getMatriculaAvio());
            sentenciaSQL.setString(2, avion.getModeloAvion());
            sentenciaSQL.setString(3, avion.getCedulaPropietario());
            sentenciaSQL.setInt(4, avion.getTipoContrato());
            
            int resultado = sentenciaSQL.executeUpdate();
            
            if(resultado > 0){
                System.out.println("Exito registrando el avion");
            }else{
                System.out.println("Error al al crear registro");
            }
            
            
        }catch(Exception e){
            System.out.print("No se puedo registrar el avion " + e);
        }finally{
            
            try{
                conexion.close();
            }catch(Exception e){
                System.out.println("Error: "+e);
            }
        }
    }
    
}

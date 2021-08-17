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
public class InsertarPropietario extends BaseDatos{
    
    private PreparedStatement sentenciaSQL;
    
    public void insertarPropietario(Propietario propietario){
        
        Connection conexion = conectarBD();
        String consulta = "INSERT INTO propietarios (cedula_propietario, nombre, metodo_pago)"
                + "VALUES(?,?,?)";
        
        try{
            
            sentenciaSQL = conexion.prepareStatement(consulta);
            
            sentenciaSQL.setString(1, propietario.getCedula());
            sentenciaSQL.setString(2, propietario.getNombres());
            sentenciaSQL.setInt(3, propietario.getMetodoPago());
            
            int resultado = sentenciaSQL.executeUpdate();
            
            if(resultado > 0){
                System.out.println("Exito registrando el propietario");
            }else{
                System.out.println("Error al al crear registro");
            }
            
            
        }catch(Exception e){
            System.out.print("No se puedo registrar el propietario " + e);
        }finally{
            
            try{
                conexion.close();
            }catch(Exception e){
                System.out.println("Error: "+e);
            }
        }
    }
    
}

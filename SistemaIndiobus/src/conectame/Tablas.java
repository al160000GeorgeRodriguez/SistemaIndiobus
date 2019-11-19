/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conectame;

// Esta librería contiene los metodos que nos permiten vincularnos con la base de datos, asignando
//todos los controles a las variables instanciadas en la librería
import java.sql.Connection;
// Permite controlar las excepciones de las solicitudes enviadas
import java.sql.SQLException;
// Permite realizar las peticiones a la base de datos
import java.sql.PreparedStatement;
// permite recuperar los resultados de las transacciones realizaadas
import java.sql.ResultSet;
// Esta libreria gestiona las peticiones
import java.sql.Statement;
//genera numeros aleatorios
import java.util.Random;
//genera numeros aleatorios


/**
 *
 * @author WAX
 */
public class Tablas {
    public boolean BorrarTabla(Connection conexion) {
        String borrarTabla = "drop table if exists Usuarios;";
        try {
            // Se genera la sentencia
            PreparedStatement sentencia = conexion.prepareStatement(borrarTabla);
            int res = sentencia.executeUpdate();
            return true;
        } catch (SQLException sqle) {
            // solo depuracion se genera el codigo de error
            System.out.println("Instrucción incorrecta:" + sqle.getErrorCode() + " " + sqle.getMessage());
        }
        return false;
    }


    public boolean CrearTablaUsuario(Connection conexion) {
        String crearUnaTabla = "create table Usuarios(ID_Usuarios int unsigned auto_increment,Matricula mediumint unsigned, Password varchar(40) not null,  Nombre varchar(100),  Apellido varchar(100), TipoUsuario varchar(100),  primary key(ID_Usuarios) );";
        BorrarTabla(conexion);
    try {
            // Se genera la sentencia
            PreparedStatement sentencia = conexion.prepareStatement(crearUnaTabla);
            int res = sentencia.executeUpdate();
            return true;
        } catch (SQLException sqle) {
            // solo depuracion se genera el codigo de error
            System.out.println("Instrucción incorrecta:" + sqle.getErrorCode() + " " + sqle.getMessage());
        }
    return false;
    }
}

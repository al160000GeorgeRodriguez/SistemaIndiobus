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
    public boolean BorrarTabla(Connection conexion, String Tabla) {
        String borrarTabla = "drop table if exists "+Tabla+";";
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
        BorrarTabla(conexion,"Usuario");
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
    
    public boolean CrearTablaCRUDDatos(Connection conexion) {
        String crearUnaTabla = "create table CRUD_Datos(ID_Registro int unsigned auto_increment, Hora varchar(20) not null, Fecha varchar(20) not null,   Estatus varchar(100), Ruta varchar(100), Matricula mediumint unsigned,NumCamion mediumint unsigned,  primary key(ID_Registro) );";
        BorrarTabla(conexion,"CRUD_Datos");
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
    public boolean LlenarTablaCRUDDatos(Connection conexion) {
        Random rnd = new Random();
        
        String nombreAle[] = { "Jaime", "Javier", "Juan", "Rodolfo", "Dexter", "Dulce", "Salvador", "Penelope", "Sara",
                "José" };
        String apellidoAle[] = { "Soria", "Smith", "Chilorio", "Sulvarán", "Cruz", "Chuk", "Corsario", "Chong",
                "Jimenez", "Gutierrez", "Fernández", "Hernández", "López", "Vázquez", "Rocha", "Slim" };
        String nom = nombreAle[rnd.nextInt(9)], ase = nombreAle[rnd.nextInt(9)];
        String apeP = apellidoAle[rnd.nextInt(15)], apeM = apellidoAle[rnd.nextInt(15)];
        String tel;
        Integer num, nRegistros;

        do {
            num = rnd.nextInt(9999999);
        } while (num < 999999);
        tel = Integer.toString(num);
               String dataTemporalC = "INSERT INTO lc78dKy0WL.CRUD_Datos (ID_Registro, Hora, Fecha,Estatus,Ruta,Matricula,NumCamion) VALUES "
                + "('" + nom + "','" + apeP + "','" + apeM + "', '(656)" + tel + "','" + nom + "_" + apeP + "_" + apeM
                + "@correo.com','" + ase + "')";
        try {
            // Se genera la sentencia
            PreparedStatement sentencia = conexion.prepareStatement(dataTemporalC);
            int res = sentencia.executeUpdate();
            return true;
        } catch (SQLException sqle) {
            // solo depuracion se genera el codigo de error
            System.out.println("Instrucción incorrecta:" + sqle.getErrorCode() + " " + sqle.getMessage());
        }
        return false;
    }
    public boolean LlenarTablaUsuarios(Connection conexion) {
        Random rnd = new Random();
        
        String nombreAle[] = { "Jaime","Evo","Andrés","Felipe","Vicente","Javier", "Juan", "Rodolfo", "Dexter", "Dulce", "Salvador", "Penelope", "Sara",
                "José" };
        String apellidoAle[] = { "Soria", "Smith", "Chilorio", "Sulvarán", "Cruz", "Chuk", "Corsario", "Chong",
                "Jimenez", "Gutierrez", "Fernández", "Hernández", "López", "Vázquez", "Rocha", "Slim" };
        String nom = nombreAle[rnd.nextInt(9)], ase = nombreAle[rnd.nextInt(9)];
        String apeP = apellidoAle[rnd.nextInt(15)], apeM = apellidoAle[rnd.nextInt(15)];
        String mat;
        Integer num;

        do {
            num = rnd.nextInt(200000);
        } while (!(num>10000 && num < 200000));
        mat = Integer.toString(num);
               String dataTemporalC = "INSERT INTO lc78dKy0WL.Usuarios( Matricula, Password,Nombre,Apellido,TipoUsuario) VALUES "
                + "('" + mat + "','" + nom + "123" + "','" + nom + "','" + apeP +" "+ apeM + "','" + "Alumno" + "');";
        try {
            // Se genera la sentencia
            PreparedStatement sentencia = conexion.prepareStatement(dataTemporalC);
            int res = sentencia.executeUpdate();
            return true;
        } catch (SQLException sqle) {
            // solo depuracion se genera el codigo de error
            System.out.println("Instrucción incorrecta:" + sqle.getErrorCode() + " " + sqle.getMessage());
        }
        return false;
    }
}

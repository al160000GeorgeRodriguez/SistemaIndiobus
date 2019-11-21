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
import Actividades.CRUD_Usuarios.Usuarios;
import Actividades.CrudDatos;
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
    
    public boolean CrearTablaCRUDDatos(Connection conexion) {
        String crearUnaTabla = "create table CRUD_Datos(ID_Registro int unsigned auto_increment, Hora varchar(20) not null, "
                + "Fecha varchar(20) not null,   Estatus varchar(100), Ruta varchar(100), Matricula mediumint unsigned,NumCamion mediumint unsigned,  "
                + "primary key(ID_Registro) );";
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
    public boolean LlenarTablaCRUDDatos(Connection conexion) {
        Random rnd = new Random();
        
        String matricula[] = { "8632531", "2312931", "9851538", "3698565", "1788656", "9655666", "3542555", "1454556", "9867532",
                "3652545" };
        String status[] = { "Entrada", "Salida" };
        String rutas[] = { "Torres Henequen", "Torres libramiento","Plaza Juarez", "Independencia",
                "Misiones", "Aztecas", "Centro", "Panamericana" };
        
        String mat = matricula[rnd.nextInt(9)];
        String sta = status[rnd.nextInt(1)];
        String rut = rutas[rnd.nextInt(7)];
        String hora,fecha,camion;
        Integer num;
        do{
       num = rnd.nextInt(20);
        } while(num<8);
        hora = Integer.toString(num);
        
        do {   
            num = rnd.nextInt(9999);
        } while (num < 100);
        camion = Integer.toString(num);
            num = rnd.nextInt(27)+1;
        fecha = Integer.toString(num) + "/";
            num = rnd.nextInt(11)+1;
        fecha += Integer.toString(num) + "/19";
        
               String dataTemporalC = "INSERT INTO lc78dKy0WL.CRUD_Datos(Hora, Fecha,Estatus,Ruta,Matricula,NumCamion) VALUES "
                + "('" + hora + "','" + fecha+ "','" + sta + "', '" + rut + "','" + mat +"','" + camion + "');";
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

        String nombreAle[] = { "Jaime", "Evo", "Andrés", "Felipe", "Vicente", "Javier", "Juan", "Rodolfo", "Dexter",
                "Dulce", "Salvador", "Penelope", "Sara", "José" };
        String apellidoAle[] = { "Soria", "Smith", "Chilorio", "Sulvarán", "Cruz", "Chuk", "Corsario", "Chong",
                "Jimenez", "Gutierrez", "Fernández", "Hernández", "López", "Vázquez", "Rocha", "Slim" };
        String nom = nombreAle[rnd.nextInt(11)], ase = nombreAle[rnd.nextInt(11)];
        String apeP = apellidoAle[rnd.nextInt(15)], apeM = apellidoAle[rnd.nextInt(15)];
        String mat;
        Integer num;

        do {
            num = rnd.nextInt(200000);
        } while (!(num > 100000 && num < 200000));
        mat = Integer.toString(num);
        String dataTemporalC = "INSERT INTO lc78dKy0WL.Usuarios( Matricula, Password,Nombre,Apellido,TipoUsuario) VALUES "
                + "('" + mat + "','" + nom + "123" + "','" + nom + "','" + apeP + " " + apeM + "','" + "Alumno" + "');";
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
    
    public boolean login(Connection conexion,Usuarios usuario) {
        ResultSet rs = null;
        String base = "SELECT password FROM lc78dKy0WL.Usuarios WHERE matricula='"+usuario.getMatricula()+"'";
        //Se conjunta la base con la estructura elegida
        try {
            PreparedStatement sentencia = conexion.prepareStatement(base);
            rs = sentencia.executeQuery(base);
            while (rs.next()) {
                System.out.println("Base de datos="+rs.getString("Password"));
                if (rs.getString("Password").equals(usuario.getPassword())) return true;
            }
        } catch (SQLException sqle) {
    }
        return false;
}
}


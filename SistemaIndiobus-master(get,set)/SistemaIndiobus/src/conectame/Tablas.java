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
import Actividades.Datos;
/**
 *
 * @author WAX
 */
public class Tablas {
    public boolean BorrarTabla(Connection conexion,String tabla) {
        String borrarTabla = "drop table if exists "+ tabla+";";
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
        BorrarTabla(conexion, "Usuarios");
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
        String crearUnaTabla = "create table CRUD_Datos(ID_Registro int unsigned auto_increment, Hora varchar(20) not null,Fecha varchar(100) not null,Estatus varchar(100), Ruta varchar(100),Concesionaria varchar(100), Matricula mediumint unsigned,NumCamion mediumint unsigned,primary key(ID_Registro) );";
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
        
        String matricula[] = { "8632531", "2312931", "9851538", "3698565", "1788656", "9655666", "3542555", "1454556", "9867532",
                "3652545" };
        String status[] = { "Entrada", "Salida" };
        String rutas[] = { "Torres Henequen", "Torres libramiento","Plaza Juarez", "Independencia",
                "Misiones", "Aztecas", "Centro", "Panamericana" };
                String meses[] = {"Ene","Feb","Mar","Abr","May","Jun","Jul","Ago","Sep","Oct","Nov","Dic"};
        String mat = matricula[rnd.nextInt(9)];
        String sta = status[rnd.nextInt(2)];
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
            num = rnd.nextInt(12);
        fecha += meses[num] + "/19";
        
               String dataTemporalC = "INSERT INTO lc78dKy0WL.CRUD_Datos(Hora, Fecha,Estatus,Ruta,Concesionaria,Matricula,NumCamion) VALUES "
                + "('" + hora + "','" + fecha+ "','" + sta + "', '" + rut + "','RCJ','"+ mat +"','" + camion + "');";
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
    
    public boolean login(Connection conexion, Usuarios usuario) {
        ResultSet rs = null;
        String base = "SELECT password FROM lc78dKy0WL.Usuarios WHERE matricula='" + usuario.getMatricula() + "'";
        //Se conjunta la base con la estructura elegida
        try {
            PreparedStatement sentencia = conexion.prepareStatement(base);
            rs = sentencia.executeQuery(base);
            while (rs.next()) {
                System.out.println("Base de datos=" + rs.getString("Password"));
                if (rs.getString("Password").equals(usuario.getPassword()))
                    return true;
            }
        } catch (SQLException sqle) {
            System.out.println("Instrucción incorrecta:" + sqle.getErrorCode() + " " + sqle.getMessage());
        }
        return false;
    }

    public boolean CrudDatosGuardar(Connection conexion,Datos datos) {
               String data = "INSERT INTO lc78dKy0WL.CRUD_Datos(Hora, Fecha,Estatus,Ruta,Concesionaria,Matricula,NumCamion) VALUES "
                + "('" + datos.getHora()+ "','" + datos.getFecha()+ "','" + datos.getEstatus() + "', '" + datos.getRuta() + "','" + datos.getConsecionaria() + "','"+ datos.getMatricula() +"','" + datos.getNumcamion()+ "');";
        try {
            // Se genera la sentencia
            PreparedStatement sentencia = conexion.prepareStatement(data);
            int res = sentencia.executeUpdate();
            return true;
        } catch (SQLException sqle) {
            // solo depuracion se genera el codigo de error
            System.out.println("Instrucción incorrecta:" + sqle.getErrorCode() + " " + sqle.getMessage());
        }
        return false;
    }
        public boolean CrudDatosGuardar(Connection conexion,Usuarios usuario) {
               String data = "INSERT INTO lc78dKy0WL.Usuarios( Matricula, Password,Nombre,Apellido,TipoUsuario) VALUES "
                + "('" + usuario.getMatricula()+ "','" + usuario.getPassword()+ "','" + usuario.getNombre() + "', '" + usuario.getApellido() + "','" + usuario.getTipoUsuario()+ "');";
        try {
            // Se genera la sentencia
            PreparedStatement sentencia = conexion.prepareStatement(data);
            System.out.println("Data:"+data);
            int res = sentencia.executeUpdate();
            return true;
        } catch (SQLException sqle) {
            // solo depuracion se genera el codigo de error
            System.out.println("Instrucción incorrecta:" + sqle.getErrorCode() + " " + sqle.getMessage());
        }
        return false;
    }
        public ResultSet CrudDatosListarTodo(Connection conexion) {
        // Se crea la variable para resultados
        ResultSet rs = null;
        String busqueda = "SELECT ID_Registro,Hora, Fecha,Estatus,Ruta,Concesionaria,Matricula,NumCamion FROM lc78dKy0WL.CRUD_Datos";
        try {
            PreparedStatement sentencia = conexion.prepareStatement(busqueda);
            rs = sentencia.executeQuery();
        } catch (SQLException sqle) {
            // solo depuracion
            System.out.println("Instrucción incorrecta:" + sqle.getErrorCode() + " " + sqle.getMessage());
        }
        //     conexion.cerrarConexion();
        return rs;
               }
               
        public ResultSet CrudDatosBuscar(Connection conexion,Datos datos) {
        // Se crea la variable para resultados
        ResultSet rs = null;
        Boolean sentenciaPrevia = false;
        String busqueda = "";
        Datos datosaux=datos;
        // Si no se ingresa un dato se muestra todo
        String base = "SELECT ID_Registro,Hora, Fecha,Estatus,Ruta,Concesionaria,Matricula,NumCamion FROM lc78dKy0WL.CRUD_Datos WHERE ";
        if (datosaux.getIDcruddatos()==0) {
            busqueda += "(ID_Registro='" + datosaux.getIDcruddatos() + "')";
            sentenciaPrevia=true;
        }
        if (!datosaux.getHora().isEmpty()) {
            if(sentenciaPrevia)
                busqueda += " AND ";
            busqueda += "(Hora='" + datosaux.getHora() + "')";
            sentenciaPrevia=true;
        }
        if (!datosaux.getFecha().isEmpty()) {
            if(sentenciaPrevia)
                busqueda += " AND ";
            busqueda += "(Fecha='" + datosaux.getFecha() + "')";
            sentenciaPrevia=true;
        }
            System.out.println("datosaux.getEstatus()="+datosaux.getEstatus());
            System.out.println("datosaux.getEstatus().length()="+datosaux.getEstatus().length());
        if (!(datosaux.getEstatus().isEmpty() )) {
            if(sentenciaPrevia)
                busqueda += " AND ";
            busqueda += "(Estatus='" + datosaux.getEstatus() + "')";
            sentenciaPrevia=true;
        }
        if (!datosaux.getRuta().isEmpty()) {
            if(sentenciaPrevia)
                busqueda += " AND ";
            busqueda += "(Ruta='" + datosaux.getRuta() + "')";
            sentenciaPrevia=true;
        }
        if (datosaux.getMatricula()!=0) {
            if(sentenciaPrevia)
                busqueda += " AND ";
            busqueda += "(Matricula='" + datosaux.getMatricula() + "')";
            sentenciaPrevia=true;
        }
        if (datosaux.getNumcamion()!=0) {
            if(sentenciaPrevia)
                busqueda += " AND ";
            busqueda += "(NumCamion='" + datosaux.getNumcamion() + "')";
        }

        // Se conjunta la base con la estructura elegida
        busqueda = base + busqueda;
        System.out.println(busqueda);
        try {
            PreparedStatement sentencia = conexion.prepareStatement(busqueda);
            rs = sentencia.executeQuery();
        } catch (SQLException sqle) {
            // solo depuracion
            System.out.println("Instrucción incorrecta:" + sqle.getErrorCode() + " " + sqle.getMessage());
        }
        //     conexion.cerrarConexion();
        return rs;

        }

}


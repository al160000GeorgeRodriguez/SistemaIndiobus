/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actividades.CRUD_Usuarios;

/**
 *
 * @author George
 */
public class Usuarios {
    private int Id_Usuarios, Matricula;
    private String  Password, Nombre, Apellido, TipoUsuario;

    Usuarios(int id_usuario, int matricula, String password, String nombre, String apellido, String tipousuario) {
        this.Id_Usuarios = id_usuario;
        this.Matricula = matricula;
        this.Password = password;
        this.Nombre = nombre;
        this.Apellido = apellido;
        this.TipoUsuario = tipousuario;
    }
    Usuarios(int matricula, String password) {
        this.Matricula = matricula;
        this.Password = password;
    }

    public Usuarios() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public int getId_Usuarios(){
        return Id_Usuarios;
    }
    public void setId_Usuarios(int Id_Usuarios){
        this.Id_Usuarios=Id_Usuarios;
    }
    public int getMatricula(){
        return Matricula;
    }
    public void setMatricula(int Matricula){
        this.Matricula=Matricula;
    }
    public String getPassword(){
        return Password;
    }
    public void setPassword(String Password){
        this.Password=Password;
    }
    public String getNombre(){
        return Nombre;
    }
    public void setNombre(String Nombre){
        this.Nombre=Nombre;
    }
    public String getApellido(){
        return Apellido;
    }
    public void setApellido(String Apellido){
        this.Apellido=Apellido;
    }
    public String getTipoUsuario(){
        return TipoUsuario;
    }
    public void setTipoUsuario(String TipoUsuario){
        this.TipoUsuario=TipoUsuario;
    }
    
    
}

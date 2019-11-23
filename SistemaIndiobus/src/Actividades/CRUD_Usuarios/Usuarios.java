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
    private int Id_Usuarios,Matricula;
    private String Password, Nombre, Apellido, TipoUsuario;

    public Usuarios(int Id_Usuarios, int Matricula, String Password, String Nombre, String Apellido, String TipoUsuario) {
        this.Id_Usuarios = Id_Usuarios;
        this.Matricula = Matricula;
        this.Password = Password;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.TipoUsuario = TipoUsuario;
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

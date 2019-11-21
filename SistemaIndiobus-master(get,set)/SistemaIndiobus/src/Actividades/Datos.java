/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actividades;


/**
 *
 * @author Rudy
 */
public class Datos {
     int ID_Registro;
    String hora;
    String fecha;
    String estatus;
    String ruta;
    String consecionaria;
    int matricula;//matricula de los alumnos que abordan indiobus
    int numcamion;//numero de undiobus 
    
    
     public Datos(int IDcruddatos, String hora, String fecha, String estatus, String ruta, String consecionaria, int matricula, int numcamion) {
        this.ID_Registro = IDcruddatos;
        this.hora = hora;
        this.fecha = fecha;
        this.estatus = estatus;
        this.ruta = ruta;
        this.consecionaria = consecionaria;
        this.matricula = matricula;
        this.numcamion = numcamion;
    }

    public int getIDcruddatos() {
        return ID_Registro;
    }

    public void setIDcruddatos(int ID_Registro) {
        this.ID_Registro = ID_Registro;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getConsecionaria() {
        return consecionaria;
    }

    public void setConsecionaria(String consecionaria) {
        this.consecionaria = consecionaria;
    }

    public int getMatricula() {
        return matricula;
       
    }

    public void setMatricula(int matricula) {
        
        this.matricula = matricula;
        
    }

    public int getNumcamion() {
        return numcamion;
    }

    public void setNumcamion(int numcamion) {
        this.numcamion = numcamion;
    }
    
}

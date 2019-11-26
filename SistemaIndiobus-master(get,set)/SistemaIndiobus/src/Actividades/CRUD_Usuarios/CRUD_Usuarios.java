/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actividades.CRUD_Usuarios;

import Actividades.Datos;
import Menu.Menu;
import conectame.Conexion;
import conectame.Tablas;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;



/**
 *
 * @author compu
 */


public class CRUD_Usuarios extends javax.swing.JFrame {

  
    /**
     * Creates new form CRUD_Usuarios
     */
    public CRUD_Usuarios() {
        initComponents();
        iniciarComponentes();
        
    }
    
    int id_usuario;// id del usuario default de tipo entero
    protected int matricula;// matricula del usuario protegido tipo entero
    protected String password;// contrase;a del usuario string tipo protected
    private String nombre;// nombre del usuario tipo string privado
    private String apellido;//apellido del usuario tipo string privado
    String tipousuario;// definicion del usuariio dentro de la organizacion empresarial tipo String default
   
      
    
  void iniciarComponentes()
    {
rellenarDatos();
    }
  
    ArrayList<Usuarios> lista = new ArrayList<Usuarios>();
    Conexion conexion = new Conexion();
    private Connection miConnection= null;
    Tablas tabla = new Tablas();
    private void cerrarConexion() {
        conexion.cerrarConexion();
    }

    private void iniciarBaseDatos() {
                conexion.setUsuario("lc78dKy0WL");
        conexion.setPassword("o4sjumW5GZ");
        conexion.setTipo("mysql");
        conexion.setURL("remotemysql.com");
        conexion.setPuerto(3306);
        conexion.setDbase("lc78dKy0WL");
        conexion.setOpciones("autoReconnect=true&useSSL=false");
        //Se manada a llamar la conexion
        miConnection = conexion.conexionDB();
        //tabla.CrearTablaUsuario(miConexion);
        tabla.LlenarTablaUsuarios(miConnection);
    }
   
    void rellenarDatos(){
        iniciarBaseDatos();
        ResultSet rs =tabla.CrudUsuariosListarTodo(miConnection);
        try {
            int i=0; 
           while (rs.next()) {
               //ID_Usuarios,Matricula, Password,Nombre,Apellido,TipoUsuario
        Usuarios usuario=new Usuarios(Integer.parseInt(rs.getString("ID_Usuarios")),Integer.parseInt(rs.getString("Matricula")),rs.getString("Password"),rs.getString("Nombre"),rs.getString("Apellido"),rs.getString("TipoUsuario"));
           IDusuario.setText(String.valueOf(Integer.parseInt(rs.getString("ID_Usuarios"))+1));    
           lista.add(i,usuario);
           i++;
                  }
         Object matris[][] = new Object[lista.size()][8];
            
             for(int j=0; j<lista.size(); j++)
             {
                matris[j][0]=lista.get(j).getId_Usuarios();
            matris[j][1]=lista.get(j).getMatricula();
            matris[j][2]=lista.get(j).getPassword(); 
           matris[j][3]=lista.get(j).getNombre();
            matris[j][4]=lista.get(j).getApellido();
            matris[j][5]=lista.get(j).getTipoUsuario();
            }

            if (i == 0){                System.out.println("Sin resultados");}
            else {                        
                TB.setModel(new javax.swing.table.DefaultTableModel(matris,new String [] {"ID", "Hora", "Fecha", "Estatus", "Ruta", "Concesionaria", "Matricula", "No.Camion"
            }     ));
            }

                
        } catch (SQLException sqle) {
            // solo depuracion
            System.out.println("Instrucción incorrecta:" + sqle.getErrorCode() + " " + sqle.getMessage());
        }
                cerrarConexion();
        
    }

    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPane1 = new java.awt.ScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        TB = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        IDusuario = new javax.swing.JTextField();
        Matricula = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        Contrasena = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        Nombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Apellido = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Tipousuario = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        Buscar = new javax.swing.JButton();
        crear = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        modificar = new javax.swing.JButton();
        regresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        TB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "150204", "**********", "Joaquin Kaleb", "Chavira Gonzalez", "Alumno Becario"},
                {"2", "159949", "*****", "Luis Ivan", "Valdez Anchondo", "Alumno Becario"},
                {"3", "141345", "**********", "Irvirng Johan", "Nevarez Garcia", "Alumno Becario"},
                {"4", "159905", "********", "Brandon Raul", "Montes Anchondo", "Alumno Becario"},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Matricula", "Contraseña", "Nombre", "Apellido", "Tipo de Usuario"
            }
        ));
        jScrollPane1.setViewportView(TB);

        scrollPane1.add(jScrollPane1);

        jLabel1.setText("ID:");

        IDusuario.setText("1");

        Matricula.setText("150204");

        jLabel2.setText("Matricula:");

        Contrasena.setText("jPasswordField1");

        jLabel3.setText("Contraseña:");

        Nombre.setText("Joaquin Kaleb");

        jLabel4.setText("Nombre:");

        Apellido.setText("Chavira Gonzalez");

        jLabel5.setText("Apellido:");

        Tipousuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Alumno Becario\t", "Administrador" }));

        jLabel6.setText("Tipo de Usuario:");

        Buscar.setText("Buscar");
        Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarActionPerformed(evt);
            }
        });

        crear.setText("Crear");
        crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearActionPerformed(evt);
            }
        });

        eliminar.setText("Eliminar");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

        modificar.setText("Modificar");
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });

        regresar.setText("Regresar");
        regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Tipousuario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Apellido)
                    .addComponent(Nombre)
                    .addComponent(Contrasena)
                    .addComponent(Matricula)
                    .addComponent(IDusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(modificar, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                    .addComponent(crear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(708, Short.MAX_VALUE)
                .addComponent(regresar)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {Buscar, crear, eliminar, modificar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(scrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(IDusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Buscar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Matricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Contrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(eliminar)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(crear)
                        .addGap(32, 32, 32)
                        .addComponent(modificar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Tipousuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(regresar)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {Buscar, crear, eliminar, modificar, regresar});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarActionPerformed
        Menu ir = new Menu();
        ir.setVisible(true);
        this.dispose();        // TODO add your handling code here:        // TODO add your handling code here:
    }//GEN-LAST:event_regresarActionPerformed

    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarActionPerformed
       id_usuario = Integer.parseInt(IDusuario.getText());
        for(int i=0; i<lista.size(); i++){
           if(id_usuario == lista.get(i).getId_Usuarios()){
         Object matris[][] = new Object [lista.size()][8];
                matris[i][0]=lista.get(i).getId_Usuarios();
            matris[i][1]=lista.get(i).getMatricula();
            matris[i][2]=lista.get(i).getPassword(); 
           matris[i][3]=lista.get(i).getNombre();
            matris[i][4]=lista.get(i).getApellido();
            matris[i][5]=lista.get(i).getTipoUsuario();
           TB.setModel(new javax.swing.table.DefaultTableModel(
            matris,
            new String [] {
                "ID", "Hora", "Fecha", "Estatus", "Ruta", "Concesionaria", "Matricula", "No.Camion"
            }     ));
           }      
           
        }
   
       
       /*IDusuario.setText("");
       Matricula.setText("");
       Contrasena.setText("");
       .setText("");
       NoCamion.setText("");*/
       
        
    }//GEN-LAST:event_BuscarActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
             id_usuario= Integer.parseInt(IDusuario.getText());
matricula= Integer.parseInt(Matricula.getText());
password = Arrays.toString(Contrasena.getPassword());
nombre= Nombre.getText();
apellido= Apellido.getText();
tipousuario = Tipousuario.getSelectedItem().toString();       
        try {



Usuarios crud = new Usuarios(id_usuario,matricula,password,nombre,apellido,tipousuario);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_eliminarActionPerformed

    private void crearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearActionPerformed
 
id_usuario= Integer.parseInt(IDusuario.getText());
matricula= Integer.parseInt(Matricula.getText());
password = Arrays.toString(Contrasena.getPassword());
nombre= Nombre.getText();
apellido= Apellido.getText();
tipousuario = Tipousuario.getSelectedItem().toString();


Usuarios crud = new Usuarios(id_usuario,matricula,password,nombre,apellido,tipousuario);
     if (IDusuario.getText().isEmpty()||Matricula.getText().isEmpty()||Contrasena.getText().isEmpty()||Nombre.getText().isEmpty()||Apellido.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this,"FALTA LLENAR UN CAMPO");
        } else{

        lista.add(crud);
        iniciarBaseDatos();
        tabla.CrudDatosGuardar(miConnection, crud);
        cerrarConexion();
        Object matris[][] = new Object [lista.size()][8];

        
         for(int i=0; i<lista.size(); i++){
           
            
            matris[i][0]=lista.get(i).getId_Usuarios();
            matris[i][1]=lista.get(i).getMatricula();
            matris[i][2]=lista.get(i).getPassword();
            matris[i][3]=lista.get(i).getNombre();
            matris[i][4]=lista.get(i).getApellido();
            matris[i][5]=lista.get(i).getTipoUsuario();
            
           
        }
        TB.setModel(new javax.swing.table.DefaultTableModel(
            matris,
            new String [] {
                "ID Usuario", "Matricula", "Contraseña", "Nombre", "Apellido", "Tipo de Usuario"
            }
        ));
     }

    }//GEN-LAST:event_crearActionPerformed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        // TODO add your handling code here:
            id_usuario= Integer.parseInt(IDusuario.getText());
matricula= Integer.parseInt(Matricula.getText());
password = Arrays.toString(Contrasena.getPassword());
nombre= Nombre.getText();
apellido= Apellido.getText();
tipousuario = Tipousuario.getSelectedItem().toString();
        try {
        Usuarios usuario = new Usuarios(id_usuario,matricula,password,nombre,apellido,tipousuario);
        iniciarBaseDatos();
        if(tabla.ActualizarUsuarios(miConnection, usuario))
                System.out.println("Se actualizó el usuario");
        else System.out.println("No se pudo actualizar");
        cerrarConexion();
        rellenarDatos();
        
        } catch (Exception e) {
            
        }
    }//GEN-LAST:event_modificarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
                Menu ir = new Menu();
        ir.setVisible(true);
        this.dispose(); 
    }//GEN-LAST:event_formWindowClosed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CRUD_Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CRUD_Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CRUD_Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CRUD_Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CRUD_Usuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Apellido;
    private javax.swing.JButton Buscar;
    protected javax.swing.JPasswordField Contrasena;
    javax.swing.JTextField IDusuario;
    protected javax.swing.JTextField Matricula;
    private javax.swing.JTextField Nombre;
    private javax.swing.JTable TB;
    javax.swing.JComboBox<String> Tipousuario;
    private javax.swing.JButton crear;
    private javax.swing.JButton eliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton modificar;
    private javax.swing.JButton regresar;
    private java.awt.ScrollPane scrollPane1;
    // End of variables declaration//GEN-END:variables

    
}

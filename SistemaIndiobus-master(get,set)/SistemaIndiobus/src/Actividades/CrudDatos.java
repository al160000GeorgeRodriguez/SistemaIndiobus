/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actividades;


//import com.mysql.jdbc.Connection;
import Actividades.CRUD_Usuarios.CRUD_Usuarios;
import Menu.Menu;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import conectame.Conexion;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import conectame.Tablas;
import conectame.valoresConexion;
import Menu.Menu;
import Actividades.Datos;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
public class CrudDatos extends javax.swing.JFrame {
    
    int ID_Registro;
  
    ArrayList<Datos> lista = new ArrayList<Datos>();
    /**
     * Creates new form CrudDatos
     */
    public CrudDatos() {
        initComponents();
        iniciarComponentes();
      
    }
  void iniciarComponentes()
    {
rellenarDatos();
    }
   
    Conexion conexion = new Conexion();
    private Connection miConexion = null;
    Tablas tabla = new Tablas();
        
    void iniciarBaseDatos() {
        conexion.setUsuario("lc78dKy0WL");
        conexion.setPassword("o4sjumW5GZ");
        conexion.setTipo("mysql");
        conexion.setURL("remotemysql.com");
        conexion.setPuerto(3306);
        conexion.setDbase("lc78dKy0WL");
        conexion.setOpciones("autoReconnect=true&useSSL=false");
        //Se manada a llamar la conexion
        miConexion = conexion.conexionDB();
    }

    void cerrarConexion() {
          conexion.cerrarConexion();  
    }
   
    void rellenarDatos(){
        iniciarBaseDatos();
        ResultSet rs =tabla.CrudDatosListarTodo(miConexion);
        
        try {
            int i=0; 
           while (rs.next()) {
        Datos datos=new Datos();
           datos.setIDcruddatos(Integer.parseInt(rs.getString("ID_Registro")));
           IDCrudDatos.setText(String.valueOf(Integer.parseInt(rs.getString("ID_Registro"))+1));    
           datos.setHora(rs.getString("Hora"));
           datos.setFecha(rs.getString("Fecha"));
           datos.setEstatus(rs.getString("Estatus"));
           datos.setRuta(rs.getString("Ruta"));
           datos.setConsecionaria(rs.getString("Concesionaria"));
           datos.setMatricula(Integer.parseInt( rs.getString("Matricula")));
           datos.setNumcamion(Integer.parseInt( rs.getString("NumCamion")));
           lista.add(i,datos);
           i++;
                  }
         Object matris[][] = new Object[lista.size()][8];
             for(int j=0; j<lista.size(); j++)
             {
                matris[j][0] = lista.get(j).getIDcruddatos();                 
                matris[j][1] = lista.get(j).getHora();
                matris[j][2] = lista.get(j).getFecha();
                matris[j][3] = lista.get(j).getEstatus();
                matris[j][4] = lista.get(j).getRuta();
                matris[j][5] = lista.get(j).getConsecionaria();
                matris[j][6] = lista.get(j).getMatricula();
                matris[j][7] = lista.get(j).getNumcamion();
            }

            if (i == 0){                System.out.println("Sin resultados");}
            else {             jTable1.setModel(new javax.swing.table.DefaultTableModel(matris, new String[] { "ID", "Hora", "Fecha",
                    "Estatus", "Ruta", "Concesionaria", "Matricula", "No.Camion" }));}

                
        } catch (SQLException sqle) {
            // solo depuracion
            System.out.println("Instrucción incorrecta:" + sqle.getErrorCode() + " " + sqle.getMessage());
        }
                cerrarConexion();
        
    }

        
//constructorIDCrudDatos
    
    
  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        IDCrudDatos = new javax.swing.JTextField();
        HoraCrudDatos = new javax.swing.JTextField();
        ID = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Concesionaria = new javax.swing.JTextField();
        MatriculaCrudDatos = new javax.swing.JTextField();
        NoCamion = new javax.swing.JTextField();
        guardar = new javax.swing.JButton();
        regresar = new javax.swing.JButton();
        buscar = new javax.swing.JButton();
        modificar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        Ruta = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Date date=new Date();
        SpinnerDateModel sm=new SpinnerDateModel(date,date,date,Calendar.DAY_OF_MONTH);
        Fecha = new javax.swing.JSpinner(sm);
        Estatus = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        IDCrudDatos.setText("1");
        IDCrudDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDCrudDatosActionPerformed(evt);
            }
        });

        HoraCrudDatos.setText("20:00");
        HoraCrudDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HoraCrudDatosActionPerformed(evt);
            }
        });

        ID.setText("ID:");

        jLabel1.setText("Hora:");

        jLabel2.setText("Fecha:");

        jLabel3.setText("Estatus:");

        jLabel4.setText("Ruta:");

        jLabel5.setText("Concesionaria:");

        jLabel6.setText("Matricula:");

        jLabel7.setText("No.Camion");

        Concesionaria.setText("RCJ");

        MatriculaCrudDatos.setText("150204");
        MatriculaCrudDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MatriculaCrudDatosActionPerformed(evt);
            }
        });
        MatriculaCrudDatos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                MatriculaCrudDatosKeyTyped(evt);
            }
        });

        NoCamion.setText("5341");
        NoCamion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NoCamionKeyTyped(evt);
            }
        });

        guardar.setText("Guardar");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });

        regresar.setText("Regresar");
        regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarActionPerformed(evt);
            }
        });

        buscar.setText("Buscar");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });

        modificar.setText("Modificar");
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });

        eliminar.setText("Eliminar");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

        Ruta.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        Ruta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Torres Henequen", "Torres libramiento","Plaza Juarez", "Independencia",
            "Misiones", "Aztecas", "Centro", "Panamericana" }));
Ruta.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        RutaActionPerformed(evt);
    }
    });

    jTable1.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null}
        },
        new String [] {
            "ID", "Hora", "Fecha", "Estatus", "Ruta", "Concesionaria", "Matricula", "No.Camion"
        }
    ));
    jScrollPane1.setViewportView(jTable1);

    JSpinner.DateEditor de =new JSpinner.DateEditor(Fecha,"dd/MM/yy");
    Fecha.setEditor(de);
    Fecha.setModel(new javax.swing.SpinnerDateModel());

    Estatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "entrada", "salida", " " }));

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGap(21, 21, 21)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1))
                            .addGap(58, 58, 58)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(HoraCrudDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Estatus, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createSequentialGroup()
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(IDCrudDatos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Ruta, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(MatriculaCrudDatos, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                                    .addComponent(Concesionaria)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(guardar)
                                            .addComponent(eliminar)))
                                    .addComponent(jLabel7))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(NoCamion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(regresar)
                                    .addComponent(modificar)))))))
            .addGap(56, 56, 56))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(48, 48, 48)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ID)
                        .addComponent(IDCrudDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(24, 24, 24)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(HoraCrudDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Estatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addGap(32, 32, 32)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(Ruta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(29, 29, 29)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Concesionaria, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(MatriculaCrudDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(26, 26, 26)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(NoCamion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(guardar)
                        .addComponent(regresar))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buscar)
                        .addComponent(modificar))
                    .addGap(23, 23, 23)
                    .addComponent(eliminar))
                .addGroup(layout.createSequentialGroup()
                    .addGap(28, 28, 28)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(51, Short.MAX_VALUE))
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
       
        
        Datos crud= new  Datos( Integer.parseInt(IDCrudDatos.getText()),HoraCrudDatos.getText(),Fecha.getValue().toString().substring(8,10)+"/"+Fecha.getValue().toString().substring(4,7)+"/"+Fecha.getValue().toString().substring(26,28),Estatus.getSelectedItem().toString(),Ruta.getSelectedItem().toString(),Concesionaria.getText(),Integer.parseInt(MatriculaCrudDatos.getText()),Integer.parseInt(NoCamion.getText()));
        lista.add(crud);
        System.out.println(crud.fecha);
              iniciarBaseDatos();
        tabla.CrudDatosGuardar(miConexion, crud);
        cerrarConexion();
        Object matris[][] = new Object [lista.size()][8];
      
                  IDCrudDatos.setText(String.valueOf(Integer.parseInt(IDCrudDatos.getText())+1));
        
        for(int i=0; i<lista.size(); i++){
           
            
            matris[i][0]=lista.get(i).getIDcruddatos();
            matris[i][1]=lista.get(i).getHora();
            matris[i][2]=lista.get(i).getFecha();
            matris[i][3]=lista.get(i).getEstatus();
            matris[i][4]=lista.get(i).getRuta();
            matris[i][5]=lista.get(i).getConsecionaria();
            matris[i][6]=lista.get(i).getMatricula();
            matris[i][7]=lista.get(i).getNumcamion();
           
        }
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            matris,
            new String [] {
                "ID", "Hora", "Fecha", "Estatus", "Ruta", "Concesionaria", "Matricula", "No.Camion"
            }
        ));
       
        /*iniciarBaseDatos();
        CrudDatos d =new CrudDatos ();
        Tablas tabla= new Tablas();
        d.setIDcruddatos(Integer.parseInt( IDCrudDatos.getText()));
        d.setHora(HoraCrudDatos.getText());
        d.setFecha(Fecha.getValue().toString());
        d.setEstatus(Estatus.getSelectedItem().toString());
        
        
       IDCrudDatos.setText("");
       HoraCrudDatos.setText("");
       MatriculaCrudDatos.setText("");
       MatriculaCrudDatos.setText("");
       NoCamion.setText("");*/

// TODO add your handling code here:
    }//GEN-LAST:event_guardarActionPerformed

    private void regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarActionPerformed
        Menu ir = new Menu();
        ir.setVisible(true);
        this.dispose();         // TODO add your handling code here:
    }//GEN-LAST:event_regresarActionPerformed

    private void MatriculaCrudDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MatriculaCrudDatosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MatriculaCrudDatosActionPerformed

    private void MatriculaCrudDatosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MatriculaCrudDatosKeyTyped
        char validar = evt.getKeyChar();
        if (Character.isLetter(validar)){
            getToolkit().beep();
            evt.consume();
        }       // TODO add your handling code here:
    }//GEN-LAST:event_MatriculaCrudDatosKeyTyped

    private void NoCamionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NoCamionKeyTyped
        char validar = evt.getKeyChar();
        if (Character.isLetter(validar)){
            getToolkit().beep();
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_NoCamionKeyTyped

    private void HoraCrudDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HoraCrudDatosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HoraCrudDatosActionPerformed

    private void RutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RutaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RutaActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed

    }//GEN-LAST:event_buscarActionPerformed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
   Datos dato= new  Datos( Integer.parseInt(IDCrudDatos.getText()),HoraCrudDatos.getText(),Fecha.getValue().toString().substring(8,10)+"-"+Fecha.getValue().toString().substring(4,7)+"-"+Fecha.getValue().toString().substring(26,28),Estatus.getSelectedItem().toString(),Ruta.getSelectedItem().toString(),Concesionaria.getText(),Integer.parseInt(MatriculaCrudDatos.getText()),Integer.parseInt(NoCamion.getText()));
        iniciarBaseDatos();
         if(tabla.ActualizarDatos(miConexion, dato))
                System.out.println("Se actualizó el usuario");
        else System.out.println("No se pudo actualizar");
        cerrarConexion();
        jTable1.removeAll();
        rellenarDatos();
        /*ID_Registro = Integer.parseInt(IDCrudDatos.getText());
        for(int i=0; i<lista.size(); i++){
           if(ID_Registro == lista.get(i).getIDcruddatos()){
           lista.get(i).setHora(HoraCrudDatos.getText());
           lista.get(i).setFecha(Fecha.getName());
           lista.get(i).setEstatus(Estatus.getSelectedItem().toString());
           lista.get(i).setRuta(Ruta.getSelectedItem().toString());
           lista.get(i).setConsecionaria(Concesionaria.getText());
           lista.get(i).setMatricula(Integer.parseInt( MatriculaCrudDatos.getText()));
           lista.get(i).setNumcamion(Integer.parseInt( NoCamion.getText()));

           
           }      
           
        }
        
        Object matris[][] = new Object [lista.size()][8];
      
       
        
        for(int i=0; i<lista.size(); i++){
           
            
            matris[i][0]=lista.get(i).getIDcruddatos();
            matris[i][1]=lista.get(i).getHora();
            matris[i][2]=lista.get(i).getFecha();
            matris[i][3]=lista.get(i).getEstatus();
            matris[i][4]=lista.get(i).getRuta();
            matris[i][5]=lista.get(i).getConsecionaria();
            matris[i][6]=lista.get(i).getMatricula();
            matris[i][7]=lista.get(i).getNumcamion();
           
        }
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            matris,
            new String [] {
                "ID", "Hora", "Fecha", "Estatus", "Ruta", "Concesionaria", "Matricula", "No.Camion"
            }
        ));
       
       IDCrudDatos.setText("");
       HoraCrudDatos.setText("");
       MatriculaCrudDatos.setText("");
       MatriculaCrudDatos.setText("");
       NoCamion.setText("");*/
       
        
        
    }//GEN-LAST:event_modificarActionPerformed

    private void IDCrudDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDCrudDatosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IDCrudDatosActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
       
        
        
        ID_Registro = Integer.parseInt(IDCrudDatos.getText());
        for(int i=0; i<lista.size(); i++){
           if(ID_Registro == lista.get(i).getIDcruddatos()){
          lista.remove(i);

           
           }      
        }
        
        
        Object matris[][] = new Object [lista.size()][8];
      
        for(int i=0; i<lista.size(); i++){
            matris[i][0]=lista.get(i).getIDcruddatos();
            matris[i][1]=lista.get(i).getHora();
            matris[i][2]=lista.get(i).getFecha();
            matris[i][3]=lista.get(i).getEstatus();
            matris[i][4]=lista.get(i).getRuta();
            matris[i][5]=lista.get(i).getConsecionaria();
            matris[i][6]=lista.get(i).getMatricula();
            matris[i][7]=lista.get(i).getNumcamion();
           
        }
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            matris,
            new String [] {
                "ID", "Hora", "Fecha", "Estatus", "Ruta", "Concesionaria", "Matricula", "No.Camion"
            }
        ));
    }//GEN-LAST:event_eliminarActionPerformed

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
            java.util.logging.Logger.getLogger(CrudDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrudDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrudDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrudDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrudDatos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Concesionaria;
    private javax.swing.JComboBox<String> Estatus;
    private javax.swing.JSpinner Fecha;
    private javax.swing.JTextField HoraCrudDatos;
    private javax.swing.JLabel ID;
    private javax.swing.JTextField IDCrudDatos;
    private javax.swing.JTextField MatriculaCrudDatos;
    private javax.swing.JTextField NoCamion;
    private javax.swing.JComboBox<String> Ruta;
    private javax.swing.JButton buscar;
    private javax.swing.JButton eliminar;
    private javax.swing.JButton guardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton modificar;
    private javax.swing.JButton regresar;
    // End of variables declaration//GEN-END:variables
}

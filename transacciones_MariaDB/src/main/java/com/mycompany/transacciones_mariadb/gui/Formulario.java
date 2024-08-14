/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.transacciones_mariadb.gui;

import java.sql.Connection;
import java.sql.SQLException;
import com.mycompany.transacciones_mariadb.mariaDB.ConexionCliente;
import com.mycompany.transacciones_mariadb.mariaDB.Conexion;
import com.mycompany.transacciones_mariadb.mariaDB.ConexionTelefono;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public final class Formulario extends javax.swing.JFrame {

    private Connection conexion;
    private ConexionCliente clientes;
    private Conexion conection;
    private ConexionTelefono telefono;

    /**
     *
     * @param conexion
     * @throws SQLException
     */
    public Formulario(Connection conexion) throws SQLException {
        this.conexion = conexion;
        clientes = new ConexionCliente();
        conection = new Conexion();
        telefono = new ConexionTelefono();
        initComponents();
        ButtonGroup group = new ButtonGroup();
        group.add(read_commitedbutton);
        group.add(read_uncommitedbutton);
        group.add(repeteable_readbutton);
        group.add(serializable_button);
        repeteable_readbutton.setSelected(true);
        begintable();
    }

    public void begintable() throws SQLException {
        DefaultTableModel model = (DefaultTableModel) datos_jtable.getModel();
        model.setRowCount(0); // Limpiar los datos existentes
        ResultSet resultados = clientes.consulta(conexion);
        while (resultados.next()) {
            int id = resultados.getInt("ID_Cliente");
            String nombre = resultados.getString("Nombre");
            String Apellido = resultados.getString("Apellido");
            String Direccion = resultados.getString("Direccion");
            String telefono = resultados.getString("Numero");
            model.addRow(new Object[]{id, nombre, Apellido, Direccion, telefono});
        }
    }

    public void clean() {
        Nombre_textfield.setText("");
        Apellido_textfield.setText("");
        Direccion_textfield.setText("");
        Telefonos_textfield.setText("");
    }

    private Formulario() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jRadioButton1 = new javax.swing.JRadioButton();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Nombre_textfield = new javax.swing.JTextField();
        Apellido_textfield = new javax.swing.JTextField();
        Direccion_textfield = new javax.swing.JTextField();
        Telefonos_textfield = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        datos_jtable = new javax.swing.JTable();
        guardar_jbutton = new javax.swing.JButton();
        commit_jbutton = new javax.swing.JButton();
        rollback_jbutton = new javax.swing.JButton();
        star_jbutton = new javax.swing.JButton();
        Actualizar = new javax.swing.JButton();
        read_uncommitedbutton = new javax.swing.JRadioButton();
        read_commitedbutton = new javax.swing.JRadioButton();
        repeteable_readbutton = new javax.swing.JRadioButton();
        serializable_button = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        jRadioButton1.setText("jRadioButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Formulario");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("NOMBRE");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("DIRECCION");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("TELEFONOS");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("APELLIDOS");

        Apellido_textfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Apellido_textfieldActionPerformed(evt);
            }
        });

        datos_jtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombres", "Apellidos", "Dirección ", "Telefonos"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(datos_jtable);
        if (datos_jtable.getColumnModel().getColumnCount() > 0) {
            datos_jtable.getColumnModel().getColumn(0).setResizable(false);
            datos_jtable.getColumnModel().getColumn(1).setResizable(false);
            datos_jtable.getColumnModel().getColumn(2).setResizable(false);
            datos_jtable.getColumnModel().getColumn(3).setResizable(false);
            datos_jtable.getColumnModel().getColumn(4).setResizable(false);
        }

        guardar_jbutton.setBackground(new java.awt.Color(0, 51, 153));
        guardar_jbutton.setForeground(new java.awt.Color(255, 255, 255));
        guardar_jbutton.setText("Guardar");
        guardar_jbutton.setEnabled(false);
        guardar_jbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardar_jbuttonActionPerformed(evt);
            }
        });

        commit_jbutton.setBackground(new java.awt.Color(51, 255, 51));
        commit_jbutton.setText("Commit");
        commit_jbutton.setEnabled(false);
        commit_jbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commit_jbuttonActionPerformed(evt);
            }
        });

        rollback_jbutton.setBackground(new java.awt.Color(255, 0, 0));
        rollback_jbutton.setText("Rollback");
        rollback_jbutton.setEnabled(false);
        rollback_jbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rollback_jbuttonActionPerformed(evt);
            }
        });

        star_jbutton.setText("Iniciar transaccion");
        star_jbutton.setActionCommand("Iniciar transacción");
        star_jbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                star_jbuttonActionPerformed(evt);
            }
        });

        Actualizar.setText("Actualizar");
        Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarActionPerformed(evt);
            }
        });

        read_uncommitedbutton.setText("Read_uncommited");
        read_uncommitedbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                read_uncommitedbuttonActionPerformed(evt);
            }
        });

        read_commitedbutton.setText("Read_commited");

        repeteable_readbutton.setText("Repeteable_read");
        repeteable_readbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repeteable_readbuttonActionPerformed(evt);
            }
        });

        serializable_button.setText("Serializable");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Selección del nivel de aislamiento:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Nombre_textfield)
                                    .addComponent(Direccion_textfield, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Telefonos_textfield, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(star_jbutton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(guardar_jbutton)
                                .addGap(56, 56, 56)
                                .addComponent(Actualizar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(commit_jbutton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rollback_jbutton)))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Apellido_textfield))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addComponent(read_uncommitedbutton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(read_commitedbutton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(repeteable_readbutton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(serializable_button)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(280, 280, 280))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(read_uncommitedbutton)
                    .addComponent(read_commitedbutton)
                    .addComponent(repeteable_readbutton)
                    .addComponent(serializable_button)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Nombre_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(Apellido_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(Direccion_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(Telefonos_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(commit_jbutton)
                    .addComponent(rollback_jbutton)
                    .addComponent(Actualizar)
                    .addComponent(guardar_jbutton)
                    .addComponent(star_jbutton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void star_jbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_star_jbuttonActionPerformed
        guardar_jbutton.setEnabled(true);
        commit_jbutton.setEnabled(true);
        rollback_jbutton.setEnabled(true);
        star_jbutton.setEnabled(false);
        if (read_commitedbutton.isSelected()){
            conection.establecerReadCommitted(conexion);
        }
        else if (read_uncommitedbutton.isSelected()){
            conection.establecerReadUncommitted(conexion);
        }
        else if (repeteable_readbutton.isSelected()){
            conection.establecerRepeatableRead(conexion);
        }
        else if (serializable_button.isSelected()){
            conection.establecerSerializable(conexion);
        }
        
        conection.iniciarTransaccion(conexion);
        read_commitedbutton.setEnabled(false);
        read_uncommitedbutton.setEnabled(false);
        repeteable_readbutton.setEnabled(false);
        serializable_button.setEnabled(false);
        
    }//GEN-LAST:event_star_jbuttonActionPerformed

    private void guardar_jbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardar_jbuttonActionPerformed
        String nombre = Nombre_textfield.getText();
        String apellido = Apellido_textfield.getText();
        String direccion = Direccion_textfield.getText();
        String telefonos = Telefonos_textfield.getText();
        try {
            ResultSet id = clientes.getIdCliente(conexion, nombre, apellido);
            if (!id.next()) {
                clientes.insertar(conexion, nombre, apellido, direccion);
                id = clientes.getIdCliente(conexion, nombre, apellido);
                id.next();
            }

            String id1 = id.getString("ID_Cliente");
            String[] partes = telefonos.split(",");
            for (String parte : partes) {
                telefono.insertar(conexion, parte, id1);
            }
            begintable();
            JOptionPane.showMessageDialog(this, "Se ha agregado exitósamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(Formulario.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Tiempo limite excedido", "Error", JOptionPane.ERROR_MESSAGE);
        } 
        clean();
    }//GEN-LAST:event_guardar_jbuttonActionPerformed

    private void commit_jbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_commit_jbuttonActionPerformed
        try {
            conection.commitTransaccion(conexion);
            guardar_jbutton.setEnabled(false);
            rollback_jbutton.setEnabled(false);
            commit_jbutton.setEnabled(false);
            star_jbutton.setEnabled(true);
            read_commitedbutton.setEnabled(true);
            read_uncommitedbutton.setEnabled(true);
            repeteable_readbutton.setEnabled(true);
            serializable_button.setEnabled(true);
            begintable();
            clean();
        } catch (SQLException ex) {
            Logger.getLogger(Formulario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_commit_jbuttonActionPerformed

    private void rollback_jbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rollback_jbuttonActionPerformed
        try {
            conection.rollbackTransaccion(conexion);
            guardar_jbutton.setEnabled(false);
            rollback_jbutton.setEnabled(false);
            commit_jbutton.setEnabled(false);
            star_jbutton.setEnabled(true);
            read_commitedbutton.setEnabled(true);
            read_uncommitedbutton.setEnabled(true);
            repeteable_readbutton.setEnabled(true);
            serializable_button.setEnabled(true);
            begintable();
            clean();
        } catch (SQLException ex) {
            Logger.getLogger(Formulario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_rollback_jbuttonActionPerformed

    private void ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarActionPerformed
        try {
            begintable();
        } catch (SQLException ex) {
            Logger.getLogger(Formulario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ActualizarActionPerformed

    private void Apellido_textfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Apellido_textfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Apellido_textfieldActionPerformed

    private void read_uncommitedbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_read_uncommitedbuttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_read_uncommitedbuttonActionPerformed

    private void repeteable_readbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repeteable_readbuttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_repeteable_readbuttonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Actualizar;
    private javax.swing.JTextField Apellido_textfield;
    private javax.swing.JTextField Direccion_textfield;
    private javax.swing.JTextField Nombre_textfield;
    private javax.swing.JTextField Telefonos_textfield;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton commit_jbutton;
    private javax.swing.JTable datos_jtable;
    private javax.swing.JButton guardar_jbutton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JRadioButton read_commitedbutton;
    private javax.swing.JRadioButton read_uncommitedbutton;
    private javax.swing.JRadioButton repeteable_readbutton;
    private javax.swing.JButton rollback_jbutton;
    private javax.swing.JRadioButton serializable_button;
    private javax.swing.JButton star_jbutton;
    // End of variables declaration//GEN-END:variables
}

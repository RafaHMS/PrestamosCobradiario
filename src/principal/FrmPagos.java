package principal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrmPagos extends javax.swing.JFrame {

    Connection con = new Conexion().conectarMySQL();

    public FrmPagos() {
        initComponents();
        this.setLocationRelativeTo(null);
        listar(txtPrestamos.getText());
        Date FechaActual = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String mifecha = dateFormat.format(FechaActual);
        txtFecha.setText(mifecha);
    }

    public void listar(String idprestamos) {
        DefaultTableModel modelo = new DefaultTableModel(); //mostrar datos en la tabla

        modelo.addColumn("Id");//encabezados de la tabla
        modelo.addColumn("N° Cuota");
        modelo.addColumn("Fecha");
        modelo.addColumn("Valor");
        modelo.addColumn("Id Cobrador");

        try {
            String query = "SELECT idpago,ncuota,fecha,valor,idcobrador FROM pagos"
                    + "  where idprestamo='" + idprestamos + "'"; // hace la consulta con LIKE //hace la consulta
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                String idpago = rs.getString("idpago"); //trae los datos de las columnas, deben tener los nombres de la tabla
                String ncuota = rs.getString("ncuota");
                String fecha = rs.getString("fecha");
                String valor = rs.getString("valor");
                String idcobrador = rs.getString("idcobrador");

                modelo.addRow(new Object[]{idpago, ncuota, fecha, valor, idcobrador});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        tablaPagos.setModel(modelo);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblPagos = new javax.swing.JLabel();
        lblNoPrestamos = new javax.swing.JLabel();
        txtPrestamos = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPagos = new javax.swing.JTable();
        lblCuota = new javax.swing.JLabel();
        lblValor = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        lblCobrador = new javax.swing.JLabel();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        txtCuota = new javax.swing.JTextField();
        txtValor = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        txtCobrador = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        btnBuscarCobradores = new javax.swing.JButton();
        lblCOBRADOR = new javax.swing.JLabel();
        lblDoCobrador = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        lblID = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblPagos.setFont(new java.awt.Font("Roboto Medium", 1, 24)); // NOI18N
        lblPagos.setText("Pagos");
        getContentPane().add(lblPagos, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 0, -1, -1));

        lblNoPrestamos.setFont(new java.awt.Font("Roboto SemiCondensed Black", 1, 18)); // NOI18N
        lblNoPrestamos.setText("Prestamos  N°");
        getContentPane().add(lblNoPrestamos, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 64, -1, -1));

        txtPrestamos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(txtPrestamos, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 63, 191, 26));

        tablaPagos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tablaPagos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaPagos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tablaPagos.setShowVerticalLines(true);
        tablaPagos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaPagosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaPagos);
        if (tablaPagos.getColumnModel().getColumnCount() > 0) {
            tablaPagos.getColumnModel().getColumn(3).setPreferredWidth(190);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 107, 550, 233));

        lblCuota.setFont(new java.awt.Font("Roboto ExtraBold", 1, 12)); // NOI18N
        lblCuota.setText("N° Cuota");
        getContentPane().add(lblCuota, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, -1, -1));

        lblValor.setFont(new java.awt.Font("Roboto ExtraBold", 1, 12)); // NOI18N
        lblValor.setText("Valor");
        getContentPane().add(lblValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, -1, -1));

        lblFecha.setFont(new java.awt.Font("Roboto ExtraBold", 0, 12)); // NOI18N
        lblFecha.setText("Fecha");
        getContentPane().add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(253, 358, -1, -1));

        lblCobrador.setFont(new java.awt.Font("Roboto ExtraBold", 1, 12)); // NOI18N
        lblCobrador.setText("Cobrador");
        getContentPane().add(lblCobrador, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 410, -1, -1));

        btnNuevo.setBackground(new java.awt.Color(51, 204, 0));
        btnNuevo.setFont(new java.awt.Font("Roboto ExtraBold", 1, 12)); // NOI18N
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/refresh.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        getContentPane().add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 524, 80, 40));

        btnGuardar.setBackground(new java.awt.Color(51, 255, 51));
        btnGuardar.setFont(new java.awt.Font("Roboto ExtraBold", 1, 12)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/computer.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(139, 524, 80, 40));

        btnEliminar.setBackground(new java.awt.Color(255, 0, 0));
        btnEliminar.setFont(new java.awt.Font("Roboto ExtraBold", 1, 12)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/trash.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(261, 524, 80, 40));

        btnCerrar.setBackground(new java.awt.Color(255, 153, 0));
        btnCerrar.setFont(new java.awt.Font("Roboto ExtraBold", 1, 12)); // NOI18N
        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logout.png"))); // NOI18N
        btnCerrar.setText("Cerrar");
        btnCerrar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(472, 524, 80, 40));

        txtCuota.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(txtCuota, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 360, 122, 28));

        txtValor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(txtValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, 171, 28));

        txtFecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(304, 352, 150, 27));

        txtCobrador.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(txtCobrador, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 400, 180, 28));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 47, 572, 10));

        btnBuscarCobradores.setBackground(new java.awt.Color(204, 204, 204));
        btnBuscarCobradores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/employee.png"))); // NOI18N
        btnBuscarCobradores.setText("...");
        btnBuscarCobradores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCobradoresActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscarCobradores, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 400, 60, 28));

        lblCOBRADOR.setFont(new java.awt.Font("Roboto ExtraBold", 1, 14)); // NOI18N
        lblCOBRADOR.setText("Nombre Cobrador");
        getContentPane().add(lblCOBRADOR, new org.netbeans.lib.awtextra.AbsoluteConstraints(171, 464, -1, -1));

        lblDoCobrador.setText("...");
        getContentPane().add(lblDoCobrador, new org.netbeans.lib.awtextra.AbsoluteConstraints(307, 464, -1, -1));

        txtId.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 448, 120, 30));

        lblID.setText("ID");
        getContentPane().add(lblID, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("INSERT INTO pagos(idprestamo,"
                    + "ncuota,fecha,valor,idcobrador) VALUES (?,?,?,?,?)");
            ps.setString(1, txtPrestamos.getText());
            ps.setString(2, txtCuota.getText());
            ps.setString(3, txtFecha.getText());
            ps.setString(4, txtValor.getText());
            ps.setString(5, txtCobrador.getText());

            int res = ps.executeUpdate();

            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Pago Registrado");
                listar(txtPrestamos.getText());
            } else {
                JOptionPane.showMessageDialog(null, "Error al registrar pago");
            }

        } catch (SQLException e) {
            System.err.println(e);
        }

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed

        dispose();


    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        String sql = "DELETE FROM pagos WHERE idpago = ?";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, txtId.getText().trim());

            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(this, "PAGO ELIMINADO EXITOSAMENTE");
                listar(txtPrestamos.getText());
                btnNuevo.doClick();

            } else {
                JOptionPane.showMessageDialog(this, "NO SE ENCONTRÓ EL PAGO ESPECIFICADO");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "ERROR AL ELIMINAR: " + e.getMessage());
        }


    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed

        txtCuota.setText(null);
        txtValor.setText(null);
        txtCobrador.setText(null);
        txtId.setText(null);

        txtCuota.grabFocus(); //asigna el foco al 

    }//GEN-LAST:event_btnNuevoActionPerformed

    private void tablaPagosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPagosMouseClicked
        // TODO add your handling code here:

        int filas = tablaPagos.getSelectedRow();
        if (filas > -1) {
            txtId.setText((String) tablaPagos.getValueAt(filas, 0));
            txtCuota.setText((String) tablaPagos.getValueAt(filas, 1));
            txtFecha.setText((String) tablaPagos.getValueAt(filas, 2));
            txtValor.setText((String) tablaPagos.getValueAt(filas, 3));
            txtCobrador.setText((String) tablaPagos.getValueAt(filas, 4));

        }

        DefaultTableModel model = (DefaultTableModel) tablaPagos.getModel();
        tablaPagos.setDefaultEditor(Object.class, null); // Desactiva la edición de los campos de la tabla


    }//GEN-LAST:event_tablaPagosMouseClicked

    private void btnBuscarCobradoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCobradoresActionPerformed
        // TODO add your handling code here:
        new FrmBuscarCobradores().setVisible(true);
    }//GEN-LAST:event_btnBuscarCobradoresActionPerformed

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
            java.util.logging.Logger.getLogger(FrmPagos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPagos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPagos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPagos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPagos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarCobradores;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblCOBRADOR;
    private javax.swing.JLabel lblCobrador;
    private javax.swing.JLabel lblCuota;
    public static javax.swing.JLabel lblDoCobrador;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblNoPrestamos;
    private javax.swing.JLabel lblPagos;
    private javax.swing.JLabel lblValor;
    private javax.swing.JTable tablaPagos;
    public static javax.swing.JTextField txtCobrador;
    private javax.swing.JTextField txtCuota;
    private javax.swing.JTextField txtFecha;
    public static javax.swing.JTextField txtId;
    public static javax.swing.JTextField txtPrestamos;
    public static javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}

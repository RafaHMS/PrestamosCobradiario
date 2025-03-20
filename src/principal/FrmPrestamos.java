package principal;

import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.Date;

public class FrmPrestamos extends javax.swing.JFrame {

    Connection con = new Conexion().conectarMySQL();

    public FrmPrestamos() {
        initComponents();
        this.setLocationRelativeTo(null);

        listar("");
        Date FechaActual = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String mifecha = dateFormat.format(FechaActual);
        txtFecha.setText(mifecha);
    }

    public void listar(String buscar) {
        DefaultTableModel modelo = new DefaultTableModel(); // Mostrar datos en la tabla

        // Encabezados de la tabla (agregarlos solo una vez)
        modelo.addColumn("Id");
        modelo.addColumn("Cliente");
        modelo.addColumn("Cobrador");
        modelo.addColumn("Fecha");
        modelo.addColumn("Valor");
        modelo.addColumn("Tasa");
        modelo.addColumn("Interes");
        modelo.addColumn("Periodo");
        modelo.addColumn("Tiempo");
        modelo.addColumn("Cuota");
        modelo.addColumn("Total");
        modelo.addColumn("Estado");

        try {
            String query = "SELECT idprestamo, fecha, interes, cuota, valor, tiempo, total, cobrador.nombre AS cobrador, "
                    + "tasa, cliente.nombre AS cliente, periodo, estado "
                    + "FROM prestamo "
                    + "INNER JOIN cliente ON cliente.documento = prestamo.documento "
                    + "INNER JOIN cobrador ON cobrador.idcobrador = prestamo.idcobrador "
                    + "WHERE cliente.documento LIKE '%" + buscar + "%' OR cobrador.idcobrador LIKE '%" + buscar + "%'";

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                String idprestamos = rs.getString("idprestamo"); // Obtener datos de las columnas
                String fecha = rs.getString("fecha");
                String intereses = rs.getString("interes");
                String cuota = rs.getString("cuota");
                String valor = rs.getString("valor");
                String tiempo = rs.getString("tiempo");
                String totalAPagar = rs.getString("total");
                String idCobrador = rs.getString("cobrador");
                String tasaDeInteres = rs.getString("tasa");
                String documentoCliente = rs.getString("cliente");
                String periodo = rs.getString("periodo");
                String estado = rs.getString("estado");

                // Agregar la fila con los datos en el orden correcto
                modelo.addRow(new Object[]{
                    idprestamos, documentoCliente, idCobrador, fecha, valor,
                    tasaDeInteres, intereses, periodo, tiempo, cuota, totalAPagar, estado
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        tablePrestamos.setModel(modelo);

        /*  tablePrestamos.getColumnModel().getColumn(0).setPreferredWidth(40); //Ancho de una columna
        tablePrestamos.getColumnModel().getColumn(0).setResizable(false); //que no se pueda aumentar el ancho*/
        // Definir los índices de las columnas y sus respectivos anchos
        int[] columnas = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        int[] anchos = {40, 150, 150, 120, 100, 50, 100, 100, 80, 100, 100, 80};

        // Asignar ancho y deshabilitar redimensión en cada columna
        for (int i = 0; i < columnas.length; i++) {
            tablePrestamos.getColumnModel().getColumn(columnas[i]).setPreferredWidth(anchos[i]);
            tablePrestamos.getColumnModel().getColumn(columnas[i]).setResizable(false);
        }

    }

    public void calcular() {
        int valor = Integer.parseInt(txtValor.getText());
        int tasa = Integer.parseInt(txtTasa.getText());
        int tiempo = Integer.parseInt(txtTiempo.getText());
        int interes, cuota, total;
        interes = (valor * tasa) / 100;
        total = valor + interes;
        cuota = total / tiempo;

        txtInteres.setText(interes + "");
        txtTotal.setText(total + "");
        txtCuota.setText(cuota + "");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablePrestamos = new javax.swing.JTable();
        lblTituloPrestamos = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        txtIdPrestamo = new javax.swing.JTextField();
        txtCliente = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        txtValor = new javax.swing.JTextField();
        lblIdPrestamo = new javax.swing.JLabel();
        lblCliente = new javax.swing.JLabel();
        lblValor = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        lblInteres = new javax.swing.JLabel();
        txtInteres = new javax.swing.JTextField();
        lblCuota = new javax.swing.JLabel();
        txtCuota = new javax.swing.JTextField();
        lblTiempo = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        txtTiempo = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        lblCobrador = new javax.swing.JLabel();
        lblTasa = new javax.swing.JLabel();
        lblPeriodo = new javax.swing.JLabel();
        txtCobrador = new javax.swing.JTextField();
        txtTasa = new javax.swing.JTextField();
        CbPeriodo = new javax.swing.JComboBox<>();
        btnBuscarCliente = new javax.swing.JButton();
        btnBuscarCobrador = new javax.swing.JButton();
        lblNomCliente = new javax.swing.JLabel();
        lblNomContador = new javax.swing.JLabel();
        btnPago = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablePrestamos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tablePrestamos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10", "Title 11", "Title 12"
            }
        ));
        tablePrestamos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tablePrestamos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tablePrestamos.setGridColor(new java.awt.Color(204, 204, 204));
        tablePrestamos.setRowHeight(30);
        tablePrestamos.setShowVerticalLines(true);
        tablePrestamos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePrestamosMouseClicked(evt);
            }
        });
        tablePrestamos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tablePrestamosKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(tablePrestamos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 105, 890, 185));

        lblTituloPrestamos.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTituloPrestamos.setText("PRÉSTAMOS");
        getContentPane().add(lblTituloPrestamos, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 6, -1, -1));

        btnBuscar.setBackground(new java.awt.Color(0, 204, 255));
        btnBuscar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/paper.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(816, 58, 80, 35));

        txtIdPrestamo.setEditable(false);
        txtIdPrestamo.setBackground(new java.awt.Color(255, 255, 204));
        txtIdPrestamo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(txtIdPrestamo, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 296, 95, 34));

        txtCliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(txtCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(309, 298, 147, 34));

        txtFecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaActionPerformed(evt);
            }
        });
        getContentPane().add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 336, 155, 34));

        txtValor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtValor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtValorFocusLost(evt);
            }
        });
        txtValor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtValorKeyTyped(evt);
            }
        });
        getContentPane().add(txtValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 340, 137, 34));

        lblIdPrestamo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblIdPrestamo.setText("Id Prestamo");
        getContentPane().add(lblIdPrestamo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, -1, -1));

        lblCliente.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblCliente.setText("Cliente");
        getContentPane().add(lblCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(249, 308, -1, -1));

        lblValor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblValor.setText("Valor");
        getContentPane().add(lblValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 350, -1, -1));

        lblFecha.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblFecha.setText("Fecha");
        getContentPane().add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 41, 934, 11));

        btnNuevo.setBackground(new java.awt.Color(0, 153, 0));
        btnNuevo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/add-user.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        getContentPane().add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 87, 45));

        btnGuardar.setBackground(new java.awt.Color(51, 255, 51));
        btnGuardar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/computer.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 490, 91, 45));

        btnSalir.setBackground(new java.awt.Color(255, 0, 0));
        btnSalir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logout.png"))); // NOI18N
        btnSalir.setText("Cerrar");
        btnSalir.setBorder(null);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(805, 490, 82, 45));

        txtBuscar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 58, 800, 35));

        lblInteres.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblInteres.setText("Interes");
        getContentPane().add(lblInteres, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, -1, -1));

        txtInteres.setEditable(false);
        txtInteres.setBackground(new java.awt.Color(255, 255, 204));
        txtInteres.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(txtInteres, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 376, 155, 33));

        lblCuota.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblCuota.setText("Cuota");
        getContentPane().add(lblCuota, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, -1, -1));

        txtCuota.setEditable(false);
        txtCuota.setBackground(new java.awt.Color(255, 255, 204));
        txtCuota.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtCuota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCuotaActionPerformed(evt);
            }
        });
        getContentPane().add(txtCuota, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 418, 139, 32));

        lblTiempo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTiempo.setText("Tiempo");
        getContentPane().add(lblTiempo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 400, -1, -1));

        lblTotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTotal.setText("Total:");
        getContentPane().add(lblTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 450, -1, -1));

        txtTiempo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtTiempo.setText("30");
        txtTiempo.setActionCommand("<Not Set>");
        txtTiempo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtTiempo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTiempoActionPerformed(evt);
            }
        });
        txtTiempo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTiempoKeyTyped(evt);
            }
        });
        getContentPane().add(txtTiempo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 390, 129, 33));

        txtTotal.setEditable(false);
        txtTotal.setBackground(new java.awt.Color(255, 255, 204));
        txtTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 440, 138, 36));

        lblCobrador.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblCobrador.setText("Cobrador");
        getContentPane().add(lblCobrador, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 370, -1, -1));

        lblTasa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTasa.setText("Tasa (%)");
        getContentPane().add(lblTasa, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 415, -1, -1));

        lblPeriodo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblPeriodo.setText("Periodo");
        getContentPane().add(lblPeriodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 470, -1, -1));

        txtCobrador.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtCobrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCobradorActionPerformed(evt);
            }
        });
        getContentPane().add(txtCobrador, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 350, 115, 40));

        txtTasa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtTasa.setText("20");
        txtTasa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtTasa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTasaActionPerformed(evt);
            }
        });
        txtTasa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTasaKeyTyped(evt);
            }
        });
        getContentPane().add(txtTasa, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 400, 80, 39));

        CbPeriodo.setBackground(new java.awt.Color(204, 204, 204));
        CbPeriodo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CbPeriodo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Diario", "Quincenal", "Mensual" }));
        CbPeriodo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        CbPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbPeriodoActionPerformed(evt);
            }
        });
        getContentPane().add(CbPeriodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 450, 111, 35));

        btnBuscarCliente.setBackground(new java.awt.Color(204, 204, 204));
        btnBuscarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/user.png"))); // NOI18N
        btnBuscarCliente.setText("...");
        btnBuscarCliente.setBorder(null);
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 300, 60, -1));

        btnBuscarCobrador.setBackground(new java.awt.Color(204, 204, 204));
        btnBuscarCobrador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/employee.png"))); // NOI18N
        btnBuscarCobrador.setText("...");
        btnBuscarCobrador.setBorder(null);
        btnBuscarCobrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCobradorActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscarCobrador, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 350, 50, 40));

        lblNomCliente.setText("----");
        getContentPane().add(lblNomCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 310, -1, -1));

        lblNomContador.setText("----");
        getContentPane().add(lblNomContador, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 360, -1, -1));

        btnPago.setBackground(new java.awt.Color(0, 204, 0));
        btnPago.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnPago.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/money.png"))); // NOI18N
        btnPago.setText("PAGOS");
        btnPago.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagoActionPerformed(evt);
            }
        });
        getContentPane().add(btnPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(813, 297, 83, 35));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed


    }//GEN-LAST:event_txtBuscarActionPerformed

    private void txtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaActionPerformed


    }//GEN-LAST:event_txtFechaActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        listar(txtBuscar.getText());


    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        new FrmPrincipal().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("INSERT INTO prestamo(fecha,"
                    + "interes,cuota,valor,tiempo,total,idcobrador,tasa,documento,periodo,estado) VALUES (?,?,?,?,?,?,?,?,?,?,'Activo')");
            ps.setString(1, txtFecha.getText());
            ps.setString(2, txtInteres.getText());
            ps.setString(3, txtCuota.getText());
            ps.setString(4, txtValor.getText());
            ps.setString(5, txtTiempo.getText());
            ps.setString(6, txtTotal.getText());
            ps.setString(7, txtCobrador.getText());
            ps.setString(8, txtTasa.getText());
            ps.setString(9, txtCliente.getText());
            ps.setString(10, CbPeriodo.getSelectedItem().toString());

            int res = ps.executeUpdate();

            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Prestamo Guardado");
                listar("");
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar Prestamo");
            }

        } catch (SQLException e) {
            System.err.println(e);
        }


    }//GEN-LAST:event_btnGuardarActionPerformed


    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed

        txtIdPrestamo.setText(null);
        txtInteres.setText(null);
        txtCuota.setText(null);
        txtCliente.setText(null);
        txtValor.setText(null);
        txtTotal.setText(null);
        txtCobrador.setText(null);
        lblNomCliente.setText("----");
        lblNomContador.setText("----");

        txtCliente.grabFocus(); //asigna el foco al 

    }//GEN-LAST:event_btnNuevoActionPerformed


    private void tablePrestamosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePrestamosMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tablePrestamos.getModel();
        tablePrestamos.setDefaultEditor(Object.class, null); // Desactiva la edición de los campos de la tabla


    }//GEN-LAST:event_tablePrestamosMouseClicked

    private void CbPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbPeriodoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CbPeriodoActionPerformed

    private void txtValorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtValorFocusLost
        // TODO add your handling code here:
        calcular();
    }//GEN-LAST:event_txtValorFocusLost

    private void txtTasaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTasaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTasaActionPerformed

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
        // TODO add your handling code here:
        new FrmBuscarCliente().setVisible(true);

    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    private void btnBuscarCobradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCobradorActionPerformed
        new FrmBuscarCobradores().setVisible(true);

    }//GEN-LAST:event_btnBuscarCobradorActionPerformed

    private void txtCobradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCobradorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCobradorActionPerformed

    private void btnPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagoActionPerformed

        int filas = tablePrestamos.getSelectedRow();
        if (filas > -1) {
            FrmPagos p = new FrmPagos();
            p.txtPrestamos.setText((String) tablePrestamos.getValueAt(filas, 0));
            p.txtCobrador.setText((String) tablePrestamos.getValueAt(filas, 2));
            p.txtValor.setText((String) tablePrestamos.getValueAt(filas, 4));
            p.setVisible(true);
            p.listar(p.txtPrestamos.getText());
        }


    }//GEN-LAST:event_btnPagoActionPerformed

    private void txtCuotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCuotaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCuotaActionPerformed

    private void tablePrestamosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablePrestamosKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_tablePrestamosKeyTyped

    private void txtValorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorKeyTyped
        // TODO add your handling code here:

        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtValorKeyTyped

    private void txtTiempoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTiempoActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_txtTiempoActionPerformed

    private void txtTiempoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTiempoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtTiempoKeyTyped

    private void txtTasaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTasaKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtTasaKeyTyped

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
            java.util.logging.Logger.getLogger(FrmPrestamos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrestamos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrestamos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrestamos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrestamos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CbPeriodo;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnBuscarCobrador;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnPago;
    private javax.swing.JButton btnSalir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblCobrador;
    private javax.swing.JLabel lblCuota;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblIdPrestamo;
    private javax.swing.JLabel lblInteres;
    public static javax.swing.JLabel lblNomCliente;
    public static javax.swing.JLabel lblNomContador;
    private javax.swing.JLabel lblPeriodo;
    private javax.swing.JLabel lblTasa;
    private javax.swing.JLabel lblTiempo;
    private javax.swing.JLabel lblTituloPrestamos;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblValor;
    private javax.swing.JTable tablePrestamos;
    private javax.swing.JTextField txtBuscar;
    public static javax.swing.JTextField txtCliente;
    public static javax.swing.JTextField txtCobrador;
    private javax.swing.JTextField txtCuota;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtIdPrestamo;
    private javax.swing.JTextField txtInteres;
    private javax.swing.JTextField txtTasa;
    private javax.swing.JTextField txtTiempo;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}

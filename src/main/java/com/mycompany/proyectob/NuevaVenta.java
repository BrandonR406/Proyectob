package com.mycompany.proyectob;

import static com.mycompany.proyectob.NuevoCupon.Cuponcsv;
import static com.mycompany.proyectob.Proyectob.Libro;
import static com.mycompany.proyectob.RegistrarVenta.LibroV;
import static com.mycompany.proyectob.RegistrarVenta.LibroVendido;
import static com.mycompany.proyectob.RegistrarVenta.Reporte;
import static com.mycompany.proyectob.Usuarios.Venta;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JTable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author brandon
 */
public class NuevaVenta extends javax.swing.JFrame {

    private Usuarios UsuarioActual;
    public static ArrayList<RegistrarVenta> InformeV = ArchivoVenta.CargarArchivo();
    private Libro libro;

    /**
     * Creates new form NuevaVenta
     */
    public NuevaVenta(Usuarios usuario) {
        initComponents();
        this.UsuarioActual = usuario;
        ArchivoLibro.CargarLibro();
        pintarTabla();
        TablaCupones();

        jButton4.setVisible(false);

        jTable1.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent Mouse_evt) {
                JTable table = (JTable) Mouse_evt.getSource();
                Point point = Mouse_evt.getPoint();
                int row = table.rowAtPoint(point);
                if (Mouse_evt.getClickCount() == 1) {
                    jTextField4.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
                    jTextField5.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString());
                }
            }
        });
    }

    private void pintarTabla() {
        DefaultTableModel t = new DefaultTableModel(new String[]{"Titulo", "Autor", "Genero", "Precio", "Stock"}, Proyectob.Libro.size());
        jTable1.setModel(t);
        TableModel tabla = jTable1.getModel();
        for (int i = 0; i < Proyectob.Libro.size(); i++) {
            Libro l = Proyectob.Libro.get(i);
            tabla.setValueAt(l.getTitulo(), i, 0);
            tabla.setValueAt(l.getAutor(), i, 1);
            tabla.setValueAt(l.getGenero(), i, 2);
            tabla.setValueAt(l.getPrecio(), i, 3);
            tabla.setValueAt(l.getStock(), i, 4);
        }
    }

    private void TablaLibrov() {
        DefaultTableModel t = new DefaultTableModel(new String[]{"Titulo", "Precio", "Cantidad", "Subtotal"}, RegistrarVenta.LibroV.size());
        jTable2.setModel(t);
        TableModel tabla = jTable2.getModel();
        for (int i = 0; i < RegistrarVenta.LibroV.size(); i++) {
            LibroVenta l = RegistrarVenta.LibroV.get(i);
            tabla.setValueAt(l.getTitulo(), i, 0);
            tabla.setValueAt(l.getPrecio(), i, 1);
            tabla.setValueAt(l.getCantidad(), i, 2);
            tabla.setValueAt(l.getSubtotal(), i, 3);
        }
    }

    private void TablaCupones() {
        DefaultTableModel t = new DefaultTableModel(new String[]{"Codigo", "Descuento", "Tipo", "Vencimiento"}, Proyectob.cupones.size());
        jTable3.setModel(t);
        TableModel tabla = jTable3.getModel();
        for (int i = 0; i < Proyectob.cupones.size(); i++) {
            Cupones C = Proyectob.cupones.get(i);
            tabla.setValueAt(C.getCodigo(), i, 0);
            tabla.setValueAt(C.getDescuento(), i, 1);
            tabla.setValueAt(C.getTipo(), i, 2);
            tabla.setValueAt(C.getVencimiento(), i, 3);
        }
    }

    public void totales() {
        double fila;
        double total = 0;
        double siniva;
        for (int i = 0; i < jTable2.getRowCount(); i++) {
            fila = Double.parseDouble(jTable2.getValueAt(i, 3).toString());
            total += fila;
        }
        siniva = total / 1.12;
        jTextField7.setText(String.valueOf(total));
        jTextField8.setText(String.valueOf((double) Math.round(siniva * 100d) / 100));
    }

    public void ActualizarInventario() {

        int modificar = jTable1.getSelectedRow();

        if (modificar > -1) {
            
            libro = Proyectob.Libro.get(modificar);
            int stock = (int) jTable1.getValueAt(jTable1.getSelectedRow(), 4);
            int descuento = Integer.parseInt(jTextField6.getText());
            
            if (stock > 0 && stock >= descuento) {
                int Actualizado = stock - descuento;

                libro.setTitulo(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
                libro.setAutor(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
                libro.setGenero(jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString());
                libro.setPrecio((double) jTable1.getValueAt(jTable1.getSelectedRow(), 3));
                libro.setStock(Actualizado);
                ArchivoLibro.guardarLibro(Libro);
                ArchivoLibro.GuardarJson(Libro);
                pintarTabla();

            }
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("NIT: ");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Direccion:");

        jLabel4.setText("Informacion de cliente");

        jLabel5.setText("Informacion LIbro");

        jLabel6.setText("Titulo: ");

        jLabel7.setText("Precio:");

        jLabel8.setText("Cantidad:");

        jButton1.setText("Agregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        jLabel9.setText("Total: ");

        jButton2.setText("Registrar Venta");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel10.setText("Total sin IVA:");

        jButton3.setText("Regresar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Registro de Ventas");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTable3);

        jLabel11.setText("Libros");

        jLabel12.setText("Cupones");

        jButton5.setText("Aplicar Cupon");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addGap(27, 27, 27))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel12)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton5)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jButton4)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel10)
                                                    .addComponent(jLabel9))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jButton2))))))
                                .addGap(120, 120, 120))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jButton3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton4))
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5))
                        .addContainerGap(27, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        int stock = (int) jTable1.getValueAt(jTable1.getSelectedRow(), 4);
        int cant = Integer.parseInt(jTextField6.getText());

        if (stock > 0 && stock >= cant) {
            LibroVenta LV = new LibroVenta();

            LV.setTitulo(jTextField4.getText());
            double precio = Double.parseDouble(jTextField5.getText());
            

            double Subtotal = precio * cant;
            LV.setPrecio(precio);
            LV.setCantidad(cant);
            LV.setSubtotal(Subtotal);
            LV.setFecha(LocalDate.now().toString());
            RegistrarVenta.LibroV.add(LV);
            RegistrarVenta.LibroVendido.add(LV);
            RegistrarVenta.Reporte.add(LV);
            ActualizarInventario();

            ArchivoLibroVenta.GuardarReporte(Reporte);
            ArchivoLibroVenta.guardarLibroVenta(LibroVendido);
            jTextField4.setText("");
            jTextField5.setText("");
            jTextField6.setText("");
            TablaLibrov();
            totales();
        } else {
            JOptionPane.showMessageDialog(this, "Stock insuficiente");
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        RegistrarVenta RV = new RegistrarVenta();
        RV.setNombreCliente(jTextField2.getText());
        RV.setNIT(jTextField1.getText());
        RV.setDireecion(jTextField3.getText());
        RV.setTotal(Double.parseDouble(jTextField7.getText()));
        RV.setTotalsinIVA(Double.parseDouble(jTextField8.getText()));
        RV.setVendedor(UsuarioActual.getNombre());
        RV.setFecha(LocalDate.now().toString());
        Usuarios.Venta.add(RV);
        InformeV.add(RV);
        ArchivoVenta.GuardarArchivo(InformeV);
        ArchivoVenta.guardarVenta(Venta);
        JOptionPane.showMessageDialog(this, "Venta Realizada con exito");

        jTextField2.setText("");
        jTextField1.setText("");
        jTextField3.setText("");
        jTextField7.setText("");
        jTextField8.setText("");
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0);
        RegistrarVenta.LibroV.clear();


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        ConsultarVenta CV = new ConsultarVenta();
        CV.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:

        int cupon = jTable3.getSelectedRow();
        String Tipo = jTable3.getValueAt(jTable3.getSelectedRow(), 2).toString();
        double descuento;

        double total = Double.parseDouble(jTextField7.getText());

        double totalfinal;
        double totalfinalsiniva;

        if (cupon > -1) {

            if (Tipo.equals("Porcentaje")) {

                double auxiliar = (double) jTable3.getValueAt(jTable3.getSelectedRow(), 1) / 100;
                descuento = total * auxiliar;
                totalfinal = total - descuento;
                totalfinalsiniva = totalfinal / 1.12;
                jTextField7.setText(String.valueOf(totalfinal));
                jTextField8.setText(String.valueOf(totalfinalsiniva));

            } else if (Tipo.equals("Monto fijo")) {

                descuento = (double) jTable3.getValueAt(jTable3.getSelectedRow(), 1);

                totalfinal = total - descuento;
                totalfinalsiniva = totalfinal / 1.12;
                jTextField7.setText(String.valueOf(totalfinal));
                jTextField8.setText(String.valueOf(totalfinalsiniva));

            }

        }


    }//GEN-LAST:event_jButton5ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    // End of variables declaration//GEN-END:variables
}

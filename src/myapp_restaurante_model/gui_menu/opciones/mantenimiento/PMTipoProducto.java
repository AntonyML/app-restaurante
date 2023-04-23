/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp_restaurante_model.gui_menu.opciones.mantenimiento;

import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;
import myapp_restaurante_model.domain.Comentarios;
import myapp_restaurante_model.domain.Empleado;
import myapp_restaurante_model.domain.Producto;
import myapp_restaurante_model.domain.Tipo_Producto;
import myapp_restaurante_model.gui_menu.JFGuardar;
import myapp_restaurante_model.gui_menu.TextPrompt;
import myapp_restaurante_model.gui_menu.table_custom.TableActionCellEditor;
import myapp_restaurante_model.gui_menu.table_custom.TableActionCellRender;
import myapp_restaurante_model.gui_menu.table_custom.TableActionEvent;
import myapp_restaurante_model.logic.FilesTxt;
import myapp_restaurante_model.logic.LogicFilesTxt;

 
public final class PMTipoProducto extends javax.swing.JPanel {

    private TextPrompt t;
    private final JFGuardar pg;
    private final String[] eti;
    private String result;
    private Tipo_Producto tP;

    private final LogicFilesTxt lTxt;
    private final FilesTxt f;
    private int size;
    String addressTxt;
    private Object[][] OTableInformation;

    /**
     * Creates new form NewJPanel
     */
    public PMTipoProducto() {

        //jframe de guardar *es un efecto
        this.pg = new JFGuardar();

        //etiquetas de la tabla
        String[] etiquetas = {"ID", "Nombre", "Accion"};
        this.eti = etiquetas;

        //se inicializa todo el codigo del jframe
        initComponents();
        //edita los jtexfields
        setTextPront();

        ////////////////
        result = "";
        //iniciliciamos las logicas
        lTxt = new LogicFilesTxt();
        f = new FilesTxt();
        //Direcion del txt
        addressTxt = "src\\myapp_restaurante_model\\data\\tipoProducto.txt";
        //Se obtiene el tamaño del txt
        size = lTxt.getInformation(f.readFile(addressTxt)).length;

        result = f.readFile(addressTxt);

        //Se obtiene el contenido del txt
        OTableInformation = lTxt.getObject(f.readFile(addressTxt));

        //edita las tablas para autollenarse//Primero se mete el tamaño que se obtuvo segun el txt y luego la informacion
        if (result.isEmpty()) {
            result = ""; //si estya vacio no crea nada nuevo ni guarda nada

        } else {
            result = lTxt.getObjetsConverString(OTableInformation);
            //  JOptionPane.showConfirmDialog(null, result);
            editarTabla(OTableInformation);
        }

        //edita la tabla para que salgan los iconos
        TableActionEvent event;
        event = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                if (table.isEditing()) {
                    table.getCellEditor().stopCellEditing();
                }
                System.out.println("Edit row : " + row);
                //edita las tablas para autollenarse
                OTableInformation = lTxt.obtenerContenidoTabla(table);
                result = lTxt.obtenerContenidoDesdeMatriz(OTableInformation);
                f.EditFile(addressTxt, result);
            }

            @Override
            public void onDelete(int row) {
                if (table.isEditing()) {
                    table.getCellEditor().stopCellEditing();
                }
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.removeRow(row);

                result = lTxt.deleteInformation(result, row);
                f.EditFile(addressTxt, result);
                System.out.println("Delete row : " + row);
            }

            @Override
            public void onView(int row) {
                System.out.println("View row : " + row);
            }
        };

        table.getColumnModel().getColumn(table.getColumnModel().getColumnCount() - 1).setCellRenderer(new TableActionCellRender());
        table.getColumnModel().getColumn(table.getColumnModel().getColumnCount() - 1).setCellEditor(new TableActionCellEditor(event));
        //volvemos a editar la tabla para acomodar los parametros de acuerdo a los margenes que se necesita
        table.setIntercellSpacing(new java.awt.Dimension(5, 1));
        table.setRowHeight(40);
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(table.getColumnModel().getColumnCount() - 1).setPreferredWidth(130);
        }

        jTextField1.setEnabled(false);

        jButton1.setEnabled(false);
    }

    //tabla para editar
    public void editarTabla(Object[][] data) {

        table.setModel(new javax.swing.table.DefaultTableModel(
                data, eti
        ));
        jScrollPane1.setViewportView(table);
    }

    private void setTextPront() {
        t = new TextPrompt("ID", jTextCodigo);
        t.changeAlpha(0.75f);
        t.changeStyle(Font.ITALIC);
        t.changeFontSize(11);

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
        jLabel4 = new javax.swing.JLabel();
        jTextCodigo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jBuscar = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 255, 153));
        jLabel1.setText("Nombre");
        jLabel1.setToolTipText("Nombre o dirección");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, 30));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 180, 40));

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Tw Cen MT", 3, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 255, 153));
        jLabel4.setText("ID");
        jLabel4.setToolTipText("Nombre o dirección");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, -1, 30));

        jTextCodigo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jTextCodigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextCodigo.setCaretColor(new java.awt.Color(51, 0, 51));
        jTextCodigo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextCodigoMouseClicked(evt);
            }
        });
        jTextCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextCodigoActionPerformed(evt);
            }
        });
        add(jTextCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, 70, 30));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Accion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setIntercellSpacing(new java.awt.Dimension(5, 1));
        table.setRowHeight(40);
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setPreferredWidth(50);
            table.getColumnModel().getColumn(1).setResizable(false);
            table.getColumnModel().getColumn(2).setPreferredWidth(100);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(233, 42, 570, 490));

        jButton1.setBackground(new java.awt.Color(102, 255, 153));
        jButton1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Guardar");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 470, 120, 40));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 255, 153));
        jLabel7.setText("Borrar");
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, -1, 20));

        jBuscar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jBuscar.setForeground(new java.awt.Color(102, 255, 153));
        jBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myapp_restaurante_model/gui_menu/iconos/consultas.png"))); // NOI18N
        jBuscar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 102, 102)));
        jBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBuscarMouseClicked(evt);
            }
        });
        add(jBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 410, 40, 30));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myapp_restaurante_model/gui_menu/iconos/gradient (2).gif"))); // NOI18N
        add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-8, 0, 820, 540));
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextCodigoActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jTextCodigoActionPerformed

    private void jTextCodigoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextCodigoMouseClicked
        // TODO add your handling code here:ID

        // Agregar FocusListener
        jTextCodigo.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                // No se necesita hacer nada cuando se gana el enfoque
            }

            @Override
            public void focusLost(FocusEvent e) {
                // Mostrar mensaje cuando se pierde el enfoque

            }

        });


    }//GEN-LAST:event_jTextCodigoMouseClicked
//Consructor


    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:registrar

        if (jTextField1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Coloca correctamente los datos");
        } else {
            action();
        }

    }//GEN-LAST:event_jButton1MouseClicked
    public void action() {
        if (jTextCodigo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Datos erroneos");
        } else {

            tP = new Tipo_Producto(Integer.parseInt(jTextCodigo.getText()), jTextField1.getText());

            result += tP.toString() + "\n";

            //Se obtiene el tamaño del txt
            size = lTxt.getInformation(result).length;

            //Se obtiene el contenido del txt
            OTableInformation = lTxt.getObject(f.readFile(addressTxt));

            //edita las tablas para autollenarse
            //OTableInformation = lTxt.getObject(size, result);
            OTableInformation = lTxt.getObject(result);
            editarTabla(OTableInformation);
            result = lTxt.getObjetsConverString(OTableInformation);

            //edita la tabla para que salgan los iconos
            TableActionEvent event;
            event = new TableActionEvent() {
                @Override
                public void onEdit(int row) {
                    System.out.println("Edit row b: " + row);
                    if (table.isEditing()) {
                        table.getCellEditor().stopCellEditing();
                    }
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    //edita las tablas para autollenarse
                    OTableInformation = lTxt.obtenerContenidoTabla(table);
                    editarTabla(OTableInformation);
                    result = lTxt.obtenerContenidoDesdeMatriz(OTableInformation);
                    f.EditFile(addressTxt, result);
                }

                @Override
                public void onDelete(int row) {
                    if (table.isEditing()) {
                        table.getCellEditor().stopCellEditing();
                    }
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    model.removeRow(row);

                    result = lTxt.deleteInformation(result, row);
                    f.EditFile(addressTxt, result);
                    System.out.println("Delete row : " + row);
                }

                @Override
                public void onView(int row) {
                    System.out.println("View row b: " + row);
                }
            };
            table.getColumnModel().getColumn(table.getColumnModel().getColumnCount() - 1).setCellRenderer(new TableActionCellRender());
            table.getColumnModel().getColumn(table.getColumnModel().getColumnCount() - 1).setCellEditor(new TableActionCellEditor(event));
            //volvemos a editar la tabla para acomodar los parametros de acuerdo a los margenes que se necesita
            table.setIntercellSpacing(new java.awt.Dimension(5, 1));
            table.setRowHeight(40);
            jScrollPane1.setViewportView(table);
            if (table.getColumnModel().getColumnCount() > 0) {
                table.getColumnModel().getColumn(table.getColumnModel().getColumnCount() - 1).setPreferredWidth(130);
            }
            this.repaint();
            f.EditFile(addressTxt, result);
        }
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here://Borrar
        jTextCodigo.setText("");
        jTextCodigo.setEnabled(true);
        jTextField1.setText("");


    }//GEN-LAST:event_jLabel7MouseClicked

    private void jBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBuscarMouseClicked
        // TODO add your handling code here:Buscar
        // JOptionPane.showMessageDialog(null, "result"+result);
        if (lTxt.isId(result, jTextCodigo.getText())) {
            JOptionPane.showMessageDialog(null, "Modificando");
            //obtendo el los datos segun la posicion 
            String nombre = lTxt.getInformationIndividual(lTxt.getInformattionById(result, jTextCodigo.getText()))[1];

            jTextCodigo.setEnabled(false);
            jTextField1.setEnabled(true);

            jTextField1.setText(nombre);

        } else {
            JOptionPane.showMessageDialog(null, "Creando");
            jTextField1.setEnabled(true);

        }
        jButton1.setEnabled(true);
    }//GEN-LAST:event_jBuscarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jBuscar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextCodigo;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables

//encapsulamiento
}

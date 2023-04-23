/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp_restaurante_model.gui_menu.opciones.mantenimiento;

import java.awt.Font;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;
import myapp_restaurante_model.domain.Usuarios;
import myapp_restaurante_model.gui_menu.JFGuardar;
import myapp_restaurante_model.gui_menu.TextPrompt;
import myapp_restaurante_model.gui_menu.table_custom.TableActionCellEditor;
import myapp_restaurante_model.gui_menu.table_custom.TableActionCellRender;
import myapp_restaurante_model.gui_menu.table_custom.TableActionEvent;
import myapp_restaurante_model.logic.FilesTxt;
import myapp_restaurante_model.logic.LogicFilesTxt;

 
public final class PMUsuarios extends javax.swing.JPanel {

    private TextPrompt t;
    private final JFGuardar pg;
    private final String[] eti;
    private String result;
    private Usuarios u;
    private final LogicFilesTxt lTxt;
    private final FilesTxt f;
    private int size;
    String addressTxt;
    private Object[][] OTableInformation;

    /**
     * Creates new form NewJPanel
     */
    public PMUsuarios() {

        //jframe de guardar *es un efecto
        this.pg = new JFGuardar();

        //etiquetas de la tabla
        String[] etiquetas = {"#", "Usuario", "Contraseña", "N Acesso", "Nombre", "Apellidos", "Correo", "Accion"};
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
        addressTxt = "src\\myapp_restaurante_model\\data\\usuario.txt";
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
    }

    //tabla para editar
    public void editarTabla(Object[][] data) {

        table.setModel(new javax.swing.table.DefaultTableModel(
                data, eti
        ));
        jScrollPane1.setViewportView(table);
    }

    private void setTextPront() {
        t = new TextPrompt("#####", jTextCodigo);
        t.changeAlpha(0.75f);
        t.changeStyle(Font.ITALIC);
        /*
        // LO AGREGAMOS
        t = new TextPrompt("Nombre", jTextField2);
        t.changeAlpha(0.75f);
        t.changeStyle(Font.ITALIC);
        // LO AGREGAMOS
        t = new TextPrompt("Dirección", jTextField3);
        t.changeAlpha(0.75f);
        t.changeStyle(Font.ITALIC);
        // LO AGREGAMOS
        t = new TextPrompt("Correo", jTextField4);
        t.changeAlpha(0.75f);
        t.changeStyle(Font.ITALIC);
        // LO AGREGAMOS
        t = new TextPrompt("Teléfono", jTextField5);
        t.changeAlpha(0.75f);
        t.changeStyle(Font.ITALIC);
         */
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
        jTextField4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jTextCodigo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 255, 153));
        jLabel1.setText("Usuario");
        jLabel1.setToolTipText("Nombre o dirección");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, 30));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 120, 40));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Tw Cen MT", 3, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 255, 153));
        jLabel2.setText("Contraseña");
        jLabel2.setToolTipText("Nombre o dirección");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, 30));

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 140, 40));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Tw Cen MT", 3, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 255, 153));
        jLabel3.setText("Nombre");
        jLabel3.setToolTipText("Nombre o dirección");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, 30));

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 140, 40));

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Tw Cen MT", 3, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 255, 153));
        jLabel4.setText("Apellidos");
        jLabel4.setToolTipText("Nombre o dirección");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, -1, 30));

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 90, 40));

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Tw Cen MT", 3, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 255, 153));
        jLabel5.setText("Correo");
        jLabel5.setToolTipText("Nombre o dirección");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, -1, 30));

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 180, 40));

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
        add(jTextCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 10, 70, 30));

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("Tw Cen MT", 3, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 255, 153));
        jLabel8.setText("N Acceso");
        jLabel8.setToolTipText("Nombre o dirección");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, 30));

        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 140, 40));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myapp_restaurante_model/gui_menu/iconos/guardar.png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel6MouseExited(evt);
            }
        });
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 470, 80, 60));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "#", "Usuario", "Contraseña", "N Acesso", "Nombre", "Apellidos", "Correo", "Accion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true
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
            table.getColumnModel().getColumn(7).setPreferredWidth(100);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(233, 42, 570, 490));

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

        jButton1.setBackground(new java.awt.Color(102, 255, 153));
        jButton1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Registrarse");
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

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myapp_restaurante_model/gui_menu/iconos/gradient (2).gif"))); // NOI18N
        add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-8, 0, 820, 540));
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here://Borrar
        jTextCodigo.setText("");
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jTextField7.setText("");

    }//GEN-LAST:event_jLabel7MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextCodigoActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jTextCodigoActionPerformed

    private void jTextCodigoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextCodigoMouseClicked
        // TODO add your handling code here:
        jTextCodigo.setText("");
    }//GEN-LAST:event_jTextCodigoMouseClicked

    private void jLabel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseEntered
        // TODO add your handling code here:

        pg.setVisible(true);
        pg.setLocation(1350, 710);
    }//GEN-LAST:event_jLabel6MouseEntered

    private void jLabel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseExited
        // TODO add your handling code here:
        pg.setVisible(false);
    }//GEN-LAST:event_jLabel6MouseExited

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:registrar 
        if (jTextField1.getText().isEmpty() || jTextField2.getText().isEmpty() || jTextField3.getText().isEmpty()
                || jTextField4.getText().isEmpty() || jTextField5.getText().isEmpty() || jTextField7.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Coloca correctamente los datos");
        } else {
            action();
        }


    }//GEN-LAST:event_jButton1MouseClicked
    public void action() {
        u = new Usuarios(result, jTextField1.getText(), jTextField2.getText(), Integer.parseInt(jTextField7.getText()),
                jTextField3.getText(), jTextField4.getText(), jTextField5.getText());

        result += u.toString() + "\n";

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

    }
    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:Guardar en el txt
        f.EditFile(addressTxt, result);
    }//GEN-LAST:event_jLabel6MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fondo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextCodigo;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables

//encapsulamiento
}

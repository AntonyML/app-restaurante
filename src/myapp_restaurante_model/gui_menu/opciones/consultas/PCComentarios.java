/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp_restaurante_model.gui_menu.opciones.consultas;

import myapp_restaurante_model.gui_menu.opciones.mantenimiento.*;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;
import myapp_restaurante_model.domain.Comentarios;
import myapp_restaurante_model.gui_menu.JFGuardar;
import myapp_restaurante_model.gui_menu.TextPrompt;
import myapp_restaurante_model.gui_menu.table_custom.TableActionCellEditor;
import myapp_restaurante_model.gui_menu.table_custom.TableActionCellRender;
import myapp_restaurante_model.gui_menu.table_custom.TableActionEvent;
import myapp_restaurante_model.logic.FilesTxt;
import myapp_restaurante_model.logic.LogicFilesTxt;


public final class PCComentarios extends javax.swing.JPanel {

    private TextPrompt t;
    private final JFGuardar pg;
    private final String[] eti;
    private String result;
    private Comentarios c;
    private final LogicFilesTxt lTxt;
    private final FilesTxt f;
    private int size;
    String addressTxt;
    private Object[][] OTableInformation;

    /**
     * Creates new form NewJPanel
     */
    public PCComentarios() {

        //jframe de guardar *es un efecto
        this.pg = new JFGuardar();

        //etiquetas de la tabla
        String[] etiquetas = {"ID", "Correo", "Asunto", "Comentario", "Fecha", "Accion"};
        this.eti = etiquetas;

        //se inicializa todo el codigo del jframe
        initComponents();
        //edita los jtexfields
      

        ////////////////
        result = "";
        //iniciliciamos las logicas
        lTxt = new LogicFilesTxt();
        f = new FilesTxt();
        //Direcion del txt
        addressTxt = "src\\myapp_restaurante_model\\data\\comentario.txt";
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        fondo = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Correo", "Asunto", "Comentario", "Fecha", "Accion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
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
            table.getColumnModel().getColumn(5).setPreferredWidth(100);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 790, 520));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myapp_restaurante_model/gui_menu/iconos/gradient (2).gif"))); // NOI18N
        add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 540));
    }// </editor-fold>//GEN-END:initComponents
//Consructor
/*
    public void action() {
        if (jTextCodigo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Datos erroneos");
        } else {
            c = new Comentarios(Integer.parseInt(jTextCodigo.getText()), jTextField1.getText(), jTextField2.getText(),
                    jTextArea1.getText(), jTextField3.getText());

            result += c.toString() + "\n";

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
            table.getColumnModel().getColumn(5).setCellRenderer(new TableActionCellRender());
            table.getColumnModel().getColumn(5).setCellEditor(new TableActionCellEditor(event));
            //volvemos a editar la tabla para acomodar los parametros de acuerdo a los margenes que se necesita
            table.setIntercellSpacing(new java.awt.Dimension(5, 1));
            table.setRowHeight(40);
            jScrollPane1.setViewportView(table);
            if (table.getColumnModel().getColumnCount() > 0) {
                table.getColumnModel().getColumn(0).setPreferredWidth(30);
                table.getColumnModel().getColumn(1).setPreferredWidth(60);
                table.getColumnModel().getColumn(2).setPreferredWidth(75);
                table.getColumnModel().getColumn(4).setPreferredWidth(60);
                table.getColumnModel().getColumn(5).setPreferredWidth(100);
            }
            this.repaint();
            f.EditFile(addressTxt, result);
        }
    }
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fondo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables

//encapsulamiento
}

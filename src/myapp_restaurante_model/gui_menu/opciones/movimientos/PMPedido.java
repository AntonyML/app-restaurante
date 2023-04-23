/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp_restaurante_model.gui_menu.opciones.movimientos;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;
import myapp_restaurante_model.domain.Detalle_Pedido;
import myapp_restaurante_model.domain.Pedido;
import myapp_restaurante_model.domain.Producto;
import myapp_restaurante_model.gui_menu.JFGuardar;
import myapp_restaurante_model.gui_menu.Menu;
import myapp_restaurante_model.gui_menu.TextPrompt;
import myapp_restaurante_model.gui_menu.opciones.mantenimiento.PMCliente;
import myapp_restaurante_model.gui_menu.opciones.mantenimiento.PMMesa;
import myapp_restaurante_model.gui_menu.table_custom.TableActionCellEditor;
import myapp_restaurante_model.gui_menu.table_custom.TableActionCellRender;
import myapp_restaurante_model.gui_menu.table_custom.TableActionEvent;
import myapp_restaurante_model.logic.FilesTxt;
import myapp_restaurante_model.logic.LogicFilesTxt;

 
public final class PMPedido extends javax.swing.JPanel {
//variables

    private String resultDetalle = "";
    private boolean check;
    private TextPrompt t;
    private final JFGuardar pg;
    private final String[] eti;
    private final String[] etiaux;
    private String result;
    private Pedido p;
    private Detalle_Pedido dt;
    private final LogicFilesTxt lTxt;
    private final FilesTxt f;
    private int size;
    String addressTxt;
    private Object[][] OTableInformation;
    // Obtén la fecha de hoy
    private final LocalDate fechaHoy = LocalDate.now();
    // Crea un formato de fecha
    private final DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    // Convierte la fecha en una cadena de texto
    private final String fechaHoyTexto = fechaHoy.format(formatoFecha);

//    Date fechaHoyDate = (Date) formatoFecha.parse(fechaHoyTexto);
    Date fecha = new Date();
    DateFormat formatoF = new SimpleDateFormat("dd/MM/yyyy");
    private final Menu menu;
    String addressTxtpro = "src\\myapp_restaurante_model\\data\\producto.txt";

    String resultpro;

    /**
     * Creates new form NewJPanel
     *
     * @param menu
     */
    public PMPedido(Menu menu) {

        check = false;
        this.menu = menu;
        //jframe de guardar *es un efecto
        this.pg = new JFGuardar();

        //etiquetas de la tabla
        String[] etiquetas = {"ID", "Fecha", "ID Cliente", "Valor", "Valor itbis", "Propina", "Concepto", "Status", "ID Camarero", "Id Mesa", "Accion"};
        this.eti = etiquetas;
        String[] eaux = {"ID", "Sec", "Id producto", "Cantidad", "Precio", "Accion"};
        this.etiaux = eaux;
        //se inicializa todo el codigo del jframe
        initComponents();
        //edita los jtexfields
        setTextPront();

        ////////////////
        result = "";
        //iniciliciamos las logicas
        lTxt = new LogicFilesTxt();
        f = new FilesTxt();
        resultpro = f.readFile(addressTxtpro);
        //Direcion del txt
        addressTxt = "src\\myapp_restaurante_model\\data\\pedido.txt";
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
        jTextField1.setText(fechaHoyTexto);
        jTextField1.setEnabled(false);
        // jTextField2.setEnabled(false);
        jTextField3.setEnabled(false);
        jTextField4.setEnabled(false);
        jTextField5.setEnabled(false);
        jTextField6.setEnabled(false);
        jTextField7.setEnabled(false);
        // jTextField8.setEnabled(false);
        jTextField9.setEnabled(false);
        // jTextField10.setEnabled(false);
        jTextField11.setEnabled(false);
        // jTextField12.setEnabled(false);
        jTextField13.setEnabled(false);
        jTextField14.setEnabled(false);

        // jPanel1.setEnabled(false);
        // jButton1.setEnabled(false);
        //jBuscar.setEnabled(false);
    }

    //tabla para editar
    public void editarTabla(Object[][] data) {

        table.setModel(new javax.swing.table.DefaultTableModel(
                data, eti
        ));
        jScrollPane1.setViewportView(table);
    }
    //tabla para editar

    public void editarTabla2(Object[][] data) {

        table1.setModel(new javax.swing.table.DefaultTableModel(
                data, etiaux
        ));
        jScrollPane2.setViewportView(table1);
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
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextCodigo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        borrar = new javax.swing.JLabel();
        jBuscar = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        id1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jBuscar1 = new javax.swing.JLabel();
        fondo1 = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 255, 153));
        jLabel1.setText("Fecha");
        jLabel1.setToolTipText("Nombre o dirección");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 30));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 120, 30));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Tw Cen MT", 3, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 255, 153));
        jLabel2.setText("ID Cliente");
        jLabel2.setToolTipText("Nombre o dirección");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, 30));

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 80, 30));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Tw Cen MT", 3, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 255, 153));
        jLabel3.setText("Valor");
        jLabel3.setToolTipText("Nombre o dirección");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, 30));

        id.setBackground(new java.awt.Color(0, 0, 0));
        id.setFont(new java.awt.Font("Tw Cen MT", 3, 24)); // NOI18N
        id.setForeground(new java.awt.Color(102, 255, 153));
        id.setText("ID");
        id.setToolTipText("Nombre o dirección");
        add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, -1, 30));

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 140, 40));

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

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("Tw Cen MT", 3, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 255, 153));
        jLabel8.setText("Valor itbis");
        jLabel8.setToolTipText("Nombre o dirección");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, 30));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Fecha", "ID Cliente", "Valor", "Valor itbis", "Propina", "Concepto", "Status", "ID Camarero", "Id Mesa", "Accion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true, true, true, true, true
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
            table.getColumnModel().getColumn(5).setHeaderValue("Propina");
            table.getColumnModel().getColumn(6).setPreferredWidth(100);
            table.getColumnModel().getColumn(6).setHeaderValue("Concepto");
            table.getColumnModel().getColumn(7).setHeaderValue("Status");
            table.getColumnModel().getColumn(8).setHeaderValue("ID Camarero");
            table.getColumnModel().getColumn(9).setHeaderValue("Id Mesa");
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(233, 42, 570, 230));

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

        borrar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        borrar.setForeground(new java.awt.Color(102, 255, 153));
        borrar.setText("Borrar");
        borrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        borrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                borrarMouseClicked(evt);
            }
        });
        add(borrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, -1, 20));

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

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 120, 40));

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Tw Cen MT", 3, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 255, 153));
        jLabel5.setText("Propina");
        jLabel5.setToolTipText("Nombre o dirección");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, 20));

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 110, 30));

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Tw Cen MT", 3, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 255, 153));
        jLabel6.setText("Concepto");
        jLabel6.setToolTipText("Nombre o dirección");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, 30));

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setFont(new java.awt.Font("Tw Cen MT", 3, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 255, 153));
        jLabel9.setText("ID Mesa");
        jLabel9.setToolTipText("Nombre o dirección");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 360, -1, 30));

        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 210, 30));

        jLabel10.setBackground(new java.awt.Color(0, 0, 0));
        jLabel10.setFont(new java.awt.Font("Tw Cen MT", 3, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 255, 153));
        jLabel10.setText("Status");
        jLabel10.setToolTipText("Nombre o dirección");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, -1, 30));

        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 50, 30));

        jLabel11.setBackground(new java.awt.Color(0, 0, 0));
        jLabel11.setFont(new java.awt.Font("Tw Cen MT", 3, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 255, 153));
        jLabel11.setText("ID Camarero");
        jLabel11.setToolTipText("Nombre o dirección");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, -1, 40));

        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });
        add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 330, 100, 30));

        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });
        add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 370, 80, 30));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        id1.setBackground(new java.awt.Color(0, 0, 0));
        id1.setFont(new java.awt.Font("Tw Cen MT", 3, 24)); // NOI18N
        id1.setForeground(new java.awt.Color(102, 255, 153));
        id1.setText("Detalle Pedido");
        id1.setToolTipText("Nombre o dirección");
        jPanel1.add(id1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, -1, 30));

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Sec", "Id producto", "Cantidad", "Precio", "Accion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table1.setRowHeight(40);
        jScrollPane2.setViewportView(table1);
        if (table1.getColumnModel().getColumnCount() > 0) {
            table1.getColumnModel().getColumn(0).setPreferredWidth(50);
            table1.getColumnModel().getColumn(1).setResizable(false);
            table1.getColumnModel().getColumn(2).setPreferredWidth(100);
        }

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 520, 120));

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Tw Cen MT", 3, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 255, 153));
        jLabel4.setText("ID");
        jLabel4.setToolTipText("Nombre o dirección");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, 30));

        jTextField10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField10ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 40, 30));

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Tw Cen MT", 3, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 255, 153));
        jLabel7.setText("Sec");
        jLabel7.setToolTipText("Nombre o dirección");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, 30));

        jTextField11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField11ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 40, 30));

        jLabel12.setBackground(new java.awt.Color(0, 0, 0));
        jLabel12.setFont(new java.awt.Font("Tw Cen MT", 3, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 255, 153));
        jLabel12.setText("ID Producto");
        jLabel12.setToolTipText("Nombre o dirección");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, -1, 30));

        jTextField12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField12ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField12, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 70, 30));

        jLabel13.setBackground(new java.awt.Color(0, 0, 0));
        jLabel13.setFont(new java.awt.Font("Tw Cen MT", 3, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 255, 153));
        jLabel13.setText("Cantidad");
        jLabel13.setToolTipText("Nombre o dirección");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, -1, 30));

        jTextField13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField13ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField13, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, 110, 30));

        jLabel14.setBackground(new java.awt.Color(0, 0, 0));
        jLabel14.setFont(new java.awt.Font("Tw Cen MT", 3, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 255, 153));
        jLabel14.setText("Precio");
        jLabel14.setToolTipText("Nombre o dirección");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, -1, 30));

        jTextField14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField14ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField14, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, 120, 30));

        jButton2.setBackground(new java.awt.Color(102, 255, 153));
        jButton2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Guardar");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 200, 90, 30));

        jBuscar1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jBuscar1.setForeground(new java.awt.Color(102, 255, 153));
        jBuscar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myapp_restaurante_model/gui_menu/iconos/consultas.png"))); // NOI18N
        jBuscar1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 102, 102)));
        jBuscar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBuscar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBuscar1MouseClicked(evt);
            }
        });
        jPanel1.add(jBuscar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 30, 20));

        fondo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myapp_restaurante_model/gui_menu/iconos/gradient (2).gif"))); // NOI18N
        fondo1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(fondo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 230));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 290, 540, 230));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myapp_restaurante_model/gui_menu/iconos/gradient (2).gif"))); // NOI18N
        add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 540));
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

        if (jTextField1.getText().isEmpty() || jTextField2.getText().isEmpty() || jTextField3.getText().isEmpty()
                || jTextField4.getText().isEmpty() || jTextField5.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Coloca correctamente los datos");
        } else {
            action();
        }

    }//GEN-LAST:event_jButton1MouseClicked
    public void action() {

        if (jTextCodigo.getText().isEmpty() && check) {
            JOptionPane.showMessageDialog(null, "Datos erroneos, Colocar datos de detalle precio o Id correctamente");
        } else {
            check = false;
            //variables
            double valor_pedido = Double.parseDouble(jTextField13.getText()) * Double.parseDouble(jTextField14.getText());

            
            double propina = Double.parseDouble(jTextField3.getText()) * 0.10;
            p = new Pedido(Integer.parseInt(jTextCodigo.getText()), 
                    fechaHoyTexto, 
                    Integer.parseInt(jTextField2.getText()),
                    valor_pedido, 
                    Double.parseDouble(jTextField4.getText()),
                    propina,
                    jTextField6.getText(),
                    Boolean.parseBoolean(jTextField7.getText()),
                    Integer.parseInt(jTextField8.getText()),
                    Integer.parseInt(jTextField9.getText()));

            result += p.toString() + "\n";

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

            jTextField10.setText(jTextCodigo.getText());
            String addressTxtsec = "src\\myapp_restaurante_model\\data\\detalleProducto.txt";

            String resultsec = f.readFile(addressTxtsec);
            int sec = lTxt.getInformationIndividual(resultsec).length;

            jTextField11.setText(String.valueOf(sec));
            jTextField12.setEnabled(true);
            jTextField13.setEnabled(true);
           
        }
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jButton1ActionPerformed

    private void borrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_borrarMouseClicked
        // TODO add your handling code here://Borrar
        jTextCodigo.setText("");
        jTextCodigo.setEnabled(true);
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jTextField6.setText("");
        jTextField7.setText("");
        jTextField8.setText("");
        jTextField9.setText("");
        //  jTextArea1.setText("");

    }//GEN-LAST:event_borrarMouseClicked

    private void jBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBuscarMouseClicked
        // TODO add your handling code here:Buscar
        // JOptionPane.showMessageDialog(null, "result"+result);
        //////////////////////
        //Direcion del txt
        String addressTxtCliente = "src\\myapp_restaurante_model\\data\\cliente.txt";
        String resultCliente = f.readFile(addressTxtCliente);
        ////////////////////////////////////
        String addressTxtCamarero = "src\\myapp_restaurante_model\\data\\empleado.txt";
        String resultCamarero = f.readFile(addressTxtCamarero);
        String camarero = lTxt.getInformationIndividual(lTxt.getInformattionById(resultCamarero, "1"))[4];

        if (jTextField2.getText().isEmpty() && jTextField8.getText().isEmpty()
                && jTextCodigo.getText().isEmpty() && lTxt.isId(result, jTextCodigo.getText()) && lTxt.isId(resultCamarero, jTextField8.getText())) {
            JOptionPane.showMessageDialog(null, "Modificando");
            //verificar si existe el cliente
            if (!lTxt.isId(resultCliente, jTextField2.getText())) {
                JOptionPane.showMessageDialog(null, "Error, no existe el cliente");
                PMCliente pmc;
                pmc = new PMCliente();
                menu.getjPanel_Menu().removeAll();
                pmc.setSize(810, 540);
                pmc.setLocation(0, 0);
                menu.getjPanel_Menu().add(pmc, BorderLayout.CENTER);
                menu.getjPanel_Menu().revalidate();
                menu.getjPanel_Menu().repaint();
            }
            //verificar si es camarero
            if (!camarero.equals(1)) {
                JOptionPane.showMessageDialog(null, "Error, no es camarero");
                PMPedido pmp;
                pmp = new PMPedido(menu);
                menu.getjPanel_Menu().removeAll();
                pmp.setSize(810, 540);
                pmp.setLocation(0, 0);
                menu.getjPanel_Menu().add(pmp, BorderLayout.CENTER);
                menu.getjPanel_Menu().revalidate();
                menu.getjPanel_Menu().repaint();
            }

            //obtendo el los datos segun la posicion 
            String fecha = lTxt.getInformationIndividual(lTxt.getInformattionById(result, jTextCodigo.getText()))[1];
            String id_cliente = lTxt.getInformationIndividual(lTxt.getInformattionById(result, jTextCodigo.getText()))[2];
            String valor_pedido = lTxt.getInformationIndividual(lTxt.getInformattionById(result, jTextCodigo.getText()))[3];
            String valor_itbis = lTxt.getInformationIndividual(lTxt.getInformattionById(result, jTextCodigo.getText()))[4];
            String valor_propina = lTxt.getInformationIndividual(lTxt.getInformattionById(result, jTextCodigo.getText()))[5];
            String concepto = lTxt.getInformationIndividual(lTxt.getInformattionById(result, jTextCodigo.getText()))[6];
            String status = lTxt.getInformationIndividual(lTxt.getInformattionById(result, jTextCodigo.getText()))[7];
            String id_camarero = lTxt.getInformationIndividual(lTxt.getInformattionById(result, jTextCodigo.getText()))[8];
            String id_mesa = lTxt.getInformationIndividual(lTxt.getInformattionById(result, jTextCodigo.getText()))[9];

            jTextCodigo.setEnabled(false);
            jTextField1.setEnabled(true);
            jTextField2.setEnabled(true);
            jTextField3.setEnabled(true);
            jTextField4.setEnabled(true);
            jTextField5.setEnabled(true);
            jTextField6.setEnabled(true);
            jTextField7.setEnabled(true);
            jTextField8.setEnabled(true);
            jTextField9.setEnabled(true);

            jTextField1.setText(fecha);
            jTextField2.setText(id_cliente);
            jTextField3.setText(valor_pedido);
            jTextField4.setText(valor_itbis);
            jTextField5.setText(valor_propina);
            jTextField6.setText(concepto);
            jTextField7.setText(status);
            jTextField8.setText(id_camarero);
            jTextField9.setText(id_mesa);

        } else {
            JOptionPane.showMessageDialog(null, "Creando");

            //variables
            double valor_pedido = Double.parseDouble(jTextField13.getText()) * Double.parseDouble(jTextField14.getText());

            //Direcion del txt
            String addressTxtIt = "src\\myapp_restaurante_model\\data\\producto.txt";

            String resultIt = f.readFile(addressTxtIt);

            String itbis = lTxt.getInformationIndividual(lTxt.getInformattionById(resultIt, jTextField10.getText()))[5];
            double itbisd = 0;
            if (Boolean.parseBoolean(itbis)) {
                itbisd = Double.parseDouble(jTextField14.getText()) * 0.18;
            }

            jTextField1.setEnabled(true);
            jTextField2.setEnabled(true);
            jTextField3.setText(String.valueOf(valor_pedido));
            jTextField4.setText(String.valueOf(itbisd));

            jTextField6.setEnabled(true);
            jTextField7.setEnabled(true);
            jTextField8.setEnabled(true);
            jTextField9.setEnabled(true);

            double propina = Double.parseDouble(jTextField3.getText()) * 0.10;// jTextArea1.setEnabled(true);
            jTextField5.setText(String.valueOf(propina));

        }

        jButton1.setEnabled(true);
    }//GEN-LAST:event_jBuscarMouseClicked

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9ActionPerformed

    private void jTextField10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10ActionPerformed

    private void jTextField11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11ActionPerformed

    private void jTextField12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField12ActionPerformed

    private void jTextField13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField13ActionPerformed

    private void jTextField14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField14ActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:guardar p1 detalle

        if (jTextField10.getText().isEmpty() || jTextField12.getText().isEmpty() || jTextField13.getText().isEmpty()
                || jTextField14.getText().isEmpty() || jTextField11.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Coloca correctamente los datos");
        } else {
            actionD();
        }
        /*
        
         */

    }//GEN-LAST:event_jButton2MouseClicked
    public void actionD() {

        if (jTextField12.getText().isEmpty() && jTextField10.getText().isEmpty() && check) {
            JOptionPane.showMessageDialog(null, "Datos erroneos, Colocar datos de detalle precio o Id correctamente");
        } else {
            String addressTxtDetalle = "src\\myapp_restaurante_model\\data\\detalleProducto.txt";
            check = false;

            ///////////////////
            String idp = lTxt.getInformationIndividual(lTxt.getInformattionById(resultpro, jTextField12.getText()))[0];
            String descrip = lTxt.getInformationIndividual(lTxt.getInformattionById(resultpro, jTextField12.getText()))[1];
            String tipo = lTxt.getInformationIndividual(lTxt.getInformattionById(resultpro, jTextField12.getText()))[2];
            String precio = lTxt.getInformationIndividual(lTxt.getInformattionById(resultpro, jTextField12.getText()))[3];
            String existencia = lTxt.getInformationIndividual(lTxt.getInformattionById(resultpro, jTextField12.getText()))[4];
            String itbis = lTxt.getInformationIndividual(lTxt.getInformattionById(resultpro, jTextField12.getText()))[5];

            Producto pro = new Producto(Integer.parseInt(idp), descrip, Integer.parseInt(tipo),
                    Double.parseDouble(precio), Double.parseDouble(existencia), Boolean.parseBoolean(itbis));
            double cantiD = Double.parseDouble(jTextField13.getText());

            int cant = (int) cantiD;

            double preciod = Double.parseDouble(jTextField14.getText());
            int preciodd = (int) preciod;
            dt = new Detalle_Pedido(Integer.parseInt(jTextField10.getText()), Integer.parseInt(jTextField11.getText()),
                    Integer.parseInt(jTextField12.getText()), cant, preciodd);
            resultDetalle += dt.toString() + "\n";

            //Se obtiene el tamaño del txt
            size = lTxt.getInformation(resultDetalle).length;

            //Se obtiene el contenido del txt
            OTableInformation = lTxt.getObject(f.readFile(addressTxtDetalle));

            //edita las tablas para autollenarse
            //OTableInformation = lTxt.getObject(size, result);
            OTableInformation = lTxt.getObject(resultDetalle);
            editarTabla2(OTableInformation);
            resultDetalle = lTxt.getObjetsConverString(OTableInformation);
            JOptionPane.showConfirmDialog(null, resultDetalle);
            //edita la tabla para que salgan los iconos
            TableActionEvent event;
            event = new TableActionEvent() {
                @Override
                public void onEdit(int row) {
                    System.out.println("Edit row b: " + row);
                    if (table1.isEditing()) {
                        table1.getCellEditor().stopCellEditing();
                    }
                    DefaultTableModel model = (DefaultTableModel) table1.getModel();
                    //edita las tablas para autollenarse
                    OTableInformation = lTxt.obtenerContenidoTabla(table1);
                    editarTabla2(OTableInformation);
                    resultpro = lTxt.obtenerContenidoDesdeMatriz(OTableInformation);
                    f.EditFile(addressTxtDetalle, resultDetalle);
                }

                @Override
                public void onDelete(int row) {
                    if (table1.isEditing()) {
                        table1.getCellEditor().stopCellEditing();
                    }
                    DefaultTableModel model = (DefaultTableModel) table1.getModel();
                    model.removeRow(row);

                    resultpro = lTxt.deleteInformation(resultpro, row);
                    f.EditFile(addressTxtDetalle, resultDetalle);
                    System.out.println("Delete row : " + row);
                }

                @Override
                public void onView(int row) {
                    System.out.println("View row b: " + row);
                }
            };
            table1.getColumnModel().getColumn(table1.getColumnModel().getColumnCount() - 1).setCellRenderer(new TableActionCellRender());
            table1.getColumnModel().getColumn(table1.getColumnModel().getColumnCount() - 1).setCellEditor(new TableActionCellEditor(event));
            //volvemos a editar la tabla para acomodar los parametros de acuerdo a los margenes que se necesita
            table1.setIntercellSpacing(new java.awt.Dimension(5, 1));
            table1.setRowHeight(40);
            jScrollPane1.setViewportView(table1);
            if (table1.getColumnModel().getColumnCount() > 0) {
                table1.getColumnModel().getColumn(table1.getColumnModel().getColumnCount() - 1).setPreferredWidth(130);
            }
            this.repaint();

            f.EditFile(addressTxtDetalle, resultDetalle);

        }
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jBuscar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBuscar1MouseClicked
        // TODO add your handling code here:buscar p1 detalle{}

        String addressTxtp = "src\\myapp_restaurante_model\\data\\producto.txt";

        String resultp = f.readFile(addressTxtp);
        /////////////////
        String addressTxtD = "src\\myapp_restaurante_model\\data\\detalle.txt";

        String resultD = f.readFile(addressTxtD);

        String cantidad = lTxt.getInformationIndividual(lTxt.getInformattionById(resultp, jTextField12.getText()))[3];

        check = true;

        if (lTxt.isId(resultD, jTextField10.getText()) && lTxt.isId(resultp, jTextField12.getText()) && !cantidad.equals(0)) {
            JOptionPane.showMessageDialog(null, "Modificando");
            //obtendo el los datos segun la posicion 

            String idD = lTxt.getInformationIndividual(lTxt.getInformattionById(resultD, jTextField12.getText()))[0];
            String sec = lTxt.getInformationIndividual(lTxt.getInformattionById(resultD, jTextField12.getText()))[1];
            String id_Producto = lTxt.getInformationIndividual(lTxt.getInformattionById(resultD, jTextField12.getText()))[2];
            String cant = lTxt.getInformationIndividual(lTxt.getInformattionById(resultD, jTextField12.getText()))[3];
            String precio = lTxt.getInformationIndividual(lTxt.getInformattionById(resultD, jTextField12.getText()))[4];

            jTextField10.setEnabled(false);
            jTextField11.setEnabled(true);
            jTextField12.setEnabled(true);
            jTextField13.setEnabled(true);
            jTextField14.setEnabled(true);

            jTextField10.setText(idD);
            jTextField11.setText(sec);
            jTextField12.setText(id_Producto);
            jTextField13.setText(cant);
            jTextField14.setText(precio);

        } else {
            JOptionPane.showMessageDialog(null, "Creando");
            if (lTxt.isId(resultp, jTextField12.getText())) {

                String cant = lTxt.getInformationIndividual(lTxt.getInformattionById(resultp, jTextField12.getText()))[2];
                String precio = lTxt.getInformationIndividual(lTxt.getInformattionById(resultp, jTextField12.getText()))[3];
                jTextField13.setText(cant);
                jTextField14.setText(precio);
                JOptionPane.showMessageDialog(null, cant + precio);
            }
            jTextField10.setEnabled(true);
            jTextField11.setEnabled(true);
            jTextField12.setEnabled(true);
            jTextField13.setEnabled(true);
            jTextField14.setEnabled(true);

        }

        jButton1.setEnabled(true);
    }//GEN-LAST:event_jBuscar1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel borrar;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel fondo1;
    private javax.swing.JLabel id;
    private javax.swing.JLabel id1;
    private javax.swing.JLabel jBuscar;
    private javax.swing.JLabel jBuscar1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextCodigo;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTable table;
    private javax.swing.JTable table1;
    // End of variables declaration//GEN-END:variables

//encapsulamiento
}

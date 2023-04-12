package myapp_restaurante_model.bussiness;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import myapp_restaurante_model.gui_mantenimiento_usuarios.GUI_Mantenimiento_Usuarios;

public class Controller_Gui_Mantenimiento_Usuarios implements ActionListener {
//instancias

    public Controller_Gui_Mantenimiento_Usuarios() {
        GUI_Mantenimiento_Usuarios gui_Mantenimiento_Usuarios = new GUI_Mantenimiento_Usuarios();
        gui_Mantenimiento_Usuarios.setVisible(true);
    }

    public void initializeButtons() {
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

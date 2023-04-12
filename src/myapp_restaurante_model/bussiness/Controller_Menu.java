package myapp_restaurante_model.bussiness;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import myapp_restaurante_model.gui_menu.Menu;

public class Controller_Menu implements ActionListener {
//instancias

    public Controller_Menu() {
        Menu menu;
        menu = new Menu();
        menu.setVisible(true);
    }

    public void initializeButtons() {
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

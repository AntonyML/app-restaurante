package myapp_restaurante_model.logic;


import javax.swing.JComboBox;
import javax.swing.JOptionPane;



public class Logic {

    private String register;
  
    boolean check;

   

    public String getOptionsControllerAdmin(int n) {
        String result = "";

        //admin 2 5 8
        int admin[] = {2, 5, 8};
        int client[] = {3, 6, 9};
        int Type_Dish[] = {4, 7, 10};

        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 3; j++) {
                if (admin[j] == i && i == n) {
                    result = "admin";
                }
                if (client[j] == i && i == n) {
                    result = "client";
                }
                if (Type_Dish[j] == i && i == n) {
                    result = "dish";
                }

            }

        }

        return result;
    }

    public String getOptionsControllerMenu(int n) {
        String result = "";

        //admin 2 5 8
        int insert[] = {2, 3, 4};
        int edit[] = {5, 6, 7};
        int delete[] = {8, 9, 10};

        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 3; j++) {
                if (insert[j] == i && i == n) {
                    result = "insert";
                }
                if (edit[j] == i && i == n) {
                    result = "edit";
                }
                if (delete[j] == i && i == n) {
                    result = "delete";
                }

            }

        }

        return result;
    }

    public String[] getInformation(String data) {
        return data.split("\n");

    }

    public JComboBox getPCmenu(JComboBox[][] data) {
        JComboBox comboboxMenu = null;

        String[] namesLabel = {"Sistema", "Insertar", "Editar", "Eliminar", "Pedidos", "Reportes"};

        for (int j = 0; j < 6; j++) {

            if (!data[0][j].getSelectedItem().toString().equals(namesLabel[j])) {
                comboboxMenu = data[0][j];

            }
        }

        //hay que hacer un metodo que valide en la controller si esta null, pedirle al usuario que meta los datos correctamente
        return comboboxMenu;

    }

    public boolean getPCmenuValidation(JComboBox data) {
        check = false;
        if (data != null) {
            check = true;
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione la opcion deseada");
        }
        return check;
    }

    public String getRegister(String register) {
        if ("".equals(register) || register == null || register.equals("999") || register.contains("999")) {
            register = "\n   Registro" + "\n" + "¯¯¯¯¯¯¯¯¯¯¯¯\n";
        }
        return register;
    }

    /*
    Sistema:Acerda de=0,Salir=1;
    Insertar: Admin=2, Clientes=3, Platillos=4;
    editar:Admin=5, Clientes=6, Platillos=7;
    eliminar:Admin=8, Clientes=9, Platillos=10;
    pedidos:nuevo=11,consultar=12,eliminar =13;
    reportes:Clientes=14, Platillos=15, pedidos por fecha=16;
     */
    public int getCheckbox(String name) {
        int result = 999;
        switch (name) {
            case "Acerda de":
                result = 0;
                break;
            case "Salir":
                result = 1;
                break;
            case "I.Admin":
                result = 2;
                break;
            case "I.Clientes":
                result = 3;
                break;
            case "I.Platillos":
                result = 4;
                break;
            case "E.Admin":
                result = 5;
                break;
            case "E.Clientes":
                result = 6;
                break;
            case "E.Platillos":
                result = 7;
                break;
            case "EL.Admin":
                result = 8;
                break;
            case "EL.Clientes":
                result = 9;
                break;
            case "EL.Platillos":
                result = 10;
                break;
            case "Nuevo":
                result = 11;
                break;
            case "Consultas":
                result = 12;
                break;
            case "Eliminar":
                result = 13;
                break;
            case "R.Clientes":
                result = 14;
                break;
            case "R.Platillos":
                result = 15;
                break;
            case "Pedidos por fecha":
                result = 16;
                break;
            default:
                JOptionPane.showMessageDialog(null, "Indique una opción en la parte superior");
        }
        return result;
    }

}

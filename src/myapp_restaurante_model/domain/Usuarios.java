/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp_restaurante_model.domain;

import javax.swing.JOptionPane;
import myapp_restaurante_model.logic.FilesTxt;
import myapp_restaurante_model.logic.LogicFilesTxt;

/**
 *
 * @author TML
 */
public class Usuarios {

    private static int numberUser;
    private String login_Usuario;
    private String pass_Usuario;
    private int nivel_Acesso;//(0,1)
    private String nombre_Usuario;
    private String apellidos_Usuario;
    private String correo_Usuario;
    LogicFilesTxt ltxt;

    public Usuarios(String result, String login_Usuario, String pass_Usuario, int nivel_Acesso, String nombre_Usuario, String apellidos_Usuario, String correo_Usuario) {
        ltxt = new LogicFilesTxt();
        this.login_Usuario = login_Usuario;
        this.pass_Usuario = pass_Usuario;
        this.nivel_Acesso = nivel_Acesso;
        this.nombre_Usuario = nombre_Usuario;
        this.apellidos_Usuario = apellidos_Usuario;
        this.correo_Usuario = correo_Usuario;

        if (result.isEmpty()) {
            Usuarios.numberUser++;
        } else {
            System.out.println("else");
            
            Usuarios.numberUser = 1+ ltxt.getInformation(result).length;
        }
        /*
        if (f.readFileId("src\\myapp_restaurante_model\\data\\usuario.txt", "1").equals("No se encontro la persona en la lista registrada")) {
            System.out.println("else");
            Usuarios.numberUser++;
        } else {
            System.out.println("else");
            String[] information = lTxt.getInformation(f.readFile("src\\myapp_restaurante_model\\data\\usuario.txt"));
            Usuarios.numberUser = information.length + 1;
        }
         */
    }

    public String getLogin_Usuario() {
        return login_Usuario;
    }

    public void setLogin_Usuario(String login_Usuario) {
        this.login_Usuario = login_Usuario;
    }

    public String getPass_Usuario() {
        return pass_Usuario;
    }

    public void setPass_Usuario(String pass_Usuario) {
        this.pass_Usuario = pass_Usuario;
    }

    public int getNivel_Acesso() {
        return nivel_Acesso;
    }

    public void setNivel_Acesso(int nivel_Acesso) {
        this.nivel_Acesso = nivel_Acesso;
    }

    public String getNombre_Usuario() {
        return nombre_Usuario;
    }

    public void setNombre_Usuario(String nombre_Usuario) {
        this.nombre_Usuario = nombre_Usuario;
    }

    public String getApellidos_Usuario() {
        return apellidos_Usuario;
    }

    public void setApellidos_Usuario(String apellidos_Usuario) {
        this.apellidos_Usuario = apellidos_Usuario;
    }

    public String getCorreo_Usuario() {
        return correo_Usuario;
    }

    public void setCorreo_Usuario(String correo_Usuario) {
        this.correo_Usuario = correo_Usuario;
    }

    public static int getNumberUser() {
        return numberUser;
    }

    public static void setNumberUser(int numberUser) {
        Usuarios.numberUser = numberUser;
    }

    @Override
    public String toString() {
        return numberUser + "," + login_Usuario + ","
                + pass_Usuario + "," + nivel_Acesso + "," + nombre_Usuario + "," + apellidos_Usuario + "," + correo_Usuario;
    }

}

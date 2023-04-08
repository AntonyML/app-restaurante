/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Tony ML
 */
public class Usuarios {
    private String login_Usuario;
    private String pass_Usuario;
    private int nivel_Acesso;//(0,1)
    private String nombre_Usuario;
    private String apellidos_Usuario;
    private String correo_Usuario;

    public Usuarios(String login_Usuario, String pass_Usuario, int nivel_Acesso, String nombre_Usuario, String apellidos_Usuario, String correo_Usuario) {
        this.login_Usuario = login_Usuario;
        this.pass_Usuario = pass_Usuario;
        this.nivel_Acesso = nivel_Acesso;
        this.nombre_Usuario = nombre_Usuario;
        this.apellidos_Usuario = apellidos_Usuario;
        this.correo_Usuario = correo_Usuario;
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

    @Override
    public String toString() {
        return "Usuarios{" + "login_Usuario=" + login_Usuario + ", pass_Usuario=" + pass_Usuario + ", nivel_Acesso=" + nivel_Acesso + ", nombre_Usuario=" + nombre_Usuario + ", apellidos_Usuario=" + apellidos_Usuario + ", correo_Usuario=" + correo_Usuario + '}';
    }
    
}

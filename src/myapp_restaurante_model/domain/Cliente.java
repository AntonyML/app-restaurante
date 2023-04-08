/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;


public class Cliente {
     private int id_Cliente;
       private String nombre_Cliente;
         private String apellido_Cliente;
           private String apellido_Pat_Cliente;
          private String apellido_Mat_Cliente;
           private String Celular_Cliente;
            private String Correo_Cliente;

    public Cliente(int id_Cliente, String nombre_Cliente, String apellido_Cliente, String apellido_Pat_Cliente, String apellido_Mat_Cliente, String Celular_Cliente, String Correo_Cliente) {
        this.id_Cliente = id_Cliente;
        this.nombre_Cliente = nombre_Cliente;
        this.apellido_Cliente = apellido_Cliente;
        this.apellido_Pat_Cliente = apellido_Pat_Cliente;
        this.apellido_Mat_Cliente = apellido_Mat_Cliente;
        this.Celular_Cliente = Celular_Cliente;
        this.Correo_Cliente = Correo_Cliente;
    }

    public int getId_Cliente() {
        return id_Cliente;
    }

    public void setId_Cliente(int id_Cliente) {
        this.id_Cliente = id_Cliente;
    }

    public String getNombre_Cliente() {
        return nombre_Cliente;
    }

    public void setNombre_Cliente(String nombre_Cliente) {
        this.nombre_Cliente = nombre_Cliente;
    }

    public String getApellido_Cliente() {
        return apellido_Cliente;
    }

    public void setApellido_Cliente(String apellido_Cliente) {
        this.apellido_Cliente = apellido_Cliente;
    }

    public String getApellido_Pat_Cliente() {
        return apellido_Pat_Cliente;
    }

    public void setApellido_Pat_Cliente(String apellido_Pat_Cliente) {
        this.apellido_Pat_Cliente = apellido_Pat_Cliente;
    }

    public String getApellido_Mat_Cliente() {
        return apellido_Mat_Cliente;
    }

    public void setApellido_Mat_Cliente(String apellido_Mat_Cliente) {
        this.apellido_Mat_Cliente = apellido_Mat_Cliente;
    }

    public String getCelular_Cliente() {
        return Celular_Cliente;
    }

    public void setCelular_Cliente(String Celular_Cliente) {
        this.Celular_Cliente = Celular_Cliente;
    }

    public String getCorreo_Cliente() {
        return Correo_Cliente;
    }

    public void setCorreo_Cliente(String Correo_Cliente) {
        this.Correo_Cliente = Correo_Cliente;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id_Cliente=" + id_Cliente + ", nombre_Cliente=" + nombre_Cliente + ", apellido_Cliente=" + apellido_Cliente + ", apellido_Pat_Cliente=" + apellido_Pat_Cliente + ", apellido_Mat_Cliente=" + apellido_Mat_Cliente + ", Celular_Cliente=" + Celular_Cliente + ", Correo_Cliente=" + Correo_Cliente + '}';
    }
    
}

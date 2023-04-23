/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp_restaurante_model.domain;

public class Empleado {
    private int id_Empleado;
    private String nombre_Empleado;
    private String apellido1_Empleado;
    private String Apellido2_Empleado;
    private int tipo_Empleado;
    private double Balance_Propina;
    private String foto;
    private double porcentaje_Propina;

    public Empleado(int id_Empleado, String Nombre_Empleado, String Apellido1_Empleado, String Apellido2_Empleado, int tipo_Empleado, double Balance_Propina, String foto, double porcentaje_Propina) {
        this.id_Empleado = id_Empleado;
        this.nombre_Empleado = Nombre_Empleado;
        this.apellido1_Empleado = Apellido1_Empleado;
        this.Apellido2_Empleado = Apellido2_Empleado;
        this.tipo_Empleado = tipo_Empleado;
        this.Balance_Propina = Balance_Propina;
        this.foto = foto;
        this.porcentaje_Propina = porcentaje_Propina;
    }

    public int getId_Empleado() {
        return id_Empleado;
    }

    public void setId_Empleado(int id_Empleado) {
        this.id_Empleado = id_Empleado;
    }

    public String getNombre_Empleado() {
        return nombre_Empleado;
    }

    public void setNombre_Empleado(String Nombre_Empleado) {
        this.nombre_Empleado = Nombre_Empleado;
    }

    public String getApellido1_Empleado() {
        return apellido1_Empleado;
    }

    public void setApellido1_Empleado(String Apellido1_Empleado) {
        this.apellido1_Empleado = Apellido1_Empleado;
    }

    public String getApellido2_Empleado() {
        return Apellido2_Empleado;
    }

    public void setApellido2_Empleado(String Apellido2_Empleado) {
        this.Apellido2_Empleado = Apellido2_Empleado;
    }

    public int getTipo_Empleado() {
        return tipo_Empleado;
    }

    public void setTipo_Empleado(int tipo_Empleado) {
        this.tipo_Empleado = tipo_Empleado;
    }

    public double getBalance_Propina() {
        return Balance_Propina;
    }

    public void setBalance_Propina(double Balance_Propina) {
        this.Balance_Propina = Balance_Propina;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public double getPorcentaje_Propina() {
        return porcentaje_Propina;
    }

    public void setPorcentaje_Propina(double porcentaje_Propina) {
        this.porcentaje_Propina = porcentaje_Propina;
    }

    @Override
    public String toString() {
        return id_Empleado + ", " + nombre_Empleado + "," + apellido1_Empleado + "," + Apellido2_Empleado + "," + tipo_Empleado + "," + Balance_Propina + "," + foto + "," + porcentaje_Propina ;
    }
    
    
}

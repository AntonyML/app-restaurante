/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp_restaurante_model.domain;

public class Entrada_Salidad_Producto {

    private int id_E_S;
    private String fecha_E_S;
    private int tipo_E_S;
    private boolean estatus_E_S;

    public Entrada_Salidad_Producto(int id_E_S, String fecha_E_S, int tipo_E_S, boolean estatus_E_S) {
        this.id_E_S = id_E_S;
        this.fecha_E_S = fecha_E_S;
        this.tipo_E_S = tipo_E_S;
        this.estatus_E_S = estatus_E_S;
    }

    public int getId_E_S() {
        return id_E_S;
    }

    public void setId_E_S(int id_E_S) {
        this.id_E_S = id_E_S;
    }

    public String getFecha_E_S() {
        return fecha_E_S;
    }

    public void setFecha_E_S(String fecha_E_S) {
        this.fecha_E_S = fecha_E_S;
    }

    public int getTipo_E_S() {
        return tipo_E_S;
    }

    public void setTipo_E_S(int tipo_E_S) {
        this.tipo_E_S = tipo_E_S;
    }

    public boolean isEstatus_E_S() {
        return estatus_E_S;
    }

    public void setEstatus_E_S(boolean estatus_E_S) {
        this.estatus_E_S = estatus_E_S;
    }

    @Override
    public String toString() {
        return id_E_S + "," + fecha_E_S + "," + tipo_E_S + "," + estatus_E_S;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp_restaurante_model.domain;


public class Producto {

    private int id_Producto;
    private String Descripcion_Producto;
    private int tipo_Producto;
    private double precio_Producto;
    private double existencia_Producto;
    private boolean itbis_Producto;

    public Producto(int id_Producto, String Descripcion_Producto, int tipo_Producto, double precio_Producto, double existencia_Producto, boolean itbis_Producto) {
        this.id_Producto = id_Producto;
        this.Descripcion_Producto = Descripcion_Producto;
        this.tipo_Producto = tipo_Producto;
        this.precio_Producto = precio_Producto;
        this.existencia_Producto = existencia_Producto;
        this.itbis_Producto = itbis_Producto;
    }

    public int getId_Producto() {
        return id_Producto;
    }

    public void setId_Producto(int id_Producto) {
        this.id_Producto = id_Producto;
    }

    public String getDescripcion_Producto() {
        return Descripcion_Producto;
    }

    public void setDescripcion_Producto(String Descripcion_Producto) {
        this.Descripcion_Producto = Descripcion_Producto;
    }

    public int getTipo_Producto() {
        return tipo_Producto;
    }

    public void setTipo_Producto(int tipo_Producto) {
        this.tipo_Producto = tipo_Producto;
    }

    public double getPrecio_Producto() {
        return precio_Producto;
    }

    public void setPrecio_Producto(double precio_Producto) {
        this.precio_Producto = precio_Producto;
    }

    public double getExistencia_Producto() {
        return existencia_Producto;
    }

    public void setExistencia_Producto(double existencia_Producto) {
        this.existencia_Producto = existencia_Producto;
    }

    public boolean isItbis_Producto() {
        return itbis_Producto;
    }

    public void setItbis_Producto(boolean itbis_Producto) {
        this.itbis_Producto = itbis_Producto;
    }

    @Override
    public String toString() {
        return id_Producto + "," + Descripcion_Producto + "," + tipo_Producto
                + "," + precio_Producto + "," + existencia_Producto + "," + itbis_Producto;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp_restaurante_model.domain;

public final class Tipo_Producto {
     private int id_tipo_producto;
     private String nombre_tipo;

    public Tipo_Producto(int id_tipo_producto, String nombre_tipo) {
        this.id_tipo_producto = id_tipo_producto;
        this.nombre_tipo = nombre_tipo;
    }

    public int getId_tipo_producto() {
        return id_tipo_producto;
    }

    public void setId_tipo_producto(int id_tipo_producto) {
        this.id_tipo_producto = id_tipo_producto;
    }

    public String getNombre_tipo() {
        return nombre_tipo;
    }

    public void setNombre_tipo(String nombre_tipo) {
        this.nombre_tipo = nombre_tipo;
    }

    @Override
    public String toString() {
        return id_tipo_producto + "," + nombre_tipo;
    }

   
     
}

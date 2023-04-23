/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp_restaurante_model.domain;

import java.util.logging.Logger;

public class Detalle_Entrada_Salida_Producto {
   private int id_E_S_Detalle; 
   private String Sec_E_S_Detalle;
   private int id_Producto_Detalle;
   private double cant_prod_detalle;
   private double precio_prod_detalle;

    public Detalle_Entrada_Salida_Producto(Entrada_Salidad_Producto entrada_Salidad_Producto
            , String Sec_E_S_Detalle, Producto producto , double cant_prod_detalle, double precio_prod_detalle) {
        this.id_E_S_Detalle = entrada_Salidad_Producto.getId_E_S();
        this.Sec_E_S_Detalle = Sec_E_S_Detalle;
        this.id_Producto_Detalle = producto.getId_Producto();
        this.cant_prod_detalle = cant_prod_detalle;
        this.precio_prod_detalle = precio_prod_detalle;
    }

    public int getId_E_S_Detalle() {
        return id_E_S_Detalle;
    }

    public void setId_E_S_Detalle(int id_E_S_Detalle) {
        this.id_E_S_Detalle = id_E_S_Detalle;
    }

    public String getSec_E_S_Detalle() {
        return Sec_E_S_Detalle;
    }

    public void setSec_E_S_Detalle(String Sec_E_S_Detalle) {
        this.Sec_E_S_Detalle = Sec_E_S_Detalle;
    }

    public int getId_Producto_Detalle() {
        return id_Producto_Detalle;
    }

    public void setId_Producto_Detalle(int id_Producto_Detalle) {
        this.id_Producto_Detalle = id_Producto_Detalle;
    }

    public double getCant_prod_detalle() {
        return cant_prod_detalle;
    }

    public void setCant_prod_detalle(double cant_prod_detalle) {
        this.cant_prod_detalle = cant_prod_detalle;
    }

    public double getPrecio_prod_detalle() {
        return precio_prod_detalle;
    }

    public void setPrecio_prod_detalle(double precio_prod_detalle) {
        this.precio_prod_detalle = precio_prod_detalle;
    }

    @Override
    public String toString() {
        return "Detalle_Entrada_Salida_Producto{" + "id_E_S_Detalle=" + id_E_S_Detalle + ", Sec_E_S_Detalle=" + Sec_E_S_Detalle + ", id_Producto_Detalle=" + id_Producto_Detalle + ", cant_prod_detalle=" + cant_prod_detalle + ", precio_prod_detalle=" + precio_prod_detalle + '}';
    }
 
}

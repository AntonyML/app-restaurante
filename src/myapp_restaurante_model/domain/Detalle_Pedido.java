/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp_restaurante_model.domain;

/**
 *
 * @author TML
 */
public class Detalle_Pedido {
     private int id_Det_pedido;
     private int sec_pedido;
     private int id_Producto_pedido;
     private double cantidad;
     private int precio_producto;

    public Detalle_Pedido(Pedido pedido, int sec_pedido, Producto producto, double cantidad, int precio_producto) {
        this.id_Det_pedido = pedido.getId_pedido();
        this.sec_pedido = sec_pedido;
        this.id_Producto_pedido = producto.getId_Producto();
        this.cantidad = cantidad;
        this.precio_producto = precio_producto;
    }

    public int getId_Det_pedido() {
        return id_Det_pedido;
    }

    public void setId_Det_pedido(int id_Det_pedido) {
        this.id_Det_pedido = id_Det_pedido;
    }

    public int getSec_pedido() {
        return sec_pedido;
    }

    public void setSec_pedido(int sec_pedido) {
        this.sec_pedido = sec_pedido;
    }

    public int getId_Producto_pedido() {
        return id_Producto_pedido;
    }

    public void setId_Producto_pedido(int id_Producto_pedido) {
        this.id_Producto_pedido = id_Producto_pedido;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecio_producto() {
        return precio_producto;
    }

    public void setPrecio_producto(int precio_producto) {
        this.precio_producto = precio_producto;
    }

    @Override
    public String toString() {
        return "Detalle_Pedido{" + "id_Det_pedido=" + id_Det_pedido + ", sec_pedido=" + sec_pedido + ", id_Producto_pedido=" + id_Producto_pedido + ", cantidad=" + cantidad + ", precio_producto=" + precio_producto + '}';
    }
     
}

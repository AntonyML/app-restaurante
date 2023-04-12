/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp_restaurante_model.domain;

import java.util.Date;

/**
 *
 * @author TML
 */
public class Pedido {
    private int id_pedido;
    private Date fecha_Pedido;
    private int id_Cliente_pedido;//id_cliente
    private double valor_pedido;
   private double valor_itbis_pedido;
   private double valor_propina_pedido;
   private String concepto_pedido;
   private boolean status_pedido;
 private int  id_camarero_pedido;
 private int id_mesa;

    public Pedido(int id_pedido, Date fecha_Pedido, Cliente cliente, double valor_pedido,
            double valor_itbis_pedido, double valor_propina_pedido, String concepto_pedido,
            boolean status_pedido, Empleado empleado, Mesa mesa) {
        this.id_pedido = id_pedido;
        this.fecha_Pedido = fecha_Pedido;
        this.id_Cliente_pedido = cliente.getId_Cliente();
        this.valor_pedido = valor_pedido;
        this.valor_itbis_pedido = valor_itbis_pedido;
        this.valor_propina_pedido = valor_propina_pedido;
        this.concepto_pedido = concepto_pedido;
        this.status_pedido = status_pedido;
        this.id_camarero_pedido = empleado.getId_Empleado();
        this.id_mesa = mesa.getId_Mesa();
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public Date getFecha_Pedido() {
        return fecha_Pedido;
    }

    public void setFecha_Pedido(Date fecha_Pedido) {
        this.fecha_Pedido = fecha_Pedido;
    }

    public int getId_Cliente_pedido() {
        return id_Cliente_pedido;
    }

    public void setId_Cliente_pedido(int id_Cliente_pedido) {
        this.id_Cliente_pedido = id_Cliente_pedido;
    }

    public double getValor_pedido() {
        return valor_pedido;
    }

    public void setValor_pedido(double valor_pedido) {
        this.valor_pedido = valor_pedido;
    }

    public double getValor_itbis_pedido() {
        return valor_itbis_pedido;
    }

    public void setValor_itbis_pedido(double valor_itbis_pedido) {
        this.valor_itbis_pedido = valor_itbis_pedido;
    }

    public double getValor_propina_pedido() {
        return valor_propina_pedido;
    }

    public void setValor_propina_pedido(double valor_propina_pedido) {
        this.valor_propina_pedido = valor_propina_pedido;
    }

    public String getConcepto_pedido() {
        return concepto_pedido;
    }

    public void setConcepto_pedido(String concepto_pedido) {
        this.concepto_pedido = concepto_pedido;
    }

    public boolean isStatus_pedido() {
        return status_pedido;
    }

    public void setStatus_pedido(boolean status_pedido) {
        this.status_pedido = status_pedido;
    }

    public int getId_camarero_pedido() {
        return id_camarero_pedido;
    }

    public void setId_camarero_pedido(int id_camarero_pedido) {
        this.id_camarero_pedido = id_camarero_pedido;
    }

    public int getId_mesa() {
        return id_mesa;
    }

    public void setId_mesa(int id_mesa) {
        this.id_mesa = id_mesa;
    }

    @Override
    public String toString() {
        return "Pedido{" + "id_pedido=" + id_pedido + ", fecha_Pedido=" + fecha_Pedido + ", id_Cliente_pedido=" + id_Cliente_pedido + ", valor_pedido=" + valor_pedido + ", valor_itbis_pedido=" + valor_itbis_pedido + ", valor_propina_pedido=" + valor_propina_pedido + ", concepto_pedido=" + concepto_pedido + ", status_pedido=" + status_pedido + ", id_camarero_pedido=" + id_camarero_pedido + ", id_mesa=" + id_mesa + '}';
    }
 
 
   
}

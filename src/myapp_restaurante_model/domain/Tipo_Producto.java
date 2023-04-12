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
public final class Tipo_Producto {
     private int id_Cliente_Reserva;
     private int nombre_tipo;

    public Tipo_Producto(Producto producto, int nombre_tipo) {
        this.id_Cliente_Reserva = producto.getTipo_Producto();
        this.nombre_tipo = nombre_tipo;
    }

    public int getId_Cliente_Reserva() {
        return id_Cliente_Reserva;
    }

    public void setId_Cliente_Reserva(int id_Cliente_Reserva) {
        this.id_Cliente_Reserva = id_Cliente_Reserva;
    }

    public int getNombre_tipo() {
        return nombre_tipo;
    }

    public void setNombre_tipo(int nombre_tipo) {
        this.nombre_tipo = nombre_tipo;
    }

    @Override
    public String toString() {
        return "Tipo_Producto{" + "id_Cliente_Reserva=" + id_Cliente_Reserva + ", nombre_tipo=" + nombre_tipo + '}';
    }

   
     
}

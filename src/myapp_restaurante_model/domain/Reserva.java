/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.Date;

/**
 *
 * @author Tony ML
 */
public final class Reserva {

    private String id_Reserva;
    private Date fecha_Reserva;
    private int id_Cliente_Reserva;
    private int id_Mesa_Reserva;
    private boolean estado_Reserva;
    private Date fecha_Baja_Reserva;
    private String hora_act;

    public Reserva(String id_Reserva, Date fecha_Reserva, Cliente cliente,Mesa mesa, boolean estado_Reserva, Date fecha_Baja_Reserva, String hora_act) {
        this.id_Reserva = id_Reserva;
        this.fecha_Reserva = fecha_Reserva;
        asignarIdCliente(cliente);
        asignarIdMesa(mesa);
        this.estado_Reserva = estado_Reserva;
        this.fecha_Baja_Reserva = fecha_Baja_Reserva;
        this.hora_act = hora_act;
    }

    public void asignarIdCliente(Cliente cliente) {
        this.id_Cliente_Reserva = cliente.getId_Cliente();
    }

    public void asignarIdMesa(Mesa mesa) {
        this.id_Mesa_Reserva = mesa.getId_Mesa();
    }

    public String getId_Reserva() {
        return id_Reserva;
    }

    public void setId_Reserva(String id_Reserva) {
        this.id_Reserva = id_Reserva;
    }

    public Date getFecha_Reserva() {
        return fecha_Reserva;
    }

    public void setFecha_Reserva(Date fecha_Reserva) {
        this.fecha_Reserva = fecha_Reserva;
    }

    public int getId_Cliente_Reserva() {
        return id_Cliente_Reserva;
    }

    public void setId_Cliente_Reserva(int id_Cliente_Reserva) {
        this.id_Cliente_Reserva = id_Cliente_Reserva;
    }

    public int getId_Mesa_Reserva() {
        return id_Mesa_Reserva;
    }

    public void setId_Mesa_Reserva(int id_Mesa_Reserva) {
        this.id_Mesa_Reserva = id_Mesa_Reserva;
    }

    public boolean isEstado_Reserva() {
        return estado_Reserva;
    }

    public void setEstado_Reserva(boolean estado_Reserva) {
        this.estado_Reserva = estado_Reserva;
    }

    public Date getFecha_Baja_Reserva() {
        return fecha_Baja_Reserva;
    }

    public void setFecha_Baja_Reserva(Date fecha_Baja_Reserva) {
        this.fecha_Baja_Reserva = fecha_Baja_Reserva;
    }

    public String getHora_act() {
        return hora_act;
    }

    public void setHora_act(String hora_act) {
        this.hora_act = hora_act;
    }

    @Override
    public String toString() {
        return "Reserva{" + "id_Reserva=" + id_Reserva + ", fecha_Reserva=" + fecha_Reserva + ", id_Cliente_Reserva=" + id_Cliente_Reserva + ", id_Mesa_Reserva=" + id_Mesa_Reserva + ", estado_Reserva=" + estado_Reserva + ", fecha_Baja_Reserva=" + fecha_Baja_Reserva + ", hora_act=" + hora_act + '}';
    }

}

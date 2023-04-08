/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

public class Mesa {
    private int id_Mesa;
     private int max_Comensales;
      private int cant_Comensales;
       private int estatus_mesa;
        private int numeros_mesas;

    public Mesa(int id_Mesa, int max_Comensales, int cant_Comensales, int estatus_mesa, int numeros_mesas) {
        this.id_Mesa = id_Mesa;
        this.max_Comensales = max_Comensales;
        this.cant_Comensales = cant_Comensales;
        this.estatus_mesa = estatus_mesa;
        this.numeros_mesas = numeros_mesas;
    }

    public int getId_Mesa() {
        return id_Mesa;
    }

    public void setId_Mesa(int id_Mesa) {
        this.id_Mesa = id_Mesa;
    }

    public int getMax_Comensales() {
        return max_Comensales;
    }

    public void setMax_Comensales(int max_Comensales) {
        this.max_Comensales = max_Comensales;
    }

    public int getCant_Comensales() {
        return cant_Comensales;
    }

    public void setCant_Comensales(int cant_Comensales) {
        this.cant_Comensales = cant_Comensales;
    }

    public int getEstatus_mesa() {
        return estatus_mesa;
    }

    public void setEstatus_mesa(int estatus_mesa) {
        this.estatus_mesa = estatus_mesa;
    }

    public int getNumeros_mesas() {
        return numeros_mesas;
    }

    public void setNumeros_mesas(int numeros_mesas) {
        this.numeros_mesas = numeros_mesas;
    }

    @Override
    public String toString() {
        return "Mesa{" + "id_Mesa=" + id_Mesa + ", max_Comensales=" + max_Comensales + ", cant_Comensales=" + cant_Comensales + ", estatus_mesa=" + estatus_mesa + ", numeros_mesas=" + numeros_mesas + '}';
    }
        
        
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Tony ML
 */
public class Comentarios {
    private int id_Comentario;
     private String correo;
       private String asunto;
        private String comentario;
         private String fecha_comentario;

    public Comentarios(int id_Comentario, String correo, String asunto, String comentario, String fecha_comentario) {
        this.id_Comentario = id_Comentario;
        this.correo = correo;
        this.asunto = asunto;
        this.comentario = comentario;
        this.fecha_comentario = fecha_comentario;
    }

    public int getId_Comentario() {
        return id_Comentario;
    }

    public void setId_Comentario(int id_Comentario) {
        this.id_Comentario = id_Comentario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getFecha_comentario() {
        return fecha_comentario;
    }

    public void setFecha_comentario(String fecha_comentario) {
        this.fecha_comentario = fecha_comentario;
    }

    @Override
    public String toString() {
        return "Comentarios{" + "id_Comentario=" + id_Comentario + ", correo=" + correo + ", asunto=" + asunto + ", comentario=" + comentario + ", fecha_comentario=" + fecha_comentario + '}';
    }
         
         
}

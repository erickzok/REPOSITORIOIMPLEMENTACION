/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.Date;

/**
 *
 * @author Erick
 */
public class Consumible {
    String  id_consumible ;
   String nombre_consumible ;
   Date fecha_uso;
   int cantidad ;
   float costo;
   String id_servicio ;

    public String getId_consumible() {
        return id_consumible;
    }

    public void setId_consumible(String id_consumible) {
        this.id_consumible = id_consumible;
    }

    public String getNombre_consumible() {
        return nombre_consumible;
    }

    public void setNombre_consumible(String nombre_consumible) {
        this.nombre_consumible = nombre_consumible;
    }

    public Date getFecha_uso() {
        return fecha_uso;
    }

    public void setFecha_uso(Date fecha_uso) {
        this.fecha_uso = fecha_uso;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public String getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(String id_servicio) {
        this.id_servicio = id_servicio;
    }
   
}

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
public class Servicio {
    String id_servicio ;
   String nombre_servicio ;
   Date fecha_inicio;
   Date fecha_fin ;
   float costo ;
   int cantidad_servicios ;
   float subtotal_servicios;
   String tecnico_asignado ;
   String id_orden_compra;
   String id_factura;

    public String getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(String id_servicio) {
        this.id_servicio = id_servicio;
    }

    public String getNombre_servicio() {
        return nombre_servicio;
    }

    public void setNombre_servicio(String nombre_servicio) {
        this.nombre_servicio = nombre_servicio;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public int getCantidad_servicios() {
        return cantidad_servicios;
    }

    public void setCantidad_servicios(int cantidad_servicios) {
        this.cantidad_servicios = cantidad_servicios;
    }

    public float getSubtotal_servicios() {
        return subtotal_servicios;
    }

    public void setSubtotal_servicios(float subtotal_servicios) {
        this.subtotal_servicios = subtotal_servicios;
    }

    public String getTecnico_asignado() {
        return tecnico_asignado;
    }

    public void setTecnico_asignado(String tecnico_asignado) {
        this.tecnico_asignado = tecnico_asignado;
    }

    public String getId_orden_compra() {
        return id_orden_compra;
    }

    public void setId_orden_compra(String id_orden_compra) {
        this.id_orden_compra = id_orden_compra;
    }

    public String getId_factura() {
        return id_factura;
    }

    public void setId_factura(String id_factura) {
        this.id_factura = id_factura;
    }
 
}

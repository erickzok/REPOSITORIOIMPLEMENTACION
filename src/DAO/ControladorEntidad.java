/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.Conectar;
import Entidades.Servicio;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultListModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Erick
 */
public class ControladorEntidad {
   


    
    public ArrayList<Servicio> ListarServicio(){
         ArrayList<Servicio> list = new ArrayList<>();
        Conectar conec = new Conectar();

        
        String sql = "SELECT id_servicio ,nombre_servicio, fecha_inicio, fecha_fin, costo, cantidad_servicios, subtotal_servicios, tecnico_asignado , id_orden_compra ,id_factura FROM Servicio ";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = conec.getConnection().prepareStatement(sql);
                  
            rs = ps.executeQuery();
            while (rs.next()) {
             
            Servicio vo = new Servicio();
            vo.setId_servicio(rs.getString(1));
            vo.setNombre_servicio(rs.getString(2));
            vo.setFecha_inicio(rs.getDate(3));
            vo.setFecha_fin(rs.getDate(4));    
            vo.setCosto(rs.getFloat(5));
            vo.setCantidad_servicios(rs.getInt(6));
                        vo.setSubtotal_servicios(7);

            vo.setTecnico_asignado(rs.getString(8));
            vo.setId_orden_compra(rs.getString(9));
            vo.setId_factura(rs.getString(10));
                       

            
            list.add(vo);
            System.out.println("Terminóy");
        }


        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        
        }
         
    
        return list;
     }
    public DefaultListModel<String>   ListarRepuestos(String idServicio){
            
       DefaultListModel<String>   list = new DefaultListModel<>();
        Conectar conec = new Conectar();

        
        String sql = "SELECT nombrerepuesto FROM repuesto WHERE id_servicio= ? ";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = conec.getConnection().prepareStatement(sql);
            ps.setString(1,idServicio);
      
            rs = ps.executeQuery();
            while (rs.next()) {
             
            String nombreRepuesto = rs.getString("nombrerepuesto");
            
            // Agregar el valor al DefaultListModel
            list.addElement(nombreRepuesto);
            System.out.println("Terminó");
        }


        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        
        }
         
    
        return list;
     }
    public DefaultListModel<String>   ListarConsumibles(String idServicio){
            
        DefaultListModel<String>   list = new DefaultListModel<>();
        Conectar conec = new Conectar();

        
        String sql = "SELECT nombre_consumible FROM consumible WHERE id_servicio= ? ";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = conec.getConnection().prepareStatement(sql);
            ps.setString(1,idServicio);
      
            rs = ps.executeQuery();
            while (rs.next()) {
             
            String nombreConsumible = rs.getString("nombre_consumible");
            
            // Agregar el valor al DefaultListModel
            list.addElement(nombreConsumible);
            System.out.println("Terminó");
        }


        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        
        }
         
    
        return list;
     }
    public Map<String, String> AccionesRecomendadas(String idOrdenCompra) {
        Map<String, String> map = new HashMap<>();
        Conectar conec = new Conectar();

        String sql = "SELECT nombre_accion, Estado FROM accionrecomendada WHERE id_orden_compra = ?";
        ResultSet rs = null;
        PreparedStatement ps = null;
        
        try {
            ps = conec.getConnection().prepareStatement(sql);
            ps.setString(1, idOrdenCompra);

            rs = ps.executeQuery();
            while (rs.next()) {
                String nombreAccion = rs.getString("nombre_accion");
                String estado = rs.getString("Estado");

                // Agregar la entrada al mapa
                map.put(nombreAccion, estado);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            // Cerrar el ResultSet y el PreparedStatement en el bloque finally
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        return map;
    }
    public ArrayList<String> DatosServicio(String idServicio) {
        ArrayList<String> list = new ArrayList<>();
        Conectar conec = new Conectar();

        String sql = "SELECT nombre_servicio, fecha_inicio, costo, tecnico_asignado FROM Servicio WHERE id_servicio=?";
        ResultSet rs = null;
        PreparedStatement ps = null;

        try {
            ps = conec.getConnection().prepareStatement(sql);
            ps.setString(1, idServicio);

            rs = ps.executeQuery();
            while (rs.next()) {
                String nombreServicio = rs.getString("nombre_servicio");
                String fechaInicio = rs.getString("fecha_inicio");
                String costo = rs.getString("costo");
                String tecnicoAsignado = rs.getString("tecnico_asignado");

                // Añadir los valores a la lista
                list.add(nombreServicio);
                list.add(fechaInicio);
                list.add(costo);
                list.add(tecnicoAsignado);

                System.out.println("Terminó");
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        } finally {
            // Cerrar el ResultSet y el PreparedStatement en el bloque finally
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        return list;
    }
      public void registrarServicio(Servicio servicio_x){
        Conectar conec = new Conectar();

        Date fechaActual = Date.valueOf(LocalDate.now());
        String sql = "INSERT INTO Servicio (id_servicio, nombre_servicio, fecha_inicio, fecha_fin, costo, cantidad_servicios, subtotal_servicios, tecnico_asignado, id_orden_compra,if_factura) VALUES (?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = null;
        
       
        try {
            

            ps = conec.getConnection().prepareStatement(sql);
            ps.setString(1,servicio_x.getId_servicio());
            ps.setString(2,servicio_x.getNombre_servicio());
            ps.setDate(3, new java.sql.Date(servicio_x.getFecha_inicio().getTime()));
            ps.setDate(4, new java.sql.Date(servicio_x.getFecha_fin().getTime()));
            ps.setFloat(5, servicio_x.getCosto());
            ps.setInt(6, servicio_x.getCantidad_servicios() );
            ps.setFloat(7,servicio_x.getSubtotal_servicios());
            ps.setString(8, servicio_x.getTecnico_asignado());
            ps.setString(9, servicio_x.getId_orden_compra());
            ps.setString(10, servicio_x.getId_factura());


            
            
            
            
                  
            ps.executeUpdate();
            System.out.println("Resgistro  actividad correcto");


        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        
        }
         
    }
    
    
    
}


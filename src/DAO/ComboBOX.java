/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.Conectar;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author Erick
 */
public class ComboBOX {
     public Map<String, String> listarComboBoxEmpleado() {
        Map<String, String> map = new HashMap<>();
        Conectar conec = new Conectar();
        String sql = "SELECT Nombre , id_empleado FROM Empleado  ORDER BY Nombre ASC ;";
        ResultSet rs = null;
        PreparedStatement ps = null;

        try {
            ps = conec.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String nombreEmpleado = rs.getString("Nombre");
                String idEmpleado = rs.getString("id_empleado");

                // Agregar al mapa con el nombre como clave y valor
                map.put(nombreEmpleado, idEmpleado);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
                conec.desconectar();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        return map;
    }

    public void listarEmpleadoCB(JComboBox<String> CB,ArrayList<String> listaNombresEmpleado, ArrayList<String> listaIdEmpleado) {
        Map<String, String> mapaProyectos = listarComboBoxEmpleado();
           listaNombresEmpleado= new ArrayList<>(listarComboBoxEmpleado().keySet());
            listaIdEmpleado = new ArrayList<>(listarComboBoxEmpleado().values());

        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
        comboBoxModel.addElement("");
        for (String elemento : mapaProyectos.keySet()) {
            comboBoxModel.addElement(elemento);
        }

        CB.setModel(comboBoxModel);
    }
     
     
}

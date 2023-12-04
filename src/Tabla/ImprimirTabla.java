/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tabla;

import DAO.ControladorEntidad;
import Entidades.Servicio;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Erick
 */
public class ImprimirTabla {
    ControladorEntidad listaVO =  new ControladorEntidad  ();
     public void visualizar_tabla_Servicios (JTable tabla) {
    String[] nombreColumnas = {"id Servicio","Servicio", "Fecha inicio","Fecha Fin" ,"Costo", "Cantidad Servicio", "Subtotal Servicio", "Tecnico Asignado", "ID orden", "ID Factura"};
    DefaultTableModel modelo = new DefaultTableModel(null, nombreColumnas) {
        
        public Class<?> getColumnClass(int columnIndex) {
            if (columnIndex == 0) {
                return Integer.class;  // La primera columna (Id) será de tipo Integer
            }
             if(columnIndex ==1 ){
                return Integer.class;
            }
            return String.class;  // Las demás columnas serán de tipo String
        }
    };

    Servicio vo = new Servicio();
    ArrayList<Servicio> list = listaVO.ListarServicio();
    

    if (list.size() > 0) {
        for (int i = 0; i < list.size(); i++) {
            vo = list.get(i);
            Object fila[] = new Object[] {
                
                vo.getId_servicio(),
                vo.getNombre_servicio(),
                vo.getFecha_inicio(),
                vo.getFecha_fin(),
                vo.getCosto(),
                vo.getCantidad_servicios(),
                vo.getSubtotal_servicios(),
                vo.getTecnico_asignado(),
                vo.getId_orden_compra(),

                vo.getId_factura(),

                
         
                
                
            };

            modelo.addRow(fila);
        }
        
            tabla.setModel(modelo);
            tabla.setRowHeight(32);
        
        
    }
    else {
            JOptionPane.showMessageDialog(null, "¡Aviso: no Hay Actividades registradas", "Error", JOptionPane.ERROR_MESSAGE);

        }
        
   }
    public void mostrarEnJTable(JTable jTable, String idOrdenCompra) {
        // Obtener el Map de AccionesRecomendadas
       
        Map<String, String> accionesRecomendadas = listaVO.AccionesRecomendadas(idOrdenCompra);

        // Crear un modelo de tabla predeterminado
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nombre Acción");
        model.addColumn("Estado");

        // Agregar filas al modelo de tabla con los datos del Map
        for (Map.Entry<String, String> entry : accionesRecomendadas.entrySet()) {
            String nombreAccion = entry.getKey();
            String estado = entry.getValue();

            model.addRow(new Object[]{nombreAccion, estado});
        }

        // Establecer el modelo de la tabla
        jTable.setModel(model);
    }

    
}

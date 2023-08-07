/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.com.tacotitos.dao;

import ar.com.tacotitos.dto.IngredienteDTO;
import ar.com.tacotitos.dto.PedidoDTO;
import ar.com.tacotitos.dto.TacoDTO;
import ar.com.tacotitos.utils.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author Due
 */
public class TacoDao {
    
    DBConnector db = new DBConnector();
    
    public TacoDTO saveTaco (List<IngredienteDTO> listaIngredientesSelected, PedidoDTO pedido, Integer precioTotalDeIngredientesSeleccionados) {
        try {
            Connection con = db.connect();
            String sql = "insert into taco(id_pedido,costo) values(" + pedido.getId() + "," + precioTotalDeIngredientesSeleccionados + ");";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            int row = ps.executeUpdate();
                if (row == 1) {
                    sql = "SELECT * FROM taquitos.taco ORDER BY id DESC LIMIT 0, 1;";
                    Statement st = con.createStatement();
                    ResultSet rs =st.executeQuery(sql);
                    while (rs.next()) {
                        for (IngredienteDTO dto : listaIngredientesSelected) {
                            String subSql = "insert into taquitos.ingrediente_taco(id_ingrediente,id_taco,precio_ingrediente) values(" 
                                    + dto.getId() + "," 
                                    + rs.getLong("id") + "," 
                                    + dto.getPrecio() +");";
                            PreparedStatement subPs = con.prepareStatement(subSql, Statement.RETURN_GENERATED_KEYS);
                            int subRow = subPs.executeUpdate();
                        }
                        return new TacoDTO(
                            rs.getLong("id"),
                            rs.getLong("id_pedido"),
                            rs.getInt("costo"));
                    }
                }
                return null;
        } catch (Exception e) {
            System.out.println("Error al recuperar los datos de la base :(");
            e.printStackTrace();
            return null;
        }
    }
    
    public void deleteTaco (Long idTaco) {
        try {
            System.out.println("Eliminando ingredientes del taco con ID: " + idTaco);
            Connection con = db.connect();
            String sql = "delete from ingrediente_taco where id_taco = " + idTaco;
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            int row = ps.executeUpdate();
                   System.out.println("Eliminando taco con ID: " + idTaco);
                   String subSql = "delete from taco where id = " + idTaco;
                   ps = con.prepareStatement(subSql, Statement.RETURN_GENERATED_KEYS);
                   row = ps.executeUpdate();
                   System.out.println("Eliminado el taco: " + idTaco);
        } catch (Exception e) {
            System.out.println("Error al recuperar los datos de la base :(");
            e.printStackTrace();
        }
    }
}

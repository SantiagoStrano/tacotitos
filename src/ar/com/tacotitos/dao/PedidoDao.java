/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.com.tacotitos.dao;

import ar.com.tacotitos.dto.PedidoDTO;
import ar.com.tacotitos.utils.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Due
 */
public class PedidoDao {
    
    DBConnector db = new DBConnector();
    
    public PedidoDTO saveAndGetPedido () {
        try {
            Connection con = db.connect();
            String sql = "insert into pedidos(fecha,precio_total) values(now(),0);";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            int row = ps.executeUpdate();
                if (row == 1) {
                    sql = "SELECT * FROM taquitos.pedidos ORDER BY id DESC LIMIT 0, 1;";
                    Statement st = con.createStatement();
                    ResultSet rs =st.executeQuery(sql);
                    while (rs.next()) {
                        return new PedidoDTO(
                            rs.getLong("id"),
                            rs.getDate("fecha"),
                            rs.getLong("precio_total"));
                    }
                }
                return null;
            
        } catch (Exception e) {
            System.out.println("Error al recuperar los datos de la base :(");
            e.printStackTrace();
            return null;
        }
    }
    
    public void confirmarNuevoPedido (PedidoDTO pedido, Integer precioTotalPedido) {
        try {
            Connection con = db.connect();
            String sql = "update taquitos.pedidos set alta = 1, precio_total = " + precioTotalPedido + " where id = " + pedido.getId() + ";";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            int row = ps.executeUpdate();
                if (row == 1) {
                    System.out.println("Pedido ingresado correctamente!");
                }
        } catch (Exception e) {
            System.out.println("Error al actualizar el pedido :(");
            e.printStackTrace();
        }
    }
    
    public void cancelarPedido (PedidoDTO pedido) {
        try {
            System.out.println("Entro a cancelarPedidoS");
            Connection con = db.connect();
            String sql = "SELECT * FROM taquitos.taco where id_pedido = " + pedido.getId() + ";";
                    Statement st = con.createStatement();
                    ResultSet rs =st.executeQuery(sql);
                        while (rs.next()) {
                            Long idTaco = rs.getLong("id");
                            System.out.println("Borrando los ingredientes del taco: " + idTaco);
                            sql = " DELETE from taquitos.ingrediente_taco where id_taco = " + idTaco + ";";
                            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                            ps.executeUpdate();
                            System.out.println("Borre los ingedientes del taco: " +idTaco);
                            System.out.println("Ahora borro el taco con id: " +idTaco);
                                String subSql = "DELETE from taquitos.taco where id = " + idTaco + ";";
                                ps = con.prepareStatement(subSql, Statement.RETURN_GENERATED_KEYS);
                                ps.executeUpdate();
                                System.out.println("Borre el taco de id: " +idTaco);
                        }
                        String subSql = "DELETE from taquitos.pedidos where id = " + pedido.getId() + ";";
                        PreparedStatement ps = con.prepareStatement(subSql, Statement.RETURN_GENERATED_KEYS);
                        ps.executeUpdate();
                        System.out.println("Pedido Cancelado.");
        } catch (Exception e) {
            System.out.println("Error al cancelar el pedido.");
            e.printStackTrace();
        }
    }
    
}

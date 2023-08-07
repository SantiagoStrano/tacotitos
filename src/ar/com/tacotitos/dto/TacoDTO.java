/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.com.tacotitos.dto;

/**
 *
 * @author Due
 */
public class TacoDTO {
    private Long id;
    private Long idPedido;
    private Integer costo; 
    
    public TacoDTO (Long id, Long idPedido, Integer costo) {
        this.id = id;
        this.idPedido = idPedido;
        this.costo = costo;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId (Long id) {
        this.id = id;
    }
    
    public Integer getCosto() {
        return costo;
    }
    
    public void setCosto (Integer costo) {
        this.costo = costo;
    }
    public Long getIdPedido() {
        return idPedido;
    }
    
    public void setIdPedido (Long idPedido) {
        this.idPedido = idPedido;
    }
}


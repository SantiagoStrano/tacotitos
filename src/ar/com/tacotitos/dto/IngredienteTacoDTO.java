/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.com.tacotitos.dto;

/**
 *
 * @author Due
 */
public class IngredienteTacoDTO {
    private Long idIngrediente;
    private Long idTipoIngrediente;
    private Long idTaco;
    
    public IngredienteTacoDTO (Long idIngrediente, Long idTipoIngrediente, Long idTaco) {
        this.idIngrediente = idIngrediente;
        this.idTipoIngrediente = idTipoIngrediente;
        this.idTaco = idTaco;
    }
 
    
    public Long getIdIngrediente() {
        return idIngrediente;
    }
    
    public void setIdIngrediente (Long idIngrediente) {
        this.idIngrediente = idIngrediente;
    }
    
    public Long getIdTipoIngrediente() {
        return idTipoIngrediente;
    }
    
    public void setIdTipoIngrediente (Long idTipoIngrediente) {
        this.idTipoIngrediente = idTipoIngrediente;
    }
    
    public Long getIdTaco() {
        return idTaco;
    }
    
    public void setIdTaco (Long idTaco) {
        this.idTaco = idTaco;
    }

}


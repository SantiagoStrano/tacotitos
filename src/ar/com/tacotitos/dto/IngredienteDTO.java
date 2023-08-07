/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.com.tacotitos.dto;

/**
 *
 * @author Due
 */
public class IngredienteDTO {
    
    private Long id;
    private String nombre;
    private Long idTipoIngrediente;//ID de la tabla a la que hace referencia
    private Integer precio; 
    private Boolean baja;
    
    public IngredienteDTO () {
        
    }
    public IngredienteDTO (Long id, String nombre, Long id_tipo_ingrediente, Integer precio){
        this.id = id;
        this.nombre = nombre;
        this.idTipoIngrediente = id_tipo_ingrediente;
        this.precio = precio;
    }
    
    public IngredienteDTO (Long id, String nombre, Long id_tipo_ingrediente, Integer precio, Boolean baja){
        this.id = id;
        this.nombre = nombre;
        this.idTipoIngrediente = id_tipo_ingrediente;
        this.precio = precio;
        this.baja = baja;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId (Long id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre (String nombre) {
        this.nombre = nombre;
    }
    
    public Long getIdTipoIngrediente() {
        return idTipoIngrediente;
    }
    
    public void setIdTipoIngrediente (Long idTipoIngrediente) {
        this.idTipoIngrediente = idTipoIngrediente;
    }
    
    public Integer getPrecio() {
        return precio;
    }
    
    public void setPrecio (Integer precio) {
        this.precio = precio;
    }
    
    public Boolean getBaja() {
        return baja;
    }
    
    public void setBaja (Boolean baja) {
        this.baja = baja;
    }
}

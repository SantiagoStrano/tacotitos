/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.com.tacotitos.controller;

import ar.com.tacotitos.dto.IngredienteDTO;
import ar.com.tacotitos.dto.PedidoDTO;
import ar.com.tacotitos.dto.TacoDTO;
import ar.com.tacotitos.service.TacoService;
import java.util.List;

/**
 *
 * @author Due
 */
public class TacoController {
    
    TacoService service = new TacoService();
    
    public TacoDTO saveTaco(List<IngredienteDTO> listaIngredientesSelected, PedidoDTO pedido, Integer precioTotalDeIngredientesSeleccionados) {
        TacoDTO taco = service.saveTaco(listaIngredientesSelected, pedido, precioTotalDeIngredientesSeleccionados);
        return taco;
    }
    
    public void deleteTaco (Long idTaco){
        service.deleteTaco(idTaco);
    };
    
    
}

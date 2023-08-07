/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.com.tacotitos.service;

import ar.com.tacotitos.dao.TacoDao;
import ar.com.tacotitos.dto.IngredienteDTO;
import ar.com.tacotitos.dto.TacoDTO;
import ar.com.tacotitos.dto.PedidoDTO;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class TacoService {
    
    TacoDao tDao = new TacoDao();
    
    public TacoDTO saveTaco (List<IngredienteDTO> listaIngredientesSelected, PedidoDTO pedido, Integer precioTotalDeIngredientesSeleccionados){
        return tDao.saveTaco(listaIngredientesSelected, pedido, precioTotalDeIngredientesSeleccionados);
    };
    
    public void deleteTaco (Long idTaco){
        tDao.deleteTaco(idTaco);
    };
}

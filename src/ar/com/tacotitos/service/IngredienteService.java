/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.com.tacotitos.service;

import ar.com.tacotitos.dao.IngredienteDao;
import ar.com.tacotitos.dao.TipoIngredienteDao;
import ar.com.tacotitos.dto.IngredienteDTO;
import ar.com.tacotitos.dto.TipoIngredienteDTO;
import java.util.List;

/**
 *
 * @author Due
 */
public class IngredienteService {
    
    TipoIngredienteDao tiDao = new TipoIngredienteDao();
    IngredienteDao iDao = new IngredienteDao();
    
    public List<IngredienteDTO> getByTipoIngredienteId(Long idTipoIngrediente){
        return iDao.getByTipoIngredienteId(idTipoIngrediente);
    };
    
    public List<IngredienteDTO> getIngredientes () {
        return iDao.getIngredientes();
    }
    
    public List<IngredienteDTO> getIngredientesDeTacoBarato(){
        return iDao.getIngredientesDeTacoBarato();
    };
    
    public Integer save(String nombre, String precio, String tipoIngrediente) {
        IngredienteDTO data = new IngredienteDTO();
        List<TipoIngredienteDTO> lista = tiDao.getAll();
        for (TipoIngredienteDTO dto : lista) {
            if (dto.getNombre().equals(tipoIngrediente)) {
                data = new IngredienteDTO();
                data.setNombre(nombre);
                data.setIdTipoIngrediente(dto.getId());
                data.setPrecio(Integer.parseInt(precio));
            }
        }
        if (data != null) {
            return iDao.save(data);
        } else {
          return 0; 
        }
    }
}

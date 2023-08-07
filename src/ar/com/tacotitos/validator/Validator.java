/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.com.tacotitos.validator;

import ar.com.tacotitos.controller.TipoIngredienteController;
import ar.com.tacotitos.dto.IngredienteDTO;
import ar.com.tacotitos.dto.IngredienteTacoDTO;
import ar.com.tacotitos.dto.TipoIngredienteDTO;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Usuario
 */
public class Validator {
    
    TipoIngredienteController tipoIngredienteController = new TipoIngredienteController();
    
    public ValidationMessage esValido (List<IngredienteDTO> listaIngredientesSelected) {
        StringBuilder sb = new StringBuilder();
        Boolean isValid = Boolean.TRUE;
        List<TipoIngredienteDTO> list = tipoIngredienteController.getTiposDeIngrediente();
        HashMap <TipoIngredienteDTO,Long> mapaDeIngredientes = new HashMap <TipoIngredienteDTO,Long>();
        for (TipoIngredienteDTO ing : list) {
            mapaDeIngredientes.put(ing, Long.valueOf(0));
        }
        //Empiezo a validar los ingredientes
        if (listaIngredientesSelected.isEmpty()) {
            isValid = Boolean.FALSE;
            sb.append("No se ingresó ningun elemento.\n");
        } else if (listaIngredientesSelected.size() > 8) {
            isValid = Boolean.FALSE;
            sb.append("Solo podés ingresa un maximo de 8 elementos.\n");
        } else {
            for (IngredienteDTO ingredienteTaco : listaIngredientesSelected) {
                for (Map.Entry<TipoIngredienteDTO,Long> entry : mapaDeIngredientes.entrySet()) {
                    if (entry.getKey().getId() == ingredienteTaco.getIdTipoIngrediente()) {
                        entry.setValue(entry.getValue()+1);
                    }
                }
            }
            for (Map.Entry<TipoIngredienteDTO,Long> entry : mapaDeIngredientes.entrySet()) {
                switch (entry.getKey().getNombre()){
                    case "tortilla":
                        System.out.println("Entro a validar tortillas...");
                        if (entry.getValue() == 0) {
                            isValid = Boolean.FALSE;
                            sb.append("Necesitas ingresar al menos una tortilla\n");
                        }
                        if (entry.getValue() > 2) {
                            isValid = Boolean.FALSE;
                            sb.append("Solo puedes agregar como maximo dos tortillas\n");
                        }
                    break;
                    case "salsa":
                        System.out.println("Entro a validar salsas...");
                        if (entry.getValue() > 1) {
                            isValid = Boolean.FALSE;
                            sb.append("Solo puedes agregar como maximo una salsa\n");
                        }
                    break;
                    case "alimento":
                        System.out.println("Entro a validar alimentos...");
                        if (entry.getValue() == 0) {
                            isValid = Boolean.FALSE;
                            sb.append("Necesitas ingresar al menos un alimento\n");
                        }
                        if (entry.getValue() > 5) {
                            isValid = Boolean.FALSE;
                            sb.append("Solo se pueden agregar un maximo de 5 ingredientes\n");
                        }
                    break;   
                }
            }
        }
        return new ValidationMessage(isValid, sb.toString().isBlank() ? "Taco ingresado con exito." : sb.toString());
    }
}

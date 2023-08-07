/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.com.tacotitos.validator;

/**
 *
 * @author Usuario
 */
public class ValidationMessage {

    private Boolean isValid;
    private String message;
    
    public ValidationMessage (Boolean isValid, String message) {
        this.isValid = isValid;
        this.message = message;
    }

    public Boolean getIsValid() {
        return isValid;
    }
    
    public void setIsValid (Boolean isValid) {
        this.isValid = isValid;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage (String message) {
        this.message = message;
    }
}

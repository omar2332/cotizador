/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;


public class Validaciones {
    
    
    public boolean validarRfc(String rfc){
        rfc=rfc.toUpperCase().trim();
        return rfc.toUpperCase().matches("[A-Z]{4}[0-9]{6}[A-Z0-9]{3}");
    }//Cierra método validarRFC
    
    public boolean isValidEmailAddress(String email) { //Para validar el EMAIl
        boolean result = true;  
        try {
           InternetAddress emailAddr = new InternetAddress(email);
           emailAddr.validate();
        } catch (AddressException ex) {
           result = false;
        }
        return result;
    }
    public boolean isNumber(char ch){ //Para detectar si el caracter es un numero
        return ch >= '0' && ch <= '9';
    }

    public boolean isValidSignal(char ch,javax.swing.JTextField labelVigencia){ // para revisar si existe un signo negativo
        if( (labelVigencia.getText() == null || "".equals(labelVigencia.getText().trim()) ) && ch == '-'){
            return true;
        }

        return false;
    }

    public boolean validatePoint(char ch,javax.swing.JTextField labelVigencia){//validar el punto decimal
        if(ch != '.'){
            return false;
        }

        if(labelVigencia.getText() == null || "".equals(labelVigencia.getText().trim())){
            labelVigencia.setText("0.");
            return false;
        }else if("-".equals(labelVigencia.getText())){
            labelVigencia.setText("-0.");
        }

        return true;
    }
    
    
}

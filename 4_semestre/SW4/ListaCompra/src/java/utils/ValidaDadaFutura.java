/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author aluno
 */
@FacesValidator(value = "validaDataFutura")

public class ValidaDadaFutura implements Validator<Date> {

    @Override
    public void validate(FacesContext context, UIComponent component, Date value)
            throws ValidatorException {
        Date data = value;
        Date hoje = new Date();
        if (hoje.after(data)) {
            throw new ValidatorException(new FacesMessage("Data deve ser Futura"));
        }
    }

}

package validador;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("agendamentoDateValidator")
public class DateValitador implements Validator {

    List<Integer> daysOfWeek = List.of(
            Calendar.TUESDAY,
            Calendar.WEDNESDAY,
            Calendar.THURSDAY
    );

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        if (value == null) {
            throw new ValidatorException(new FacesMessage("O data nao pode estar vazia"));
        }
        Date date = (Date) value;
        Calendar time = Calendar.getInstance();
        time.setTime(date);

        int getWeek = time.get(Calendar.DAY_OF_WEEK);

        Optional<Integer> week = daysOfWeek.stream()
                .filter(a -> a == getWeek)
                .findAny();

        if (week.isEmpty()) {
            throw new ValidatorException(new FacesMessage("O dia da semana não é válido!\n São aceitos somente Terça, Quata e Quinta das 08:00 as 17:45"));
        }

    }

}

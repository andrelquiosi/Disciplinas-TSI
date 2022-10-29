package converters;

import dao.MarcaDAO;
import entidade.Modelo;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

@ApplicationScoped
@Named(value="modeloConverter")
public class ModeloConverter implements Converter {

    @Inject
    MarcaDAO marcaBean;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            int id = Integer.parseInt( value );
            return marcaBean.buscarModelo( id );
        } catch(NumberFormatException ex) { }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
       if (value == null) {
           return null;
       }
       Modelo mod = (Modelo) value;
       return String.valueOf( mod.getId() );
    }
    
}

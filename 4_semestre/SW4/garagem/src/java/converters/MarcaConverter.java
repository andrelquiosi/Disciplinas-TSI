package converters;

import dao.MarcaDAO;
import entidade.Marca;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

@ApplicationScoped
@Named(value="marcaConverter")
public class MarcaConverter implements Converter {
    
    @Inject
    MarcaDAO mBean;
   
    @Override
    public String getAsString(FacesContext context, 
            UIComponent component, Object value) {
        if (value == null) {
            return null;
        }
        Marca m = (Marca) value;
        return String.valueOf( m.getId() );
    }

    @Override
    public Object getAsObject(FacesContext context,
            UIComponent component, String value) {
        try {
            int codigo = Integer.parseInt(value);
            return mBean.buscarMarca( codigo );
        } catch(NumberFormatException nfe) { 
        }
        return null;
    }
}

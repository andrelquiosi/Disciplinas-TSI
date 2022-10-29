package beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

@Named(value = "userBean")
@SessionScoped
public class UserBean implements Serializable {

    private boolean logado = false;
    private String userName, password;
    
    public UserBean() { }
    
    public String logar() {
        if ("admin".equals(userName) && 
            "123456".equals(password)) {
            logado = true;
            return "admin/cad_marcas.xhtml";
        }
        return "login.xhtml";
    }

    public boolean isLogado() {
        return logado;
    }

    public void setLogado(boolean logado) {
        this.logado = logado;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}

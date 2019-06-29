/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hieptd.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import hieptd.daos.RegistrationDAO;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author Hiep
 */
public class LoginAction extends ActionSupport {
    private static final String ERROR = "error";
    private static final String ADMIN = "admin";
    private static final String USER = "user";
    
    private String username, password;
    
    public LoginAction() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String execute() throws Exception {
        String url = ERROR;
        RegistrationDAO dao = new RegistrationDAO();
        String role = dao.checkLogin(username, password);
        HttpServletRequest request = ServletActionContext.getRequest();
        if(role.equals("failed"))
            request.setAttribute("ERROR", "INVALID username or password");
        else {
            Map session = ActionContext.getContext().getSession();
            session.put("USERLOGIN", username);
            if(role.equals("admin"))
                url = ADMIN;
            else if(role.equals("user"))
                url = USER;
            else
                request.setAttribute("ERROR", "Your role is not supported");
        }
        return url;
    }
    
    @Override
    public void validate(){
        if(username.length() == 0){
            addFieldError("username", "Username can't be blank");
        }
        if(password.length() == 0){
            addFieldError("password", "Password can't be blank");
        }
    }
    
}

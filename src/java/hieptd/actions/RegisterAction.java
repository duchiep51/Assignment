/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hieptd.actions;

import com.opensymphony.xwork2.ActionSupport;
import hieptd.daos.RegistrationDAO;
import hieptd.dtos.RegistrationDTO;

/**
 *
 * @author Hiep
 */
public class RegisterAction extends ActionSupport {
    private String username, password, confirm, emailId, phoneNo;

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

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public RegisterAction() {
    }
    
    public String execute() throws Exception {
        RegistrationDAO dao = new RegistrationDAO();
        RegistrationDTO dto = new RegistrationDTO(username, password, emailId, phoneNo);
        if(dao.insert(dto))
            return "success";
        return "fail";
    }
    
}

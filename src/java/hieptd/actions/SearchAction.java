/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hieptd.actions;

import hieptd.daos.RegistrationDAO;
import hieptd.dtos.RegistrationDTO;
import java.util.List;

/**
 *
 * @author Hiep
 */
public class SearchAction {
    private String searchValue;
    private List<RegistrationDTO> listAccount;

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public List<RegistrationDTO> getListAccount() {
        return listAccount;
    }

    public void setListAccount(List<RegistrationDTO> listAccount) {
        this.listAccount = listAccount;
    }
    
    public SearchAction() {
    }
    
    public String execute() throws Exception {
        RegistrationDAO dao = new RegistrationDAO();
        listAccount = dao.findByLikeName(searchValue);
        return "success";
    }
    
}

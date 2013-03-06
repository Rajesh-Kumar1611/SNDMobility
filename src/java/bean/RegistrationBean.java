/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.OfficeDao;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;



import javax.faces.bean.SessionScoped;
/**
 *
 * @author Dhriti
 */
@ManagedBean(name="registrationBean")
@SessionScoped
public class RegistrationBean implements Serializable{
private String username,office,roles,password;



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    /**
     *
     * @return
     */
public ArrayList<RegistrationBean> officename(String s) {
        return OfficeDao.getOfficename();
        
        
    }
}

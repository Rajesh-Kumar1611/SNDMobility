/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.RegistrationBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Dhriti
 */
public class OfficeDao {
    public static ArrayList<RegistrationBean> getOfficename() {
        try {
            Connection con = DataBase.getConnection();
            PreparedStatement ps = con.prepareStatement("select fld_OfficeID_int,fld_Office_Name_VC from tbloffice");
            ArrayList<RegistrationBean> al = new ArrayList<RegistrationBean>();
            ResultSet rs = ps.executeQuery();
            boolean found = false;
            while (rs.next()) {
                RegistrationBean e = new RegistrationBean();
                e.setOffice(rs.getString("fld_Office_Name_VC"));
                al.add(e);
                found = true;
            }
            System.out.println(al);
            rs.close();
            if (found) {
                return al;
            } else {
                return null; // no entires found
            }
        } catch (Exception e) {
            System.out.println("Error In getUser() -->" + e.getMessage());
            return (null);
        }
    }
}

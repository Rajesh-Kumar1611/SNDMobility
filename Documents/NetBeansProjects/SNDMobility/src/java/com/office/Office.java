/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.office;

import com.utils.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Avin
 */
public class Office {
    
    public static ArrayList<OfficeGetters_n_Setters> getOfficeDetails()
    {
         try {
            Connection con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement("select fld_Office_Name_VC,fld_OfficeType_int,fld_Createdby_VC,fld_CreatedDate_date,fld_ModifiedBy_VC,fld_ModifiedDate_date,fld_Email_VC,fld_Website_VC,fld_WorkPhno_int,fld_CellPhno_int,fld_Faxno_int,fld_Buildingno_VC,fld_Street_VC,fld_AreaLocality_VC,fld_LandMark_VC,fld_City_VC,fld_ZipCode,fld_State_VC,fld_Country_VC,fld_Comments_VC from tbloffice");
            ArrayList<OfficeGetters_n_Setters> al = new ArrayList<OfficeGetters_n_Setters>();
            ResultSet rs = ps.executeQuery();
            boolean found = false;
            while (rs.next()) {
                OfficeGetters_n_Setters e = new OfficeGetters_n_Setters();
                e.setFld_Office_Name_VC(rs.getString("fld_Office_Name_VC"));  
                e.setFld_OfficeType_int(rs.getInt("fld_OfficeType_int"));
                e.setFld_Createdby_VC(rs.getString("fld_Createdby_VC"));
                e.setFld_CreatedDate_date(rs.getDate("fld_CreatedDate_date"));
                e.setFld_ModifiedBy_VC(rs.getString("fld_ModifiedBy_VC"));
                e.setFld_ModifiedDate_date(rs.getDate("fld_ModifiedDate_date"));
                e.setFld_Email_VC(rs.getString("fld_Email_VC"));
                e.setFld_Website_VC(rs.getString("fld_Website_VC"));
                e.setFld_WorkPhno_int(rs.getInt("fld_WorkPhno_int"));
                e.setFld_CellPhno_int(rs.getInt("fld_CellPhno_int"));
                e.setFld_Faxno_int(rs.getInt("fld_Faxno_int"));
                e.setFld_Buildingno_VC(rs.getString("fld_Buildingno_VC"));
                e.setFld_Street_VC(rs.getString("fld_Street_VC"));
                e.setFld_AreaLocality_VC(rs.getString("fld_AreaLocality_VC"));
                e.setFld_LandMark_VC(rs.getString("fld_LandMark_VC"));
                e.setFld_City_VC(rs.getString("fld_City_VC"));
                e.setFld_ZipCode(rs.getInt("fld_ZipCode"));
                e.setFld_State_VC(rs.getString("fld_State_VC"));
                e.setFld_Country_VC(rs.getString("fld_Country_VC"));
                e.setFld_Comments_VC(rs.getString("fld_Comments_VC"));
                
             
                al.add(e);
                found = true;
            }
            
            System.out.println("Arraylist"+al);
            rs.close();
            if (found) {
                return al;
            } else {
                return null; // no entires found
            }
        } catch (Exception e) {
            System.out.println("Error In getCustomer() -->" + e.getMessage());
            return (null);
        }
    }
    
}

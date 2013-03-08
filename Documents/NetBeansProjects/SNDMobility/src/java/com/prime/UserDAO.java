/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.product;

import com.utils.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Avin
 */
class UserDAO {
    
    public static ArrayList<CB> getCustomer() {
        try {
            Connection con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from tblproduct");
            ArrayList<CB> al = new ArrayList<CB>();
            ResultSet rs = ps.executeQuery();
            boolean found = false;
            while (rs.next()) {
                CB e = new CB();
                e.setFld_ProductID_int(rs.getInt("fld_ProductID_int"));
                e.setFld_ProductName_VC(rs.getString("fld_ProductName_VC"));
                e.setFld_Product_Price_float(rs.getFloat("fld_Product_Price_float"));
                e.setFld_CatogeryID_int(rs.getInt("fld_CatogeryID_int"));
                e.setFld_RemainingQty_int(rs.getInt("fld_RemainingQty_int"));
                e.setFld_reorderlevel_int(rs.getInt("fld_reorderlevel_int"));
                e.setFld_productavilable_bool(rs.getBoolean("fld_productavilable_bool"));
                e.setFld_Createdby_VC(rs.getString("fld_Createdby_VC"));
               e.setFld_CreatedDate_date(rs.getDate(9));
                e.setFld_ModifiedBy_VC(rs.getString("fld_ModifiedBy_VC"));
               e.setFld_ModifiedDate_date(rs.getDate(11));
                
                
               
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

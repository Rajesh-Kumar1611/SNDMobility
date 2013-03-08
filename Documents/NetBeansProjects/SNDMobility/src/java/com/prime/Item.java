/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.product;

import com.utils.DBUtil;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;
 
@ManagedBean(name = "item")
@SessionScoped

/**
 *
 * @author Avin
 */
public class Item implements Serializable{
     private static  ArrayList<Ob> orderList = new ArrayList<Ob>();
    
     private int fld_ProductID_int,fld_CatogeryID_int,fld_RemainingQty_int,fld_reorderlevel_int;
    private String fld_ProductName_VC,fld_Createdby_VC,fld_ModifiedBy_VC;
    private float fld_Product_Price_float;
    private Date fld_CreatedDate_date,fld_ModifiedDate_date;
    private boolean fld_productavilable_bool;

    public int getFld_RemainingQty_int() {
        return fld_RemainingQty_int;
    }

    public void setFld_RemainingQty_int(int fld_RemainingQty_int) {
        this.fld_RemainingQty_int = fld_RemainingQty_int;
    }

    public int getFld_reorderlevel_int() {
        return fld_reorderlevel_int;
    }

    public void setFld_reorderlevel_int(int fld_reorderlevel_int) {
        this.fld_reorderlevel_int = fld_reorderlevel_int;
    }

    public boolean isFld_productavilable_bool() {
        return fld_productavilable_bool;
    }

    public void setFld_productavilable_bool(boolean fld_productavilable_bool) {
        this.fld_productavilable_bool = fld_productavilable_bool;
    }
    
    
    Ob order;

    public int getFld_ProductID_int() {
        return fld_ProductID_int;
    }

    public void setFld_ProductID_int(int fld_ProductID_int) {
        this.fld_ProductID_int = fld_ProductID_int;
    }

    public int getFld_CatogeryID_int() {
        return fld_CatogeryID_int;
    }

    public void setFld_CatogeryID_int(int fld_CatogeryID_int) {
        this.fld_CatogeryID_int = fld_CatogeryID_int;
    }

    public String getFld_ProductName_VC() {
        return fld_ProductName_VC;
    }

    public void setFld_ProductName_VC(String fld_ProductName_VC) {
        this.fld_ProductName_VC = fld_ProductName_VC;
    }

    public String getFld_Createdby_VC() {
        return fld_Createdby_VC;
    }

    public void setFld_Createdby_VC(String fld_Createdby_VC) {
        this.fld_Createdby_VC = fld_Createdby_VC;
    }

    public String getFld_ModifiedBy_VC() {
        return fld_ModifiedBy_VC;
    }

    public void setFld_ModifiedBy_VC(String fld_ModifiedBy_VC) {
        this.fld_ModifiedBy_VC = fld_ModifiedBy_VC;
    }

    public float getFld_Product_Price_float() {
        return fld_Product_Price_float;
    }

    public void setFld_Product_Price_float(float fld_Product_Price_float) {
        this.fld_Product_Price_float = fld_Product_Price_float;
    }

    public Date getFld_CreatedDate_date() {
        return fld_CreatedDate_date;
    }

    public void setFld_CreatedDate_date(Date fld_CreatedDate_date) {
        this.fld_CreatedDate_date = fld_CreatedDate_date;
    }

    public Date getFld_ModifiedDate_date() {
        return fld_ModifiedDate_date;
    }

    public void setFld_ModifiedDate_date(Date fld_ModifiedDate_date) {
        this.fld_ModifiedDate_date = fld_ModifiedDate_date;
    }

    public Ob getOrder() {
        return order;
    }

    public void setOrder(Ob order) {
        this.order = order;
    }
    
    
    
     
     public ArrayList<Ob> getOrderList() {
        return orderList;
    }
     
     
     
     public void setOrderlist(ArrayList<Ob> obj)
     {
         this.orderList=obj;
     }
 
    public String addAction() {
        
        
       this.fld_ProductID_int=fld_ProductID_int;
       this.fld_CatogeryID_int=fld_CatogeryID_int;
       this.fld_ProductName_VC=fld_ProductName_VC;
       this.fld_Createdby_VC=fld_Createdby_VC;
       this.fld_ModifiedBy_VC=fld_ModifiedBy_VC;
       this.fld_Product_Price_float=fld_Product_Price_float;
       this.fld_CreatedDate_date=fld_CreatedDate_date;
       this.fld_ModifiedDate_date=fld_ModifiedDate_date;
       this.fld_productavilable_bool=fld_productavilable_bool;
       
        
        Ob orderitem = new Ob(this.fld_ProductID_int,this.fld_CatogeryID_int, this.fld_ProductName_VC,this.fld_Createdby_VC,this.fld_Product_Price_float);
        
        Connection con=null;
        Item user= new Item();
        
         java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
         
         String admin="admin";
         int i=1;
        
        
        try
            // inserting details...
        { 
            con = DBUtil.getConnection();
            
            PreparedStatement ps=con.prepareStatement("insert into tblproduct values('"+getFld_ProductID_int()+"','"+getFld_ProductName_VC()+"','"+getFld_Product_Price_float()+"','"+getFld_CatogeryID_int()+"','"+i+"','"+i+"','"+i+"','"+admin+"','"+sqlDate+"','"+admin+"','"+sqlDate+"')");
            ps.executeUpdate();
            System.out.println("Data inserteds");
            
        }
        catch(Exception e ){
            System.out.println("Exception while inserting record"+e);
        }

        
        
        
        
        
        
        orderList.add(orderitem);
 
      
        return null;
    }
    public void onEdit(RowEditEvent event) {  
        FacesMessage msg = new FacesMessage("Item Edited",((Ob) event.getObject()).getItem());  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }  
       
    public void onCancel(RowEditEvent event) {  
        FacesMessage msg = new FacesMessage("Item Cancelled");   
        FacesContext.getCurrentInstance().addMessage(null, msg); 
        orderList.remove((Ob) event.getObject());
    }  
    
    
    
}

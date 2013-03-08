package com.product;

import java.io.Serializable;
import java.util.Date;


public class Ob implements Serializable
{
    
    private int fld_ProductID_int,fld_CatogeryID_int;
    private String fld_ProductName_VC,fld_Createdby_VC,fld_ModifiedBy_VC;
    private float fld_Product_Price_float;
    private Date fld_CreatedDate_date,fld_ModifiedDate_date;
    
    public Ob(int fld_ProductID_int,int fld_CatogeryID_int,String fld_ProductName_VC,String fld_Createdby_VC,float fld_Product_Price_float)
    {
        
       this.fld_ProductID_int=fld_ProductID_int;
       this.fld_CatogeryID_int=fld_CatogeryID_int;
       this.fld_ProductName_VC=fld_ProductName_VC;
       this.fld_Createdby_VC=fld_Createdby_VC;
       this.fld_Product_Price_float=fld_Product_Price_float;
      
      
    } 

    Ob(int fld_ProductID_int, int fld_CatogeryID_int, String fld_ProductName_VC, String fld_Createdby_VC, float fld_Product_Price_float, String imageID, String imageName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

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

    String getItem() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
    
}

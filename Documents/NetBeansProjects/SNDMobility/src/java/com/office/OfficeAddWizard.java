/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.office;

import com.utils.DBUtil;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author Avin
 */
@ManagedBean
public class OfficeAddWizard {
    
    
   static private OfficeGettersNSettersForWizard user=new OfficeGettersNSettersForWizard();

    public OfficeAddWizard() {
        
    }
	
	private boolean skip;
	
	private static Logger logger = Logger.getLogger(OfficeAddWizard.class.getName());

	public OfficeGettersNSettersForWizard getUser() {
		return user;
	}

	public void setUser(OfficeGettersNSettersForWizard user) {
		this.user = user;
	}
	
	public void store() {
		//persist user;
            
            Connection con=null;    
            java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
            String admin="admin";
            int i=0;
            int id=getMax();
             try
            // inserting details...
        { 
            con = DBUtil.getConnection();
            
            PreparedStatement ps=con.prepareStatement("insert into tbloffice values('"+id+"','"+user.getFld_Office_Name_VC()+"','"+user.getFld_OfficeType_int()+"','"+admin+"','"+sqlDate+"','"+admin+"','"+sqlDate+"','"+user.getFld_Email_VC()+"','"+user.getFld_Website_VC()+"','"+user.getFld_WorkPhno_int()+"','"+user.getFld_CellPhno_int()+"','"+user.getFld_Faxno_int()+"','"+user.getFld_Buildingno_VC()+"','"+user.getFld_Street_VC()+"','"+user.getFld_AreaLocality_VC()+"','"+user.getFld_LandMark_VC()+"','"+user.getFld_City_VC()+"','"+user.getFld_ZipCode()+"','"+user.getFld_State_VC()+"','"+user.getFld_Country_VC()+"','"+user.getFld_Comments_VC()+"')");
            ps.executeUpdate();
            System.out.println("Data inserteds");
            user.setFld_Office_Name_VC("");
            user.setFld_OfficeType_int(0);
            user.setFld_Email_VC("");
            user.setFld_Website_VC("");
            user.setFld_WorkPhno_int(0);
            user.setFld_CellPhno_int(0);
            user.setFld_Faxno_int(0);
            user.setFld_Buildingno_VC("");
            user.setFld_Street_VC("");
            user.setFld_AreaLocality_VC("");
            user.setFld_LandMark_VC("");
            user.setFld_City_VC("");
            user.setFld_ZipCode(0);
            user.setFld_State_VC("");
            user.setFld_Country_VC("");
            user.setFld_Comments_VC("");
        }
        catch(Exception e ){
            System.out.println("Exception while inserting record  :"+e);
        }
            
            
            
		
		FacesMessage msg = new FacesMessage("ADDED", " Office : " + user.getFld_Office_Name_VC());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
        
        public int getMax()
        {
            
            Connection con=null;
            int i = 0;
             try
            // inserting details...
            { 
            con = DBUtil.getConnection();
              PreparedStatement ps = con.prepareStatement("select Max(fld_OfficeID_int) from tbloffice");
              ResultSet rs = ps.executeQuery();
              while(rs.next())
              {
                i= rs.getInt(1);
              }
        
              
            
            }
            catch(Exception e ){
            System.out.println("Exception while inserting record  :"+e);
            }
            return i+1;
        }
        
        
	public boolean isSkip() {
		return skip;
	}

	public void setSkip(boolean skip) {
		this.skip = skip;
	}
	
	public String onFlowProcess(FlowEvent event) {
		logger.info("Current wizard step:" + event.getOldStep());
		logger.info("Next step:" + event.getNewStep());
                logger.info("User"+user.getFld_Office_Name_VC());
		
		if(skip) {
			skip = false;	//reset in case user goes back
			return "confirm";
		}
		else {
			return event.getNewStep();
		}
	}
    
}

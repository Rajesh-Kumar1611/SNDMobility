/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.beans;


import com.pojo.WareHouse;
import com.utils.DBUtil;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.event.NodeSelectEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;


/**
 *
 * @author ubuntu
 */
@ManagedBean
public class WareHouseBean {



    private TreeNode root;
    private TreeNode treenode;
    private TreeNode selectedNode;
    private static  List<WareHouse> list;
    private static List<WareHouse> arraylist;
    private WareHouse warehouseobject;
    private List<WareHouse> subList2;
    private String warehousestring;
    
    
    private List<WareHouse> getProductNames()
    {
           Connection conn=null;
        List<WareHouse> cat=new ArrayList<WareHouse>();
        try {
        conn=DBUtil.getConnection();
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery("select setFld_WareHouseID_int,setFld_WareHouseName_VC,setFld_WareHouseParentID,setFld_OfficeID_int from tblwarehousetree");
        while(rs.next())
        {
        WareHouse warehouse=new WareHouse();
        warehouse.setFld_WareHouseID_int(rs.getInt(1));
        warehouse.setFld_WareHouseName_VC(rs.getString(2));
        warehouse.setFld_WareHouseParentID(rs.getInt(3));
        warehouse.setFld_OfficeID_int(rs.getInt(4));
        cat.add(warehouse);
        
        }
        } catch (Exception e) {
            System.out.println("Exception while reading"+e);
        }
        finally
        {
            try {
                DBUtil.closeConnection(conn);
            } catch (Exception e) {
            }
        
        
        }
    return cat;
    }
    
    public WareHouseBean() {
        list=new ArrayList<WareHouse>();
        root=new DefaultTreeNode("Root",null);
        list=getProductNames();
        treenode=new DefaultTreeNode("", root);
        recursive(list, 0,treenode);

    }
    public  void recursive(List<WareHouse> list, int id,TreeNode node){
            subList2=new ArrayList<WareHouse>();
            subList2=subWarehouse(id);
              for(WareHouse k:subList2){
            TreeNode childNode=new DefaultTreeNode(k.getFld_WareHouseName_VC(), node);
             recursive(subList2, k.getFld_WareHouseID_int(),childNode);
          }

    }
    public static List<WareHouse> subWarehouse(int i)
    {
        arraylist=new ArrayList<WareHouse>();
        for(WareHouse k:getList()){
            if(k.getFld_WareHouseParentID()==i){
                arraylist.add(k);
            }
        }
        return arraylist;
    }

  
    public void selectedNode(NodeSelectEvent event){
        FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_INFO, "selected", event.getTreeNode().getData().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
   
      public void createNode(){
//        JOptionPane.showMessageDialog(null,katCont.kategoriIdDonder(getSelectedNode().getData().toString()).getKategoriId());
//        katNesnesi=new Warehouse(getWarehousestring(), katCont.kategoriIdDonder(getSelectedNode().getData().toString()).getKategoriId());
//         katCont.create(katNesnesi);
//         setKategIsmi(null);
          
          int parentid=0;
          System.out.println(getSelectedNode().getData().toString()+" child"+warehousestring);
          
        Connection conn=null;
        List<WareHouse> cat=new ArrayList<WareHouse>();
        try {
      
        conn=DBUtil.getConnection();
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery("select fld_CatogeryID_int from tblcatlogtree where fld_CatogeryName_VC='"+getSelectedNode().getData().toString()+"'");
        while(rs.next())
        {
        parentid=rs.getInt(1);
        
        }
        
        stmt.executeUpdate("insert into tblcatlogtree values ("+getMax()+",'"+warehousestring+"','"+parentid+"','Rajesh','asdasd','Rajesh','kjasd')");
        
        
        
        } catch (Exception e) {
            System.out.println("Exception while writing"+e);
        }
        finally
        {
            try {
                DBUtil.closeConnection(conn);
            } catch (Exception e) {
            }
        }
        warehousestring="";
        
          
    }
      
     private int getMax()
     {
        int max=0;
       Connection conn=null;
      
        try {
        conn=DBUtil.getConnection();
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery("select max(fld_CatogeryID_int) from tblcatlogtree");
        while(rs.next())
        {
        max=rs.getInt(1);
        
        }
        max=max+1;        
        
        
        } catch (Exception e) {
           max=0;
            System.out.println("Exception while writing"+e);
        }
        finally
        {
            try {
                DBUtil.closeConnection(conn);
                
            } catch (Exception e) {
            }
        }
     return max;
     
     }
     public List<WareHouse> getMessages() {
        return getProductNames();
    }
    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public TreeNode getTreenode() {
        return treenode;
    }

    public void setTreenode(TreeNode treenode) {
        this.treenode = treenode;
    }

    public TreeNode getSelectedNode() {
        return selectedNode;
    }

    public void setSelectedNode(TreeNode selectedNode) {
        this.selectedNode = selectedNode;
    }

    public static List<WareHouse> getList() {
        return list;
    }

    public static void setList(List<WareHouse> list) {
        WareHouseBean.list = list;
    }

    public static List<WareHouse> getArraylist() {
        return arraylist;
    }

    public static void setArraylist(List<WareHouse> arraylist) {
        WareHouseBean.arraylist = arraylist;
    }

    public WareHouse getWarehouseobject() {
        return warehouseobject;
    }

    public void setWarehouseobject(WareHouse warehouseobject) {
        this.warehouseobject = warehouseobject;
    }

    public List<WareHouse> getSubList2() {
        return subList2;
    }

    public void setSubList2(List<WareHouse> subList2) {
        this.subList2 = subList2;
    }

    public String getWarehousestring() {
        return warehousestring;
    }

    public void setWarehousestring(String warehousestring) {
        this.warehousestring = warehousestring;
    }
    
    
}

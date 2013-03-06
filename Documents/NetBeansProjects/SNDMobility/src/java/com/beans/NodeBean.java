/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.beans;

import com.pojo.Categeory;
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
public class NodeBean {

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

    public static List<Categeory> getList() {
        return list;
    }

    public static void setList(List<Categeory> list) {
        NodeBean.list = list;
    }

    public static List<Categeory> getArraylist() {
        return arraylist;
    }

    public static void setArraylist(List<Categeory> arraylist) {
        NodeBean.arraylist = arraylist;
    }

    public Categeory getCategeoryobject() {
        return categeoryobject;
    }

    public void setCategeoryobject(Categeory categeoryobject) {
        this.categeoryobject = categeoryobject;
    }

    public List<Categeory> getSubList2() {
        return subList2;
    }

    public void setSubList2(List<Categeory> subList2) {
        this.subList2 = subList2;
    }

    public String getCategeorystring() {
        return categeorystring;
    }

    public void setCategeorystring(String categeorystring) {
        this.categeorystring = categeorystring;
    }

    private TreeNode root;
    private TreeNode treenode;
    private TreeNode selectedNode;
    private static  List<Categeory> list;
    private static List<Categeory> arraylist;
    private Categeory categeoryobject;
    private List<Categeory> subList2;
    private String categeorystring;
    
    private List<Categeory> getProductNames()
    {
           Connection conn=null;
        List<Categeory> cat=new ArrayList<Categeory>();
        try {
        conn=DBUtil.getConnection();
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery("select * from tblcatlogtree");
        while(rs.next())
        {
        Categeory categeory=new Categeory();
        categeory.setFldCatogeryIDint(rs.getInt(1));
        categeory.setFldCatogeryNameVC(rs.getString(2));
        categeory.setFldCatogeryParentIDint(rs.getInt(3));
        categeory.setFldCreatedStringdate(rs.getString(4));
        categeory.setFldModifiedByVC(rs.getString(5));
        categeory.setFldModifiedStringdate(rs.getString(6));
        cat.add(categeory);
        
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
    
    public NodeBean() {
        list=new ArrayList<Categeory>();
        root=new DefaultTreeNode("Root",null);
        list=getProductNames();
        treenode=new DefaultTreeNode("", root);
        recursive(list, 0,treenode);

    }
    public  void recursive(List<Categeory> list, int id,TreeNode node){
            subList2=new ArrayList<Categeory>();
            subList2=subCategeory(id);
              for(Categeory k:subList2){
            TreeNode childNode=new DefaultTreeNode(k.getFldCatogeryNameVC(), node);
             recursive(subList2, k.getFldCatogeryIDint(),childNode);
          }

    }
    public static List<Categeory> subCategeory(int i)
    {
        arraylist=new ArrayList<Categeory>();
        for(Categeory k:getList()){
            if(k.getFldCatogeryParentIDint()==i){
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
//        katNesnesi=new Categeory(getCategeorystring(), katCont.kategoriIdDonder(getSelectedNode().getData().toString()).getKategoriId());
//         katCont.create(katNesnesi);
//         setKategIsmi(null);
          
          int parentid=0;
          System.out.println(getSelectedNode().getData().toString()+" child"+categeorystring);
          
        Connection conn=null;
        List<Categeory> cat=new ArrayList<Categeory>();
        try {
      
        conn=DBUtil.getConnection();
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery("select fld_CatogeryID_int from tblcatlogtree where fld_CatogeryName_VC='"+getSelectedNode().getData().toString()+"'");
        while(rs.next())
        {
        parentid=rs.getInt(1);
        
        }
        
        stmt.executeUpdate("insert into tblcatlogtree values ("+getMax()+",'"+categeorystring+"','"+parentid+"','Rajesh','asdasd','Rajesh','kjasd')");
        
        
        
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
        categeorystring="";
        
          
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
     public List<Categeory> getMessages() {
        return getProductNames();
    }

    
}

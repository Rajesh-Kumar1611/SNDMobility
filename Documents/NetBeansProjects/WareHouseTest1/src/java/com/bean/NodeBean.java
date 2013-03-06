/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bean;

import com.entity.Tblcatlogtree;
import com.entity.TblcatlogtreeJpaController;
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

    private TreeNode root;
    private TreeNode donanim;
    private TreeNode selectedNode;
    private static  List<Tblcatlogtree> list;
    private static List<Tblcatlogtree> arraylist;
    private TblcatlogtreeJpaController katCont;
    private Tblcatlogtree katNesnesi;
    private List<Tblcatlogtree> subList2;
    private String kategIsmi;
    public NodeBean() {
        list=new ArrayList<Tblcatlogtree>();
        root=new DefaultTreeNode("Root",null);
        katCont=new TblcatlogtreeJpaController();
        list=katCont.findTblcatlogtreeEntities();
        donanim=new DefaultTreeNode("", root);
//Butun kategorileri tutan bir ana kategori olusturuyor.
//Dynamic olarak sub kategori ekliyor. Recursive olarak hepsini kontrol edilmesi lazim.
        recursive(list, 0,donanim);

    }
//Dynamic tree viewi olutruan method.
    public  void recursive(List<Tblcatlogtree> list, int id,TreeNode node){
            subList2=new ArrayList<Tblcatlogtree>();
            subList2=subKategori(id);
              for(Tblcatlogtree k:subList2){
            TreeNode childNode=new DefaultTreeNode(k.getFldCatogeryNameVC(), node);
//Veritabaninda kategori tablosunu tree view seklinde dynamic olarak olusturmayi saglar.
             recursive(subList2, k.getFldCatogeryIDint(),childNode);
          }

    }
//herhangi bir tree nodenin childlarini buluyor.
    public static List<Tblcatlogtree> subKategori(int i)
    {
        arraylist=new ArrayList<Tblcatlogtree>();
        for(Tblcatlogtree k:getListe()){
            if(k.getFldCatogeryParentIDint()==i){
                arraylist.add(k);
            }
        }
        return arraylist;
    }
    public static List<Tblcatlogtree> getListe() {
        return list;
    }
    public Tblcatlogtree getKatNesnesi() {
        return katNesnesi;
    }
    public void setKatNesnesi(Tblcatlogtree katNesnesi) {
        this.katNesnesi = katNesnesi;
    }
    public TreeNode getRoot() {
        return root;
    }
    
    public TreeNode getSelectedNode() {
        return selectedNode;
    }

    public void setSelectedNode(TreeNode selectedNode) {
        this.selectedNode = selectedNode;
    }
    public void secilenNode(NodeSelectEvent event){
        FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_INFO, "selected", event.getTreeNode().getData().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
   
    public String getKategIsmi() {
        return kategIsmi;
    }

    public void setKategIsmi(String kategIsmi) {
        this.kategIsmi = kategIsmi;
    }


    public void yeniKatEkle(){
        try {
            
        katNesnesi=new Tblcatlogtree(getKategIsmi(), katCont.kategoriIdDonder(getSelectedNode().getData().toString()).getFldCatogeryIDint());
         katCont.create(katNesnesi);
         setKategIsmi(null);
        } catch (Exception e) {
        }
//        JOptionPane.showMessageDialog(null,katCont.kategoriIdDonder(getSelectedNode().getData().toString()).getKategoriId());
    }
    
}

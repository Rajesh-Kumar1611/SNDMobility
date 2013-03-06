/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Rajesh
 */
@Entity
@Table(name = "tblcatlogtree")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblcatlogtree.findAll", query = "SELECT t FROM Tblcatlogtree t"),
    @NamedQuery(name = "Tblcatlogtree.findByFldCatogeryIDint", query = "SELECT t FROM Tblcatlogtree t WHERE t.fldCatogeryIDint = :fldCatogeryIDint"),
    @NamedQuery(name = "Tblcatlogtree.", query = "SELECT t FROM TblcatfindByFldCatogeryNameVClogtree t WHERE t.fldCatogeryNameVC = :fldCatogeryNameVC"),
    @NamedQuery(name = "Tblcatlogtree.findByFldCatogeryParentIDint", query = "SELECT t FROM Tblcatlogtree t WHERE t.fldCatogeryParentIDint = :fldCatogeryParentIDint"),
    @NamedQuery(name = "Tblcatlogtree.findByFldCreatedbyVC", query = "SELECT t FROM Tblcatlogtree t WHERE t.fldCreatedbyVC = :fldCreatedbyVC"),
    @NamedQuery(name = "Tblcatlogtree.findByFldCreatedDatedate", query = "SELECT t FROM Tblcatlogtree t WHERE t.fldCreatedDatedate = :fldCreatedDatedate"),
    @NamedQuery(name = "Tblcatlogtree.findByFldModifiedByVC", query = "SELECT t FROM Tblcatlogtree t WHERE t.fldModifiedByVC = :fldModifiedByVC"),
    @NamedQuery(name = "Tblcatlogtree.findByFldModifiedDatedate", query = "SELECT t FROM Tblcatlogtree t WHERE t.fldModifiedDatedate = :fldModifiedDatedate")})
public class Tblcatlogtree implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "fld_CatogeryID_int")
    private Integer fldCatogeryIDint;
    @Size(max = 100)
    @Column(name = "fld_CatogeryName_VC")
    private String fldCatogeryNameVC;
    @Column(name = "fld_CatogeryParentID_int")
    private Integer fldCatogeryParentIDint;
    @Size(max = 45)
    @Column(name = "fld_Createdby_VC")
    private String fldCreatedbyVC;
    @Column(name = "fld_CreatedDate_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fldCreatedDatedate;
    @Size(max = 45)
    @Column(name = "fld_ModifiedBy_VC")
    private String fldModifiedByVC;
    @Column(name = "fld_ModifiedDate_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fldModifiedDatedate;

    public Tblcatlogtree() {
    }

    public Tblcatlogtree(Integer fldCatogeryIDint) {
        this.fldCatogeryIDint = fldCatogeryIDint;
    }  




    public Tblcatlogtree(String kategoriAdi, Integer katUstId) {
        this.fldCatogeryNameVC = kategoriAdi;
        this.fldCatogeryParentIDint = katUstId;
    }
    
    

    public Integer getFldCatogeryIDint() {
        return fldCatogeryIDint;
    }

    public void setFldCatogeryIDint(Integer fldCatogeryIDint) {
        this.fldCatogeryIDint = fldCatogeryIDint;
    }

    public String getFldCatogeryNameVC() {
        return fldCatogeryNameVC;
    }

    public void setFldCatogeryNameVC(String fldCatogeryNameVC) {
        this.fldCatogeryNameVC = fldCatogeryNameVC;
    }

    public Integer getFldCatogeryParentIDint() {
        return fldCatogeryParentIDint;
    }

    public void setFldCatogeryParentIDint(Integer fldCatogeryParentIDint) {
        this.fldCatogeryParentIDint = fldCatogeryParentIDint;
    }

    public String getFldCreatedbyVC() {
        return fldCreatedbyVC;
    }

    public void setFldCreatedbyVC(String fldCreatedbyVC) {
        this.fldCreatedbyVC = fldCreatedbyVC;
    }

    public Date getFldCreatedDatedate() {
        return fldCreatedDatedate;
    }

    public void setFldCreatedDatedate(Date fldCreatedDatedate) {
        this.fldCreatedDatedate = fldCreatedDatedate;
    }

    public String getFldModifiedByVC() {
        return fldModifiedByVC;
    }

    public void setFldModifiedByVC(String fldModifiedByVC) {
        this.fldModifiedByVC = fldModifiedByVC;
    }

    public Date getFldModifiedDatedate() {
        return fldModifiedDatedate;
    }

    public void setFldModifiedDatedate(Date fldModifiedDatedate) {
        this.fldModifiedDatedate = fldModifiedDatedate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fldCatogeryIDint != null ? fldCatogeryIDint.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblcatlogtree)) {
            return false;
        }
        Tblcatlogtree other = (Tblcatlogtree) object;
        if ((this.fldCatogeryIDint == null && other.fldCatogeryIDint != null) || (this.fldCatogeryIDint != null && !this.fldCatogeryIDint.equals(other.fldCatogeryIDint))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Tblcatlogtree[ fldCatogeryIDint=" + fldCatogeryIDint + " ]";
    }
    
}

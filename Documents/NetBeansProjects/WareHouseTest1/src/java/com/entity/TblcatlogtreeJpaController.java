/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.entity;


import com.entity.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author ubuntu
 */
public class TblcatlogtreeJpaController {

    public TblcatlogtreeJpaController() {
        emf = Persistence.createEntityManagerFactory("TblcatlogtreePU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tblcatlogtree kategoriler) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(kategoriler);
            em.getTransaction().commit();
        } finally {           if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tblcatlogtree kategoriler) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            kategoriler = em.merge(kategoriler);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = kategoriler.getFldCatogeryIDint();
                if (findTblcatlogtree(id) == null) {
                    throw new NonexistentEntityException("The kategoriler with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tblcatlogtree kategoriler;
            try {

                kategoriler = em.getReference(Tblcatlogtree.class, id);
                kategoriler.getFldCatogeryIDint();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The kategoriler with id " + id + " no longer exists.", enfe);
            }
            em.remove(kategoriler);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tblcatlogtree> findTblcatlogtreeEntities() {
        return findTblcatlogtreeEntities(true, -1, -1);
    }

    public List<Tblcatlogtree> findTblcatlogtreeEntities(int maxResults, int firstResult) {
        return findTblcatlogtreeEntities(false, maxResults, firstResult);
    }

    private List<Tblcatlogtree> findTblcatlogtreeEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from Tblcatlogtree as o");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Tblcatlogtree findTblcatlogtree(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tblcatlogtree.class, id);
        } finally {
            em.close();
        }
    }

    public int getTblcatlogtreeCount() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select count(o) from Tblcatlogtree as o");
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
//Gelen kategori isminine ait id yi donderiyor. Bu method normalde ide tarafından oluşturulmuyor. Kendim yazdim
    public Tblcatlogtree kategoriIdDonder(String kategoriAdi)
    {
        EntityManager em=getEntityManager();
        try{
            Query query=em.createQuery("SELECT k FROM Tblcatlogtree k WHERE k.fldCatogeryNameVC =?").setParameter(1, kategoriAdi);;
        return (Tblcatlogtree) query.getSingleResult();
        }finally{
            em.close();
        }
    }

}

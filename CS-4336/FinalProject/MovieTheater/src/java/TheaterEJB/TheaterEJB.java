/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheaterEJB;

import GEntities.Movie;
import GEntities.Purchase;
import GEntities.Theater;
import GEntities.Times;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Timestamp;


/**
 *
 * @author Garry_12
 */
@Stateless
public class TheaterEJB {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext(unitName = "MovieTheaterPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    public List<Theater> findAllTheaters() {
        return em.createNamedQuery("Theater.findAll", Theater.class).getResultList();
    }

    public List<Theater> findAllTheatersByZip(String zipInt) {
        return em.createNamedQuery("Theater.findByTzip", Theater.class).setParameter("tzip", zipInt).getResultList();
    }

    public List<Movie> findAllMoviesByTid(Theater T) {
        //return em.createNamedQuery("Movie.findByTheaterId", Movie.class).setParameter("tid", TID).getResultList();
        return T.getMovieList();
    }

    public List<Times> findAllMovieTimes(int TID, int M_ID) {
        return em.createNamedQuery("Times.findByMovieIDTid", Times.class).setParameter("tid", TID).setParameter("m_id", M_ID).getResultList();
    }
    
    public void insertCheckOut(Purchase p){    
       //em.persist(p);
       /*em.createNamedQuery("PURCHASE.insertOrder", PURCHASE.class)
               .setParameter("pid", p.getPid())
               .setParameter("tid", p.getTid())
               .setParameter("m_id",p.getM_id())
               .setParameter("pname",p.getPname())
               .setParameter("pemail", p.getPemail())
               .setParameter("pnum_tickets",p.getPnum_tickets())
               .setParameter("pphone", p.getPphone())
               .setParameter("pdatecur", p.getPdatecur())
               .setParameter("pmovieDate",p.getPmovieDate());*/
       em.persist(p);
    }
}
//INSERT INTO PURCHASE(pid,tid,m_id,pname,pemail,pnum_tickets,pphone,pdatecur,pmovieDate) VALUES (:pid,:tid,:m_id,:pname,:pemail,:pnum_tickets,:pphone,:pdatecur,:pmovieDate)
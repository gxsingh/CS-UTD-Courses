/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GEntities;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Garry_12
 */
@Entity
@Table(name = "TIMES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Times.findAll", query = "SELECT t FROM Times t"),
    @NamedQuery(name = "Times.findByTid", query = "SELECT t FROM Times t WHERE t.timesPK.tid = :tid"),
    @NamedQuery(name = "Times.findByMId", query = "SELECT t FROM Times t WHERE t.timesPK.mId = :mId"),
    @NamedQuery(name = "Times.findByTtime", query = "SELECT t FROM Times t WHERE t.timesPK.ttime = :ttime"),
    @NamedQuery(name = "Times.findByMovieIDTid", query = "SELECT s FROM Times s, Theater t, Movie m WHERE (s.timesPK.mId = m.mId AND s.timesPK.tid = t.tid) AND (t.tid = :tid AND m.mId = :m_id)")})
public class Times implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TimesPK timesPK;
    @JoinColumn(name = "M_ID", referencedColumnName = "M_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Movie movie;
    @JoinColumn(name = "TID", referencedColumnName = "TID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Theater theater;

    public Times() {
    }

    public Times(TimesPK timesPK) {
        this.timesPK = timesPK;
    }

    public Times(int tid, int mId, String ttime) {
        this.timesPK = new TimesPK(tid, mId, ttime);
    }

    public TimesPK getTimesPK() {
        return timesPK;
    }

    public void setTimesPK(TimesPK timesPK) {
        this.timesPK = timesPK;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (timesPK != null ? timesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Times)) {
            return false;
        }
        Times other = (Times) object;
        if ((this.timesPK == null && other.timesPK != null) || (this.timesPK != null && !this.timesPK.equals(other.timesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "GEntities.Times[ timesPK=" + timesPK + " ]";
    }
    
}

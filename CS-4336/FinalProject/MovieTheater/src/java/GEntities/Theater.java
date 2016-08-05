/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GEntities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Garry_12
 */
@Entity
@Table(name = "THEATER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Theater.findAll", query = "SELECT t FROM Theater t"),
    @NamedQuery(name = "Theater.findByTid", query = "SELECT t FROM Theater t WHERE t.tid = :tid"),
    @NamedQuery(name = "Theater.findByTname", query = "SELECT t FROM Theater t WHERE t.tname = :tname"),
    @NamedQuery(name = "Theater.findByTphone", query = "SELECT t FROM Theater t WHERE t.tphone = :tphone"),
    @NamedQuery(name = "Theater.findByTaddress", query = "SELECT t FROM Theater t WHERE t.taddress = :taddress"),
    @NamedQuery(name = "Theater.findByTcity", query = "SELECT t FROM Theater t WHERE t.tcity = :tcity"),
    @NamedQuery(name = "Theater.findByTstate", query = "SELECT t FROM Theater t WHERE t.tstate = :tstate"),
    @NamedQuery(name = "Theater.findByTzip", query = "SELECT t FROM Theater t WHERE t.tzip = :tzip")})
public class Theater implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TID")
    private Integer tid;
    @Size(max = 100)
    @Column(name = "TNAME")
    private String tname;
    @Size(max = 15)
    @Column(name = "TPHONE")
    private String tphone;
    @Size(max = 100)
    @Column(name = "TADDRESS")
    private String taddress;
    @Size(max = 100)
    @Column(name = "TCITY")
    private String tcity;
    @Size(max = 2)
    @Column(name = "TSTATE")
    private String tstate;
    @Size(max = 5)
    @Column(name = "TZIP")
    private String tzip;
    @JoinTable(name = "THEATER_MOVIE", joinColumns = {
        @JoinColumn(name = "TID", referencedColumnName = "TID")}, inverseJoinColumns = {
        @JoinColumn(name = "M_ID", referencedColumnName = "M_ID")})
    @ManyToMany
    private List<Movie> movieList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "theater")
    private List<Times> timesList;
    @OneToMany(mappedBy = "tid")
    private List<Purchase> purchaseList;

    public Theater() {
    }

    public Theater(Integer tid) {
        this.tid = tid;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTphone() {
        return tphone;
    }

    public void setTphone(String tphone) {
        this.tphone = tphone;
    }

    public String getTaddress() {
        return taddress;
    }

    public void setTaddress(String taddress) {
        this.taddress = taddress;
    }

    public String getTcity() {
        return tcity;
    }

    public void setTcity(String tcity) {
        this.tcity = tcity;
    }

    public String getTstate() {
        return tstate;
    }

    public void setTstate(String tstate) {
        this.tstate = tstate;
    }

    public String getTzip() {
        return tzip;
    }

    public void setTzip(String tzip) {
        this.tzip = tzip;
    }

    @XmlTransient
    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }

    @XmlTransient
    public List<Times> getTimesList() {
        return timesList;
    }

    public void setTimesList(List<Times> timesList) {
        this.timesList = timesList;
    }

    @XmlTransient
    public List<Purchase> getPurchaseList() {
        return purchaseList;
    }

    public void setPurchaseList(List<Purchase> purchaseList) {
        this.purchaseList = purchaseList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tid != null ? tid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Theater)) {
            return false;
        }
        Theater other = (Theater) object;
        if ((this.tid == null && other.tid != null) || (this.tid != null && !this.tid.equals(other.tid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "GEntities.Theater[ tid=" + tid + " ]";
    }
    
}

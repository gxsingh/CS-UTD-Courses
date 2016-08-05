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
@Table(name = "MOVIE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movie.findAll", query = "SELECT m FROM Movie m"),
    @NamedQuery(name = "Movie.findByMId", query = "SELECT m FROM Movie m WHERE m.mId = :mId"),
    @NamedQuery(name = "Movie.findByMname", query = "SELECT m FROM Movie m WHERE m.mname = :mname"),
    @NamedQuery(name = "Movie.findByMduration", query = "SELECT m FROM Movie m WHERE m.mduration = :mduration"),
    @NamedQuery(name = "Movie.findByMgenre", query = "SELECT m FROM Movie m WHERE m.mgenre = :mgenre"),
    @NamedQuery(name = "Movie.findByMrating", query = "SELECT m FROM Movie m WHERE m.mrating = :mrating"),
    @NamedQuery(name = "Movie.findByMdescription", query = "SELECT m FROM Movie m WHERE m.mdescription = :mdescription"),
    @NamedQuery(name = "Movie.findByMactors", query = "SELECT m FROM Movie m WHERE m.mactors = :mactors"),
    @NamedQuery(name = "Movie.findByMyear", query = "SELECT m FROM Movie m WHERE m.myear = :myear"),
    @NamedQuery(name = "Movie.findByMimgloc", query = "SELECT m FROM Movie m WHERE m.mimgloc = :mimgloc")})
public class Movie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "M_ID")
    private Integer mId;
    @Size(max = 100)
    @Column(name = "MNAME")
    private String mname;
    @Column(name = "MDURATION")
    private Integer mduration;
    @Size(max = 100)
    @Column(name = "MGENRE")
    private String mgenre;
    @Size(max = 20)
    @Column(name = "MRATING")
    private String mrating;
    @Size(max = 250)
    @Column(name = "MDESCRIPTION")
    private String mdescription;
    @Size(max = 350)
    @Column(name = "MACTORS")
    private String mactors;
    @Column(name = "MYEAR")
    private Integer myear;
    @Size(max = 150)
    @Column(name = "MIMGLOC")
    private String mimgloc;
    @ManyToMany(mappedBy = "movieList")
    private List<Theater> theaterList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "movie")
    private List<Times> timesList;
    @OneToMany(mappedBy = "mId")
    private List<Purchase> purchaseList;

    public Movie() {
    }

    public Movie(Integer mId) {
        this.mId = mId;
    }

    public Integer getMId() {
        return mId;
    }

    public void setMId(Integer mId) {
        this.mId = mId;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public Integer getMduration() {
        return mduration;
    }

    public void setMduration(Integer mduration) {
        this.mduration = mduration;
    }

    public String getMgenre() {
        return mgenre;
    }

    public void setMgenre(String mgenre) {
        this.mgenre = mgenre;
    }

    public String getMrating() {
        return mrating;
    }

    public void setMrating(String mrating) {
        this.mrating = mrating;
    }

    public String getMdescription() {
        return mdescription;
    }

    public void setMdescription(String mdescription) {
        this.mdescription = mdescription;
    }

    public String getMactors() {
        return mactors;
    }

    public void setMactors(String mactors) {
        this.mactors = mactors;
    }

    public Integer getMyear() {
        return myear;
    }

    public void setMyear(Integer myear) {
        this.myear = myear;
    }

    public String getMimgloc() {
        return mimgloc;
    }

    public void setMimgloc(String mimgloc) {
        this.mimgloc = mimgloc;
    }

    @XmlTransient
    public List<Theater> getTheaterList() {
        return theaterList;
    }

    public void setTheaterList(List<Theater> theaterList) {
        this.theaterList = theaterList;
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
        hash += (mId != null ? mId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movie)) {
            return false;
        }
        Movie other = (Movie) object;
        if ((this.mId == null && other.mId != null) || (this.mId != null && !this.mId.equals(other.mId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "GEntities.Movie[ mId=" + mId + " ]";
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GEntities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Garry_12
 */
@Entity
@Table(name = "PURCHASE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Purchase.findAll", query = "SELECT p FROM Purchase p"),
    @NamedQuery(name = "Purchase.findByPid", query = "SELECT p FROM Purchase p WHERE p.pid = :pid"),
    @NamedQuery(name = "Purchase.findByPname", query = "SELECT p FROM Purchase p WHERE p.pname = :pname"),
    @NamedQuery(name = "Purchase.findByPemail", query = "SELECT p FROM Purchase p WHERE p.pemail = :pemail"),
    @NamedQuery(name = "Purchase.findByPnumTickets", query = "SELECT p FROM Purchase p WHERE p.pnumTickets = :pnumTickets"),
    @NamedQuery(name = "Purchase.findByPphone", query = "SELECT p FROM Purchase p WHERE p.pphone = :pphone"),
    @NamedQuery(name = "Purchase.findByPdatecur", query = "SELECT p FROM Purchase p WHERE p.pdatecur = :pdatecur"),
    @NamedQuery(name = "Purchase.findByPmoviedate", query = "SELECT p FROM Purchase p WHERE p.pmoviedate = :pmoviedate")})
public class Purchase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PID")
    private Integer pid;
    @Size(max = 150)
    @Column(name = "PNAME")
    private String pname;
    @Size(max = 100)
    @Column(name = "PEMAIL")
    private String pemail;
    @Column(name = "PNUM_TICKETS")
    private Integer pnumTickets;
    @Size(max = 15)
    @Column(name = "PPHONE")
    private String pphone;
    @Column(name = "PDATECUR")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pdatecur;
    @Column(name = "PMOVIEDATE")
    @Temporal(TemporalType.DATE)
    private Date pmoviedate;
    @JoinColumn(name = "M_ID", referencedColumnName = "M_ID")
    @ManyToOne
    private Movie mId;
    @JoinColumn(name = "TID", referencedColumnName = "TID")
    @ManyToOne
    private Theater tid;

    public Purchase() {
    }

    public Purchase(Integer pid) {
        this.pid = pid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPemail() {
        return pemail;
    }

    public void setPemail(String pemail) {
        this.pemail = pemail;
    }

    public Integer getPnumTickets() {
        return pnumTickets;
    }

    public void setPnumTickets(Integer pnumTickets) {
        this.pnumTickets = pnumTickets;
    }

    public String getPphone() {
        return pphone;
    }

    public void setPphone(String pphone) {
        this.pphone = pphone;
    }

    public Date getPdatecur() {
        return pdatecur;
    }

    public void setPdatecur(Date pdatecur) {
        this.pdatecur = pdatecur;
    }

    public Date getPmoviedate() {
        return pmoviedate;
    }

    public void setPmoviedate(Date pmoviedate) {
        this.pmoviedate = pmoviedate;
    }

    public Movie getMId() {
        return mId;
    }

    public void setMId(Movie mId) {
        this.mId = mId;
    }

    public Theater getTid() {
        return tid;
    }

    public void setTid(Theater tid) {
        this.tid = tid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pid != null ? pid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Purchase)) {
            return false;
        }
        Purchase other = (Purchase) object;
        if ((this.pid == null && other.pid != null) || (this.pid != null && !this.pid.equals(other.pid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "GEntities.Purchase[ pid=" + pid + " ]";
    }
    
}

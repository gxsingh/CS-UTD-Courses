/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GEntities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Garry_12
 */
@Embeddable
public class TimesPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "TID")
    private int tid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "M_ID")
    private int mId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "TTIME")
    private String ttime;

    public TimesPK() {
    }

    public TimesPK(int tid, int mId, String ttime) {
        this.tid = tid;
        this.mId = mId;
        this.ttime = ttime;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public int getMId() {
        return mId;
    }

    public void setMId(int mId) {
        this.mId = mId;
    }

    public String getTtime() {
        return ttime;
    }

    public void setTtime(String ttime) {
        this.ttime = ttime;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) tid;
        hash += (int) mId;
        hash += (ttime != null ? ttime.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TimesPK)) {
            return false;
        }
        TimesPK other = (TimesPK) object;
        if (this.tid != other.tid) {
            return false;
        }
        if (this.mId != other.mId) {
            return false;
        }
        if ((this.ttime == null && other.ttime != null) || (this.ttime != null && !this.ttime.equals(other.ttime))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "GEntities.TimesPK[ tid=" + tid + ", mId=" + mId + ", ttime=" + ttime + " ]";
    }
    
}

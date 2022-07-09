
package com.thimblemill.src.models;

import java.io.Serializable;

public class Npark implements Serializable {

    private static final long serialVersionUID = 1L;
  
    private Integer gid;
    private String feature;
    private Object geometry;

    public Npark() {
    }

    public Npark(Integer gid) {
        this.gid = gid;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public Object getGeometry() {
        return geometry;
    }

    public void setGeometry(Object geometry) {
        this.geometry = geometry;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gid != null ? gid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Npark)) {
            return false;
        }
        Npark other = (Npark) object;
        if ((this.gid == null && other.gid != null) || (this.gid != null && !this.gid.equals(other.gid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mvRoute.Npark[ gid=" + gid + " ]";
    }
    
}

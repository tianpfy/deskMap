
package com.thimblemill.src.models;

import java.io.Serializable;

public class Road implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer gid;
    private String name;
    private String feattype;
    private Object geometry;

    public Road() {
    }

    public Road(Integer gid) {
        this.gid = gid;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFeattype() {
        return feattype;
    }

    public void setFeattype(String feattype) {
        this.feattype = feattype;
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
        if (!(object instanceof Road)) {
            return false;
        }
        Road other = (Road) object;
        if ((this.gid == null && other.gid != null) || (this.gid != null && !this.gid.equals(other.gid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mvRoute.Road[ gid=" + gid + " ]";
    }
    
}

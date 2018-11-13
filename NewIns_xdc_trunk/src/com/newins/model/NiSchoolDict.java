package com.newins.model;

import java.util.Date;

public class NiSchoolDict {
    private Integer schoolid;

    private String schoolname;

    private String province;

    private String belongto;

    private String degreelevel;

    private String schoolclass;

    private String schooltype;

    private Integer postgraduate;

    private String wanxschoolcode;

    private String wanxschoolname;

    private String regioncode;

    private String regionname;

    private Date addtime;

    private String comment;

    public Integer getSchoolid() {
        return schoolid;
    }

    public void setSchoolid(Integer schoolid) {
        this.schoolid = schoolid;
    }

    public String getSchoolname() {
        return schoolname;
    }

    public void setSchoolname(String schoolname) {
        this.schoolname = schoolname == null ? null : schoolname.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getBelongto() {
        return belongto;
    }

    public void setBelongto(String belongto) {
        this.belongto = belongto == null ? null : belongto.trim();
    }

    public String getDegreelevel() {
        return degreelevel;
    }

    public void setDegreelevel(String degreelevel) {
        this.degreelevel = degreelevel == null ? null : degreelevel.trim();
    }

    public String getSchoolclass() {
        return schoolclass;
    }

    public void setSchoolclass(String schoolclass) {
        this.schoolclass = schoolclass == null ? null : schoolclass.trim();
    }

    public String getSchooltype() {
        return schooltype;
    }

    public void setSchooltype(String schooltype) {
        this.schooltype = schooltype == null ? null : schooltype.trim();
    }

    public Integer getPostgraduate() {
        return postgraduate;
    }

    public void setPostgraduate(Integer postgraduate) {
        this.postgraduate = postgraduate;
    }

    public String getWanxschoolcode() {
        return wanxschoolcode;
    }

    public void setWanxschoolcode(String wanxschoolcode) {
        this.wanxschoolcode = wanxschoolcode == null ? null : wanxschoolcode.trim();
    }

    public String getWanxschoolname() {
        return wanxschoolname;
    }

    public void setWanxschoolname(String wanxschoolname) {
        this.wanxschoolname = wanxschoolname == null ? null : wanxschoolname.trim();
    }

    public String getRegioncode() {
        return regioncode;
    }

    public void setRegioncode(String regioncode) {
        this.regioncode = regioncode == null ? null : regioncode.trim();
    }

    public String getRegionname() {
        return regionname;
    }

    public void setRegionname(String regionname) {
        this.regionname = regionname == null ? null : regionname.trim();
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }
}
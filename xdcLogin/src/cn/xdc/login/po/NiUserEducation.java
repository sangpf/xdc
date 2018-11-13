package cn.xdc.login.po;

import java.util.Date;

public class NiUserEducation {
    private Integer userid;

    private Integer degree;

    private Integer registerstatus;

    private Integer schoolid;

    private String schoolname;

    private Integer regionid;

    private String regionname;

    private String college;

    private String department;

    private String major;

    private String classname;

    private String usersn;

    private Integer role;

    private Boolean bindcard;

    private Integer bindstudent;

    private Integer wanxscore;

    private String wanxaccount;

    private Date enroldate;

    private Date graduatedate;

    private Integer leavestatus;

    private String comment;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getDegree() {
        return degree;
    }

    public void setDegree(Integer degree) {
        this.degree = degree;
    }

    public Integer getRegisterstatus() {
        return registerstatus;
    }

    public void setRegisterstatus(Integer registerstatus) {
        this.registerstatus = registerstatus;
    }

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

    public Integer getRegionid() {
        return regionid;
    }

    public void setRegionid(Integer regionid) {
        this.regionid = regionid;
    }

    public String getRegionname() {
        return regionname;
    }

    public void setRegionname(String regionname) {
        this.regionname = regionname == null ? null : regionname.trim();
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college == null ? null : college.trim();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname == null ? null : classname.trim();
    }

    public String getUsersn() {
        return usersn;
    }

    public void setUsersn(String usersn) {
        this.usersn = usersn == null ? null : usersn.trim();
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Boolean getBindcard() {
		return bindcard;
	}

	public void setBindcard(Boolean bindcard) {
		this.bindcard = bindcard;
	}

	public Integer getBindstudent() {
        return bindstudent;
    }

    public void setBindstudent(Integer bindstudent) {
        this.bindstudent = bindstudent;
    }

    public Integer getWanxscore() {
        return wanxscore;
    }

    public void setWanxscore(Integer wanxscore) {
        this.wanxscore = wanxscore;
    }

    public String getWanxaccount() {
        return wanxaccount;
    }

    public void setWanxaccount(String wanxaccount) {
        this.wanxaccount = wanxaccount == null ? null : wanxaccount.trim();
    }

    public Date getEnroldate() {
        return enroldate;
    }

    public void setEnroldate(Date enroldate) {
        this.enroldate = enroldate;
    }

    public Date getGraduatedate() {
        return graduatedate;
    }

    public void setGraduatedate(Date graduatedate) {
        this.graduatedate = graduatedate;
    }

    public Integer getLeavestatus() {
        return leavestatus;
    }

    public void setLeavestatus(Integer leavestatus) {
        this.leavestatus = leavestatus;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }
}
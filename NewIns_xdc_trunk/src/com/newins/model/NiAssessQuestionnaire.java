package com.newins.model;

import java.util.Date;

public class NiAssessQuestionnaire {
    private Integer aqnid;

    private String aqnname;

    private Integer publisherid;

    private String publishername;

    private String epilogue;

    private String perface;

    private Integer aqnclassid;

    private Date ctime;

    private Date stime;

    private Integer staus;

    private Integer recommandqty;

    private Integer questionnum;

    private String filepath;

    private Integer validation;

    private Integer tag1id;

    private Integer tag2id;

    private Integer tag3id;

    private Integer tag4id;

    private Integer tag5id;

    private String picpath;

    private String aqnsummary;

    private String editor;

    private String comment;

    public Integer getAqnid() {
        return aqnid;
    }

    public void setAqnid(Integer aqnid) {
        this.aqnid = aqnid;
    }

    public String getAqnname() {
        return aqnname;
    }

    public void setAqnname(String aqnname) {
        this.aqnname = aqnname == null ? null : aqnname.trim();
    }

    public Integer getPublisherid() {
        return publisherid;
    }

    public void setPublisherid(Integer publisherid) {
        this.publisherid = publisherid;
    }

    public String getPublishername() {
        return publishername;
    }

    public void setPublishername(String publishername) {
        this.publishername = publishername == null ? null : publishername.trim();
    }

    public String getEpilogue() {
        return epilogue;
    }

    public void setEpilogue(String epilogue) {
        this.epilogue = epilogue == null ? null : epilogue.trim();
    }

    public String getPerface() {
        return perface;
    }

    public void setPerface(String perface) {
        this.perface = perface == null ? null : perface.trim();
    }

    public Integer getAqnclassid() {
        return aqnclassid;
    }

    public void setAqnclassid(Integer aqnclassid) {
        this.aqnclassid = aqnclassid;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Date getStime() {
        return stime;
    }

    public void setStime(Date stime) {
        this.stime = stime;
    }

    public Integer getStaus() {
        return staus;
    }

    public void setStaus(Integer staus) {
        this.staus = staus;
    }

    public Integer getRecommandqty() {
        return recommandqty;
    }

    public void setRecommandqty(Integer recommandqty) {
        this.recommandqty = recommandqty;
    }

    public Integer getQuestionnum() {
        return questionnum;
    }

    public void setQuestionnum(Integer questionnum) {
        this.questionnum = questionnum;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath == null ? null : filepath.trim();
    }

    public Integer getValidation() {
        return validation;
    }

    public void setValidation(Integer validation) {
        this.validation = validation;
    }

    public Integer getTag1id() {
        return tag1id;
    }

    public void setTag1id(Integer tag1id) {
        this.tag1id = tag1id;
    }

    public Integer getTag2id() {
        return tag2id;
    }

    public void setTag2id(Integer tag2id) {
        this.tag2id = tag2id;
    }

    public Integer getTag3id() {
        return tag3id;
    }

    public void setTag3id(Integer tag3id) {
        this.tag3id = tag3id;
    }

    public Integer getTag4id() {
        return tag4id;
    }

    public void setTag4id(Integer tag4id) {
        this.tag4id = tag4id;
    }

    public Integer getTag5id() {
        return tag5id;
    }

    public void setTag5id(Integer tag5id) {
        this.tag5id = tag5id;
    }

    public String getPicpath() {
        return picpath;
    }

    public void setPicpath(String picpath) {
        this.picpath = picpath == null ? null : picpath.trim();
    }

    public String getAqnsummary() {
        return aqnsummary;
    }

    public void setAqnsummary(String aqnsummary) {
        this.aqnsummary = aqnsummary == null ? null : aqnsummary.trim();
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor == null ? null : editor.trim();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }
}
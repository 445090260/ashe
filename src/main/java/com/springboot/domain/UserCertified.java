package com.springboot.domain;

import java.util.Date;

public class UserCertified {
    private Integer id;

    private Integer userId;

    private String certType;

    private Integer certNo;

    private String certExp;

    private Date creatDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCertType() {
        return certType;
    }

    public void setCertType(String certType) {
        this.certType = certType == null ? null : certType.trim();
    }

    public Integer getCertNo() {
        return certNo;
    }

    public void setCertNo(Integer certNo) {
        this.certNo = certNo;
    }

    public String getCertExp() {
        return certExp;
    }

    public void setCertExp(String certExp) {
        this.certExp = certExp == null ? null : certExp.trim();
    }

    public Date getCreatDate() {
        return creatDate;
    }

    public void setCreatDate(Date creatDate) {
        this.creatDate = creatDate;
    }
}
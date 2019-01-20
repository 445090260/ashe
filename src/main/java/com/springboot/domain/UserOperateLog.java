package com.springboot.domain;

import java.util.Date;

public class UserOperateLog {
    private Integer id;

    private Integer userId;

    private String operateDesc;

    private String operateIp;

    private Date operateTime;

    private String resultStatus;

    private String operateParams;

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

    public String getOperateDesc() {
        return operateDesc;
    }

    public void setOperateDesc(String operateDesc) {
        this.operateDesc = operateDesc == null ? null : operateDesc.trim();
    }

    public String getOperateIp() {
        return operateIp;
    }

    public void setOperateIp(String operateIp) {
        this.operateIp = operateIp == null ? null : operateIp.trim();
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    public String getResultStatus() {
        return resultStatus;
    }

    public void setResultStatus(String resultStatus) {
        this.resultStatus = resultStatus == null ? null : resultStatus.trim();
    }

    public String getOperateParams() {
        return operateParams;
    }

    public void setOperateParams(String operateParams) {
        this.operateParams = operateParams == null ? null : operateParams.trim();
    }
}
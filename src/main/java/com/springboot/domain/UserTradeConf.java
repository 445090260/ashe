package com.springboot.domain;

public class UserTradeConf {
    private Integer userId;

    private String tradePassword;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTradePassword() {
        return tradePassword;
    }

    public void setTradePassword(String tradePassword) {
        this.tradePassword = tradePassword == null ? null : tradePassword.trim();
    }
}
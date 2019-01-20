package com.springboot.domain;

public class UserSystemConf {
    private Integer userId;

    private String payset;

    private String theme;

    private String lang;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPayset() {
        return payset;
    }

    public void setPayset(String payset) {
        this.payset = payset == null ? null : payset.trim();
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme == null ? null : theme.trim();
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang == null ? null : lang.trim();
    }
}
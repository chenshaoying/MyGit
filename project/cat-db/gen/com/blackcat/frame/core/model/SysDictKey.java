package com.blackcat.frame.core.model;

import java.io.Serializable;

public class SysDictKey implements Serializable {
    private String dictcd;

    private String fildcd;

    private String fildvl;

    private static final long serialVersionUID = 1L;

    public String getDictcd() {
        return dictcd;
    }

    public void setDictcd(String dictcd) {
        this.dictcd = dictcd == null ? null : dictcd.trim();
    }

    public String getFildcd() {
        return fildcd;
    }

    public void setFildcd(String fildcd) {
        this.fildcd = fildcd == null ? null : fildcd.trim();
    }

    public String getFildvl() {
        return fildvl;
    }

    public void setFildvl(String fildvl) {
        this.fildvl = fildvl == null ? null : fildvl.trim();
    }
}
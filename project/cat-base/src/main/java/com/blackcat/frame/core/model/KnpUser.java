package com.blackcat.frame.core.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class KnpUser implements Serializable {
    private String userid;

    private BigDecimal bankorgId;

    private String userna;

    private String userpw;

    private String userbr;

    private String usedst;

    private String userst;

    private String userlv;

    private String lspwdt;

    private Integer pwrtcn;

    private String lslgdt;

    private String telephone;

    private String mobileno;

    private String email;

    private static final long serialVersionUID = 1L;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public BigDecimal getBankorgId() {
        return bankorgId;
    }

    public void setBankorgId(BigDecimal bankorgId) {
        this.bankorgId = bankorgId;
    }

    public String getUserna() {
        return userna;
    }

    public void setUserna(String userna) {
        this.userna = userna == null ? null : userna.trim();
    }

    public String getUserpw() {
        return userpw;
    }

    public void setUserpw(String userpw) {
        this.userpw = userpw == null ? null : userpw.trim();
    }

    public String getUserbr() {
        return userbr;
    }

    public void setUserbr(String userbr) {
        this.userbr = userbr == null ? null : userbr.trim();
    }

    public String getUsedst() {
        return usedst;
    }

    public void setUsedst(String usedst) {
        this.usedst = usedst == null ? null : usedst.trim();
    }

    public String getUserst() {
        return userst;
    }

    public void setUserst(String userst) {
        this.userst = userst == null ? null : userst.trim();
    }

    public String getUserlv() {
        return userlv;
    }

    public void setUserlv(String userlv) {
        this.userlv = userlv == null ? null : userlv.trim();
    }

    public String getLspwdt() {
        return lspwdt;
    }

    public void setLspwdt(String lspwdt) {
        this.lspwdt = lspwdt == null ? null : lspwdt.trim();
    }

    public Integer getPwrtcn() {
        return pwrtcn;
    }

    public void setPwrtcn(Integer pwrtcn) {
        this.pwrtcn = pwrtcn;
    }

    public String getLslgdt() {
        return lslgdt;
    }

    public void setLslgdt(String lslgdt) {
        this.lslgdt = lslgdt == null ? null : lslgdt.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno == null ? null : mobileno.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }
}
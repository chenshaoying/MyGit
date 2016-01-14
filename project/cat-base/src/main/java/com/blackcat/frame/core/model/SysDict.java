package com.blackcat.frame.core.model;

import java.io.Serializable;

public class SysDict extends SysDictKey implements Serializable {
    private String desctx;

    private Integer seq;

    private static final long serialVersionUID = 1L;

    public String getDesctx() {
        return desctx;
    }

    public void setDesctx(String desctx) {
        this.desctx = desctx == null ? null : desctx.trim();
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }
}
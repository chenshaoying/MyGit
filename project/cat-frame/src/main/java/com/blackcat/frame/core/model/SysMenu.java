package com.blackcat.frame.core.model;

import java.io.Serializable;

public class SysMenu implements Serializable {
    private String menucd;

    private String name;

    private String icon;

    private Integer level;

    private String pid;

    private String action;

    private String desctx;

    private static final long serialVersionUID = 1L;

    public String getMenucd() {
        return menucd;
    }

    public void setMenucd(String menucd) {
        this.menucd = menucd == null ? null : menucd.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action == null ? null : action.trim();
    }

    public String getDesctx() {
        return desctx;
    }

    public void setDesctx(String desctx) {
        this.desctx = desctx == null ? null : desctx.trim();
    }
}
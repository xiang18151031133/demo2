package com.swx.model;

import java.io.Serializable;

public class Department implements Serializable{
    private int d_id;
    private String d_name;//部门名称
    private int d_cid;//公司
    private String d_createTime;//创建时间

    public Department() {
    }

    public Department(int d_id, String d_name, int d_cid, String d_createTime) {
        this.d_id = d_id;
        this.d_name = d_name;
        this.d_cid = d_cid;
        this.d_createTime = d_createTime;
    }

    public int getD_id() {
        return d_id;
    }

    public void setD_id(int d_id) {
        this.d_id = d_id;
    }

    public String getD_name() {
        return d_name;
    }

    public void setD_name(String d_name) {
        this.d_name = d_name;
    }

    public int getD_cid() {
        return d_cid;
    }

    public void setD_cid(int d_cid) {
        this.d_cid = d_cid;
    }

    public String getD_createTime() {
        return d_createTime;
    }

    public void setD_createTime(String d_createTime) {
        this.d_createTime = d_createTime;
    }

    @Override
    public String toString() {
        return "Department{" +
                "d_id=" + d_id +
                ", d_name='" + d_name + '\'' +
                ", d_cid=" + d_cid +
                ", d_createTime='" + d_createTime + '\'' +
                '}';
    }
}

package com.swx.model;

import java.io.Serializable;

public class Job implements Serializable {
    private int j_id;
    private int j_did;//对应的部门
    private String j_name;//职位名称
    private String j_createTime;//创建时间

    public Job() {
    }

    public Job(int j_id, int j_did, String j_name, String j_createTime) {
        this.j_id = j_id;
        this.j_did = j_did;
        this.j_name = j_name;
        this.j_createTime = j_createTime;
    }

    public int getJ_id() {
        return j_id;
    }

    public void setJ_id(int j_id) {
        this.j_id = j_id;
    }

    public int getJ_did() {
        return j_did;
    }

    public void setJ_did(int j_did) {
        this.j_did = j_did;
    }

    public String getJ_name() {
        return j_name;
    }

    public void setJ_name(String j_name) {
        this.j_name = j_name;
    }

    public String getJ_createTime() {
        return j_createTime;
    }

    public void setJ_createTime(String j_createTime) {
        this.j_createTime = j_createTime;
    }

    @Override
    public String toString() {
        return "Job{" +
                "j_id=" + j_id +
                ", j_did=" + j_did +
                ", j_name='" + j_name + '\'' +
                ", j_createTime='" + j_createTime + '\'' +
                '}';
    }
}

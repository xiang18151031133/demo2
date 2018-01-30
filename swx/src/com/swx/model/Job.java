package com.swx.model;

import java.io.Serializable;

public class Job implements Serializable {
    private int j_id;
    private int j_did;
    private String j_name;

    public Job() {
    }

    public Job(int j_id, int j_did, String j_name) {
        this.j_id = j_id;
        this.j_did = j_did;
        this.j_name = j_name;
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

    @Override
    public String toString() {
        return "Job{" +
                "j_id=" + j_id +
                ", j_did=" + j_did +
                ", j_name='" + j_name + '\'' +
                '}';
    }
}

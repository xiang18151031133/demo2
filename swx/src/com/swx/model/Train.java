package com.swx.model;

import java.io.Serializable;

public class Train implements Serializable {
    private int t_id;//
    private int t_eid;//培训的员工
    private String t_time;//培训时间
    private String t_address;//培训地址
    private String t_train;//培训内容

    public Train() {
    }

    public Train(int t_id, int t_eid, String t_time, String t_address, String t_train) {
        this.t_id = t_id;
        this.t_eid = t_eid;
        this.t_time = t_time;
        this.t_address = t_address;
        this.t_train = t_train;
    }

    public int getT_id() {
        return t_id;
    }

    public void setT_id(int t_id) {
        this.t_id = t_id;
    }

    public int getT_eid() {
        return t_eid;
    }

    public void setT_eid(int t_eid) {
        this.t_eid = t_eid;
    }

    public String getT_time() {
        return t_time;
    }

    public void setT_time(String t_time) {
        this.t_time = t_time;
    }

    public String getT_address() {
        return t_address;
    }

    public void setT_address(String t_address) {
        this.t_address = t_address;
    }

    public String getT_train() {
        return t_train;
    }

    public void setT_train(String t_train) {
        this.t_train = t_train;
    }

    @Override
    public String toString() {
        return "Train{" +
                "t_id=" + t_id +
                ", t_eid=" + t_eid +
                ", t_time='" + t_time + '\'' +
                ", t_address='" + t_address + '\'' +
                ", t_train='" + t_train + '\'' +
                '}';
    }
}

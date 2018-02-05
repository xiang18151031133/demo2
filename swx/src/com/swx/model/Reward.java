package com.swx.model;

import java.io.Serializable;

public class Reward implements Serializable {
    private int re_id;
    private int re_eid;//对应的员工
    private double re_money;//奖惩金额
    private String re_time;//奖惩时间
    private String re_reason;//奖惩理由
    private int re_status;//1（奖励） 2（惩罚）

    public Reward() {
    }

    public Reward(int re_id, int re_eid, double re_money, String re_time, String re_reason, int re_status) {
        this.re_id = re_id;
        this.re_eid = re_eid;
        this.re_money = re_money;
        this.re_time = re_time;
        this.re_reason = re_reason;
        this.re_status = re_status;
    }

    public int getRe_id() {
        return re_id;
    }

    public void setRe_id(int re_id) {
        this.re_id = re_id;
    }

    public int getRe_eid() {
        return re_eid;
    }

    public void setRe_eid(int re_eid) {
        this.re_eid = re_eid;
    }

    public double getRe_money() {
        return re_money;
    }

    public void setRe_money(double re_money) {
        this.re_money = re_money;
    }

    public String getRe_time() {
        return re_time;
    }

    public void setRe_time(String re_time) {
        this.re_time = re_time;
    }

    public String getRe_reason() {
        return re_reason;
    }

    public void setRe_reason(String re_reason) {
        this.re_reason = re_reason;
    }

    public int getRe_status() {
        return re_status;
    }

    public void setRe_status(int re_status) {
        this.re_status = re_status;
    }

    @Override
    public String toString() {
        return "Reward{" +
                "re_id=" + re_id +
                ", re_eid=" + re_eid +
                ", re_money=" + re_money +
                ", re_time='" + re_time + '\'' +
                ", re_reason='" + re_reason + '\'' +
                ", re_status=" + re_status +
                '}';
    }
}

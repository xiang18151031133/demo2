package com.swx.model;

import java.io.Serializable;

public class Interview implements Serializable {
    private int i_id;//
    private int i_cid;//对应company表
    private int i_uid;//对应user表
    private String i_interviewtime;//面试时间
    private String i_interviewaddress;//面试地点
    private int i_rmid;//对应的recruitment表
    private int i_ustatus;//求职者确认状态（0没有 1放弃 2确认）
    private int i_result;//面试结果

    public Interview() {
    }

    public Interview(int i_id, int i_cid, int i_uid, String i_interviewtime, String i_interviewaddress, int i_rmid, int i_ustatus, int i_result) {
        this.i_id = i_id;
        this.i_cid = i_cid;
        this.i_uid = i_uid;
        this.i_interviewtime = i_interviewtime;
        this.i_interviewaddress = i_interviewaddress;
        this.i_rmid = i_rmid;
        this.i_ustatus = i_ustatus;
        this.i_result = i_result;
    }

    public int getI_id() {
        return i_id;
    }

    public void setI_id(int i_id) {
        this.i_id = i_id;
    }

    public int getI_cid() {
        return i_cid;
    }

    public void setI_cid(int i_cid) {
        this.i_cid = i_cid;
    }

    public int getI_uid() {
        return i_uid;
    }

    public void setI_uid(int i_uid) {
        this.i_uid = i_uid;
    }

    public String getI_interviewtime() {
        return i_interviewtime;
    }

    public void setI_interviewtime(String i_interviewtime) {
        this.i_interviewtime = i_interviewtime;
    }

    public String getI_interviewaddress() {
        return i_interviewaddress;
    }

    public void setI_interviewaddress(String i_interviewaddress) {
        this.i_interviewaddress = i_interviewaddress;
    }

    public int getI_rmid() {
        return i_rmid;
    }

    public void setI_rmid(int i_rmid) {
        this.i_rmid = i_rmid;
    }

    public int getI_ustatus() {
        return i_ustatus;
    }

    public void setI_ustatus(int i_ustatus) {
        this.i_ustatus = i_ustatus;
    }

    public int getI_result() {
        return i_result;
    }

    public void setI_result(int i_result) {
        this.i_result = i_result;
    }

    @Override
    public String toString() {
        return "Interview{" +
                "i_id=" + i_id +
                ", i_cid=" + i_cid +
                ", i_uid=" + i_uid +
                ", i_interviewtime='" + i_interviewtime + '\'' +
                ", i_interviewaddress='" + i_interviewaddress + '\'' +
                ", i_rmid=" + i_rmid +
                ", i_ustatus=" + i_ustatus +
                ", i_result=" + i_result +
                '}';
    }
}

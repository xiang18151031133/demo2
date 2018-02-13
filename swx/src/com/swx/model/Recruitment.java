package com.swx.model;

import java.io.Serializable;

//招聘表
public class Recruitment implements Serializable{
    private int rm_id;//
    private int rm_cid;//对应的公司
    private String rm_jobdesc;//招聘描述
    private String rm_jdesc;//招聘部门
    private String rm_jname;//对应的职位
    private int rm_peopleneeded;//需求的人数
    private String rm_requirement;//职位需求
    private double rm_money;//职位工资
    private String rm_workplace;//工作地点
    private int rm_uid;//对应的应聘者

    public Recruitment() {
    }

    public Recruitment(int rm_id, int rm_cid, String rm_jobdesc, String rm_jdesc, String rm_jname, int rm_peopleneeded, String rm_requirement, double rm_money, String rm_workplace, int rm_uid) {
        this.rm_id = rm_id;
        this.rm_cid = rm_cid;
        this.rm_jobdesc = rm_jobdesc;
        this.rm_jdesc = rm_jdesc;
        this.rm_jname = rm_jname;
        this.rm_peopleneeded = rm_peopleneeded;
        this.rm_requirement = rm_requirement;
        this.rm_money = rm_money;
        this.rm_workplace = rm_workplace;
        this.rm_uid = rm_uid;
    }

    public int getRm_id() {
        return rm_id;
    }

    public void setRm_id(int rm_id) {
        this.rm_id = rm_id;
    }

    public int getRm_cid() {
        return rm_cid;
    }

    public void setRm_cid(int rm_cid) {
        this.rm_cid = rm_cid;
    }

    public String getRm_jobdesc() {
        return rm_jobdesc;
    }

    public void setRm_jobdesc(String rm_jobdesc) {
        this.rm_jobdesc = rm_jobdesc;
    }

    public String getRm_jdesc() {
        return rm_jdesc;
    }

    public void setRm_jdesc(String rm_jdesc) {
        this.rm_jdesc = rm_jdesc;
    }

    public String getRm_jname() {
        return rm_jname;
    }

    public void setRm_jname(String rm_jname) {
        this.rm_jname = rm_jname;
    }

    public int getRm_peopleneeded() {
        return rm_peopleneeded;
    }

    public void setRm_peopleneeded(int rm_peopleneeded) {
        this.rm_peopleneeded = rm_peopleneeded;
    }

    public String getRm_requirement() {
        return rm_requirement;
    }

    public void setRm_requirement(String rm_requirement) {
        this.rm_requirement = rm_requirement;
    }

    public double getRm_money() {
        return rm_money;
    }

    public void setRm_money(double rm_money) {
        this.rm_money = rm_money;
    }

    public String getRm_workplace() {
        return rm_workplace;
    }

    public void setRm_workplace(String rm_workplace) {
        this.rm_workplace = rm_workplace;
    }

    public int getRm_uid() {
        return rm_uid;
    }

    public void setRm_uid(int rm_uid) {
        this.rm_uid = rm_uid;
    }

    @Override
    public String toString() {
        return "Recruitment{" +
                "rm_id=" + rm_id +
                ", rm_cid=" + rm_cid +
                ", rm_jobdesc='" + rm_jobdesc + '\'' +
                ", rm_jdesc='" + rm_jdesc + '\'' +
                ", rm_jname='" + rm_jname + '\'' +
                ", rm_peopleneeded=" + rm_peopleneeded +
                ", rm_requirement='" + rm_requirement + '\'' +
                ", rm_money=" + rm_money +
                ", rm_workplace='" + rm_workplace + '\'' +
                ", rm_uid=" + rm_uid +
                '}';
    }
}

package com.swx.model;

import java.io.Serializable;

public class Salary implements Serializable {
    private int s_id;
    private int s_eid;//员工id
    private double s_bonus;//奖金
    private String s_date;//薪资对应时间
    private int s_status;//员工确认结果（0没有 1申诉 2确认）
    private double s_punish;//罚款
    private double s_salary;//薪资
    private double s_finalSalary;//最终薪资

    public Salary() {
    }

    public Salary(int s_id, int s_eid, double s_bonus, String s_date, int s_status, double s_punish, double s_salary, double s_finalSalary) {
        this.s_id = s_id;
        this.s_eid = s_eid;
        this.s_bonus = s_bonus;
        this.s_date = s_date;
        this.s_status = s_status;
        this.s_punish = s_punish;
        this.s_salary = s_salary;
        this.s_finalSalary = s_finalSalary;
    }

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public int getS_eid() {
        return s_eid;
    }

    public void setS_eid(int s_eid) {
        this.s_eid = s_eid;
    }

    public double getS_bonus() {
        return s_bonus;
    }

    public void setS_bonus(double s_bonus) {
        this.s_bonus = s_bonus;
    }

    public String getS_date() {
        return s_date;
    }

    public void setS_date(String s_date) {
        this.s_date = s_date;
    }

    public int getS_status() {
        return s_status;
    }

    public void setS_status(int s_status) {
        this.s_status = s_status;
    }

    public double getS_punish() {
        return s_punish;
    }

    public void setS_punish(double s_punish) {
        this.s_punish = s_punish;
    }

    public double getS_salary() {
        return s_salary;
    }

    public void setS_salary(double s_salary) {
        this.s_salary = s_salary;
    }

    public double getS_finalSalary() {
        return s_finalSalary;
    }

    public void setS_finalSalary(double s_finalSalary) {
        this.s_finalSalary = s_finalSalary;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "s_id=" + s_id +
                ", s_eid=" + s_eid +
                ", s_bonus=" + s_bonus +
                ", s_date='" + s_date + '\'' +
                ", s_status=" + s_status +
                ", s_punish=" + s_punish +
                ", s_salary=" + s_salary +
                ", s_finalSalary=" + s_finalSalary +
                '}';
    }
}

package com.swx.model;

import java.io.Serializable;

public class Employee implements Serializable {
    private int e_id;
    private String e_name;//用户名
    private String e_password;//密码
    private String e_realname;//真实姓名
    private int e_age;//年龄
    private String e_ethnicity;//名族
    private String e_phone;//电话
    private String e_address;//住址
    private String e_hiretime;//入职日期
    private int e_cid;//公司id
    private String e_jdesc;//部门名称
    private String e_jname;//职位
    private String e_basicwage;//基本工资
    private String e_workstarttime;//上班时间
    private String e_workendtime;//下班时间
    private int e_workstatus;//状态（0离职时只可查看 1试用 2在职）

    public Employee() {
    }

    public Employee(int e_id, String e_name, String e_password, String e_realname, int e_age, String e_ethnicity, String e_phone, String e_address, String e_hiretime, int e_cid, String e_jdesc, String e_jname, String e_basicwage, String e_workstarttime, String e_workendtime, int e_workstatus) {
        this.e_id = e_id;
        this.e_name = e_name;
        this.e_password = e_password;
        this.e_realname = e_realname;
        this.e_age = e_age;
        this.e_ethnicity = e_ethnicity;
        this.e_phone = e_phone;
        this.e_address = e_address;
        this.e_hiretime = e_hiretime;
        this.e_cid = e_cid;
        this.e_jdesc = e_jdesc;
        this.e_jname = e_jname;
        this.e_basicwage = e_basicwage;
        this.e_workstarttime = e_workstarttime;
        this.e_workendtime = e_workendtime;
        this.e_workstatus = e_workstatus;
    }

    public int getE_id() {
        return e_id;
    }

    public void setE_id(int e_id) {
        this.e_id = e_id;
    }

    public String getE_name() {
        return e_name;
    }

    public void setE_name(String e_name) {
        this.e_name = e_name;
    }

    public String getE_password() {
        return e_password;
    }

    public void setE_password(String e_password) {
        this.e_password = e_password;
    }

    public int getE_age() {
        return e_age;
    }

    public void setE_age(int e_age) {
        this.e_age = e_age;
    }

    public String getE_realname() {
        return e_realname;
    }

    public void setE_realname(String e_realname) {
        this.e_realname = e_realname;
    }

    public String getE_ethnicity() {
        return e_ethnicity;
    }

    public void setE_ethnicity(String e_ethnicity) {
        this.e_ethnicity = e_ethnicity;
    }

    public String getE_phone() {
        return e_phone;
    }

    public void setE_phone(String e_phone) {
        this.e_phone = e_phone;
    }

    public String getE_address() {
        return e_address;
    }

    public void setE_address(String e_address) {
        this.e_address = e_address;
    }

    public String getE_hiretime() {
        return e_hiretime;
    }

    public void setE_hiretime(String e_hiretime) {
        this.e_hiretime = e_hiretime;
    }

    public int getE_cid() {
        return e_cid;
    }

    public void setE_cid(int e_cid) {
        this.e_cid = e_cid;
    }

    public String getE_jdesc() {
        return e_jdesc;
    }

    public void setE_jdesc(String e_jdesc) {
        this.e_jdesc = e_jdesc;
    }

    public String getE_jname() {
        return e_jname;
    }

    public void setE_jname(String e_jname) {
        this.e_jname = e_jname;
    }

    public String getE_basicwage() {
        return e_basicwage;
    }

    public void setE_basicwage(String e_basicwage) {
        this.e_basicwage = e_basicwage;
    }

    public String getE_workstarttime() {
        return e_workstarttime;
    }

    public void setE_workstarttime(String e_workstarttime) {
        this.e_workstarttime = e_workstarttime;
    }

    public String getE_workendtime() {
        return e_workendtime;
    }

    public void setE_workendtime(String e_workendtime) {
        this.e_workendtime = e_workendtime;
    }

    public int getE_workstatus() {
        return e_workstatus;
    }

    public void setE_workstatus(int e_workstatus) {
        this.e_workstatus = e_workstatus;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "e_id=" + e_id +
                ", e_name='" + e_name + '\'' +
                ", e_password='" + e_password + '\'' +
                ", e_realname='" + e_realname + '\'' +
                ", e_age=" + e_age +
                ", e_ethnicity='" + e_ethnicity + '\'' +
                ", e_phone='" + e_phone + '\'' +
                ", e_address='" + e_address + '\'' +
                ", e_hiretime='" + e_hiretime + '\'' +
                ", e_cid=" + e_cid +
                ", e_jdesc='" + e_jdesc + '\'' +
                ", e_jname='" + e_jname + '\'' +
                ", e_basicwage='" + e_basicwage + '\'' +
                ", e_workstarttime='" + e_workstarttime + '\'' +
                ", e_workendtime='" + e_workendtime + '\'' +
                ", e_workstatus=" + e_workstatus +
                '}';
    }
}

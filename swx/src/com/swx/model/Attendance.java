package com.swx.model;

import java.io.Serializable;

public class Attendance implements Serializable {
    private int at_id;
    private int at_eid;//员工
    private String at_workTime;//上班时间
    private String at_closeTime;//下班时间
    private int at_checkResult;//考勤结果（0、正常 1、有问题 ）

    public Attendance() {
    }

    public Attendance(int at_id, int at_eid, String at_workTime, String at_closeTime, int at_checkResult) {
        this.at_id = at_id;
        this.at_eid = at_eid;
        this.at_workTime = at_workTime;
        this.at_closeTime = at_closeTime;
        this.at_checkResult = at_checkResult;
    }

    public int getAt_id() {
        return at_id;
    }

    public void setAt_id(int at_id) {
        this.at_id = at_id;
    }

    public int getAt_eid() {
        return at_eid;
    }

    public void setAt_eid(int at_eid) {
        this.at_eid = at_eid;
    }

    public String getAt_workTime() {
        return at_workTime;
    }

    public void setAt_workTime(String at_workTime) {
        this.at_workTime = at_workTime;
    }

    public String getAt_closeTime() {
        return at_closeTime;
    }

    public void setAt_closeTime(String at_closeTime) {
        this.at_closeTime = at_closeTime;
    }

    public int getAt_checkResult() {
        return at_checkResult;
    }

    public void setAt_checkResult(int at_checkResult) {
        this.at_checkResult = at_checkResult;
    }

    @Override
    public String toString() {
        return "Attendance{" +
                "at_id=" + at_id +
                ", at_eid=" + at_eid +
                ", at_workTime='" + at_workTime + '\'' +
                ", at_closeTime='" + at_closeTime + '\'' +
                ", at_checkResult=" + at_checkResult +
                '}';
    }
}

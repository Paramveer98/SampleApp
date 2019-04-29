package com.example.mypractice.sqlitedb;

import com.example.mypractice.ButtonClass;

public class StudentDetails {


    int reg_id;
    String name, stud_class;



    public StudentDetails(int reg_id, String name, String stud_class) {
        this.reg_id = reg_id;
        this.name = name;
        this.stud_class = stud_class;
    }

    public StudentDetails() {

    }


    public int getReg_id() {
        return reg_id;
    }

    public void setReg_id(int reg_id) {
        this.reg_id = reg_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStud_class() {
        return stud_class;
    }

    public void setStud_class(String stud_class) {
        this.stud_class = stud_class;
    }
}

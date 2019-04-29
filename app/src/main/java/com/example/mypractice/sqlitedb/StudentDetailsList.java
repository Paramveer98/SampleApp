package com.example.mypractice.sqlitedb;

import com.example.mypractice.ButtonClass;

public class StudentDetailsList {


    String stud_name;
    String stud_roll;


    public StudentDetailsList(String stud_name, String stud_roll) {

        this.stud_name = stud_name;
        this.stud_roll = stud_roll;
    }

    public StudentDetailsList() {

    }


    public String getName() {
        return stud_name;
    }

    public void setName(String name) {
        this.stud_name = stud_name;
    }


    public String getStud_roll() {
        return stud_roll;
    }

    public void setStud_roll(String stud_roll) {
        this.stud_roll = stud_roll;
    }
}

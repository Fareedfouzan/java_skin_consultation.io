package com.mycompany.person;

public class Date {

    //Instance Variables
    private int day;
    private int month;
    private int year;

    //Constructors

    public Date(){
        day = 12;
        month = 5;
        year = 2004;
    }
    public Date(int day, int month, int year){
        if((year > 1939) && (year < 2099) && (month > 0) && (month < 13) && (day > 0) && (day < 32)){
            this.day = day;
            this.month = month;
            this.year = year;
        }

        else{
            System.out.println("Not in range");
        }
    }

    //Set/Get Methods

    public void setDay(int day){
        if((day > 0) && (day < 32)){
            this.day = day;
        }
        else{
            System.out.println("Not a correct day");
        }
    }

    public int getDay(){
        return day;
    }

    public void setMonth(int month){
        if((month > 0) && (month < 13)){
            this.month = month;
        }
        else{
            System.out.println("Not a correct month");
        }
    }

    public int getMonth(){
        return month;
    }

    public void setYear(int year){
        if((year > 1939) && (year < 2099)){
            this.year = year;
        }
        else{
            System.out.println("Not a correct year");
        }
    }

    public int getYear(){
        return year;
    }

    public void setDate(int day, int month, int year) {
        if ((year > 1939) && (year < 2099) && (month > 0) && (month < 13) && (day > 0) && (day < 32)) {
            this.day = day;
            this.month = month;
            this.year = year;
        } else {
            System.out.println("Not in range");
        }
    }

    public String getDate(){
        String date = String.format("%02d/%02d/%04d", day,month,year);
        return date;
    }

    //toString() Method

    public String toString(){
        return day + "-" + month + "-" + year;
    }
}

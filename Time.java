package com.mycompany.person;

public class Time {

    //Instance Variables
    private int hour;
    private int minute;
    private int second;

    //Constructors

    public Time(){
      hour = 0;
      minute = 0;
      second = 0;
    }
    public Time(int hour, int minute, int second){
        if((hour > 0) && (hour < 13) && (minute > 0) && (minute < 60) && (second > 0) && (second < 60)){
           this.hour = hour;
           this.minute = minute;
           this.second = second;
        }

        else{
            System.out.println("Not in range");
        }
    }

    public void setHour(int hour){
        if((hour > 0) && (hour < 13)){
            this.hour = hour;
        }
        else{
            System.out.println("Not a correct hour");
        }
    }

    public int getHour(){
        return hour;
    }

    public void setMinute(int minute){
        if((minute > 0) && (minute < 60)){
            this.minute = minute;
        }
        else{
            System.out.println("Not a correct minute");
        }
    }

    public int getMinute(){
        return minute;
    }

    public void setSecond(int second){
        if((second > 0) && (second < 60)){
           this.second = second;
        }
        else{
            System.out.println("Not a correct year");
        }
    }

    public int getSecond(){
        return second;
    }

    public void setTime(int hour, int minute, int second){
        if((hour > 0) && (hour < 13) && (minute > 0) && (minute < 60) && (second > 0) && (second < 60)){
            this.hour = hour;
            this.minute = minute;
            this.second = second;
        }
        else{
            System.out.println("Not in range");
        }
    }

    public String getTime(){
        String time = String.format("%02d/%02d/%02d", hour,minute,second);
        return time;
    }

    //toString() Method

    public String toString(){
        return hour + ":" + minute + ":" + second;
    }

}


package com.mycompany.person;


/**
 *
 * @author fareedkhan
 */
public class Consultation extends Person{

    //Instance Variables
    protected String date;
    protected String time;
    protected double cost;
    protected String notes;
    protected Patient patient;

    //Constructors

    public Consultation(){
        super();
        date = "12.05.1994";
        time = "10:00";
        cost = 125;
        notes = "Hospital open";
        patient.uniqueId = 145;
    }


    public Consultation(String name, String surname, String dob, long mobNo, String date, String time, double cost,String notes){
        super(name,surname,dob,mobNo);
        this.date = date;
        this.time = time;
        this.cost = cost;
        this.notes = notes;
    }

    public Consultation(String date,String time,double cost,String notes){
        this.date = date;
        this.time = time;
        this.cost = cost;
        this.notes = notes;
    }

    //Set/Get Methods
    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSurname() {
        return surname;
    }

    @Override
    public String getDob() {
        return dob;
    }

    @Override
    public long getMobNo() {
        return mobNo;
    }

    public void setDate(String date){
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setTime(String time){
       this.time = time;
    }

    public String getTime() {
        return time;
    }

    public void setCost(double cost){
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }

    public void setNotes(String notes){
        this.notes = notes;
    }

    public String getNotes() {
        return notes;
    }

    //toString() Method
    @Override
    public String toString() {
        return "Consultation{" +
                "date=" + date +
                ", time=" + time +
                ", cost=" + cost +
                ", notes='" + notes + '\'' +
                '}';
    }
}

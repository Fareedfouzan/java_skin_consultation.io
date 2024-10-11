
package com.mycompany.person;

/**
 *
 * @author fareedkhan
 */
public class Patient  extends Person{

    //Instance Variables
    protected int uniqueId;

    //Constructors
    public Patient() {
        super();
        uniqueId = 0;
    }

    public Patient(int uniqueId){
        this.uniqueId = uniqueId;
    }

    public Patient(String name, String surname, String dob, long mobNo, int uniqueId){
        super(name, surname, dob, mobNo);
        this.uniqueId = uniqueId;
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

    public void setUniqueId(int uniqueId){
        this.uniqueId = uniqueId;
    }
    
    public int getUniqueId(){
        return uniqueId;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "uniqueId=" + uniqueId +
                '}';
    }
}

package com.mycompany.person;

import java.util.ArrayList;

/**
 *
 * @author fareedkhan
 */
public class Doctor extends Person{

    //Instance Variables
    protected int medicLicenseNo;
    protected String specialisation;

    protected ArrayList<Consultation> consultationList;

    //Constructors
    public Doctor() {
        super();
       medicLicenseNo = 176;
       specialisation = "Cardiology";
    }


    public Doctor(String name, String surname, String dob, long mobNo){
        super(name, surname, dob, mobNo);
    }

    public Doctor(int medicLicenseNo, String specialisation){
        this.medicLicenseNo = medicLicenseNo;
        this.specialisation = specialisation;
    }
    public Doctor(String name, String surname, String dob, long mobNo, int medicLicenseNo, String specialisation){
        super(name, surname, dob, mobNo);
        this.medicLicenseNo = medicLicenseNo;
        this.specialisation = specialisation;
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

    public void setMedicLicenseNo(int medicLicenseNo){
        this.medicLicenseNo = medicLicenseNo;
    }
    
    public int getMedicLicenseNo(){
        return medicLicenseNo;
    }
    
    public void setSpecialisation(String spec){
        this.specialisation = spec;
    }
    
    public String getSpecialisation(){
        return specialisation;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "medicLicenseNo=" + medicLicenseNo +
                ", specialisation='" + specialisation + '\'' +
                '}';
    }
}

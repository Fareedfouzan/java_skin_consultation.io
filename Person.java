package com.mycompany.person;

/**
 *
 * @author fareedkhan
 */
public abstract class Person{

    //Instance Variables
    protected String name;
    protected String surname;
    protected String dob;
    protected long mobNo;

    //Constructors
    public Person(){
        name = "Fareed khan";
        surname = "Mohamed Rafi";
        dob = "16-09-2003";
        mobNo = 07405357535;
    }
    
    public Person(String name,String surname,String dob,long mobNo){
        this.name = name;
        this.surname = surname;
        this.dob = dob;
        this.mobNo = mobNo;
    }

    //Set/Get Methods
    public void setName(String name){
        this.name = name;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setMobNo(long mobNo) {
        this.mobNo = mobNo;
    }

    //Abstract Methods
    public abstract String getName();
    public abstract String getSurname();
    public abstract String getDob();
    public abstract long getMobNo();

    //toString() Method
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dob='" + dob + '\'' +
                ", mobNo=" + mobNo +
                '}';
    }
}

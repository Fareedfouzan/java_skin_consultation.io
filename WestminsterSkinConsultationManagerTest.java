
package com.mycompany.person;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author fareedkhan
 */
public class WestminsterSkinConsultationManagerTest {
    String name = "Fareed khan";
    String surname = "Mohamed Rafi";
    Date date = new Date(12,5,2005);
    String date2 = date.toString();
    long mobNo = 07405357535;
    int medLicenseNo = 112;
    String spec = "Cardiology";
    Doctor doc = new Doctor(name,surname,date2,mobNo,medLicenseNo,spec);
    ArrayList<Doctor> doctor = new ArrayList<>();
    File file = new File("DoctorDetails");
    public WestminsterSkinConsultationManagerTest() {
    }
    
    @BeforeEach
    public void setUp() {

    }
    
    @AfterEach
    public void tearDown(){

    }
     /**
     * Test of AddDoctor method, of class WestminsterSkinConsultationManager.
     */
    @Test
    public void testAddDoctor() {
        assertEquals(name,doc.getName());
        assertEquals(surname,doc.getSurname());
        assertEquals(2005,date.getYear());
        assertEquals(5,date.getMonth());
        assertEquals(12,date.getDay());
        assertEquals(mobNo,doc.getMobNo());
        assertEquals(medLicenseNo,doc.getMedicLicenseNo());
        assertEquals(spec,doc.getSpecialisation());
    }


    /**
     * Test of DeleteDoctor method, of class WestminsterSkinConsultationManager.
     */
    @Test
    public void testDeleteDoctor() {
        doctor.removeIf(doc -> doc.getMedicLicenseNo() == medLicenseNo);
              assertEquals(medLicenseNo,doc.getMedicLicenseNo());
       }

    /**
     * Test of SaveDoctor method, of class WestminsterSkinConsultationManager.
     */
    @Test
    public void testSaveDoctor() throws Exception {
        FileOutputStream os = new FileOutputStream(file);
       for(Doctor doc:doctor){
           assertEquals(name, doc.getName());
           assertEquals(surname, doc.getSurname());
           assertEquals(date2, doc.getDob());
           assertEquals(mobNo, doc.getMobNo());
           assertEquals(medLicenseNo, doc.getMedicLicenseNo());
           assertEquals(spec, doc.getSpecialisation());
       }
       os.close();
    }

    }

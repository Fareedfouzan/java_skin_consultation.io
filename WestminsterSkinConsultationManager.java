package com.mycompany.person;


import java.io.*;
import java.text.*;
import java.util.*;

/**
 *
 * @author fareedkhan
 */
public class WestminsterSkinConsultationManager implements SkinConsultationManager {

    //I took the code from the Java Week 05 Tutorials which is implemented in a similar manner

    //Instance Variables1
    private ArrayList<Doctor> docList;
    private int numDoctors;


    //Constructor
    public WestminsterSkinConsultationManager(int docLength) {
        numDoctors = docLength;
        docList = new ArrayList<>();
    }

    //Methods
    @Override
    public void AddDoctor(Doctor d) {    //This method is used to add a doctor in the list
        if (docList.size() < numDoctors) {
            docList.add(d);
        } else {
            System.out.println("Space Exceeded");
        }
    }

    @Override
    public void printDoctor() {    //This method is used to print the doctors in the list alphabetically according to doctor's surname
        Collections.sort(docList, new Comparator<Doctor>()
        {
            @Override
            public int compare(Doctor o1, Doctor o2) {
                return o1.getSurname().compareTo(o2.getSurname());
            }
        });
        for (int j = 0; j < docList.size(); j++) {
            System.out.println("Doctor " + (j + 1));
            System.out.println("Name: " + docList.get(j).getName());
            System.out.println("Surname: " + docList.get(j).getSurname());
            System.out.println("Date of birth: " + docList.get(j).getDob());
            System.out.println("Mobile No: " + docList.get(j).getMobNo());
            System.out.println("Medical License No: " + docList.get(j).getMedicLicenseNo());
            System.out.println("Specialisation: " + docList.get(j).getSpecialisation());
        }

    }
    @Override
    public void DeleteDoctor(int medicLicenseNo) {   //This method is used to delete a doctor selecting the medical license number
        try {
            for (Doctor doctor : docList) {
                if (doctor.getMedicLicenseNo() == medicLicenseNo) {
                    docList.remove(doctor);
                    System.out.println("The customer " + doctor.getName() + " is deleted");
                    System.out.println("Total number of doctors:" + docList.size());
                } else {
                    System.out.println("Medical license number is not in the list");
                }
            }
            showDoctorList();
        }
        catch (Exception e){
            System.out.println("Doctors list is empty");
        }
    }

    public void showDoctorList() {
        for(Doctor doctor : docList){
            System.out.println("Name: " + doctor.getName() + "\n" + "Surname: " + doctor.getSurname() + "\n" + "Date of Birth: " + doctor.getDob() + "\n" + "Mobile No: " + doctor.getMobNo() + "\n" + "Medical License No: " + doctor.getMedicLicenseNo() + "\n" + "Specialisation: " + doctor.getSpecialisation());
        }
    }

    @Override
    public void SaveDoctor(Doctor dl) throws IOException {   //This method is used to save the doctors in a text file
        try {
            //Open
            FileWriter fw = new FileWriter("DoctorDetails",true);
            BufferedWriter bw = new BufferedWriter(fw);
            //Write
            for(Doctor doc: docList){
                bw.write("Name: " + doc.getName() + "\n");
                bw.write("Surname: " + doc.getSurname() + "\n");
                bw.write("Date of Birth: " + doc.getDob() + "\n");
                bw.write("Mobile no: " + doc.getMobNo() + "\n");
                bw.write("Medical license no: " + doc.getMedicLicenseNo() + "\n");
                bw.write("Specialisation: " + doc.getSpecialisation() + "\n");
            }
            bw.flush();
            System.out.println("Done!" + "");
            //Close
            bw.close();
            fw.close();
        }
        catch (IOException e) {
           e.printStackTrace();
        }
    }
    @Override
    public void LoadDoctor() {  //This method is used to load the saved doctors from the text file
        try {
            //Open
            FileReader fr = new FileReader("DoctorDetails");
            BufferedReader br = new BufferedReader(fr);

            //Read
            String data = "";
            while ((data = br.readLine()) != null) {
                System.out.println(data);
            }

            //Close
            br.close();
            fr.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void openGUI() {  //This method is used to open GUI and do something inside
        Display frame = new Display(docList);
        frame.setTitle("Doctor Admin");
        frame.setVisible(true);
        frame.setSize(800,500);
    }

    @Override
    public boolean RunMenu() throws IOException {    //This method is the console menu which runs on user perspective
        boolean exit = true;
        while (exit) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Welcome to the Skin Consultation");
            System.out.println("Please enter the following options:");
            System.out.println("1.Add a doctor");
            System.out.println("2.Delete a doctor");
            System.out.println("3.Print the list of doctors");
            System.out.println("4.Save all doctors in a file");
            System.out.println("5.Load all saved doctors");
            System.out.println("6.Open GUI");
            System.out.print("Please enter your response: ");
            int option = sc.nextInt();
            switch (option) {
                case 1 :
                    System.out.println("Press 1 if you want to add the details");
                    System.out.println("Press 2 to exit");
                    System.out.print("Enter your response: ");
                    int option2 = sc.nextInt();
                    sc.nextLine();
                    switch (option2) {
                        case 1:
                            for (int i = 0; i < numDoctors; i++) {
                                try {
                                    System.out.println("Doctor " + (i + 1));
                                    System.out.print("Enter your name: ");
                                    String name = sc.next();
                                    System.out.print("Enter your surname: ");
                                    String surname = sc.next();
                                    System.out.print("Enter the day (1-31) that you were born: ");
                                    int day = sc.nextInt();
                                    System.out.print("Enter the month (1-12): ");
                                    int month = sc.nextInt();
                                    System.out.print("Enter the year (1940-2098): ");
                                    int year = sc.nextInt();
                                   if ((day < 1 || day > 31) || (month < 1 || month > 12) || (year < 1940 || year > 2098)) {
                                        continue;
                                    }
                                    Date date2 = new Date(day, month, year);
                                    String date = date2.toString();
                                    System.out.print("Enter your mobile no: ");
                                    long mobNo = sc.nextLong();
                                    System.out.print("Enter your medical license no: ");
                                    int license = sc.nextInt();
                                    System.out.print("Enter your specialisation: ");
                                    String spec = sc.next();
                                    System.out.println("Would you like to add another doctor?");
                                    System.out.println("1.Yes\n2.No");
                                    System.out.print("Enter your response: ");
                                    int options = sc.nextInt();
                                    if (options == 1) {
                                        Doctor doc = new Doctor(name, surname, date, mobNo, license, spec);
                                        this.AddDoctor(doc);
                                        continue;
                                    } else if (options == 2) {
                                        Doctor doc = new Doctor(name, surname, date, mobNo, license, spec);
                                        this.AddDoctor(doc);
                                        break;
                                    }
                                }
                                catch (Exception e) {
                                    System.out.println("Exceeded the max number of doctors");
                                }
                            }
                            break;
                        case 2:
                            break;
                    }
                    break;
                        case 2:
                            System.out.print("Please enter the medical license number for the customer that you want to delete: ");
                            int medicLicenseNo = sc.nextInt();
                            DeleteDoctor(medicLicenseNo);
                            break;
                        case 3:
                            this.printDoctor();
                            break;
                        case 4:
                            Doctor dl = new Doctor();
                            this.SaveDoctor(dl);
                            break;
                        case 5:
                            this.LoadDoctor();
                            break;
                        case 6 :
                            this.openGUI();
                            break;
                        default:
                            System.out.println("Incorrect option");
                            break;
                    }
                    System.out.println("Would you like to continue?\n 1.Yes\n 2.No");
                    System.out.print("Enter your response: ");
                    if (sc.nextInt() == 1) {
                        exit = true;
                    }
                    else {
                        exit = false;
                        System.out.println("Thank you for booking an appointment with us!");
                        System.exit(0);
                    }
                }
               return exit;
            }

    //Main method
      public static void main(String[] args) throws ParseException, IOException {   //This is the main method in which it runs the menu
          SkinConsultationManager scm = new WestminsterSkinConsultationManager(10);
          boolean exit = false;

          while (!exit) {
              exit = scm.RunMenu();
          }
      }
 }
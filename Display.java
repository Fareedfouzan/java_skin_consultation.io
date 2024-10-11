package com.mycompany.person;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class Display extends JFrame {
    JTable myTable;
    PersonTableModel tableModel;
    ArrayList<Doctor> list;
    public Display(ArrayList<Doctor> list){
        this.list = list;
        tableModel = new PersonTableModel(list);
        myTable = new JTable(tableModel);

        setBounds(100,100,589,381);
        myTable.setAutoCreateRowSorter(true);

        JScrollPane scrollPane = new JScrollPane(myTable);
        scrollPane.setPreferredSize(new Dimension(1735,200));
        JPanel panel = new JPanel();
        panel.setBackground(Color.YELLOW);
        JLabel lbl = new JLabel("List of Doctors");
        panel.setVisible(false);
        panel.add(lbl);
        panel.add(scrollPane);
        add(panel,BorderLayout.SOUTH);

        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.RED);
        panel1.setLayout(new GridLayout(14,2,0,1));
        JLabel label = new JLabel("Patient Details: ");
        label.setFont(new Font("Arial",Font.BOLD,20));
        JLabel label2 = new JLabel("Name");
        JTextField text1 = new JTextField();
        text1.setFont(new Font("Arial", Font.BOLD, 15));
        JLabel label3 = new JLabel("Surname");
        JTextField text2 = new JTextField();
        text2.setFont(new Font("Arial",Font.BOLD,15));
        JLabel label4 = new JLabel("Date of birth");
        JTextField text3 = new JTextField();
        JLabel label5 = new JLabel("Mobile number");
        JTextField text6 = new JTextField();
        text6.setFont(new Font("Arial",Font.BOLD,15));
        JLabel label6 = new JLabel("Patient ID");
        JTextField text7 = new JTextField();
        text7.setFont(new Font("Arial",Font.BOLD,15));
        JButton button0 = new JButton("Clear patient details");
        button0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text1.setText(null);
                text2.setText(null);
                text3.setText(null);
                text6.setText(null);
                text7.setText(null);
            }
        });
        JButton button = new JButton("Register Patient Details");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Patient> patients = new ArrayList<>();
                patients.add(new Patient(text1.getText(), text2.getText(), text3.getText(), Long.parseLong(text6.getText()),Integer.parseInt(text7.getText())));
                try {
                    FileWriter fw = new FileWriter("Patient");
                    BufferedWriter bw = new BufferedWriter(fw);
                    for (Patient pat : patients) {
                        bw.write("Name: " + pat.getName() + "\n");
                        bw.write("Surname: " + pat.getSurname() + "\n");
                        bw.write("Date of birth: " + pat.getDob() + "\n");
                        bw.write("Mobile Number: " + pat.getMobNo() + "\n");
                        bw.write("Patient ID: " + pat.getUniqueId() + "\n");
                    }
                    bw.flush();
                    bw.close();
                    fw.close();
                }
                catch (IOException e2){
                    JOptionPane.showMessageDialog(null,e2);
                }
                JOptionPane.showMessageDialog(null,"Name - " + text1.getText() + "\n" + "Surname - " + text2.getText() + "\n" + "Date of Birth - " + text3.getText() + "\n" + "Mobile number - " + text6.getText() + "\n" + "Patient ID - " + text7.getText());
            }
        });
        panel1.add(label);
        panel1.add(label2);
        panel1.add(text1);
        panel1.add(label3);
        panel1.add(text2);
        panel1.add(label4);
        panel1.add(text3);
        panel1.add(label5);
        panel1.add(text6);
        panel1.add(label6);
        panel1.add(text7);
        panel1.add(button0);
        add(panel1,BorderLayout.WEST);

        JPanel panel2 = new JPanel();

        JButton button1 = new JButton("View Doctor's List");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(true);
            }
        });
        JButton button3 = new JButton("Save Doctor Consultation");

        panel2.setBackground(Color.BLACK);
        panel2.add(button);
        panel2.add(button1);
        panel2.add(button3);
        add(panel2,BorderLayout.NORTH);

        JPanel panel3 = new JPanel();
        panel3.setBackground(Color.RED);
        panel3.setLayout(new GridLayout(17,1,0,0));
        JLabel label7 = new JLabel("Consultation Details: ");
        label7.setFont(new Font("Arial",Font.BOLD,20));
        JLabel label8 = new JLabel("Date of Consultation");
        JTextField text8 = new JTextField();
        JLabel label9 = new JLabel("Times of Consultation(Hour:Minute)");
        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.addItem("None selected");
        comboBox.addItem("10:00");
        comboBox.addItem("10:30");
        comboBox.addItem("11:00");
        comboBox.addItem("11:30");
        comboBox.addItem("12:00");
        comboBox.addItem("12:30");
        comboBox.addItem("13:00");
        comboBox.setSelectedItem(null);
        comboBox.setBounds(90,85,245,31);
        JButton GetTime = new JButton("Get Time");
        JTextField text9 = new JTextField();
        GetTime.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value = (String)comboBox.getSelectedItem();
                text9.setText(value);
            }
        });
        JLabel label10 = new JLabel("Cost of Consultation");
        JTextField text11 = new JTextField();
        text11.setFont(new Font("Arial",Font.BOLD,15));
        JLabel label11 = new JLabel("Consultation Notes");
        JTextField text12 = new JTextField();
        text12.setFont(new Font("Arial",Font.BOLD,15));


      //
        JButton button2 = new JButton("Encrypt Text");
        String[] encryptedString = {""};
        final byte[][] encrypted = {new byte[0]};
        button2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    byte[] arrayBytes = "NiTH5252".getBytes();
                    SecretKeySpec key = new SecretKeySpec(arrayBytes,"DES");
                    Cipher cipher = Cipher.getInstance("DES");
                    cipher.init(Cipher.ENCRYPT_MODE, key);
                    encrypted[0] = cipher.doFinal(text12.getText().getBytes());
                    encryptedString[0] = new String(encrypted[0]);
                    JOptionPane.showMessageDialog(null,"The Encrypted String is " + encryptedString[0]);
                    text12.setText(encryptedString[0]);
                }
                catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException |
                       IllegalBlockSizeException | BadPaddingException ex) {
                    JOptionPane.showMessageDialog(null,ex);
                }
            }
        });

        JButton button8 = new JButton("Decrypt Text");
        button8.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String decrpytedString = "";
                try {
                    byte[] arrayBytes = "NiTH5252".getBytes();
                    SecretKeySpec key2 = new SecretKeySpec(arrayBytes,"DES");
                    Cipher cipher2 = Cipher.getInstance("DES");
                    cipher2.init(Cipher.DECRYPT_MODE, key2);
                    byte[] decrypted = cipher2.doFinal(encrypted[0]);
                    decrpytedString = new String(decrypted);
                    JOptionPane.showMessageDialog(null,"The Decrypted String is " + decrpytedString);
                    text12.setText(decrpytedString);
                }
                catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException |
                       IllegalBlockSizeException | BadPaddingException ex) {
                    JOptionPane.showMessageDialog(null,ex);
                }
            }
        });

        JButton button5 = new JButton("Upload Image");
        button5.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    JFileChooser chooser = new JFileChooser();
                    chooser.showOpenDialog(null);
                    File file = chooser.getSelectedFile();
                    text12.setText(file.getAbsolutePath());
                }
                catch (Exception e3){
                    JOptionPane.showMessageDialog(null, e3);
                }
            }
        });

        JButton button6 = new JButton("Encrypt Image");
        button6.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FileInputStream fis = new FileInputStream(text12.getText());
                    FileOutputStream fos = new FileOutputStream("Encrypt.jpg");
                    byte[] k = "NiTH5252".getBytes();
                    SecretKeySpec key = new SecretKeySpec(k,"DES");
                    Cipher cipher = Cipher.getInstance("DES");
                    cipher.init(Cipher.ENCRYPT_MODE, key);
                    CipherOutputStream cos = new CipherOutputStream(fos,cipher);
                    byte[] buf = new byte[1024];
                    int read;
                    while ((read = fis.read(buf)) != -1) {
                        cos.write(buf,0,read);
                    }
                    fis.close();
                    fos.flush();
                    cos.close();
                    JOptionPane.showMessageDialog(null,"The file encrypted successfully");
                }
                catch (Exception e1){
                    JOptionPane.showMessageDialog(null,e1);
                }
            }
        });

        //For Encrypt and Decrypt, I took the code from the video which is given below:
        // Encrypt: https://youtu.be/xIx_zI1tqAg
        // Decrypt: https://youtu.be/K4QB38ROsPM
        JButton button7 = new JButton("Decrypt Image");
        button7.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FileInputStream fis = new FileInputStream(text12.getText());
                    FileOutputStream fos = new FileOutputStream("Decrypt.jpg");
                    byte[] k = "NiTH5252".getBytes();
                    SecretKeySpec key = new SecretKeySpec(k,"DES");
                    Cipher cipher = Cipher.getInstance("DES");
                    cipher.init(Cipher.DECRYPT_MODE, key);
                    CipherOutputStream cos = new CipherOutputStream(fos,cipher);
                    byte[] buf = new byte[1024];
                    int read;
                    while ((read = fis.read(buf)) != -1) {
                        cos.write(buf,0,read);
                    }
                    fis.close();
                    fos.flush();
                    cos.close();
                    JOptionPane.showMessageDialog(null,"The image was decrypted successfully");
                }
                catch (Exception e1){
                    JOptionPane.showMessageDialog(null,e1);
                }
            }
        });
        JButton button4 = new JButton("View Consultation");
        button4.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FileReader fr = new FileReader("Consultation");
                    BufferedReader br = new BufferedReader(fr);
                    String data = "";
                    while ((data = br.readLine()) != null) {
                        JOptionPane.showMessageDialog(null, data);
                    }
                    br.close();
                    fr.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        button3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Consultation cons = new Consultation(text8.getText(),text9.getText(),Double.parseDouble(text11.getText()),text12.getText());
                ArrayList<Consultation> consultationArrayList = new ArrayList<>();
                consultationArrayList.add(cons);
                try {
                    FileWriter file = new FileWriter("Consultation");
                    BufferedWriter bw = new BufferedWriter(file);
                    for(Consultation consultation : consultationArrayList)
                        bw.write("Date of Consultation: " + consultation.getDate() + "\n" + "Times of Consultation: " + consultation.getTime() + "\n"+ "Cost of consultation: " + consultation.getCost() + "\n" + "Consultation Notes: " + consultation.getNotes());
                    bw.close();
                    file.close();
                }
                catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        panel3.add(label7);
        panel3.add(label8);
        panel3.add(text8);
        panel3.add(label9);
        panel3.add(comboBox);
        panel3.add(GetTime);
        panel3.add(text9);
        panel3.add(label10);
        panel3.add(text11);
        panel3.add(label11);
        panel3.add(text12);
        panel3.add(button2);
        panel3.add(button8);
        panel3.add(button5);
        panel3.add(button6);
        panel3.add(button7);
        panel3.add(button4);
        add(panel3,BorderLayout.EAST);
    }
}
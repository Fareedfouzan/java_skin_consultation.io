package com.mycompany.person;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class PersonTableModel extends AbstractTableModel {

    private String[] columnNames = {"Name","Surname","Date of Birth","Mobile No","Medical License no","Specialisation"};
    private ArrayList<Doctor> list;

    public PersonTableModel(ArrayList<Doctor> doctorArrayList) {
        list = doctorArrayList;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object temp = null;
        while (true) {
            if (columnIndex == 0) {
                temp = list.get(rowIndex).getName();
            } else if (columnIndex == 1) {
                temp = list.get(rowIndex).getSurname();
            } else if (columnIndex == 2) {
                temp = list.get(rowIndex).getDob();
            } else if (columnIndex == 3) {
                temp = list.get(rowIndex).getMobNo();
            } else if (columnIndex == 4) {
                temp = list.get(rowIndex).getMedicLicenseNo();
            } else if (columnIndex == 5) {
                temp = list.get(rowIndex).getSpecialisation();
            }
            return temp;
        }
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }
}

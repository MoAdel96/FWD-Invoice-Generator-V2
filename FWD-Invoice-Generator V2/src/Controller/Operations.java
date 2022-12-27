
package Controller;

import Model.InvoiceTable;
import Model.InvoiceItems;

import java.io.*;
import javax.swing.*;
import java.util.Scanner;
import java.util.ArrayList;


public class Operations {
    public static ArrayList<InvoiceTable> readFile(String Path){
        ArrayList<InvoiceTable> Invoice_Table_list = new ArrayList<InvoiceTable>();

        try {
            File myObj = new File(Path);
            Scanner MyInput = new Scanner(myObj);
            while (MyInput.hasNextLine()) {
                InvoiceTable invHdr = new InvoiceTable();
                String data = MyInput.nextLine();
                String[] dataLine = data.split(",");
                invHdr.setInvoice_Number1(Integer.parseInt(dataLine[0]));
                invHdr.setDate(dataLine[1]);
                invHdr.setCust_Nam(dataLine[2]);
                invHdr.setTotal_curr(0d);
                Invoice_Table_list.add(invHdr);
            }
            MyInput.close();
        } catch (FileNotFoundException e1) {
            System.out.println("Something went wrong");
            e1.printStackTrace();
        }
        return Invoice_Table_list;
    }
    public static ArrayList<InvoiceItems> InvoiceItm3readFile(String Path){
        ArrayList<InvoiceItems> Invoice_Itm_list = new ArrayList<InvoiceItems>();

        try {
            File myObj = new File(Path);
            Scanner MyInput = new Scanner(myObj);
            while (MyInput.hasNextLine()) {
                InvoiceItems InvoiceItm3 = new InvoiceItems();
                String data = MyInput.nextLine();
                String[] dataLine = data.split(",");
                InvoiceItm3.setInvoice_Numberber(Integer.parseInt(dataLine[0]));
                InvoiceItm3.setItm_Name1(dataLine[1]);
                InvoiceItm3.setItm_Price2(Double.parseDouble(dataLine[2]));
                InvoiceItm3.setInv_Quantity(Integer.parseInt(dataLine[3]));
                Invoice_Itm_list.add(InvoiceItm3);
            }
            MyInput.close();
        } catch (FileNotFoundException e1) {
            System.out.println("Something went wrong");
            e1.printStackTrace();
        }
        return Invoice_Itm_list;
    }
    public static void Write(ArrayList<InvoiceTable> Invoice_Table_list, File  fileToSave) {
        String fileContent = "";
        for (int i = 0; i < Invoice_Table_list.size(); i++) {
            fileContent += Invoice_Table_list.get(i).getInvoice_Number1() + "," + Invoice_Table_list.get(i).getDate() + ","
                    + Invoice_Table_list.get(i).getCust_Nam() + "," + Invoice_Table_list.get(i).getTotal_curr() + "\r\n";
        }
        try {
            String FileName = fileToSave.getPath();
            FileWriter File_writer = new FileWriter(FileName, false); //the true will append the new data
            File_writer.write(fileContent);
            File_writer.close();
        } catch (IOException e1) {
            e1.printStackTrace();

        }
    }
    public static void InvoiceItm3Write(ArrayList<InvoiceItems> Invoice_Itm_list, File fileToSave) {
        String fileContent = "";
        for (int j = 0; j < Invoice_Itm_list.size(); j++) {
            fileContent += ""
                    +Invoice_Itm_list.get(j).getInvoice_Numberber()+","
                    +Invoice_Itm_list.get(j).getItm_Name1() +","
                    +Invoice_Itm_list.get(j).getItm_Price2() +","
                    +Invoice_Itm_list.get(j).getInv_Quantity()+ ","
                    + Invoice_Itm_list.get(j).getFull_Price1()
                    +"\r\n";
        }

        try {
            String FileName = fileToSave.getPath();
            FileWriter File_writer = new FileWriter(FileName,false); //the true will append the new data
            File_writer.write(fileContent);//appends the string to the file
            File_writer.close();
            JOptionPane.showMessageDialog(null, "File saved successfully");
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

}













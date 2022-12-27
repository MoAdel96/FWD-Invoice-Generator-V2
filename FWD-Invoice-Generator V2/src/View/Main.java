package View;

import Controller.Controls;
import Controller.Operations;
import Model.InvoiceTable;
import Model.InvoiceItems;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

public class Main extends JFrame {
   
    
    
    private JButton Create_New_Inv;
    private JButton Delet_Inv;
    private JButton DeleteBtn;
    private JButton Create_New_Itm;

   

    private JTextField Invoice_Date;
    private JTextField Customer_Name;

    private JPanel Left_Side_Panel;
    private JPanel Right_Side_Panel;

    private JTable Inv_Table;
    private JTable Inv_Itm_Table;

    private JMenuBar Main_Menu;
    
    private JMenu Menu_File;

    private JLabel Invoice_Table;
    private JLabel Invoice_Number;
    private JLabel Count;
    private JLabel Inv_Date;
    private JLabel Cust_Nam;
    private JLabel Invoice_Total;
    private JLabel Invoice_curr;
    private JLabel InvoiceItm3s;
    
    private JMenuItem Load_File;
    private JMenuItem Save_File;
    
    

    public static void main(String[] args) {
        new View.Main().setVisible(true);
    }
    public Main() {
        super();
        setLayout(new BoxLayout(getContentPane(),BoxLayout.X_AXIS));

        Create_New_Inv = new JButton();
        Delet_Inv = new JButton();
        DeleteBtn = new JButton();
        Create_New_Itm = new JButton();

        Invoice_Table = new JLabel();
        Invoice_Number = new JLabel();
        Count = new JLabel();
        Inv_Date = new JLabel();
        Cust_Nam = new JLabel();
        Invoice_Total = new JLabel();
        Invoice_curr = new JLabel();
        InvoiceItm3s = new JLabel();


        Invoice_Date = new JTextField();
        Customer_Name = new JTextField();

        Inv_Table = new JTable();
        Inv_Itm_Table = new JTable();
        Main_Menu = new JMenuBar();
        Menu_File = new JMenu("File");
        Load_File = new JMenuItem("Load File");
        Save_File = new JMenuItem("Save File");


        Menu_File.add(Load_File);
        Menu_File.add(Save_File);
        Main_Menu.add(Menu_File);
        setJMenuBar(Main_Menu);
        Right_Side_Panel =new JPanel();
        Left_Side_Panel = new JPanel();



        Create_New_Inv.setText("Create New Invoice");
        Delet_Inv.setText("Delete Invoice");
        DeleteBtn.setText("Delete Item");
        Create_New_Itm.setText("Create New Item");

        Invoice_Table.setText("Invoices Table");
        Invoice_Number.setText("Invoice Number");
        Count.setText("0");
        Inv_Date.setText("Invoices Date");
        Cust_Nam.setText("Customer Name");
        Invoice_Total.setText("Invoices Total");
        Invoice_curr.setText("0 EGP");
        InvoiceItm3s.setText("Invoices Items");


        Inv_Table.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "No.", "Date", "Customer", "Total"
                }
        ));

        Inv_Itm_Table.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "No.", "Item Name", "Item Price", "Count","Item Total"
                }
        ));
        JScrollPane scroll1 =  new JScrollPane(Inv_Table);
        JScrollPane scroll2 =  new JScrollPane(Inv_Itm_Table);

        Dimension size = Inv_Table.getPreferredSize();
        Create_New_Inv.setBounds(30,600,200,30);
        Delet_Inv.setBounds(250,600,200,30);
        Invoice_Table.setBounds(30,0,200,30);
        scroll1.setBounds(30,65,600,500);
        Left_Side_Panel.setLayout(null);

        Invoice_Table.setSize(1000,100);
        Left_Side_Panel.add(Invoice_Table);
        Left_Side_Panel.add(scroll1);
        Left_Side_Panel.add(Create_New_Inv);
        Left_Side_Panel.add(Delet_Inv);

        Right_Side_Panel.setLayout(null);

        Create_New_Itm.setBounds(30,600,150,30);
        DeleteBtn.setBounds(190,600,150,30);

        Invoice_Number.setBounds(30,40,100,30);
        Count.setBounds(150,40,100,30);
        Inv_Date.setBounds(30,70,100,30);
        Invoice_Date.setBounds(150,70,100,30);
        Cust_Nam.setBounds(30,100,100,30);
        Customer_Name.setBounds(150,100,100,30);

        Invoice_Total.setBounds(30,130,100,30);
        Invoice_curr.setBounds(150,130,100,30);
        InvoiceItm3s.setBounds(30,170,100,30);
        scroll2.setBounds(30,200,600,370);


        Right_Side_Panel.add(Inv_Date);
        Right_Side_Panel.add(Invoice_Date);

        Right_Side_Panel.add(Invoice_Number);
        Right_Side_Panel.add(Count);
        Right_Side_Panel.add(Cust_Nam);
        Right_Side_Panel.add(Invoice_Total);
        Right_Side_Panel.add(Invoice_curr);
        Right_Side_Panel.add(InvoiceItm3s);
        Right_Side_Panel.add(Customer_Name);
        Right_Side_Panel.add(scroll2);
        Right_Side_Panel.add(DeleteBtn);
        Right_Side_Panel.add(Create_New_Itm);


        add(Left_Side_Panel);
        add(Right_Side_Panel);
        Inv_Table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        Inv_Itm_Table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        //Load Last inital status
        DefaultTableModel Inv_Tablemodel = (DefaultTableModel) Inv_Table.getModel();
        DefaultTableModel InvoiceItm3Model1 = (DefaultTableModel) Inv_Itm_Table.getModel();
        ArrayList<InvoiceTable> InVlist = new ArrayList<InvoiceTable>();
        ArrayList<InvoiceItems> Invoice_Itm_list = new ArrayList<InvoiceItems>();


        Inv_Table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                try {
                    InvoiceItm3Model1.setRowCount(0);
                    for (int i = 0; i < Invoice_Itm_list.size(); i++) {
                        if ((Invoice_Itm_list.get(i).getInvoice_Numberber() + "").equals(Inv_Table.getValueAt(Inv_Table.getSelectedRow(), 0).toString())) {

                            InvoiceItm3Model1.addRow(new Object[]{Invoice_Itm_list.get(i).getInvoice_Numberber(),
                                    Invoice_Itm_list.get(i).getItm_Name1(),
                                    Invoice_Itm_list.get(i).getItm_Price2(),
                                    Invoice_Itm_list.get(i).getInv_Quantity(),
                                    Invoice_Itm_list.get(i).getFull_Price1()});
                            Count.setText(Inv_Table.getValueAt(Inv_Table.getSelectedRow(), 0).toString());
                            Invoice_Date.setText(Inv_Table.getValueAt(Inv_Table.getSelectedRow(), 1).toString());
                            Customer_Name.setText(Inv_Table.getValueAt(Inv_Table.getSelectedRow(), 2).toString());
                            Invoice_curr.setText(Inv_Table.getValueAt(Inv_Table.getSelectedRow(), 3).toString());
                            Inv_Table.addNotify();
                        }
                    }
                }catch (Exception e){
                    //do nothing
                    e.printStackTrace();
                }
            }
        });

        setSize(800,800);
        setLocation(200,200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setTitle("Sales Invoice Generator");
        Create_New_Inv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JTextField field1 = new JTextField();
                JTextField field2 = new JTextField();
                JPanel panel = new JPanel(new GridLayout(0, 1));
                panel.add(new JLabel("Invoice Date:"));
                panel.add(field1);
                panel.add(new JLabel("Customer Name:"));
                panel.add(field2);
                int result = JOptionPane.showConfirmDialog(null, panel, "Create Invoice",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (result == JOptionPane.OK_OPTION) {
                    InvoiceTable InvHdr = new InvoiceTable();
                    if (Inv_Tablemodel.getRowCount() >0 ){
                        InvHdr.setInvoice_Number1(Integer.parseInt(Inv_Tablemodel.getValueAt((Inv_Tablemodel.getRowCount()-1),0).toString()) + 1);
                        Inv_Tablemodel.addRow(new Object[]{Integer.parseInt(Inv_Tablemodel.getValueAt((Inv_Tablemodel.getRowCount()-1),
                                0).toString()) + 1, field1.getText(), field2.getText(),0.0d});
                    }else {
                        InvHdr.setInvoice_Number1(1);
                    }
                    InvHdr.setDate(field1.getText());
                    InvHdr.setCust_Nam(field2.getText());
                    InvHdr.setTotal_curr(0.0d);
                    InVlist.add(InvHdr);
                } else {
                    System.out.println("Cancelled");
                }

            }
        });
        Delet_Inv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controls.Delet_Inv(Inv_Table,Invoice_Itm_list,Inv_Tablemodel);
            }
        });



        DeleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controls.DeleteBtn(Inv_Itm_Table,InvoiceItm3Model1,Invoice_Itm_list,Inv_Tablemodel);
            }
        });
        Create_New_Itm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Inv_Table.getSelectedRow() != -1) {
                    JTextField field1 = new JTextField();
                    JTextField field2 = new JTextField();
                    JTextField field3 = new JTextField();

                    JPanel panel = new JPanel(new GridLayout(0, 1));
                    panel.add(new JLabel("Item name:"));
                    panel.add(field1);
                    panel.add(new JLabel("Item Count:"));
                    panel.add(field2);
                    panel.add(new JLabel("Item Price:"));
                    panel.add(field3);
                    int result = JOptionPane.showConfirmDialog(null, panel, "Create Itm",
                            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                    if (result == JOptionPane.OK_OPTION) {

                        InvoiceItems Itm = new InvoiceItems();
                        Itm.setInvoice_Numberber(Integer.parseInt(Inv_Table.getValueAt((Inv_Table.getSelectedRow()), 0).toString()));
                        Itm.setItm_Name1(field1.getText());
                        Itm.setItm_Price2(Double.parseDouble(field3.getText()));
                        Itm.setInv_Quantity(Integer.parseInt(field2.getText()));
                        Invoice_Itm_list.add(Itm);
                        InvoiceItm3Model1.addRow(new Object[]{Itm.getInvoice_Numberber()
                                , Itm.getItm_Name1(),Itm.getItm_Price2(), Itm.getInv_Quantity(), Itm.getFull_Price1()});
                        for (int i = 0; i < Inv_Tablemodel.getRowCount(); i++) {
                            if (Integer.parseInt(Inv_Tablemodel.getValueAt(i,0).toString()) == Itm.getInvoice_Numberber()){
                                int sum = 0;
                                for (int j = 0; j < Invoice_Itm_list.size(); j++) {
                                    if (Itm.getInvoice_Numberber() == Invoice_Itm_list.get(j).getInvoice_Numberber()){
                                        sum += Invoice_Itm_list.get(j).getFull_Price1();
                                    }
                                }
                                Inv_Tablemodel.setValueAt(sum,i,3);
                            }
                        }
                    } else {
                        System.out.println("Cancelled");
                    }
                }else {
                    JOptionPane.showMessageDialog(null, " Select Invoice to add Item");
                }
            }
        });
        Load_File.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int k = 0; k < 2; k++) {


                    JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
                    int returnValue = jfc.showOpenDialog(null);
                    File selectedFile = null;
                    if (returnValue == JFileChooser.APPROVE_OPTION) {
                        selectedFile = jfc.getSelectedFile();
                    }

                    DefaultTableModel Inv_Tablemodel = (DefaultTableModel) Inv_Table.getModel();
                    DefaultTableModel Inv_Itm_Tablemodel = (DefaultTableModel) Inv_Itm_Table.getModel();

                    if (selectedFile.getName().contains("InvoiceHeader.csv")) {
                        Inv_Tablemodel.setRowCount(0);
                        ArrayList<InvoiceTable> InVlist1 = Operations.readFile(selectedFile.getAbsolutePath());
                        for (int i = 0; i < InVlist1.size(); i++) {
                            Inv_Tablemodel.addRow(new Object[]{InVlist1.get(i).getInvoice_Number1(),
                                    InVlist1.get(i).getDate(), InVlist1.get(i).getCust_Nam(), InVlist1.get(i).getTotal_curr()});
                        }
                        InVlist.addAll(InVlist1);
                    }
                    if (selectedFile.getName().contains("InvoiceLine.csv")) {
                        Inv_Itm_Tablemodel.setRowCount(0);
                        ArrayList<InvoiceItems> Invoice_Itm_list1 = Operations.InvoiceItm3readFile(selectedFile.getAbsolutePath());

                        Invoice_Itm_list.clear();
                        Invoice_Itm_list.addAll(Invoice_Itm_list1);
                        for (int j = 0; j < Inv_Tablemodel.getRowCount(); j++) {
                            Inv_Tablemodel.setValueAt(0d , j, 3);
                        }

                        for (int i = 0; i < Invoice_Itm_list1.size(); i++) {
                            for (int j = 0; j < Inv_Tablemodel.getRowCount(); j++) {
                                if ((Inv_Tablemodel.getValueAt(j, 0) + "").equals(Invoice_Itm_list1.get(i).getInvoice_Numberber() + "")) {
                                    Double TableValue = Double.parseDouble(Inv_Tablemodel.getValueAt(j, 3).toString());
                                    Double Itm_Price2 = Invoice_Itm_list1.get(i).getFull_Price1();
                                    Inv_Tablemodel.setValueAt(TableValue + Itm_Price2
                                            , j, 3);
                                }
                            }
                        }
                    }


                    for (int i = 0; i < InVlist.size(); i++) {
                        String out =  "Invoice" + InVlist.get(i).getInvoice_Number1()+"\n" +
                                "{\n" +
                                "\t" + InVlist.get(i).getDate()+","+InVlist.get(i).getCust_Nam()+"\n";
                        for (int j = 0; j < Invoice_Itm_list.size(); j++) {
                            if (InVlist.get(i).getInvoice_Number1() == Invoice_Itm_list.get(j).getInvoice_Numberber())
                                out += "\t" + Invoice_Itm_list.get(j).getItm_Name1()+"," + Invoice_Itm_list.get(j).getItm_Price2()
                                        + ","+ Invoice_Itm_list.get(j).getInv_Quantity()+ "\n";
                        }
                        out += "}";
                        System.out.println(out);
                    }

                }
            }
        });
        Save_File.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                JFrame parentFrame = new JFrame();

                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Select a file to save");
                fileChooser.setSelectedFile(new File("EditedInvoiceHeader.csv"));
                int userSelection = fileChooser.showSaveDialog(parentFrame);

                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    File fileToSave = fileChooser.getSelectedFile();

                    String fileContent = "";
                    ArrayList<InvoiceTable> EditInvList = new ArrayList<>();

                    for (int j = 0; j < Inv_Tablemodel.getRowCount(); j++) {

                        InvoiceTable inv = new InvoiceTable();
                        inv.setInvoice_Number1(Integer.parseInt(Inv_Tablemodel.getValueAt(j, 0).toString()));
                        inv.setDate(Inv_Tablemodel.getValueAt(j, 1).toString());
                        inv.setCust_Nam(Inv_Tablemodel.getValueAt(j, 2).toString());
                        inv.setTotal_curr(Double.parseDouble(Inv_Tablemodel.getValueAt(j, 3).toString()));
                        EditInvList.add(inv);
                    }
                   Operations.Write(EditInvList,fileToSave);
                }

                parentFrame = new JFrame();

                fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Select a file to save");
                fileChooser.setSelectedFile(new File("EditedInvoiceLine.csv"));
                userSelection = fileChooser.showSaveDialog(parentFrame);

                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    File fileToSave = fileChooser.getSelectedFile();

                    Operations.InvoiceItm3Write(Invoice_Itm_list, fileToSave);
                }
            }

        });

    }
}

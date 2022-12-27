package Controller;
import Model.InvoiceItems;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class Controls {

    public static void DeleteBtn(JTable Inv_Itm_Table, DefaultTableModel InvoiceItm3Model1, ArrayList<InvoiceItems> Invoice_Itm_list, DefaultTableModel Inv_Tablemodel){
        if(Inv_Itm_Table.getSelectedRow() != -1) {

            int Rows_selec = Inv_Itm_Table.getSelectedRow();
            String ItmName = InvoiceItm3Model1.getValueAt(Rows_selec,1).toString();
            int Invoice_Number = Integer.parseInt(InvoiceItm3Model1.getValueAt(Rows_selec,0).toString());

            for (int i = 0; i < Invoice_Itm_list.size(); i++) {
                if ((Invoice_Itm_list.get(i).getItm_Name1()).equals(ItmName)){
                    Invoice_Itm_list.remove(i);
                }
            }
            InvoiceItm3Model1.removeRow(Rows_selec);
            for (int i = 0; i < Inv_Tablemodel.getRowCount(); i++) {
                if (Integer.parseInt(Inv_Tablemodel.getValueAt(i,0).toString()) == Invoice_Number){
                    int sum = 0;
                    for (int j = 0; j < Invoice_Itm_list.size(); j++) {
                        if (Invoice_Number == Invoice_Itm_list.get(j).getInvoice_Numberber()){
                            sum += Invoice_Itm_list.get(j).getFull_Price1();
                        }
                    }
                    Inv_Tablemodel.setValueAt(sum,i,3);
                }
            }
            Inv_Itm_Table.addNotify();
            JOptionPane.showMessageDialog(null, "Selected row has been deleted successfully");
        }else {
            JOptionPane.showMessageDialog(null, " Select row to delete");
        }
    }
    public static void CancelBtn(DefaultTableModel Inv_Tablemodel, JTextField Customer_Name, JTextField Invoice_Date, JTable Inv_Table, JLabel Count){
        for (int j = 0; j < Inv_Tablemodel.getRowCount(); j++) {
            String canc_inv_num = Count.getText();
            if ((Inv_Tablemodel.getValueAt(j,0)+"").equals(canc_inv_num))
            {
                Invoice_Date.setText(Inv_Tablemodel.getValueAt(j,1).toString());
                Customer_Name.setText(Inv_Tablemodel.getValueAt(j,2).toString());

            }
        }
    }
    public static void savebtn(DefaultTableModel Inv_Tablemodel, JTextField Customer_Name
            , JTextField Invoice_Date, JTable Inv_Table, JLabel Count, ArrayList<InvoiceItems> Invoice_Itm_list, DefaultTableModel InvoiceItm3Model1){
        for (int j = 0; j < Inv_Tablemodel.getRowCount(); j++) {
            String canc_inv_num = Count.getText();
            if ((Inv_Tablemodel.getValueAt(j,0)+"").equals(canc_inv_num))
            {
                Inv_Tablemodel.setValueAt(Customer_Name.getText(),j,2);
                Inv_Tablemodel.setValueAt(Invoice_Date.getText(),j,1);
                Inv_Table.addNotify();
                JOptionPane.showMessageDialog(null, "Data has been Update Successfully");
            }
        }
        if (InvoiceItm3Model1.getRowCount() > 0){
            int InvoiceNumber = Integer.parseInt(InvoiceItm3Model1.getValueAt(0,0).toString());
            ArrayList<Integer> deletedX_inds = new ArrayList<Integer>();
            for (int i = 0; i < Invoice_Itm_list.size(); i++) {
                if (Invoice_Itm_list.get(i).getInvoice_Numberber() == InvoiceNumber){
                    deletedX_inds.add(i);
                }
            }

            for (int i = deletedX_inds.size()-1; i >= 0; i--) {
                int X_ind = deletedX_inds.get(i);
                Invoice_Itm_list.remove(X_ind);
            }

            for (int i = 0; i < InvoiceItm3Model1.getRowCount(); i++) {
                InvoiceItems Itm = new InvoiceItems();
                Itm.setInvoice_Numberber( Integer.parseInt(InvoiceItm3Model1.getValueAt(i,0).toString()));
                Itm.setItm_Name1(InvoiceItm3Model1.getValueAt(i,1).toString());
                Itm.setItm_Price2(Double.parseDouble(InvoiceItm3Model1.getValueAt(i,2).toString()));
                Itm.setInv_Quantity(Integer.parseInt(InvoiceItm3Model1.getValueAt(i,3).toString()));
                Invoice_Itm_list.add(Itm);
            }

            for (int i = 0; i < Inv_Tablemodel.getRowCount(); i++) {
                if (Integer.parseInt(Inv_Tablemodel.getValueAt(i,0).toString())
                        == Integer.parseInt(InvoiceItm3Model1.getValueAt(0,0).toString())){
                    int sum = 0;
                    for (int j = 0; j < Invoice_Itm_list.size(); j++) {
                        if (Invoice_Itm_list.get(j).getInvoice_Numberber() == Integer.parseInt(Inv_Tablemodel.getValueAt(i,0).toString()) ){
                            sum += Invoice_Itm_list.get(j).getFull_Price1();
                        }
                    }
                    Inv_Tablemodel.setValueAt(sum , i,3);
                }
            }
        }
    }
    public static void Delet_Inv(JTable Inv_Table, ArrayList<InvoiceItems> Invoice_Itm_list, DefaultTableModel Inv_Tablemodel){
        if(Inv_Table.getSelectedRow() != -1) {

            int Rows_selec = Inv_Table.getSelectedRow();

            for (int i = 0; i < Invoice_Itm_list.size(); i++) {
                String CustID = Inv_Tablemodel.getValueAt(Rows_selec,0).toString();
                if ((Invoice_Itm_list.get(i).getInvoice_Numberber()+"").equals(CustID)){
                    Invoice_Itm_list.remove(i);
                }
            }
            Inv_Tablemodel.removeRow(Rows_selec);

            Inv_Table.addNotify();
            JOptionPane.showMessageDialog(null, "Selected has been deleted successfully");
        }
    }
}







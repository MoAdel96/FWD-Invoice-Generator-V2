package Model;

public class InvoiceItems {

    private int Inv_Quantity;
    private Double Full_Price1;

    private int Invoice_Numberber;
    private String Itm_Name1;
    private double Itm_Price2;


    public Double getFull_Price1() {
        return Inv_Quantity * Itm_Price2;
    }

    public String getItm_Name1() {
        return Itm_Name1;
    }

    public void setInvoice_Numberber(int Invoice_Numberber) {
        this.Invoice_Numberber = Invoice_Numberber;
    }

    public void setItm_Name1(String Itm_Name1) {
        this.Itm_Name1 = Itm_Name1;
    }

    public int getInv_Quantity() {
        return Inv_Quantity;
    }

    public void setItm_Price2(double Itm_Price2) {
        this.Itm_Price2 = Itm_Price2;
    }

    public int getInvoice_Numberber() {
        return Invoice_Numberber;
    }

    public void setInv_Quantity(int Inv_Quantity) {
        this.Inv_Quantity = Inv_Quantity;
    }

    public Double getItm_Price2() {
        return Itm_Price2;
    }


}

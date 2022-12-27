package Model;

public class InvoiceTable {


    private String Date;
    private int Invoice_Number1;

    private Double Total_curr;

    private String Cust_Nam;


    public String getCust_Nam() {
        return Cust_Nam;
    }

    public void setCust_Nam(String Cust_Nam) {
        this.Cust_Nam = Cust_Nam;
    }

    public Double getTotal_curr() {
        return Total_curr;
    }

    public void setTotal_curr(Double total_curr) {
        this.Total_curr = total_curr;
    }

    public int getInvoice_Number1() {
        return Invoice_Number1;
    }

    public void setInvoice_Number1(int Invoice_Numberber) {
        this.Invoice_Number1 = Invoice_Numberber;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        this.Date = date;
    }

}

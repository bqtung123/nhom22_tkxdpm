package entity.invoice;



public class Invoice {


    public Invoice(int amount){
    	 this.amount = amount;
    }

    private int amount;

	public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void saveInvoice(){
        
    }
}

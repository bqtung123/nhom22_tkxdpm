package entity.invoice;



public class Invoice {

//    private Order order;
//    private int amount;
//    
    public Invoice(int amount){
    	 this.amount = amount;
    }
//
//    public Invoice(Order order){
//        this.order = order;
//    }
//
//    public Order getOrder() {
//        return order;
//    }

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

package rms;

public class OrderList {
	private int orderQty;
	private String orderDesc;
    private double orderPrice;
    private double orderTotal;
    
	public OrderList(String orderDesc, int orderQty, double orderPrice, double orderTotal) {
		this.orderDesc = orderDesc ;
		this.orderQty = orderQty;
		this.orderPrice = orderPrice;
		this.orderTotal = orderTotal;
	}
	public void displayOrders()
    {
		System.out.println( " Name: "  + orderDesc + " | " + "Price " + orderPrice + " | " + "Qty" + orderQty + " | " + "Order Total Price " + orderTotal + "\n" 
				+ "----------------------------------------");
		//System.out.println("asd");
		
    }
}

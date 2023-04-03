package rms;

import java.util.*;

public class Order 
{
	protected int orderId, orderQty;
	protected String orderDesc;
	protected double orderPrice;
	protected double orderTotal;
    
    ArrayList<OrderList> orderBill =  new ArrayList<OrderList>();
	public Double takeOrder(ArrayList<Menu> m)
	{
		Scanner sc = new Scanner(System.in);
		
		//ArrayList<Order> orderBill =  new ArrayList<Order>();
		 Iterator<Menu> menuIt = m.iterator(); //Detects and print out the menu.add items
	        while(menuIt.hasNext())
	        {
	            System.out.println(menuIt.next());
	        }
	        
	        //Ordering
	        System.out.println("Enter your order ID: ");
	        orderId = sc.nextInt();
	        sc.nextLine();
	        orderDesc = m.get(orderId - 1).itemName;
	        System.out.println("You have chosen " + orderDesc);
	        orderPrice = m.get(orderId- 1).itemCost;
	        System.out.println("The price of the item is RM" + orderPrice);
	        
	        //Quantity
	        System.out.println("How many do you want? ");
	        orderQty = sc.nextInt();
	        sc.nextLine();
	        orderTotal = orderPrice * orderQty;
	        System.out.println("Your total order for " + orderDesc + " is RM" + orderTotal);
	        orderBill.add(new OrderList (orderDesc, orderQty, orderPrice, orderTotal));
	        return orderTotal;
		
	}

	public void viewMenu(ArrayList<Menu> m)
	{
		Iterator<Menu> menuIt = m.iterator(); //Detects and print out the menu.add items
		System.out.println("		MENU");
        while(menuIt.hasNext()) 
        {
        	
            System.out.println(menuIt.next()); //viewMenu
        }
	}

	
	public int numOrder(int min, int max)
	{
		Random r = new Random();
		return r.nextInt(max - min + 1) + min;
	}
}

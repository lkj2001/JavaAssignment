package rms;

import java.util.*;
import java.util.Random;

public class Order 
{
	private int orderId, orderQty;
	private String orderDesc;
    private double orderPrice;
    private double orderTotal;
    
	public Double takeOrder(ArrayList<Menu> m)
	{
		Scanner sc = new Scanner(System.in);
		
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
	
	public void displayOrders()
    {
    	
    }
	
	public int numOrder(int min, int max)
	{
		Random r = new Random();
		return r.nextInt(max - min + 1) + min;
	}
}

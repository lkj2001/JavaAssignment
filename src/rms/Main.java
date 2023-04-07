package rms;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class Main 
{	
	static int foodId;
	static String foodName;
	static Double foodPrice;
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int num, num2, loginNum, editNum, numOrder;
		double totalOrder = 0.00;
      	SalesReport sr = new SalesReport();
		int min = 1, max = 10; //Uses for random table number
		
		boolean continueOrder = true;

		RMS u = new RMS();
		Order order = new Order();
		ArrayList<OrderList> orderBill =  new ArrayList<OrderList>();
		ArrayList<Menu> menus = new ArrayList<Menu>();
		
		menus.add(new Menu(1, "Nasi Lemak", 5.00)); //Need to use toString in order for the Main to detect the parameter
        menus.add(new Menu(2, "Mee Hoon", 4.00));
        menus.add(new Menu(3, "Roti Canai", 3.00));
        menus.add(new Menu(4, "Laksa", 5.00));

        
        int level = 0; // current menu level
        do 
        {
            switch (level) 
            {
                case 0:
                    System.out.println("Press 1 to View Menu\n" + "Press 2 to Login\n" + "Press 0 to exit program");                    
                    num = sc.nextInt();
                    sc.nextLine();
                    if (num == 0) 
                    {
                        System.out.println("Goodbye, have a nice day!!");
                        return; // exit the program
                    } 
                    else if (num == 1) 
                    {
                    	if(!menus.isEmpty())
                    	{
                    		order.viewMenu(menus);
                            System.out.println("Press 1 to Order \nPress 2 to Go back");
                            numOrder = sc.nextInt();
                            if (numOrder == 1) 
                            {
                            	System.out.println("Press 1 for Dine-In \nPress 2 for Takeaway"); //Typing anything other than 1 or 2 will
                            	//bring you back to main menu
                            	num2 = sc.nextInt();
                            	
                            	if(num2 == 1)
                            	{
                            		int randomNumber = order.numOrder(min, max); //Table number generator
            		        		//int randomNumber = Order.numOrder(min, max); //Only usable when we turn numOrder into a static method
            		        		System.out.println("Your table number is " + randomNumber);
            		        		continueOrder = true;
            		        		while(continueOrder)
            		        		{
                			        	Order[] o = new Order[1]; //the array determines how many times you can takeOrder
               			        	 for(int i = 0; i < o.length; i ++)
               			         	{
               			         		o[i] = new Order();
               			             	totalOrder += o[i].takeOrder(menus);
               			             	orderBill.add(new OrderList (o[i].orderDesc, o[i].orderQty, o[i].orderPrice, o[i].orderTotal)); 
               			             	System.out.println("Your total order will be RM" + totalOrder);
               			             	System.out.println("Would you like to order again?");
               			             	System.out.println("Press 1 to order again \nPress 2 to stop ordering");
               			             	int keepOrder = sc.nextInt();
               			             	if(keepOrder == 1)
               			             	{
               			             		continueOrder = true;
               			             	}
               			             	else if(keepOrder == 2)
               			             	{
               			             		continueOrder = false;
               			             	}
               			         	}
            		        		}
//            		        		Order[] o = new Order[1]; //the array determines how many times you can takeOrder
//              			        	 for(int i = 0; i < o.length; i ++)
//              			         	{
//              			         		o[i] = new Order();
//              			             	totalOrder += o[i].takeOrder(menus);
//              			             	orderBill.add(new OrderList (o[i].orderDesc, o[i].orderQty, o[i].orderPrice, o[i].orderTotal)); 
//              			             	System.out.println("Your total order will be RM" + totalOrder);
//              			         	}
            			        	Payment payment = new Payment();
            			        	System.out.println("Your total order will be RM" + totalOrder);
            			        	payment.payMethod();
         			             	payment.printReceiptFormat(totalOrder, orderBill);
         			             	sr.sumEarnings(totalOrder);
         			             	orderBill.clear();
                            	}
                            	else if(num2 == 2)
                            	{
            		        		System.out.println("This is a takeaway");
            		        		continueOrder = true;
            		        		while(continueOrder)
            		        		{
                			        	Order[] o = new Order[1]; //the array determines how many times you can takeOrder
               			        	 for(int i = 0; i < o.length; i ++)
               			         	{
               			         		o[i] = new Order();
               			             	totalOrder += o[i].takeOrder(menus);
               			             	orderBill.add(new OrderList (o[i].orderDesc, o[i].orderQty, o[i].orderPrice, o[i].orderTotal)); 
               			             	System.out.println("Your total order will be RM" + totalOrder);
               			             	System.out.println("Would you like to order again?");
               			             	System.out.println("Press 1 to order again \nPress 2 to stop ordering");
               			             	int keepOrder = sc.nextInt();
               			             	if(keepOrder == 1)
               			             	{
               			             		continueOrder = true;
               			             	}
               			             	else if(keepOrder == 2)
               			             	{
               			             		continueOrder = false;
               			             	}
               			         	}
            		        		}
            			        	Payment payment = new Payment();
            			        	System.out.println("Your total order will be RM" + totalOrder);
            			        	payment.payMethod();
         			             	payment.printReceiptFormat(totalOrder, orderBill);
         			             	sr.sumEarnings(totalOrder);
         			             	orderBill.clear();
                            	}
                            } 
                            else if (numOrder == 2) 
                            {
                                level = 0; // go back to main menu
                            } 
                            else 
                            {
                                System.out.println("Invalid input");
                            }
                    	} 
                    	else
                    	{
                    		System.out.println("Menu is empty");
                    	}
                    } 
                    else if (num == 2) 
                    {
                        level = 1; // go to login menu
                    } 
                    else 
                    {
                        System.out.println("Invalid input");
                    }
                    break;
                case 1:
                    // login menu
                    u.Login();
                    if (u.mId == 1 && u.mPass.equals("M123")) 
                    {
                        System.out.println("Login Sucessful");
                        System.out.println("Press 1 to View Menu\n" + "Press 2 to Edit Menu\n" + "Press 3 to view Sales\n"
                            + "Press 0 to Go back");
                        loginNum = sc.nextInt();
                        if (loginNum == 0) 
                        {
                            level = 0; // go back to main menu
                        } 
                        else if (loginNum == 1) //viewMenu
                        {
                            order.viewMenu(menus);
                            System.out.println("Press 2 to Edit Menu\nPress 3 to view Sales\nPress 0 to Go back");
                            loginNum = sc.nextInt();
                            if (loginNum == 0) 
                            {
                                level = 1; // stay in the same menu
                            } 
                            else if (loginNum == 2) 
                            {                            
                                level = 2; //Go to edit menu
                            } 
                            else if (loginNum == 3) 
                            {
                                level = 3; //Go to sales menu
                            }
                            else 
                            {
                                System.out.println("Invalid input");
                            }
                        }
                        else if(loginNum == 2)
                        {
                        	level = 2;
                        }
                        else if (loginNum == 3) 
                        {
                            //level = 3; // go to view sales menu
                            sr.printSalesReport();
                        } 
                        else 
                        {
                            System.out.println("Invalid input");
                        }
                    } 
                    else 
                    {
                        System.out.println("Invalid ID or Password");
                        level = 0; // go back to main menu
                    }
                    break;
                case 2:
                    //Edit menu
                	System.out.println("Press 1 to add item into the menu \nPress 2 to delete item in the menu \nPress 0 to go back");
                	editNum = sc.nextInt();
                	if(editNum == 0)
                	{
                		level = 1;
                	}
                	else if(editNum == 1)
                	{
                		do
                		{
                			order.viewMenu(menus);
                    		AddMenu(sc, menus);
                            order.viewMenu(menus); //use to test if the code on top works
                            System.out.println("Do you still want to add items? \nPress 1 to continue \nPress 0 to exit");
                            editNum = sc.nextInt();
                		}while(editNum == 1);
                        
                	} 
                	else if (editNum == 2) 
                    {
                        do
                        {
                        	order.viewMenu(menus);
                        	DeleteMenu(sc, menus);
                            order.viewMenu(menus);
                            System.out.println("Do you still want to delete items? \nPress 1 to continue \nPress 0 to exit");
                            editNum = sc.nextInt();
                        }while(editNum == 1);
                    } 
                    else if (editNum != 1) 
                    {
                        System.out.println("Invalid input");
                    }
                    break;
                case 3:
                    //Sales menu
            }
        }while(level >= 0);
	}
	public static void AddMenu(Scanner sc, ArrayList<Menu> menus)
	{
		

		System.out.println("Enter Menu ID: ");
		foodId = sc.nextInt();
		System.out.println("Enter Menu Food Description: ");
		sc.nextLine();
		foodName = sc.nextLine();
		System.out.println("Enter Menu Food Price: ");
		foodPrice = sc.nextDouble();
		
		menus.add(new Menu(foodId, foodName, foodPrice));
	}
	
	public static void DeleteMenu(Scanner sc, ArrayList<Menu> menus)
	{
		if(!menus.isEmpty())
		{
			System.out.print("Enter menu ID to delete: ");
		    foodId = sc.nextInt();

		    for (Menu menu : menus) 
		    {
		    	if (menu.id == foodId) 
		        {
		            menus.remove(menu);
		            System.out.println("Menu item has been deleted.");
		            return;
		        }
		    }
		}
		else
		{
			System.out.println("Menu is empty");
		}
	}	
}	

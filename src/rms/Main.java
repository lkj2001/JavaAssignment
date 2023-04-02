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
		int num, loginNum, editNum, numOrder;
		double totalOrder = 0.00;
		
		int min = 1, max = 10; //Uses for random table number

		RMS u = new RMS();
		Order order = new Order();
		
		ArrayList<Menu> menus = new ArrayList<Menu>();
		
		menus.add(new Menu(1, "Nasi Lemak", 3.00)); //Need to use toString in order for the Main to detect the parameter
        menus.add(new Menu(2, "Mee Hoon", 3.00));
        menus.add(new Menu(3, "Roti Canai", 3.00));
        menus.add(new Menu(4, "Bread", 3.00));
//		do
//		{
//			System.out.println("Press 1 to View Menu\n" + "Press 2 to Login\n" + "Press 0 to exit program");
//			num = sc.nextInt();
//			sc.nextLine();
//			if(num == 0)
//			{
//				System.out.println("Goodbye, have a nice day!!");
//				break;
//			}
//			else if(num == 1)
//			{ 
//				order.viewMenu(menus);
//		        System.out.println("Press 1 to Order \nPress 2 to Go back" );
//		        numOrder = sc.nextInt();
//		        do
//		        {
//		        	if(numOrder == 1)
//			        {
//		        		int randomNumber = order.numOrder(min, max); //Table number generator
//		        		//int randomNumber = Order.numOrder(min, max); //Only usable when we turn numOrder into a static method
//		        		System.out.println("Your table number is " + randomNumber);
//			        	Order[] o = new Order[3]; //the array determines how many times you can takeOrder
//			        	 for(int i = 0; i < o.length; i ++)
//			         	{
//			         		o[i] = new Order();
//			             	totalOrder += o[i].takeOrder(menus);
//			             	System.out.println("Your total order will be RM" + totalOrder);
//			         	}
//			        }
//			        else if(numOrder == 2)
//			        {
//						break; //Pressing 2 will go back to line 29
//			        }
//		        	break;
//		        	
//		        } while(true);
//			}
//			else if (num == 2)
//			{
//				u.Login();
//				if(u.mId == 1 && u.mPass.equals("M123"))
//				{
//					System.out.println("Login Sucessful");
//					System.out.println("Press 1 to View Menu\n" + "Press 2 to Edit Menu\n" + "Press 3 to view Sales\n"
//					+ "Press 0 to Go back");
//					num1 = sc.nextInt();
//					if (num1 == 1)
//					{
//						order.viewMenu(menus);
//				        System.out.println("Press 2 to Edit Menu\nPress 3 to view Sales\nPress 0 to Go back");
//			            num1 = sc.nextInt();
//				        
//					}
//					else if(num1 == 2)
//					{
//						System.out.println("Press 1 to Add menu items \nPress 2 to Delete menu items \nPress 0 to go back");
//						num2 = sc.nextInt();
//						if(num2 == 0)
//						{
//							
//						}
//						else if(num2 == 1)
//						{
//							do
//							{
//								AddMenu(sc, menus);
//								order.viewMenu(menus); //use to test if the code on top works
//								System.out.println("Do you still want to add items? \nPress 1 to continue \nPress 0 to exit");
//								num2 = sc.nextInt();
//							}while(num2 == 1);
//							
//						}
//						else if(num2 == 2)
//						{
//							DeleteMenu(sc, menus);
//							order.viewMenu(menus); //use to test if the code on top works
//						}
//						break;
//					}
//					
//					else if(num1 == 3)
//					{
//						break;
//					}
//					break;
//					}
//				
//				else
//				{
//					System.out.println("Invalid ID or Password");
//				}
//			}
//			else
//			{
//				System.out.println("Invalid number, Please insert the correct number");
//			}
//		} while (true);
        
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
                        order.viewMenu(menus);
                        System.out.println("Press 1 to Order \nPress 2 to Go back");
                        numOrder = sc.nextInt();
                        if (numOrder == 1) 
                        {
                        	int randomNumber = order.numOrder(min, max); //Table number generator
    		        		//int randomNumber = Order.numOrder(min, max); //Only usable when we turn numOrder into a static method
    		        		System.out.println("Your table number is " + randomNumber);
    			        	Order[] o = new Order[3]; //the array determines how many times you can takeOrder
    			        	 for(int i = 0; i < o.length; i ++)
    			         	{
    			         		o[i] = new Order();
    			             	totalOrder += o[i].takeOrder(menus);
    			             	System.out.println("Your total order will be RM" + totalOrder);
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
                            level = 3; // go to view sales menu
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
                		AddMenu(sc, menus);
                        order.viewMenu(menus); //use to test if the code on top works
                        System.out.println("Do you still want to add items? \nPress 1 to continue \nPress 0 to exit");
                        editNum = sc.nextInt();
                        
                	} 
                	else if (editNum == 2) 
                    {
                        DeleteMenu(sc, menus);
                        order.viewMenu(menus);
                        System.out.println("Do you still want to delete items? \nPress 1 to continue \nPress 0 to exit");
                        editNum = sc.nextInt();
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
		foodName = sc.next();
		System.out.println("Enter Menu Food Price: ");
		foodPrice = sc.nextDouble();
		
		menus.add(new Menu(foodId, foodName, foodPrice));
	}
	
	public static void DeleteMenu(Scanner sc, ArrayList<Menu> menus)
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
	
}	

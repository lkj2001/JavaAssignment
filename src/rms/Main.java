package rms;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class Main 
{	
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int num, num1, num2, numOrder;
		double totalOrder = 0.00;
		
		int min = 1, max = 10; //Uses for random table number

		RMS u = new RMS();
		Order order = new Order();
		
		ArrayList<Menu> menus = new ArrayList<Menu>();
		
		menus.add(new Menu(1, "Nasi Lemak", 3.00)); //Need to use toString in order for the Main to detect the parameter
        menus.add(new Menu(2, "Mee Hoon", 3.00));
        menus.add(new Menu(3, "Roti Canai", 3.00));
        menus.add(new Menu(4, "Bread", 3.00));
		do
		{
			System.out.println("Press 1 to View Menu\n" + "Press 2 to Login\n" + "Press 0 to exit program");
			num = sc.nextInt();
			sc.nextLine();
			if(num == 0)
			{
				System.out.println("Goodbye, have a nice day!!");
				break;
			}
			else if(num == 1)
			{ 
				order.viewMenu(menus);
		        System.out.println("Press 1 to Order \nPress 2 to Go back" );
		        numOrder = sc.nextInt();
		        
		        do
		        {
		        	if(numOrder == 1)
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
			        else if(numOrder == 0)
			        {
			        	System.out.println("Press 1 to View Menu\n" + "Press 2 to Login\n" + "Press 0 to exit program");
						num = sc.nextInt();
						sc.nextLine();
			        }
		        	break;
		        } while(true);
			}
			else if (num == 2)
			{
				u.Login();
				if(u.mId == 1 && u.mPass.equals("M123"))
				{
					System.out.println("Login Sucessful");
					System.out.println("Press 1 to View Menu\n" + "Press 2 to Edit Menu\n" + "Press 3 to view Sales\n"
					+ "Press 0 to exit program");
					num1 = sc.nextInt();
					if (num1 == 1)
					{
						order.viewMenu(menus);
				        System.out.println("Press 2 to Edit Menu\nPress 3 to view Sales\nPress 0 to exit program");
			            num1 = sc.nextInt();
				        
					}
					else if(num1 == 2)
					{
						System.out.println("Press 1 to Add menu items \nPress 2 to Delete menu items");
						num2 = sc.nextInt();
						if(num2 == 1)
						{
							do
							{
								AddMenu(sc, menus);
								order.viewMenu(menus); //use to test if the code on top works
								System.out.println("Do you still want to add items? \nPress 1 to continue \nPress 0 to exit");
								num2 = sc.nextInt();
							}while(num2 == 1);
							
						}
						else if(num2 == 2)
						{
							
						}
						break;
					}
					
					else if(num1 == 3)
					{
						break;
					}
					break;
				}
				else
				{
					System.out.println("Invalid ID or Password");
				}
			}
			else
			{
				System.out.println("Invalid number, Please insert the correct number");
			}
		} while (true);
	}
	
	public static void AddMenu(Scanner sc, ArrayList<Menu> menus)
	{
		int foodId;
		String foodName;
		Double foodPrice;

		System.out.println("Enter Menu ID: ");
		foodId = sc.nextInt();
		System.out.println("Enter Menu Food Description: ");
		foodName = sc.next();
		System.out.println("Enter Menu Food Price: ");
		foodPrice = sc.nextDouble();
		
		menus.add(new Menu(foodId, foodName, foodPrice));
	}
	
}	

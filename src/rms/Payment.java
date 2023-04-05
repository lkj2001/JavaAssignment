package rms;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Payment {
	private String paymentType;
	private double cashAmount;
	private double cashReturnAmount;
	private int cardNumber;
	
	Scanner sc = new Scanner(System.in);
	
	public void payMethod() {
		int num;
		do {
			System.out.println("Enter 1 for cash \n2 for card ");
			num = sc.nextInt();
	
			switch(num) {
				case 1: 
					paymentType = "Cash";
					System.out.println("Payment type selected Cash");
					System.out.println("Amount received: ");
					cashAmount = sc.nextDouble();
					break;
				case 2:
					paymentType = "Card";
					System.out.println("Payment type selected Card");
					cardNumber = sc.nextInt();
					break;
				default:
					System.out.println("Please enter 1 for cash \n2 for card payment");
					break;
			}
		}while(num <= 0 && num >= 3);
	}
	
	public void printReceipt(double totalAmount, ArrayList<OrderList> orderBill) {
		int transCount = 0; //Used for Transaction Number
		transCount++;
		
		cashReturnAmount = cashAmount - totalAmount;
		System.out.println("		Kopitiam Restaurant");
		System.out.println("Jalan Kontraktor U1/14, Glenpark U1, 40150 Shah Alam, Selangor");
		System.out.println("---------------------------------------------------------------");
		
		System.out.println("Transactional Number: N" + transCount); //Display Transaction Number
		
		for(int i = 0; i <orderBill.size(); i++){
			    orderBill.get(i).displayOrders(); // Each element of menus
			  }
		System.out.println("Cash Received: " + cashAmount);
		System.out.println("Change amount: " + cashReturnAmount);
		System.out.println("Thank you for coming, please come again!");
	}
}

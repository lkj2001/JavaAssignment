package rms;
//import static rms.Payment.transNumber;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public  class Payment {
	private String paymentType;
	public double cashAmount;
	public double cashReturnAmount;
	protected int cardNumber;
	protected static int transactionCounter = 100;
	
	Scanner sc = new Scanner(System.in);
	
	public void payMethod() {
		int num;
		do {
			System.out.println("Enter 1 for cash \nEnter 2 for card ");
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

	private static String transNumber() //This need to be a static function
	{
	    String transactionNumber = "Transaction Number: N" + transactionCounter;
	    transactionCounter++;
	    return transactionNumber;
	}
	
	void printReceiptFormat(double totalAmount, ArrayList<OrderList> orderBill) {
		
		cashReturnAmount = cashAmount - totalAmount;
		System.out.println("		Kopitiam Restaurant");
		System.out.println("Jalan Kontraktor U1/14, Glenpark U1, 40150 Shah Alam, Selangor");
		System.out.println(transNumber());
		System.out.println("---------------------------------------------------------------");
		
		for(int i = 0; i <orderBill.size(); i++){
			    orderBill.get(i).displayOrders(); // Each element of menus
			  }
		
			if(paymentType == "Cash") {
				new Cash().printReceipt(cashAmount,cashReturnAmount);
			}
				else {
				 new Card().printReceipt();
			}
		System.out.println("Thank you for coming, please come again!");
	}
	
	 void printReceipt() {
		 
	 }
}



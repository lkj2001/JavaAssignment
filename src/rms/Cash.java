package rms;

import java.util.ArrayList;

class Cash extends Payment{
	void printReceipt(double cashAmount,double cashReturnAmount) {

		System.out.println("Cash Received: " + cashAmount);
		System.out.println("Change amount: " + cashReturnAmount);

	}
}

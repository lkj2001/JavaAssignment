package rms;

import java.util.Scanner;

public class RMS 
{
	Scanner sc = new Scanner(System.in);
	public int mId;
	//private String mName;
	public String mPass;
	
	public void Login()
	{
		System.out.println("Enter your id: ");
		mId = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter your password: ");
		mPass = sc.nextLine();	
	}
}

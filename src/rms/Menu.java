package rms;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu 
{
	protected int id;
	protected String itemName;
	protected Double itemCost;
	
	public Menu(int id, String itemName, Double itemCost)
	{
		this.id = id;
		this.itemName = itemName;
		this.itemCost = itemCost;
	}
	
//	public void display()
//	{
//		System.out.println("id " + id + "\n" + "name: " + itemName + "\n" + "cost " + itemCost);
//	}
	
	public String toString()
	{
		return "ID: "  + id + " | "  + " Name: "  + itemName + " | " + "Price " + itemCost + "\n" 
	+ "----------------------------------------";
	}
	/*
	
	}*/
}


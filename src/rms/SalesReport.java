package rms;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
public class SalesReport {
	public double totalDayEarnings;
	public double totalMonthEarnings;
	public int currentMonth;
	public int currentDay;
	
	Date date = new Date();
	LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	int month = localDate.getMonthValue();
	int day = localDate.getDayOfMonth();

	public void printSalesReport() {
		System.out.println("-----------------------------------------------");
		System.out.println("Sales Report");
		System.out.println("Date: " + localDate  + "\nEarnings: " + totalDayEarnings);
		System.out.println("This Month Earnings: " + totalMonthEarnings);
		System.out.println("-----------------------------------------------");
	}

	public void sumEarnings(double totalOrder) {
		if(currentDay != day) {
			currentDay = day;
			totalDayEarnings = 0;
		}
		if(currentMonth != month) {
			currentMonth = month;
			totalMonthEarnings = 0;
		}
		totalDayEarnings = totalDayEarnings + totalOrder;
		totalMonthEarnings = totalMonthEarnings + totalOrder;
	}
	
}

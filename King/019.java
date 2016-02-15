public class euler {
	
	public static void main (String [] abc) {
		int [] daysInMonth={31,28,31,30,31,30,31,31,30,31,30,31};
		int [] daysInMonthLeapYear={31,29,31,30,31,30,31,31,30,31,30,31};
		int days=0;
		int count=0;
		
		for (int i=0;i<12;i++) {
			days+=daysInMonth[i]; //for filling the days until 1901, 1 Jan.
		}
		
		for (int year=1901;year<2001;year++) {
			for (int month=0;month<12;month++) {
				if (days%7==6) {
					count++;
				}
				if ((year%4==0 && year%100!=0) || year%400==0) {
					days=days+daysInMonthLeapYear[month];
				} else {
					days=days+daysInMonth[month];
				}
			}
		}
		System.out.println(count);
	}
}
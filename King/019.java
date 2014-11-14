public class euler {
	
	public static void main (String [] abc) {
		int [] daysInMonth={31,28,31,30,31,30,31,31,30,31,30,31};
		int [] daysInMonthLeapYear={31,29,31,30,31,30,31,31,30,31,30,31};
		int maxDays=0;
		int count=0;
		for (int year=1900;year<2001;year++) {
			for (int month=0;month<12;month++) {
				if (year>1900 && maxDays%7==6) {
					count++;
				}
				if ((year%4==0 && year%100!=0) || year%400==0) {
					maxDays=maxDays+daysInMonthLeapYear[month];
				} else {
					maxDays=maxDays+daysInMonth[month];
				}
			}
		}
		System.out.println(count);
	}
}
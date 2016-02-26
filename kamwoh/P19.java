

package projecteuler;

/**
 *
 * @author Woh
 */
public class P19 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int year=1900;
        int day;
        int[] totalYear = new int[2000-1901+1];
        int nextYear = dayOneOfYear(1901,0);
        System.out.println("1901 day 1:"+nextYear);
        displayDay(nextYear);
        /*int dayTotal=0;
        for(int i=1901;i<=2000;i++)
        {
            if(isLeapYear(i))
            {
                day=366;
                dayTotal+=day;
            }
            else
            {
                day=365;
                dayTotal+=day;
            }//System.out.println("year:"+i+",day:"+day);
        }
        System.out.println("total day between 1901 and 2000:"+dayTotal);
        int weekTotal=dayTotal/7;
        System.out.println("total week:"+ weekTotal);
        int shift=dayTotal-4;
        System.out.println("shift:"+shift);
        int totalSun=shift/7;
        System.out.println("total sun:"+totalSun);
        int day1=shift%7;
        System.out.println("day 1:"+day1);*/
        
        int[] month;
        //int[][] d=new int[100][12];
        int d=0;
        int count=0;
        
        for(int i=1901;i<=2000;i++)
        {
            d=dayOneOfYear(i,d);
            month=monthDay(i,d);
            for(int j=0;j<12;j++)
            {
                if(month[j]==6)
                    count++;
            }
            
        }
        
        System.out.println("total sun:"+count);
        
    }
    
    public static int dayOneOfYear(int year, int dayOneOfLastYear)
    {
        int day;
        if(isLeapYear(year-1))
            day=dayOneOfLastYear+2;
        else
            day=dayOneOfLastYear+1;
        day%=7;
        return day;
    }
    
    public static int[] monthDay(int currentYear, int dayOneOfYear)
    {
        int[] monthDay = new int[12];
        int day=dayOneOfYear;
        int totalDayOfMonth;
        for(int i=0;i<12;i++)
        {
            monthDay[i]=day;
            totalDayOfMonth=day(i+1,currentYear);
            day+=totalDayOfMonth-28;
            day%=7;
        }
        return monthDay;
    }
    
    public static int day(int month, int year)
    {
        if(month==1||month==3||month==5||month==7||month==8||month==10||month==12)
            return 31;
        else if(month==2)
        {
            if(isLeapYear(year))
                return 29;
            else
                return 28;
        }
        else
            return 30;
    }

    public static boolean isLeapYear(int year)
    {
        return year%4==0&&(year%100!=0||year%400==0);
    }
    
    public static void displayDay(int day)
    {
        String s="";
        switch(day)
        {
            case 0:
                s="Monday";
                break;
            case 1:
                s="Tuesday";
                break;
            case 2:
                s="Wednesday";
                break;
            case 3:
                s="Thursday";
                break;
            case 4:
                s="Friday";
                break;
            case 5:
                s="Saturday";
                break;
            case 6:
                s="Sunday";
                break;
        }
        System.out.println(s);
    }
    
}

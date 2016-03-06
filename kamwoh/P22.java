

package projecteuler;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Woh
 */
public class P22 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String file = "p022_names.txt";
        String[] s1 = getInput(file);
        sort(s1);
        long total=0;
        for(int i=0;i<s1.length;i++)
        {
            total+=getValue(s1[i])*(binarySearch(s1,s1[i])+1);
        }
        System.out.println("total:"+total);
    }
    
    public static String[] getInput(String file)
    {
        String[] s1=null;
        try{
            Scanner read = new Scanner(new FileInputStream(file));
            String s = read.nextLine();
            s1 = s.split(",");
            s1 = takeOffQuote(s1);
        }catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
        return s1;
    }

    public static void sort(String[] s)
    {
        sort(s,0,s.length-1);
    }
    
    public static void sort(String[] s, int low, int high)
    {
        if(low<high)
        {
            int minIndex = low;
            String temp = s[low];
            for(int i=low+1;i<=high;i++)
            {
                if(s[i].compareTo(temp)<0)
                {
                    temp=s[i];
                    minIndex=i;
                }
            }
            
            s[minIndex]=s[low];
            s[low]=temp;
            sort(s,low+1,high);
        }
    }
    
    public static int getValue(String s)
    {
        int total=0;
        for(int i=0;i<s.length();i++)
        {
            total+=s.charAt(i)-64;
        }
        return total;
    }
    
    public static int binarySearch(String[] s,String key)
    {
        return binarySearch(s,key,0,s.length-1);
    }
    
    public static int binarySearch(String[] s, String key, int low, int high)
    {
        if(low>high)
            return -1;
        int mid = (low+high)/2;
        if(s[mid].compareTo(key)>0)
        {
            return binarySearch(s,key,low,mid-1);
        }
        else if(s[mid].compareTo(key)==0)
        {
            return mid;
        }
        else
        {
            return binarySearch(s,key,mid+1,high);
        }
    }
    
    public static String[] takeOffQuote(String[] s)
    {
        String[] s1 = new String[s.length];
        String temp;
        for(int i=0;i<s.length;i++)
        {
            temp=s[i].substring(1,s[i].length()-1);
            s1[i]=temp;
        }
        return s1;
    }
    
}

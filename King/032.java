import java.util.ArrayList;

public class euler {
	
	public static void main (String [] abc) {
		long startTime=System.currentTimeMillis();
		int sum=0;
		ArrayList<Integer> al=new ArrayList<>();
		for (int i=1;i<=9876;i++) {
			if (checkUnique(i)) {
				for (int i2=2;i2<=987;i2++) {
					if (!al.contains(i*i2) && check(i,i2,i*i2)) {
						sum+=i*i2;
						al.add(i*i2);
					}
				}
			}
		}
		long processTime=System.currentTimeMillis()-startTime;
		System.out.println(sum+"\nTook "+processTime+"ms.");
	}
	
	public static boolean checkUnique (int num) {
		boolean [] flag=new boolean [10];
		int quotient=0;
		while (num>0) {
			quotient=num%10;
			if (flag[quotient] || quotient==0) {
				return false;
			} else {
				flag[quotient]=true;
			}
			num/=10;
		}
		return true;
	}
	
	public static boolean check (int num1, int num2, int num3) {
		boolean [] flag=new boolean [10];
		int count=0;
		int quotient=0;
		int [] nums={num1,num2,num3};
		for (int i=0;i<3;i++) {
			while (nums[i]>0) {
				quotient=nums[i]%10;
				if (flag[quotient] || quotient==0) {
					return false;
				} else {
					flag[quotient]=true;
					count++;
				}
				nums[i]/=10;
			}
		}
		return (count==9);
	}
}
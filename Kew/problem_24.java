import java.util.ArrayList;
public class problem_24
{
	public static void main(String[]args)
	{
		long before=System.currentTimeMillis();
		String[]n={"0","1","2","3","4","5","6","7","8","9"};		
		//String[]n={"0","1","2","3","4","5"};		
		int loop=factoria(n.length);
		int size=n.length;
		int loopSize=loop;
		int index=0;		
		String[]ans=new String[loop];		
		for(int i=0;i<ans.length;i++)
		{
			ans[i]="";
		}		

		//System.out.println("n.length="+n.length);
		//System.out.println("loop="+loop);
		//System.out.println("size="+size);
		loopSize/=size;
		

		while(index!=loop||loopSize!=2)
		{			

			if(index==loop)
			{				
				index=0;
				size--;
				loopSize/=size;	
			}
			for(int i=0;i<size;i++)
			{
				for(int j=0;j<loopSize;j++)
				{			
					//System.out.println("index="+index);		
					ArrayList <String> letter=checkRepeat(n,ans[index]);
					ans[index]+=letter.get(i);
					//System.out.println("ans="+ans[index]);
					index++;					
				}
			}					
		}	

		String[]temp=new String[2];

		for(int i=0;i<loop;i++)
		{
			check(temp,n,ans[i]);
			for(int j=0;j<temp.length;j++)
			{
				ans[i]+=temp[j];
			}

			for(int j=temp.length-1;j>=0;j--)
			{
				ans[i+1]+=temp[j];
			}
			i++;
		}

		System.out.println(ans[999999]);
		System.out.println(ans[1000000]);
		System.out.println(ans[1000001]);

		long after=System.currentTimeMillis();
		System.out.println("Time Taken="+(after-before)+"ms");
		/*for(int i=0;i<ans.length;i++)
		{
			System.out.println(ans[i]);
		}*/

	}

	public static ArrayList<String> checkRepeat(String[]n,String input)
	{		
		ArrayList<String>letter=new ArrayList<>();
		boolean check=false;
		for(int i=0;i<n.length;i++)
		{
			for(int j=0;j<input.length();j++)
			{
				if(String.valueOf(input.charAt(j)).equals(n[i]))
					check=true;
			}
			if(!check)
			{
				letter.add(n[i]);
			}
			check=false;
		}		

		return letter;
	}

	public static void check(String[]temp,String[]n,String input)
	{
		boolean check=true;
		int index=0;
		for(int i=0;i<n.length;i++)
		{
			check=true;
			for(int j=0;j<input.length();j++)
			{
				if(String.valueOf(input.charAt(j)).equals(n[i]))
				{
					check=false;
					break;
				}
			}
			if(check)
			{
				//System.out.println("index="+index);
				temp[index]=n[i];
				index++;				
			}
		}
	}

	public static int factoria(int n)
	{
		if(n==1)
			return n;
		else
			return factoria(n-1)*n;
	}
}
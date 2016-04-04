public class problem_32
{
	public static void main(String[]args)
	{
		int top = 987654321;
		System.out.println(top);
		boolean[]pandigital=new boolean[top];
		int product=0;
		int sum=0;
		boolean[]repeat=new boolean[10];
		for(int i=0;i<98765;i++)
		{
			for(int j=i;j<98765;j++)
			{
				System.out.println("i="+i);
				ΩSystem.out.println("j="+j);
				//clear the cache of repeat
				for(int y=0;y<repeat.length;y++)
				{
					repeat[y]=false;
				}
				product=i*j;
				//System.out.println("i="+i);
				//System.out.println("j="+j);
				//System.out.println("product="+product);
				String temp=Integer.toString(product);
				String tempI=Integer.toString(i);
				String tempJ=Integer.toString(j);
				if((temp.length()+tempI.length()+tempJ.length())!=9)
					continue;

				//boolean[]repeat=new boolean[10];
				//check for i
				int reminder=0;
				reminder=i;
				do
				{				
					//System.out.println("i="+i);
					repeat[reminder%10]=true;
					reminder/=10;

				}while(reminder!=0);
				//end of check for i

				//check for j				
				reminder=j;
				do
				{					
					repeat[reminder%10]=true;
					reminder/=10;
				}while(reminder!=0);
				//end of check for j

				//check for product
				reminder=product;
				do
				{					
					repeat[reminder%10]=true;
					reminder/=10;
				}while(reminder!=0);
				//end of check for product

				boolean check=false;
				for(int k=1;k<10;k++)
				{
					if(repeat[k]!=true)
						check=true;
				}
				if(!check)
				{
					pandigital[product]=true;
					System.out.println("i="+i);
					System.out.println("j="+j);
					System.out.println("product="+product);
				}
					

				}
			

			
		}

		for(int i=0;i<pandigital.length;i++)
		{
			if(pandigital[i]==true)
			{	
				sum+=i;
			}
		}

		System.out.println(sum);

	}
}
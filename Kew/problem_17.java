public class problem_17
{	
	public static void main(String[]args)
	{
		int total=0;
		for(int i=1;i<1001;i++)
		{			
			String word=identifyLetter(i);
			System.out.println(word);
			System.out.println(i);
			System.out.println(word.length());
			total+=word.length();
			//System.out.println(total);
		}

		System.out.println(total);
	}

	public static String identifyLetter(int num)
	{
		String word="";

		if(num==1000)
		{
			word="onethousand";
			return word;
		}

		int index=0;

		int temp=num;
		do
		{			
			temp/=10;
			index++;
		}while(temp!=0);

		if(num<=20)
		{			
			switch(num)
			{
				case 1:
					word="one";
					break;
				case 2:
					word="two";
					break;
				case 3:
					word="three";
					break;
				case 4:
					word="four";
					break;
				case 5:
					word="five";
					break;
				case 6:
					word="six";
					break;
				case 7:
					word="seven";
					break;	
				case 8:
					word="eight";
					break;
				case 9:
					word="nine";
					break;
				case 10:
					word="ten";
					break;
				case 11:
					word="eleven";
					break;
				case 12:
					word="twelve";
					break;
				case 13:
					word="thirteen";
					break;
				case 14:
					word="fourteen";
					break;
				case 15:
					word="fifteen";
					break;
				case 16:
					word="sixteen";
					break;
				case 17:
					word="seventeen";
					break;
				case 18:
					word="eighteen";
					break;
				case 19:
					word="nineteen";
					break;
				case 20:
					word="twenty";
					break;
			}
		}
		else 
		{
			int reminder=0;			
			/*reminder=num%10;
			switch(reminder)
			{
				case 1:
					word+="one";
					break;
				case 2:
					word+="two";
					break;
				case 3:
					word+="three";
					break;
				case 4:
					word+="four";
					break;
				case 5:
					word+="five";
					break;
				case 6:
					word+="six";
					break;
				case 7:
					word+="seven";
					break;	
				case 8:
					word+="eight";
					break;
				case 9:
					word+="nine";	
					break;
				case 10:
					word+="ten";
					break;
			}*/

			temp=num;
			num/=10;
			int reminder2=num%10;
			reminder=temp%10;

			System.out.println("reminder2="+reminder2);
			if(reminder2>=2)
			{
				//System.out.println("reminder2 greater than 2");
				if(index>2)
				{
					word+="and";
				}		
				switch(reminder2)
				{								
					case 2:
						word+="twenty";
						break;			
					case 3:
						word+="thirty";
						break;
					case 4:
						word+="forty";
						break;
					case 5:
						word+="fifty";
						break;
					case 6:
						word+="sixty";
						break;
					case 7:
						word+="seventy";
						break;	
					case 8:
						word+="eighty";
						break;
					case 9:
						word+="ninety";
						break;
				}

				switch(reminder)
				{
					case 1:
						word+="one";
						break;
					case 2:
						word+="two";
						break;
					case 3:
						word+="three";
						break;
					case 4:
						word+="four";
						break;
					case 5:
						word+="five";
						break;
					case 6:
						word+="six";
						break;
					case 7:
						word+="seven";
						break;	
					case 8:
						word+="eight";
						break;
					case 9:
						word+="nine";
						break;					
				}

			}
			else
			{
				if(reminder2>=1)
				{
					switch(reminder)
					{
						case 0:
							word="andten";
							break;
						case 1:
							word="andeleven";
							break;
						case 2:
							word="andtwelve";
							break;
						case 3:
							word="andthirteen";
							break;
						case 4:
							word="andfourteen";
							break;
						case 5:
							word="andfifteen";
							break;
						case 6:
							word="andsixteen";
							break;
						case 7:
							word="andseventeen";
							break;
						case 8:
							word="andeighteen";
							break;
						case 9:
							word="andnineteen";
							break;				
					}
				}
				else if(reminder2==0)
				{
					if(index>2&&(reminder2!=0||reminder!=0))
					{
						word+="and";
					}
					switch(reminder)
					{
						case 1:
							word+="one";
							break;
						case 2:
							word+="two";
							break;
						case 3:
							word+="three";
							break;
						case 4:
							word+="four";
							break;
						case 5:
							word+="five";
							break;
						case 6:
							word+="six";
							break;
						case 7:
							word+="seven";
							break;	
						case 8:
							word+="eight";
							break;
						case 9:
							word+="nine";
							break;					
					}

				}
				
			}

			

			if(index>2)
			{
				word+="hundred";

				num/=10;
				reminder=num%10;

				switch(reminder)
				{
					case 1:
						word+="one";
						break;
					case 2:
						word+="two";
						break;
					case 3:
						word+="three";
						break;
					case 4:
						word+="four";
						break;
					case 5:
						word+="five";
						break;
					case 6:
						word+="six";
						break;
					case 7:
						word+="seven";
						break;	
					case 8:
						word+="eight";
						break;
					case 9:
						word+="nine";
						break;
					case 10:
						word+="ten";
						break;
				}
			}
		
		}


		return word;
	}
}
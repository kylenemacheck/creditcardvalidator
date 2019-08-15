package creditCard;

import java.util.ArrayList;
import java.util.List;

public class Valitdator 
{
	private static double creditCardNumber;
	
	public Valitdator (double creditCardNumber)
	{
		this.creditCardNumber = creditCardNumber;
	}
	
	public static int numberOfDigits(double number)
	{
		return (int) (Math.log10(number) + 1);
	}
	
	public static boolean isAMAX(List<Integer> ccArray)
	{
		return numberOfDigits(creditCardNumber) == 15 && ((ccArray.get(0) == 3 && ccArray.get(1) == 4) || 
				(ccArray.get(0) == 3 && ccArray.get(1) == 7));
	}
	
	public static boolean isMasterCard(List<Integer> ccArray)
	{
		return numberOfDigits(creditCardNumber) == 16 && ((ccArray.get(0) == 5 && ccArray.get(1) == 1) || 
				(ccArray.get(0) == 5 && ccArray.get(1) == 2) || (ccArray.get(0) == 5 && ccArray.get(1) == 3) || 
				(ccArray.get(0) == 5 && ccArray.get(1) == 4) || (ccArray.get(0) == 5 && ccArray.get(0) == 5));
	}
	
	public static boolean isVISA(List<Integer> ccArray)
	{
		return ccArray.get(0) == 4 && (numberOfDigits(creditCardNumber) == 13 || numberOfDigits(creditCardNumber) == 16);
	}
	
	public static List<Integer> numberToArray(double number)
	{
		List<Integer> array = new ArrayList<>();
		for (; number != 0; number /= 10)
		   array.add((int) number % 10);
		return array;
	}
	
	public static String validateCard()
	{
		double tempCard = 0;
		int the = 0;
		int placeHolder = 2;
		
		List<Integer> ccArray = numberToArray(creditCardNumber);
		
		while (placeHolder < numberOfDigits(creditCardNumber))
		{
			tempCard = ccArray.get(numberOfDigits(creditCardNumber) - placeHolder) * 2;
			    
			if (tempCard > 9)
			{
				the += ccArray.get(1);
				the += ccArray.get(0);
			}
			else
				the += tempCard;
			placeHolder += 2;
		}
		
		int i = 1;
		
		while (i <= numberOfDigits(creditCardNumber))
		{
			the += ccArray.get(numberOfDigits(creditCardNumber) - i);
			i += 2;
		}
		
		if (the % 10 == 0)
		{
			if (isAMAX(ccArray))
				return "AMEX";
			else
			{
				if (isMasterCard(ccArray))
					return "MASTERCARD";
				else
				{
					if (isVISA(ccArray))
						return "VISA";
					else
						return "INVALID";
				}
			}
		}
		else
			return "INVALIDeee";
	}
	// card ex: 378282246310005
}

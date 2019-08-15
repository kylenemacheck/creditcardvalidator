package creditCard;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ValitdatorTest 
{

	@BeforeEach
	void setUp() throws Exception 
	{
		
	}

	@AfterEach
	void tearDown() throws Exception 
	{
		
	}

	@Test
	void testNumberOfDigits() 
	{
		assertTrue(Valitdator.numberOfDigits(123456789101112131415161718.0) == 27);
		assertTrue(Valitdator.numberOfDigits(123456789.0) == 9);
		assertTrue(Valitdator.numberOfDigits(123.0) == 3);
		assertTrue(Valitdator.numberOfDigits(1.0) == 1);
	}
	
	@Test
	void testNumberToArray() 
	{
		double number = 0123456789.0;
		List<Integer> arrayCheck = new ArrayList<>();
		for (int i = 0; i < 10; i++)
			arrayCheck.add(i);
		List<Integer> array = Valitdator.numberToArray(number);
		for (int i = 0; i < arrayCheck.size(); i++)
			assertTrue(arrayCheck.get(i) == array.get(i));
	}
	
	@Test
	void testIsAMAX() 
	{
		List<Integer> array = Valitdator.numberToArray(340000000000000.0);
		assertTrue(Valitdator.isAMAX(array));
		
		array = Valitdator.numberToArray(370000000000000.0);
		assertTrue(Valitdator.isAMAX(array));
	}
	
	@Test
	void testIsMasterCard() 
	{
		double ccNumber = 5100000000000000.0;
		for (int i = 0; i < 5; i++)
		{
			List<Integer> array = Valitdator.numberToArray(ccNumber);
			assertTrue(Valitdator.isMasterCard(array));
			ccNumber += 100000000000000.0;
		}
	}
	
	@Test
	void testIsVISA() 
	{
		List<Integer> array = Valitdator.numberToArray(4000000000000.0);
		assertTrue(Valitdator.isAMAX(array));
		
		array = Valitdator.numberToArray(4000000000000000.0);
		assertTrue(Valitdator.isAMAX(array));
	}
	
	@Test
	void testValidateCard() 
	{
		
	}
}

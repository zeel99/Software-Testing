package AutoTest.eecs4313a2b;

import static org.junit.Assert.*;
import org.junit.Test;

import net.sf.borg.common.DateUtil;

import java.util.Date;

public class IsAfterTest {

	//Valid Date: Date within the valid date range and is a real date (days range from 1-31,
	//months range from 0-11, years range from 1900 onwards)
    //Invalid Date: Date not within the valid date range or not a real date
	
	//Weak Normal: Test cases within the legal input range
	
	
	//WN1: Valid date change: Input variables with varying valid date
	
	@Test
	public void testWeakNormal1() {
		
		assertTrue(DateUtil.isAfter(new Date(2017, 11, 28), new Date(2017, 11, 22)));
		assertFalse(DateUtil.isAfter(new Date(2017, 11, 22),new Date(2017, 11, 28)));
		assertEquals(new Date(2017, 11, 28).after(new Date(2017, 11, 22)),
				DateUtil.isAfter(new Date(2017, 11, 28), new Date(2017, 11, 22)));
	}
	
	//WN2: Valid month change: Input variables with varying valid month
	
	@Test
	public void testWeakNormal2() {
		
		assertTrue(DateUtil.isAfter(new Date(2014, 06, 1), new Date(2014, 05, 1)));
		assertFalse(DateUtil.isAfter(new Date(2014, 05, 1),new Date(2014, 06, 1)));
		assertEquals(new Date(2014, 06, 1).after(new Date(2014, 05, 1)),
						DateUtil.isAfter(new Date(2014, 06, 1), new Date(2014, 05, 1)));
	}
	
	//WN3: Valid year change: Input variable with varying valid year
	
	@Test
	public void testWeakNormal3() {
		
		assertTrue(DateUtil.isAfter(new Date(2010, 05, 25), new Date(2009, 05, 25)));
		assertFalse(DateUtil.isAfter(new Date(2009, 05, 25),new Date(2010, 05, 25)));
		assertEquals(new Date(2010, 05, 25).after(new Date(2009, 05, 25)),
						DateUtil.isAfter(new Date(2010, 05, 25), new Date(2009, 05, 25)));
	}
	
	//Weak Robust: Test cases with valid as well as invalid inputs
	
	Date invalid_d1 = new Date(2009, 01, 30);     //Feb 30 is not possible
	Date valid_before_d1 = new Date(2008, 3, 5);       //valid before first one
	Date valid_after_d1 = new Date(2009, 07, 5);       //valid after first one
	
	Date valid_d1 = new Date(2009, 05, 22);     
	Date invalid_before_d1 = new Date(2008, 01, 30);   //invalid before first one
	Date invalid_after_d1 = new Date(2010, 01, 30);    //valid after first one
	
	//WR1: First date is invalid, but the second one is valid and before the first one
	@Test
	public void testWeakRobust1() {
		
		assertTrue(DateUtil.isAfter(invalid_d1, valid_before_d1));
		assertFalse(DateUtil.isAfter(valid_before_d1, invalid_d1));
		
	}
	
	//WR2: First date is invalid, but the second one is valid and after the first one 
	
	@Test
	public void testWeakRobust2() {
		
		assertFalse(DateUtil.isAfter(invalid_d1, valid_after_d1));
		assertTrue(DateUtil.isAfter(valid_after_d1, invalid_d1));
	}
	
	//WR3: First date is valid, but the second one is invalid and before the first one 
	@Test
	public void testWeakRobust3() {
		
		assertTrue(DateUtil.isAfter(valid_d1, invalid_before_d1));
		assertFalse(DateUtil.isAfter(invalid_before_d1, valid_d1));
	}
	

	//WR4: First date is valid, but the second one is invalid and after the first one 
	@Test
	public void testWeakRobust4() {
		
		assertFalse(DateUtil.isAfter(valid_d1, invalid_after_d1));
		assertTrue(DateUtil.isAfter(invalid_after_d1, valid_d1));
		
	}
	
	//WR5: Both dates are invalid, and the second one is after the first one 
	@Test
	public void testWeakRobust5() {
		
		assertFalse(DateUtil.isAfter(invalid_d1, invalid_after_d1));
	}
	
	//WR6: Both dates are invalid, and the second one is before the first one
	@Test
	public void testWeakRobust6() {
		
		assertTrue(DateUtil.isAfter(invalid_d1, invalid_before_d1));
	}
	
	//WR7: Both dates are valid, and the second one is after the first one 
	@Test
	public void testWeakRobust7() {
		
		assertFalse(DateUtil.isAfter(valid_d1, valid_after_d1));
	}
	
	//WR8: Both dates are valid, and the second one is before the first one
	@Test
	public void testWeakRobust8() {
		
		assertTrue(DateUtil.isAfter(valid_d1, valid_before_d1));
		
	}
	

	
}

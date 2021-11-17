package AutoTest.eecs4313a2b;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;

import net.sf.borg.common.DateUtil;

public class DateUtilTest {
	/**
	 * 
	 * @param year
	 * @param month - 0-based index
	 * @param day
	 */
	public void verifyDayOfEpoch(int year, int month, int day) {
		// GregorianCalendar month value is 0-based index
		Calendar testCalendar = new GregorianCalendar(year, month, day);
		Date testDate = testCalendar.getTime();
		System.out.println(testDate.toString());
		
		// Calculate the epoch day count to be tested
		int epochDayResult = DateUtil.dayOfEpoch(testDate);
		
		// Obtain an instance of LocalDate from the calculated epoch day count (epoch + result).
		// testDateVerification and testDate should be the same date
		LocalDate testDateVerification =  LocalDate.ofEpochDay(epochDayResult);
		System.out.println(testDateVerification.toString());
		// Verify that the original input date is the same as epoch + result
		assertEquals(testCalendar.get(Calendar.YEAR), testDateVerification.getYear());
		assertEquals(testCalendar.get(Calendar.MONTH) + 1, testDateVerification.getMonth().getValue());
		assertEquals(testCalendar.get(Calendar.DAY_OF_MONTH), testDateVerification.getDayOfMonth());
	}
	
	/**
	 * Using Boundary Value Testing technique, we have 4n + 1 test cases for n input variables.
	 * Since the method in test `dayOfEpoch(Date d)` takes a Date as input, we can consider the year, month and day as the three inputs.
	 * For 3 input variables, we have (4 * 3) + 1 = 13 test cases.
	 * 
	 * We should define the minimum, maximum and nominal values for each variable.
	 * Year - minimum: 1970 (UNIX epoch), minimum+: 1971, maximum: 2050 (arbitrary), maximum-: 2049, nominal: 2010
	 * Month - minimum: 1, minimum+: 2, maximum: 12, maximum-: 11, nominal: 6
	 * Day - minimum: 1, minimum+: 2, maximum: 30, maximum-: 29, nominal: 15   // maximum is set to 30 to avoid wrapping over to next month for months with 30 days
	 */
	
	
	/** 
	 * Nominal month and day, minimum year
	 * 1970-6-15
	 */	
	@Test
	public void test1() {
		verifyDayOfEpoch(1970, 5, 15);
	}
	
	/** 
	 * Nominal month and day, minimum+ year
	 * 1971-6-15
	 */	
	@Test
	public void test2() {
		verifyDayOfEpoch(1971, 5, 15);
	}
	
	/** 
	 * Nominal month and day, nominal year
	 * 2010-6-15
	 */
	@Test
	public void test3() {
		verifyDayOfEpoch(2010, 5, 15);
	}
	
	/** 
	 * Nominal month and day, maximum- year
	 * 2049-6-15
	 */	
	@Test
	public void test4() {
		verifyDayOfEpoch(2049, 5, 15);
	}
	
	/** 
	 * Nominal month and day, maximum year
	 * 2050-6-15
	 */	
	@Test
	public void test5() {
		verifyDayOfEpoch(2050, 5, 15);
	}
	
	/** 
	 * Nominal year and day, minimum month
	 * 2010-1-15
	 */	
	@Test
	public void test6() {
		verifyDayOfEpoch(2010, 0, 15);
	}
	
	/** 
	 * Nominal year and day, minimum+ month
	 * 2010-2-15
	 */	
	@Test
	public void test7() {
		verifyDayOfEpoch(2010, 1, 15);
	}
	
	/** 
	 * Nominal year and day, maximum- month
	 * 2010-11-15
	 */	
	@Test
	public void test8() {
		verifyDayOfEpoch(2010, 10, 15);
	}
	
	/** 
	 * Nominal year and day, maximum month
	 * 2010-12-15
	 */	
	@Test
	public void test9() {
		verifyDayOfEpoch(2010, 11, 15);
	}
	
	/** 
	 * Nominal year and month, minimum day
	 * 2010-6-1
	 */	
	@Test
	public void test10() {
		verifyDayOfEpoch(2010, 5, 1);
	}
	
	/** 
	 * Nominal year and month, minimum+ day
	 * 2010-6-2
	 */	
	@Test
	public void test11() {
		verifyDayOfEpoch(2010, 5, 2);
	}
	
	/** 
	 * Nominal year and month, maximum- day
	 * 2010-6-29
	 */	
	@Test
	public void test12() {
		verifyDayOfEpoch(2010, 5, 29);
	}
	
	/** 
	 * Nominal year and month, maximum day
	 * 2010-6-30
	 */	
	@Test
	public void test13() {
		verifyDayOfEpoch(2010, 5, 30);
	}
}

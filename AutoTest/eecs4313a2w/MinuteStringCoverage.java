package AutoTest.eecs4313a2w;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import net.sf.borg.common.DateUtil;


public class MinuteStringCoverage {

	@Test
	public void testminuteString1() {	
		
		//Condition C3 : Value == 60
		assertEquals(DateUtil.minuteString(60), "1 Hour");
	}
	@Test	
	public void testminuteString2() {	
			// Condition C1 : Value = 1
			assertEquals(DateUtil.minuteString(1), "1 Minute");	
		}
	@Test
	public void testminuteString3() {	
		// Condition C2 : Value < 60
		assertEquals(DateUtil.minuteString(21), "21 Minutes");
	}
	@Test
	public void testminuteString4() {		
		//Condition C4 : Value > 60 and Value mod 60 == 0
		assertEquals(DateUtil.minuteString(120), "2 Hours");
	}
	@Test
	public void testminuteString5() {	
		//Condition C5 : Value > 60 and Value mod 60 != 0 (i.e value mod 60 == 1)
		assertEquals(DateUtil.minuteString(181), "3 Hours 1 Minute");
	}
	@Test
	public void testminuteString6() {	
		//Condition C6 : Value > 60 and Value mod 60 != 0 (i.e value mod 60 > 1)
		assertEquals(DateUtil.minuteString(195), "3 Hours 15 Minutes");
	}
	
	
//-----------------------------------------------------------------------------------
	// New test cases to increase coverage.
	
	
	@Test
	public void testminuteString7() {	
		//Condition C6 : Value = 0
		assertEquals(DateUtil.minuteString(0), "0 Minutes");
	}
	
	@Test
	public void testminuteString8() {	
		//Condition C6 : Value < 0
		assertEquals(DateUtil.minuteString(-20), "-20 Minutes");
	}
	
}
	

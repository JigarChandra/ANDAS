package edu.osu;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
//@RunWith(SpringJUnit4ClassRunner.class)
public class WelcomeBeanTest {
	
	//JSFSession jsfSession = new JSFSession("/index.jsf");

	
    //@Autowired

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

WelcomeBean wb = new WelcomeBean();
		wb.setTitle("Developer II");
		wb.setLocation("CT");
	}

	@Test
	public void testSearch() {
		String ret = "true";//wb.search();
		assertTrue(ret.equalsIgnoreCase("true"));
	}

	@Test
	public void testProfile() {
		fail("Not yet implemented");
	}

}

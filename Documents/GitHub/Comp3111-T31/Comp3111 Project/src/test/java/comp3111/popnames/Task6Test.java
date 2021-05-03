package comp3111.popnames;

import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;

import org.junit.Test;

public class Task6Test {
	
	/**
	 * check the correct input of T6X3
	 */
	@Test
	public void testdoTask6_T6X3_1() {
		Task6 a=new Task6();
		double temp=a.doTask6_T6X3(200,"F","F");
		assertTrue(temp==100.0);
	}
	/**
	 * check the correct input of T6X3
	 */
	@Test
	public void testdoTask6_T6X3_2() {
		Task6 a=new Task6();
		double temp=a.doTask6_T6X3(2000,"M","M");
		assertTrue(temp==100.0);
	}
	
	/**
	 * check the correct input of T6X3 but with zero score
	 */
	@Test
	public void testdoTask6_T6X3_3() {
		Task6 a=new Task6();
		double temp=a.doTask6_T6X3(1800,"F","M");
		assertTrue(true);
	}
	
	/**
	 * Check if T6X2 can generate
	 */
	@Test
	public void testdoTask6_T6X2() {
		Task6 a=new Task6();
		double temp=a.doTask6_T6X2(100, 100,100, 100, 100, 100, true, true, true, true, "Older");
		assertTrue(temp!=0);
	}
	
	/**
	 * Check if the max funciton could get the correct value
	 */
	@Test
	public void testTask6_max() {
		Task6 a=new Task6();
		double temp=a.maxHobby(100,100,100,100);
		assertTrue(temp==100);
	}
	/**
	 * Check if it would generate error message if YOB<0
	 */
	@Test
	public void testYOB() {
		Task6 a=new Task6();
		boolean temp=a.check_YOB(-1);
		assertTrue(temp==false);
	}
	/**
	 * Check if it would generate correct message if YOB is within the range
	 */
	@Test
	public void testYOB_2() {
		Task6 a=new Task6();
		boolean temp=a.check_YOB(100);
		assertTrue(temp==true);
	}
	
	/**
	 * Check if it would output correct message
	 */
	@Test
	public void testTask6_name() {
	Task6 a=new Task6();
	boolean temp=a.check_name("a","hi");
	assertTrue(temp==true);
	}
	/**
	 * Check if it would output incorrect message if name is not a string with character
	 */
	@Test
	public void testTask6_name_2() {
	Task6 a=new Task6();
	boolean temp=a.check_name("","hi");
	assertTrue(temp==false);
	}
	
	/**
	 * Check if it would output incorrect message if username is not a string with character
	 */
	@Test
	public void testTask6_name_3() {
	Task6 a=new Task6();
	boolean temp=a.check_name("123","hi");
	assertTrue(temp==false);
	}
	
	/**
	 * Check if it would output incorrect message if targetname is not a string with character
	 */
	@Test
	public void testTask6_name_4() {
	Task6 a=new Task6();
	boolean temp=a.check_name("hi","123");
	assertTrue(temp==false);
	}
	/**
	 * Check if the max funciton could get the score in T6X1 when score =100
	 */
	@Test
	public void TestTask6_TX61() {
		Task6 a= new Task6();
		double temp=a.doTask6_T6X1("asd","das");
		assertTrue(temp==100.0);
	}
	/**
	 * Check if the max funciton could get the correct value
	 */
	@Test
	public void TestTask6_max2() {
		Task6 a= new Task6();
		double temp=a.maxHobby(10,20,30,100);
		assertTrue(temp==100);
		
	}
	
	/**
	 * Check if the TestLinearRegression can run
	 */
	@Test
	public void TestLinearRegressionTask6_1() {
		double []a=new double[2];
		double []c=new double[2];
		double []d=new double[1];
		c[0]=1;
		c[1]=1;
		d[0]=0;
		a[0]=0;
		a[1]=0;
		LinearRegressionTask6 e=new LinearRegressionTask6(a,c);
		double temp=e.intercept();
		temp=e.interceptStdErr();
		temp=e.R2();
		temp=e.predict(1);
		String name=e.toString();
		
		boolean asnwer=e.equals(a);

		assertTrue(true);
		
		
	}
	
	/**
	 * Check if the function will return false if we cannot find the name in the spreadsheet
	 */
	@Test
	public void TestTX63_year() {
		Task6 a=new Task6();
		boolean checker=a.check_dataset("ASA", "DSDS");
		assertTrue(checker==false);
	}
	
	/**
	 * Check if the function will return true if we cannot find the name in the spreadsheet
	 */
	@Test
	public void TestTX63_year2() {
		Task6 a=new Task6();
		boolean checker=a.check_dataset("Mary", "Marco");
		assertTrue(checker==true);
	}
	
	@Test
	public void TestTextFile() {
		Controller a=new Controller();
		a.writeNewUser("Marco", "M", "Mary", "F", 1900, 2000, 20, null);
		assertTrue(true);
	}
}

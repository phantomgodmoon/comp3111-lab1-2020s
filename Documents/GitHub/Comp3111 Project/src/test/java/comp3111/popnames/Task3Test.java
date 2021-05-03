package comp3111.popnames;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import comp3111.popnames.Task3.DataInTableView;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static org.junit.Assert.*;

public class Task3Test extends ApplicationTest {
	
	//Check the valid output
	@Test
	public void testYear1() {
		Task3 a = new Task3();
		boolean check=a.check_input(1900, 2000, "HI", 'M');
		assertTrue(check==(true));
		}
	//Check the invalid year in which ending year<starting year
	@Test 
	public void testYear2() {
		Task3 a = new Task3();
		boolean check=a.check_input(1900, 1890, "HI", 'M');
		assertTrue(check==(false));
	}
	
	//Check the invalid year in which starting year is too small.
	@Test 
	public void testYear3() {
		Task3 a = new Task3();
		boolean check=a.check_input(1000, 2000, "HI", 'M');
		assertTrue(check==(false));
	}
	
	//Check the invalid year in which ending year is too large.
	@Test 
	public void testYear4() {
		Task3 a = new Task3();
		boolean check=a.check_input(1900, 3000, "HI", 'M');
		assertTrue(check==(false));
	}
	
	//Check the invalid gender where gender is not 'M' or 'F'
	@Test
	public void testGender1() {
		Task3 a = new Task3();
		boolean check=a.check_input(1900, 2000, "HI", 'A');
		assertTrue(check==(false));
	}
	//Check the invalid gender where gender is not 'M' or 'F'
	@Test
	public void testGender2() {
		Task3 a = new Task3();
		boolean check=a.check_input(1900, 2000, "HI", 'm');
		assertTrue(check==(false));
	}
	//Check the valid gender.
	@Test
	public void testGender3() {
		Task3 a = new Task3();
		boolean check=a.check_input(1900, 2000, "HI", 'M');
		assertTrue(check==(true));
	}
	
	//Check the valid name
	@Test
	public void testName1() {
		Task3 a = new Task3();
		boolean check=a.check_input(1900, 2000, "Marco", 'M');
		assertTrue(check==true);
	}
	
	//check the invalid name where the name of interest contains non-character.
	@Test
	public void testName2() {
		Task3 a = new Task3();
		boolean check=a.check_input(1900, 2000, "M2rco", 'M');
		assertTrue(check==false);
	}
	
	//check the invalid name where the name of interest has number of character <2.
	@Test
	public void testName3() {
		Task3 a = new Task3();
		boolean check=a.check_input(1900, 2000, "M", 'M');
		assertTrue(check==false);
	}
	//check the invalid name where the name of interest has number of character >16.
	@Test
	public void testName4() {
		Task3 a = new Task3();
		boolean check=a.check_input(1900, 2000, "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMM", 'M');
		assertTrue(check==false);
	}
	//check if the funciton can generate the required array
	@Test
	public void data1() {
		Task3 a = new Task3();
		int [][] check=a.getNumberOfSameGenderOfYear(1900,1901,"Mary","F");
		assertTrue(true);
	}
	
	//check if the function can generate the correct number
	@Test
	public void data2() {
		Task3 a = new Task3();
		int [][] check=a.getNumberOfSameGenderOfYear(1900,1901,"Mary","F");
		int year=a.getYearOfMostPopular(check);
		assertTrue(year==1900);
	}
	
	//check if the functions in tableView function well
	@Test
	public void tableView() {
		Task3 a = new Task3();
		DataInTableView check=new DataInTableView("1000","1000","1000","1000");
		check.setYear(null);
		check.setRank(null);
		check.setOccurence(null);
		check.setPercentage(null);	
		assertTrue(check.getOccurence()==null&&check.getRank()==null&&check.getYear()==null&&check.getPercentage()==null);
	}
	
	
//	//check if it can generate the chart
//	@Test
//	public void doBarChartTask3() {
//		Controller a=new Controller();
//		a.doBarChartTask3();
//		assertTrue(true);
//		
//	}
//	//check if it can generate the chart
//
//	@Test
//	public void doLineChartTask3() {
//		Controller a=new Controller();
//		a.doLineChartTask3();
//		assertTrue(true);
//		
//	}
//	//check if it can generate the chart
//
//	@Test
//	public void doTableViewTask3() {
//		Controller a=new Controller();
//		a.doTableViewTask3();
//		assertTrue(true);
//		
//	}
}

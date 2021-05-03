package comp3111.popnames;

import org.apache.commons.csv.*;
import edu.duke.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class Task3 {

	/**
	 * Read the spreadsheet
	 * @param year
	 * @return
	 */
	public static CSVParser getFileParser(int year) {
	     FileResource fr = new FileResource(String.format("dataset/yob%s.csv", year));
	     return fr.getCSVParser(false);
		}
	
	/**
	 * generate an array storing the information
	 * @param startingYear
	 * @param endingYear
	 * @param name
	 * @param gender
	 * @return
	 */
	public static int[][] getNumberOfSameGenderOfYear(int startingYear,int endingYear, String name,String gender) {
		int dataStore[][]=new int[140][4];
		int totalBirthsOfTheSameGender=0;
		int numOfAppearance=0;
		for(int row=0;row<140;row++)
			for(int col=0;col<4;col++) {
				dataStore[row][col]=0;
			}
		for(int year=startingYear;year<endingYear;year++) {   //check every year within the range
			dataStore[year-startingYear][0]=year;
			int rank =0;  //rank is used to store the ranking
		for (CSVRecord rec : getFileParser(year)) {   // check every column to find the name of interest
			rank++; // the first row is the most popular (rank one).   
			if(rec.get(1).equals(gender)){ 
				totalBirthsOfTheSameGender=totalBirthsOfTheSameGender+Integer.parseInt(rec.get(2)); //Count if same gender
				if (rec.get(0).equals(name)){  // if the target is found.
				numOfAppearance = Integer.parseInt(rec.get(2));
				dataStore[year-startingYear][1]=rank;              //Store the ranking
				dataStore[year-startingYear][2]=numOfAppearance;  //Store the number of Occurrence
				
			}
		}
		}
		dataStore[year-startingYear][3]=totalBirthsOfTheSameGender;  //Store the totalBirthsOfTheSameGender
		}
		return dataStore;
	}
	
	/**
	 * Get the most poupular Year
	 * @param data
	 * @return
	 */
	public static int getYearOfMostPopular(int data[][]) {
		int HighestRankingFound=1001;
		int HighestRankingFoundOfYear=0;
		for(int row=0;row<140;row++) {
			if(data[row][0]==0) {break;}   
			if(data[row][1]<HighestRankingFound&& data[row][1]!=0) {
				
				HighestRankingFound=data[row][1];
				HighestRankingFoundOfYear=data[row][0];
			}
		}
			return HighestRankingFoundOfYear;
			// return the Year of most popular.
	}
	

	/**
	 * Check the input
	 * @param startingYear
	 * @param endingYear
	 * @param nameOfInterest
	 * @param genderOfInterest
	 * @return
	 */
	@FXML
	public static boolean check_input(int startingYear, int endingYear, String nameOfInterest, char genderOfInterest) {
		
		if(startingYear<1880 || startingYear >2019) {
			JFrame f;
			f=new JFrame();  
		    JOptionPane.showMessageDialog(f,"Invalid Range. The range of the Starting Year must be bigger than 1880"
		    		+ " and smaller than 2019."); 
			return false;
		}
		if(endingYear<1880 || endingYear>2019) {
			JFrame f;
			f=new JFrame();  
		    JOptionPane.showMessageDialog(f,"Invalid Range. The range of the Ending Year must be bigger than 1880"
		    		+ " and smaller than 2019.");
		    return false;
		}
		
		if(endingYear<startingYear) {
			JFrame f=new JFrame();  
		    JOptionPane.showMessageDialog(f,"Starting Year is bigger than Ending Year? How do you mean?");
		    return false;
		}
		if(nameOfInterest.length()<2||nameOfInterest.length()>15) {
			JFrame f;
			f=new JFrame();  
		    JOptionPane.showMessageDialog(f,"Invalid Name Of Interest. The Name Of Interest must be a string"
		    		+ " with minimum 2 characters and maximum 15 characters.");
		    return false;
		}
		for (int i=0; i<nameOfInterest.length();i++) {
			if ((Character.isLetter(nameOfInterest.charAt(i)) == false)) {
				JFrame f;
				f=new JFrame();  
			    JOptionPane.showMessageDialog(f,"Invalid Name Of Interest. The Name Of Interest must be a string "
			    		+ "containing characters only!");
			    return false;
			}
		}
		if(genderOfInterest!='M' && genderOfInterest!='F') {
			JFrame f=new JFrame();  
		    JOptionPane.showMessageDialog(f,"Invalid Gender Of Interest. The Gender of Interest must be either "
		    		+ "character 'M' or 'F'.");
		    return false;
		}
		return true;
	}
	/**
	 * Generate the dataView by ObservableList
	 * @author Marco
	 *
	 */
	static public class DataInTableView{
		private final SimpleStringProperty year;
	    private final SimpleStringProperty rank;
	    private final SimpleStringProperty occurence;
	    private final SimpleStringProperty percentage;
	 
	    public DataInTableView(String year, String rank, String occurence, String percentage) {
	        this.year = new SimpleStringProperty(year);
	        this.rank = new SimpleStringProperty(rank);
	        this.occurence = new SimpleStringProperty(occurence);
	        this.percentage=new SimpleStringProperty(percentage);
	    }
	 
	    public String getYear() {
	        return year.get();
	    }
	    public void setYear(String year) {
	        this.year.set(year);
	    }
	        
	    public String getRank() {
	        return rank.get();
	    }
	    public void setRank(String rank) {
	    	this.rank.set(rank);
	    }
	    
	    public String getOccurence() {
	        return occurence.get();
	    }
	    public void setOccurence(String occurence) {
	    	this.occurence.set(occurence);
	    }
	    
	    public String getPercentage() {
	        return percentage.get();
	    }
	    public void setPercentage(String percentage) {
	    	this.percentage.set(percentage);
	    }
	}
}


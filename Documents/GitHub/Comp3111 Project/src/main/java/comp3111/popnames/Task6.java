package comp3111.popnames;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;

import javax.print.attribute.standard.Media;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import org.apache.commons.csv.*;
import org.apache.xalan.templates.ElemValueOf;
import edu.duke.*;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Task6 {
	/**
	 * Check User Name
	 * @param userName
	 * @param targetName
	 * @return
	 */
	public static boolean check_name(String userName,String targetName) {
		
		if(userName.length()==0||targetName.length()==0) 
			{
				JFrame f=new JFrame();  
			    JOptionPane.showMessageDialog(f,"Invalid User Name. The User Name must be a string "
			    		+ "containing characters only!");
			    return false;
			}
		
		for (int i=0; i<userName.length();i++) {
			if ((Character.isLetter(userName.charAt(i)) == false)) {
				JFrame f=new JFrame();  
			    JOptionPane.showMessageDialog(f,"Invalid User Name. The User Name must be a string "
			    		+ "containing characters only!");
			    return false;
			}
		}

		for (int i=0; i<targetName.length();i++) {
			if ((Character.isLetter(targetName.charAt(i)) == false)) {
				JFrame f=new JFrame();  
			    JOptionPane.showMessageDialog(f,"Invalid Name Of Interest. The Name Of Interest must be a string "
			    		+ "containing characters only!");
			    return false;
			}
		}
		return true;
	}
	/**
	 * Check YOB
	 * @param YOB
	 * @return
	 */
	public static boolean check_YOB(int YOB) {
		if(YOB<0) {	
			JFrame f=new JFrame();  
		    JOptionPane.showMessageDialog(f,"How come you come before the god?");
			return false;
		}
		return true;
	}
	
	/**
	 * The function focuses on the required algorithm T6X1
	 * If length of string is the same, 100, otherwise 0.
	 * @param userName
	 * @param TargetName
	 * @return
	 */
	static double doTask6_T6X1(String userName, String TargetName) {
		if (userName.length()==TargetName.length()) {
			return 100;
		} else return 0;
	}
	
	
	/**
	 * This function focuses on data reporting skill, Normalize the Data.
	 * @param userYOB
	 * @param targetYOB
	 * @param gamingScore
	 * @param netflixScore
	 * @param readingScore
	 * @param sportScore
	 * @param erudite
	 * @param sporty
	 * @param hipster
	 * @param sociable
	 * @param preferenece
	 * @return
	 */
	static double doTask6_T6X2(int userYOB, int targetYOB, double gamingScore, double netflixScore,double readingScore,double sportScore, boolean erudite,boolean sporty,boolean hipster,boolean sociable, String preferenece) {
		double max=maxHobby(gamingScore,netflixScore,readingScore,sportScore);
		double normalized_gamingScore=gamingScore/max;
		double normalized_netflixScore=netflixScore/max;
		double normalized_readingScore=readingScore/max;
		double normalized_sportScore=sportScore/max;
		double compatibility=0;
		if(sporty) {
			compatibility=compatibility+normalized_sportScore/5*100;
		}
		if(hipster) {
			compatibility=compatibility+normalized_readingScore/5*100;
			
		}
		if(sociable) {
			compatibility=compatibility+normalized_gamingScore/5*100;
			
		}
		if(erudite) {
			compatibility=compatibility+normalized_netflixScore/5*100;
			
		}
		int age_difference=userYOB-targetYOB;
		if((preferenece.equalsIgnoreCase("Older") && age_difference>=0)||(preferenece.equalsIgnoreCase("Younger") && age_difference<=0)) {
			compatibility=compatibility+20;
			
		}
		
		return compatibility;
	}
	
	
	/**This Task focuses on the demonstration of Audio and Image.
	 * Target homosexuality, ghost, and heterosexual cases.
	 * @param YOB
	 * @param userGender
	 * @param targetGender
	 * @return
	 */
	static double doTask6_T6X3(int YOB, String userGender, String targetGender) {
		if (userGender==targetGender && userGender=="F") {
			doGeneratePhoto("F");
			return 100.0;
		} 
		else if(userGender==targetGender && userGender=="M") {
			doGeneratePhoto("M");
			return 100.0;
		}
		else if(YOB<1900) {
			doGeneratePhoto("G");
			return 100;
		}
	return 0;
	}
	
	static void doGeneratePhoto(String type) {
		if(type=="F") {

		}
		
		if(type=="M") {
			
		}
		
		if(type=="G") {

		}
		
	}
	/**
	 * Find the max value of 4 score
	 * @param gamingScore
	 * @param netflixScore
	 * @param readingScore
	 * @param sportScore
	 * @return
	 */
	static double maxHobby(double gamingScore, double netflixScore,double readingScore,double sportScore) {
		double max=0;
		if(gamingScore>max) {
			max=gamingScore;
		}
		if(netflixScore>max) {
			max=netflixScore;
		}
		if(readingScore>max) {
			max=readingScore;
		}
		if(sportScore>max) {
			max=sportScore;
		}
		
		return max;
	}
	
	/**
	 * CHeck if the name is inside the database
	 * @param userName
	 * @param targetName
	 * @return
	 */
	static Boolean check_dataset(String userName, String targetName) {
		String message=null;
		boolean correctUserName=false;
		boolean correctTargetName=false;
		for(int year=1900;year<2001;year++)   //check every year within the range
		for (CSVRecord rec : Task3.getFileParser(year)) {   // check every column to find the name of interest
			if(rec.get(0).equals(targetName)){  // if the target is found
				correctTargetName=true;
			}
			if(rec.get(0).equals(userName)){  // if the target is found
				correctUserName=true;
			}	
		}
		
		if((!correctUserName)||(!correctTargetName)) {
			return false;
		}
		else return true;
		
	}
}

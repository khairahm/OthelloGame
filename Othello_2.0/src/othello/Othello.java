/*
 * File Name: Othello.java
 * Author: Khair Ahmed , 040946481
 * Course: CST8233 Lab Section: 313
 * Assignment: Assignment 2 part 1
 * Date: November 22 2020
 * Purpose: To run the game
 * Class List: OthelloViewController, Controller, OthelloModel, Othello, OthelloNetworkModalViewController
 *
 * 
 */
package othello;

import java.awt.EventQueue;
/**
 *  Creates the Splash Screen
 * @author Khair Ahmed
 * @version 1.0
 * @see  java.swing 
 * @see java.awt
 * @see OthelloViewController
 * @see OthelloSplashScreen
 */
public class Othello {
	/**
	 * Main method that run that loads the splash screen and Then the gui
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  int duration = 5000;
		 // Create the screen
		  OthelloSplashScreen splash = new OthelloSplashScreen(duration);
	    //Show the Splash screen 
		  splash.showSplashWindow();
	    //Create and display the main application GUI
	    EventQueue.invokeLater(new Runnable(){
	       @Override
	       public void run(){ 	
	    	   OthelloViewController ovc = new OthelloViewController();
				
				ovc.setVisible(true);
	       }
	     });
	  }//end main
	}// end SplashScreenDemo class



/*
 * File Name: OthelloViewController
 * Author: Khair Ahmed , 040946481
 * Course: CST8233 Lab Section: 313
 * Assignment: Assignment 2 part 1
 * Date: November 22 2020
 * Purpose:	Will create the GUI and perform all mouse clicks
 * Class List: OthelloViewController, Controller, OthelloModel, Othello, OthelloNetworkModalViewController
 * 
 */
package othello;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;
/**
 *  Creates the Splash Screen
 * @author Khair Ahmed
 * @version 1.0
 * @see  java.swing 
 * @see java.awt
 */
public class OthelloSplashScreen extends JWindow {
	/**
	 * time that the splash will load for
	 */
	private final int duration;
	/**
	 * creates splash screen
	 * @param duration
	 */
	public OthelloSplashScreen(int duration) {
		this.duration=duration;
	}
	/**
	 Shows a splash screen in the center of the desktop
	 for the amount of time given in the constructor.
	*/
	  public void showSplashWindow() {
	   //create content pane
		
	     JPanel content = new JPanel(new BorderLayout());
	   // or use the window content pane
	   //  JPanel content = (JPanel)getContentPane();
	     content.setBackground(Color.GRAY);
	    
	    // Set the window's bounds, position the window in the center of the screen
	    int width =  1010;
	    int height = 640;
	    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (screen.width-width)/2;
	    int y = (screen.height-height)/2;
	    //set the location and the size of the window
	    setBounds(x,y,width,height);

	  
	      
	   ///acessing image in image file
	JLabel label = new JLabel(new ImageIcon("image/splash.gif"));


	 //Title for the game 
	    JLabel demo = new JLabel("Khair's Othello Client", JLabel.CENTER);
	    demo.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 14));
	    content.add(label, BorderLayout.CENTER);
	    content.add(demo, BorderLayout.SOUTH);
	   
	    
	    //replace the window content pane with the content JPanel
	      setContentPane(content);

	    //make the splash window visible
	    setVisible(true);

	    // Snooze for awhile, pretending the code is loading something awesome while
	    // our splashscreen is entertaining the user.
	    try {
	    	
	    	 Thread.sleep(duration); }
	    catch (InterruptedException e) {/*log an error here?*//*e.printStackTrace();*/}
	    //destroy the window and release all resources
	    dispose(); 
	    //You can hide the splash window. The resources will not be released.
	    //setVisible(false);
	  }
}

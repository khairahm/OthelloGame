/*
 * File Name: OthelloNetworkModalViewController.java
 * Author: Khair Ahmed , 040946481
 * Course: CST8233 Lab Section: 313
 * Assignment: Assignment 2 part 1
 * Date: November 22 2020
 * Purpose: To control and create the modal view
 * Class List: OthelloViewController, Controller, OthelloModel, Othello, OthelloNetworkModalViewController
 *
 * 
 */
package othello;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JPanel;

/**
 * Create the view and has a controlls of the modal
 * @author Khair Ahmed
 *
 */
public class OthelloNetworkModalViewController extends JDialog
{

    /** Whether the user pressed the Connect button. */
    private Boolean hasConnected=false;
    
    /** A reference to the private inner Controller class for use by the two buttons. */
    private Controller handler = new Controller();
    
    /** The CombobBox you will need to create.*/
    //NOTE:  You're free to rename it, but as there are some references to it in this stub,
    //you'll need to be consistent when renaming them all.
   //default values for port
    private String val[] ={"","31000", "41000", "51000" };
    private JComboBox<String> portInput;
    /** The text field where the user will enter the hostname to connect to.*/
    //As above, you're free to rename this.  But be careful.
    private JTextField addressInput;

    //These are suggested implementations.  You're free to tackle it differently of course.\
    //panels for the view
    private JPanel mainPanel;
    private JPanel addressPanel;
    private JPanel portPanel;
    private JPanel statusPanel;
    private JPanel btnPanel;
    //conponets for controller
    private JLabel addressLabel;
    private JLabel portLabel;
    private JLabel statusLabel;
    private JButton connectBtn;
    private JButton cancelBtn;
public OthelloNetworkModalViewController (JFrame mainView)
    {
        //In Swing, it's ideal if we provide reference frame this will sit atop.
        //The title isn't relevant since we want this to be an undecorated dialog.
        super(mainView,"Enter Network Address",true);
        
        //Important note!  Uncomment this line ONLY when you're nearly ready.
        //It'll be a lot harder to get rid of the modal when it's undecorated.
        //So save uncommenting this for nearly last, when you've debugged everything
        //and you're doing your final testing.
        
        setUndecorated(true); 
        
        //This will hold your UI.  You may rename it if you want to.
        Container networkPanel = getContentPane();
      
        mainPanel = new JPanel();
        //Create 5px border with 5 pixel gap
        mainPanel.setBorder(BorderFactory.createCompoundBorder(new LineBorder(Color.GRAY, 5), new EmptyBorder(5, 5, 5, 5)));
        mainPanel.setLayout(new GridLayout(4,1));
        networkPanel.add(mainPanel);
        addressPanel =new JPanel();
        portPanel =new JPanel();
        statusPanel =new JPanel();
        btnPanel =new JPanel();
  
        
        //Set flow layout
        addressPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        portPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        statusPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        btnPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        
        //short cut for Alt A
        addressLabel = new JLabel("Address: ");
        addressLabel.setDisplayedMnemonic(KeyEvent.VK_A);
        //shortcut for Alt P
        portLabel =    new JLabel("Port: ");
        portLabel.setDisplayedMnemonic(KeyEvent.VK_P);
        statusLabel = new JLabel("Status: ");
      //add and create rest of componet
        addressPanel.add(addressLabel);
        portPanel.add(portLabel);
        statusPanel.add(statusLabel);
        
        addressInput = new JTextField();
        addressLabel.setLabelFor(addressInput);
       
        addressInput.setColumns(20);
       
        addressPanel.add(addressInput);
        portInput = new JComboBox<String>(val);
       
        portInput.setEditable(true);
        portLabel.setLabelFor(portInput);
        portPanel.add(portInput);
    
        connectBtn = new JButton("Connect");
        connectBtn.addActionListener(handler);
        connectBtn.setActionCommand("C");
        cancelBtn = new JButton("Cancel");
        cancelBtn.addActionListener(handler);

        cancelBtn.setActionCommand("X");
        btnPanel.add(connectBtn);
        btnPanel.add(cancelBtn);
        mainPanel.add(addressPanel);
        mainPanel.add(portPanel);
        mainPanel.add(statusPanel);
        mainPanel.add(btnPanel);
        

        //Now you're on your own!  Put your own UI in here.
        //Stick to GridLayout, BorderLayout and FlowLayout this
        //time around.
    
        
        
        
        
        //This statement should be the last one.
        pack();
    }
        



    /** This method returns the value the user has entered.
        @return The actual value, unless there was an error or the user pressed the cancel button.
    */

    public String getAddress()
    {
        if (hasConnected && getPort()!=-1) // added check for if number is in range
        {
            return (addressInput.getText());
        }
        else
        {
            //You can return whatever error message you like.  This isn't cast in stone.
            return ("Error:  Invalid Address or attempt cancelled.");
        }
    }

    /** This method returns the port the user has selected OR ENTERED in the Combo Box.
    @return The port selected.  Returns -1 on invalid port or cancel pressed.
    */
    
    public int getPort()
    {
        int portnum;
        if (hasConnected)
        {
            //Ensure the user has entered digits.
            //You should probably also ensure the port numbers are in the correct range.
            //I did not.  That's from 0 to 65535, by the way.  Treat it like invalid input.
            try
            {
            	if(portInput.getSelectedIndex()==-1) {
            	portnum = Integer.parseInt((String)portInput.getEditor().getItem());	
            	}else {
                portnum = Integer.parseInt((String)portInput.getSelectedItem());
            	}
            	
            	if(portnum <0 || portnum>65535) {
            		portnum =-1;
            		statusLabel.setText("Status: Not Connected");
            	}else {
            		statusLabel.setText("Status: Connected");
            	}
                
                
            }
                catch(NumberFormatException nfe)
            {
                //I've been using a negative portnum as an error state in my main code.
                portnum = -1;
            }

            return portnum;
        }
        return -1;
    }
    
    /** Responsible for final cleanup and hiding the modal. Does not do much at the moment.*/
    public void hideModal()
    {
        //Add any code that you may want to do after the user input has been processed
        //and you're figuratively closing up the shop.
        setVisible(false);
        
    }
    
    /** Returns whether or not the user had pressed connect.
    @return True if the user pressed Connect, false if the user backed out with cancel.
    */
    public boolean pressedConnect()
    {
        return hasConnected;
    }
    
    /** The Controller for managing user input in the network dialogue.
    @author Khair Ahmed
    @version 1.3
    @since 1.8.0_261
    @see OthelloViewController
    */
    
    private class Controller implements ActionListener
    {
        public void actionPerformed(ActionEvent evt)
        {
            String s = evt.getActionCommand();
           
            //I set the action command on my connect button to "C".
            if ("C".equals(s))
            {
                //In Assignment 2-2, we will be making revisions here.
                //This would be a great place to update the "Status" portion of the UI.
            
            	
            	
                hasConnected=true;
             	
            
            }else {
            	statusLabel.setText("Status: Not Connected");
            	 hasConnected=false;
            }
            //Hide the modal. For part 2, we may not want to hide the modal right away.
            hideModal();
        }

	
	
        
    }
}
        

        


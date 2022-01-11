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
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

/**
 * Creates the View and give buttons functions
 * 
 * @author Khair Ahmed
 * @version 1.0
 * @see java.swing java.awt
 */
public class OthelloViewController extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Controls all mouse event
	 */
	private Controller controller;
	/**
	 * container where all other panels are places
	 */
	private Container mainContainer;
	/**
	 * black piece one
	 */
	private ImageIcon currentBlkImage;
	/**
	 * black piece two
	 */

	private ImageIcon currentWhiteImage;

	/**
	 * panel for the game board
	 */
	private JPanel gamePanel;
	/**
	 * panel for outputs
	 */
	private JPanel chatPanel;
	/**
	 * where the textfield and submit button panels are
	 */
	private JPanel bottomPanel;
	/**
	 * panel show moves
	 */
	private JPanel showMovePanel;

	// private JLabel showMoveLabel;
	/**
	 * check box that shows user possible moves
	 */
	private JCheckBox showMoveBox;
	/**
	 * panel where all prompts exist
	 */
	private JPanel promptPanel;
	/**
	 * where the panel outputs information
	 */
	private JTextArea promptArea;
	/**
	 * panel that holds all information panels
	 */
	private JPanel piecePanel;
	/**
	 * 1 half of info panel shows text
	 */
	private JPanel textInfoPanel;
	/**
	 * second half of info panel shows photos
	 */
	private JPanel photoInfoPanel;
	/**
	 * game field
	 */
	private JLabel[][] field;
	/**
	 * game board number buttons
	 */
	private JButton[] numButtons;
	/**
	 * game board letter buttons
	 */
	private JButton[] letterButtons;
	/**
	 * move button to control the movement
	 */
	private JButton moveBtn;
	/**
	 * holds the letters for the buttons that require the buttons
	 * 
	 * @value A,B,C,D,E,F,G,H
	 */
	private static final String letters[] = { "A", "B", "C", "D", "E", "F", "G", "H" };
	/**
	 * user chat field
	 */
	private JTextField chat;
	/**
	 * submit chat button
	 */
	private JButton sumbit;
	/**
	 * label for black photo
	 */
	private JLabel blackInfo;
	/**
	 * label for white phot
	 */
	private JLabel whiteInfo;
	/**
	 * photo of black piece
	 */
	private JLabel blkPhotoInfo;
	/**
	 * photo of white photo
	 */
	private JLabel whtPhotoInfo;
	/**
	 * hold player 1 value
	 */
	public static int BLACK = 1;
	/**
	 * hold player 2 value
	 */
	public static int WHITE = 2;
	/**
	 * hold player 0 value
	 */
	public static int EMPTY = 0;
	/*
	 * black piece image
	 */
	private ImageIcon blackImage;
	/*
	 * white piece image
	 */
	private ImageIcon whiteImage;
	/**
	 * bat image
	 */
	private ImageIcon batImage;
	/*
	 * pumpkin image;
	 */
	private ImageIcon pumpkinImage;
	/**
	 * cat image
	 */
	private ImageIcon catImage;
	
	/**
	 * dog image
	 */
	private ImageIcon dogImage;
	/**
	 * check image;
	 */
	private ImageIcon checkImage;
	/**
	 * holds all game data
	 */
	private OthelloModel model;
	/**
	 * controls for the button
	 */
	private GameButtonHandler gbController;
	/**
	 * main menu
	 * 
	 */
	private JMenuBar mainMenu;
/**file menu
 * 
 */
	private JMenu fileMenu;
	/*
	 * new game option
	 */
	private JMenuItem newGameItem;
	/**
	 * load game Option
	 */
	private JMenuItem loadGameItem;
	/**
	 * save Game option
	 */
	private JMenuItem saveGameItem;
	/**
	 * exit game option
	 */
	private JMenuItem exitGameItem;
	/**game menu
	 * 
	 */
	private JMenu gameMenu;
	/**
	 * reskin menu
	 */
	private JMenu reskinSubMenu;
	/*
	 * group for the buttons
	 */
	private ButtonGroup reskinGroup;
	/**
	 * lets user select normal irons
	 */
	private JRadioButtonMenuItem nrmlIconItem;
	/**
	 * lets user select cats and dogs
	 */
	private JRadioButtonMenuItem catIconItem;
	/**
	 * lets user select bats and pumpkins
	 */
	private JRadioButtonMenuItem batIconItem;
	/**
	 * debug submenu
	 */
	private JMenu debugSubMenu;
	/**
	 * group for debug test
	 */
	private ButtonGroup debugGroup;
	/**
	 * allows user to test games
	 */
	private JRadioButtonMenuItem nrmlTest;
	/**
	 * allows user to test games
	 */
	private JRadioButtonMenuItem cornerTest;
	/**
	 * allows user to test games
	 */
	private JRadioButtonMenuItem sideTest;
	/**
	 * allows user to test games
	 */
	private JRadioButtonMenuItem cap1Test;
	/**
	 * allows user to test games
	 */
	private JRadioButtonMenuItem cap2Test;
	/**
	 * allows user to test games
	 */
	private JRadioButtonMenuItem empTest;
	/**
	 * allows user to test games
	 */
	private JRadioButtonMenuItem inSqrTest;
	/**
	 * help menu
	 */
	private JMenu helpMenu;
	/** 
	 * about page
	 */
	private JMenuItem aboutItem;

	private JMenu networkMenu;
	private JMenuItem connectionItem;
	private JMenuItem disconnectItem;
	private OthelloNetworkModalViewController networkDialog ;

	/**
	 * Construct that creates the view
	 */
	public OthelloViewController() {
		// Give the GUI a name
		super("Khair's Othello Client");
		// Initialize controller
		controller = new Controller();
		gbController = new GameButtonHandler();

		model = new OthelloModel();
		// set window size and make sure it is not resizeable
		this.setSize(1010, 640);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		// controls where the object are being place
		GridBagConstraints gbc = new GridBagConstraints();
		// Create container for the page
		mainContainer = this.getContentPane();
		mainContainer.setLayout(new BorderLayout());
		this.setLocationRelativeTo(null);
		mainContainer.setBackground(Color.gray);
		// Create game panel and demensions
		gamePanel = new JPanel();
		gamePanel.setBackground(Color.GRAY);
		gamePanel.setPreferredSize(new Dimension(550, 500));
		gamePanel.setBorder(new LineBorder(Color.GRAY, 5));
		gamePanel.setVisible(true);
		gamePanel.setLayout(new GridBagLayout());
		// Field is 8 by 8 so create a 2d array
		field = new JLabel[8][8];
		// create the buttons with numbers
		numButtons = new JButton[8];
		// Create the buttons that contain letter labels
		letterButtons = new JButton[8];
		mainMenu = new JMenuBar();
		this.setJMenuBar(mainMenu);

		fileMenu = new JMenu("File");
		mainMenu.add(fileMenu);
		mainMenu.add(fileMenu);

		newGameItem = new JMenuItem("New Game");
		fileMenu.add(newGameItem);
		newGameItem.addActionListener(controller);
		loadGameItem = new JMenuItem("Load Game");
		loadGameItem.setEnabled(false);
		fileMenu.add(loadGameItem);
		saveGameItem = new JMenuItem("Save Game");
		saveGameItem.setEnabled(false);
		fileMenu.add(saveGameItem);
		exitGameItem = new JMenuItem("Exit Game");
		fileMenu.add(exitGameItem);
		exitGameItem.addActionListener(controller);
		gameMenu = new JMenu("Game");
		mainMenu.add(gameMenu);
		reskinSubMenu = new JMenu("Reskin Pieces");
		networkDialog = new OthelloNetworkModalViewController(this);
		reskinGroup = new ButtonGroup();
		nrmlIconItem = new JRadioButtonMenuItem("Normal Pieces (black and white)");
		nrmlIconItem.setSelected(true);
		nrmlIconItem.addActionListener(controller);
		reskinGroup.add(nrmlIconItem);
		reskinSubMenu.add(nrmlIconItem);

		catIconItem = new JRadioButtonMenuItem("Cats vs. Dogs");
		catIconItem.addActionListener(controller);
		reskinGroup.add(catIconItem);
		reskinSubMenu.add(catIconItem);

		batIconItem = new JRadioButtonMenuItem("Pumpskins vs. Bats");
		batIconItem.addActionListener(controller);
		reskinGroup.add(batIconItem);
		reskinSubMenu.add(batIconItem);
		gameMenu.add(reskinSubMenu);

		debugSubMenu = new JMenu("Debug Test");

		debugGroup = new ButtonGroup();
		nrmlTest = new JRadioButtonMenuItem("Normal Test");
		nrmlTest.setSelected(true);
		nrmlTest.addActionListener(controller);
		debugGroup.add(nrmlTest);
		debugSubMenu.add(nrmlTest);

		cornerTest = new JRadioButtonMenuItem("Corner Test");
		cornerTest.addActionListener(controller);
		debugGroup.add(cornerTest);
		debugSubMenu.add(cornerTest);

		sideTest = new JRadioButtonMenuItem("Side Test");

		debugGroup.add(sideTest);
		debugSubMenu.add(sideTest);
		sideTest.addActionListener(controller);
		cap1Test = new JRadioButtonMenuItem("1x Capture Test");
		cap1Test.addActionListener(controller);
		debugGroup.add(cap1Test);
		debugSubMenu.add(cap1Test);
		cap2Test = new JRadioButtonMenuItem("2x Capture Test");
		cap2Test.addActionListener(controller);
		debugGroup.add(cap2Test);
		debugSubMenu.add(cap2Test);
		empTest = new JRadioButtonMenuItem("Empty Board");
		empTest.addActionListener(controller);
		debugGroup.add(empTest);
		debugSubMenu.add(empTest);
		inSqrTest = new JRadioButtonMenuItem("Inner Test");
		inSqrTest.addActionListener(controller);
		debugGroup.add(inSqrTest);
		debugSubMenu.add(inSqrTest);
		gameMenu.add(debugSubMenu);
		networkMenu = new JMenu("Network");
		mainMenu.add(networkMenu);
		connectionItem = new JMenuItem("New Connection");
		connectionItem.addActionListener((ActionEvent avt)->newConnectionMenu());
		disconnectItem = new JMenuItem("Disconnect");
		disconnectItem.addActionListener((ActionEvent avt)->disconnectionMenu());
		networkMenu.add(connectionItem);
		networkMenu.add(disconnectItem);
		helpMenu = new JMenu("Help");
		mainMenu.add(helpMenu);

		aboutItem = new JMenuItem("About");
		aboutItem.addActionListener(controller);
		helpMenu.add(aboutItem);

		/*
		 * use a nested for loop inorder to create the field set the colur based on
		 * where it is and add the field too the panel
		 */
		for (int i = 0; i < 8; i++) {
			gbc.gridx = i;
			for (int j = 0; j < 8; j++) {

				gbc.gridy = j;
				field[i][j] = new JLabel();
				field[i][j].setPreferredSize(new Dimension(60, 60));
				if ((i + j) % 2 != 1) {
					field[i][j].setBackground(Color.BLACK);
				} else {
					field[i][j].setBackground(Color.WHITE);
				}
				field[i][j].setOpaque(true);
				field[i][j].setHorizontalAlignment(JLabel.CENTER);
				field[i][j].setVerticalAlignment(JLabel.CENTER);

				gamePanel.add(field[i][j], gbc);
			}

		}
		gbc.gridx = 9;
		/*
		 * for loop that creates the number buttons and then creates the buttons sets
		 * the size and places its in the game panel based on desired location
		 */
		for (int i = 0; i < 8; i++) {
			gbc.gridy = i;
			numButtons[i] = createButton(Integer.toString(i), null, Color.BLACK, Color.LIGHT_GRAY, gbController);

			numButtons[i].setPreferredSize(new Dimension(60, 60));
			gamePanel.add(numButtons[i], gbc);

		}
		gbc.gridy = 9;
		/*
		 * for loop that creates the letter buttons and then creates the buttons sets
		 * the size and places its in the game panel based on desired location
		 */
		for (int i = 0; i < 8; i++) {
			gbc.gridx = i;
			letterButtons[i] = createButton(letters[i], null, Color.BLACK, Color.LIGHT_GRAY, gbController);
			letterButtons[i].setPreferredSize(new Dimension(60, 60));
			gamePanel.add(letterButtons[i], gbc);

		}

		gbc.gridx = 9;
		gbc.gridy = 9;
		// Create the move button
		moveBtn = createButton("Move", null, Color.BLACK, Color.WHITE, gbController);
		// set move button size
		moveBtn.setPreferredSize(new Dimension(60, 60));
		// add button to game button
		gamePanel.add(moveBtn, gbc);
		// create the 4 game pieces
		blackImage = new ImageIcon("image/black_s.png");
		whiteImage = new ImageIcon("image/white_s.png");
		batImage = new ImageIcon("image/bat.png");
		pumpkinImage = new ImageIcon("image/pumpkin.png");
		catImage = new ImageIcon("image/cat.png");
		dogImage = new ImageIcon("image/dog.png");
		checkImage = new ImageIcon("image/checkmark.png");
		currentBlkImage = blackImage;
		currentWhiteImage = whiteImage;

		// set the placement of the game pieces
		model.initialize(OthelloModel.NORMAL);
		controller.setBoard(field, currentBlkImage, currentWhiteImage, model, false);
		// create the chat panel
		chatPanel = new JPanel();
		// Create the sub,it button
		sumbit = createButton("Submit", null, Color.RED, Color.BLACK, controller);
		// set size
		sumbit.setPreferredSize(new Dimension(100, 25));
		/*
		 * set chat panel size and information
		 */
		chatPanel.setBackground(Color.GRAY);
		chatPanel.setPreferredSize(new Dimension(450, 540));

		chatPanel.setVisible(true);
		chatPanel.setLayout(new GridBagLayout());
		/*
		 * create text field
		 */
		chat = new JTextField();
		// set size
		chat.setPreferredSize(new Dimension(880, 25));
		// craete the panel for the buttom of the GUI
		bottomPanel = new JPanel();
		/*
		 * set all buttom panel properties
		 */
		bottomPanel.setBackground(Color.GRAY);
		bottomPanel.setPreferredSize(new Dimension(1010, 30));

		bottomPanel.setVisible(true);
		bottomPanel.setLayout(new GridBagLayout());

		gbc.gridx = 0;
		gbc.gridy = 0;
		/*
		 * place chat on button
		 */
		bottomPanel.add(chat, gbc);
		gbc.gridx++;
		/*
		 * place button on buttom panel
		 */
		bottomPanel.add(sumbit, gbc);
		/*
		 * create panel for the show move panel and set its properties
		 */
		showMovePanel = new JPanel();
		showMovePanel.setBorder(new LineBorder(Color.GRAY, 5));
		showMovePanel.setBackground(Color.WHITE);
		showMovePanel.setPreferredSize(new Dimension(450, 40));
		showMovePanel.setVisible(true);
		showMovePanel.setLayout(new BorderLayout(10, 5));
		// create check box
		showMoveBox = new JCheckBox("Show Valid Moves");

		gbc.gridx = 0;
		gbc.gridy = 0;
		// add checkbox to panel
		showMovePanel.add(showMoveBox, BorderLayout.WEST);
		chatPanel.add(showMovePanel, gbc);
		showMoveBox.addItemListener(gbController);
		
		// Create prompt panel
		promptPanel = new JPanel();
		/*
		 * set prompt panel and its properties
		 */
		promptPanel.setBorder(new MatteBorder(0, 0, 5, 5, Color.GRAY));
		promptPanel.setBackground(Color.PINK);
		promptPanel.setPreferredSize(new Dimension(450,380));

		promptPanel.setVisible(true);
		promptPanel.setLayout(new FlowLayout());
		/*
		 * create output text area set its properites and place it on the panel
		 */
		promptArea = new JTextArea();
		promptArea.setEditable(false);
		promptArea.setCursor(null);
		promptArea.setOpaque(false);
		promptArea.setFocusable(false);
		promptArea.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		promptPanel.add(promptArea, BorderLayout.WEST);
		//promptPanel.setAlignmentY(CENTER_ALIGNMENT);
		promptArea.setText("Player 1 Initilized with " + model.getChips(BLACK)+ " pieces \n");
		promptArea.append("Player 2 Initilized with" + model.getChips(WHITE)+" pieces \n");
		gbc.gridx = 0;
		gbc.gridy = 1;
		// add chat panel to promptpanel
		chatPanel.add(promptPanel, gbc);
		// Set initial text
		
		// Panel that holds the infomration on the pieces
		piecePanel = new JPanel();
		/*
		 * set piecePanel properties a
		 */
		piecePanel.setBorder(new MatteBorder(0, 0, 5, 5, Color.GRAY));
		piecePanel.setBackground(Color.WHITE);
		piecePanel.setPreferredSize(new Dimension(450, 120));

		piecePanel.setVisible(true);
		piecePanel.setLayout(new BorderLayout());
		// Create the panel where the text information will be placed
		textInfoPanel = new JPanel();
		/*
		 * set piecePanel properties
		 */
		textInfoPanel.setBackground(Color.WHITE);
		textInfoPanel.setPreferredSize(new Dimension(440, 60));

		textInfoPanel.setVisible(true);
		textInfoPanel.setLayout(new BorderLayout());
		// add textInfoPanel to Piece panel
		piecePanel.add(textInfoPanel, BorderLayout.NORTH);
		photoInfoPanel = new JPanel();
		/*
		 * set piecePanel properties
		 */
		photoInfoPanel.setBackground(Color.WHITE);

		photoInfoPanel.setPreferredSize(new Dimension(440, 60));

		photoInfoPanel.setVisible(true);
		photoInfoPanel.setLayout(new BorderLayout());
		// add photoinfopanel to piecepanel
		piecePanel.add(photoInfoPanel, BorderLayout.SOUTH);
		/*
		 * create player information label
		 */
		blackInfo = new JLabel("   Player One Pieces: ");
		whiteInfo = new JLabel("   Player Two Pieces");
		gbc.gridx = 0;
		gbc.gridy = 0;
		// create photo label with information for blk user
		blkPhotoInfo = new JLabel(Integer.toString(model.getChips(BLACK)), currentBlkImage, JLabel.HORIZONTAL);
		/*
		 * add text panel information to the text panel
		 */
		textInfoPanel.add(blkPhotoInfo, BorderLayout.EAST);
		textInfoPanel.add(blackInfo, BorderLayout.WEST);
		// create photo label with information for whtie user
		whtPhotoInfo = new JLabel(Integer.toString(model.getChips(WHITE)), currentWhiteImage, JLabel.HORIZONTAL);
		// place white user infomration to panel
		photoInfoPanel.add(whtPhotoInfo, BorderLayout.EAST);
		photoInfoPanel.add(whiteInfo, BorderLayout.WEST);

		gbc.gridx = 0;
		gbc.gridy = 2;
		// add pieces information panel to main chat panel
		chatPanel.add(piecePanel, gbc);
		/*
		 * Add the 3 main panel to the container
		 */
		mainContainer.add(gamePanel, BorderLayout.WEST);

		mainContainer.add(chatPanel, BorderLayout.EAST);
		mainContainer.add(bottomPanel, BorderLayout.SOUTH);
	}

	/**
	 * Create a button
	 * 
	 * @param text    name of button
	 * @param ac      ActionCommand that user wants to perform
	 * @param fgc     Foreground (font) color of buttons
	 * @param bgc     background color of button
	 * @param handler actionlistener to give buttom function
	 * @return Jbutton newButton
	 */
	public JButton createButton(String text, String ac, Color fgc, Color bgc, ActionListener handler) {
		// create a button
		JButton newButton = new JButton(text);
		// Set color of text
		newButton.setForeground(fgc);
		// set background set
		newButton.setBackground(bgc);
		// Right now we have no action commands yet so keep this handle erros
		if (ac != null) {
			newButton.setActionCommand(ac);
		}
		// Give the button function
		newButton.addActionListener(handler);
		// set the font if the button is the move buton
		if (bgc == Color.WHITE) {
			newButton.setFont(new Font("Dialog", Font.PLAIN, 10));
		}
		// return the new buttons
		return newButton;
	}
	/**
	 * Control for newconnection button dialog
	 */
	public void newConnectionMenu() {
		//set network dialog modal demensions and view
		Point thisLocation = getLocation();
		Dimension parentSize = getSize();
		Dimension dialogSize = networkDialog.getSize();
		int offsetX = (parentSize.width-dialogSize.width)/2+thisLocation.x;
		int offsetY = (parentSize.height-dialogSize.height)/2+thisLocation.y;
		networkDialog.setLocation(offsetX,offsetY);
		networkDialog.setVisible(true);
		
		if(networkDialog.pressedConnect()) {// checks if user pressed the connect button or cancel
			promptArea.append("Connect Pressed\n");	
		}else {
			promptArea.append("Cancel Pressed\n");
		}
		//Returns the address and port to the text area.
		promptArea.append("Connecting to " + networkDialog.getAddress()+ "\n");
		promptArea.append("On Port " + networkDialog.getPort()+ "\n");
	}
	/**
	 * controll for disconnection button
	 */
	public void disconnectionMenu() {
		promptArea.append("Disconnecting from network connection\n");
	}
	
	
	
	/**
	 * Private class that handles the main menu
	 * 
	 * @author Khair Ahmed
	 * @version 1.0
	 * @see java.swing
	 * @see java.awt
	 */
	 private class Controller implements ActionListener {
		int gameMode;
		
		
		/**
		 * Controls all events that are in the main menu
		 * 
		 * @param event ActionEvent when the button is clicked
		 */
		@Override
		public void actionPerformed(ActionEvent event) {
			/* Debug Menu Control */
			if (nrmlTest.isSelected()) {
				gameMode = OthelloModel.NORMAL;
			} else if (cornerTest.isSelected()) {
				gameMode = OthelloModel.CORNER_TEST;
			} else if (sideTest.isSelected()) {
				gameMode = OthelloModel.OUTER_TEST;
			} else if (cap1Test.isSelected()) {
				gameMode = OthelloModel.TEST_CAPTURE;
			} else if (cap2Test.isSelected()) {
				gameMode = OthelloModel.TEST_CAPTURE2;
			} else if (empTest.isSelected()) {
				gameMode = OthelloModel.UNWINNABLE;
			} else if (inSqrTest.isSelected()) {
				gameMode = OthelloModel.INNER_TEST;
			}
	
			
			if(event.getSource().equals(disconnectItem)) {
				promptArea.append("Disconnection from the network connection\n");
			}
			/* Reskin Menu */
			if (nrmlIconItem.isSelected()) {
				currentBlkImage = blackImage;
				currentWhiteImage = whiteImage;
				setBoard(field, currentBlkImage, currentWhiteImage, model, false);
				blkPhotoInfo.setIcon(currentBlkImage);
				whtPhotoInfo.setIcon(currentWhiteImage);
			} else if (catIconItem.isSelected()) {
				currentBlkImage = catImage;
				currentWhiteImage = dogImage;
				setBoard(field, currentBlkImage, currentWhiteImage, model, false);
				blkPhotoInfo.setIcon(currentBlkImage);
				whtPhotoInfo.setIcon(currentWhiteImage);
			} else if (batIconItem.isSelected()) {
				currentBlkImage = batImage;
				currentWhiteImage = pumpkinImage;
				setBoard(field, currentBlkImage, currentWhiteImage, model, false);
				blkPhotoInfo.setIcon(currentBlkImage);
				whtPhotoInfo.setIcon(currentWhiteImage);
			}
			/* Main Menu Control */
			if (event.getSource().equals(newGameItem)) {
				model.initialize(gameMode);
				setBoard(field, currentBlkImage, currentWhiteImage, model, true);
				setGameButtons(letterButtons, -1);
				setGameButtons(numButtons, -1);
				
				

			}

			else if (event.getSource().equals(aboutItem)) {
				JOptionPane.showMessageDialog(null, "Othello Game\nby Khair \nand Invisible Partner\nOctober 2020",
						"About", JOptionPane.INFORMATION_MESSAGE);
			} else if (event.getSource().equals(exitGameItem)) {
				System.exit(0);
			}
		
		}

		/**
		 * Sets after move or new game
		 * @param field
		 * @param currentBlkImage
		 * @param currentWhiteImage
		 * @param model
		 * @param newGame
		 */
		public void setBoard(JLabel[][] field, ImageIcon currentBlkImage, ImageIcon currentWhiteImage,
				OthelloModel model, boolean newGame) {
			for (int i = 0; i < 8; i++) { // set icons
				for (int j = 0; j < 8; j++) {
					if (model.getBoard(i, j) == BLACK) {
						field[i][j].setIcon(currentBlkImage);
					} else if (model.getBoard(i, j) == WHITE) {
						field[i][j].setIcon(currentWhiteImage);
					} else {
						field[i][j].setIcon(null);
					}
				}
			}

			if(newGame) {// if user wants new game re initalize game pipeces
				promptArea.setText("Player 1 Initilized with " + model.getChips(BLACK)+ " pieces \n");
				promptArea.append("Player 2 Initilized with" + model.getChips(WHITE)+" pieces \n");
				blkPhotoInfo.setText(Integer.toString(model.getChips(BLACK)));
				whtPhotoInfo.setText(Integer.toString(model.getChips(WHITE)));
				moveBtn.setEnabled(true);
			}

		}

	}
/**
 * Handles control of game buttons
 * @author Khair Ahmed
 *
 */
	private class GameButtonHandler implements ActionListener, ItemListener {
		/**
		 * holds the letter the button selected asa an int
		 */
		int letterMove;
		int numMove;
		int player = 1;
		int captured;
		/**
		 * Controls all JBUTTONS
		 * 
		 * @param event ActionEvent when the button is clicked
		 */
		@Override
		public void actionPerformed(ActionEvent event) {
			/*
			 * if any of the buttons are pressed it will store the button value and change it to white
			 */
			for (int i = 0; i < 8; i++) {
				if (event.getSource().equals(letterButtons[i])) {
					setGameButtons(letterButtons, i);
					letterMove = i;
				}
				if (event.getSource().equals(numButtons[i])) {
					setGameButtons(numButtons, i);
					numMove = i;
				}

			}
			//if move button is clicked
			if (event.getSource().equals(moveBtn)) {
				
					if(model.canMove(player)) {// check if user can move
						if (model.isValid(letterMove, numMove, player)) {
							//complete move
							captured =model.move(letterMove, numMove, player);
						
							promptArea.append("Player "+ player + "Captured " + captured + " Piece \n" );
						}	
					}//switch to next player
					player= playerSwitch(player, model, moveBtn);
					//update board
					updateBoard(field, model, currentBlkImage, currentWhiteImage, player, checkImage);
					blkPhotoInfo.setText(Integer.toString(model.getChips(BLACK)));
					whtPhotoInfo.setText(Integer.toString(model.getChips(WHITE)));
					if(endGame(model)) {// check if move result in end game and if so disable move button
						if(model.getChips(BLACK)>model.getChips(WHITE)) {
							promptArea.append("Player 1 Wins\n\n" );
						}else if (model.getChips(BLACK)<model.getChips(WHITE)){
							promptArea.append("Player 2 Wins\n\n" );
						}else if(model.getChips(BLACK)==model.getChips(WHITE)) {
							promptArea.append("TIE GAME! \n\n" );
						}
						moveBtn.setEnabled(false);
						promptArea.append("Play Again? (Select New Game from File Menu\n)");
						
					}
			
			}
			
			
		}
		/**
		 * Controls toggle for valid moves shown or not shown
		 * 
		 * @param event ActionEvent when the button is clicked
		 */
		public void itemStateChanged(ItemEvent event) {
			if (event.getStateChange() == ItemEvent.SELECTED) {//show moves
				System.out.println("State");
				showMoves(field, model, player, checkImage);
			} else {
				showMoves(field, model, player, null);//dont show moves
			}

		}
	}
	/**
	 * Switches the turns of the player
	 * @param player black or white
	 * @param model internal biard
	 * @param moveBtn move button
	 * @return turn which player turn it is now
	 */
	public int playerSwitch(int player, OthelloModel model,JButton moveBtn) {
		int turn ;
		//causes player to switch to next player
		if(player ==1) {
			turn =2;
		}else {
			turn =1;
		}// check if use can move other make him skip
		if (model.canMove(turn)) {
			moveBtn.setText("Move");
		}else {
			moveBtn.setText("Skip");
			promptArea.append("Player" + turn+ "Has no valid moves, Press Skip\n");
		}
		setGameButtons(letterButtons, -1);
		setGameButtons(numButtons, -1);
	
		return turn;
		
	}
/**
 * set the game Buttons to whtie or grey
 * @param button any button that is selected
 * @param match a number that represent the that wants to be seleted
 */
	public void setGameButtons(JButton[] button, int match) {
		/*
		 * if right button is selected then change it to white
		 */
		for (int i = 0; i < 8; i++) {
			if (i == match) {
				System.out.println("Changed to white");
				button[i].setBackground(Color.WHITE);
			} else {
				button[i].setBackground(Color.LIGHT_GRAY);
			}

		}
	}

/**
 * shows all avaible moves to the user
 * @param field the field
 * @param model internal board
 * @param player black or white
 * @param checkImage image of a check mark
 */
	public void showMoves(JLabel[][] field, OthelloModel model, int player, ImageIcon checkImage) {
		/**
		 * loop through all positon on model and check if pice and be placed and plae and image of check mark 
		 * else remove any images that may exist
		 */
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {

				if (model.isValid(i, j, player)) {
					field[i][j].setIcon(checkImage);

				} else if (!(model.isValid(i, j, player)) && model.getBoard(i, j) == 0) {
					field[i][j].setIcon(null);

				}
			}
		}
	}
/**
 * update the board so that the view represents the internal board
 * @param field the field
 * @param model internal board
 * @param currentBlkImage what the icon is that the user wants 
 * @param currentWhiteImage what the icon is that the user wants 
 * @param player black or white
 * @param checkImage image of a check mark
 */
	public void updateBoard(JLabel[][] field, OthelloModel model,  ImageIcon currentBlkImage,
			ImageIcon currentWhiteImage, int player,  ImageIcon checkImage) {
		/*
		 * set image to white or black depends on internal board
		 */
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if(model.getBoard(i, j)== BLACK) {
					field[i][j].setIcon(currentBlkImage);
				}
				else if(model.getBoard(i, j)== WHITE) {
					field[i][j].setIcon(currentWhiteImage);
				}
			}
		}
		// if user is toggled the show move button then update avaible moves
		if(showMoveBox.isSelected()) {
			showMoves(field, model, player, checkImage);
		}
		


	
	}
	/**
	 * check if game is at an end game state
	 * @param model
	 * @return true if no more moves
	 * @return false if you can make moves
	 */
	public boolean endGame(OthelloModel model) {
		if(!(model.canMove(BLACK)) && !(model.canMove(WHITE))) {
			return true;
		}else {
			return false;
		}
	}

}

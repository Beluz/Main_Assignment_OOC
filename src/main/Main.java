package main;
//STUDENT NAME: MARIABELUZ SUAREZ AMADOR
//STUDENT NUMBER: 2017367
//BCS IT YEAR 2, GROUP B
//LECTURERS: Object Oriented Constructs / Systems Analysis & Design 
//ASSIGNMENT: Planning and Implementing an Object-Oriented Software System 


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;

import Customer.CustomerType;
import Customer.MusicLover;
import Customer.TvLover;
import Customer.VideoLover;
import Customer.Premium;


public class Main extends JFrame implements ActionListener {

	//GridLayout manager = new GridLayout();
	BorderLayout manager = new BorderLayout ();
	BorderLayout customer = new BorderLayout ();
	
	String[][] dataCustomer = new String[100][6]; //array to store customers
	String[] datacolumnNames =  {"Id", "Name", "Address", "Membership","Phone","Points"}; //array to store the column names of customer query

	public JButton bSaveAdd;
	JLabel c_Id;
	public JTextField txtc_Id;
	JLabel lAddress;
	public JTextField tAddress;
	JLabel lFirstName;
	public JTextField tFirstName;
	JLabel lPhone;
	public JTextField tPhone;
	JLabel lMembership;
	JLabel lRole;
	public JRadioButton Music_Lover;
	public JRadioButton Movie_Lover;
	public JRadioButton Tv_Lover;
	public JRadioButton Premium;
	public JComboBox custype;
	JLabel lPoints;
	ButtonGroup type;
	JButton searchCustomer;
	JButton UpdateCustomer;
	JButton SaveUpdate;
	
	JPanel Pc_Id;
	JPanel PAddress;
	JPanel PFirstName;
	JPanel PPhone;
	JPanel PRole;
	JPanel PPoints;
	JPanel PSaveAdd;
	JPanel PsearchCustomer;
			
			
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}
	
	public Main() {
		this.setSize(500,700);
		this.setVisible(true);
		this.setTitle("Ultra-Vision System");
		
		JMenuBar myMenuBar = new JMenuBar();
		this.setJMenuBar(myMenuBar);
		
		JMenu customerMenu = new JMenu ("Customers");
		myMenuBar.add(customerMenu);
		
		JMenu titleMenu = new JMenu ("Titles");
		myMenuBar.add(titleMenu);
		
		JMenu rentMenu = new JMenu ("Rents");
		myMenuBar.add(rentMenu);
		
		
		JMenuItem searchCustomerMenuItem = new JMenuItem ("Search Customer");
		customerMenu.add(searchCustomerMenuItem);
		searchCustomerMenuItem.addActionListener(this);
		searchCustomerMenuItem.setActionCommand("SearchCustomer");
		
		JMenuItem addCustomerMenuItem = new JMenuItem ("Add New Customer");
		customerMenu.add(addCustomerMenuItem);
		addCustomerMenuItem.addActionListener(this);
		addCustomerMenuItem.setActionCommand("AddCustomer");
		
		JMenuItem updateMenuItem = new JMenuItem ("Update Customer Details");
		customerMenu.add(updateMenuItem);
		updateMenuItem.addActionListener(this);
		updateMenuItem.setActionCommand("UpdateCustomer");
		
		JMenuItem addTitleMenuItem = new JMenuItem ("Add New Title");
		titleMenu.add(addTitleMenuItem);
		addTitleMenuItem.addActionListener(this);
		addTitleMenuItem.setActionCommand("AddTitle");
		
		JMenuItem updateTitleMenuItem = new JMenuItem ("Update Title Details");
		titleMenu.add(updateTitleMenuItem);
		updateTitleMenuItem.addActionListener(this);
		updateTitleMenuItem.setActionCommand("UpdateTitle");
		
		JMenuItem registerRentMenuItem = new JMenuItem ("Register rent");
		rentMenu.add(registerRentMenuItem);
		registerRentMenuItem.addActionListener(this);
		registerRentMenuItem.setActionCommand("RegisterRent");
		
		JMenuItem returnTitleMenuItem = new JMenuItem ("Returns");
		rentMenu.add(returnTitleMenuItem);
		returnTitleMenuItem.addActionListener(this);
		returnTitleMenuItem.setActionCommand("Returns");
		
		
		
		//--------------------------------------------------------
				
		this.setLayout(manager);

				
		//Creating the panel
		JPanel mainPanel = new JPanel();
		// Adding the panel to the frame
		
		
		//Creating the label
		JLabel myLabel = new JLabel("Welcome to Ultra-Vision System");
		//Adding the label to the panel
		mainPanel.add(myLabel);

        add(mainPanel,BorderLayout.CENTER);
       
        
        this.add(mainPanel);
            
        this.validate();
		this.repaint();
    		
	}

	  
	public void bd() {
		try{
			// Load the database driver
			//if you use MAC laptop use the next line com.mysql.cj.jdbc.Driver"
			Class.forName("com.mysql.jdbc.Driver").newInstance() ;
			
			String dbServer = "jdbc:mysql://localhost:3306/ultra_vision";
			String user = "root";
			String password = "";
			String query="";
			

			query = "SELECT * FROM customer";					

			//object from my driver i get the connection
			//.getConnection is a static method
			// Get a connection to the database
			Connection conn = DriverManager.getConnection(dbServer, user, password) ;
			
			// Get a statement from the connection
			//statement is to say what do i want to do (queries)
			Statement stmt = conn.createStatement() ;
			
			
			// Execute the query
			//result set is a set of values because we usually get a group of values after execute a query from statement
			ResultSet rs = stmt.executeQuery(query) ;
			// Loop through the result set
			int i=0; //variable to loop the results
			while(rs.next()) {
				dataCustomer[i][0] = rs.getString("c_Id");
				dataCustomer[i][1] = rs.getString("c_Name");
				dataCustomer[i][2] = rs.getString("c_Address");
				dataCustomer[i][3] = rs.getString("c_Membership");
				dataCustomer[i][4] = rs.getString("c_Phone");
				dataCustomer[i][4] = rs.getString("c_Points");
				i++;	
			}
				rs.close() ;
			
			
			// Close the result set, statement and the connection
			stmt.close() ;
			conn.close() ;
			}
			catch( SQLException se ){
			System.out.println( "SQL Exception:" ) ;
			
			// Loop through the SQL Exceptions
			while( se != null ){
			System.out.println( "State  : " + se.getSQLState()  ) ;
			System.out.println( "Message: " + se.getMessage()   ) ;
			System.out.println( "Error  : " + se.getErrorCode() ) ;
			
			se = se.getNextException() ;
			}
		}
		catch( Exception e ){
		System.out.println( e ) ;
		}
	}
	
	
	
	//////////////////// ACTION LISTENER ///////////////////////////////////////////////
	
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		// TODO Auto-generated method stub
		
		if (ev.getActionCommand().equals("SearchCustomer")) {
			
			JTable CustomerTable;
			JScrollPane spCustomer;
			
			//this.setVisible(false);
			JFrame frame = new JFrame("Search Customer");
	        frame.setSize(500, 500);
	        frame.setVisible(true);
	        
	        GridLayout searchcusManager = new GridLayout(0, 1);
			frame.setLayout(searchcusManager);
			
			Pc_Id = new JPanel();
			PAddress = new JPanel();
			PFirstName = new JPanel();
			PPhone = new JPanel();
		    PRole = new JPanel();
		    PPoints = new JPanel();
		    PsearchCustomer = new JPanel();
			
			c_Id = new JLabel("Account Number: ");
			txtc_Id = new JTextField(30);//instantiation of a Textfield
			txtc_Id.setText("");
			
			//-----this piece of code was take it from a website:
			//-----http://www.forosdelweb.com/f45/jtextfield-solo-numerico-575289/
			txtc_Id.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (txtc_Id.getText().length()== 10) {e.consume();}
				if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
				getToolkit().beep();
				e.consume();
			    }
			}
			});
			//---------------------------------------------------
			lAddress = new JLabel("Address: ");
			tAddress = new JTextField(30);//instantiation of Textfield
			tAddress.setText("");
			lFirstName = new JLabel("Name: ");
			tFirstName = new JTextField(30);//instantiation of a Textfield
			tFirstName.setText("");
			lPhone = new JLabel("Phone: ");
			tPhone = new JTextField(30);//instantiation of a Textfield
			tPhone.setText("");
			//-----this piece of code was take it from a website:
			//-----http://www.forosdelweb.com/f45/jtextfield-solo-numerico-575289/
			tPhone.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (tPhone.getText().length()== 10) {e.consume();}
				if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
				getToolkit().beep();
				e.consume();
			    }
			}
			});
			//---------------------------------------------------
			
			custype = new JComboBox();
			CustomerType[] ctype = CustomerType.values();
			
			for (CustomerType t : ctype) {
				custype.addItem(t);
			}
			
			lPoints = new JLabel("Points: ");
			searchCustomer = new JButton("Search");
			searchCustomer.addActionListener(this);
			searchCustomer.setActionCommand("Search_Customer");
			
			UpdateCustomer = new JButton("Update");
			UpdateCustomer.addActionListener(this);
			UpdateCustomer.setActionCommand("UpdateCustomer");
			UpdateCustomer.setEnabled(false);
			
			SaveUpdate = new JButton("Save Update");
			SaveUpdate.addActionListener(this);
			SaveUpdate.setActionCommand("SaveUpdate");
			SaveUpdate.setEnabled(false);
			
			//adding the elements to the panel
			Pc_Id.add(c_Id);
			Pc_Id.add(txtc_Id);	
			PFirstName.add(lFirstName);
			PFirstName.add(tFirstName);
			PAddress.add(lAddress);
			PAddress.add(tAddress);
			PPhone.add(lPhone);
			PPhone.add(tPhone);
			PRole.add(custype);
			PPoints.add(lPoints);
			PsearchCustomer.add(searchCustomer);
			PsearchCustomer.add(UpdateCustomer);
			PsearchCustomer.add(SaveUpdate);
			
			frame.add(Pc_Id);
			frame.add(PFirstName);
			frame.add(PAddress);
			frame.add(PPhone);
			frame.add(PRole);
			frame.add(PPoints);
			frame.add(PsearchCustomer);
			
			//once we add all the elements we repaint, otherwise the program wont show the elements
			//everytime we add any element we have to repaint
			frame.validate();
			frame.repaint();
			
		}else if (ev.getActionCommand().equals("Search_Customer")) {
			
			MusicLover newMusicLover = new MusicLover();
			String[] searchCustomer = new String[6];
			searchCustomer = newMusicLover.customerDetails(txtc_Id.getText());
			tAddress.setText(searchCustomer[1]);
			tFirstName.setText(searchCustomer[2]);
			tPhone.setText(searchCustomer[4]);
			custype.getModel().setSelectedItem(searchCustomer[3]);
			lPoints.setText("Points:   " + searchCustomer[5]);
			tAddress.setEditable(false);
			tFirstName.setEditable(false);
			tPhone.setEditable(false);
			custype.setEnabled(false);
			UpdateCustomer.setEnabled(true);
			
		}else if (ev.getActionCommand().equals("AddCustomer")) {

			//-----------------Code to define all the GUI elements needed
			JTable CustomerTable;
			JScrollPane spCustomer;
			
			//this.setVisible(false);
			JFrame frame = new JFrame("Customer");
	        frame.setSize(500, 700);
	       
	        frame.setVisible(true);
	        
	        GridLayout addcusManager = new GridLayout(0, 1);
			frame.setLayout(addcusManager);
			
			Pc_Id = new JPanel();
			PAddress = new JPanel();
			PFirstName = new JPanel();
			PPhone = new JPanel();
		    PRole = new JPanel();
		    PSaveAdd = new JPanel();
			
			c_Id = new JLabel("Account Number: ");
			txtc_Id = new JTextField(30);//instantiation of a Textfield
			txtc_Id.setText("");
			
			//-----this piece of code was take it from a website:
			//-----http://www.forosdelweb.com/f45/jtextfield-solo-numerico-575289/
			txtc_Id.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (txtc_Id.getText().length()== 10) {e.consume();}
				if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
				getToolkit().beep();
				e.consume();
			    }
			}
			});
			//---------------------------------------------------
			
			lAddress = new JLabel("Address: ");
			tAddress = new JTextField(30);//instantiation of Textfield
			tAddress.setText("");
			lFirstName = new JLabel("Name: ");
			tFirstName = new JTextField(30);//instantiation of a Textfield
			tFirstName.setText("");
			lPhone = new JLabel("Phone: ");
			tPhone = new JTextField(30);//instantiation of a Textfield
			tPhone.setText("");
			//-----this piece of code was take it from a website:
			//-----http://www.forosdelweb.com/f45/jtextfield-solo-numerico-575289/
			tPhone.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (tPhone.getText().length()== 10) {e.consume();}
				if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
				getToolkit().beep();
				e.consume();
			    }
			}
			});
			//---------------------------------------------------
			
			custype = new JComboBox();
			CustomerType[] ctype = CustomerType.values();
			
			for (CustomerType t : ctype) {
				custype.addItem(t);
			}

			bSaveAdd = new JButton("Add Customer"); // create and instantiate a button
			bSaveAdd.addActionListener(this);
			bSaveAdd.setActionCommand("SaveCustomer");
			
			//adding the elements to the panel
			Pc_Id.add(c_Id);
			Pc_Id.add(txtc_Id);	
			PFirstName.add(lFirstName);
			PFirstName.add(tFirstName);
			PAddress.add(lAddress);
			PAddress.add(tAddress);
			PPhone.add(lPhone);
			PPhone.add(tPhone);
			PRole.add(custype);
			PSaveAdd.add(bSaveAdd);
			
			frame.add(Pc_Id);
			frame.add(PFirstName);
			frame.add(PAddress);
			frame.add(PPhone);
			frame.add(PRole);
			frame.add(PSaveAdd);
			
			
			
			JPanel PCustomer = new JPanel();
			JLabel myLabel = new JLabel("Adding New Customers");
			PCustomer.add(myLabel);
			
			JPanel Pinfocustomer = new JPanel();
			
			
			bd();  //call to a method to connect the database
			
			
			CustomerTable = new JTable(dataCustomer, datacolumnNames);
			spCustomer = new JScrollPane(CustomerTable);
			Pinfocustomer.add(spCustomer);
			
			frame.add(PCustomer);
			frame.add(Pinfocustomer);
			
			//once we add all the elements we repaint, otherwise the program wont show the elements
			//everytime we add any element we have to repaint
			frame.validate();
			frame.repaint();
	        
	        
	        
			
		}else if (ev.getActionCommand().equals("SaveCustomer")) {
			
			if (custype.getModel().getSelectedItem().toString().equals("ML")) {
				MusicLover newMusicLover = new MusicLover();
				newMusicLover.addCustomer(txtc_Id.getText(), tFirstName.getText(), tAddress.getText(), custype.getModel().getSelectedItem().toString(), tPhone.getText());
				JOptionPane.showMessageDialog(this, "A new Customeer " + custype.getModel().getSelectedItem().toString() + " have been added.");
			}else if (custype.getModel().getSelectedItem().toString().equals("VL")) {
				VideoLover newVideoLover = new VideoLover();
				newVideoLover.addCustomer(txtc_Id.getText(), tFirstName.getText(), tAddress.getText(), custype.getModel().getSelectedItem().toString(), tPhone.getText());
				JOptionPane.showMessageDialog(this, "A new Customeer " + custype.getModel().getSelectedItem().toString() + " have been added.");
			}else if (custype.getModel().getSelectedItem().toString().equals("TL")) {
				TvLover newTvLover = new TvLover();
				newTvLover.addCustomer(txtc_Id.getText(), tFirstName.getText(), tAddress.getText(), custype.getModel().getSelectedItem().toString(), tPhone.getText());
				JOptionPane.showMessageDialog(this, "A new Customeer " + custype.getModel().getSelectedItem().toString() + " have been added.");
			}else if (custype.getModel().getSelectedItem().toString().equals("P")) {
				Premium newPremiumLover = new Premium();
				newPremiumLover.addCustomer(txtc_Id.getText(), tFirstName.getText(), tAddress.getText(), custype.getModel().getSelectedItem().toString(), tPhone.getText());
				JOptionPane.showMessageDialog(this, "A new Customeer " + custype.getModel().getSelectedItem().toString() + " have been added.");
			}
			
			
			
		}else if (ev.getActionCommand().equals("UpdateCustomer")) {
			
			tAddress.setEditable(true);
			tFirstName.setEditable(true);
			tPhone.setEditable(true);
			custype.setEnabled(true);
			UpdateCustomer.setEnabled(false);
			SaveUpdate.setEnabled(true);
		
		}else if (ev.getActionCommand().equals("SaveUpdate")) {
		
			if (custype.getModel().getSelectedItem().toString().equals("ML")) {
				MusicLover newMusicLover = new MusicLover();
				newMusicLover.updateCustomer(txtc_Id.getText(), tFirstName.getText(), tAddress.getText(), custype.getModel().getSelectedItem().toString(), tPhone.getText());
				JOptionPane.showMessageDialog(this, "A new Customeer " + custype.getModel().getSelectedItem().toString() + " have been added.");
			}else if (custype.getModel().getSelectedItem().toString().equals("VL")) {
				VideoLover newVideoLover = new VideoLover();
				newVideoLover.updateCustomer(txtc_Id.getText(), tFirstName.getText(), tAddress.getText(), custype.getModel().getSelectedItem().toString(), tPhone.getText());
				JOptionPane.showMessageDialog(this, "A new Customeer " + custype.getModel().getSelectedItem().toString() + " have been added.");
			}else if (custype.getModel().getSelectedItem().toString().equals("TL")) {
				TvLover newTvLover = new TvLover();
				newTvLover.updateCustomer(txtc_Id.getText(), tFirstName.getText(), tAddress.getText(), custype.getModel().getSelectedItem().toString(), tPhone.getText());
				JOptionPane.showMessageDialog(this, "A new Customeer " + custype.getModel().getSelectedItem().toString() + " have been added.");
			}else if (custype.getModel().getSelectedItem().toString().equals("P")) {
				Premium newPremiumLover = new Premium();
				newPremiumLover.updateCustomer(txtc_Id.getText(), tFirstName.getText(), tAddress.getText(), custype.getModel().getSelectedItem().toString(), tPhone.getText());
				JOptionPane.showMessageDialog(this, "A new Customeer " + custype.getModel().getSelectedItem().toString() + " have been added.");
			}
			
		}else if (ev.getActionCommand().equals("AddTitle")) {
			
		}else if (ev.getActionCommand().equals("UpdateTitle")) {
			
		}else if (ev.getActionCommand().equals("RegisterRent")) {
			
		}else if (ev.getActionCommand().equals("Returns")) {
			
		}
		
		
	}


}

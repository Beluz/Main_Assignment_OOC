package Customer;
//STUDENT NAME: MARIABELUZ SUAREZ AMADOR
//STUDENT NUMBER: 2017367
//BCS IT YEAR 2, GROUP B
//LECTURERS: Object Oriented Constructs / Systems Analysis & Design 
//ASSIGNMENT: Planning and Implementing an Object-Oriented Software System 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Premium  extends Customer implements CustomerInterface  {

	
	
	@Override
	public void addCustomer(String Id, String Name, String Address, String Membership, String Phone) {
		// TODO Auto-generated method stub
		try{
			// Load the database driver
			//if you use MAC laptop use the next line com.mysql.cj.jdbc.Driver"
			Class.forName("com.mysql.jdbc.Driver").newInstance() ;
			
			String dbServer = "jdbc:mysql://localhost:3306/ultra_vision";
			String user = "root";
			String password = "";
			String query="";
			

			query = "INSERT INTO CUSTOMER VALUES('"+ Id +"','"+ Name +"','"+ Address +"','"+ Membership +"','"+ Phone  +"', 0)";
    		
    		//object from my driver i get the connection
    		//.getConnection is a static method
    		// Get a connection to the database
    		Connection conn = DriverManager.getConnection(dbServer, user, password) ;
    		
    		// Get a statement from the connection
    		//statement is to say what do i want to do (queries)
    		Statement stmt = conn.createStatement() ;

    		stmt.executeUpdate(query) ;
    		//JOptionPane.showMessageDialog(this, "You have been Sign Up!", 0 );
    	
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
	
	

	@Override
	public void updateCustomer(String Id, String Name, String Address, String Membership, String Phone) {
		// TODO Auto-generated method stub
		try{
			// Load the database driver
			//if you use MAC laptop use the next line com.mysql.cj.jdbc.Driver"
			Class.forName("com.mysql.jdbc.Driver").newInstance() ;
			
			String dbServer = "jdbc:mysql://localhost:3306/ultra_vision";
			String user = "root";
			String password = "";
			String query="";
			

			query = "UPDATE CUSTOMER SET c_Id='"+ Id +"', c_Name='"+ Name +"', c_Address='"+ Address +"', c_Membership='"+ Membership +"', c_Phone='"+ Phone  +"' WHERE c_Id='" + Id + "'";
    		
    		//object from my driver i get the connection
    		//.getConnection is a static method
    		// Get a connection to the database
    		Connection conn = DriverManager.getConnection(dbServer, user, password) ;
    		
    		// Get a statement from the connection
    		//statement is to say what do i want to do (queries)
    		Statement stmt = conn.createStatement() ;

    		stmt.executeUpdate(query) ;
    		//JOptionPane.showMessageDialog(this, "You have been Sign Up!", 0 );
    	
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

	@Override
	public String[] customerDetails(String c_Id) {
		// TODO Auto-generated method stub
		// Method which return the customer's details when we are searching for a customer
				String[] dataCustomer = new String[6]; //array to store customers
				
				try{
					// Load the database driver
					//if you use MAC laptop use the next line com.mysql.cj.jdbc.Driver"
					Class.forName("com.mysql.jdbc.Driver").newInstance() ;
					
					String dbServer = "jdbc:mysql://localhost:3306/ultra_vision";
					String user = "root";
					String password = "";
					String query="";
					

					query = "select * from customer where c_Id='" + c_Id + "' " ;
		    		
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
						dataCustomer[0] = rs.getString("c_Id");
						dataCustomer[1] = rs.getString("c_Name");
						dataCustomer[2] = rs.getString("c_Address");
						dataCustomer[3] = rs.getString("c_Membership");
						dataCustomer[4] = rs.getString("c_Phone");
						dataCustomer[5] = rs.getString("c_Points");
						i++;	
					}
						rs.close() ;
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
				
				return dataCustomer;
	}

}

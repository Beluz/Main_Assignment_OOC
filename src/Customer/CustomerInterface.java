package Customer;
//STUDENT NAME: MARIABELUZ SUAREZ AMADOR
//STUDENT NUMBER: 2017367
//BCS IT YEAR 2, GROUP B
//LECTURERS: Object Oriented Constructs / Systems Analysis & Design 
//ASSIGNMENT: Planning and Implementing an Object-Oriented Software System 

import java.util.ArrayList;

public interface CustomerInterface {


	//the methods are abstract by default so we don't need to write the word "abstract"
	//this method is used to add new customers
	public void addCustomer(String Id, String Name, String Address, String Membership, String Phone);
	
	// this method is used to update customers' details
    public  void updateCustomer(String Id, String Name, String Address, String Membership, String Phone);

    //the next method is used to search a customer
    public String[] customerDetails(String c_Id);
    
    
}

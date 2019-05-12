package Customer;
//STUDENT NAME: MARIABELUZ SUAREZ AMADOR
//STUDENT NUMBER: 2017367
//BCS IT YEAR 2, GROUP B
//LECTURERS: Object Oriented Constructs / Systems Analysis & Design 
//ASSIGNMENT: Planning and Implementing an Object-Oriented Software System 


public abstract class Customer{

	private String Id; //card account
	private String Name;
	private String Address;
	private String Membership; //type of membership
	private String Phone;
	private int Points;
	

	public int getPoints() {
		return Points;
	}
	
	public void setPoints(int Points) {
		this.Points = Points;
	}
	
	
	
	

}//end of customer class

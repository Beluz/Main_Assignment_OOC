package Customer;
//STUDENT NAME: MARIABELUZ SUAREZ AMADOR
//STUDENT NUMBER: 2017367
//BCS IT YEAR 2, GROUP B
//LECTURERS: Object Oriented Constructs / Systems Analysis & Design 
//ASSIGNMENT: Planning and Implementing an Object-Oriented Software System 

public enum CustomerType {

	ML("Music Lovers"), //Can only rent Music CDs and Live Concert Videos
	VL("Video Lovers"), // Can only rent Movies (excluding Live Concert Videos) 
	TV("TV Lover"), // Can only rent Box Sets 
	P("Premium"); //Can rent any title
	
	//variable to pass the value
	private final String desc;
	
	//constructor CustomerType
	CustomerType(String description) {
		desc = description;
	}
	
	public String getCustomerType() {
		return desc;
	}
	
	
}

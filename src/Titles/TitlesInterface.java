package Titles;

public interface TitlesInterface {


	public String format_CD = "CD";
	public String format_BR = "BR";
	public String format_DVD = "DVD";
	
	//define the type of format of the title
	public void Format();
	
	
	//this method is used to add new titles
	public void addTitle(String Type, String Name, String Genre, String ArtOrDir, int Year_Release, String Format);
	
	// this method is used to update titles' details
    public  void updateTitle(int Id, String Type, String Name, String Genre, String ArtOrDir, int Year_Release, String Format);

    
}

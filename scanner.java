import java.io.*;
import java.util.*;

public class scanner
{

    public static void main(String arg[])
    {
	//get filename
	String filename = "./testFile.txt";
	
	String line = null;

	//String Table
	ArrayList stringTableIDs = new ArrayList();
	ArrayList stringTableValues = new ArrayList();

	//ID Table
	ArrayList idTableID = new ArrayList();
	ArrayList idTableValue = new ArrayList();
	
	try
	    {
		FileReader fr = new FileReader(filename);
		
		BufferedReader br = new BufferedReader(fr);

		while((line = br.readLine()) != null) {

		    //This is where the lines are processed into tokens
		    
		    line = line.toUpperCase();
		    String tok = " ";
		    int i = 0;
		    while(line.charAt(i) != ' '){
			tok = tok + line.charAt(i);
			i++;
		    }
		    
		    //Handles Strings
		    System.out.println("tok = '" + tok + "'");
		    
		    if(tok.equals(" STRING"))
			{
			    //skip the white space
			    while(line.charAt(i) == ' '){
				i++;
			    }
			    
			    //Get the id  
			    String id = "";
			    while(line.charAt(i) != '='){
				id = id + line.charAt(i);
				i++;
			    }

			    //skip white space
			    while(line.charAt(i) == ' '){
				i++;
			    }
			    
			    //Get the value
			    String value = "";
			    i++;
			    while(line.charAt(i) != ';'){
				value = value + line.charAt(i);
				i++;
			    }

			    //Add to the string table
			    stringTableIDs.add(id);
			    stringTableValues.add(value);
			    
			    System.out.println("String " + stringTableIDs.size());
			}

		    //Handles IDs
		    if(tok.equals(" INT"))
			{
			    
			    //get the id
			    String id = "";
			    while(line.charAt(i) != '='){
				id = id + line.charAt(i);
				i++;
			    }
			    
			    //get the value
			    String valueString = "";
			    i++;
			    i++;
			    while(line.charAt(i) != ';'){
				valueString = valueString + line.charAt(i);
				i++;
			    }
			    
			    int valueNum = Integer.parseInt(valueString);

			    //Add to the id table
			    idTableID.add(id);
			    idTableValue.add(valueNum);
			    
			    System.out.println("ID " + idTableID.size());
			}
			    
			    
			    
		    
		    
		}
		
		br.close();
	    }
	catch(IOException ex){
	    System.out.println("Error reading file " + filename + "");
	}
    }
}
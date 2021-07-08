//Name: Ruchira Perera
//Student #: 8714992

import java.util.*;
import java.io.FileWriter;   
import java.io.IOException;  

//Sorts the items of the given Knapsack and prints them to a .sol file 
public class Solution {
	
	// list of items to put in the bag to have the maximal value
	public Knapsack solutionKnapsack;
	// maximal value possible
    public int value;
    
    public String [] itemNames; 
	
	public Solution(Knapsack solutionKnapsack) {
		this.solutionKnapsack = solutionKnapsack;
        value = solutionKnapsack.getValue();
        itemNames = new String[solutionKnapsack.getItems().size()];
	}
	
	//sorts the items in a knapsack alphabetically
	public void sortItems() {

            for (int i = 0; i < solutionKnapsack.getItems().size(); i++) {
                itemNames[i] = solutionKnapsack.getItems().get(i).getName() + " ";
            }

			Arrays.sort(itemNames);
			System.out.println("value: " + value);
            System.out.println(Arrays.toString(itemNames));

	}

	//Writes the solution of the knapsack problem to a .sol file. 
	public void writeToFile(String fileName){

		sortItems();
		try {
			String solFileName = fileName.substring(0,fileName.length()-4) + ".sol";
			FileWriter fileWriter = new FileWriter(solFileName);
			
			fileWriter.write(String.valueOf(value));
			fileWriter.write("\r\n");

			for (String item: itemNames){
				fileWriter.write(item);

			}
			fileWriter.close();
			System.out.println("Solution writtten to file");


		  } catch (IOException e) {
			System.out.println("Error");
			e.printStackTrace();
		  }
	}

}

//Name: Ruchira Perera
//Student #: 8714992

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.ArrayList;
import java.util.Scanner; // Import the Scanner class to read text files

public class KnapsackProblem {
    
    public static void main(String[] args) {

        //incorrect parameters are given by the user 
        if (args.length != 2){

            System.out.println("Incorrect input. Please try again");

        }

        else {

            int capacity = 0;
            int num_items = 0;
            String lastLine = "";
            String[] item_info;
            String fileName = args[0];
            ArrayList <Item> items = new ArrayList<Item>();
            Solution solution;

        //Reads the input file to find and store the items and max capacity 
        try {
            File myObj = new File(fileName);    
            Scanner myReader = new Scanner(myObj);
            num_items = Integer.parseInt(myReader.nextLine());
    
            while (myReader.hasNextLine()) {
    
                lastLine = myReader.nextLine();
    
                if (Character.isLetter(lastLine.charAt(0))){
                    item_info = lastLine.split(" ", 3);
                    items.add(new Item(item_info[0],Integer.parseInt(item_info[1]), Integer.parseInt(item_info[2])));
                    //System.out.println(item_info[0]);
                }
    
            }
            myReader.close();
            } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            }
            capacity = Integer.parseInt(lastLine);

            //Selects method for solving the problem from user input 

            //Dynamic Solution 
            if (args[1].toUpperCase().equals("D")){

                //dynamic solution 
                KTable dynamic = new KTable(items, capacity);
                solution = dynamic.findItems();
                solution.writeToFile(fileName);
                
            }

            //Bruteforce solution 
            else if (args[1].toUpperCase().equals("F")){
                BruteForce bruteForceSol = new BruteForce(items, capacity);
                solution = new Solution(bruteForceSol.bruteForceCalc(items, capacity, num_items));
                solution.writeToFile(fileName);

            }

            else{
                System.out.println("Incorrect input. Please try again");
                return;
            } 
                 
        }
    }

}


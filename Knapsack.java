//Name: Ruchira Perera
//Student #: 8714992

import java.util.ArrayList;

//Stores Items 
public class Knapsack {

    ArrayList <Item> items = new ArrayList<Item>();
    int value;

	public Knapsack(int value) {

        this.value = value;
	}
    
    //add an item to a knapsack 
	public void addItem(Item item) {

        items.add(item);
	}
    
    /*
    Get Methods
    */
    
    //Get the arraylist of Item in a Knapsack 
    public ArrayList <Item> getItems(){
        return items;
    }

    //get the total value of a knapsack 
    public int getValue(){

        if (items.size() >0){
            value = 0;
            for (Item item: items){
                value += item.getValue();
            }
    
        }
        return value;
    }


}

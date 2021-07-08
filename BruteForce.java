//Name: Ruchira Perera
//Student #: 8714992

import java.util.ArrayList;

public class BruteForce {

    ArrayList <Item> items;
    int capacity;
    int NB_ITEMS;


    public BruteForce (ArrayList <Item> items,int capacity){

        this.items = items;
        this.capacity = capacity;
        NB_ITEMS = items.size();

    }

	/*
	bruteForceCalc Method
	Source: https://www.baeldung.com/java-knapsack

	Recursive Solution to the Knapsack Problem 

	The original solution returns an integer value for the solution. This
	solution uses the logic of the original to return a Knapsack object 
	which stores the information of the items and value. 

	*/

    public Knapsack bruteForceCalc (ArrayList <Item> items,int capacity, int num_items) {
		if (num_items <= 0) {
			Knapsack knapsack = new Knapsack(0);
			return knapsack;
		} 
		else if (items.get(num_items -1).getWeight() > capacity) {
			return bruteForceCalc(items, capacity, num_items - 1);
		} else {

			Knapsack ignore = bruteForceCalc(items,capacity, num_items - 1);
			Knapsack take = bruteForceCalc(items,capacity - items.get(num_items -1).getWeight(), num_items - 1);
			
			int ignoreVal = ignore.getValue();
			int takeVal = items.get(num_items - 1).getValue() + take.getValue();
			            
			if( Math.max(ignoreVal, takeVal) == ignoreVal ) 
				return ignore;
			else {
				take.addItem(items.get(num_items - 1));
				return take;
			}
		}
	}

}

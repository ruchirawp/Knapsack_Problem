//Name: Ruchira Perera
//Student #: 8714992

import java.util.ArrayList;

//Creates a table and solves for the maximum value and items in a knapsack problem 
public class KTable {
    

    ArrayList <Item> items;
    int capacity;
    int NB_ITEMS;
    Knapsack[][] table;

    public KTable(ArrayList <Item> items,int capacity){

        this.items = items;
        this.capacity = capacity;
        NB_ITEMS = items.size();
        table = new Knapsack[NB_ITEMS + 1][capacity + 1];
        findMaxValue();
        
    }


    /*
    findMaxValue Method
    Finds the highest value possible for a set of items and a given capacity 

	Source: https://ssaurel.medium.com/solving-the-knapsack-problem-in-java-c985c71a7e64

    The original solution uses a 2d int array. My implementation uses Knapsack
    objects to create a 2d array. 

	*/

    public void findMaxValue(){

        // first row is initialized to 0
        for (int i = 0; i <= capacity; i++){
            table[0][i] = new Knapsack(0);

        }
        // first column is initialized to 0
        for (int i = 0; i <= NB_ITEMS; i++){
            table[i][0] = new Knapsack(0);
        }

        // we iterate on items
        for (int i = 1; i <= NB_ITEMS; i++) {
            // we iterate on each capacity
            for (int j = 1; j <= capacity; j++) {
            if (items.get(i - 1).getWeight() > j)
                table[i][j] = table[i-1][j];
            else
                // we maximize value at this rank in the matrix
                table[i][j] = new Knapsack(Math.max(table[i-1][j].getValue(), 
                    table[i-1][j - items.get(i-1).getWeight()].getValue() + items.get(i-1).getValue()));
            }
        }


    }

    /*
    findItems Method
    finds the constituent items for the solution of the max value 

	Source: https://ssaurel.medium.com/solving-the-knapsack-problem-in-java-c985c71a7e64

    The original solution uses a 2d int array. My implementation uses Knapsack
    objects to create a 2d array. 

	*/
    public Solution findItems(){

        int res = table[NB_ITEMS][capacity].getValue();
        int w = capacity;

    for (int i = NB_ITEMS; i > 0  &&  res > 0; i--) {
      if (res != table[i-1][w].getValue()) {
        table[NB_ITEMS][capacity].addItem(items.get(i-1));
        // we remove items value and weight
        res -= items.get(i-1).getValue();
        w -= items.get(i-1).getWeight();
      }
    }
        return new Solution(table[NB_ITEMS][capacity]);
    }

}

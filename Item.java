//Name: Ruchira Perera
//Student #: 8714992

//Stores the attributes of an Item 
public class Item {

    //instance variables 
	int value;
    int weight;
    String name;

	
	public Item(String name, int value, int weight) {
		this.name = name;
		this.value = value;
		this.weight = weight;
	}
    
    /*
    Get methods for the attributes
    */

    public String getName(){
        return name;
    }

    public int getValue(){
        return value;
    }

    public int getWeight(){
        return weight;
    }


}

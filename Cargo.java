public class Cargo extends BoxCar{
    private int boxcarID;
    private String cargoID;
    private int weight;
    private int height;
    
    public void Cargo(int boxcarID, String cargoID, int weight, int height){
	this.boxcarID = boxcarID;
	this.cargoID = cargoID;
	this.weight = weight;
	this.height = height;
    }
    public int getBoxCarID(){
	return boxcarID;
    }
    public String getCargoID(){
	return cargoID;
    }
    public int getWeight(){
	return weight;
    }
    public int getHeight(){
	return height;
    }
    public void setWeight(int newWeight){
	this.weight = newWeight;
    }
    public void setHeight(int newHeight){
        this.height = newHeight;
    }
    public void setBoxCarID(int newID){
	this.boxcarID = newID;
    }
    public void setCargoID(String newID){
	this.cargoID = newID;
    }
    public void print(){
        System.out.println("          " + getCargoID() + ":   Weight: " + getWeight() + "  Height: " + getHeight());
    }

}
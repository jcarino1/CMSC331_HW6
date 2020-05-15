public class Person extends BoxCar{
    private int boxcarID;
    private String cargoID;
    private String name;
    private int age;

    public void Person(int boxcarID,String cargoID, String name, int age){
	this.boxcarID = boxcarID;
	this.cargoID = cargoID;
	this.name = name;
	this.age = age;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public String getCargoID(){
	return cargoID;
    }
    public int getBoxCarID(){
	return boxcarID;
    }
    public void setName(String newName){
        this.name = newName;
    }
    public void setAge(int newAge){
        this.age = newAge;
    }
    public void setCargoID(String newID){
        this.cargoID = newID;
    }
    public void setBoxCarID(int newID){
	this.boxcarID = newID;
    }
    public void print(){
        System.out.println("          " + getCargoID() + ":   Name: " + getName() + "         " + getAge());
    }


}
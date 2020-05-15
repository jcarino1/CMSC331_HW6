public class BoxCar{
    private String type;
    private int size;
    private Object[] BoxCar = new Object[15];
    private int counter;

    public void BoxCar(){

    }    
    public void add(Object object){
        BoxCar[counter] = object;
	counter++;
    }
    public int getSizeOccupied(){
	int counter = 0;
        for(int i = 0; i < BoxCar.length; i++){
            if(BoxCar[i] != null){
		counter++;
            }
        }
        return counter;
    }

    public Object getObject(int i){
	return BoxCar[i];
    }

    public int getSize(){
	return size;
    }
    public void setSize(int newSize){
	this.size = newSize;
    }
    public String getType(){
        return type;
    }
    public void setType(String newType){
        this.type = newType;
    }

}
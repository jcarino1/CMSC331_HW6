public class Train{
    private int CurrSpeed;
    private int MaxSpeed;
    private int MinSpeed;
    private String position;
    private int numCars;
    private int maxCars;
    private int counter;
    private boolean departed;
    private boolean arrived;
    private String Start;
    private BoxCar[] train = new BoxCar[15];
    public void Train(){
	this.departed = false;
	this.arrived = false;
    }

    public void Train(int CurrSpeed, int MaxSpeed, int MinSpeed, String position, int numCars,int maxCars){
        this.CurrSpeed = CurrSpeed;
        this.MaxSpeed = MaxSpeed;
        this.MinSpeed = MinSpeed;
        this.position = position;
        this.numCars = numCars;
        this.maxCars = maxCars;
	this.train = new BoxCar[15];
    }

    public void Arrive(){
	this.arrived = true;
    }
    public int getSize(){
	int counter = 0;
	for(int i = 0; i < train.length; i++){
	    if(train[i] != null){
		counter++;
	    }
	}
	numCars = counter;
	return counter;
    }
    public void removeCar(int i){
	if(departed == true && arrived == false){
	    System.out.println("ERROR: The train has not arriaved in yet. ");
	}
	if(arrived == true){
	    train[i] = null;
	}
		
    }
    public boolean check(String type, String ID){
	for(int i = 0; i < getSize(); i++){
	    if(train[i].getType().equals(type)){
		for(int j = 0; j < train[i].getSize(); j++){
		    //if(train[i].getObject(j).getCargoID().equals(ID)){
		    Object arr = train[i].getObject(j);
		    //System.out.println(arr);
		    return true;
		}
	    }
	}
	return false;
    }
    public boolean isEmpty(String type){
	for(int i = 0; i < getSize(); i++){
            if(train[i].getType().equals(type)){
                if(train[i].getSizeOccupied() == 0){
                    return true;
                }
            }
        }
	return false;
    }
    public boolean isFull(String type){
	for(int i = 0; i < getSize(); i++){
            if(train[i].getType().equals(type)){
		if(train[i].getSizeOccupied() == train[i].getSize()){
		    return true;
		}
	    }
	}
	return false;
    }
    public void addPerson(Object object){
	for(int i = 0; i < getSize(); i++){
	    if(train[i].getType().equals("PERSON")){
		if(isFull("PERSON") == false){
		    train[i].add(object);
		}
	    }
	}

    }

    public void addCargo(Object object){
        for(int i = 0; i < getSize(); i++){
            if(train[i].getType().equals("CARGO")){
                if(isFull("CARGO") == false){
                    train[i].add(object);
                }
            }
        }

    }
    public void SpeedUp(int speed){
	if(departed == true){
	    if((getSpeed()+speed) >= getMaxSpeed()){
		System.out.println("  ERROR: Speed can not be increased, it would exceed it's maximum speed. ");
	    }else{
		setSpeed((getSpeed()+speed));
	    }
	}else{
	    System.out.println("  ERROR: The Train has not departed yet.");
	}
    }
    public void SlowDown(int speed){
        if(departed == true){
            if((getSpeed()-speed) <= getMinSpeed()){
                System.out.println("  ERROR: Speed can not be increased, it would exceed it's maximum speed.");
            }else{
                setSpeed(getSpeed()-speed);
            }
        }else{
            System.out.println("  ERROR: The Train has not departed yet.");
        }
    }

    public void Depart(){
	this.departed = true;
    }

    public void add(BoxCar object){
	train[counter] = object;
	counter++;
    }

    public Object getObject(int i){
	return train[i];
    }

    public int getSpeed(){
	return CurrSpeed;
    }

    public int getMaxSpeed(){
	return MaxSpeed;
    }

    public int getMinSpeed(){
	return MinSpeed;
    }

    public int getNumCars(){
	return getSize();
    }

    public int getMax(){
	return maxCars;
    }
    public String getStart(){
	return Start;
    }

    public String getPosition(){
	return position;
    }

    public void setSpeed(int newSpeed){
    	this.CurrSpeed = newSpeed;
    }

    public void setNumCars(int newNum){
        this.numCars = newNum;
    }

    public void setMax(int newMax){
	this.maxCars = newMax;
    }
    
    public void setMinSpeed(int newSpeed){
	this.MinSpeed = newSpeed;
    }

    public void setMaxSpeed(int newSpeed){
	this.MaxSpeed = newSpeed;
    }

    public void setPosition(String newPosition){
	if(arrived == true){
	    this.position = "Stopped in "  + newPosition;
	}else if(departed == true){
	    this.position = "Traveling from " + Start + " to " + newPosition;
	}else{
	    this.position = "Stopped in  "  + newPosition;
	    this.Start = newPosition;
	}
	
    }

    public void print(){
        System.out.println("Train Status");
        System.out.println("------------");
        System.out.println("     Current Speed: " + getSpeed());
        System.out.println("     Minimum Speed: " + getMinSpeed());
        System.out.println("     Maximum Speed: " + getMaxSpeed());
        System.out.println("     Current Position: " + getPosition());
        System.out.println("     Current Number of BoxCars: " + getNumCars());
	System.out.println("     Maximum Number of BoxCars: " + getMax());
	System.out.println();
    }
    
}
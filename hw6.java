import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class hw6{
    public static void main(String[] args){
	String line = "";
	String [] commands = new String[81];
	int i = 0;

        try{
            Scanner input = new Scanner( new FileInputStream("train_commands.txt"));
            while(input.hasNextLine()){
		line = input.nextLine();
		commands[i] = line;
		i++;
	    }
        }
        catch(FileNotFoundException ex){
	    System.err.println("Could not open file words.txt");
	}
	
	int size = commands.length;
	
	List<Person> person = new ArrayList<Person>();
	List<Cargo> cargo = new ArrayList<Cargo>();

	Train t = new Train();
	t.setMax(3);
	t.setMinSpeed(10);
	t.setMaxSpeed(50);
	t.setPosition("New York");
	
	for(int j = 0; j < size; j++ ){
	    if(commands[j].equals("PRINT")){
		System.out.println(commands[j]);
		t.print();
		if(t.getSize() > 0){
		    for(int p = 0; p < t.getSize(); p++){
			if(p==0){
			    System.out.println("     BoxCar: " + p);
			    System.out.println("     ----------");
			    System.out.println("     Contents: ");
			    for(int m = 0; m < person.size(); m++){
				person.get(m).print();
			    }
			}else if(p == 1){
			    System.out.println("     BoxCar: " + p);
			    System.out.println("     ----------");
			    System.out.println("     Contents: ");
			    for(int n = 0; n < cargo.size(); n++){
				cargo.get(n).print();
			    }
			}
			System.out.println();
		    }
		}
	    }else if(commands[j].equals("ADDCAR")){
		System.out.println(commands[j] + " " + commands[j+1] + " " + commands[j+2]);
		++j;
		BoxCar b = new BoxCar();
		b.setType(commands[j]);
		++j;
		b.setSize(Integer.parseInt(commands[j]));
		t.add(b);
	    }else if(commands[j].equals("LOAD")){
		++j;
		if(commands[j].equals("PERSON")){
		    System.out.println(commands[j-1] + " " + commands[j+1] + " " + commands[j+2] + " " + commands[j+3] + " " + commands[j+4]);
		    Person p = new Person();
		    ++j;
		    p.setBoxCarID(Integer.parseInt(commands[j]));
		    ++j;
		    p.setCargoID(commands[j]);
		    ++j;
		    p.setName(commands[j]);
		    ++j;
		    p.setAge(Integer.parseInt(commands[j]));
		    
		    if(t.isFull("PERSON") == false){
			t.check("PERSON", p.getCargoID());
			if(j == 12){
                            t.addPerson(p);
                            person.add(p);
                        }else{
			    for(Person element: person){
				if(p.getCargoID().equals(element.getCargoID())){
				    System.out.println("  ERROR: Invalid item, item with id " + p.getCargoID() + " already exists. ");
				    break;
				}else{
                                    t.addPerson(p);
                                    person.add(p);
				    break;
				}
			    }
			}
		    }else{
			System.out.println("  ERROR: Not enough room for the given item.");
		    }
		}else{
		    System.out.println(commands[j-1] + " " + commands[j+1] +  " " + commands[j+3] + " " + commands[j+4]);
		    Cargo c = new Cargo();
		    ++j;
                    c.setBoxCarID(Integer.parseInt(commands[j]));
		    ++j;
                    c.setCargoID(commands[j]);
                    ++j;
                    c.setWeight(Integer.parseInt(commands[j]));
                    ++j;
                    c.setHeight(Integer.parseInt(commands[j]));
		    
		    if(t.isFull("CARGO") == false){
                        t.check("CARGO", c.getCargoID());
                        if(j == 36){
                            t.addCargo(c);
                            cargo.add(c);
                        }else{
                            for(Cargo element: cargo){
                                if(c.getCargoID().equals(element.getCargoID())){
                                    System.out.println("  ERROR: Invalid item, item with id " + c.getCargoID() + " already exists. ");
                                    break;
                                }else{
                                    t.addCargo(c);
                                    cargo.add(c);
                                    break;
                                }
                            }
                        }
		    }else{
                        System.out.println("  ERROR: Not enough room for the given item.");
                    }
		}
	    }else if(commands[j].equals("SPEEDUP")){
		System.out.println(commands[j] + " " + commands[j+1]);
		++j;
		t.SpeedUp(Integer.parseInt(commands[j]));
	    }else if(commands[j].equals("SLOWDOWN")){
		System.out.println(commands[j] + " " + commands[j+1]);
		++j;
		t.SlowDown(Integer.parseInt(commands[j]));
	    }else if(commands[j].equals("UNLOAD")){
		System.out.println(commands[j] + " " + commands[j+1] + " " + commands[j+2]);
		++j;
		if(commands[j].equals("1")){
		    ++j;
		    for(int n = 0; n < cargo.size(); n++){
			if(cargo.get(n).getCargoID().equals(commands[j])){
			    cargo.remove(n);
			}else{
			    System.out.println("    ERROR: Invalid item id, item not found");
			}
		    }
		}else{
		    ++j;
                    for(int n = 0; n < person.size(); n++){
                        if(person.get(n).getCargoID().equals(commands[j])){
                            person.remove(n);
                        }
			
                    }
		}
	    }else if(commands[j].equals("REMOVECAR")){
		System.out.println(commands[j] + " " + commands[j+1]);
		++j;
		if(cargo.size() == 0 || person.size() == 0){
		    t.removeCar(Integer.parseInt(commands[j]));
		}else{
		    System.out.println("    ERROR: BoxCar: " + commands[j] + ", is not empty. ");
		}
	    }else if(commands[j].equals("DEPART")){
		System.out.println(commands[j] + " " + commands[j+1]);
		t.Depart();
		++j;
		t.setPosition(commands[j]);
		
	    }else if(commands[j].equals("ARRIVE")){
		System.out.println(commands[j]);
		t.Arrive();
		t.setPosition("Chicago");
		t.setSpeed(0);
	    }else if(commands[j].equals("QUIT")){
		System.out.println(commands[j]);
		System.out.println("Quitting.......");
		System.exit(0);
	    }
	}
	
    }
}

	    
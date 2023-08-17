import java.util.ArrayList;
import java.util.Arrays;

public class Application {

	public static void main(String[] args) {
		//all Exceptions are represented ABOVE their respective testing group
		StringBuilder sb = new StringBuilder("==================================\n\n");
		sb.append("         Location Tests\n\n");
		sb.append("==================================\n\n");
		
		Location l1 = new Location(1,1);
		Location l2 = new Location(5,4);
		Location badLoc = new Location(-1,6);
		Location origin = new Location(0,0);
		
		sb.append(l1.getxCoord() + " || " + l1.getyCoord() + "\n");
		sb.append(l2.getxCoord() + " || " + l2.getyCoord() + "\n");
		
		l1.setxCoord(68);
		l1.setyCoord(7);
		l2.update(8, 6);
		
		sb.append(l1.getxCoord() + " || " + l1.getyCoord() + "\n");
		sb.append(l2.getxCoord() + " || " + l2.getyCoord() + "\n");
		
		l1.setxCoord(-5);//Causes InvalidCoordinateException
		
		sb.append(l1.getxCoord() + " || " + l1.getyCoord() + "\n");
		
		sb.append(Arrays.toString(l2.getCoordinates()) + "\n");
		
		sb.append(l2.toString() + "\n");
		
		
		System.out.print(sb.toString() + "\n\n");
		sb.setLength(0);
		
		sb.append("==================================\n\n");
		sb.append("          Animal Tests\n\n");
		sb.append("==================================\n\n");
		
		//Animal a1 = new Animal();
		//above code will result in an error since Animal is Abstract
		Animal ani = new Goldfinch(); //Causes InvalidSimIDException
		sb.append(ani.toString()+ "\n"); 
		sb.append(ani.getSimID() + "\n");
		sb.append(ani.getLocation() + "\n");
		sb.append(ani.isFull() + "\n");
		sb.append(ani.isRested() + "\n");
		
		ani.setFull(true);
		ani.setRested(false);
		ani.setLocation(l2);
		ani.setSimID(99);
		sb.append(ani.toString()+ "\n"); 
		
		ani.eat();
		sb.append(ani.isFull() + "\n");
		ani.sleep();
		sb.append(ani.isRested() + "\n");
		sb.append(ani.toString()+ "\n");
		
		ani.setSimID(-6); //causes InvalidSimIDException
		
		//ani.getWingSpan();
		//code above results in an error because Animal does not have access to the Goldfinch method getWingSpan()
		
		
		System.out.print(sb.toString() + "\n\n");
		sb.setLength(0);
		
		sb.append("==================================\n\n");
		sb.append("         Goldfinch Tests\n\n");
		sb.append("==================================\n\n");
		
		Goldfinch g1 = new Goldfinch();//Causes InvalidSimIDException
		Goldfinch g2 = new Goldfinch(1,l1,8.7);
		
		sb.append(g1.toString()+ "\n"); 
		sb.append(g2.toString()+ "\n"); 
		
		sb.append(g1.getWingSpan()+ "\n"); 
		
		g1.setWingSpan(4.9);//Causes InvalidWingspanException
		sb.append(g1.getWingSpan()+ "\n"); //keeps original value for wingspan of 9.0
		g1.setWingSpan(11.1);//Causes InvalidWingspanException
		sb.append(g1.getWingSpan()+ "\n"); //keeps original value for wingspan of 9.0
		g1.setWingSpan(10.5);
		sb.append(g1.getWingSpan()+ "\n");
		
		sb.append(g1.getLocation()+ "\n");
		g1.fly(l1);
		sb.append(g1.getLocation()+ "\n");
		g1.fly(badLoc);//Exception caught earlier, will not throw an exception here.
		sb.append(g1.getLocation()+ "\n");
		
		g1.setLocation(origin);
		g1.walk(-1);//Causes InvalidCoordinateException (X)
		sb.append(g1.getLocation()+ "\n");
		g1.walk(-2);//Causes InvalidCoordinateException (Y)
		sb.append(g1.getLocation()+ "\n");
		g1.walk(1);
		g1.walk(2);
		sb.append(g1.getLocation()+ "\n");
		g1.walk(3);//Prints switch case error message
		

		System.out.print(sb.toString() + "\n\n");
		sb.setLength(0);
		
		sb.append("==================================\n\n");
		sb.append("         BrownBear Tests\n\n");
		sb.append("==================================\n\n");
		
		BrownBear b1 = new BrownBear();//Causes InvalidSimIDException
		BrownBear b2 = new BrownBear(2,l2,"Grizzly");
		
		sb.append(b1.toString()+ "\n"); 
		sb.append(b2.toString()+ "\n"); 
		
		sb.append(b1.getSubSpecies()+ "\n");
		sb.append(b2.getSubSpecies()+ "\n");
		
		b1.setSubSpecies("not a bear");//Causes InvalidSubspeciesException
		sb.append(b1.getSubSpecies()+ "\n");
		b1.setSubSpecies("Kodiak");
		sb.append(b1.getSubSpecies()+ "\n");
		
		sb.append(b2.getLocation() + "\n");
		b2.setLocation(l1);
		sb.append(b2.getLocation() + "\n");
		
		sb.append(b1.getLocation() + "\n");
		b1.walk(-1);//Causes InvalidCoordinateException (X)
		sb.append(b1.getLocation()+ "\n");
		b1.walk(-2);//Causes InvalidCoordinateException (Y)
		sb.append(b1.getLocation()+ "\n");
		b1.walk(1);
		b1.walk(2);
		sb.append(b1.getLocation()+ "\n");
		b1.walk(3);//Prints switch case error message
		
		b1.swim(-2);
		b1.swim(-1);
		sb.append(b1.getLocation()+ "\n");
		b1.swim(-2);//Causes InvalidCoordinateException (Y)
		sb.append(b1.getLocation()+ "\n");
		b1.swim(-1);//Causes InvalidCoordinateException (X)
		sb.append(b1.getLocation()+ "\n");
		b1.swim(3);//Prints switch case error message
		
		
		System.out.print(sb.toString() + "\n\n");
		sb.setLength(0);
		
		sb.append("==================================\n\n");
		sb.append("         Generics Tests\n\n");
		sb.append("==================================\n\n");
		
		Animal a1 = new Goldfinch();//Causes InvalidSimIDException
		Animal a2 = new Goldfinch(1,l1,8.7);
		
		Animal a3 = new BrownBear();//Causes InvalidSimIDException
		Animal a4 = new BrownBear(2,l2,"Grizzly");
		ArrayList<Animal> arAni = new ArrayList<Animal>();
		arAni.add(a1);
		arAni.add(a2);
		arAni.add(a3);
		arAni.add(a4);
		
		for (int i=0;i<arAni.size();i++) {
			sb.append(arAni.get(i).toString() + "\n");
		}
		
		System.out.print(sb.toString());
		
		
	}

}

import java.util.Arrays;
import java.util.List;

public class BrownBear extends Animal implements Walkable,Swimmable {
	private String[] subS = new String[]{"Alaskan","Asiatic","European","Grizzly","Kodiak","Siberian"};
	private List<String> validSS = Arrays.asList(subS);
	private String subSpecies;
	
	public BrownBear() {
		super();
		setSubSpecies("Alaskan");
	}
	public BrownBear(int simID, Location l, String subSpecies) {
		super(simID,l);
		setSubSpecies(subSpecies);
	}
	public String getSubSpecies() {
		return subSpecies;
	}
	public void setSubSpecies(String subSpecies) {
		try {
			if (validSS.contains(subSpecies)==false) {
				throw new InvalidSubspeciesException("Invalid Subspecies");
			}
			else {
				this.subSpecies = subSpecies;
			}
		} catch (InvalidSubspeciesException e) {
			System.out.println(e);
		}
	}
	@Override
	public String toString() {
		return "BrownBear [subSpecies=" + subSpecies + ", simID=" + simID
				+ ", location=" + location + ", full=" + full + ", rested=" + rested + "]";
	}
	@Override
	public void walk(int direction) {
		try {
			switch (direction) {
			case -1: 
				if ((this.location.getxCoord() - 3) < 0) {
					throw new InvalidCoordinateException("Invalid X Coordinate");
				}
				else {
					this.location.setxCoord(this.location.getxCoord()-3);
				}
				break;
			case -2:
				if ((this.location.getyCoord() - 3) < 0) {
					throw new InvalidCoordinateException("Invalid Y Coordinate");
				}
				else {
					this.location.setyCoord(this.location.getyCoord()-3);
				}
				break;
			case 1:
				this.location.setxCoord(this.location.getxCoord()+3);
				break;
			case 2: 
				this.location.setyCoord(this.location.getyCoord()+3);
				break;
			default:
				System.out.println("Entered direction value is invalid.");
				break;
			}
			this.location.update(this.location.getxCoord(),this.location.getyCoord());
		} catch (InvalidCoordinateException e) {
			System.out.println(e);
		}
		
	}
	@Override
	public void swim(int direction) {
		try {
			switch (direction) {
			case -1: 
				if ((this.location.getxCoord() - 2) < 0) {
					throw new InvalidCoordinateException("Invalid X Coordinate");
				}
				else {
					this.location.setxCoord(this.location.getxCoord()-2);
				}
				break;
			case -2:
				if ((this.location.getyCoord() - 2) < 0) {
					throw new InvalidCoordinateException("Invalid Y Coordinate");
				}
				else {
					this.location.setyCoord(this.location.getyCoord()-2);
				}
				break;
			case 1:
				this.location.setxCoord(this.location.getxCoord()+2);
				break;
			case 2: 
				this.location.setyCoord(this.location.getyCoord()+2);
				break;
			default:
				System.out.println("Entered direction value is invalid.");
				break;
			}
			this.location.update(this.location.getxCoord(),this.location.getyCoord());
		} catch (InvalidCoordinateException e) {
			System.out.println(e);
		}
		
	}
	
	
}

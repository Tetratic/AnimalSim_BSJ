
public class Goldfinch extends Animal implements Flyable,Walkable {
	private double wingSpan;
	
	public Goldfinch() {
		super();
		setWingSpan(9.0);
	}
	public Goldfinch(int simID, Location l, double ws) {
		super(simID,l);
		setWingSpan(ws);
	}
	public double getWingSpan() {
		return wingSpan;
	}
	public void setWingSpan(double wingSpan) {
		try {
			if (wingSpan < 5.0 || wingSpan > 11.0) {
				throw new InvalidWingspanException("Invalid Wingspan");
			}
			else {
				this.wingSpan = wingSpan;
			}
		} catch(InvalidWingspanException e){
			System.out.println(e);
		}
	}
	@Override
	public String toString() {
		return "Goldfinch [wingSpan=" + wingSpan + ", simID=" + simID + ", location=" + location + ", full=" + full
				+ ", rested=" + rested + "]";
	}
	@Override
	public void fly(Location l) {
		try{
			if (l.getxCoord()<0 || l.getyCoord()<0) {
				throw new InvalidCoordinateException("Coordinates Out of Bounds");
			}
			else {
				this.setLocation(l);
			}
		} catch (InvalidCoordinateException e) {
			System.out.println(e);
		}
		
	}
	@Override
	public void walk(int direction) {
		try {
			switch (direction) {
			case -1: 
				if ((this.location.getxCoord() - 1) < 0) {
					throw new InvalidCoordinateException("Invalid X Coordinate");
				}
				else {
					this.location.setxCoord(this.location.getxCoord()-1);
				}
				break;
			case -2:
				if ((this.location.getyCoord() - 1) < 0) {
					throw new InvalidCoordinateException("Invalid Y Coordinate");
				}
				else {
					this.location.setyCoord(this.location.getyCoord()-1);
				}
				break;
			case 1:
				this.location.setxCoord(this.location.getxCoord()+1);
				break;
			case 2: 
				this.location.setyCoord(this.location.getyCoord()+1);
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

import java.util.Random;

public abstract class Animal {
	protected int simID;
	protected Location location;
	protected boolean full, rested;
	
	protected Location pholdLoc = new Location();
	
	public Animal() {
		setSimID(0);
		setLocation(pholdLoc);
		setFull(false);
		setRested(true);
	}
	public Animal(int simID, Location l) {
		setSimID(simID);
		setLocation(l);
		setFull(false);
		setRested(true);
	}
	
	public int getSimID() {
		return simID;
	}
	public void setSimID(int simID) {
		try {
			if (simID <= 0) {
				throw new InvalidSimIDException("Invalid SimID");
			}
			else {
				this.simID = simID;
			}
		} catch (InvalidSimIDException e) {
			System.out.println(e);
		}
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public boolean isFull() {
		return full;
	}
	public void setFull(boolean full) {
		this.full = full;
	}
	public boolean isRested() {
		return rested;
	}
	public void setRested(boolean rested) {
		this.rested = rested;
	}
	
	public boolean eat() {
		Random r = new Random();
		double e = r.nextDouble();
		//System.out.println(e);
		//for testing purposes, uncomment to see the value in line 3 of the console output
		if (e>0.5) {
			full = true;
		}
		else {
			full = false;
		}
		return full;
	}
	
	public boolean sleep() {
		Random r = new Random();
		double e = r.nextDouble();
		//System.out.println(e);
		//for testing purposes, uncomment to see the value in line 3 of the console output
		if (e>0.5) {
			rested = true;
		}
		else {
			rested = false;
		}
		return rested;
	}
}

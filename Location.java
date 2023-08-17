
public class Location {
	private int xCoord,yCoord;
	
	public Location() {
		this.setxCoord(0);
		this.setyCoord(0);
	}
	public Location(int x, int y) {
		this.setxCoord(x);
		this.setyCoord(y);
	}
	
	public int getxCoord() {
		return xCoord;
	}
	public void setxCoord(int xCoord) {
		try {
			if(xCoord<0) {
				throw new InvalidCoordinateException("Invalid X Coordinate");
			}
			else {
				this.xCoord = xCoord;
			}
		} catch (InvalidCoordinateException e) {
			System.out.println(e);
		}
	}
	public int getyCoord() {
		return yCoord;
	}
	public void setyCoord(int yCoord) {
		try {
			if(yCoord<0) {
				throw new InvalidCoordinateException("Invalid Y Coordinate");
			}
			else {
				this.yCoord = yCoord;
			}
		} catch (InvalidCoordinateException e) {
			System.out.println(e);
		}
	}
	
	public void update(int x, int y) {
		setxCoord(x);
		setyCoord(y);
	}
	public int[] getCoordinates() {
		int[] ar = new int[]{this.getxCoord(),this.getyCoord()};
		return ar;
	}
	@Override
	public String toString() {
		return "Location [xCoord=" + xCoord + ", yCoord=" + yCoord + "]";
	}
	
}

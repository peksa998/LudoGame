package client;

public class FieldC {
	
	private int index;
	private boolean isSafe;
	private boolean isBase;
	private int colour = -1; // -1 ako polje nema boju
	private int coordinate_x;
	private int coordinate_y;
	
	PawnC[] pawnsOnField = new PawnC[16];

	public FieldC(int index, boolean isSafe, boolean isBase, int colour, int coordinate_x, int coordinate_y) {
		super();
		this.index = index;
		this.isSafe = isSafe;
		this.isBase = isBase;
		this.colour = colour;
		this.coordinate_x = coordinate_x;
		this.coordinate_y = coordinate_y;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public boolean isSafe() {
		return isSafe;
	}

	public void setSafe(boolean isSafe) {
		this.isSafe = isSafe;
	}

	public boolean isBase() {
		return isBase;
	}

	public void setBase(boolean isBase) {
		this.isBase = isBase;
	}

	public int getColour() {
		return colour;
	}

	public void setColour(int colour) {
		this.colour = colour;
	}

	public int getCoordinate_x() {
		return coordinate_x;
	}

	public void setCoordinate_x(int coordinate_x) {
		this.coordinate_x = coordinate_x;
	}

	public int getCoordinate_y() {
		return coordinate_y;
	}

	public void setCoordinate_y(int coordinate_y) {
		this.coordinate_y = coordinate_y;
	}

	public PawnC[] getPawnsOnField() {
		return pawnsOnField;
	}

	public void setPawnsOnField(PawnC[] pawnsOnField) {
		this.pawnsOnField = pawnsOnField;
	}
	
	
	

}
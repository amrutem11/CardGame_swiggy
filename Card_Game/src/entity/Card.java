package entity;

public class Card {

	private int value;

	private Colors color;

	private boolean special;

	private Shapes shape;

	// constructor
	public Card(int value, boolean special, Shapes shape) {

		this.value = value;
		this.special = special;
		this.shape = shape;
	}

	public Card(int value, Shapes shape) {

		this.value = value;
		this.shape = shape;
	}

	// getter and setters to get and set the values
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Shapes getShape() {
		return shape;
	}

	public void setShape(Shapes shape) {
		this.shape = shape;
	}

	public Colors getColour() {
		return color;
	}

	public void setColour(Colors color) {
		this.color = color;
	}

	// to check if the card is special action card.
	public boolean isSpecial() {
		// return special;

		if (value > 9) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "Card [value=" + value + ", colour=" + color + ", special=" + special + ", shape=" + shape + "]";
	}

}

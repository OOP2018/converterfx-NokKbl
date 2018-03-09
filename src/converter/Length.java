package converter;

public enum Length {
	Meter(1.0000),
	Centimeter(0.0100),
	Kilometer(1000.0),
	Mile(1609.344),
	Foot(0.30480),
	Wa(2.00000),
	AU(149597870700L);
	
	private final double value;
	
	private Length(double value) {
		this.value = value;
	}
	
	public double getValue() {
		return this.value;
	}
	
	public static void main(String[] args) {
		Length[] lengths = Length.values();
		 // use the values
		 for(Length x : lengths)
		 System.out.println(x.toString()+" = "+x.getValue());
	}
}

package converter;

/**
 * Length enum is a class with a fixed set of static instances for Length units.
 * @author Kunyaruk Katebunlu
 */
public enum Length {
	/** enum members */
	Meter(1.0000),
	Centimeter(0.0100),
	Kilometer(1000.0),
	Mile(1609.344),
	Foot(0.30480),
	Wa(2.00000),
	AU(149597870700L);
	
	/** attributes of the enum numbers */
	private final double value;
	
	/**
	 * Constructor of Length.
	 * @param value is an input value.
	 */
	private Length(double value) { this.value = value; }
	
	/**
	 * Return a value of the Length units.
	 * @return value of Length units.
	 */
	public double getValue() { return this.value; }
}

import java.text.DecimalFormat;

public class Conversiones {
	DecimalFormat df = new DecimalFormat("0.00");

	// CELSIUS
	public String centigradosF(double g) {
		double conversion = (g * 9 / 5) + 32;
		return df.format(conversion);
	}

	public String centigradosK(double g) {
		double conversion = g + 273.15;
		return df.format(conversion);
	}

	public String centigradosR(double g) {
		double conversion = g * 9 / 5 + 491.67;
		return df.format(conversion);
	}

	// FAHRENHEIT
	public String fahrenheitC(double g) {
		double conversion = (g - 32) * 5 / 9;
		return df.format(conversion);
	}

	public String fahrenheitK(double g) {
		double conversion = (g - 32) * 5 / 9 + 273.15;
		return df.format(conversion);
	}

	public String fahrenheitR(double g) {
		double conversion = g + 459.67;
		return df.format(conversion);
	}

	// KELVIN
	public String kelvinF(double g) {
		double conversion = (g - 273.15) * 9 / 5 + 32;
		return df.format(conversion);
	}

	public String kelvinC(double g) {
		double conversion = g - 273.15;
		return df.format(conversion);
	}

	public String kelvinR(double g) {
		double conversion = g * 1.8;
		return df.format(conversion);
	}

	// RANKINE
	public String rankineF(double g) {
		double conversion = g - 459.67;
		return df.format(conversion);
	}

	public String rankineC(double g) {
		double conversion = (g - 491.67) * 5 / 9;
		return df.format(conversion);
	}

	public String rankineK(double g) {
		double conversion = g * 5/9;
		return df.format(conversion);
	}
}

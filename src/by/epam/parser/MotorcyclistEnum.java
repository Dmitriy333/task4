package by.epam.parser;
enum MotorcyclistEnum {
	MOTORCYCLISTS("motorcyclists"),
	MOTORCYCLIST("motorcyclist"),
	HELMET("helmet"),
	JACKET("jacket"),
	GLOVES("gloves"),
	PANTS("pants"),
	BOOTS("boots"),
	WEIGHT("weight"),
	PRICE("price"),
	ID("id"),
	SIZECL("sizecl"),
	GLASS("glass"),
	COLOR("color"),
	FIRM("firm"),
	MATERIAL("material"),
	DESIGN("design"),
	MODEL("model"),
	KNEEPROTECTION("kneeprotection"),
	VENTILATION("ventilation"),
	FASTENERS("fasteners")
	;
	private String value;

	private MotorcyclistEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}

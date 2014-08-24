package by.epam.substances.clothes;

public class Pants extends Cloth {
	private String madeof;
	private String kneeProtection;
	private String size;

	public String getMadeof() {
		return madeof;
	}

	public void setMadeof(String madeof) {
		this.madeof = madeof;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString())
		.append("; Material: ")
		.append(this.getMadeof())
		.append("; Knee protection: ")
		.append(this.getKneeProtection())
		.append("; Size: ")
		.append(this.getSize());
		return sb.toString();
	}

	public String getKneeProtection() {
		return kneeProtection;
	}

	public void setKneeProtection(String kneeProtection) {
		this.kneeProtection = kneeProtection;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
}

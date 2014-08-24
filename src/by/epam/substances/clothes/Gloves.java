package by.epam.substances.clothes;

public class Gloves extends Cloth{
	private String ventilation;
	private String size;

	public String getVentilation() {
		return ventilation;
	}

	public void setVentilation(String ventilation) {
		this.ventilation = ventilation;
	}
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString())
		.append("; Ventilation technology: ")
		.append(this.getVentilation())
		.append("; Size: ")
		.append(this.getSize());
		return sb.toString();
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
}


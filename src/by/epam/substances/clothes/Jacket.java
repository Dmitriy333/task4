package by.epam.substances.clothes;

public class Jacket extends Cloth {
	private String madeof;
	private String model;
	private String size;
	public String getMadeof() {
		return madeof;
	}

	public void setMadeof(String madeof) {
		this.madeof = madeof;
	}
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString()).
		append("; Material: ").
		append(this.getMadeof()).
		append("; Model: ")
		.append(this.getModel())
		.append("; Size: ")
		.append(this.getSize());
		return sb.toString() ;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
}
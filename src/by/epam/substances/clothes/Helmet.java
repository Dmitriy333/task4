package by.epam.substances.clothes;

public class Helmet extends Cloth {
	private String firm;
	private String design;
	private String glass;
	private String color;
	private String size;
	public String getFirm() {
		return firm;
	}

	public void setFirm(String firm) {
		this.firm = firm;
	}

	public String getDesign() {
		return design;
	}

	public void setDesign(String design) {
		this.design = design;
	}
	
	public String getGlass() {
		return glass;
	}

	public void setGlass(String glass) {
		this.glass = glass;
	}
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString()).
		append("; Firm: ").
		append(this.getFirm()).
		append("; Design: ").
		append(this.getDesign()).
		append("; Glass: ").
		append(this.getGlass()).
		append("; Color: ").
		append(this.getColor()).
		append("; Size: ").
		append(this.getSize());
		return sb.toString();
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

}
package by.epam.substances.clothes;

public class Boots extends Cloth {
	private String firm;
	private String fasteners;

	public String getFirm() {
		return firm;
	}

	public void setFirm(String firm) {
		this.firm = firm;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString())
		.append("; Firm: ")
		.append(this.getFirm())
		.append("; Fasteners: ")
		.append(this.getFasteners());
		return sb.toString();
	}

	public String getFasteners() {
		return fasteners;
	}

	public void setFasteners(String fasteners) {
		this.fasteners = fasteners;
	}
	@Override
	public boolean equals(Object o){
		if(this == o){
			return true;
		}
		if(null == o){
			return false;
		}
		if(getClass() != o.getClass()){
			return false;
		}
		Boots boots = (Boots)o;
		if(super.equals(boots)&& boots.fasteners.equals(this.fasteners)&&boots.firm.equals(this.firm)){
			return true;
		}
		else{
			return false;
		}
	}

}
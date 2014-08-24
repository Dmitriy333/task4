package by.epam.substances.clothes;


public abstract class Cloth {
	private double weight;
	private double price;
	private int id;

	public double getWeight() {
		return weight;
	}

	public int getID() {
		return id;
	}

	public void setID(int id) throws NegativeNumberException {
			if (id > 0) {
				this.id = id;
			} else {
				throw new NegativeNumberException(
						"Проверьте правильность ввода id (отрицательное число)");
			}

	}

	public void setWeight(double weight) throws NegativeNumberException {
			if (weight < 0) {
				throw new NegativeNumberException(
						"Проверьте правильность ввода: вес (отрицательное число)");
			} else {
				this.weight = weight;
			}
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) throws NegativeNumberException {
			if (price < 0) {
				throw new NegativeNumberException(
						"Проверьте правильность ввода: цена (отрицательное число)");
			} else {
				this.price = price;
			}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getClass().getSimpleName())
				.append(": ID: ")
				.append(this.getID())
				.append(": Weight: ")
				.append(this.getWeight())
				.append("; Price: ")
				.append(this.getPrice());
		return sb.toString();
	}
	
	@Override
	public int hashCode(){
        int result = 1;
        result = (int) (weight*10*result + id);
		return result;
	}

}

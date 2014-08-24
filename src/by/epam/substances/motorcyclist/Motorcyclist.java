package by.epam.substances.motorcyclist;

import java.util.ArrayList;
import java.util.List;

import by.epam.substances.clothes.Cloth;

public class Motorcyclist {
	private String name;
	private List<Cloth> clothes = new ArrayList<Cloth>();

	public void addCloth(Cloth cloth) {
		clothes.add(cloth);
	}

	public Cloth getCloth(int n) {
		return clothes.get(n);
	}
	public void setCloth(Cloth cloth) {
		 clothes.add(cloth);
	}

	public List<Cloth> getClothList() {
		return clothes;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName())
		.append(" Name: ")
		.append(name)
		.append("\n");
		for (Cloth cloth : clothes) {
			sb.append(cloth).append("\n");
		}
		return sb.toString();
	}

}

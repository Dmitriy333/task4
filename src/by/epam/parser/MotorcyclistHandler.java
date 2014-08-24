package by.epam.parser;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import by.epam.substances.clothes.*;
import by.epam.substances.motorcyclist.Motorcyclist;



public class MotorcyclistHandler extends DefaultHandler {
	private ArrayList<Motorcyclist> motorcyclists;
	private Motorcyclist current = null;
	private MotorcyclistEnum currentEnum;
	private Cloth cloth;
	private Logger logger = Logger.getLogger(MotorcyclistHandler.class);

	public MotorcyclistHandler() {
		motorcyclists = new ArrayList<Motorcyclist>();
	}

	public ArrayList<Motorcyclist> getMotorcyclists() {
		return motorcyclists;
	}

	public void startElement(String uri, String localName, String qName,
			Attributes attrs) {
		if ("motorcyclist".equals(localName)) {
			current = new Motorcyclist();
			current.setName(attrs.getValue(0));
		}
		if ("helmet".equals(localName) || "jacket".equals(localName)
				|| "gloves".equals(localName) || "boots".equals(localName)
				|| "pants".equals(localName)) {
			switch(localName){
			case "helmet":
				cloth = new Helmet();
				break;
			case "pants":
				cloth = new Pants();
				break;
			case "gloves":
				cloth = new Gloves();
				break;
			case "boots":
				cloth = new Boots();
				break;
			case "jacket":
				cloth = new Jacket();
				break;
			}
			
		} else {
			currentEnum  = MotorcyclistEnum.valueOf(localName.toUpperCase());
		}

	}

	public void endElement(String uri, String localName, String qName) {
		if ("motorcyclist".equals(localName)) {
			motorcyclists.add(current);
		}
		if ("helmet".equals(localName) || "jacket".equals(localName)
				|| "gloves".equals(localName) || "boots".equals(localName)
				|| "pants".equals(localName)) {
			current.addCloth(cloth);
		}

	}

	public void characters(char[] ch, int start, int length) {
		String s = new String(ch, start, length).trim();
		if (currentEnum != null) {
			switch (currentEnum) {
			case ID:
				try {
					cloth.setID(Integer.valueOf(s));
				} catch (NumberFormatException e) {
					logger.error(e);
					e.printStackTrace();
				} catch (NegativeNumberException e) {
					logger.error(e);
					e.printStackTrace();
				}
				break;
			case WEIGHT:
				try {
					cloth.setWeight(Double.valueOf(s));
				} catch (NumberFormatException e) {
					logger.error(e);
					e.printStackTrace();
				} catch (NegativeNumberException e) {
					logger.error(e);
					e.printStackTrace();
				}
				break;
			case PRICE:
				try {
					cloth.setPrice(Double.valueOf(s));
				} catch (NumberFormatException e) {
					logger.error(e);
					e.printStackTrace();
				} catch (NegativeNumberException e) {
					logger.error(e);
					e.printStackTrace();
				}
				break;
			case FIRM:
				if(cloth instanceof Boots){
					((Boots)cloth).setFirm(s);
				}
				if(cloth instanceof Helmet){
					((Helmet)cloth).setFirm(s);
				}
				break;
			case MATERIAL:
				if(cloth instanceof Jacket){
					((Jacket)cloth).setMadeof(s);
				}
				if(cloth instanceof Pants){
					((Pants)cloth).setMadeof(s);
				}
				break;
			case FASTENERS:
				((Boots)cloth).setFasteners(s);
				break;
			case KNEEPROTECTION:
				((Pants)cloth).setKneeProtection(s);
				break;
			case VENTILATION:
				((Gloves)cloth).setVentilation(s);
				break;
			case MODEL:
				((Jacket)cloth).setModel(s);
				break;
			case DESIGN:
				((Helmet)cloth).setDesign(s);
				break;
			case GLASS:
				((Helmet)cloth).setGlass(s);
				break;
			case COLOR:
				((Helmet)cloth).setColor(s);
				break;
			case SIZECL:
				if(cloth instanceof Helmet){
					((Helmet)cloth).setSize(s);
				}
				if(cloth instanceof Jacket){
					((Jacket)cloth).setSize(s);
				}
				if(cloth instanceof Gloves){
					((Gloves)cloth).setSize(s);
				}
				if(cloth instanceof Pants){
					((Pants)cloth).setSize(s);
				}
				break;
			default:
//				throw new EnumConstantNotPresentException(
//						currentEnum.getDeclaringClass(), currentEnum.name());
			}
		}
		currentEnum = null;
	}
	
}

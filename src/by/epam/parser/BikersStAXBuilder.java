package by.epam.parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.apache.log4j.Logger;

import by.epam.substances.clothes.Boots;
import by.epam.substances.clothes.Cloth;
import by.epam.substances.clothes.Gloves;
import by.epam.substances.clothes.Helmet;
import by.epam.substances.clothes.Jacket;
import by.epam.substances.clothes.NegativeNumberException;
import by.epam.substances.clothes.Pants;
import by.epam.substances.motorcyclist.Motorcyclist;

public class BikersStAXBuilder extends ParserBuilder {
	private XMLInputFactory inputFactory;
	private Logger logger = Logger.getLogger(BikersStAXBuilder.class);

	public BikersStAXBuilder() {
		inputFactory = XMLInputFactory.newInstance();
		motorcyclists = new ArrayList<Motorcyclist>();
	}

	@Override
	public ArrayList<Motorcyclist> getMotorcyclists() {
		return motorcyclists;
	}

	@Override
	public void buildMotorcyclistsList(String fileName) {
		FileInputStream inputStream = null;
		XMLStreamReader reader = null;
		String name;
		try {
			inputStream = new FileInputStream(new File(fileName));
			reader = inputFactory.createXMLStreamReader(inputStream);
			while (reader.hasNext()) {
				int type = reader.next();
				if (type == XMLStreamConstants.START_ELEMENT) {
					name = reader.getLocalName();
					if (MotorcyclistEnum.valueOf(name.toUpperCase()) == MotorcyclistEnum.MOTORCYCLIST) {
						Motorcyclist current = buildMotorcyclist(reader);
						motorcyclists.add(current);
					}
				}
			}
		} catch (XMLStreamException e) {
			logger.error("StAX parsing error! " + e.getMessage());
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			logger.error("File " + fileName + " not found! " + e);
			e.printStackTrace();
		} finally {
			try {
				if (inputStream != null) {
					inputStream.close();
				}
			} catch (IOException e) {
				logger.error("Impossible close file " + fileName + " : "
						+ e);
				e.printStackTrace();
			}
		}
	}

	private Motorcyclist buildMotorcyclist(XMLStreamReader reader)
			throws XMLStreamException {
		Motorcyclist biker = new Motorcyclist();
		biker.setName(reader.getAttributeValue(0));
		String name;
		Cloth cloth;
		MotorcyclistEnum currentEnum;
		boolean in = true;
		while (reader.hasNext() & in) {
			int type = reader.next();
			switch (type) {
			case XMLStreamConstants.START_ELEMENT:
				name = reader.getLocalName();
				currentEnum = MotorcyclistEnum.valueOf(name.toUpperCase());
				switch (currentEnum) {
				case HELMET:
					cloth = new Helmet();
					getAttributesForCloth(biker,cloth,reader);
					break;
				case PANTS:
					cloth = new Pants();
					getAttributesForCloth(biker,cloth,reader);
					break;
				case GLOVES:
					cloth = new Gloves();
					getAttributesForCloth(biker,cloth,reader);
					break;
				case BOOTS:
					cloth = new Boots();
					getAttributesForCloth(biker,cloth,reader);
					break;
				case JACKET:
					cloth = new Jacket();
					getAttributesForCloth(biker,cloth,reader);
					break;
				default:
					break;
				}
				break;
			case XMLStreamConstants.END_ELEMENT:
				name = reader.getLocalName();
				if ("motorcyclist".equals(name)) {
					in = false;
				}
			break;
			}
		}
		return biker;
	}

	private void getAttributesForCloth(Motorcyclist motorcyclist, Cloth cloth, XMLStreamReader reader)
			throws XMLStreamException {
		String name;
		boolean in = true;
		MotorcyclistEnum currentEnum;
		while (reader.hasNext() && in) {
			int type = reader.next();
			switch (type) {
			case XMLStreamConstants.START_ELEMENT:
				String attr = reader.getElementText().trim();
				name = reader.getLocalName();
				currentEnum = MotorcyclistEnum.valueOf(name.toUpperCase());
				switch (currentEnum) {
				case ID:
					try {
						cloth.setID(Integer.valueOf(attr));
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
						cloth.setWeight(Double.valueOf(attr));
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
						cloth.setPrice(Double.valueOf(attr));
					} catch (NumberFormatException e) {
						logger.error(e);
						e.printStackTrace();
					} catch (NegativeNumberException e) {
						logger.error(e);
						e.printStackTrace();
					}
					break;
				case FIRM:
					if (cloth.getClass().equals(Boots.class)) {
						((Boots) cloth).setFirm(attr);
					}
					if (cloth.getClass().equals(Helmet.class)) {
						((Helmet) cloth).setFirm(attr);
					}
					break;
				case MATERIAL:
					if (cloth.getClass().equals(Jacket.class)) {
						((Jacket) cloth).setMadeof(attr);
					}
					if (cloth.getClass().equals(Pants.class)) {
						((Pants) cloth).setMadeof(attr);
					}
					break;
				case FASTENERS:
					((Boots) cloth).setFasteners(attr);
					break;
				case KNEEPROTECTION:
					((Pants) cloth).setKneeProtection(attr);
					break;
				case VENTILATION:
					((Gloves) cloth).setVentilation(attr);
					break;
				case MODEL:
					((Jacket) cloth).setModel(attr);
					break;
				case DESIGN:
					((Helmet) cloth).setDesign(attr);
					break;
				case GLASS:
					((Helmet) cloth).setGlass(attr);
					break;
				case COLOR:
					((Helmet) cloth).setColor(attr);
					break;
				case SIZECL:
					if (cloth.getClass().equals(Helmet.class)) {
						((Helmet) cloth).setSize(attr);
					}
					if (cloth.getClass().equals(Jacket.class)) {
						((Jacket) cloth).setSize(attr);
					}
					if (cloth.getClass().equals(Gloves.class)) {
						((Gloves) cloth).setSize(attr);
					}
					if (cloth.getClass().equals(Pants.class)) {
						((Pants) cloth).setSize(attr);
					}
					break;
				default:
					break;
				}
				break;
			case XMLStreamConstants.END_ELEMENT:
				name = reader.getLocalName();
				if ("helmet".equals(name) || "jacket".equals(name)
						|| "gloves".equals(name) || "boots".equals(name)
						|| "pants".equals(name)) {
					in = false;
					motorcyclist.addCloth(cloth);
				}
			break;
			}
		}

	}
}

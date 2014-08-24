package by.epam.parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import by.epam.substances.clothes.*;
import by.epam.substances.motorcyclist.Motorcyclist;

enum Fields {
	NAME, HELMET, BOOTS, PANTS, JACKET, GLOVES, WEIGHT, PRICE, FIRM, MATERIAL, DESIGN, GLASS, MODEL, KNEEPROTECTION, FASTENERS, VENTIALTION;
}

public class BikersDOMBuilder extends ParserBuilder {
	private DocumentBuilderFactory factory;
	private DocumentBuilder builder;
	private Logger logger = Logger.getLogger(BikersDOMBuilder.class);
	public BikersDOMBuilder(){
		// Get the DOM Builder Factory
		factory = DocumentBuilderFactory.newInstance();
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void buildMotorcyclistsList(String fileName) {

		String resource = fileName;
		Document document = null;
		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(new File(resource));
			document = builder.parse(inputStream);
		} catch (SAXException e) {
			logger.error(e);
			e.printStackTrace();
		} catch (IOException e) {
			logger.error(e);
			e.printStackTrace();
		}
		// motorcyclist
		Element root = document.getDocumentElement();
		NodeList bikersList = root.getChildNodes();
		Node nodeBikersList = bikersList.item(0);
		String bufString;
		motorcyclists = new ArrayList<Motorcyclist>();
		while (nodeBikersList != null) {
			if (nodeBikersList instanceof Element) {
				// create Biker
				Motorcyclist motorcyclist = new Motorcyclist();
				bufString = nodeBikersList.getAttributes().getNamedItem("name")
						.getNodeValue();
				motorcyclist.setName(bufString);
				NodeList clothesList = nodeBikersList.getChildNodes();
				Node nodeClothesList = clothesList.item(0);
				while (nodeClothesList != null) {
					if (nodeClothesList instanceof Element) {
						String nodeName = nodeClothesList.getNodeName();
						NodeList attrList = nodeClothesList.getChildNodes();
						switch (nodeName) {
						case "helmet":
							Helmet helmet = new Helmet();
							for (int i = 0; i < attrList.getLength(); i++) {
								Node helmetAttr = nodeClothesList
										.getChildNodes().item(i);
								if (helmetAttr instanceof Element) {
									String nodeHelmetAttr = helmetAttr
											.getNodeName();
									String boofString = helmetAttr
											.getTextContent().trim();
									switch (nodeHelmetAttr) {
									case "id":
										try {
											helmet.setID(Integer
													.valueOf(boofString));
										} catch (NumberFormatException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
											logger.error(e);
										} catch (NegativeNumberException e) {
											logger.error(e);
											e.printStackTrace();
										}
										break;
									case "weight":
										try {
											helmet.setWeight(Double
													.valueOf(boofString));
										} catch (NumberFormatException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
											logger.error(e);
										} catch (NegativeNumberException e) {
											logger.error(e);
											e.printStackTrace();
										}
										break;
									case "price":
										try {
											helmet.setPrice(Double
													.valueOf(boofString));
										} catch (NumberFormatException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
											logger.error(e);
										} catch (NegativeNumberException e) {
											logger.error(e);
											e.printStackTrace();
										}
										break;
									case "glass":
										helmet.setGlass(boofString);
										break;
									case "color":
										helmet.setColor(boofString);
										break;
									case "firm":
										helmet.setFirm(boofString);
										break;
									case "design":
										helmet.setDesign(boofString);
										break;
									case "sizecl":
										helmet.setSize(boofString);
										break;
									}
								}
							}
							motorcyclist.addCloth(helmet);
							break;
						case "boots":
							Boots boots = new Boots();
							for (int i = 0; i < attrList.getLength(); i++) {
								Node helmetAttr = nodeClothesList
										.getChildNodes().item(i);
								if (helmetAttr instanceof Element) {
									String nodeHelmetAttr = helmetAttr
											.getNodeName();
									String boofString = helmetAttr
											.getTextContent().trim();
									switch (nodeHelmetAttr) {
									case "id":
										try {
											boots.setID(Integer.valueOf(boofString));
										} catch (NumberFormatException e) {
											logger.error(e);
											e.printStackTrace();
										} catch (NegativeNumberException e) {
											logger.error(e);
											e.printStackTrace();
										}
										break;
									case "weight":
										try {
											boots.setWeight(Double
													.valueOf(boofString));
										} catch (NumberFormatException e) {
											logger.error(e);
											e.printStackTrace();
										} catch (NegativeNumberException e) {
											logger.error(e);
											e.printStackTrace();
										}
										break;
									case "price":
										try {
											boots.setPrice(Double
													.valueOf(boofString));
										} catch (NumberFormatException e) {
											logger.error(e);
											e.printStackTrace();
										} catch (NegativeNumberException e) {
											logger.error(e);
											e.printStackTrace();
										}
										break;
									case "fasteners":
										boots.setFasteners(boofString);
										break;
									case "firm":
										boots.setFirm(boofString);
										break;
									}
								}
							}
							motorcyclist.addCloth(boots);
							break;
						case "pants":
							Pants pants = new Pants();
							for (int i = 0; i < attrList.getLength(); i++) {
								Node helmetAttr = nodeClothesList
										.getChildNodes().item(i);
								if (helmetAttr instanceof Element) {
									String nodeHelmetAttr = helmetAttr
											.getNodeName();
									String boofString = helmetAttr
											.getTextContent().trim();
									switch (nodeHelmetAttr) {
									case "id":
										try {
											pants.setID(Integer.valueOf(boofString));
										} catch (NumberFormatException e) {
											logger.error(e);
											e.printStackTrace();
										} catch (NegativeNumberException e) {
											logger.error(e);
											e.printStackTrace();
										}
										break;
									case "weight":
										try {
											pants.setWeight(Double
													.valueOf(boofString));
										} catch (NumberFormatException e) {
											logger.error(e);
											e.printStackTrace();
										} catch (NegativeNumberException e) {
											logger.error(e);
											e.printStackTrace();
										}
										break;
									case "price":
										try {
											pants.setPrice(Double
													.valueOf(boofString));
										} catch (NumberFormatException e) {
											logger.error(e);
											e.printStackTrace();
										} catch (NegativeNumberException e) {
											logger.error(e);
											e.printStackTrace();
										}
										break;

									case "kneeprotection":
										pants.setKneeProtection(boofString);
										break;
									case "material":
										pants.setMadeof(boofString);
										break;
									case "sizecl":
										pants.setSize(boofString);
										break;
									}
								}
							}
							motorcyclist.addCloth(pants);
							break;
						case "jacket":
							Jacket jacket = new Jacket();
							for (int i = 0; i < attrList.getLength(); i++) {
								Node helmetAttr = nodeClothesList
										.getChildNodes().item(i);
								if (helmetAttr instanceof Element) {
									String nodeHelmetAttr = helmetAttr
											.getNodeName();
									String boofString = helmetAttr
											.getTextContent().trim();
									switch (nodeHelmetAttr) {
									case "id":
										try {
											jacket.setID(Integer.valueOf(boofString));
										} catch (NumberFormatException e) {
											logger.error(e);
											e.printStackTrace();
										} catch (NegativeNumberException e) {
											logger.error(e);
											e.printStackTrace();
										}
										break;
									case "weight":
										try {
											jacket.setWeight(Double
													.valueOf(boofString));
										} catch (NumberFormatException e) {
											logger.error(e);
											e.printStackTrace();
										} catch (NegativeNumberException e) {
											logger.error(e);
											e.printStackTrace();
										}
										break;
									case "price":
										try {
											jacket.setPrice(Double
													.valueOf(boofString));
										} catch (NumberFormatException e) {
											logger.error(e);
											e.printStackTrace();
										} catch (NegativeNumberException e) {
											logger.error(e);
											e.printStackTrace();
										}
										break;
									case "model":
										jacket.setModel(boofString);
										break;
									case "material":
										jacket.setMadeof(boofString);
										break;
									case "sizecl":
										jacket.setSize(boofString);
										break;
									}
								}
							}
							motorcyclist.addCloth(jacket);
							break;
						case "gloves":
							Gloves gloves = new Gloves();
							for (int i = 0; i < attrList.getLength(); i++) {
								Node helmetAttr = nodeClothesList
										.getChildNodes().item(i);
								if (helmetAttr instanceof Element) {
									String nodeHelmetAttr = helmetAttr
											.getNodeName();
									String boofString = helmetAttr
											.getTextContent().trim();
									switch (nodeHelmetAttr) {
									case "id":
										try {
											gloves.setID(Integer.valueOf(boofString));
										} catch (NumberFormatException e) {
											logger.error(e);
											e.printStackTrace();
										} catch (NegativeNumberException e) {
											logger.error(e);
											e.printStackTrace();
										}
										break;
									case "weight":
										try {
											gloves.setWeight(Double
													.valueOf(boofString));
										} catch (NumberFormatException e1) {
											logger.error(e1);
											e1.printStackTrace();
										} catch (NegativeNumberException e1) {
											logger.error(e1);
											e1.printStackTrace();
										}
										break;
									case "price":
										try {
											gloves.setPrice(Double
													.valueOf(boofString));
										} catch (NumberFormatException e) {
											logger.error(e);
											e.printStackTrace();
										} catch (NegativeNumberException e) {
											logger.error(e);
											e.printStackTrace();
										}
										break;
									case "ventilation":
										gloves.setVentilation(boofString);
										break;
									case "sizecl":
										gloves.setSize(boofString);
										break;
									}
								}
							}
							motorcyclist.addCloth(gloves);
							break;
						}
					}
					nodeClothesList = nodeClothesList.getNextSibling();
				}
				motorcyclists.add(motorcyclist);
			}
			nodeBikersList = nodeBikersList.getNextSibling();
		}
	}
	
	@Override
	public ArrayList<Motorcyclist> getMotorcyclists(){
		return motorcyclists;
	}
}

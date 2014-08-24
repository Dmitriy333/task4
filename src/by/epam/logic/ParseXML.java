package by.epam.logic;

import java.util.ArrayList;

import by.epam.parser.BikersDOMBuilder;
import by.epam.parser.BikersSAXBuilder;
import by.epam.parser.BikersStAXBuilder;
import by.epam.parser.ParserBuilder;
import by.epam.parser.ParserException;
import by.epam.servlet.ParsersEnum;
import by.epam.substances.motorcyclist.Motorcyclist;

public class ParseXML {
	public static ArrayList<Motorcyclist> getMotorcyclists(String parserName,
			String fileName) throws ParserException {
		if ((parserName.equals("DOM") || parserName.equals("STAX") || parserName
				.equals("SAX"))) {
			ArrayList<Motorcyclist> bikers = null;
			ParserBuilder parser = null;
			ParsersEnum parserEn = ParsersEnum.valueOf(parserName);
			switch (parserEn) {
			case SAX:
				parser = new BikersSAXBuilder();
				break;
			case STAX:
				parser = new BikersStAXBuilder();
				break;
			case DOM:
				parser = new BikersDOMBuilder();
				break;
			}
			parser.buildMotorcyclistsList(fileName);
			bikers = parser.getMotorcyclists();
			return bikers;
		} else {
			throw new ParserException("Invalid parser name: " + parserName);
		}
	}
}

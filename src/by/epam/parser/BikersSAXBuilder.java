package by.epam.parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import by.epam.substances.motorcyclist.Motorcyclist;

public class BikersSAXBuilder extends ParserBuilder{
	private MotorcyclistHandler mh;
	private XMLReader reader;
	private Logger logger = Logger.getLogger(BikersStAXBuilder.class);
	public BikersSAXBuilder(){
		mh = new MotorcyclistHandler();
		try{
			//создание объекта обработчика
			reader = XMLReaderFactory.createXMLReader();
			reader.setContentHandler(mh);
		}catch(SAXException e){
			System.err.println("ошибка SAX паресера: " + e);
		}
	}
	@Override
	public ArrayList<Motorcyclist> getMotorcyclists(){
		return motorcyclists;
	}
	@Override
	public void buildMotorcyclistsList(String fileName){
		try{
			//разбор XML документа
			InputSource inputSource = new InputSource(new FileInputStream(new File(fileName)));
			reader.parse(inputSource);
		}catch(SAXException e){
			logger.error("ошибка SAX паресера: " + e);
			e.printStackTrace();
		}catch(IOException e){
			logger.error("ошибка I/O потока: " + e);
			e.printStackTrace();
		}
		motorcyclists = mh.getMotorcyclists();
	}
	
}

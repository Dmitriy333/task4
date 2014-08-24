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
			//�������� ������� �����������
			reader = XMLReaderFactory.createXMLReader();
			reader.setContentHandler(mh);
		}catch(SAXException e){
			System.err.println("������ SAX ��������: " + e);
		}
	}
	@Override
	public ArrayList<Motorcyclist> getMotorcyclists(){
		return motorcyclists;
	}
	@Override
	public void buildMotorcyclistsList(String fileName){
		try{
			//������ XML ���������
			InputSource inputSource = new InputSource(new FileInputStream(new File(fileName)));
			reader.parse(inputSource);
		}catch(SAXException e){
			logger.error("������ SAX ��������: " + e);
			e.printStackTrace();
		}catch(IOException e){
			logger.error("������ I/O ������: " + e);
			e.printStackTrace();
		}
		motorcyclists = mh.getMotorcyclists();
	}
	
}

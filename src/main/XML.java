package main;

import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


//Klass mis sisaldab abifunktsiooni XML andmete töötlemiseks


public class XML {
	
	//TagNAme <Response> siis "Response" on tagName;
	
	private DocumentBuilderFactory dbFactory;
	private DocumentBuilder dBuilder;
	private Document document;
	

	public XML(URL inputURL) {
		
		super();
		
		dbFactory = DocumentBuilderFactory.newInstance();
		try {
			
			dBuilder = dbFactory.newDocumentBuilder();
			document = dBuilder.parse(inputURL.openStream());
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	

	public String getUnNestedTagContent(String tagName) {

		NodeList nList = document.getElementsByTagName(tagName);
		Node nNode = nList.item(0);
		return nNode.getTextContent();
		
		
	}
	
	
	

	

	
	
	
	
	
	
}

package main;

import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


//Klass mis sisaldab abifunktsiooni XML andmete t��tlemiseks


public class XML {
	
	/*
	 * 
	 * Klassi v�iks t�iendada nii, et saaks ka Nested TAG'e queryda, kuigi see �ks paras m�steerium Javas
	 * https://www.tutorialspoint.com/java_xml/java_dom_parse_document.htm  <--- Abi
	 */
	
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
	
	
	//<temperatuur>45</temperatuur>     korral tagastatakse 45.
	public String getUnNestedTagContent(String tagName) {

		NodeList nList = document.getElementsByTagName(tagName);
		Node nNode = nList.item(0);
		return nNode.getTextContent();
		
		
	}
	
	
	//<temperatuur v��rtus="45"/>        korral tagastatakse 45, kus temperatuur on "tagName" ja v��rtus on "attributeName".
	public String getTagContentValue(String tagName, String attributeName) {
		
		NodeList nList = document.getElementsByTagName(tagName);
		
		Node nNode = nList.item(0);
		Element e = (Element)nNode;
		
		return e.getAttribute(attributeName);
	}
	
	
	

	

	
	
	
	
	
	
}

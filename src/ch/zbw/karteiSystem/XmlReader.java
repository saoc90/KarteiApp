/**
 * 
 */
package ch.zbw.karteiSystem;

import java.io.File;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * @author Jwo
 *
 */
public class XmlReader {
	
	private Document doc;
	private ArrayList<Card> CardList;
	private ArrayList<CardFile> CardFileList;
	
	public MainHandler readFile() throws ParserConfigurationException, SAXException, IOException{
		read();
		getData();
		return null;
	}

	 private boolean read() throws ParserConfigurationException, SAXException, IOException{
		 	 CardFileList = new ArrayList<>();
			 File data = new File("data.bin");
			 DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			 DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			 doc = dBuilder.parse(data);
			 doc.getDocumentElement().normalize();
			 return true;
	 }
		
	 private boolean getData(){
			 System.out.println("root of xml file" + doc.getDocumentElement().getNodeName());
			 NodeList nodes = doc.getElementsByTagName("data");
			 String language ="";
			 int score =0;
			 Node node = nodes.item(0);
			 if (node.getNodeType() == Node.ELEMENT_NODE) {
			 Element element = (Element) node;
			 language = getValue("language", element);
			 score = parseInt(getValue("score", element));
			 }
			 System.out.println(language + score);
			 for(int i =1;i<nodes.getLength();i++){
				 CardFileList.add(generateCardFileList(nodes.item(i)));
			 }
			 
			 return true;
			 }

	
	 private  String getValue(String tag, Element element) {
			 NodeList nodes = element.getElementsByTagName(tag).item(0).getChildNodes();
			 Node node = (Node) nodes.item(0);
			 return node.getNodeValue();
			 }
			 
			


	 private CardFile generateCardFileList(Node node){
		 
		 if (node.getNodeType() == Node.ELEMENT_NODE){
			 Element element = (Element) node;
			 
		 }
		 return null;
	 }
	 
	 
	 private int parseInt(String text){
				try{
				 return Integer.parseInt(text);
			} catch(NumberFormatException e){
				return 0;
			}
				
			}
}

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
	
	
	public MainHandler readFile(){
		try {
			read();
		} catch (ParserConfigurationException | SAXException | IOException e) {
			return new MainHandler(new ArrayList<CardFile>(), Strings.ENGLISH, 0); // if no file attatched.
		}
		return getData();
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
		
	 private MainHandler getData(){
			 NodeList nodes = doc.getElementsByTagName("data");
			 String language ="";
			 int score =0;
			 Node node = nodes.item(0);
			 if (node.getNodeType() == Node.ELEMENT_NODE) {
			 Element element = (Element) node;
			 language = getValue("language", element);
			 score = parseInt(getValue("score", element));
			 }
			 for(int i =1;i<nodes.getLength();i++){
				 CardFileList.add(generateCardFileList(nodes.item(i)));
			 }
			 
			 return new MainHandler(CardFileList, language, score);
			 }

	
	 private  String getValue(String tag, Element element) {
			 NodeList nodes = element.getElementsByTagName(tag).item(0).getChildNodes();
			 Node node = (Node) nodes.item(0);
			 return node.getNodeValue();
			 }
			 
			


	 private CardFile generateCardFileList(Node node){
		 ArrayList<Card> cardList = new ArrayList<>();
		 String title="";//for title of Cardfile
		 String l1="";//for language 1 of CardFile
		 String l2="";//for language 2 of CardFile
		 int id=-1;//for id of Cardfile.
		 boolean languageSwitched = false;
		 if (node.getNodeType() == Node.ELEMENT_NODE){
			 Element element = (Element) node;
			 title = getValue("title", element);
			 l1 = getValue("title", element);
			 l2 = getValue("language1",element);
			 id = parseInt(getValue("id", element));
			 int tmp = parseInt(getValue("languageSwitched", element));
			 if(tmp==1){
				 languageSwitched=true;
			 } else if(tmp==0){
				 languageSwitched=false;
			 }
			 
			 NodeList nodes = element.getElementsByTagName("card");
			 for(int i= 0;i<nodes.getLength();i++){
				 CardList.add(genarateCard(nodes.item(i)));
			 }
			
		 }
		
		 return new CardFile(cardList, title, l1, l2, id, languageSwitched);
	 }
	 
	 private Card genarateCard(Node node){
		 String word1 = "";
		 String word2 = "";
		 int wrongAnswer = 0;
		 int rightAnswer = 0;
		 int boxNr = 0;
		 if(node.getNodeType() == Node.ELEMENT_NODE){
			 Element element = (Element) node;
			 word1 = getValue("word1", element);
			 word2 = getValue("word2", element);
			 wrongAnswer = parseInt(getValue("wrongAnswers", element));
			 rightAnswer = parseInt(getValue("wrongAnswers", element));
			 boxNr = parseInt(getValue("boxNr", element));
		 }
		 return new Card(word1, word2, boxNr, wrongAnswer, rightAnswer);
	 }
	 
	 
	 private int parseInt(String text){
				try{
				 return Integer.parseInt(text);
			} catch(NumberFormatException e){
				return 0;
			}
				
			}
}

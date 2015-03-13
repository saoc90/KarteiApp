/**
 * 
 */
package ch.zbw.karteiSystem;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;


/**
 * @author Jwo Nagel
 * 
 * This class is used for save all the application data into an XML file. for saving call the method save(MainHandler mainhandler)
 * The data are stored in data.xml
 */
	
public class XmlWriter {
	
	private Document doc;
	private Element rootElement;
	private MainHandler mainHandler;
	
	public static final String URI = "data.bin";
	
	/**
	 * save all data of the programm into data.xml into the application dir.
	 * @param mainHandler object filled with the data to save.
	 * @return true if it worked else false.
	 */
	public boolean save(MainHandler mainHandler){
		if(mainHandler==null){
			return false;
		}
		boolean worked = false;
		this.mainHandler=mainHandler;
		worked=createDoc();
		if(!worked){
			return worked;
		}
		rootElement = doc.createElement("root");
		doc.appendChild(rootElement);//generates the root element of the xml.
		writeAppData();
		addCardFiles();
		worked = writeXML();
		return worked;
	}
	
	/**
	 * creates a document.
	 * @return true if it worked.
	 */
	private boolean createDoc() {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			return false;
		}
		doc = builder.newDocument();
		return true;
	}

	/**
	 * Writes all other program data to the Document.
	 */
	private void writeAppData(){
		Element data = doc.createElement("data");
		rootElement.appendChild(data);
		
		Element language = doc.createElement("language");
		data.appendChild(language);
		language.appendChild(doc.createTextNode(mainHandler.getInitLanguage()));
		
		Element score = doc.createElement("score");
		data.appendChild(score);
		score.appendChild(doc.createTextNode(mainHandler.getScore()+""));
	}
	
	/**
	 * Writes all CardFiles to the document.
	 */
	private void addCardFiles() {
		if(mainHandler.getAllCardFiles()==null){
			return;
		}
		ArrayList<CardFile> cardFileList = mainHandler.getAllCardFiles();
		for(CardFile cardFile : cardFileList){
			Element cardFileElement = doc.createElement("cardFile");
			rootElement.appendChild(cardFileElement);
			
			Element title = doc.createElement("title");
			cardFileElement.appendChild(title);
			title.appendChild(doc.createTextNode(cardFile.getTitle()));
			
			Element l1 = doc.createElement("language1");
			cardFileElement.appendChild(l1);
			l1.appendChild(doc.createTextNode(cardFile.getLanguage1()));
			
			Element l2 = doc.createElement("language2");
			cardFileElement.appendChild(l2);
			l2.appendChild(doc.createTextNode(cardFile.getLanguage2()));
			
			Element id = doc.createElement("id");
			cardFileElement.appendChild(id);
			id.appendChild(doc.createTextNode(cardFile.getCardFileId()+""));
			
			Element ls = doc.createElement("languageSwitched");
			cardFileElement.appendChild(ls);
			String switched;
			if(cardFile.isLanguageSwitched()){
				switched="1";
			} else{
				switched="0";
			}
			ls.appendChild(doc.createTextNode(switched));
			
			addCards(cardFile.getAllCards() ,cardFileElement);
		}
		
	}
	
	/**
	 * adds the elemnts fro Objects Card to the document.
	 * @param cardList Lists with all cards of a CardFile. 
	 * @param cardFileElement Element of the given Cardfile.
	 */
	private void addCards(ArrayList<Card> cardList, Element cardFileElement) {
		if(cardList==null){
			return;
		}
		for(int i=0;i<cardList.size();i++){
			Element card = doc.createElement("card");
			cardFileElement.appendChild(card);
			
			Element word1 = doc.createElement("word1");
			card.appendChild(word1);
			word1.appendChild(doc.createTextNode(StringtoNumber(cardList.get(i).getWord1())));
			
			Element word2 = doc.createElement("word2");
			card.appendChild(word2);
			word2.appendChild(doc.createTextNode(StringtoNumber(cardList.get(i).getWord2())));
			
			Element boxNr = doc.createElement("boxNr");
			card.appendChild(boxNr);
			boxNr.appendChild(doc.createTextNode(cardList.get(i).getBoxNr()+""));
			
			Element wrongAnswers = doc.createElement("wrongAnswers");
			card.appendChild(wrongAnswers);
			wrongAnswers.appendChild(doc.createTextNode(cardList.get(i).getWrongAnswers()+""));
			
			Element rightAnswers = doc.createElement("rightAnswers");
			card.appendChild(rightAnswers);
			rightAnswers.appendChild(doc.createTextNode(cardList.get(i).getRightAnswers()+""));
		}
	}
	
	private String StringtoNumber(String text){
		if(text.equals("")||text==null){
			return " ";
		}
		char[] tmp = text.toCharArray();
		String content = "";
		for(int i=0;i<tmp.length;i++){
			int ch = (int)tmp[i];
			if(i==tmp.length-1){
				content = content + ch;
			} else {
			content = content + ch + ";";
			}
		}
		return content;
	}
	
	/**
	 * save the document to the resouces as data.xml.
	 * @return true if the file is saved.
	 */
	private boolean writeXML() {
		  try {
			// write the content as xml file.
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(XmlWriter.URI)); //filename data.xml
			transformer.transform(source, result);
		  } catch (TransformerException tfe) {
			return false;
		  }
		  return true;
		}
}

package au.com.dom;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
//Not completed
enum NodeType{

	ELEMENT_NODE(1),
	ATTRIBUTE_NODE(2),
	TEXT_NODE(3),
	CDATA_SECTION_NODE(4),
	ENTITY_REFERENCE_NODE(5),
	ENTITY_NODE(6),
	PROCESSING_INSTRUCTION_NODE(7),
	COMMENT_NODE(8),
	DOCUMENT_NODE(9),
	DOCUMENT_TYPE_NODE(10),
	DOCUMENT_FRAGMENT_NODE(11),
	NOTATION_NODE(12);
	private int nodeTypeShortValue;
	
	NodeType(int nodeTypeShortValue){
		this.nodeTypeShortValue=nodeTypeShortValue;
	}
	public int getNodeTypeShortValue(){
		return this.nodeTypeShortValue;
	}
}
public class DomAPIDemo {
	public static void main(String...l){
		DocumentBuilderFactory builderFactory=DocumentBuilderFactory.newInstance();
		builderFactory.setValidating(true);
		builderFactory.setNamespaceAware(true);
		try {
			DocumentBuilder builder=builderFactory.newDocumentBuilder();
			try {
				Document document=builder.parse(new File("order.xml"));
				NodeList nodeList= document.getChildNodes();
				List<Node> temp=new ArrayList<Node>();
				for(int x=0;x<nodeList.getLength();x++){
					Node node=nodeList.item(x);
					if(node.hasChildNodes()){
						temp.add(node);
						continue;
					}
					
					System.out.println(getNodeType(node));
					System.out.println(node.getNodeName());
				}
	
			} catch (SAXException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		};
	}
	private void printNode(Node node){
		
	}
	
	private static NodeType getNodeType(Node node) {
		switch (node.getNodeType()){
		case 1:
			return NodeType.ELEMENT_NODE;
		case 2:
			return NodeType.ATTRIBUTE_NODE;
		case 3:
			return NodeType.TEXT_NODE;
		case 4:
			return NodeType.CDATA_SECTION_NODE;
		case 5:
			return NodeType.ENTITY_REFERENCE_NODE;
		case 6:
			return NodeType.ENTITY_NODE;
		case 7:
			return NodeType.PROCESSING_INSTRUCTION_NODE;
		case 8:
			return NodeType.COMMENT_NODE;			
		case 9:
			return NodeType.DOCUMENT_NODE;
		case 10:
			return NodeType.DOCUMENT_TYPE_NODE;
		case 11:
			return NodeType.DOCUMENT_FRAGMENT_NODE;
		case 12:
			return NodeType.NOTATION_NODE;
		default:
			return null;			
		}
		
		
	}
	
	
}

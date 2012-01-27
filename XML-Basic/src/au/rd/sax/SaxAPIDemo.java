package au.rd.sax;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;


public class SaxAPIDemo {	
	public static void main(String[] args) {
		SAXParserFactory parserFactory=SAXParserFactory.newInstance();
		//parserFactory.setValidating(false); //Default is true
		try {
			SAXParser  parser= parserFactory.newSAXParser();			
			parser.parse(new File("order.xml"), new OrderDataHandler());
			
		} catch (ParserConfigurationException e) {
		
			e.printStackTrace();
		} catch (SAXException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
}
class OrderDataHandler extends DefaultHandler{

	@Override
	public void setDocumentLocator(Locator locator) {
		System.out.println("Document Locator: "+ locator.getSystemId());
		super.setDocumentLocator(locator);
	}
	
	@Override
	public InputSource resolveEntity(String publicId, String systemId)
			throws IOException, SAXException {
		System.out.println("Resolve Entity: ");
		return super.resolveEntity(publicId, systemId);
	}

	@Override
	public void notationDecl(String name, String publicId, String systemId)
			throws SAXException {
		System.out.println("Notation Decl : ");
		super.notationDecl(name, publicId, systemId);
	}

	@Override
	public void unparsedEntityDecl(String name, String publicId,
			String systemId, String notationName) throws SAXException {
		System.out.println("unparsedEntityDecl: ");
		super.unparsedEntityDecl(name, publicId, systemId, notationName);
	}

	

	@Override
	public void startDocument() throws SAXException {
		System.out.println("Start Doc : ");
		super.startDocument();
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("End doc: ");
		super.endDocument();
	}

	@Override
	public void startPrefixMapping(String prefix, String uri)
			throws SAXException {
		System.out.println("Start Prefix Mapping: ");
		super.startPrefixMapping(prefix, uri);
	}

	@Override
	public void endPrefixMapping(String prefix) throws SAXException {
		System.out.println("End Prefix Mapping: ");
		super.endPrefixMapping(prefix);
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		System.out.println("Start Element: ");
		super.startElement(uri, localName, qName, attributes);
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		System.out.println("End Element: ");
		super.endElement(uri, localName, qName);
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		System.out.println("Characters: ");
		super.characters(ch, start, length);
	}

	@Override
	public void ignorableWhitespace(char[] ch, int start, int length)
			throws SAXException {
		System.out.println("ignoreablewhitespace: ");
		super.ignorableWhitespace(ch, start, length);
	}

	@Override
	public void processingInstruction(String target, String data)
			throws SAXException {
		System.out.println("Processesing Instruction: ");
		super.processingInstruction(target, data);
	}

	@Override
	public void skippedEntity(String name) throws SAXException {
		System.out.println("skipped Entity: ");
		super.skippedEntity(name);
	}

	@Override
	public void warning(SAXParseException e) throws SAXException {
		System.out.println("Warning: ");
		super.warning(e);
	}

	@Override
	public void error(SAXParseException e) throws SAXException {
		System.out.println("error: ");
		super.error(e);
	}

	@Override
	public void fatalError(SAXParseException e) throws SAXException {
		System.out.println("fatal Error: ");
		super.fatalError(e);
	}


	
}
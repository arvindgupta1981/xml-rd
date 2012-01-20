package com.jkt;

import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.jkt.generated.Golfer;
import com.jkt.generated.ObjectFactory;


public class GolfersMain {	
	public static void main(String[] args)throws DatatypeConfigurationException, IOException {
		try {			
			JAXBContext jContext=JAXBContext.newInstance("com.jkt.generated");			
			
			ObjectFactory objectFactory=new ObjectFactory();
			Golfer golfer=objectFactory.createGolfer();
			
			 DatatypeFactory       factory  = DatatypeFactory.newInstance();  
			 XMLGregorianCalendar  calendar = factory.newXMLGregorianCalendar();
			 
			 calendar.setYear(1987);
			 calendar.setMonth(12);
			 calendar.setDay(11);
			 
			golfer.setID(1);
			golfer.setName("Ram Singh");
			golfer.setBirthday(calendar);			
			System.out.println("calender : "+calendar);
			/*Validator validator = jContext.createValidator();
			validator.validate(golfer);*/
			
			Marshaller marshaller = jContext.createMarshaller();
			System.out.println("marshallering done : ");
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			FileOutputStream fileOutputStream=new FileOutputStream("golfer.xml");
			marshaller.marshal(golfer, fileOutputStream);						
		} catch (JAXBException e) {
			System.out.println("JAXBException occured : ");
			e.printStackTrace();
		}catch(Exception e){
			System.out.println("Exception error occured :");
			e.printStackTrace();
		}
		

	}

}

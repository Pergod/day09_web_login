package com.itcast.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class XMLUtils {
	private static String filepath;
	
	static{
		filepath=XMLUtils.class.getClassLoader().getResource("users.xml").getPath();
	}
	
	public static Document getDocument() throws DocumentException {
		SAXReader reader=new SAXReader();
		Document document=reader.read(new File(filepath));
		return document;
	}
	
	public static void Write2Xml(Document document) throws IOException {
        OutputFormat format=OutputFormat.createPrettyPrint();
        format.setEncoding("UTF-8");
        XMLWriter writer = new XMLWriter(new FileOutputStream(filepath), format);
        writer.write(document);
        writer.close();
	}
}

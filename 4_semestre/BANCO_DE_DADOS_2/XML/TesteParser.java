/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bd2;

import java.io.IOException;
import java.util.HashSet;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class TesteParser extends DefaultHandler {

    private int contadorPub;
    private StringBuilder currentValue = new StringBuilder();
    private HashSet<String> coAutores = new HashSet<>();
    private HashSet<String> veiculos = new HashSet<>();

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        currentValue.append(ch, start, length);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentValue.setLength(0);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        if (qName.equals("title")) {
            contadorPub++;
        }
        if (qName.equals("author")) {
            coAutores.add(currentValue.toString());
        }
        if (qName.equals("journal")|| qName.equals("boobooktitle")) {
            veiculos.add(currentValue.toString());
        }

    }

    public int getNumeroPublicacoes() {
        return contadorPub;
    }

    public HashSet<String> getCoAutores() {
        return coAutores;
    }

    public HashSet<String> getVeiculos() {
        return veiculos;
    }

    public static void main(String[] args) throws SAXException, ParserConfigurationException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        TesteParser TesteParser = new TesteParser();

        saxParser.parse("src/bd2/5534.xml", TesteParser);
        System.out.println("#pubs: " + TesteParser.getNumeroPublicacoes());
        TesteParser.getCoAutores().forEach(System.out::println);
        TesteParser.getVeiculos().forEach(System.out::println);

    }

}

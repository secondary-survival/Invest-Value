package data;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * this class is used to provide data present in properties, csv, excel, text... files
 */
public class DataProvider {
    private static final String propertiesPath = "src/main/resources/Automation/UI/UIAutomation.properties";
    private static final String AutomationPropertiesPath = "../Invest-Value/Automation-Properties.xml";

    /**
     * This method helps in getting values of a property
     *
     * @param key is a name of a property
     * @return property value
     */
    public static String dataProvider(String key) {
        try (InputStream input = Files.newInputStream(Paths.get(propertiesPath))) {
            Properties prop = new Properties();
            prop.load(input);
            return prop.get(key).toString();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return "";
    }

    /**
     * Retrieves XML values based on the provided XPath expression.
     *
     * @param path     The XPath expression to select the desired node.
     * @param property The property name that needs to be fetched
     * @return The first value retrieved based on the XPath expression, or an empty string if no value is found.
     */
    public static String XMLDataProvider(String path, String property) {
        try {
            File inputFile = new File(AutomationPropertiesPath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder;

            dBuilder = dbFactory.newDocumentBuilder();

            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            XPath xPath = XPathFactory.newInstance().newXPath();

            NodeList nodeList = (NodeList) xPath.compile(path).evaluate(
                    doc, XPathConstants.NODESET);

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node nNode = nodeList.item(i);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    return eElement.getElementsByTagName(property).item(0).getTextContent();
                }
            }
        } catch (ParserConfigurationException | SAXException | XPathExpressionException | IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
//package com.toreadxmlfile.learning.LearningService;
//
//import com.toreadxmlfile.learning.SomeDTO;
//import org.w3c.dom.Document;
//import org.w3c.dom.Node;
//import org.w3c.dom.NodeList;
//
//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
//import javax.xml.xpath.*;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//import java.util.NoSuchElementException;
//
//public class LearningIterator implements LearningIntServicer {
//    public static Iterable<Node> iterable(final NodeList nodeList) {
//        return () -> new Iterator<Node>() {
//
//            private int index = 0;
//
//            @Override
//            public boolean hasNext() {
//                return index < nodeList.getLength();
//            }
//
//            @Override
//            public Node next() {
//                if (!hasNext())
//                    throw new NoSuchElementException();
//                return nodeList.item(index++);
//            }
//        };
//    }
//    private static List<String> evaluateXPath(Document document, String xpathExpression)
//    {
//        // Create XPathFactory object
//        XPathFactory xpathFactory = XPathFactory.newInstance();
//
//        // Create XPath object
//        XPath xpath = xpathFactory.newXPath();
//
//        List<String> values = new ArrayList<>();
//        try
//        {
//            // Create XPathExpression object
//            XPathExpression expr = xpath.compile(xpathExpression);
//
//            // Evaluate expression result on XML document
//            NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
//
//            for (int i = 0; i < nodes.getLength(); i++) {
//                values.add(nodes.item(i).getNodeValue());
//            }
//
//        } catch (XPathExpressionException e) {
//            e.printStackTrace();
//        }
//        return values;
//    }
//    public static void main(String[] args) throws Exception {
//        //Build DOM
//
//        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//        factory.setNamespaceAware(true); // never forget this!
//        DocumentBuilder builder = factory.newDocumentBuilder();
//        Document doc = builder.parse("data/xmllearndata.xml");
//
//        //Create XPath
//
//        XPathFactory xpathfactory = XPathFactory.newInstance();
//        XPath xpath = xpathfactory.newXPath();
//        String xpathRoot = "//Routes/Route";
//        XPathExpression expr = xpath.compile(xpathRoot);
//        int i = 0;
//        for (Node n : iterable((NodeList) expr.evaluate(doc, XPathConstants.NODESET))) {
//            i++;
//            String xpe2 = String.format("%s[%d]/%s/text()", xpathRoot, i, "FlightNumber");
//            System.out.println("FxPe: " + xpe2);
//            System.out.println("Flight Number: " + evaluateXPath(doc, xpe2).get(0));
//            for (Node n2 : iterable(n.getChildNodes())) {
//                System.out.println(n2.getTextContent());
//            }
//
//        }
//    }
//
//    @Override
//    public List<SomeDTO> getDetails() {
//        return null;
//    }
//
//    @Override
//    public SomeDTO getDetails(String someDetail) {
//        return null;
//    }
//
//    @Override
//    public SomeDTO addDetails(SomeDTO someDTO) {
//        return null;
//    }
//}
//}

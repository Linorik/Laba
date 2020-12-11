package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
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

public class StringOperator {
    private List<String> strings = new ArrayList();
    private int size;

    public StringOperator(int size) {
        this.size = size;
    }

    public void print() {
        System.out.println("Elements:");
        Iterator var1 = this.strings.iterator();

        while(var1.hasNext()) {
            String string = (String)var1.next();
            System.out.println(string);
        }
    }

    public void deleteElement(String element) {
        this.strings.remove(element);
    }

    public void addElement(String element) {
        if (this.strings.size() == this.size) {
            this.strings.remove(0);
        }

        this.strings.add(element);
    }

    public void findDuplicateElements() {
        int sum = 0;
        Set<String> names = new TreeSet();

        for(int i = 0; i < this.strings.size(); ++i) {
            if (!names.contains(this.strings.get(i))) {
                for(int j = i + 1; j < this.strings.size(); ++j) {
                    if (((String)this.strings.get(i)).equals(this.strings.get(j))) {
                        names.add(this.strings.get(i));
                        ++sum;
                    }
                }

                if (sum != 0) {
                    System.out.println((String)this.strings.get(i) + " has " + sum + " duplicates");
                    sum = 0;
                }
            }
        }
    }

    public void reverseElements() {
        System.out.println(this.strings.size());

        for(int i = 0; i < this.strings.size(); ++i) {
            StringBuilder stringBuilder = new StringBuilder((String)this.strings.get(i));
            this.strings.set(i, stringBuilder.reverse().toString());
        }
    }

    public void letterCount() {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int sum = 0;

        for(int j = 0; j < alphabet.length(); ++j) {
            Iterator var4 = this.strings.iterator();

            while(var4.hasNext()) {
                String string = (String)var4.next();

                for(int i = 0; i < string.length(); ++i) {
                    if (alphabet.substring(j, j + 1).equals(string.substring(i, i + 1))) {
                        ++sum;
                    }
                }
            }

            if (sum > 0) {
                System.out.println("Number of letter " + alphabet.substring(j, j + 1) + " is " + sum);
            }

            sum = 0;
        }
    }

    public void findSubstring(String substring) {
        Iterator var2 = this.strings.iterator();

        while(var2.hasNext()) {
            String string = (String)var2.next();
            if (string.contains(substring)) {
                System.out.println("Element " + string + " contains substring " + substring);
            }
        }
    }

    public void countElementsLength() {
        String[] lengths = new String[this.strings.size()];

        int j;
        for(j = 0; j < this.strings.size(); ++j) {
            lengths[j] = ((String)this.strings.get(j)).length() + " " + (String)this.strings.get(j);
        }

        Arrays.sort(lengths);

        for(j = 0; j < lengths.length; ++j) {
            System.out.print(lengths[j]);
            System.out.println();
        }
    }

    public int compareInnerObjects(int firstIndex, int secondIndex) {
        return ((String)this.strings.get(firstIndex)).compareTo((String)this.strings.get(secondIndex));
    }

    public void initializeFromFile() {
        Scanner file = null;

        try {
            file = new Scanner(new File("D:/БГУИР/3 курс/6 сем/ПИСм/Лаба 8/untitled/src/com/company/TextFile.txt"));
        } catch (FileNotFoundException var3) {
            var3.printStackTrace();
        }

        for(; file.hasNextLine(); this.strings.add(file.nextLine())) {
            if (this.strings.size() == this.size) {
                this.strings.remove(0);
            }
        }

    }

    public void createXML() {
        DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = null;

        try {
            documentBuilder = documentFactory.newDocumentBuilder();
        } catch (ParserConfigurationException var10) {
            var10.printStackTrace();
        }

        Document document = documentBuilder.newDocument();
        Element root = document.createElement("list");
        document.appendChild(root);
        Iterator var5 = this.strings.iterator();

        while(var5.hasNext()) {
            String string = (String)var5.next();
            Element employee = document.createElement("element");
            employee.appendChild(document.createTextNode(string));
            root.appendChild(employee);
        }

        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File("D:/БГУИР/3 курс/6 сем/ПИСм/Лаба 8/untitled/src/com/company/xmlData.xml"));
            transformer.transform(domSource, streamResult);
        } catch (TransformerException var9) {
            var9.printStackTrace();
        }

    }
}

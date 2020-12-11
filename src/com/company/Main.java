//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.company;

import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Boolean a = true;

        for(StringOperator strings = new StringOperator(5); a; strings.createXML()) {
            System.out.println();
            System.out.println("******************************");
            System.out.println("1. Add element");
            System.out.println("2. Delete element");
            System.out.println("3. Reverse elements");
            System.out.println("4. Count the number of letters");
            System.out.println("5. Find substring");
            System.out.println("6. Length of elements");
            System.out.println("7. Duplicates");
            System.out.println("8. Compare elements");
            System.out.println("9. Add elements from file");
            System.out.println("10. Exit");
            System.out.println("******************************");
            System.out.println();
            int choice = in.nextInt();
            switch(choice) {
                case 1:
                    System.out.println("Enter an element");
                    strings.addElement(in.next());
                    strings.print();
                    break;
                case 2:
                    System.out.println("Enter an element you want to delete");
                    strings.deleteElement(in.next());
                    strings.print();
                    break;
                case 3:
                    strings.reverseElements();
                    strings.print();
                    break;
                case 4:
                    strings.letterCount();
                    break;
                case 5:
                    System.out.println("Enter substring");
                    strings.findSubstring(in.next());
                    break;
                case 6:
                    strings.countElementsLength();
                    break;
                case 7:
                    strings.findDuplicateElements();
                    break;
                case 8:
                    System.out.println("Enter the indexes of elements you want to compare");
                    System.out.println(strings.compareInnerObjects(in.nextInt(), in.nextInt()));
                    break;
                case 9:
                    strings.initializeFromFile();
                    strings.print();
                    break;
                case 10:
                    a = false;
            }
        }

    }
}

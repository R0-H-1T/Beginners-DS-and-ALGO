package com.DSA.DS.LinkedList;

import java.util.Scanner;

public class LinkedListUse extends LinkedList1{
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        System.out.println("Enter total Nodes to create: ");
        Node list1 = createList(sc.nextInt());


        while(true){
            System.out.println("Enter option------------\n1.Display\n2.Find length\n3.Insert Node");
            System.out.println("4.Remove consec dups\n5.Delete Node\n6.Reverse LL\n7.Increment data of nodes.\n8.Exit------------");
            switch (sc.nextInt()){
                case 1: printNodes(list1); break;
                case 2: System.out.println(len(list1)); break;
                case 3: System.out.println("\nEnter node at index: ");
                        list1 = insertNode(list1, sc.nextInt());
                        break;
                case 5: System.out.println("\nEnter node to be deleted: ");
                        list1 = deleteNode(list1, sc.nextInt());
                        break;
                case 4: list1 = rmConsecutiveDuplicates(list1); break;
                case 6: list1 = reverse(list1); break;
                case 7: incrementNode(list1); break;
                case 8: System.exit(0); break;
                default:
                    System.out.println("Invalid option selected");
                    System.exit(0);
            }
            System.out.println();
        }

    }
}

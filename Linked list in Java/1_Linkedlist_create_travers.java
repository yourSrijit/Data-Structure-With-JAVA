package Linked_List_Java;

import java.util.Scanner;

public class Linkedlist_create_travers {

    class LinkedList1 {

        public static class Node {
            public int data;
            public Node next;

            public Node(int data) {
                this.data = data;
                this.next = null;
            }
        }

        /**
         *
         */
        public static Node Create() {
            Scanner sc = new Scanner(System.in);
            Node head = null;
            int n = 0;
            do {

                System.out.println("Enter a data of new Node");
                int data = sc.nextInt();
                Node new_Node = new Node(data);
                if (head == null) {
                    head = new_Node;
                } else {
                    new_Node.next = head;
                    head = new_Node;
                }
                System.out.println("Enter 1 to add another Node");
                n = sc.nextInt();
            } while (n == 1);
            sc.close();

            return head;
        }

        /**
         *
         */
        public static void travarse(Node ptr) {
            if (ptr == null) {
                System.out.println("Linkd list is Empty");
            } else {
                int i = 1;
                while (ptr != null) {
                    System.out.println("Data of node no " + i + " is " + ptr.data);
                    ptr = ptr.next;
                    i++;
                }
            }
        }
        // public static void display(){
        //     travarse(head);
        // }

    }

    public static void main(String[] args) {
        // Scanner sc=new Scanner(System.in);
        // System.out.println("Enter 1:For creating Linked List\n");
        // System.out.println("Enter 2:For display Linked List\n");
        // int choose=sc.nextInt();
        // switch(choose){
        //     case 1:
        //          LinkedList1.Create();
        //          break;
        //     case 2:
        //          LinkedList1.travarse();
        // }


        LinkedList1.Node j;
        j=LinkedList1.Create();
        LinkedList1.travarse(j);

    }

}

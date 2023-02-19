package Linked_List_Java;

import java.util.Scanner;

public class Linkedlist_Insertion {
    public static Node head=null;
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
             *
             *
             */
    public static  void Insert_Beg(){
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter data for new node");
            int data=sc.nextInt();
            Node new_node=new Node(data);
            if(head==null){
                head=new_node;
            }
            else {
                new_node.next = head;
                head = new_node;
            }
            sc.close();
        }
        public static void Insert_End(){
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter data for new node");
            int data=sc.nextInt();
            Node new_node=new Node(data);
            if(head==null){
                head=new_node;
            }else {
                Node ptr=head;
                while(ptr.next!=null){
                    ptr=ptr.next;
                }
                ptr.next=new_node;
                new_node.next=null;
            }
            sc.close();
        }
        public static void Insert_AnyPos(){
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter data for new node");
            int data=sc.nextInt();
            System.out.println("Enter the index of the new node u want to insert");
            int n=sc.nextInt();
            Node new_node=new Node(data);
            if(head==null){
                head=new_node;
            }
            else {
                Node ptr=head;
                Node poi=head.next;
                int i=1;
                while (i!=n){
                    ptr=ptr.next;
                    poi=poi.next;
                    i++;
                }
                new_node.next=poi.next;
                ptr.next=new_node;

            }
            sc.close();
        }
        public static void Display(){
        if(head==null){
            System.out.println("Linked list is empty");
        }
        else {
            Node ptr = head;
            int i = 1;
            while (ptr != null) {
                System.out.println("Data of node " + i + " is " + ptr.data);
                ptr=ptr.next;
            }
            }
        }

    public static void main(String[] args) {
        while (true) {
            System.out.println("Enter\n 1:to Insert a node at beginning\n 2:to insert at End \n 3:to Insert at any position\n 4:to Display all the nodes\n 5:To exit");
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter your choice");
            int choice=sc.nextInt();

            switch (choice){
                case 1:
                    Insert_Beg();
                    break;
                case 2:
                    Insert_End();
                    break;
                case 3:
                    Insert_AnyPos();
                    break;
                case 4:
                    Display();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("opps! Wrong entry try again");
                    break;
            }

        }
    }
}

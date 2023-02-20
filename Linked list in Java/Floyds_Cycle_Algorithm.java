package Linked_List_Java;

import java.util.Scanner;

public class Floyds_Cycle_Algorithm {
    public static Node head=null;
    public static class Node {
        public int data;
        public Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

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

    }
//    public static void Insert_End(){
//        Scanner sc=new Scanner(System.in);
//        System.out.println("Enter data for new node");
//        int data=sc.nextInt();
//        Node new_node=new Node(data);
//        if(head==null){
//            head=new_node;
//        }else {
//            Node ptr=head;
//            while(ptr.next!=null){
//                ptr=ptr.next;
//            }
//            ptr.next=new_node;
//            new_node.next=null;
//        }
//
//    }
//    public static void Insert_AnyPos(){
//        Scanner sc=new Scanner(System.in);
//        System.out.println("Enter data for new node");
//        int data=sc.nextInt();
//        System.out.println("Enter the index of the new node u want to insert");
//        int n=sc.nextInt();
//        Node new_node=new Node(data);
//        if(head==null){
//            head=new_node;
//        }
//        else {
//            Node ptr=head;
//            Node poi=head.next;
//            int i=1;
//            while (i!=n){
//                ptr=ptr.next;
//                poi=poi.next;
//                i++;
//            }
//            new_node.next=ptr.next;
//            ptr.next=new_node;
//
//        }
//
//    }
    public static int findCycle(){
        Node slowPointer=head;
        Node fastPointer=head;
        while (slowPointer !=null && fastPointer !=null && fastPointer.next!=null){
            slowPointer=slowPointer.next;
            fastPointer=fastPointer.next.next;
            if(slowPointer ==fastPointer) {
                System.out.println("Cycle is present in the linked List");
                return 1;
            }
        }
        System.out.println("No Cycle present in the Linked List");
        return 0;
    }
    public static void createCycle(){
        Node temp=head;
        while (temp.next!=null){
            temp=temp.next;
        }
        temp.next=head;
    }
    public static void Display(){
        if(head==null){
            System.out.println("Linked list is empty");
        }
        else {
            Node ptr = head;
            int i = 1;
            while (ptr != null) {
                System.out.println("Data of node " + i++ + " is " + ptr.data);
                ptr=ptr.next;
            }
        }
    }


    public static void main(String[] args) {
        while (true) {
            System.out.println("Enter\n 1:to Insert a node at beginning\n 2:to Display all the nodes \n 3:To find Cycle\n 4:Create cycle\n 5:To exit");
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter your choice");
            int choice=sc.nextInt();

            switch (choice){
                case 1:
                    Insert_Beg();
                    break;
                case 2:
                    Display();
                    break;
                case 3:
                      findCycle();
                      break;
                case 4:
                    createCycle();
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
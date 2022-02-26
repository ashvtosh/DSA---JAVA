import java.util.Scanner;
public class CircularLinkedList {
    class Node{
        int element;
        Node next;
        Node(int e,Node n){
            element=e;
            next=n;
        }
    }
    private Node head;
    private Node tail;
    private int size;
    public CircularLinkedList(){
        head=null;
        tail=null;
        size=0;
    }
    public int length(){
        return size;
    }
    public boolean isempty(){
        return size==0;
    }
    public void display(){
        Node p=head;
        int i=0;
        while(i<length()){
            System.out.println(p.element+" ");
            p=p.next;
            i=i+1;
        }
    }
    public void addfirst(int e){
        Node newest=new Node(e,null);
        if(isempty()){
            newest.next=newest;
            tail=newest;
        }
        else{
            tail.next=newest;
            newest.next=head;
        }
        head=newest;
        size=size+1;
    }
    public void addlast(int e){
        Node newest=new Node(e,null);
        if(isempty()){
            newest.next=newest;
            head=newest;
        }
        else{
            newest.next=tail.next;
            tail.next=newest;
        }
        tail=newest;
        size=size+1;
    }
    public void addany(int e,int position){
        if(position>=0&&position<=size){
            Node newest=new Node(e,null);
            Node p=head;
            int i=1;
            while(i<position-1){
                p=p.next;
                i=i+1;
            }
            newest.next=p.next;
            p.next=newest;
            size=size+1;
        }
    }
    public void removefirst(){
        if(isempty()){
            System.out.println("CIRCULAR LIST IS EMPTY");
            return;
        }
        int e=head.element;
        tail.next=head.next;
        head=head.next;
        size=size-1;
        if(isempty()){
            head=null;
            tail=null;
        }
        System.out.println("ELEMENT IS REMOVED FROM LIST FROM BEGINING AND THE ELEMENT IS: "+e);
    }
    public void removelast(){
        if(isempty()){
            System.out.println("CIRCULAR LIST IS EMPTY");
            return;
        }
        Node p=head;
        int i=1;
        while(i<length()-1){
            p=p.next;
            i=i+1;
        }
        tail=p;
        p=p.next;
        tail.next=head;
        int e=p.element;
        size=size-1;
        System.out.println("ELEMENT IS REMOVED FROM LIST FROM BEGINING AND THE ELEMENT IS: "+e);
    }
    public void removeany(int position){
        if(position>=0&&position<=size){
            Node p=head;
            int i=1;
            while(i<position-1){
                p=p.next;
                i=i+1;
            }
            int e=p.next.element;
            p.next=p.next.next;
            size=size-1;
            System.out.println("ELEMENT IS REMOVED FROM LIST FROM GIVEN POSITION AND THE ELEMENT IS: "+e);
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        CircularLinkedList l=new CircularLinkedList();
        int k=1;
        while(k>0){
            System.out.println("ENTER YOUR CHOICE: ");
            System.out.println("1. ADD ELEMENT IN LIST FROM BEGINING.");
            System.out.println("2. ADD ELEMENT IN LIST FROM ENDING.");
            System.out.println("3. ADD ELEMENT IN LIST AT ANY POSITION.");
            System.out.println("4. DISPLAY LENGTH OF LIST.");
            System.out.println("5. DISPLAY LIST.");
            System.out.println("6. REMOVE ONE ELEMENT FROM BEGINING.");
            System.out.println("7. REMOVE ONE ELEMENT FROM END.");
            System.out.println("8. REMOVE ONE ELEMENT FROM PROVIDED POSITION.");
            System.out.println("9. EXIT.");
            int ch=sc.nextInt();
            switch(ch){
                case 1:
                    System.out.println("ENTER THE ELEMENT TO BE ADDED: ");
                    l.addfirst(sc.nextInt());
                    break;
                case 2:
                    System.out.println("ENTER THE ELEMENT TO BE ADDED: ");
                    l.addlast(sc.nextInt());
                    break;
                case 3:
                    System.out.println("ENTER THE ELEMENT TO BE ADDED AND ITS POSITION:: ");
                    l.addany(sc.nextInt(), sc.nextInt());
                    break;
                case 4:
                    System.out.println("SIZE OF LIST: "+l.size);
                    break;
                case 5:
                    System.out.println("LIST IS DISPLAYED");
                    l.display();
                    break;
                case 6:
                    l.removefirst();
                    break;
                case 7:
                    l.removelast();
                    break;
                case 8:
                    System.out.println("ENTER THE POSITION FROM WHERE ELEMENT IS TO BE DELETED: ");
                    int p=sc.nextInt();
                    l.removeany(p);
                    break;
                case 9:
                    k=0;
                    break;
                default:
                    System.out.println("INVALID CHOICE!!");

            }
        }
    }
}
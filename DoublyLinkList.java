import java.util.*;
//public Scanner sc=new Scanner(System.in);
public class DoublyLinkList {
    class Node{
        int element;
        Node next;
        Node prev;
        Node(int e,Node n,Node p){
            element=e;
            next=n;
            prev=p;
        }
    }
    private Node head;
    private Node tail;
    private int size;
    public DoublyLinkList(){
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
        while(p!=null){
            System.out.println(p.element);
            p=p.next;
        }
    }
    public void addlast(int e){
        Node newest=new Node(e,null,null);
        if(isempty()){
            head=newest;
            tail=newest;
        }
        else{
            tail.next=newest;
            newest.prev=tail;
            tail=newest;
        }
        size=size+1;
    }
    public void addfirst(int e){
        Node newest=new Node(e,null,null);
        if(isempty()){
            head=newest;
            tail=newest;
        }
        else{
            newest.next=head;
            head.prev=newest;
            head=newest;
        }
        size=size+1;
    }
    public void addany(int e,int position){
        if(position>=0&&position<=size){
            Node newest=new Node(e,null,null);
            Node p=head;
            int i=1;
            while(i<position-1){
                p=p.next;
                i=i+1;
            }
            newest.next=p.next;
            p.next.prev=newest;
            p.next=newest;
            newest.prev=p;
            size=size+1;
        }
    }
    public void removefirst(){
        if(isempty()){
            System.out.println("LIST IS ALREADY EMPTY");
            return;
        }
        else{
            int e=head.element;
            head=head.next;
            size=size-1;
            if(isempty())
                tail=null;
            else
                head.prev=null;
            System.out.println("ELEMENT DELETED IS: "+e);
        }
    }
    public void removelast(){
        if(isempty()){
            System.out.println("LIST IS ALREADY EMPTY");
            return;
        }
        else{
            int e=tail.element;
            tail=tail.prev;
            size=size-1;
            if(isempty())
                head=null;
            else
                tail.next=null;
            System.out.println("ELEMENT DELETED IS: "+e);
        }
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
            p.next.prev=p;
            size=size-1;
            System.out.println("ELEMENT "+e+" IS DELETED FROM "+position);
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        DoublyLinkList l=new DoublyLinkList();
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
import java.util.*;
public class LinkedList {
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
    public LinkedList(){
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
    public void addlast(int e){
        Node newest=new Node(e,null);
        if(isempty())
            head=newest;
        else
            tail.next=newest;
        tail=newest;
        size=size+1;
    }
    public void addfirst(int e){
        Node newest=new Node(e,null);
        if(isempty()){
            head=newest;
            tail=newest;
        }
        else{
            newest.next=head;
            head=newest;
        }
        size=size+1;
    }
    public void addany(int e,int position){
        if(position<=0||position>=size){
            System.out.println("INVALID POSITION");
        }
        else{
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
        if(isempty())
            System.out.println("LIST IS ALREADY EMPTY");
        else{
            int e=head.element;
            head=head.next;
            size=size-1;
            if(isempty())
                tail=null;
            System.out.println("ELEMENT "+e+" IS REMOVED");
        }
    }
    public void removelast(){
        if(isempty())
            System.out.println("LIST IS EMPTY");
        else if(tail==head || size==1){
            System.out.println("NOW LIST IS EMPTY AS U DELETED LAST ELEMENT: "+tail.element);
            tail=null;
            head=null;
            size=size-1;
        }
        else{
            Node p=head;
            int i=1;
            while(i<length()-1){
                p=p.next;
                i=i+1;
            }
            tail=p;
            p=p.next;
            int e=p.element;
            tail.next=null;
            size=size-1;
            System.out.println("ELEMENT DELETED IS: "+e);
        }
    }
    public void removeany(int position){
        Node p=head;
        int i=1;
        while(i<position-1){
            p=p.next;
            i=i+1;
        }
        int e=p.next.element;
        p.next=p.next.next;
        size=size-1;
        System.out.println("ELEMENT "+e+" IS DELETED FROM "+position);
    }
    public void display(){
        Node p=head;
        while(p!=null){
            System.out.print(p.element + " ");
            p=p.next;
        }
    }
    public int search(int key){
        Node p=head;
        int index=0;
        while(p!=null){
            if(p.element==key)
                return index;
            p=p.next;
            index=index+1;
        }
        return -1;
    }
    public void insertsorted(int e){
        Node newest=new Node(e,null);
        if(isempty())
            head=newest;
        else{
            Node p=head;
            Node q=head;
            while(p!=null&&p.element<e){
                q=p;
                p=p.next;
            }
            if(p==head){
                newest.next=head;
                head=newest;
            }
            else{
                newest.next=q.next;
                q.next=newest;
            }
        }
        size=size+1;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        LinkedList l=new LinkedList();
        int k=1;
        while(k>0){
            System.out.println("ENTER YOUR CHOICE: ");
            System.out.println("0. ADD ELEMENT IN LIST IN SORTED MANNER.");
            System.out.println("1. ADD ELEMENT IN LIST FROM BEGINING.");
            System.out.println("2. ADD ELEMENT IN LIST FROM ENDING.");
            System.out.println("3. ADD ELEMENT IN LIST AT ANY POSITION.");
            System.out.println("4. DISPLAY LENGTH OF LIST.");
            System.out.println("5. DISPLAY LIST.");
            System.out.println("6. REMOVE ONE ELEMENT FROM BEGINING.");
            System.out.println("7. SEARCH SPECIFIC ELEMENT IN LIST.");
            System.out.println("8. REMOVE ONE ELEMENT FROM END.");
            System.out.println("9. REMOVE ONE ELEMENT FROM PROVIDED POSITION.");
            System.out.println("10. EXIT.");
            int ch=sc.nextInt();
            switch(ch){
                case 0:
                    System.out.println("ENTER ELEMENT TO BE ADDED: ");
                    l.insertsorted(sc.nextInt());
                    break;
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
                    System.out.println("ENTER THE VALUE TO BE SEARCHED: ");
                    int index=l.search(sc.nextInt());
                    if(index==-1)
                        System.out.println("VALUE IS NOT PRESENT IN THE LIST");
                    else
                        System.out.println("VALUE IS PRESENT AT INDEX: "+index);
                    break;
                case 8:
                    l.removelast();
                    break;
                case 9:
                    System.out.println("ENTER THE POSITION FROM WHERE ELEMENT IS TO BE DELETED: ");
                    int p=sc.nextInt();
                    l.removeany(p);
                    break;
                case 10:
                    k=0;
                    break;
                default:
                    System.out.println("INVALID CHOICE!!");

            }
        }
    }
}

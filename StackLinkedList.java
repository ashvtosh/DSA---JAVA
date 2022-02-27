public class StackLinkedList {
    class Node{
        int element;
        Node next;
        Node(int e,Node n){
            element=e;
            next=n;
        }
    }
    private Node top;
    private int size;
    public StackLinkedList(){
        top=null;
        size=0;
    }
    public int length(){
        return size;
    }
    public boolean isempty(){
        return size==0;
    }
    public void push(int e){
        Node newest=new Node(e,null);
        if(isempty())
            top=newest;
        else{
            newest.next=top;
            top=newest;
        }
        size=size+1;
    }
    public int pop(){
        if(isempty()){
            System.out.println("LIST IS EMPTY");
            return -1;
        }
        else{
            int e=top.element;
            top=top.next;
            size=size-1;
            return e;
        }
    }
    public int peak(){
        if(isempty()){
            System.out.println("LIST IS EMPTY");
            return -1;
        }
        else
            return top.element;
    }
    public void display(){
        Node p=top;
        while(p!=null){
            System.out.print(p.element + " ");
            p=p.next;
        }
    }

}
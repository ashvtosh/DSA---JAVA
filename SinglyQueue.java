import java.util.*;
public class SinglyQueue {
    int ar[];
    int front,rear;
    SinglyQueue(){
        ar=new int[5];
        front=-1;
        rear=-1;
    }
    void insert(){
        if(rear!=ar.length){
            Scanner sc=new Scanner(System.in);
            System.out.println("ENTER DATA");
            System.out.println("DATA INSERTED");
            if(front==-1)
                front=0;
            int e=sc.nextInt();
            ar[rear+1]=e;
            rear=rear+1;
        }
        else{
            System.out.println("QUEUE IS FULL");
        }
    }
    void delete(){
        if(front==-1)
            System.out.println("QUEUE IS EMPTY");
        else{
            System.out.println("ELEMENT IS DELETED...."+ar[front]);
            if(front==rear){
                front=-1;
                rear=-1;
            }
            else if(front<rear)
                front=front+1;
        }
    }
    void traverse(){
        if(front==-1||rear==-1){
            System.out.println("SINGLY QUEUE EMPTY");
        }
        else{
            for(int i=front;i<=rear;i++){
                System.out.print(ar[i]+" ");
            }
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        SinglyQueue l=new SinglyQueue();
        int k=1;
        while(k>0){
            System.out.println("ENTER YOUR CHOICE: ");
            System.out.println("1. INSERT ELEMENT IN LIST.");
            System.out.println("2. DELETE ELEMENT FROM LIST.");
            System.out.println("3. TRAVERSE THE LIST.");
            System.out.println("4. EXIT.");
            int ch=sc.nextInt();
            switch(ch){
                case 1:
                    l.insert();
                    break;
                case 2:
                    l.delete();
                    break;
                case 3:
                    l.traverse();
                    break;
                case 4:
                    k=0;
                    break;
                default:
                    System.out.println("INVALID CHOICE!!");
            }
        }
    }
}
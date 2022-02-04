public class DLL {
    Node head;
    class Node {
        int data;
        Node prev;
        Node next;
        Node(int d) { data = d; }
    }
    public void push(int new_data)
    {
        Node new_Node = new Node(new_data);
        new_Node.next = head;
        new_Node.prev = null;
        if (head != null)
            head.prev = new_Node;
        head = new_Node;
    }
    // Add a node before the given node
    public void InsertBefore(Node next_node, int new_data)
    {
        /*Check if the given nx_node is NULL*/
        if(next_node == null)
        {
            System.out.println("The given next node can not be NULL");
            return;
        }
        //Allocate node, put in the data
        Node new_node = new Node(new_data);
        //Making prev of new node as prev of next node
        new_node.prev = next_node.prev;
        //Making prev of next node as new node
        next_node.prev = new_node;
        //Making next of new node as next node
        new_node.next = next_node;
        //Check if new node is added as head
        if(new_node.prev != null)
            new_node.prev.next = new_node;
        else
            head = new_node;
    }
    /* Given a node as prev_node, insert
    a new node after the given node */
    public void InsertAfter(Node prev_Node, int new_data)
    {
        /*1. check if the given prev_node is NULL */
        if (prev_Node == null) {
            System.out.println("The given previous node cannot be NULL ");
            return;
        }
        Node new_node = new Node(new_data);
        /* 4. Make next of new node as next of prev_node */
        new_node.next = prev_Node.next;
        /* 5. Make the next of prev_node as new_node */
        prev_Node.next = new_node;
        /* 6. Make prev_node as previous of new_node */
        new_node.prev = prev_Node;
        /* 7. Change previous of new_node's next node */
        if (new_node.next != null)
            new_node.next.prev = new_node;
    }
    // Add a node at the end of the list
    void append(int new_data)
    {
        Node new_node = new Node(new_data);
        Node last = head; /* used in step 5*/
        /* 3. This new node is going to be the last node, so
         * make next of it as NULL*/
        new_node.next = null;
        /* 4. If the Linked List is empty, then make the new
         * node as head */
        if (head == null) {
            new_node.prev = null;
            head = new_node;
            return;
        }
        /* 5. Else traverse till the last node */
        while (last.next != null)
            last = last.next;
        /* 6. Change the next of last node */
        last.next = new_node;
        /* 7. Make last node as previous of new node */
        new_node.prev = last;
    }
    public void printlist(Node node)
    {
        Node last = null;
        System.out.println("Traversal in forward Direction");
        while (node != null) {
            System.out.print(node.data + " ");
            last = node;
            node = node.next;
        }
        System.out.println();
        System.out.println("Traversal in reverse direction");
        while (last != null) {
            System.out.print(last.data + " ");
            last = last.prev;
        }
    }
    public static void main(String[] args)
    {
        DLL dll = new DLL();
        dll.append(6);
        dll.push(7);
        dll.push(1);
        dll.append(4);
        dll.InsertAfter(dll.head.next, 8);
        dll.InsertBefore(dll.head.next.next, 5);
        System.out.println("Created DLL is: ");
        dll.printlist(dll.head);
    }
}
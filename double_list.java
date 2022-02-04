public class double_list {
    Node head;
    class Node {
        int data;
        Node prev;
        Node next;
        Node(int d) { data = d; }
    }
    // Adding a node at the front of the list
    public void push(int new_data)
    {
        Node new_Node = new Node(new_data);
        /*Make next of new node as head and previous as NULL */
        new_Node.next = head;
        new_Node.prev = null;
        /*change prev of head node to new node */
        if (head != null)
            head.prev = new_Node;
        /*move the head to point to the new node */
        head = new_Node;
    }
}

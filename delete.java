class LinkedList {
    Node head;
    class Node {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }
    /* Given a key, deletes the first
    occurrence of key in
    * linked list */
    void deleteNode(int key)
    {
        // Store head node
        Node temp = head, prev = null;
        // If head node itself holds the key to be deleted
        if (temp != null && temp.data == key) {
            head = temp.next; // Changed head
            return;
        }
        // Search for the key to be deleted, keep track of
        // the previous node as we need to change temp.next
        while (temp != null && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }

        // If key was not present in linked list
        if (temp == null)
            return;

        // Unlink the node from linked list
        prev.next = temp.next;
    }

    /* Inserts a new Node at front of the list. */
    public void push(int new_data)
    {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }
    /* This function prints contents of linked list starting
    from the given node */
    public void printList()
    {
        Node tnode = head;
        while (tnode != null) {
            System.out.print(tnode.data + " ");
            tnode = tnode.next;
        }
    }
    public static void main(String[] args)
    {
        LinkedList a = new LinkedList();
        a.push(7);
        a.push(1);
        a.push(3);
        a.push(2);
        System.out.println("\nCreated Linked list is:");
        a.printList();
        a.deleteNode(1);
        System.out.println("\nLinked List after Deletion of :");
        a.printList();
    }
}

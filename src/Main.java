public class Main {
    public static void main(String[] args) {


        CircularLinkedList cll = new CircularLinkedList();

        // Insert elements into the circular linked list
        cll.insertAtBeginning(1);
        cll.insertAtBeginning(2);
        cll.insertAtBeginning(3);
        cll.insertAtBeginning(4);

        // Display the circular linked list
        System.out.print("Circular Linked List: ");
        cll.display();

        // Delete node with key 3 from circular linked list
        cll.delete(3);

        // Display the updated circular linked list
        System.out.print("Updated Circular Linked List after deletion of 3: ");
        cll.display();

    }


    // Creating Node
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Implementation of Circular LinkedList
    public static class CircularLinkedList {
        Node head;
        public CircularLinkedList () {
            this.head = null;
        }
        // Inserting a new node at the beginning
        public void insertAtBeginning (int data) {
            Node newNode = new Node(data);
            if(head == null) {
                this.head = newNode;
                head.next = head;
            }else  {
                Node temp = head;
                while (temp.next != head) {
                    temp = temp.next;
                }
                temp.next = newNode;
                newNode.next = head;
                head = newNode;
            }

        }


        // Displaying a Circular LinkedList

        public void display() {
            if(head == null) {
                System.out.println("Circular Linked list is Empty");
                return;
            }
            Node temp = head;
            do {
                System.out.println(temp.data + " ");
                temp = temp.next;
            }while (temp != head);
            System.out.println();
        }


        // Method to delete a node with given key from a circular LinkedList
        public void delete(int key) {
            if(head == null) {
                return;
            }
            Node  current = head, prev = null;

            if(current != null && current.data == key) {
                prev = head;
                while (prev.next != head) {
                    prev = prev.next;
                }
                if(head == head.next) {
                    head = null;
                }else {
                    head = current.next;
                    prev.next = head;
                }
                // Search for the key to be deleted, keep track of the prevous node
                do {

                    prev = current;
                    current = current.next;
                }while (current != head && current.data != key);

                // key was not present in the list
                if(current == head) {
                    return;
                }
                // Unlink the node from circular linked list
                prev.next = current.next;
            }
        }


    }

}
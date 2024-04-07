
public class LinkedListMain {
    private Node head; //private variable representing head of the list

    //inner class node representing a node in the list
    private class Node {
        int data; // ata stored in node
        Node next; //reference to next node in list

        //initialize a node w/ data
        Node(int data) {
            this.data = data; // initialize data
            this.next = null; // initialize next reference to null
        }
    }

    //append new node with data at end of list
    public void append(int data) {
        // if list is empty, creates new node and make it head node
        if (head == null) {
            head = new Node(data);
            return;
        }
        //search list to find the last node
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        //append the new node to the end of list
        current.next = new Node(data);
    }

    //method to remove node after a certain node in list
    public void removeAfter(Node node) {
        //check if certain node is null or the last node
        if (node == null || node.next == null) {
            return; //no node to remove
        }
        //remove lists next node by adjusting references
        node.next = node.next.next;
    }

    //method to create copy of the list starting from a certain node
    public LinkedListMain copy(Node node) {
        //create a new linkedlistmain object to store the copied list
        LinkedListMain newList = new LinkedListMain();
        Node current = node; // start from the certain node
        //traverse the list and append each node to the new list
        while (current != null) {
            newList.append(current.data);
            current = current.next;
        }
        return newList;
    }

    //method to remove duplicates of a certain key from the linked list
    public void removeDuplicate(Node node, int key) {
        Node current = node; // start from the certain node
        //search list and remove duplicates of the key
        while (current != null && current.next != null) {
            if (current.next.data == key) {
                current.next = current.next.next; //remove duplicate node
            } else {
                current = current.next;
            }
        }
    }

    //find the max value in the list
    public int max(Node node) {
        if (node == null) {
            return 0; //return 0 if the list is empty
        }
        int max = node.data; //initialize max with the first node's data
        //serach list to find max value
        while (node != null) {
            if (node.data > max) {
                max = node.data; //change max if greater value is found
            }
            node = node.next;
        }
        return max; //return the max value
    }

    //method to print the linked list
    public void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " "); // print data of the current node
            node = node.next;
        }
    }

    //main method to use linkedlistmain
    public static void main(String[] args) {
        // create a new instance of linkedlistmain
        LinkedListMain list = new LinkedListMain();
        // append some elements to the list
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);

        //print the original list
        System.out.println("o.g. list:");
        list.printList(list.head);

        //remove the node after the second node in the list
        Node nodeToRemoveAfter = list.head.next;
        list.removeAfter(nodeToRemoveAfter);
        System.out.println("\nlist after removing node after " + nodeToRemoveAfter.data + ":");
        list.printList(list.head);

        //create a copy of the original list
        System.out.println("\ncopy of o.g. list:");
        LinkedListMain copyList = list.copy(list.head);
        copyList.printList(copyList.head);

        //append some duplicate elements to the list
        list.append(2);
        list.append(3);
        list.append(2);
        System.out.println("\nlist with all duplicates:");
        list.printList(list.head);

        //remove duplicates of a certain key
        int keyToRemove = 2;
        list.removeDuplicate(list.head, keyToRemove);
        System.out.println("\nlist after removing " + keyToRemove + "'s duplicates:");
        list.printList(list.head);

        //find & print max value
        System.out.println("\nmax value: " + list.max(list.head));
    }
}

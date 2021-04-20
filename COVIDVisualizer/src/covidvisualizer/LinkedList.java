package covidvisualizer;

import linkedlist.SinglyLinkedList.Node;
import list.ListInterface;

public class LinkedList<T> implements ListInterface<T> {

    /**
     * This represents a node in a singly linked list. This node stores data
     * along with having a pointer to the next node in the list
     *
     * @param <D>
     *            This is the type of object that this class will store
     * @author Giri Ganta (gantagiri4)
     * @version 2021.04.19
     */
    public static class Node<D> {

        // The data element stored in the node.
        private D data;

        // The next node in the sequence.
        private Node<D> next;

        /**
         * Creates a new node with the given data
         *
         * @param d
         *            the data to put inside the node
         */
        public Node(D d) {
            data = d;
            next = null;
        }


        /**
         * Sets the node after this node
         *
         * @param n
         *            the node after this one
         */
        public void setNext(Node<D> n) {
            next = n;
        }


        /**
         * Gets the next node
         *
         * @return the next node
         */
        public Node<D> next() {
            return next;
        }


        /**
         * Gets the data in the node
         *
         * @return the data in the node
         */
        public D getData() {
            return data;
        }
    }

    // fields
    private Node<T> head;
    private int size;

    /**
     * Creates a new LinkedList Object.
     */
    public LinkedList() {
        head = null;
        size = 0;
    }


    /**
     * Adds a valid entry to the end of the list.
     */
    @Override
    public void add(T anEntry) {
        if (anEntry == null) {
            throw new IllegalArgumentException("Object cannot be added");
        }
        if (isEmpty()) {
            head = new Node<T>(anEntry);
        }

        Node<T> current = head;

        while (current.next != null) {
            current = current.next;
        }
        current.setNext(new Node<T>(anEntry));
        size++;
    }


    /**
     * Adds the object to the position in the list
     *
     * @precondition anEntry cannot be null
     * @param index
     *            where to add the object
     * @param obj
     *            the object to add
     * @throws IndexOutOfBoundsException
     *             if index is less than zero or greater than size
     * @throws IllegalArgumentException
     *             if AnEntry is null
     */
    @Override
    public void add(int index, T anEntry) {
        if (anEntry == null) {
            throw new IllegalArgumentException("Object is null");
        }

        if ((index < 0) || (index > size)) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }

        Node<T> current = head;

        if (isEmpty()) {
            head = new Node<T>(anEntry);
        }

        else {
            if (index == 0) {
                Node<T> newNode = new Node<T>(anEntry);
                newNode.setNext(head);
                head = newNode;
            }
            else {
                int currentIndex = 0;
                while (current != null) {
                    if ((currentIndex + 1) == index) {
                        Node<T> nextNext = current.next;
                        Node<T> newNode = new Node<T>(anEntry);
                        current.setNext(newNode);
                        newNode.setNext(nextNext);

                    }
                    current = current.next();
                    currentIndex++;
                }
            }
        }
        size++;

    }


    /**
     * Removes all of the elements from the list
     */
    @Override
    public void clear() {
        if (head != null) {
            head.setNext(null);
            head = null;
        }
        size = 0;

    }


    /**
     * Checks if the list contains the given object
     *
     * @param obj
     *            the object to check for
     * @return true if it contains the object
     */
    @Override
    public boolean contains(T anEntry) {
        Node<T> current = head;
        while (current != null) {
            if (anEntry.equals(current.data)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }


    @Override
    public T getEntry(int index) {
        if (isEmpty()) {
            return null;
        }
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        
        Node<T> current = head;
        if (index >= 0 && index < size) {
            return 
        }
        
    }


    @Override
    public int getLength() {
        // TODO Auto-generated method stub
        return 0;
    }


    /**
     * Checks if the list is empty or not.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    @Override
    public T remove(int arg0) {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public T replace(int arg0, T arg1) {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public Object[] toArray() {
        // TODO Auto-generated method stub
        return null;
    }

}

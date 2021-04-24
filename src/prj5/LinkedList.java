package covidvisualizer;

import list.ListInterface;

public class LinkedList<T> implements ListInterface<T> {

    /**
     * This represents a node in a singly linked list. This node stores data
     * along with having a pointer to the next node in the list
     *
     * @param <T>
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
        else {
            Node<T> current = head;

            while (current.next != null) {
                current = current.next;
            }
            current.setNext(new Node<T>(anEntry));
        }
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


    /**
     * gets the entry at the specified entry within the list.
     * 
     * @param index
     *            the spot within the list that the object is being returned
     *            from.
     * 
     * @return
     *         the object at the specified entry.
     */
    @Override
    public T getEntry(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        else {
            Node<T> current = head;
            int curr = 0;
            while (curr != index) {
                current = current.next;
                curr++;
            }
            return current.getData();
        }
    }


    /**
     * Checks if the list is empty or not.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * Removes an object from the list at the specified index.
     * 
     * @param index
     *            index that the object is being removed from.
     * 
     * @return
     *         the object that was removed.
     */
    @Override
    public T remove(int index) {
        T result = null;

        if (index >= 0 && index < size) {
            if (index == 0) {
                result = head.getData();
                head = head.next;
                size--;
            }
            else {
                Node<T> current = head;
                int curr = 0;
                while (curr + 1 != index) {
                    current = current.next;
                    curr++;
                }
                result = current.next.getData();
                current.next = current.next.next;
                size--;
            }
        }
        else {
            throw new IndexOutOfBoundsException();
        }
        return result;
    }


    /**
     * Replaces an object from the list at the specified index with the
     * specified entry.
     * 
     * @param index
     *            index that the object is being replaced from.
     * 
     * @param anEntry
     *            object that is replacing the pre-existing entry.
     * 
     * @return
     *         the object that was replaced
     */
    @Override
    public T replace(int index, T anEntry) {
        T result = null;

        if (index >= 0 && index < size) {
            if (index == 0) {
                result = head.data;
                head.data = anEntry;
            }
            else {
                Node<T> current = head;
                int curr = 0;
                while (curr != index) {
                    current = current.next;
                    curr++;
                }
                result = current.data;
                current.data = anEntry;
            }
        }
        else {
            throw new IndexOutOfBoundsException();
        }
        return result;
    }


    /**
     * Returns an array representation of the list If a list contains A, B, and
     * C, the following should be returned {A, B, C}, If a list
     * contains A, B, C, and C the following should be returned {A, B, C, C}
     * 
     * @return an array representing the list
     */
    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];

        Node<T> current = head;
        int count = 0;
        while (current != null) {
            array[count] = current.getData();
            current = current.next;
            count++;
        }

        return array;
    }


    /**
     * Returns true if both lists have the exact same contents
     * in the exact same order
     *
     * @return a boolean of whether two lists have the same contents,
     *         item per item and in the same order
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() == obj.getClass()) {
            @SuppressWarnings("unchecked")
            LinkedList<T> other = ((LinkedList<T>)obj);
            if (other.getLength() == this.getLength()) {
                Node<T> current = head;
                Node<T> otherCurrent = other.head;
                while (current != null) {
                    if (!current.getData().equals(otherCurrent.getData())) {
                        return false;
                    }
                    current = current.next();
                    otherCurrent = otherCurrent.next();
                }
                return true;
            }
        }

        return false;
    }


    /**
     * Returns a string representation of the list If a list contains A, B, and
     * C, the following should be returned "{A, B, C}" (Without the quotations)
     *
     * @return a string representing the list
     */
    @Override
    public String toString() {
        String result = "{";

        Node<T> current = head;
        while (current != null) {
            result += "" + current.data;
            current = current.next;
            if (current != null) {
                result += ", ";
            }
        }
        result += "}";
        return result;
    }


    /**
     * Gets the last time the given object is in the list
     *
     * @param obj
     *            the object to look for
     * @return the last position of it. -1 If it is not in the list
     */
    public int lastIndexOf(T anEntry) {
        int lastIndex = -1;
        Node<T> current = head;
        int currentIndex = 0;
        while (current != null) {
            if (anEntry.equals(current.data)) {
                lastIndex = currentIndex;
            }
            currentIndex++;
            current = current.next;

        }
        return lastIndex;
    }


    /**
     * Gets the length of the list.
     */
    @Override
    public int getLength() {
        return size;
    }

}

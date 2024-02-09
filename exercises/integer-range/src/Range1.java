import java.util.Iterator;

public class Range1 implements Iterable {

    private Node head;
    private int length = 0;
    int min;
    int max;
    Integer data;


    public Range1(int min, int max) {

        for (int i = min; i <= max; i++) {
           // MyIterator range1 = new Node(i);
        }
    }

    public int size() {
        return length;
    }

    /**
     * Adds an element to the end of the list
     *
     * @param data the element to add
     */
    public void add(Integer data) {

        Node node = new Node(data);
        Node iterator = head;
        while (iterator.getNext() != null) {
            iterator = iterator.getNext();
        }
        iterator.setNext(node);
        this.length++;
    }

    /**
     * Obtains an element by index
     *
     * @param index the index of the element
     * @return the element
     */
    public Object get(int index) {

        Node iterator = head;

        if (iterator.getNext() == null || size() <= index) {
            return null;
        } else {
            for (int i = 0; i <= index; i++) {
                if (i != index) {
                    iterator = iterator.getNext();
                }

            }
            return iterator.getNext().getData();
        }
    }

    /**
     * Returns the index of the element in the list
     *
     * @param data element to search for
     * @return the index of the element, or -1 if the list does not contain element
     */
    public int indexOf(Object data) {

        Node iterator = head;
        int index = 0;

        while (iterator.getNext() != null) {
            if (iterator.getNext().getData().equals(data)) {
                return index;
            }
            iterator = iterator.getNext();
            index++;
        }
        return -1;
    }

    /**
     * Removes an element from the list
     *
     * @param data the element to remove
     * @return true if element was removed
     */
    public boolean remove(Object data) {
        Node iterator = head;
        int index = 0;

        if (indexOf(data) < 0 || this.head.getNext() == null) {
            return false;
        }
        for (int i = 0; i < indexOf(data); i++) {
            if (iterator.getNext() == null) {
                return false;
            }
            iterator = iterator.getNext();
        }

        iterator.setNext((iterator.getNext().getNext()));

        System.out.println(indexOf(data));
        length--;

//        while (iterator.getNext().getData() != data){
//            iterator = iterator.getNext();
//        }
        return true;
    }

    @Override
    public Iterator iterator() {
        return new MyIterator();
    }

    private class Node {

        private Integer data;
        private Node next;

        public Node(Integer data) {
            this.data = data;
            next = null;
        }

        public Integer getData() {
            return data;
        }

        public void setData(Integer data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }


    }

}

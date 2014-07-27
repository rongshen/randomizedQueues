import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created with IntelliJ IDEA.
 * User: rshen
 * Date: 7/14/14
 * Time: 8:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class Deque<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int count;

    private class Node {
        private Item item;
        private Node next;
        private Node prev;

        public void setItem(Item value) { item = value; }

        public Item getItem() {
            return item;
        }

        public void setNext(Node value) { next = value; }

        public Node getNext() {
            return next;
        }

        public void setPrev(Node value) { prev = value; }

        public Node getPrev() {
            return prev;
        }
    }

    public Deque() {
        first = null;
        last = first;
        count = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return count;
    }

    public void addFirst(Item item) {
        if (item == null) {
            throw new NullPointerException();
        }
        if (isEmpty()) {
            first = new Node();
            first.setItem(item);
            first.setPrev(null);
            first.setNext(last);
            last = first;
        } else {
            Node newItem = new Node();
            newItem.setItem(item);
            newItem.setNext(first);
            first.setPrev(newItem);
            newItem.setPrev(null);
            first = newItem;
        }
        count++;
    }

    public void addLast(Item item) {
        if (item == null) {
            throw new NullPointerException();
        }
        if (isEmpty()) {
            last = new Node();
            last.setItem(item);
            last.setPrev(first);
            last.setNext(null);
            first = last;
        } else {
            Node newItem = new Node();
            newItem.setItem(item);
            newItem.setPrev(last);
            last.setNext(newItem);
            newItem.setNext(null);
            last = newItem;
        }
        count++;
    }

    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Node removedNode = first;
        first = first.getNext();
        if (first != null) {
            first.setPrev(null);
        } else {
            last = null;
        }
        removedNode.setNext(null);
        count--;
        return removedNode.getItem();
    }

    public Item removeLast() {
         if (isEmpty()) {
             throw new NoSuchElementException();
         }
        Node removedNode = last;
        last = last.getPrev();
        if (last != null) {
            last.setNext(null);
        } else {
            first = null;
        }
        removedNode.setPrev(null);
        count--;
        return removedNode.getItem();
    }

    @Override
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (current == null || current.getItem() == null) {
                throw new NoSuchElementException();
            }
            Item returnItem = current.getItem();
            current = current.getNext();
            return returnItem;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
//        Deque<Integer> test = new Deque<Integer>();
//        System.out.println(test.size());
//        System.out.println(test.isEmpty());
//
//        test.addFirst(3);
//
//        System.out.println(test.removeFirst());
//
//        test.addLast(5);
//
//        System.out.println(test.removeFirst());
//
//        test.addFirst(2);
//        test.addLast(4);

//        System.out.println(test.size());
//        System.out.println(test.isEmpty());
//
//        test.addFirst(2);
//        System.out.println(test.removeLast());
//
//        test.addFirst(5);
//        System.out.println(test.removeLast());
//
//        test.addFirst(1);
//        test.addFirst(2);
//        test.addFirst(3);
//        test.addFirst(4);
//        System.out.println(test.removeLast());
//        System.out.println(test.removeLast());
//        System.out.println(test.removeLast());
//        test.addFirst(5);
//        System.out.println(test.removeLast());
//        System.out.println(test.removeLast());
//        System.out.println(test.isEmpty());

//
//        test.addFirst(1);
//
//        test.addLast(5);
//
//        System.out.println(test.removeFirst());
//        System.out.println(test.removeLast());
//
//        System.out.println(test.size());
//
//        Iterator dequeIterator = test.iterator();
//        while (dequeIterator.hasNext()) {
//            System.out.println(dequeIterator.next());
//        }

    }
}

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created with IntelliJ IDEA.
 * User: rshen
 * Date: 7/14/14
 * Time: 8:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] resizeArray;
    private int count;
    private int sampleIndex;

    public RandomizedQueue() {

        count = 0;
        sampleIndex = 0;
    }

    public boolean isEmpty() {

        return resizeArray == null;
    }

    public int size() {

        return count;
    }

    public void enqueue(Item item) {
        if (item == null) {
            throw new NullPointerException();
        }
        if (isEmpty()) {
            resizeArray = (Item[]) new Object[]{item};
            count++;
            return;
        }
        if (count == resizeArray.length) {
            resizeArray = changeArraySize(resizeArray, count * 2);
        }
        resizeArray[count++] = item;
    }

    private Item[] changeArraySize(Item[] array, int newSize) {
        Item[] newArray = (Item[]) new Object[newSize];
        for (int i = 0; i < Math.min(array.length, newArray.length); i++) {
                newArray[i] = array[i];
        }
        return newArray;
    }

    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Item returnItem = sample();
        if (count == 1) {
            resizeArray = null;
            count = 0;
            return returnItem;
        }
        resizeArray[sampleIndex] = resizeArray[count - 1];
        resizeArray[count - 1] = null;
        count--;
        if (count == resizeArray.length/4) {
            resizeArray = changeArraySize(resizeArray, resizeArray.length/2);
        }
        return returnItem;
    }

    public Item sample() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        sampleIndex = StdRandom.uniform(count);
        return resizeArray[sampleIndex];
    }

    @Override
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    private class RandomizedQueueIterator implements Iterator<Item> {
        private int n = 0;
        private int[] randomizedIndex = new int[size()];

        public RandomizedQueueIterator() {
            for (int i = 0; i < size(); i++) {
                randomizedIndex[i] = i;
            }
            StdRandom.shuffle(randomizedIndex);
        }

        @Override
        public boolean hasNext() {
            return !isEmpty() && n <= (size() - 1);
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return resizeArray[randomizedIndex[n++]];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
//        RandomizedQueue<Integer> sut = new RandomizedQueue<Integer>();
//
//        System.out.println(sut.isEmpty());
//        System.out.println(sut.size());
//
//        sut.enqueue(2);
//        sut.enqueue(3);
//        sut.enqueue(4);
//        sut.enqueue(5);
//
//        sut.dequeue();
//        sut.dequeue();
//        sut.dequeue();
//        sut.dequeue();
//
//        Iterator randomizedQueueIterator = sut.iterator();
//        while (randomizedQueueIterator.hasNext()) {
//            System.out.println(randomizedQueueIterator.next());
//        }

    }
}

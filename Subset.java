/**
 * Created with IntelliJ IDEA.
 * User: rshen
 * Date: 7/15/14
 * Time: 8:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class Subset {
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        RandomizedQueue<String> test = new RandomizedQueue<String>();
        while (!StdIn.isEmpty())
        {
            test.enqueue(StdIn.readString());
        }
        if (k <= test.size() && k > 0)
        {
            for (int i = 0; i < k; i++)
                StdOut.println(test.dequeue());
        }
    }
}

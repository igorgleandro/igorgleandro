import java.util.Iterator;

public class RangeTest {
    public static void main(String[] args) {

        Range range = new Range(-5, 5);

        System.out.println("--- USING ITERATOR ---");

        Iterator it = range.iterator();

//        while (it.hasNext()) {
//
//            int i = it.next();
//
//            if (i == 1 || i == 2 || 1 == 3) {
//                it.remove();
//            }
//        }

        for (Object i : range) {
            System.out.println("Iterated: " + i);
        }
    }
}
import java.util.Iterator;

public class Range implements Iterable {
        int min;
        int max;

        public Range(int min, int max){
            this.min = min;
            this.max = max;
        }

    @Override
    public Iterator iterator() {
        return new MyIterator();
    }
}

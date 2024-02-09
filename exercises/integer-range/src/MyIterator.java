import java.util.Iterator;

public class MyIterator implements Iterator<Integer> {

    private Object node;
    private Integer integer;


    @Override
    public boolean hasNext() {
        if (next() != null) {
            return true;
        }
        return false;
    }

    @Override
    public Integer next() {

        if ( this.integer != null){
            return integer;
        }
        return null;
    }
}

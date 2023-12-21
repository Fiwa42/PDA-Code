public class SortedLinkedIntList {

    private LinkedIntListElement start;
    private LinkedIntListElement current;

    public void add(int value) {
        LinkedIntListElement elem = new LinkedIntListElement();
        elem.setValue(value);

        if (start == null || value < start.getValue()) {
            elem.setNext(start);
            start = elem;
        } else {
            LinkedIntListElement current = start;

            while (current.getNext() != null && value > current.getNext().getValue()) {
                current = current.getNext();
            }

            elem.setNext(current.getNext());
            current.setNext(elem);
        }
    }

    public void reset() {
        current = start;
    }

    public Integer getNext() {
        if(current != null) {
            int value = current.getValue();
            current = current.getNext();
            return value;
        }
        return null;
    }

    public boolean hasNext() {
        return current != null;
    }

    public int[] toArray() {
        LinkedIntListElement current = start;
        int size = 0;

        while (current != null) {
            size++;
            current = current.getNext();
        }

        int[] array = new int[size];
        current = start;
        int index = 0;

        while (current != null) {
            array[index++] = current.getValue();
            current = current.getNext();
        }
        
        return array;
    }
}

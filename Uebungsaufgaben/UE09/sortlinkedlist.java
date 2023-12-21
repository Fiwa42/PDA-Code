public class sortlinkedlist {
    private LinkedIntListElement head;
    private LinkedIntListElement current;

    public void add(int value) {
        LinkedIntListElement newNode = new LinkedIntListElement(value);

        if (head == null || value < head.getValue()) {
            newNode.setNext(head);
            head = newNode;
        } else {
            LinkedIntListElement current = head;
            while (current.getNext() != null && value > current.getNext().getValue()) {
                current = current.getNext();
            }
            newNode.setNext(current.getNext());
            current.setNext(newNode);
        }
    }

    public void reset() {
        current = head;
    }

    public Integer getNext() {
        if (current != null) {
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
        LinkedIntListElement current = head;
        int size = 0;

        // Calculate the size of the array
        while (current != null) {
            size++;
            current = current.getNext();
        }

        int[] array = new int[size];
        current = head;
        int index = 0;

        // Populate the array
        while (current != null) {
            array[index++] = current.getValue();
            current = current.getNext();
        }

        return array;
    }

    // LinkedIntListElement class (you may have this class already)
    private static class LinkedIntListElement {
        private int value;
        private LinkedIntListElement next;

        public LinkedIntListElement(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public LinkedIntListElement getNext() {
            return next;
        }

        public void setNext(LinkedIntListElement next) {
            this.next = next;
        }
    }
}

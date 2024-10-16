package timingtest;

/**
 * An SLList is a list of integers, which hides the terrible truth
 * of the nakedness within.
 */
public class SLList<Item> {
    private class IntNode {
        public Item item;
        public IntNode next;

        public IntNode(Item i, IntNode n) {
            item = i;
            next = n;
        }
    }

    /* The first item (if it exists) is at sentinel.next. */
    private IntNode sentinel;
    private IntNode tail;
    private int size;

    /**
     * Creates an empty timingtest.SLList.
     */
    public SLList() {
        sentinel = new IntNode(null, null);
        tail = sentinel;
        size = 0;
    }

    public SLList(Item x) {
        sentinel = new IntNode(null, null);
        sentinel.next = new IntNode(x, null);
        tail = sentinel.next;
        size = 1;
    }

    /**
     * Adds x to the front of the list.
     */
    public void addFirst(Item x) {
        sentinel.next = new IntNode(x, sentinel.next);
        if (tail == sentinel) {
            tail = sentinel.next;
        }
        size = size + 1;
    }

    /**
     * Returns the first item in the list.
     */
    public Item getFirst() {
        return sentinel.next.item;
    }

    /**
     * Adds x to the end of the list.
     */
    public void addLast(Item x) {
        size = size + 1;
        tail.next = new IntNode(x, null);
        tail = tail.next;
    }

    /**
     * returns last item in the list
     */
    public Item getLast() {
        return tail.item;
    }

    /**
     * Returns the size of the list.
     */
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        /* Creates a list of one integer, namely 10 */
        SLList L = new SLList();
        L.addLast(20);
        System.out.println(L.size());
    }
}

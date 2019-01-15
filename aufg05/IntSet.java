
import java.util.ArrayList;

public class IntSet {

    // region vars

    private Tree items;

    // endregion vars

    // region ctor

    public IntSet() {
        this.items = null;
    }

    public IntSet(int[] items) {
        for (int item : items) {
            this.items.insert(item);
        }
    }

    public IntSet(Tree items) {
        this.items = items;
    }

    // endregion ctor

    // region get/set

    public Tree getItems() {
        return items;
    }

    // endregion get/set

    // region methods

    public void insert(int value) {
        // siehe Tree
    }

    public boolean contains(int value) {
        return items.ueberpruefeWert(value);
    }

    public IntSet union(IntSet other) {
        if (other == null) {
            throw new NullPointerException();
        }
        Tree ausgabe = new Tree();
    // Tree to array??
        ArrayList<Integer> list = this.items.convertTreeToArray();
        int[] items = list.toArray(new int[list.size()]);
        int[] otherArray = other.getItems().convertTreeToArray();
        for (int item : items) {
            for (int value : otherArray) {
                if (item == value) {
                    ausgabe.insert(item);
                } else {
                    ausgabe.insert(item);
                    ausgabe.insert(value);
                }
            }
        }
        return new IntSet(ausgabe);
    }

    private boolean containsOnlyInts(Tree values) {

    }

    public IntSet intersection(IntSet other) {
        if (other == null) {
            throw new NullPointerException();
        }
    }

    public boolean equals(Object x) {

    }

    public String toString() {
    }

    // endregion methods
}
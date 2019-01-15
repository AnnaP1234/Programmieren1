
import java.util.ArrayList;

public class IntSet {

    // region vars

    private Tree items;

    // endregion vars

    // region ctor

    public IntSet() {
        this.items = null;
    }

    public IntSet(int[] values) {
        Tree items = new Tree();
        for (int item : values) {
            items.insert(item);
        }
        this.items = items;
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
        ArrayList<Integer> list = this.items.convertTreeToArray();
        Integer[] items = list.toArray(new Integer[list.size()]);
        list = other.getItems().convertTreeToArray();
        Integer[] otherArray = list.toArray(new Integer[list.size()]);
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
        return true;
    }

    public IntSet intersection(IntSet other) {
        if (other == null) {
            throw new NullPointerException();
        }
        Tree ausgabe = new Tree();
        ArrayList<Integer> list = this.items.convertTreeToArray();
        Integer[] items = list.toArray(new Integer[list.size()]);
        list = other.getItems().convertTreeToArray();
        Integer[] otherArray = list.toArray(new Integer[list.size()]);
        for (int item : items) {
            boolean inside = false;
            for (int value : otherArray) {
                if (item == value) {
                    inside = true;
                }
            }
            if(inside) {
                ausgabe.insert(item);
            }
        }
        for (int value : otherArray) {
            boolean inside = false;
            for (int item : items) {
                if (item == value) {
                    inside = true;
                }
            }
            if(inside) {
                ausgabe.insert(value);
            }
        }
        return new IntSet(ausgabe);
    }

    public boolean equals(Object x) {
        return true;
    }

    public String toString() {
        String ausgabe = "{";
        String trennzeichen = " ";
        ArrayList<Integer> list = this.items.convertTreeToArray();
        Integer[] items = list.toArray(new Integer[list.size()]);
        for (int item : items) {
            ausgabe = ausgabe + trennzeichen + item;
            trennzeichen = "; ";
        }
        ausgabe += " }";
        return ausgabe;

    }

    // endregion methods
}
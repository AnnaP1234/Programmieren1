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
        int[] items = this.items.convertTreeToArray.toArray();
        int[] otherArray = other.convertTreeToArray.toArray();
        for (int item : items) {
            for (int value : other) {
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
        if (containsOnlyInts(this.getItems()) || containsOnlyInts(other.getItems())) {
            throw new 
        }
    }

    public boolean equals(Object x) {

    }

    public String toString() {
        System.out.print("{");
        for 
    }

    // endregion methods
}
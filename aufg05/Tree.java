public class Tree {

    // region vars

    private int value;
    private Tree leftChild;
    private Tree rightChild;

    // endregion vars

    // region ctor

    public Tree(int pValue) {
        value = pValue;
    }

    // endregion ctor

    // region methods

    /**
     * Gibt den Wert der Wurzel wieder
     */
    public int getValue() {
        return value;
    }

    /**
     * Gibt den linken Teilbaum wieder
     */
    public Tree getLeftChild() {
        return leftChild;
    }

    /**
     * Gibt den rechten Teilbaum wieder
     */
    public Tree getRightTree() {
        return rightChild;
    }

    /**
     * Fügt einen neuen Wert in den aktuellen Baum ein
     * @param newValue Der einzufügende Wert
     */
    public void insert(int newValue) {
        
    }

    // endregion methods
}
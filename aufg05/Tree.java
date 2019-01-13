/**
*
* @author Anna Panzer 4509268 Gruppe 2A
* @author Sophie Ludewig 4955634 Gruppe 2A 
*/
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
        if (newValue < value) {
            if (leftChild == null) {
                leftChild = new Tree(newValue);
            } else {
                insert(leftChild, newValue);
            }
        }
        if (newValue >= value) {
            if (rightChild == null) {
                rightChild = new Tree(newValue);
            } else {
                insert(rightChild, newValue);
            }
        }
    }
    
    public void insert(Tree parent, int newValue) {
        if (newValue < parent.value ) {
            if (parent.leftChild == null) {
                parent.leftChild = new Tree(newValue);
            } else {
                insert(parent.leftChild, newValue);
            }
        }
        if (newValue >= parent.value ) {
            if (parent.rightChild == null) {
                parent.rightChild = new Tree(newValue);
            } else {
                insert(parent.rightChild, newValue);
            }
        }
    }
    
    public int kleinsterWert() {
       if (leftChild == null) {
            return value;
       } else {
            return kleinsterWert(leftChild);
       }
    }
    
    public int kleinsterWert(Tree parent) {
        if (parent.leftChild == null) {
            return parent.value;
        } else {
            return kleinsterWert(parent.leftChild);
        }
    }
    
    public int groessterWert() {
       if (rightChild == null) {
            return value;
       } else {
            return groessterWert(rightChild);
        }
    }
    
    public int groessterWert(Tree parent) {
       if (parent.rightChild == null) {
            return parent.value;
       } else {
            return groessterWert(parent.rightChild);
       }
    }
    
    public int hoehe() {
        int sumR = 1;
        int sumL = 1;
        if (leftChild != null) {
            sumL = hoehe(leftChild) + 1;
        }
        if (rightChild != null) {
            sumR = hoehe(rightChild) + 1;
        }
        return Math.max(sumL, sumR);
    }
    
    public int hoehe(Tree parent) {
        int sumR = 1;
        int sumL = 1;
        if (parent.leftChild != null) {
            sumL = hoehe(parent.leftChild) + 1;
        }
        if (parent.rightChild != null) {
            sumR = hoehe(parent.rightChild) + 1;
        }
        return Math.max(sumL, sumR);
    }
    
    public String wertVorhanden(int wert) {
        if (ueberpruefeWert(wert)) {
            return "ja";
        } else {
            return "nein";
        }
    }
    
    public boolean ueberpruefeWert(int wert) {
        if (wert < value) {
            if (leftChild == null) {
                return false;
            } else {
                return ueberpruefeWert(leftChild, wert);
            }
        }
        if (wert > value) {
            if (rightChild == null) {
                return false;
            } else {
                return ueberpruefeWert(rightChild, wert);
            }
        }
        if (wert == value) {
            return true;
        }
        return false;
    }
    
    public boolean ueberpruefeWert(Tree parent, int wert) {
        if (wert < parent.value) {
            if (parent.leftChild == null) {
                return false;
            } else {
                return ueberpruefeWert(parent.leftChild, wert);
            }
        }
        if (wert > parent.value) {
            if (parent.rightChild == null) {
                    return false;
            } else {
                return ueberpruefeWert(parent.rightChild, wert);
            }
        }
        if (wert == parent.value) {
            return true;
        }
        return false;
    }
    
    public String toString() {
        if (leftChild != null && rightChild != null) {
            return "(" + toString(leftChild) + ") " + value + " (" + toString(rightChild) + ")";
        }
        if (leftChild == null && rightChild != null) {
             return value + "(" + toString(rightChild) + ")";
        }
        if (leftChild != null && rightChild == null) {
             return "(" + toString(leftChild) + ")" + value;
        }
            return "" + value + "";
        
    }
    
    public String toString(Tree parent) {
        if (parent.leftChild != null && parent.rightChild != null) {
            return "(" + toString(parent.leftChild) + ") " + parent.value + " (" + toString(parent.rightChild) + ")";
        }
        if (parent.leftChild == null && parent.rightChild != null) {
             return parent.value + "(" + toString(parent.rightChild) + ")";
        }
        if (parent.leftChild != null && parent.rightChild == null) {
             return "(" + toString(parent.leftChild) + ")" + parent.value;
        }
            return "" + parent.value + "";
    }
    
    public String entarteterBaum() {
        if (ueberpruefeEntartetRechts() || ueberpruefeEntartetLinks()) {
            return "ja";
        } else {
            return "nein";
        }
    }
    
    public boolean ueberpruefeEntartetLinks() {
        if (leftChild != null && rightChild == null) {
            return ueberpruefeEntartetLinks(leftChild);
        }
        if (leftChild == null && rightChild == null) {
            return true;
        }
        return false;
    }
    
    public boolean ueberpruefeEntartetLinks(Tree parent) {
        if (parent.leftChild != null && parent.rightChild == null) {
            return ueberpruefeEntartetLinks(parent.leftChild);
        }
        if (parent.leftChild == null && parent.rightChild == null) {
            return true;
        }
        return false;
    }
    
    public boolean ueberpruefeEntartetRechts() {
        if (leftChild == null && rightChild != null) {
            return ueberpruefeEntartetRechts(rightChild);
        }
        if (leftChild == null && rightChild == null) {
            return true;
        }
        return false;
    }
    
    public boolean ueberpruefeEntartetRechts(Tree parent) {
        if (parent.leftChild == null && parent.rightChild != null) {
            return ueberpruefeEntartetRechts(parent.rightChild);
        }
        if (parent.leftChild == null && parent.rightChild == null) {
            return true;
        }
        return false;
    }
    // endregion methods
}

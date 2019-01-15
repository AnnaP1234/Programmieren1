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
                leftChild.insert(newValue);
            }
        }
        if (newValue >= value) {
            if (rightChild == null) {
                rightChild = new Tree(newValue);
            } else {
                rightChild.insert(newValue);
            }
        }
    }
    
    public int kleinsterWert() {
       if (leftChild == null) {
            return value;
       } else {
            return leftChild.kleinsterWert();
       }
    }
    
    public int groessterWert() {
       if (rightChild == null) {
            return value;
       } else {
            return rightChild.groessterWert();
        }
    }
    
    public int hoehe() {
        int sumR = 1;
        int sumL = 1;
        if (leftChild != null) {
            sumL = leftChild.hoehe() + 1;
        }
        if (rightChild != null) {
            sumR = rightChild.hoehe() + 1;
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
    
    private boolean ueberpruefeWert(int wert) {
        if (wert < value) {
            if (leftChild == null) {
                return false;
            } else {
                return leftChild.ueberpruefeWert(wert);
            }
        }
        if (wert > value) {
            if (rightChild == null) {
                return false;
            } else {
                return rightChild.ueberpruefeWert(wert);
            }
        }
        if (wert == value) {
            return true;
        }
        return false;
    }
    
    public String toString() {
        if (leftChild != null && rightChild != null) {
            return "(" + leftChild.toString() + ") " + value + " (" + rightChild.toString() + ")";
        }
        if (leftChild == null && rightChild != null) {
             return value + "(" + rightChild.toString() + ")";
        }
        if (leftChild != null && rightChild == null) {
             return "(" + leftChild.toString() + ")" + value;
        }
        return "" + value + "";
        
    }

    public List convertTreeToArray() {
        List list = Collections.synchronizedList(new ArrayList());
        if (leftChild != null && rightChild != null) {
            list.Add(leftChild.convertTreeToArray()); 
            list.Add(rightChild.convertTreeToArray());
        }
        if (leftChild == null && rightChild != null) {
            list.Add(rightChild.convertTreeToArray());
        }
        if (leftChild != null && rightChild == null) {
            list.Add(leftChild.convertTreeToArray());
        }
        return list;
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

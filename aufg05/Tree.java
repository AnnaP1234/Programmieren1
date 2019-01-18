import java.util.ArrayList;
/**
* Durch die Klasse Tree können ganze Zahlen in Form eines Binärbaums gespeichert werden und er enthält verschiedene Operationen für einen Binärbaum.
* Dazu gehören die Ausgabe des kleinsten und größten Werts, sowie die Höhe des Baums.
* Außerdem kann überprüft werden, ob ein bestimmter Wert im Baum enthalten ist.
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

    /**
     * erster Konstruktor der Klasse Tree
     * @param pValue = einzusortierende Wert
     */
    public Tree(int pValue) {
        value = pValue;
    }

    /**
     * zweiter Konstruktor der Klasse Tree
     */
    public Tree() {
        value = -1;
    }

    /**
     * dritter Konstruktor der Klasse Tree
     * @param values die in den Baum einzufügenden Werte
     */
    public Tree(int[] values) {
        for(int value : values) {
            insert(value);
        }
    }

    // endregion ctor

    // region methods

    /**
     * Gibt den Wert der Wurzel wieder
     * @return Wert der Wurzel
     */
    public int getValue() {
        return value;
    }

    /**
     * Gibt den linken Teilbaum wieder
     * @return linker Teilbaum
     */
    public Tree getLeftChild() {
        return leftChild;
    }

    /**
     * Gibt den rechten Teilbaum wieder
     * @return rechter Teilbaum
     */
    public Tree getRightTree() {
        return rightChild;
    }

    /**
     * Fügt einen neuen Wert in den aktuellen Baum ein
     * Werte die kleiner sind als Wurzel kommen in linken Teilbaum
     * Werte die größer sind als Wurzel kommen in rechten Teilbaum
     * @param newValue = einzufügende Wert
     */
    public void insert(int newValue) {
        if (this.value == -1) {
            this.value = newValue;
        } else if (newValue < value) {
            if (leftChild == null) {
                leftChild = new Tree(newValue);
            } else {
                leftChild.insert(newValue);
            }
        } else if (newValue >= value) {
            if (rightChild == null) {
                rightChild = new Tree(newValue);
            } else {
                rightChild.insert(newValue);
            }
        }
    }
    
    /**
     * Gibt den kleinsten Wert im Baum wieder, d.h. letzte Werte im linken Teilbaum
     * @return kleinster Wert
     */
    public int kleinsterWert() {
        if (leftChild == null) {
            return value;
        } else {
            return leftChild.kleinsterWert();
        }
    }
    
    /**
     * Gibt den größten Wert im Baum wieder, d.h. letzte Wert im rechten Teilbaum
     * @return größter Wert
     */
    public int groessterWert() {
        if (rightChild == null) {
            return value;
        } else {
            return rightChild.groessterWert();
        }
    }
    
    /**
     * Berechnet die Höhe des Baums, d.h. wie viele Ebenen an Teilbäumen gibt es
     * Baum nur mit Wurzel hat die Höhe 1
     * @return Höhe
     */
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
    
    /**
     * gibt wieder ob ein vorgegebener Wert im Baum enthalten ist
     * greift auf Methode ueberpruefeWert() zurück
     * @param wert = vorgegebene Wert
     * @return ja = Wert ist vorhanden
     */
    public String convertBoolean(boolean wert) {
        if (wert) {
            return "ja";
        }
        return "nein";
    }
    
    /**
     * durchsucht Baum nach einem vorgegebenen Wert
     * @param wert = vorgegebene Wert
     * @return true = Wert ist vorhanden
     */
    public boolean ueberpruefeWert(int wert) {
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
        return true;
    }
    
    /**
     * gibt den Baum auf der Konsole aus
     * Kindsknoten und Wurzel werden durch Klammern unterschieden
     * @return Baum unterschieden mit Klammern
     */
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

    /**
     * gibt den Baum als Arrayliste wieder
     * @return Arrayliste
     */
    public ArrayList<Integer> convertTreeToArray() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (leftChild != null && rightChild != null) {
            list.addAll(leftChild.convertTreeToArray()); 
            list.addAll(rightChild.convertTreeToArray());
        }
        if (leftChild == null && rightChild != null) {
            list.addAll(rightChild.convertTreeToArray());
        }
        if (leftChild != null && rightChild == null) {
            list.addAll(leftChild.convertTreeToArray());
        }
        list.add(value);
        return list;
    }
    
    /**
     * gibt wieder ob es sich um einen entarteten Baum handelt
     * @return true = entarteter Baum
     */
    public boolean ueberpruefeEntartet() {
        if (leftChild != null && rightChild == null) {
            return leftChild.ueberpruefeEntartet();
        }
        if (leftChild == null && rightChild != null) {
            return rightChild.ueberpruefeEntartet();
        }
        if (leftChild == null && rightChild == null) {
            return true;
        }
        return false;
    }
    
    /**
    * Methode für funktionales Interface 
    * Überprüft alle Elemente des Baums auf bestimmten Term
    * @param op = Interface TreeOperation
    * @return true = wenn alle Elemente dem Term entsprechen
    */
    public boolean forAll(TreeOperation op) {
        ArrayList<Integer> list = this.convertTreeToArray();
        Integer[] array = list.toArray(new Integer[list.size()]);
        for (int i = 0; i < array.length; i++) {
            if (!op.operation(array[i])) {
                return false;
            }
        }
        return true;
    }
    
    // endregion methods
}

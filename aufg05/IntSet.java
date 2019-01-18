import java.util.ArrayList;
/**
* Die Klasse IntSet enthält die Menge der ganzen Zahlen, die in den Binärbaum 
* eingefügt werden soll. Außerdem findet die Ausgabe der Operationen auf der
* Konsole statt.
* @author Anna Panzer 4509268 Gruppe 2A
* @author Sophie Ludewig 4955634 Gruppe 2A 
*/
public class IntSet {

    // region vars

    private Tree items;

    // endregion vars

    // region ctor

    /**
    * erster Konstruktor der Klasse IntSet
    * Die Menge ist leer
    */
    public IntSet() {
        this.items = null;
    }

    /**
    * zweiter Konstruktor der Klasse IntSet
    * Fügt die übergebenen Werte in den Baum, die Menge, ein
    * @param values = einzufügende Werte
    */
    public IntSet(int[] values) {
        Tree items = new Tree();
        for (int item : values) {
            items.insert(item);
        }
        this.items = items;
    }

    /**
    * dritter Konstruktor der Klasse IntSet
    * Menge wird als Baumstruktur übergeben und gesetzt
    * @param items = einzufügende Menge
    */
    public IntSet(Tree items) {
        this.items = items;
    }

    // endregion ctor

    // region get/set

    /**
    * Methode gibt den Baum wieder, der die Menge verwaltet
    * @return Der Baum der Menge
    */
    public Tree getItems() {
        return this.items;
    }

    // endregion get/set

    // region methods

    /**
    * Fügt ein Element in einen Baum ein. Diese Methode liegt in der Tree Klasse
    * @param value Der einzufügende int-Wert
    */
    public void insert(int value) {
        this.items.insert(value);
    }

    /**
    * Ermittelt, ob ein Wert in einer Menge enthalten ist.
    * @param value Der Wert, der auf sein Vorhandensein überprüft werden soll
    * @return true, wenn der Wert in der Menge enthalten ist
    */
    public boolean contains(int value) {
        return items.ueberpruefeWert(value);
    }

    /**
    * Ermittelt die Vereinigung zweier Mengen
    * Ist kein Object oder ein Object falschen Types übergeben wird eine Exception geworfen.
    * @param other Die zu schneidene Menge
    * @return IntSet Die Menge der Elemente, die in jeder der beiden Mengen liegen, ohne Dopplungen
    */
    public IntSet union(IntSet other) {
        if (other == null) {
            throw new NullPointerException();
        } else if (!(other instanceof IntSet)) {
            throw new IllegalArgumentException();
        }
        Tree ausgabe = new Tree();
        ArrayList<Integer> list = this.items.convertTreeToArray();
        Integer[] items = list.toArray(new Integer[list.size()]);
        list = other.getItems().convertTreeToArray();
        Integer[] otherArray = list.toArray(new Integer[list.size()]);
        for (int item : items) {
            for (int value : otherArray) {
                if (item == value) {
                    if (!ausgabe.ueberpruefeWert(item)) {
                        ausgabe.insert(item);
                    }
                } else {
                    if (!ausgabe.ueberpruefeWert(item)) {
                        ausgabe.insert(item);
                    }
                    if (!ausgabe.ueberpruefeWert(value)) {
                        ausgabe.insert(value);
                    }
                }
            }
        }
        return new IntSet(ausgabe);
    }

    /**
    * Ermittelt den Schnitt zweier Mengen. 
    * Ist kein Object oder ein Object falschen Types übergeben wird eine Exception geworfen.
    * @param other Die zu schneidene Menge
    * @return IntSet Die Menge der Elemente, die genau in beiden Mengen liegen
    */
    public IntSet intersection(IntSet other) {
        if (other == null) {
            throw new NullPointerException();
        } else if (!(other instanceof IntSet)) {
            throw new IllegalArgumentException();
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
            if (inside) {
                if (!ausgabe.ueberpruefeWert(item)) {
                    ausgabe.insert(item);
                }
            }
        }
        for (int value : otherArray) {
            boolean inside = false;
            for (int item : items) {
                if (item == value) {
                    inside = true;
                }
            }
            if (inside) {
                if (!ausgabe.ueberpruefeWert(value)) {
                    ausgabe.insert(value);
                }
            }
        }
        return new IntSet(ausgabe);
    }

    /**
    *  Überprüft, ob sich zwei Mengen gleichen
    * @param x Ein Objekt x, welches, falls möglich, mit der Mengen verglichen wird
    * @return true, wenn die Mengen identisch sind
    */
    public boolean equals(Object x) {
        if  (x == null) {
            return false;
        }
        if (x instanceof IntSet) {
            boolean equals = true;
            ArrayList<Integer> avalues = ((IntSet) x).getItems().convertTreeToArray();
            Integer[] values = avalues.toArray(new Integer[avalues.size()]);
            if (this.items.convertTreeToArray().size() != avalues.size()) {
                return false;
            }
            for (int value : values) {
                if (equals) {
                    equals = this.contains(value);
                }                
            }
            return equals;
        }
        return false;
    }

    /**
    * Gibt den Baum in Mengenschreibweise als String wieder
    * @return ausgabe Gibt einen String wieder, der den Baum als Menge darstellt.
    */
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

/**
* Die Klasse IntSet enthält die Menge der ganzen Zahlen, die in den Binärbaum 
* eingefügt werden soll. Außerdem findet die Ausgabe der Operationen auf der
* Konsole statt.
* @author Anna Panzer 4509268 Gruppe 2A
* @author Sophie Ludewig 4955634 Gruppe 2A 
*/
import java.util.ArrayList;

public class IntSet {

    // region vars

    private Tree items;

    // endregion vars

    // region ctor

    /**
    * erster Konstruktor der Klasse IntSet
    */
    public IntSet() {
        this.items = null;
    }

    /**
    * zweiter Konstruktor der Klasse IntSet
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
    * @param items = einzufügender Wert
    */
    public IntSet(Tree items) {
        this.items = items;
    }

    // endregion ctor

    // region get/set

    /**
    * Methode gibt einzufügende Werte wieder
    */
    public Tree getItems() {
        return items;
    }

    // endregion get/set

    // region methods

    /**
    *  
    * @param value 
    */
    public void insert(int value) {
        // siehe Tree
    }

    /**
    *  
    * @param value 
    * @return 
    */
    public boolean contains(int value) {
        return items.ueberpruefeWert(value);
    }

    /**
    *  
    * @param other 
    * @return 
    */
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
                    if(!ausgabe.ueberpruefeWert(item)) {
                        ausgabe.insert(item);
                    }
                } else {
                    if(!ausgabe.ueberpruefeWert(item)) {
                        ausgabe.insert(item);
                    }
                    if(!ausgabe.ueberpruefeWert(value)) {
                        ausgabe.insert(value);
                    }
                }
            }
        }
        return new IntSet(ausgabe);
    }

    /**
    *  
    * @param values  
    * @return 
    */
    private boolean containsOnlyInts(Tree values) {
        return true;
    }

    /**
    *  
    * @param other 
    * @return 
    */
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
                if(!ausgabe.ueberpruefeWert(item)) {
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
            if(inside) {
                if(!ausgabe.ueberpruefeWert(value)) {
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
        if(x == null) {
            return false;
        }
        if(x instanceof IntSet) {
            boolean equals = true;
            ArrayList<Integer> avalues = ((IntSet) x).getItems().convertTreeToArray();
            Integer[] values = avalues.toArray(new Integer[avalues.size()]);
            if(this.items.convertTreeToArray().size() != avalues.size()) {
                return false;
            }
            for (int value : values) {
                if(equals) {
                    equals = this.contains(value);
                }                
            }
            return equals;
        }
        return false;
    }

    /**
    * Gibt den Baum auf der Konsole wieder
    * @return Ausgabe auf Konsole
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

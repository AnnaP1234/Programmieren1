/**
* Die Klasse IntSetMain enthält die Menge der ganzen Zahlen, die in den Binärbaum 
* eingefügt werden soll. Außerdem findet die Ausgabe der Operationen auf der
* Konsole statt.
* @author Anna Panzer 4509268 Gruppe 2A
* @author Sophie Ludewig 4955634 Gruppe 2A 
*/
public class IntSetMain {
    public static void main( String[] args) {
        Tree t = new Tree(7);
        int[] numbers = {5, 3, 9, 8};
        for (int number : numbers) {
           t.insert(number);
        }
        int wert = 30;

        IntSet intSet = new IntSet(t);
        System.out.println("Ausgabe des Baums: " + intSet.getItems().toString());
        
        System.out.println(intSet.toString());

        Tree o = new Tree(10);
        int[] values = {1, 5, 3, 12, 20, 11};
        for (int value : values) {
           o.insert(value);
        }
        IntSet other = new IntSet(o);
        System.out.println(other.toString());
        System.out.println(intSet.union(other).toString());
        
        System.out.println("Ausgabe des Baums: " + intSet.union(other).getItems().toString());

        System.out.println(intSet.intersection(other).toString());
        
    }
}

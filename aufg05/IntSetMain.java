/**
* Die Klasse IntSetMain enthält die Menge der ganzen Zahlen, die in den Binärbaum 
* eingefügt werden soll. Außerdem findet die Ausgabe der Operationen auf der
* Konsole statt.
* @author Anna Panzer 4509268 Gruppe 2A
* @author Sophie Ludewig 4955634 Gruppe 2A 
*/
public class IntSetMain {
    public static void main( String[] args) {
        try {
            int[] numbers = {7, 5, 3, 9, 8};
            Tree t = new Tree(numbers);

            IntSet intSet = new IntSet(t);
            System.out.println("Ausgabe des Baums: " + intSet.getItems().toString());
            
            System.out.println(intSet.toString());

            int[] values = {10, 1, 5, 3, 12, 20, 11};
            Tree o = new Tree(values);
            
            IntSet other = new IntSet(o);
            System.out.println(other.toString());
            System.out.println("Ausgabe der Vereinigung: " + intSet.union(other).toString());
            
            System.out.println("Ausgabe des Baums der Vereinigung: " + intSet.union(other).getItems().toString());

            System.out.println("Ausgabe des Schnitts: " + intSet.intersection(other).toString());

            intSet.union(null);
        } catch(Exception e) {
            System.out.println("Es ist ein Fehler aufgetreten. " + e);
        }
        
    }
}

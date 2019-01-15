/**
*
* @author Anna Panzer 4509268 Gruppe 2A
* @author Sophie Ludewig 4955634 Gruppe 2A 
*/
public class IntSetMain {
    public static void main( String[] args) {
        Tree t = new Tree(7);
        int[] numbers = {5, 4, 3, 2};
        for (int number : numbers) {
           t.insert(number);
        }
        int wert = 30;

        IntSet intSet = new IntSet(t);
        System.out.println("Ausgabe des Baums: " + intSet.getItems().toString());
        
        System.out.println(intSet.toString());
        
    }
}

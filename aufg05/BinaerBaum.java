/**
*
* @author Anna Panzer 4509268 Gruppe 2A
* @author Sophie Ludewig 4955634 Gruppe 2A 
*/
public class BinaerBaum {
    public static void main( String[] args) {
        Tree t = new Tree(7);
        int[] numbers = {4, 15, 2, 6, 9, 19, 8};
        int wert = 30;
        
        for (int number : numbers) {
           t.insert(number);
        }

        System.out.println("Kleinster Wert: " + t.kleinsterWert());
        System.out.println("Größter Wert: " + t.groessterWert());
        System.out.println("Höhe: " + t.hoehe());
        System.out.println("Ist Wert " + wert + " vorhanden: " + t.wertVorhanden(wert));
        System.out.println("Ausgabe des Baums: " + t.toString());
        System.out.println("Entartet: " + t.entarteterBaum());
    }
}

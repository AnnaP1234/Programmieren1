/**
* Die Klasse Binarbaum enthält die Menge der ganzen Zahlen, die in den Binärbaum 
* eingefügt werden soll. Außerdem findet die Ausgabe der Operationen auf der
* Konsole statt.
* @author Anna Panzer 4509268 Gruppe 2A
* @author Sophie Ludewig 4955634 Gruppe 2A 
*/
public class BinaerBaum {
    public static void main( String[] args) {
        //Instanz der Klasse Tree
        Tree t = new Tree(7);
        //einzusortierende Werte
        int[] numbers = {4, 6, 5, 2, 1, 3, 15, 19, 11, 9, 13, 21};
        int wert = 30;
        
        for (int number : numbers) {
            t.insert(number);
        }

        //Ausgabe der Operationen
        System.out.println("Kleinster Wert: " + t.kleinsterWert());
        System.out.println("Größter Wert: " + t.groessterWert());
        System.out.println("Höhe: " + t.hoehe());
        System.out.println("Ist Wert " + wert + " vorhanden: " + t.wertVorhanden(wert));
        System.out.println("Ausgabe des Baums: " + t.toString());
        System.out.println("Entartet: " + t.entarteterBaum());
        
        boolean kleinerZwanzig = t.forAll(v -> v < 20);
        System.out.println("Alle Werte kleiner 20?: " + kleinerZwanzig);
        
        boolean groesserZehn = t.forAll(v -> v > 10);
        System.out.println("Alle Werte größer 10?: " + groesserZehn);
    }
}

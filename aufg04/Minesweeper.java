/**
* In der Klasse Minesweeper werden zunächst folgenden Größen festgelegt: Größe des Spielfelds, Anzahl der Minen im Feld 
* und Anzahl der initial aufgedeckten Felder. Danach wird eine Instanz der Klasse Spielfeld erstellt.
* Anschließend wird zum Testen das komplett aufgedeckte Spielfeld ausgegeben und das Spiel gestartet.
* @author Anna Panzer 4509268 Gruppe 2A
* @author Sophie Ludewig 4955634 Gruppe 2A 
*/
public class Minesweeper {
    public static void main( String[] args) {
        int n = 10;
        int x = 15;
        int v = 5;
        
        Spielfeld spielfeld = new Spielfeld(n, x, v);
        
        //Ausgabe des komplett aufgedeckten Spielfelds zum Testen
        spielfeld.ausgabe(true);
        
        //Spiel wird gestartet
        System.out.println("Das Spiel startet: ");
        spielfeld.spielen();
    }
}

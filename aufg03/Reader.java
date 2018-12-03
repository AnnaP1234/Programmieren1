import java.util.Scanner;

/*
* Die Klasse Reader enthält die Aufforderung die Koordinaten der Spieler in * die Konsole einzugeben und diese anschließend als Integer zu speichern
*/
public class Reader {
    //bin mir hier nicht sicher wieso static aber hat er mir beim kompilieren vorgeschlagen
    static int x;
    static int y;

    /* 
    * Konstruktur der Klasse Reader
    * Aufruf der der Methode readKoord
    */
    public Reader() {
        readKoord();
    }
    
    /* 
    * Die Methode readKoord enthält die Aufforderung die zwei Koordinaten 
    * einzugeben und anschließend beide Werte als Integer zu speichern
    */
    public void readKoord(){
     Scanner sc = new Scanner(System.in);
     System.out.println("Bitte die Koordinaten (Reihe und Spalte, jeweils 0-2) eingeben: ");
     x = sc.nextInt();
     y = sc.nextInt();
    }
}

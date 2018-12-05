import java.util.Scanner; 

public class Reader2 {

    private Scanner sc;

    /* 
    * Konstruktur der Klasse Reader
    */
    public Reader2() {
        sc = new Scanner(System.in);
    }
    
    /* 
    * Die Methode readKoord enthält die Aufforderung die zwei Koordinaten 
    * einzugeben und anschließend beide Werte als Integer zu speichern
    * Fehlend: Überprüfung Eingabetyp
    */
    public Point readKoord() {
        System.out.println("Bitte die Koordinaten (Reihe und Spalte, jeweils 0-2) eingeben: ");
        int x = sc.nextInt();
        int y = sc.nextInt();
        
        if (!isOk(x, y)) {
            System.out.println("Die Werte sollten zwischen 0 und 2 liegen.");
            return readKoord();
        }

        return new Point (x, y);
    }

    private boolean isOk(int x, int y) {
        if (x < 3 && y < 3) {
            return true;
        }
        return false;
    }
}

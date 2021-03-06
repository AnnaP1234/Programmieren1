import java.util.Scanner; 
/**
* In der Klasse Reader werden die Spieler aufgefordert ihre gewünschten Koordinaten 
* einzugeben und diese werden gespeichert.
* @author Anna Panzer 4509268 Gruppe 2A
* @author Sophie Ludewig 4955634 Gruppe 2A 
*/
public class Reader {

    private Scanner sc;

    /** 
    * Konstruktur der Klasse Reader
    */
    public Reader() {
        sc = new Scanner(System.in);
    }
    
    /** 
    * Die Methode readKoord enthält die Aufforderung die zwei Koordinaten 
    * einzugeben und anschließend beide Werte als Integer zu speichern
    * @return entweder neuer Aufruf der Klasse oder neue Instanz der Klasse Pointer
    */
    public Point readKoord() {
        System.out.println("Bitte die Koordinaten (Reihe und Spalte, jeweils 0-2) eingeben: ");
        int x = 3;
        int y = 3;
        try {
            x = sc.nextInt();
            y = sc.nextInt();
        } catch (java.util.InputMismatchException e) {
            System.out.println("Bitte Zahlenwerte eingeben.");
            sc.nextLine();
            return readKoord();
        }
        
        if (!isOk(x, y)) {
            System.out.println("Die Werte sollten zwischen 0 und 2 liegen.");
            return readKoord();
        }

        return new Point(x, y);
    }
    
    /**
    * Überprüft ob die eingegeben Werte zwischen 0-2 liegen
    * @param eingegebenen Koordinaten x und y
    * @return true wenn Werte zwischen 0-2 liegen
    */
    private boolean isOk(int x, int y) {
        if (x < 3 && y < 3) {
            return true;
        }
        return false;
    }
}

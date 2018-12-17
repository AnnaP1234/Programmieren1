import java.util.Scanner; 
/**
* In der Klasse Reader werden die Spieler aufgefordert ihre gewünschten Koordinaten 
* einzugeben und diese werden gespeichert.
* @author Anna Panzer 4509268 Gruppe 2A
* @author Sophie Ludewig 4955634 Gruppe 2A 
*/
public class Reader {
    // Fehlend: Überprüfung ob Wertebereich OK (-> Size)

    // region vars

    private Scanner sc;
    private int size;

    // endregion vars

    // region ctor

    /** 
    * Konstruktur der Klasse Reader
    */
    public Reader(int pSize) {
        sc = new Scanner(System.in);
        size = pSize;
    }

    // endregion ctor

    // region methods
    
    /** 
    * Die Methode readKoord enthält die Aufforderung die zwei Koordinaten 
    * einzugeben und anschließend beide Werte als Integer zu speichern
    * @return entweder neuer Aufruf der Klasse oder neue Instanz der Klasse Pointer
    */
    public Point readKoord() {
        System.out.println("Bitte die Koordinaten (Reihe und Spalte, jeweils 0-2) eingeben: ");
        int column = 0;
        int row = 3;
        try {
            column = parseChar(sc.next().charAt(0));
            row = sc.nextInt();
        } catch (java.util.InputMismatchException e) {
            System.out.println("Bitte Zahlenwerte eingeben.");
            sc.nextLine();
            return readKoord();
        }
        /*
        if (!isOk(column, row)) {
            System.out.println("Die Werte sollten zwischen 0 und 2 liegen.");
            return readKoord();
        }*/

        return new Point(column, row);
    }
    /**
     * Ermittelt anhand eines übergebenen Charlitterals die zugehörige Koordinate des Spielfelds
     * @param column das Charliteral, das in einen für das Spielfeld geeigneten Wert umgewandelt werden soll
     * @return ein Integerwert, der dem Spielfeld rangfe entspricht
     */
    private int parseChar(char column) {
        return ((int) column) - 65;
    }
    
    /**
    * Überprüft ob die eingegeben Werte zwischen 0-2 liegen
    * @param eingegebenen Koordinaten x und y
    * @return true wenn Werte zwischen 0-2 liegen
    */
    /*private boolean isOk(int x, int y) {
        if (x < 3 && y < 3) {
            return true;
        }
        return false;
    }*/

    // endregion methods
}

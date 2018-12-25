/**
* Klasse für die Unverminten Felder im Spielfeld
* @author Anna Panzer 4509268 Gruppe 2A
* @author Sophie Ludewig 4955634 Gruppe 2A 
*/
public class Unvermint implements IFeld {

    //region vars

    private int minenInNaehe;
    private char symbol;
    private boolean betreten;

    // endregion vars

    // region ctor

    /**
    * Konstruktor der Klasse Unvermint
    */
    public Unvermint() {
        betreten = false;
    }
    // endregion ctor

    // region methods
    
    /**
    * Setzt die Anzahl der Minen im Nähe des unverminten Felds
    * @return Anzahl der Minen in Nähe
    */
    public int getMinenInNaehe() {
        return minenInNaehe;
    }

    /**
    * Wiedergabe ob das Feld betreten wurde
    * @return symbol
    */
    public boolean getBetreten() {
        return betreten;
    }

    /**
    * Wiedergabe des Symbols des Feldes
    * @return symbol
    */
    public char getSymbol() {
        return (char) (48 + minenInNaehe);
    }

    /**
    * Feld wird entschärft
    * @return false wenn Feld entschärft wurde
    */
    public boolean entschaerfen() {
        return false;
    }

    /**
    * Feld wird aufgedeckt und betreten wird auf true gesetzt
    * @return false wenn das Feld aufgedeckt wird
    */
    public boolean aufdecken() {
        betreten = true;
        return true;
    }
    
    /**
    * Anzahl der Minen im Umfeld des unverminten Felds wird gesetzt
    * @param anzahl = Anzahl der Minen die sich in der Nähe befinden
    */
    public void setMinenInNaehe(int anzahl) {
        minenInNaehe = anzahl;
    }

    // endregion methods
}

/**
* Klasse für die Unverminten Felder im Spielfeld
* @author Anna Panzer 4509268 Gruppe 2A
* @author Sophie Ludewig 4955634 Gruppe 2A 
*/
public class Mine implements IFeld {
    // region vars

    private char symbol;
    private boolean betreten;

    // endregion vars

    // region ctor
    
    /**
    * Konstruktor der Klasse Mine
    */
    public Mine() {
        symbol = 'X';
        betreten = false;
    }

    // endregion ctor

    // region methods

    /**
    * Wiedergabe des Symbols des Feldes
    * @return symbol
    */
    public char getSymbol() {
        return symbol;
    }

    /**
    * Wiedergabe ob das Feld betreten wurde
    * @return symbol
    */
    public boolean getBetreten() {
        return betreten;
    }

    /**
    * Feld wird entschärft und Symbol des Felds wird auf 'entschärft' geändert
    * @return true wenn Feld entschärft wurde
    */
    public boolean entschaerfen() {
        symbol = '!';
        return true;
    }

    /**
    * Feld wird aufgedeckt und betreten wird auf true gesetzt
    * @return false wenn das Feld aufgedeckt wird
    */
    public boolean aufdecken() {
        betreten = true;
        return false;
    }

    // endregion methods
}

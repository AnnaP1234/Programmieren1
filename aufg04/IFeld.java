/**
* Klasse IFeld enthält das Interface für die Klassen Mine und Unvermint
* Entscheidung für Interface, weil ....
* @author Anna Panzer 4509268 Gruppe 2A
* @author Sophie Ludewig 4955634 Gruppe 2A 
*/
public interface IFeld {
    //region methods
    
    /**
    * Soll das Symbol des Felds wiedergeben
    * @return Symbol
    */
    public char getSymbol();

    /**
    * Gibt wieder ob das Feld schon betreten wurde
    * @return true = wenn Feld betreten
    */
    public boolean getBetreten();

    /**
    * Methode um das Feld zu entschärfen falls es eine Mine ist
    * @return true = wenn Feld entschärft
    */
    public boolean entschaerfen();

    /**
    * Methode um das Feld aufzudecken
    * @return true = Wenn Feld aufgedeckt
    */
    public boolean aufdecken();

    // endregion methods
}

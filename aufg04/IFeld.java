/**
* Klasse IFeld enthält das Interface für die Klassen Mine und Unvermint
* Entscheidung für Interface, weil ....
* @author Anna Panzer 4509268 Gruppe 2A
* @author Sophie Ludewig 4955634 Gruppe 2A 
*/
public interface IFeld
{
    //region methods

    public char getSymbol();

    public boolean getBetreten();

    public boolean entschaerfen();

    public boolean aufdecken();

    // endregion methods
}

public interface IFeld
{
    // Interface und zugehörige Klassen noch nicht vollständig!!!
    // region vars

    private static int column;
    private static int row;
    private char symbol;
    private boolean betreten;

    // endregion vars

    //region methods

    public char getSymbol();

    public boolean getBetreten();

    public boolean entschaerfen();

    public boolean aufdecken();

    // endregion methods
}
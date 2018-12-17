public class Mine implements IFeld
{
    // region vars

    private char column;
    private int row;
    private char symbol;
    private boolean betreten;

    // endregion vars

    // region methods

    public char getSymbol() {
        return symbol;
    }

    public boolean getBetreten() {
        return betreten;
    }

    public boolean entschaerfen()
    {
        symbol = "!";
        return true;
    }

    public boolean umdrehen()
    {
        
        return false;
    }

    // endregion methods
}
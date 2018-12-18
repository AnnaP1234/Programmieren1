public class Mine implements IFeld
{
    // region vars

    private char symbol;
    private boolean betreten;

    // endregion vars

    // region ctor

    public Mine() {
        symbol = 'X';
        betreten = false;
    }

    // endregion ctor

    // region methods

    public char getSymbol() {
        return symbol;
    }

    public boolean getBetreten() {
        return betreten;
    }

    public boolean entschaerfen()
    {
        symbol = '!';
        return true;
    }

    public boolean aufdecken()
    {
        betreten = true;
        return false;
    }

    // endregion methods
}
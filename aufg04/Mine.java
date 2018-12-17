public class Mine implements IFeld
{
    private char column;
    private int row;
    private char symbol;

    public boolean entschaerfen()
    {
        symbol = "!";
        return true;
    }

    public boolean umdrehen()
    {
        
        return false;
    }
}
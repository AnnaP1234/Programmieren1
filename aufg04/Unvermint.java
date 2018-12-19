public class Unvermint implements IFeld {

    //region vars

    private int minenInNaehe;
    private char symbol;
    private boolean betreten;

    // endregion vars

    // region ctor

    public Unvermint() {
        betreten = false;
    }
    // endregion ctor

    // region methods

    public int getMinenInNaehe() {
        return minenInNaehe;
    }

    public boolean getBetreten() {
        return betreten;
    }

    public char getSymbol() {
        return (char) (48 + minenInNaehe);
    }

    public boolean entschaerfen() {
        return true;
    }

    public boolean aufdecken() {
        betreten = true;
        return true;
    }
    public void setMinenInNaehe(int anzahl) {
        minenInNaehe = anzahl;
    }

    // endregion methods
}
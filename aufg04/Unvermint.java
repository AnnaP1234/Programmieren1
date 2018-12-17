public class Unvermint implements IFeld {

    //region vars

    private static int column;
    private static int row;
    private int minenInNaehe;
    private char symbol;
    private boolean betreten;

    // endregion vars

    // region methods

    public int getMinenInNaehe() {
        return minenInNaehe;
    }

    public boolean getBetreten() {
        return betreten;
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
public class Minesweeper {
    public static void main( String[] args) {
        int n = 10;
        int x = 15;
        int v = 5;

        Spielfeld spielfeld = new Spielfeld(n, x, v);
        spielfeld.ausgabe(true);

    }
}
/**
* In der Klasse Spielfeld verwaltet das Spielfeld und den Spielverlauf.
* @author Anna Panzer 4509268 Gruppe 2A
* @author Sophie Ludewig 4955634 Gruppe 2A 
*/
class Spielfeld {
    // Fehlend: Ausgabe (offenes Spielfeld und aktuelles Spielfeld), Spielverlaufmethode
    // Überlegung: Aufforderung nach Aktion des Spielers in Reader oder Spielfeld??
// region vars

    private IFeld[][] spielfeld;
    private Reader reader;

// endregion vars

// region ctor

    /**
    *  Eine Instanz der Spielfeldklasse wird erstellt
    */
    public Spielfeld(int n, int x, int v) {
        generiere(n, x, v);
        reader = new Reader(n);
    }

// endregion ctor

// region methods


    private void generiere(int n, int x, int v) {

        spielfeld = new IFeld[n][n];

        Point point = new Point(n-1);
        int max = (n*n)-2;
        for (int i = 0; i < max; i++ ) {
            point.addOne();
            spielfeld[point.getX()][point.getY()] = new Unvermint();
        }

        generiereMineFelder(n, x);
        generiereVisitedPoints(n, v);
        zaehleBombeninNaehe(n);
    }

    private void zaehleBombeninNaehe(int max) {
        Point point = new Point (max);
        for (int i = 0; i < max; i++) {
            Point[] points = point.getPointsArround();
            int bombenanzahl = 0;
            for(Point apoint : points) {
                if (isMine(apoint)) {
                    bombenanzahl ++;
                }
            }
            ((Unvermint) spielfeld[point.getX()][point.getY()]).setMinenInNaehe(bombenanzahl);
            point.addOne();
        }
    }

    private void generiereMineFelder(int n, int x) {
        Point point = new Point(n);
        for (int i = 0; i < x; i++) {
            do {
                point.zufallKoord();
            } while(isMine(point));
            spielfeld[point.getX()][point.getY()] = new Mine();
        }
    }

    private void generiereVisitedPoints(int n, int v) {
        Point point = new Point(n);
        for (int i = 0; i < v; i++) {
            do {
                point.zufallKoord();
            } while(isMine(point));
            spielfeld[point.getX()][point.getY()].aufdecken();
        }
    }

    public boolean isMine(Point point) {
        if (spielfeld[point.getX()][point.getY()].getSymbol() == 'X') {
            return true;
        }
        return false;
    }

    /**
    *  Die Methode spielen() organisiert den Spielablauf
    *  Ruft die entsprechenden Methoden auf und führt durch das Spiel
    *  Zu Beginn wird das leere Spielfeld ausgegeben
    *  Danach wird der erste Spieler zu einer Eingabe aufgefordert. 
    *  Anschließend wird das Spielfeld ausgegeben.
    *  Da das Spiel noch nicht in den ersten Zügen abgeschlossen werden kann, muss nicht
    *  untersucht werden, ob das Spiel beendet ist.
    *  In den nachfolgenden Zügen ist dies hingegen möglich. Das Spiel läuft nur solange bis
    *  es einen Sieger oder ein Unentschieden gibt.
    
    public void spielen() {
        aktuellesSpielfeldAusgeben();
        char x = 0;
        int y = 0;
        for (int i = 0; i < 4; i++) {
            do {
                Point point = reader.readKoord();
                x = point.getX();
                y = point.getY();
                if (!isOk(x, y)) {
                    System.out.println("Feld ist bereits belegt.");
                }
            } while (!isOk(x, y));
            aktuellesSpielfeldAusgeben();
        }
        while ( ueberpruefeSpielstand(y, x) == 0) {
            do {
                Point point = reader.readKoord();
                x = point.getX();
                y = point.getY();
                if (!isOk(x, y)) {
                    System.out.println("Feld ist bereits belegt.");
                }
            } while (!isOk(x, y));
            aktuellesSpielfeldAusgeben();
        }
        System.out.println(spielstand(ueberpruefeSpielstand(y, x)));
    }

    /**
    *  Überprüft, ob die Eingabe das Spiel durch Sieg oder Unentschieden beendet.
    *  @param x = Reihe
    *  @param y = Spalte vom Spieler eingeben
    *  @return 0=Spiel geht weiter, 1=Spiel gewonnen, 2=Unentschieden
    
    public boolean ueberpruefeSpielstand(int x, int y) {
        // nach ausführen von aktion return??
        // ist Feld eine Mine?
        return true;
    }

    /**
    *  Gibt den aktuellen Stand des Spielfelds wieder.
    
    public void aktuellesSpielfeldAusgeben() {
        String tabelle = "-------------";
        System.out.println(tabelle);

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if (spielfeld[x][y] != 0) {
                    System.out.print("| " + spielfeld[x][y] + " ");
                } else {
                    System.out.print("|   ");
                }
            }
            System.out.println("| ");
            System.out.println(tabelle);
        }
    }*/

// endregion methods
}

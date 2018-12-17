/**
* In der Klasse Spielfeld verwaltet das Spielfeld und den Spielverlauf.
* Es wird überprüft, welcher Spieler am Zug ist 
* @author Anna Panzer 4509268 Gruppe 2A
* @author Sophie Ludewig 4955634 Gruppe 2A 
*/
class Spielfeld {
    
// region vars

    private iFeld[][] spielfeld;
    private Reader reader;

// endregion vars

// region ctor

    /**
    *  Eine Instanze der Spielfeldklasse wird erstellt
    *  Da die Größe des Spielfelds festgelegt ist, wird diese konstant auf 3x3 gesetzt
    *  Zu Beginn des Spiels ist die Zuganzahl 0.
    */
    public Spielfeld(int n, int x, int v) {
        Generiere(n,x,v);
        reader = new Reader();
    }

// endregion ctor

// region methods


    private void Generiere(int n, int x, int v) {

        spielfeld = new iFeld[n][n];

        Point point = new Point(n-1);
        int max = (n*n)-2;
        for (int i = 0; i < max; i++ ) {
            point.AddOne();
            spielfeld[point.GetX()][point.GetY()] = new Feld();
        }

        GeneriereMineFelder();
        GeneriereVisitedPoints();
        ZaehleBombeninNaehe();
    }

    private void ZaehleBombeninNaehe(int max) {
        Point point = new Point (max)
        for (i < max; i++) {

            Point[] points = point.GetPointsArround();
            int bombenanzahl = 0;
            forEech(apoint in points){
                apoint == isBombe bombenanzahl++;
            }
            spielfeld[point.GetX()][point.GetY()].SetBomben(bombenanzahl);

            point.AddOne();
        }
    }

    private void GeneriereMineFelder(int x) {
        for (i < x; i++) {
            Point point = Point.Zufall();
            while(IsBombe(point)) {
                point = Point.Zufall();
            }
            spielfeld[point.x][point.y] = new Mine();
        }

    }

    private void GeneriereVisitedPoints(int v) {
        for (i < v; i++) {
            Point point = Point.Zufall();

            while(IsBombe(point)) {
                point = Point.Zufall();
            }

            spielfeld[point.x][point.y] = new VisitPoint();

        }
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
    */
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
    * Überprüft ob das gewünschte Feld schon belegt ist
    * @param x = Reihe vom Spieler eingegeben
    * @param y = Spalte vom Spieler eingegeben
    * @return wahr wenn das Feld frei ist
    */
    private boolean isOk(int x, int y) {
        if (spielfeld[x][y] == 0) {
            return true;
        }
        return false;
    }

    /**
    *  Überprüft, ob die Eingabe das Spiel durch Sieg oder Unentschieden beendet.
    *  @param x = Reihe
    *  @param y = Spalte vom Spieler eingeben
    *  @return 0=Spiel geht weiter, 1=Spiel gewonnen, 2=Unentschieden
    */
    public boolean ueberpruefeSpielstand(int x, int y) {

        // ist Feld eine Mine?
        return true;
    }

    /**
    *  Gibt den aktuellen Stand des Spielfelds als String wieder.
    */
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
    }

// endregion methods
}

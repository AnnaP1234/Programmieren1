/**
* Die Klasse Spielfeld verwaltet das Spielfeld und den Spielverlauf.
* @author Anna Panzer 4509268 Gruppe 2A
* @author Sophie Ludewig 4955634 Gruppe 2A 
*/
class Spielfeld {
// region vars

    private IFeld[][] spielfeld;
    private Reader reader;

// endregion vars

// region ctor

    /**
    * Eine Instanz der Spielfeldklasse wird erstellt
    * @param n = Größe des Spielfelds
    * @param v = Anzahl der aufgedeckten Felder
    * @param x = Anzahl der Minen
    */
    public Spielfeld(int n, int x, int v) {
        generiere(n, x, v);
        reader = new Reader(n);
    }

// endregion ctor

// region methods

    /**
    * Generiert ein Spielfeld der Größe 'n' und verteilt zufällig die gewünschte Anzahl von Minen 
    * @param n = Größe des Spielfelds
    * @param v = Anzahl der aufgedeckten Felder
    * @param x = Anzahl der Minen
    */
    private void generiere(int n, int x, int v) {

        spielfeld = new IFeld[n][n];

        Point point = new Point(n - 1);
        int max = (n * n) - 2;
        for (int i = 0; i < 10; i++ ) {
            for (int y = 0; y < 10; y++) {

                spielfeld[i][y] = new Unvermint();
                //System.out.println(spielfeld[i][y].getSymbol());
                point.addOne();
            }
        }

        generiereMineFelder(n, x);
        generiereVisitedPoints(n, v);
        zaehleMineninNaehe(n);
    }

    /**
    * Methode die die Minen in der Nähe des Felds ausgibt
    * @param max = maximale Größe des Spielfelds
    */
    private void zaehleMineninNaehe(int max) {
        Point point = new Point (max);
        int anzahl = (max * max);
        for (int i = 0; i < anzahl; i++) {
            if (! (spielfeld[point.getX()][point.getY()] instanceof Mine)) {
                Point[] points = point.getPointsArround();
                int bombenanzahl = 0;
                for(Point apoint : points) {
                    if (apoint.getX() >= 0 && apoint.getY() >= 0) {
                        if (apoint.getX() < spielfeld.length && apoint.getY() < spielfeld.length) {
                            if (isMine(apoint)) {
                                bombenanzahl ++;
                            }
                        }
                    }
                }
                ((Unvermint) spielfeld[point.getX()][point.getY()]).setMinenInNaehe(bombenanzahl);
            }
            point.addOne();
        }
    }

    /**
    * Methode die die Minen zufällig auf Spielfeld verteilt
    * @param n = Größe des Spielfelds
    * @param x = Anzahl der Minen
    */
    private void generiereMineFelder(int n, int x) {
        Point point = new Point(n);
        for (int i = 0; i < x; i++) {
            do {
                point.zufallKoord();
            } while(isMine(point));
            spielfeld[point.getX()][point.getY()] = new Mine();
        }
        //ausgabe(true);
    }
    
    /**
    * Methode die die initial aufgedeckten Felder zufällig auf Spielfeld verteilt
    * @param n = Größe des Spielfelds
    * @param v = Anzahl der aufgedeckten Felder
    */
    private void generiereVisitedPoints(int n, int v) {
        Point point = new Point(n);
        for (int i = 0; i < v; i++) {
            do {
                point.zufallKoord();
            } while(isMine(point));
            spielfeld[point.getX()][point.getY()].aufdecken();
        }
    }
    
    /**
    * Methode überprüft ob aktuelle Feld eine Mine ist
    * @param point = zu überprüfende Feld
    * @return true = Feld ist eine Mine
    */
    private boolean isMine(Point point) {
        if (spielfeld[point.getX()][point.getY()].getSymbol() == 'X') {
            return true;
        }
        return false;
    }

    /**
    * Methode die die Ausgabe des Spielfelds organisiert
    * @param testen = true wenn komplett aufgedeckte Feld ausgegeben wird
    */
    public void ausgabe(boolean testen) {
        int count = 1;
        System.out.print(" ");
        for (int i = 0; i < spielfeld.length; i++) {
            System.out.print(" | " + (char) (65 + i));
            count += 4;
        }
        System.out.print(" |\r\n");
        count += 2;
        for (int i = 0; i < count; i++) {
            System.out.print("-");
        }
        System.out.println("");

        for (int x = 0; x < spielfeld.length; x++) {
            System.out.print(x + "|");
            for (int y = 0; y < spielfeld.length; y++) {
                if (testen || ((IFeld) spielfeld[x][y]).getBetreten()) {
                    System.out.print("| " + ((IFeld) spielfeld[x][y]).getSymbol() + " ");
                } else {
                    System.out.print("|   ");
                }
            }
            System.out.print("|\r\n");
        }
        System.out.println();
    }

    /**
    *  Die Methode spielen() organisiert den Spielablauf
    *  Ruft die entsprechenden Methoden auf und führt durch das Spiel
    *  Zu Beginn wird das leere Spielfeld ausgegeben, um dann eine Eingabe vom Spieler zu fordern
    */
    public void spielen() {
        ausgabe(false);
        int spielzug = 1;
        do {
            Point point = reader.readKoord();
            int aktion = reader.readAktion();
            if (aktion == 1) {
                ((IFeld) spielfeld[point.getX()][point.getY()]).aufdecken();
                System.out.println("Das Feld wird aufgedeckt.");
                if (isMine(point)) {
                    System.out.println("Das Feld ist eine Mine! Spiel beendet.");
                    ausgabe(false);
                    break;
                }
            }
            if (aktion == 2) {
                System.out.println("Es wird versucht das Feld zu entschärfen.");
                if (isMine(point)) {
                    ((IFeld) spielfeld[point.getX()][point.getY()]).entschaerfen();
                    ((IFeld) spielfeld[point.getX()][point.getY()]).aufdecken();
                    System.out.println("Das Feld ist eine Mine und wurde entschärft.");
                }
                
            }
            ausgabe(false);
            spielzug++;
        } while (!gewonnen());
        
        if (gewonnen()) {
            System.out.println("Alle Felder aufgedeckt. Spiel gewonnen!");
        }
    }

    /**
    *  Die Methode überprüft ob alle Felder des Spielfelds bereits betreten wurden
    *  Falls ja wird das Spiel als gewonnen bezeichnet
    */
    public boolean gewonnen() {
        int laenge = spielfeld.length;
        int max = laenge * laenge;
        int counter = 0;
        for (int x = 0; x < laenge; x++) {
            for (int y = 0; y < laenge; y++) {
                if (((IFeld) spielfeld[x][y]).getBetreten()) {
                    counter++;
                }
            }
        }
        if (counter == max) {
            return true;
        }
        return false;
    }
// endregion methods
}

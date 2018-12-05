class Spielfeld {
    
// region vars

    private char[][] spielfeld;
    private int spielzug;
    private Reader2 reader;

// endregion vars

// region ctor

    /*
    *  Eine Instanze der Spielfeldklasse wird erstellt
    *  Da die Größe des Spielfelds festgelegt ist, wird diese konstant auf 3x3 gesetzt
    *  Zu Beginn des Spiels ist die Zuganzahl 0.
    */
    public Spielfeld() {
        char[][] pSpielfeld = new char[3][3];
        spielfeld = pSpielfeld;
        spielzug = 0;
        reader = new Reader2();
    }

// endregion ctor

// region methods

    /*
    *  Die Methode spielen() organisiert den Spielablauf
    *  Ruft die entsprechenden Methoden auf und führt durch das Spiel
    *  Zu Beginn wird das leere Spielfeld ausgegeben
    *  Danach wird der erste Spieler zu einer Eingabe aufgefordert. Anschließend wird das Spielfeld ausgegeben.
    *  Da das Spiel noch nicht in den ersten Zügen abgeschlossen werden kann, muss nicht untersucht werden, ob das Spiel beendet ist.
    *  In den nachfolgenden Zügen ist dies hingegen möglich. Das Spiel läuft nur solange bis es einen Sieger oder ein Unentschieden gibt.
    */

    // redundanter Code!!!!
    public void spielen() {
        aktuellesSpielfeldAusgeben();
        int x = 0;
        int y = 0;
        for (int i = 0; i < 4; i++) {
            System.out.println("Spieler " + spielerAmZug() + " ist am Zug.");
            do {
                Point point = reader.readKoord();
                x = point.getX();
                y = point.getY();
                if (!isOk(x, y)) {
                    System.out.println("Feld ist bereits belegt.");
                }
            } while (!isOk(x, y));
            spielfeld[x][y] = getSymbol();
            aktuellesSpielfeldAusgeben();
            spielzug ++;
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
            // SpielerAmZug
            spielfeld[x][y] = getSymbol();
            aktuellesSpielfeldAusgeben();
            spielzug ++;
            // Spielverlauf
        }
        spielzug --;
        System.out.println(spielstand(ueberpruefeSpielstand(y, x)));
    }

    private boolean isOk(int x, int y) {
        if (spielfeld[x][y] == 0) {
            return true;
        }
        return false;
    }

    /*
    *  Berechnet den aktuellen Spieler anhand des Spielzugs.
    *  Spieler 1 ist bei geraden Zug und Spieler 2 bei ungeradem Zug an der Reihe.
    */
    public int spielerAmZug() {
        if ( spielzug % 2 == 0) {
            return 1;
        }
        return 2;
    }

    public char getSymbol() {
        if (spielerAmZug() == 1) {
            return 'x';
        }
        return 'o';
    }

    /*
    *  Überprüft, ob die Eingabe das Spiel durch Sieg oder Unentschieden beendet.
    */
    public int ueberpruefeSpielstand(int x, int y) {
        if ( (x + y) == 2 || (x + y) == 4 || (x + y) == 0) {
            if (pruefeDiagonal()) {
                return 1;
            }
        }
        if (pruefeSpalte(x)) {
            return 1;
        }
        if (pruefeZeile(y)) {
            return 1;
        }
        if (spielzug == 9) {
            return 2;
        }
        return 0;
    }

    /*
    *  Prüft, ob das Spielfeld in der übergebenen Zeile gewonnen wurde.
    */
    public boolean pruefeZeile(int zeile) {
        if ((spielfeld[zeile][0]=='x' || spielfeld[zeile][0]=='o') && spielfeld[zeile][0]==spielfeld[zeile][1] && spielfeld[zeile][0]==spielfeld[zeile][2]) {
            return true;
        }
        return false;
    }

    /*
    *  Prüft, ob das Spielfeld in der übergebenen Spalte gewonnen wurde.
    */
    public boolean pruefeSpalte(int spalte) {
        if ((spielfeld[0][spalte]=='x' || spielfeld[0][spalte]=='o') && spielfeld[0][spalte]==spielfeld[1][spalte] && spielfeld[0][spalte]==spielfeld[2][spalte]) {
            return true;
        }
        return false;
    }

    /*
    *  Prüft, ob das Spielfeld in einer der Diagonalen gewonnen wurde.
    */
    public boolean pruefeDiagonal() {
        if ((spielfeld[0][0]=='x' || spielfeld[0][0]=='o') && spielfeld[0][0]==spielfeld[1][1] && spielfeld[0][0]==spielfeld[2][2]) {
            return true;
        }
        if ((spielfeld[0][2]=='x' || spielfeld[0][2]=='o') && spielfeld[2][0]==spielfeld[1][1] && spielfeld[0][2]==spielfeld[2][2]) {
            return true;
        }
        return false;
    }

    /*
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

    /*
    *  Wandelt eine Zahlenkodierung aus ueberpruefeSpielstand() in eine Aussage um,
    *  die verständlich ist und ausgegeben werden kann.
    */
    public String spielstand(int stand) {
        switch (stand) {
            case 1:
                return "Spieler " + spielerAmZug() + " hat gewonnen.";
                
            case 2:
                return "Unentschieden";

            default:
                return "";
        }
    }

// endregion methods
}
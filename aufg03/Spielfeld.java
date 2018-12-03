class Spielfeld {
    
// region vars

    private char[] spielfeld;
    private int spielzug;

// endregion vars

// region ctor

    /*
    *  Eine Instanze der Spielfeldklasse wird erstellt
    *  Da die Größe des Spielfelds festgelegt ist, wird diese konstant auf 9 gesetzt
    *  Zu Beginn des Spiels ist die Zuganzahl 0.
    */
    public Spielfeld() {
        char[9] pSpielfeld = new char[];
        spielfeld = pSpielfeld;
        spielzug = 0;
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
    public void spielen() {
        aktuellesSpielfeldAusgeben();
        for (int i = 0; i < 5, i++) {
            System.out.println("Spieler " + spielerAmZug() + " ist am Zug.");
            //Reader
            //Ausgabe nach Eingabe
            spielzug ++;
        }
        while ( ueberpruefeSpielstand(x, y) == 0) {
            // SpielerAmZug
            // Spielverlauf
        }
        System.out.println(spielstand());
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

    /*
    *  Überprüft, ob die Eingabe das Spiel durch Sieg oder Unentschieden beendet.
    */
    public int ueberpruefeSpielstand(int x, int y) {
        int ergebnis = 0;
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
    }

    /*
    *  Prüft, ob das Spielfeld in der übergebenen Zeile gewonnen wurde.
    */
    public boolean pruefeZeile(int zeile) {
        return true;
    }

    /*
    *  Prüft, ob das Spielfeld in der übergebenen Spalte gewonnen wurde.
    */
    public boolean pruefeSpalte(int spalte) {
        return true;
    }

    /*
    *  Prüft, ob das Spielfeld in einer der Diagonalen gewonnen wurde.
    */
    public boolean pruefeDiagonal() {
        return true;
    }

    /*
    *  Gibt den aktuellen Stand des Spielfelds auf der Konsole aus.
    */
    public String aktuellesSpielfeldAusgeben() {
        String tabelle = "----------";
        String ausgabe = tabelle + "\\n";

        for (int i = 0; i <= spielfeld.Length(); i++) {
            if (spielfeld[i] != '') {
                ausgabe += "| " + spielfeld[i];
            } else {
                ausgabe += "|  ";
            }
            if ((i % 3) == 2) {
                ausgabe += "| \\n" + tabelle;
            }
        }
        return ausgabe;
    }

    /*
    *  Wandelt eine Zahlenkodierung aus ueberpruefeSpielstand() in eine Aussage um,
    *  die verständlich ist und ausgegeben werden kann.
    */
    public String spielstand(int stand) {
        switch (stand) {
            case 1:
                return "Spieler " + spielerAmZug() + " hat gewonnen. Herzlichen Glückwunsch";
                
            case 2:
                return "Unentschieden";

            default:
                return "";
        }
    }

// endregion methods
}
class Spielfeld {
    
    char[] spielfeld; 


    public String aktuellesSpielfeldAusgeben() {
        String tabelle = "----------";
        String ausgabe = tabelle + "\\n";

        for (int i = 0; i <= spielfeld.Length(); i++) {
            if (spielfeld[i] != null) {
                ausgabe += "| " + spielfeld[i];
            } else {
                ausgabe += "|  ";
            }
            if ((i % 3) == 2) {
                ausgabe += "| \\n" + tabelle
            }
        }
        return ausgabe;
    }
}
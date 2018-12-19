/**
* Enthält die Koordinaten x und y
* @author Anna Panzer 4509268 Gruppe 2A
* @author Sophie Ludewig 4955634 Gruppe 2A 
*/
public class Point {

    // region vars

    private int x;
    private int y;
    private int max;

    // endregion vars

    // region ctor
    
    /**
    * Kostruktor der Klasse Point
    * @param übergegebenen Werte für x und y
    * @return gesetzten Werte für x und y
    */
    public Point(int pX, int pY) {
        x = pX;
        y = pY;
        max = 0;
    }


    /**
     * Konstruktor der Klasse Point
     * @param pMax Größe des Spielfeld, maximalster Wert für Koordinaten
     */
    public Point (int pMax) {
        x = 0;
        y = 0;
        max = pMax;
    }

    // endregion ctor

    // region methods
    
    /**
    * Gibt Koordinate x wieder
    * @return Koordinate x
    */
    public int getX(){
        return x;
    }

    /**
    * Gibt Koordinate y wieder
    * @return Koordinate y
    */
    public int getY(){
        return y;
    }


    public void addOne() {
        x++;
        if (x >= max && y < max) {
            x = 0;
            y++;  
        }
    }

    /**
     * Ermittelt zwei zufällige Werte für x und y, die sich in einem erlaubten Bereich befinden.
     * Dieser ist von der Größe des Spielfelds abhängig.
     */
    public void zufallKoord() {
        x = (int) (Math.random() * max);
        y = (int) (Math.random() * max);
    }

    /**
     * Ermittelt die direkten Nachbarpunkte um den aktuellen Punkt
     * @return Array mit den Nachberpunkten, 8 falls der Punkt nicht am Rand des Spielfelds liegt
     */
    public Point[] getPointsArround() {
        Point[] points = new Point[8];
		int location = 0;
        for (int i = 0; i < 3; i++) {
            if (x != 0 && (x + i - 1) < max) {
                for (int j = 0; j < 3; j++) {
                    if (i == 1 && j == 1) {
                        continue;
                    }
                    if (y != 0 && (y + i - 1) < max) {
                        Point point = new Point((x + i - 1), (y + j - 1));
						points[location] = point;
                        location ++;
                    }
                }
            }
        }
		return points;
    } 
    // endregion methods
}

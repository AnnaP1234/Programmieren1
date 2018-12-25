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
    * @param x = übergebener Wert für x
    * @param y = übergebener Wert für y
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

    /**
    * Geht eine Koordinate weiter
    */
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
     * @return Array mit den Nachbarpunkten
     */
    public Point[] getPointsArround() {
        Point[] points = new Point[8];
		int location = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                Point point = new Point((x + i), (y + j));
                points[location] = point;
                location ++;
            }
        }
		return points;
    } 
    // endregion methods
}

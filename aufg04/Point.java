/**
* Enthält die Koordinaten x und y
* @author Anna Panzer 4509268 Gruppe 2A
* @author Sophie Ludewig 4955634 Gruppe 2A 
*/
public class Point {
    private int x;
    private int y;
    private int max;
    
    /*
    * Gibt Koordinate x wieder
    * @return Koordinate x
    */
    public char getX(){
        return x;
    }
    
    public void AddOne() {
        x++;
        if (x >= max) {
            x = 0;
            y++;  
        }
    }

    //Wichtig
    public void Zufall() {
        // x, y in Max zufällig bestimmen
    }

    /*
    * Gibt Koordinate y wieder
    * @return Koordinate y
    */
    public int getY(){
        return y;
    }

    public Point[] GetPointsArround() {

    }
    
    /*
    * Kostruktur der Klasse Point
    * @param übergegebenen Werte für x und y
    * @return gesetzten Werte für x und y
    */
    public Point(int pX, int pY) {
        x = pX;
        y = pY;
    }

    public Point (int pmax) {
        x = 0;
        y = 0;
        max = pmax;
    }
}

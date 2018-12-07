/**
* Enthält die Koordinaten x und y
* @author Anna Panzer 4509268 Gruppe 2A
* @author Sophie Ludewig 4955634 Gruppe 2A 
*/
public class Point {
    private int x;
    private int y;
    
    /*
    * Gibt Koordinate x wieder
    * @return Koordinate x
    */
    public int getX(){
        return x;
    }
    
    /*
    * Gibt Koordinate y wieder
    * @return Koordinate y
    */
    public int getY(){
        return y;
    }
    
    /*
    * Kostruktur der Klasse pointer
    * @param übergegebenen Werte für x und y
    * @return gesetzten Werte für x und y
    */
    public Point(int pX, int pY) {
        x = pX;
        y = pY;
    }
}

public class Dot {
    private int x, y;

    public Dot(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void addX(int x) {
        this.x += x; 
    }
    public void addY(int y) {
        this.y += y; 
    }
    public boolean compare (Dot d) {
        if ( x == d.getX() &&
             y == d.getY()    )
             return true;
        return false;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
}

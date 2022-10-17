import java.awt.Color;
import java.awt.Graphics;

public class Avion extends Vehicle{
    private int w, h;

    public Avion(int x, int y, int speedX, int speedY, Color color, int w, int h){
        super(x, y, speedX, speedY, color);
        this.w = w;
        this.h = h;
    }
public void draw(Graphics g){
    g.setColor(this.getColor());
    g.fillOval(getDot().getX(), getDot().getY(), w, h);
    g.fillOval(getDot().getX() +(int)28, getDot().getY()+ (int)-5,10, 30);
    g.setColor(Color.black);
    g.fillOval(getDot().getX() +(int)60, getDot().getY()+ (int)-0.5,15, 10);
    g.setColor(Color.white);
    g.fillOval(getDot().getX() +(int)38, getDot().getY()+ (int)-5,8, 8);
    g.fillOval(getDot().getX() +(int)38, getDot().getY()+ (int)8,8, 8);
    g.setColor(Color.red);
    g.fillRect(getDot().getX() +(int)5, getDot().getY()+ (int)4,20, 8);
}
}
import java.awt.Color;
import java.awt.Graphics;

public class Ovni extends Vehicle{
    private int w, h;

    public Ovni(int x, int y, int speedX, int speedY, Color color, int w, int h){
        super(x, y, speedX, speedY, color);
        this.w = w;
        this.h = h;
    }
public void draw(Graphics g){
    g.setColor(this.getColor());
    g.fillOval(getDot().getX(), getDot().getY(), w, h);
    g.setColor(Color.black);
    g.fillOval(getDot().getX() +(int)30, getDot().getY()+ (int)-5,30, 10);
    g.setColor(Color.white);
    g.fillOval(getDot().getX() +(int)20, getDot().getY()+ (int)-0.5,6, 10);
    g.fillOval(getDot().getX() +(int)70, getDot().getY()+ (int)-0.5,6, 10);
}
}

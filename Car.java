import java.awt.Color;
import java.awt.Graphics;

public class Car extends Vehicle{
    private int w, h;

    public Car(int x, int y, int speedX, int speedY, Color color, int w, int h){
        super(x, y, speedX, speedY, color);
        this.w = w;
        this.h = h;
    }
    public void draw(Graphics g){
        g.setColor(this.getColor());
        g.fillOval(getDot().getX(), getDot().getY(), w+10, h);
        g.setColor(Color.black);
        g.fillOval(getDot().getX() +(int)20, getDot().getY()+ (int)-5,10, 10);
        g.fillRect ( getDot().getX(),getDot().getY(), 20, 8);
        g.setColor ( Color.RED);
        g.fillRect ( getDot().getX(),getDot().getY(), -8, 5);
        g.setColor(Color.black);
        double x1 = w, x2 = w;
        double y = h;
        x1 *= 0.1; x2 *= 0.7;
        y *= 0.8;
        g.fillOval(getDot().getX() + (int)x1, getDot().getY() + (int)y, h/2, h/2);
        g.fillOval(getDot().getX() + (int)x2, getDot().getY() + (int)y, h/2, h/2);
    }
}

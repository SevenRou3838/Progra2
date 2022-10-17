import java.awt.Color;
import java.awt.Graphics;

public class Barco extends Vehicle{
    private int w, h;

    public Barco(int x, int y, int speedX, int speedY, Color color, int w, int h){
        super(x, y, speedX, speedY, color);
        this.w = w;
        this.h = h;
    }
public void draw(Graphics g){
    g.setColor(Color.white);
    g.fillRect(getDot().getX()+40, getDot().getY()-30, 5, 40);
    g.fillRect(getDot().getX()+20, getDot().getY()-60, 70, 40);
    g.setColor(this.getColor());
    g.fillOval(getDot().getX(), getDot().getY(), w, h);
    g.fillRect(getDot().getX(), getDot().getY(), 50, 20);


}
}

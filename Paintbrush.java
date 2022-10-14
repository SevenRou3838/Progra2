import java.awt.Graphics;
import java.awt.Color;
import java.awt.Polygon;

public class Paintbrush {
    private Graphics g;
    private static final Color COLOR_BROWN = new Color(34,27,21);
    private static final Color COLOR_TRUNK_TREE = new Color(50,27,30);
    private static final Color COLOR_TREE = new Color(16,46,60);

    public Paintbrush(Graphics g){
        this.g = g;
    }
    public void drawSky() {
        g.setColor(new Color (127,233,245));
        g.fillRect(0,0, 400, 100);

        g.setColor(Color.YELLOW);
        g.fillOval(40, 40, 20, 20);
    }
    public void drawMountains() {
        Polygon triangle = new Polygon();
        triangle.addPoint(15,120);
        triangle.addPoint(100,40);
        triangle.addPoint(180,130);
        g.setColor(COLOR_BROWN);
        g.fillPolygon(triangle);
    }
    public void drawTree() {
        int start = 200;
        int top = 50;

        // draw trunk
        g.setColor(COLOR_TRUNK_TREE);
        g.fillRect(start-10, top+110, 26, 40);

        g.setColor(COLOR_TREE);
        for(int i=0; i < 5; i++ ){
            Polygon triangle = new Polygon();
            int height = 50;
            int width = 70;
            int spacing = 15;

            triangle.addPoint(start, top + (spacing * i));
            triangle.addPoint(start - (width/2), top + height + (spacing*i));
            triangle.addPoint(start + (width/2), top + height + (spacing*i));

            g.fillPolygon(triangle);
        }
    }
}

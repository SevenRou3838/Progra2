import java.awt.Graphics;
import java.awt.Color;
import java.awt.Polygon;

public class Paintbrush {
    private Graphics g;
    


    public Paintbrush(Graphics g){
        this.g = g;
    }

    public void drawSky() {
        g.setColor(new Color (127,233,245));
        g.fillRect(0,0, 400, 100);

        g.setColor(Color.YELLOW);
        g.fillOval(40, 40, 20, 20);
    }


    public void drawSun(Point p){

        g.setColor(Config.COLOR_SUN);
        g.fillOval(p.getX(), p.getY(), Config.SUN_SIZE, Config.SUN_SIZE);
    }

    public void drawMountains(int x1,int y1,int x2,int y2,int x3,int y3) {
        Polygon triangle = new Polygon();
        /* triangle.addPoint(15,120);
        triangle.addPoint(100,40);
        triangle.addPoint(180,130); */
        triangle.addPoint(x1,y1);
        triangle.addPoint(x2,y2);
        triangle.addPoint(x3,y3);
        g.setColor(Config.COLOR_BROWN);
        g.fillPolygon(triangle);
    }

    public void drawTree(int start,int top) {
        /* int start = 200;
        int top = 50; */

        // draw trunk
        g.setColor(Config.COLOR_TRUNK_TREE);
        g.fillRect(start-10, top+110, 26, 40);

        g.setColor(Config.COLOR_TREE);
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
    public void drawCar(int start ,int  top){
        g.setColor(Config.COLOR_BGA);
        g.fillOval( start - 10 , top + 80 , 150 , 40 );
            g.setColor(Config.COLOR_CIRCLE);
            g.fillOval(start+70,top+70,20,20);
            g.fillOval(start-10,top+100,40,40);
            g.fillOval(start+100,top+100,40,40);
            g.fillRect(start+100,top+70,40,20);
            g.setColor(Config.COLOR_FLAME);
            g.fillRect(start+130,top+70,40,10);
    }
}